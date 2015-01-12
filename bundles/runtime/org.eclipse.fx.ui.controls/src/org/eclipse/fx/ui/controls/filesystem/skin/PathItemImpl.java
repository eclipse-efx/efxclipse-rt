/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem.skin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Collectors;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.core.FilesystemService;
import org.eclipse.fx.core.FilesystemService.Kind;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.ui.controls.filesystem.DirItem;
import org.eclipse.fx.ui.controls.filesystem.FileItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.filesystem.RootDirItem;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Implementation of the resource item system
 */
public abstract class PathItemImpl implements ResourceItem {
	/**
	 * The path
	 */
	public final Path path;

	private ReadOnlyObjectWrapper<@NonNull LocalDateTime> lastModified;

	PathItemImpl(Path path) {
		this.path = path;
	}

	@Override
	public String getName() {
		return this.path.getFileName().toString();
	}

	@Override
	public Path getPath() {
		return this.path;
	}

	@SuppressWarnings("null")
	@Override
	public ReadOnlyObjectProperty<@NonNull LocalDateTime> lastModifiedProperty() {
		if (this.lastModified == null) {
			try {
				FileTime t = Files.getLastModifiedTime(this.path);
				this.lastModified = new ReadOnlyObjectWrapper<>(
						this,
						"lastModified", LocalDateTime.ofInstant(t.toInstant(), ZoneId.systemDefault())); //$NON-NLS-1$
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}
		return this.lastModified.getReadOnlyProperty();
	}

	@Override
	public void refresh() {
		// FIXME
	}

	/**
	 * Create a new observed path
	 *
	 * @param path
	 *            the path
	 * @return the new item
	 */
	public static @NonNull RootDirItem createObservedPath(Path path) {
		if (Files.isDirectory(path)) {
			return new RootPathItemImpl(path, true);
		}
		throw new IllegalArgumentException(
				"Given path '" + path + "' is not a directory"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Create a new path
	 *
	 * @param path
	 *            the path
	 * @return the new item
	 */
	public static @NonNull RootDirItem createPath(Path path) {
		if (Files.isDirectory(path)) {
			return new RootPathItemImpl(path, false);
		}

		throw new IllegalArgumentException("Given path '" + path //$NON-NLS-1$
				+ "' is not a directory"); //$NON-NLS-1$
	}

	static class RootPathItemImpl extends DirPathItemImpl implements
			RootDirItem {

		RootPathItemImpl(Path path, boolean observe) {
			super(path, observe);
		}

		@Override
		public void dispose() {
			super.dispose();
		}
	}

	static class DirPathItemImpl extends PathItemImpl implements DirItem {
		private ObservableList<@NonNull ResourceItem> children;
		private final boolean observe;
		private Subscription fsSubscription;

		DirPathItemImpl(Path path, boolean observe) {
			super(path);
			this.observe = observe;
		}

		@Override
		@SuppressWarnings("null")
		public ObservableList<@NonNull ResourceItem> getChildren() {
			if (this.children == null) {
				this.children = FXCollections.observableArrayList();
				try {
					this.children
							.addAll(Files
									.walk(this.path, 1)
									.filter(p -> p != this.path)
									.map(p -> Files.isDirectory(p) ? new DirPathItemImpl(
											p, this.observe)
											: new FileItemImpl(p))
									.collect(Collectors.toList()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (this.observe) {
					FilesystemService service = Util
							.lookupService(FilesystemService.class);
					if (service != null) {
						this.fsSubscription = service.observePath(this.path,
								this::handlePathModification);
					}
				}
			}
			return this.children;
		}

		private void handlePathModification(Kind k, Path p) {
			switch (k) {
			case CREATE:
				if (this.children.stream().filter(i -> i.getPath() == p)
						.findFirst().isPresent()) {
					this.children
							.add(Files.isDirectory(p) ? new DirPathItemImpl(p,
									this.observe) : new FileItemImpl(p));
				}
				break;
			case DELETE:
				this.children.removeIf(i -> i.getPath() == p);
				break;
			case MODIFY:
				this.children.stream().filter(i -> i.getPath() == p)
						.findFirst().ifPresent(i -> i.refresh());
				break;
			default:
				break;
			}
		}

		void dispose() {
			if (this.fsSubscription != null) {
				this.fsSubscription.dispose();

				if (this.children != null) {
					this.children.filtered(i -> i instanceof DirPathItemImpl)
							.forEach(i -> ((DirPathItemImpl) i).dispose());
				}
			}
		}
	}

	static class FileItemImpl extends PathItemImpl implements FileItem {
		private ReadOnlyObjectWrapper<Long> fileSize;
		private static NumberFormat BYTE_FORMAT = new DecimalFormat(
				"#,##0 'Bytes'"); //$NON-NLS-1$
		private static NumberFormat KB_FORMAT = new DecimalFormat("#,##0 'KB'"); //$NON-NLS-1$
		private static NumberFormat MB_FORMAT = new DecimalFormat(
				"#,##0.0 'MB'"); //$NON-NLS-1$

		FileItemImpl(Path path) {
			super(path);
		}

		@Override
		public String getFormattedSize() {
			if (fileSizeProperty().get().longValue() >= 1000 * 1000) {
				return MB_FORMAT.format(fileSizeProperty().get().longValue()
						/ (1024.0 * 1024));
			} else if (fileSizeProperty().get().longValue() >= 1000) {
				return KB_FORMAT
						.format(fileSizeProperty().get().longValue() / 1000.0);
			} else {
				return BYTE_FORMAT.format(fileSizeProperty().get().longValue());
			}
		}

		@Override
		public ReadOnlyObjectProperty<Long> fileSizeProperty() {
			if (this.fileSize == null) {
				try {
					this.fileSize = new ReadOnlyObjectWrapper<>(this,
							"fileSize", Long.valueOf(Files.size(this.path)));//$NON-NLS-1$
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return this.fileSize.getReadOnlyProperty();
		}
	}
}
