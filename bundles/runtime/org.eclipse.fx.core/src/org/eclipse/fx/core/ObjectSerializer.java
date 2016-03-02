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

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Service interface used to serialize and deserialize objects
 */
public interface ObjectSerializer {
	/**
	 * Id of a default serializer based on JAXB
	 */
	public static final String JAXB_SERIALIZER = "jaxb"; //$NON-NLS-1$

	/**
	 * @return the id of the serializer
	 */
	public String getId();

	/**
	 * Serialize an object
	 *
	 * @param object
	 *            the object to serialize
	 * @return the object serialized as string
	 */
	public String serialize(Object object);

	/**
	 * Serialize a collection ({@link Set} and {@link List})
	 *
	 * @param data
	 *            the data
	 * @param contentType
	 *            the content type
	 * @return the serialized object data
	 */
	public default <O> String serializeCollection(Collection<O> data, Class<O> contentType) {
		return serialize(data);
	}

	/**
	 * Deserialize an object from a string
	 *
	 * @param clazz
	 *            the type
	 *
	 * @param value
	 *            the serialized object
	 * @return the deserialized object instance
	 */
	public <O> O deserialize(Class<O> clazz, String value);

	/**
	 * Deserialize collection content
	 *
	 * @param type
	 *            the collection type
	 * @param contentType
	 *            the content type
	 * @param value
	 *            the serialized data
	 * @return the collection
	 */
	public default <O, T extends Collection<O>> T deserializeCollection(Class<T> type, Class<O> contentType, String value) {
		return (T) deserialize(type, value);
	}
}
