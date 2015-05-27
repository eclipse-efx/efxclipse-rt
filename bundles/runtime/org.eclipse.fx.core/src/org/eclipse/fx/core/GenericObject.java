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

import org.eclipse.jdt.annotation.Nullable;

/**
 * Interface who allows to access attributes of objects in a generic way (eg to
 * access EMF-Objects without depending on EMF)
 * 
 * @since 2.0
 */
public interface GenericObject {
	/**
	 * @return the class of the real backing type
	 */
	public Class<?> getType();

	/**
	 * Get the the attribute handle
	 * 
	 * @param attributeName
	 *            the name of the attribute
	 * @return the attribute or <code>null</code>
	 */
	public <T> @Nullable GenericAttribute<T> getAttribute(String attributeName);

	/**
	 * @return get all attributes
	 */
	public Collection<GenericAttribute<?>> getAttributes();

	/**
	 * Check if a attribute exists
	 * 
	 * @param attributeName
	 *            the name of the attribute
	 * @return <code>true</code> if the attribute exists
	 */
	public boolean hasAttribute(String attributeName);

	/**
	 * Get the value for the attribute
	 * 
	 * @param attributeName
	 *            the name of the attribute
	 * @return the value
	 * @throws IllegalArgumentException
	 *             if the attribute does not exist
	 */
	public <V> @Nullable V get(String attributeName) throws IllegalArgumentException;

	/**
	 * Get the value for the attribute as a generic object if possible
	 * 
	 * @param attributeName
	 *            the name of the attribute
	 * @return the attribute value wrapped in a {@link GenericObject} or
	 *         <code>null</code> if the attribute value is null
	 * @throws IllegalArgumentException
	 *             if the attribute does not exist
	 * @throws IllegalStateException
	 *             if the attribute can not be adapted to a generic object
	 */
	public GenericObject getAsGenericObject(String attributeName)
			throws IllegalArgumentException, IllegalStateException;

	/**
	 * Set a new value for the attribute
	 * 
	 * @param attributeName
	 *            the name of the attribute
	 * @param value
	 *            the new value
	 * @throws IllegalArgumentException
	 *             if the attribute does not exist
	 * @throws ClassCastException
	 *             if the value is not compatible with the attribute type
	 */
	public void set(String attributeName, Object value) throws IllegalArgumentException, ClassCastException;

	/**
	 * Interface abstracting a attribute
	 * 
	 * @param <T>
	 *            the type
	 * @since 2.0
	 */
	public interface GenericAttribute<T> {
		/**
		 * @return the object owning it
		 */
		public GenericObject getOwner();

		/**
		 * @return the real backing type
		 */
		public Class<T> getType();

		/**
		 * @return the value
		 */
		public <R> @Nullable R getValue();

		/**
		 * Set a new value
		 * 
		 * @param v
		 *            the new value
		 * @throws ClassCastException
		 *             if the value is not compatible with the attribute type
		 */
		public void setValue(T v) throws ClassCastException;

	}
}
