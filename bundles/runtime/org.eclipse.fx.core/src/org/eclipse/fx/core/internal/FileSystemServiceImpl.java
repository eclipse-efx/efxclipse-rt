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
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

import org.eclipse.fx.core.FilesystemService;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.URI;

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

	@Override
	public Subscription observePath(URI path, BiConsumer<Kind,Path> consumer) {
		if( this.thread == null || ! this.thread.isAlive() ) {
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
		public final Map<WatchKey, PathSubscription> subscriptions = new HashMap<>();
		private final WatchService watcher;
		private final Executor dispatcher = Executors.newCachedThreadPool();

		public CheckThread() {
			setDaemon(true);
			try {
				this.watcher = FileSystems.getDefault().newWatchService();
			} catch (IOException e) {
				throw new IllegalStateException();
			}
		}

		public Subscription registerURI(URI uri, BiConsumer<Kind,Path> consumer) throws IOException {
			try {
				Path path = Paths.get(new java.net.URI(uri.toString()));
				WatchKey register = path.register(this.watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
				PathSubscription s = new PathSubscription(this, path, register, consumer);
				synchronized (this.subscriptions) {
					this.subscriptions.put(register,s);
				}

				return s;
			} catch (URISyntaxException e) {
				throw new IOException(e);
			}
		}

		@Override
		public void run() {
			while(true) {
				WatchKey key;
	            try {
	                key = this.watcher.take();
	            } catch (InterruptedException x) {
	                return;
	            }

	            for (WatchEvent<?> event: key.pollEvents()) {
	            	@SuppressWarnings("unchecked")
					WatchEvent<Path> e = (WatchEvent<Path>) event;
	            	WatchEvent.Kind<?> kind = e.kind();
	            	if (kind == StandardWatchEventKinds.OVERFLOW) {
	                    continue;
	                }
	            	Path context = e.context();
	            	PathSubscription pathSubscription;
	            	synchronized (context) {
	            		pathSubscription = this.subscriptions.get(key);
					}

	            	if( pathSubscription != null && pathSubscription.consumer != null ) {
	            		this.dispatcher.execute((() -> pathSubscription.consumer.accept(toKind(kind), pathSubscription.path.resolve(context))));
	            	}
	            }

	            key.reset();
			}
		}

		private static Kind toKind(WatchEvent.Kind<?> kind) {
			if( kind == StandardWatchEventKinds.ENTRY_CREATE ) {
				return Kind.CREATE;
			} else if( kind == StandardWatchEventKinds.ENTRY_DELETE ) {
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
		public final BiConsumer<Kind,Path> consumer;

		public PathSubscription(CheckThread thread, Path path, WatchKey register, BiConsumer<Kind,Path> consumer) {
			this.thread = thread;
			this.path = path;
			this.register = register;
			this.consumer = consumer;
		}

		@Override
		public void dispose() {
			this.register.cancel();
			synchronized (this.thread.subscriptions) {
				this.thread.subscriptions.remove(this.register);
			}
		}
	}
}
