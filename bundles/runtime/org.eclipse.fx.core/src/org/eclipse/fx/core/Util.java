/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Class with static utility methods
 * @deprecated use specific *Util classes (see methods for references)
 */
@Deprecated
public class Util {
	/**
	 * @return <code>true</code> if we are on JavaFX 2
	 * @deprecated use {@link SystemUtils#isFX2()}
	 */
	@Deprecated
	public static boolean isFX2() {
		return SystemUtils.isFX2();
	}

	/**
	 * @return <code>true</code> if we are on JavaFX 9
	 * @since 2.2.0
	 * @deprecated use {@link SystemUtils#isFX9()}
	 */
	@Deprecated
	public static boolean isFX9() {
		return SystemUtils.isFX9();
	}

	/**
	 * @return <code>true</code> if we are on JavaFX 8
	 * @since 2.2.0
	 * @deprecated use {@link SystemUtils#isFX8()}
	 */
	@Deprecated
	public static boolean isFX8() {
		return SystemUtils.isFX8();
	}

	/**
	 * Make use the value is not null
	 *
	 * @param value
	 *            the nullable value
	 * @param defaultValue
	 *            the default if the value is null
	 * @return a nonnull string
	 * @since 2.0
	 * @deprecated use {@link TextUtil#notNull(String, String)}
	 */
	@Deprecated
	@NonNull
	public static String notNull(@Nullable String value, @NonNull String defaultValue) {
		return TextUtil.notNull(value, defaultValue);
	}

	/**
	 * @return <code>true</code> if running on OSGi
	 * @deprecated use {@link SystemUtils#isOsgiEnv()}
	 */
	@Deprecated
	public static boolean isOsgiEnv() {
		return SystemUtils.isOsgiEnv();
	}

	/**
	 * Look up the service with the given type
	 *
	 * @param requestor
	 *            the class requesting the service
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 * @deprecated use {@link ServiceUtils#getService(Class, Class)}
	 */
	@Deprecated
	public static <S> @Nullable S lookupService(@NonNull Class<?> requestor, @NonNull Class<S> serviceClass) {
		return ServiceUtils._lookupService(requestor, serviceClass);
	}

	/**
	 * Look up the service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 * @deprecated use {@link ServiceUtils#getService(Class)}
	 */
	@Deprecated
	public static <S> @Nullable S lookupService(@NonNull Class<S> serviceClass) {
		return ServiceUtils._lookupService(null,serviceClass);
	}

	/**
	 * Lookup the service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank as an optional
	 * @since 2.2.0
	 * @deprecated use {@link ServiceUtils#getService(Class)}
	 */
	@Deprecated
	public static <S> @NonNull Optional<S> getService(@NonNull Class<S> serviceClass) {
		return ServiceUtils.getService(serviceClass);
	}

	/**
	 * Look up the service with the given type
	 *
	 * @param requestor
	 *            the class requesting the service
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 2.2.0
	 * @deprecated use {@link ServiceUtils#getService(Class, Class)}
	 */
	@Deprecated
	public static <S> @NonNull Optional<S> getService(@NonNull Class<?> requestor, @NonNull Class<S> serviceClass) {
		return ServiceUtils.getService(requestor, serviceClass);
	}

