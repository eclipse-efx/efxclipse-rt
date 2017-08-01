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
package org.eclipse.fx.ui.controls.media;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;

import org.eclipse.fx.core.IOUtils;
import org.eclipse.fx.core.Resource;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

/**
 * Helper to load media files from any URL
 *
 * @since 2.2.0
 */
public class MediaLoader {
	private static boolean isSupported(URL url) {
		if ("http".equals(url.getProtocol()) //$NON-NLS-1$
				|| "https".equals(url.getProtocol()) //$NON-NLS-1$
				|| "file".equals(url.getProtocol())) { //$NON-NLS-1$
			return true;
		} else if ("jar".equals(url.getProtocol())) { //$NON-NLS-1$
			try {
				if ("file".equals(new URL(url.getFile()).getProtocol())) { //$NON-NLS-1$
					return true;
				}
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	/**
	 * Create a media instance from the given source
	 *
	 * @param url
	 *            the url the media is located at
	 * @return media object created
	 */
	public static Optional<Media> createMedia(@NonNull URL url) {
		if (isSupported(url)) {
			return Optional.of(new Media(url.toExternalForm()));
		}
		Optional<URL> localURL = IOUtils.getLocalURL(url);

		if (localURL.isPresent()) {
			if (isSupported(localURL.get())) {
				return Optional.of(new Media(localURL.get().toExternalForm()));
			}
		}

		Optional<Resource<@NonNull Path>> localPath = IOUtils.getLocalPath(url, false);
		if( localPath.isPresent() ) {
			try {
				return Optional.of(new Media(localPath.get().getNativeResource().toUri().toURL().toExternalForm()));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}

		return Optional.empty();
	}

	/**
	 * Create a audio clip instance from the given source
	 *
	 * @param url
	 *            the url the media is located at
	 * @return media object created
	 */
	public static Optional<AudioClip> createAudioClip(@NonNull URL url) {
		if (isSupported(url)) {
			return Optional.of(new AudioClip(url.toExternalForm()));
		}
		Optional<URL> localURL = IOUtils.getLocalURL(url);

		if (localURL.isPresent()) {
			if (isSupported(localURL.get())) {
				return Optional.of(new AudioClip(localURL.get().toExternalForm()));
			}
		}

		Optional<Resource<@NonNull Path>> localPath = IOUtils.getLocalPath(url, false);
		if( localPath.isPresent() ) {
			try {
				return Optional.of(new AudioClip(localPath.get().getNativeResource().toUri().toURL().toExternalForm()));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}

		return Optional.empty();
	}
}
