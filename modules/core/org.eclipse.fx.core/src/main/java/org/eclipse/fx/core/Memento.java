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
package org.eclipse.fx.core;

import java.util.Optional;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A simple storage API for states that need to be stored
 *
 * @since 2.0
 */
public interface Memento {
	/**
	 * Store a string value
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void put(@NonNull String key, String value);

	/**
	 * Store a boolean value
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void put(@NonNull String key, boolean value);

	/**
	 * Store an integer value
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void put(@NonNull String key, int value);

	/**
	 * Store a double value
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void put(@NonNull String key, double value);

	/**
	 * Restore an object serialized with the given serializer
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 * @param serializer
	 *            the id of the serializer
	 */
	public void put(@NonNull String key, Object value, String serializer);

	/**
	 * Remove the given key
	 *
	 * @param key
	 *            the key
	 */
	public void remove(@NonNull String key);

	/**
	 * Check if the given key exists
	 *
	 * @param key
	 *            the key
	 * @return <code>true</code> if exists else <code>false</code>
	 */
	public boolean exists(@NonNull String key);

	/**
	 * Retrieve the value for the given key
	 *
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value if the key does not exists, is <code>null</code>
	 *            or not a {@link String}
	 * @return the value or the default value provided
	 */
	public @Nullable String get(@NonNull String key, @Nullable String defaultValue);

	/**
	 * Retrieve the value for the given key
	 *
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value of the key does not exits, is <code>null</code>
	 *            or not a boolean
	 * @return the value or the default value provided
	 */
	public boolean get(@NonNull String key, boolean defaultValue);

	/**
	 * Retrieve the value for the given key
	 *
	 * @param key
	 *            the value
	 * @param defaultValue
	 *            the default value of the key does not exits, is <code>null</code>
	 *            or not an int
	 * @return the value or the default value provided
	 */
	public int get(@NonNull String key, int defaultValue);

	/**
	 * Retrieve the value for the given key
	 *
	 * @param key
	 *            the key
	 * @param defaultValue
	 *            the default value if the key does not exits, is <code>null</code>
	 *            or not a double
	 * @return the value or the default value provided
	 */
	public double get(@NonNull String key, double defaultValue);

	/**
	 * Retrieve the deserialized object
	 * 
	 * @param <O>
	 *            the object type
	 * @param key
	 *            the key
	 * @param clazz
	 *            the type
	 * @param defaultValue
	 *            the default value if the key does not exits, is <code>null</code>
	 *            or can not be deserialized
	 * @return the value or default value provided
	 */
	public <O> @Nullable O get(String key, Class<O> clazz, @Nullable O defaultValue);

	/**
	 * Retrieve the deserialized object as an optional
	 * 
	 * @param <O>
	 *            the object type
	 * @param key
	 *            the key
	 * @param clazz
	 *            the type
	 * @return the value or default value provided
	 * @since 2.2
	 */
	public default <@Nullable O> Optional<O> get(String key, Class<O> clazz) {
		O o = get(key, clazz, null);
		return Optional.ofNullable(o);
	}

	/**
	 * Get the default boolean value for the key
	 * 
	 * @param key
	 *            the key
	 * @return the default
	 * @since 3.2
	 */
	public default boolean getDefaultBoolean(String key) {
		return false;
	}

	/**
	 * Get the default integer value for the key
	 * 
	 * @param key
	 *            the key
	 * @return the value
	 * @since 3.2
	 */
	public default int getDefaultInteger(String key) {
		return 0;
	}

	/**
	 * Get the default double value for the key
	 * 
	 * @param key
	 *            the key
	 * @return the value
	 */
	public default double getDefaultDouble(String key) {
		return 0.0;
	}

	/**
	 * Get the default String value for the key
	 * 
	 * @param key
	 *            the key
	 * @return the default value
	 */
	public default String getDefaultString(String key) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * Get the default Object value for the key
	 * 
	 * @param <O> the return type
	 * 
	 * @param key
	 *            the key
	 * @param clazz
	 *            the type
	 * @return the value
	 * 
	 */
	public default <@Nullable O> O getDefault(String key, Class<O> clazz) {
		return null;
	}
}