	/**
	 * Look up all service with the given type
	 *
	 * @param requestor
	 *            the class requesting the service
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 * @deprecated use {@link ServiceUtils#getServiceList(Class, Class)}
	 */
	@Deprecated
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@NonNull Class<?> requestor, @NonNull Class<S> serviceClass) {
		return ServiceUtils.getServiceList(requestor, serviceClass);
	}

	/**
	 * Look up all service with the given type
	 *
	 * @param serviceClass
	 *            the service class type
	 * @return the service with the highest rank or <code>null</code>
	 * @since 1.2
	 * @deprecated use {@link ServiceUtils#getServiceList(Class)}
	 */
	@Deprecated
	public static <S> @NonNull List<@NonNull S> lookupServiceList(@NonNull Class<S> serviceClass) {
		return ServiceUtils.getServiceList(serviceClass);
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
	 * @deprecated use {@link IOUtils#slurpFileContent(Path)}
	 */
	@Deprecated
	public static String slurpFileContent(Path path) throws IOException {
		return IOUtils.slurpFileContent(path);
	}

	/**
	 * Read the input stream into a string
	 *
	 * @param in
	 *            the stream
	 * @param charset
	 *            the charset to be used
	 * @return the string
	 * @deprecated use {@link IOUtils#readToString(InputStream, Charset)}
	 */
	@Deprecated
	public static String readToString(InputStream in, Charset charset) {
		return IOUtils.readToString(in, charset);
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
	 * @deprecated use {@link IOUtils#readToString(InputStream, int, Charset)}
	 */
	@Deprecated
	public static String readToString(InputStream in, int bufferLength, Charset charset) {
		return IOUtils.readToString(in, bufferLength, charset);
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
	 * @since 2.3.0
	 * @deprecated use {@link IOUtils#copyToStream(InputStream, OutputStream)}
	 */
	@Deprecated
	public static void copyToStream(InputStream sourceStream, OutputStream targetStream) throws IOException {
		IOUtils.copyToStream(sourceStream, targetStream);
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
	 * @deprecated use {@link IOUtils#zipDirectory(Path, Path)}
	 */
	@Deprecated
	public static @NonNull Path zipDirectory(@NonNull Path dir, @Nullable Path zipFile) throws IOException {
		return IOUtils.zipDirectory(dir, zipFile);
	}

	/**
	 * @return <code>true</code> if running on OS-X
	 * @since 2.2.0
	 * @deprecated use {@link SystemUtils#isMacOS()}
	 */
	@Deprecated
	public static boolean isMacOS() {
		return SystemUtils.isMacOS();
	}

	/**
	 * @return <code>true</code> if running on windows
	 * @since 2.2.0
	 * @deprecated use {@link SystemUtils#isWindows()}
	 */
	@Deprecated
	public static boolean isWindows() {
		return SystemUtils.isWindows();
	}

	/**
	 * Constraint the given value to the upper and lower bound
	 *
	 * @param v
	 *            the value to constraint
	 * @param min
	 *            the lower bound (only values >= 0 are applied)
	 * @param max
	 *            the upper bound (only values >= 0 are applied)
	 * @return the value
	 * @since 2.2.0
	 * @deprecated use {@link NumberUtils#unsignedConstraintValue(double, double, double)}
	 */
	@Deprecated
	public static double unsignedConstraintValue(double v, double min, double max) {
		return NumberUtils.unsignedConstraintValue(v, min, max);
	}

	/**
	 * Helper method allowing to insert temporary debug information in an
	 * {@link Stream} mapping
	 *
	 * @param data
	 *            the data
	 * @return the data
	 * @since 2.2.0
	 * @deprecated use {@link StreamUtils#debugStderr(Object)}
	 */
	@Deprecated
	public static <T> T debugStderr(T data) {
		return StreamUtils.debugStderr(data);
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
	 * @deprecated use {@link IOUtils#getLocalPath(URL, boolean)}
	 */
	@Deprecated
	public static Optional<Resource<@NonNull Path>> getLocalPath(@NonNull URL url, boolean copyIfNeeded) {
		return IOUtils.getLocalPath(url, copyIfNeeded);
	}

	/**
	 * Convert an URL to a path on the local filesystem
	 *
	 * @param url
	 *            the url
	 * @return the path
	 * @since 2.2.0
	 * @deprecated use {@link IOUtils#getLocalURL(URL)}
	 */
	@Deprecated
	public static Optional<URL> getLocalURL(@NonNull URL url) {
		return IOUtils.getLocalURL(url);
	}

	/**
	 * Create a new URL instance from the provide value
	 *
	 * @param url
	 *            the url
	 * @return the url instance
	 * @throws IllegalArgumentException
	 *             if something wrong with the URL provided
	 * @since 2.3.0
	 * @deprecated use {@link URLUtils#createUrl(String)}
	 */
	@Deprecated
	public static URL createUrl(String url) {
		return URLUtils.createUrl(url);
	}

	/**
	 * Create a new URL instance who provides an optional of the creation fails
	 *
	 * @param url
	 *            the url
	 * @param log
	 *            <code>true</code> if you want the exception to be logged
	 * @return the url wrapped in an optional
	 * @since 2.4.0
	 * @deprecated use {@link URLUtils#createUrl(String, boolean)}
	 */
	@Deprecated
	public static Optional<URL> createUrl(String url, boolean log) {
		return URLUtils.createUrl(url, log);
	}

	/**
	 * Create a string of the same char
	 *
	 * @param c
	 *            the character
	 * @param length
	 *            the length
	 * @return the created string
	 * @since 2.4.0
	 * @deprecated use {@link TextUtil#createRepeatedString(char, int)}
	 */
	@Deprecated
	public static String createRepeatedString(char c, int length) {
		return TextUtil.createRepeatedString(c, length);
	}
}
