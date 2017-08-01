/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.fx.core.function.ExExecutor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Utilities for IO operations
 *
 * @since 3.0
 */
public class IOUtils {
	/**
	 * Read the input stream into a string
	 *
	 * @param in
	 *            the stream
	 * @param charset
	 *            the charset to be used
	 * @return the string
	 */
	public static String readToString(InputStream in, Charset charset) {
		return readToString(in, 1024, charset);
	}

	/**
	 * Read the input stream into a string
	 *
	 * @param in
	 *            the stream
	 * @param bufferLength
	 *            the buffer length
	 * @param charset
	 *            the charset
	 * @return the string
	 */
	public static String readToString(InputStream in, int bufferLength, Charset charset) {
		StringBuilder b = new StringBuilder();
		char[] buf = new char[bufferLength];
		InputStreamReader r = new InputStreamReader(in, charset);
		int l;
		try {
			while ((l = r.read(buf, 0, bufferLength)) != -1) {
				b.append(buf, 0, l);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return b.toString();
	}

	/**
	 * Copy the complete input stream to an output stream
	 *
	 * @param sourceStream
	 *            the source stream
	 * @param targetStream
	 *            the output stream
	 * @throws IOException
	 *             if something is going wrong
	 */
	public static void copyToStream(InputStream sourceStream, OutputStream targetStream) throws IOException {
		byte[] buf = new byte[1024];
		int l;
		while ((l = sourceStream.read(buf)) != -1) {
			targetStream.write(buf, 0, l);
		}
	}

	/**
	 * Zip up a complete directory with all the sub directories
	 *
	 * @param dir
	 *            the directory to zip
	 * @param zipFile
	 *            the zip file or <code>null</code> if you want a temporary zip
	 *            file to be created
	 * @return the directory
	 * @throws IOException
	 *             if somethings going wrong
	 * @since 2.3.0
	 */
	@SuppressWarnings("null")
	public static @NonNull Path zipDirectory(@NonNull Path dir, @Nullable Path zipFile) throws IOException {
		Path target = zipFile;
		if (target == null) {
			target = Files.createTempFile("generated-zip", ".zip"); //$NON-NLS-1$//$NON-NLS-2$
		}

		try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(target))) {
			for (Path c : Files.list(dir).collect(Collectors.toList())) {
				if (!c.equals(target)) {
					addEntry(out, dir, c);
				}
			}

			out.close();
		}

		return target;
	}

	/**
	 * Read the content for the given path
	 *
	 * @param path
	 *            the path
	 * @return the content
	 * @throws IOException
	 *             if an I/O error occurs
	 * @since 2.0
	 */
	public static String slurpFileContent(Path path) throws IOException {
		byte[] buf = new byte[(int) Files.size(path)];

		try (InputStream in = Files.newInputStream(path)) {
			in.read(buf);
			return new String(buf);
		}
	}

	/**
	 * Convert an URL to a path on the local filesystem
	 *
	 * @param url
	 *            the url
	 * @param copyIfNeeded
	 *            <code>true</code> if the url can not be converted to a local
	 *            the content is copied to the local filesystem
	 * @return the path
	 * @since 2.2.0
	 */
	public static Optional<Resource<@NonNull Path>> getLocalPath(@NonNull URL url, boolean copyIfNeeded) {
		return ServiceUtils.getServiceList(URLResolver.class).stream().filter(r -> r.test(url)).findFirst().map(r -> Optional.of(Resource.createResource(r.resolveToLocalPath(url)))).orElseGet(() -> copyIfNeeded ? ExExecutor.executeSupplier(() -> copyToTempFile(url), "Unable to copy resource") //$NON-NLS-1$
				: Optional.empty());
	}

	/**
	 * Convert an URL to a path on the local filesystem
	 *
	 * @param url
	 *            the url
	 * @return the path
	 * @since 2.2.0
	 */
	public static Optional<URL> getLocalURL(@NonNull URL url) {
		return ServiceUtils.getServiceList(URLResolver.class).stream().filter(r -> r.test(url)).findFirst().map(r -> r.resolveToLocalURL(url));
	}

	private static Resource<@NonNull Path> copyToTempFile(@NonNull URL url) throws IOException {
		Path path = Files.createTempFile("tmp", Paths.get(url.getPath()).getFileName().toString()); //$NON-NLS-1$

		try (InputStream stream = url.openStream()) {
			Files.copy(stream, path);
		}

		if (path == null) {
			return null;
		}

		return Resource.createTempResource(path);
	}

	private static void addEntry(ZipOutputStream out, Path rootPath, Path p) throws IOException {
		if (Files.isDirectory(p)) {
			for (Path c : Files.list(p).collect(Collectors.toList())) {
				addEntry(out, rootPath, c);
			}
		} else {
			ZipEntry e = new ZipEntry(rootPath.relativize(p).toString());
			out.putNextEntry(e);
			try (InputStream s = Files.newInputStream(p)) {
				copyToStream(s, out);
			}
			out.closeEntry();
		}
	}
}
