/*******************************************************************************
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Matthew Hall - bug 118516
 *******************************************************************************/
package org.eclipse.fx.core.databinding.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;

/**
 * This is a helper that will hook up and listen for
 * <code>PropertyChangeEvent</code> events for a set of target JavaBeans
 * 
 * @since 1.0
 */
public class FXBeanPropertyListenerSupport {
	/**
	 * Start listen to target (if it supports the JavaBean property change
	 * listener pattern)
	 * 
	 * @param bean
	 * @param propertyName
	 * @param listener
	 */
	public static void hookListener(Object bean, String propertyName,
			ChangeListener<Object> listener) {
		Assert.isNotNull(bean, "Bean cannot be null"); //$NON-NLS-1$
		Assert.isNotNull(listener, "Listener cannot be null"); //$NON-NLS-1$
		Assert.isNotNull(propertyName, "Property name cannot be null"); //$NON-NLS-1$
		processListener(bean, propertyName, listener,
				/*"addPropertyChangeListener",*/ "Could not attach listener to ");//$NON-NLS-1$
	}

	/**
	 * Stop listen to target
	 * 
	 * @param bean
	 * @param propertyName
	 * @param listener
	 */
	public static void unhookListener(Object bean, String propertyName,
			ChangeListener<Object> listener) {
		Assert.isNotNull(bean, "Bean cannot be null"); //$NON-NLS-1$
		Assert.isNotNull(listener, "Listener cannot be null"); //$NON-NLS-1$
		Assert.isNotNull(propertyName, "Property name cannot be null"); //$NON-NLS-1$

		processListener(
				bean,
				propertyName,
				listener,
				/*"removePropertyChangeListener",*/ "Cound not remove listener from "); //$NON-NLS-1$ 
	}

	/**
	 * Invokes the method for the provided <code>methodName</code> attempting to
	 * first use the method with the property name and then the unnamed version.
	 * 
	 * @param bean
	 *            object to invoke the method on
	 * @param methodName
	 *            either addPropertyChangeListener or
	 *            removePropertyChangeListener
	 * @param message
	 *            string that will be prefixed to the target in an error message
	 * 
	 * @return <code>true</code> if the method was invoked successfully
	 */
	@SuppressWarnings("unchecked")
	private static boolean processListener(Object bean, String propertyName,
			ChangeListener<Object> listener, /*String methodName,*/ String message) {
		try {
			Method method = bean.getClass().getMethod(propertyName+"Property"); //$NON-NLS-1$
			Object observable = method.invoke(bean);
			if( observable instanceof ObservableValue<?> ) {
				((ObservableValue<Object>) observable).addListener(listener);
				return true;
			} else {
				log(IStatus.WARNING, message, null);
			}

		} catch (SecurityException e) {
			// ignore
		} catch (NoSuchMethodException e) {
			log(IStatus.WARNING, message + bean, e);
		} catch (IllegalArgumentException e) {
			log(IStatus.WARNING, message + bean, e);
		} catch (IllegalAccessException e) {
			log(IStatus.WARNING, message + bean, e);
		} catch (InvocationTargetException e) {
			log(IStatus.WARNING, message + bean, e);
		}

		return false;
	}

	/**
	 * Logs a message to the Data Binding logger.
	 */
	private static void log(int severity, String message, Throwable throwable) {
		/*if (BeansObservables.DEBUG) {
			Policy.getLog().log(
					new Status(severity, Policy.JFACE_DATABINDING, IStatus.OK,
							message, throwable));
		}*/
	}
}
