/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.internal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

import org.eclipse.fx.core.FilesystemService;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.log.LoggerCreator;

/**
 * Implementation of a file system
 *
 * @since 1.2
 */
public class FileSystemServiceImpl implements FilesystemService {
	private CheckThread thread;

	@Override
	public boolean applies(URI path) {
		return path.toString().startsWith("file:"); //$NON-NLS-1$
	}

	@SuppressWarnings("all")
	@Override
	public Subscription observePath(URI uri, BiConsumer<Kind, URI> consumer) {
		try {
			return observePath(Paths.get(new java.net.URI(uri.toString())),
					(k, p) -> consumer.accept(k, URI.create(p.toUri().toString())));
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Subscription observePath(Path path, BiConsumer<Kind, Path> consumer) {
		if (this.thread == null || !this.thread.isAlive()) {
			this.thread = new CheckThread();
			this.thread.start();
		}
		try {
			return this.thread.registerURI(path, consumer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	static class CheckThread extends Thread {
		public final Map<WatchKey, List<PathSubscription>> subscriptions = new HashMap<>();
		private final WatchService watcher;
		private final Executor dispatcher = Executors.newCachedThreadPool();
		private final Thread shutdownCleanup;

		public CheckThread() {
			setDaemon(true);
			try {
				this.watcher = FileSystems.getDefault().newWatchService();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
			this.shutdownCleanup = new Thread(() -> {
				try {
					this.watcher.close();
				} catch (Exception e) {
					// do not care about
				}
			});
			Runtime.getRuntime().addShutdownHook(this.shutdownCleanup);
		}

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
		}

		public Subscription registerURI(Path path, BiConsumer<Kind, Path> consumer) throws IOException {
			WatchKey register = path.register(this.watcher, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

			PathSubscription s = new PathSubscription(this, path, register, consumer);
			synchronized (this.subscriptions) {
				List<PathSubscription> list = this.subscriptions.get(register);
				if (list == null) {
					list = new CopyOnWriteArrayList<>();
					this.subscriptions.put(register, list);
				}
				list.add(s);
			}

			return s;
		}

		@SuppressWarnings("null")
		@Override
		public void run() {
			while (true) {
				WatchKey key;
				try {
					key = this.watcher.take();
				} catch (Exception x) {
					LoggerCreator.createLogger(getClass()).warning("File watcher failed. Watching ended", x); //$NON-NLS-1$
					return;
				}

				for (WatchEvent<?> event : key.pollEvents()) {
					@SuppressWarnings("unchecked")
					WatchEvent<Path> e = (WatchEvent<Path>) event;
					WatchEvent.Kind<?> kind = e.kind();
					if (kind == StandardWatchEventKinds.OVERFLOW) {
						continue;
					}
					Path context = e.context();
					synchronized (this.subscriptions) {
						List<PathSubscription> pathSubscriptionList = this.subscriptions.get(key);

						if (pathSubscriptionList != null) {
							for (PathSubscription pathSubscription : pathSubscriptionList) {
								PathSubscription fp = pathSubscription;
								this.dispatcher.execute((() -> fp.consumer.accept(toKind(kind),
										fp.path.resolve(context))));
							}
						}
					}
				}

				key.reset();
			}
		}

		synchronized void removeSubscription(PathSubscription subscription) {
			synchronized (this.subscriptions) {
				List<PathSubscription> list = this.subscriptions.get(subscription.register);

				if( list != null ) {
					list.remove(subscription);
					if( list.isEmpty() ) {
						this.subscriptions.remove(subscription.register);
					}
				}

				if (this.subscriptions.isEmpty()) {
					try {
						Runtime.getRuntime().removeShutdownHook(this.shutdownCleanup);
						this.watcher.close();
					} catch (IOException e) {
						// ignore
					}
				}
			}
		}

		private static Kind toKind(WatchEvent.Kind<?> kind) {
			if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
				return Kind.CREATE;
			} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
				return Kind.DELETE;
			} else {
				return Kind.MODIFY;
			}
		}
	}

	static class PathSubscription implements Subscription {
		public final Path path;
		public final WatchKey register;
		public final CheckThread thread;
		public final BiConsumer<Kind, Path> consumer;

		public PathSubscription(CheckThread thread, Path path, WatchKey register, BiConsumer<Kind, Path> consumer) {
			this.thread = thread;
			this.path = path;
			this.register = register;
			this.consumer = consumer;
		}

		@Override
		public void dispose() {
			this.register.cancel();
			this.thread.removeSubscription(this);
		}
	}
}
