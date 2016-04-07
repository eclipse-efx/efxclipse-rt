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
package org.eclipse.fx.ui.workbench.renderers.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.internal.contexts.Computation;
import org.eclipse.e4.core.internal.contexts.ContextChangeEvent;
import org.eclipse.e4.core.internal.contexts.EclipseContext;
import org.eclipse.e4.core.internal.contexts.ValueComputation;
import org.eclipse.e4.core.internal.contexts.WeakGroupedListenerList;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;

/**
 * Collection of utility methods
 */
@SuppressWarnings("restriction")
public class Util {

	/**
	 * Extract a collection from an event property
	 *
	 * @param event
	 *            the event
	 * @param propertyName
	 *            the property
	 * @param <E>
	 *            the element type
	 * @return collection of elements
	 */
	@SuppressWarnings({ "unchecked", "null" })
	@NonNull
	public static <E> Collection<@NonNull E> asCollection(Event event, String propertyName) {
		Object o = event.getProperty(propertyName);
		return o instanceof Collection<?> ? (Collection<E>) o : Collections.singleton((E) o);
	}

	/**
	 * Create a CSS-ID from an id making sure it is a valid CSS ID
	 *
	 * @param id
	 *            the id
	 * @return the valid css id
	 */
	@SuppressWarnings("null")
	@NonNull
	public static String toCSSId(@NonNull String id) {
		return id.replace('.', '-');
	}

	/**
	 * Create a local handler
	 *
	 * @param parent
	 *            the parent context
	 * @param activeLeaf
	 *            the active leaf
	 * @param name
	 *            the name of the context
	 * @return a new context
	 */
	public static IEclipseContext createLocalHandlerContext(@NonNull IEclipseContext parent, @NonNull IEclipseContext activeLeaf, @NonNull String name) {
		IEclipseContext rv = EclipseContextFactory.create("HI-Item");
//		IEclipseContext rv = parent.createChild(name);
		rv.set("efx_handler_context", activeLeaf); //$NON-NLS-1$
		return rv;
	}

	/**
	 * Extract the active leaf from the current context
	 *
	 * @param context
	 *            the context
	 * @return the active leaf or <code>null</code>
	 */
	public static @Nullable IEclipseContext getActiveHandlerContext(@NonNull IEclipseContext context) {
		return (IEclipseContext) context.get("efx_handler_context"); //$NON-NLS-1$
	}

	/**
	 * Check if the context is handler context
	 *
	 * @param context
	 *            the context
	 * @return <code>true</code> if the context is local handler context (or a
	 *         child of such one)
	 */
	public static boolean isLocalHandlerContext(@NonNull IEclipseContext context) {
		return context.get("efx_handler_context") != null; //$NON-NLS-1$
	}

	/**
	 * Reparent a context
	 *
	 * @param target
	 *            the target
	 * @param newParent
	 *            the new parent
	 */
	public static void setParentContext(@NonNull IEclipseContext target, @NonNull IEclipseContext newParent) {
		target.setParent(newParent);
		// FIXME Remove this once bug 468048 has been fixed
		EclipseContext c = (EclipseContext) target;
		try {
			invalidateLocalComputations(c, new HashSet<>());
		} catch (Throwable t) {
			LoggerCreator.createLogger(Util.class).error("Failed to invalidate context", t); //$NON-NLS-1$
		}
	}

	@SuppressWarnings("unchecked")
	private static void invalidateLocalComputations(EclipseContext c, @SuppressWarnings("rawtypes") Set scheduled) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
		Field localValueComputationsField = c.getClass().getDeclaredField("localValueComputations"); //$NON-NLS-1$
		localValueComputationsField.setAccessible(true);
		Map<String, ValueComputation> localValueComputations = (Map<String, ValueComputation>) localValueComputationsField.get(c);

		Field weakListenersField = c.getClass().getDeclaredField("weakListeners"); //$NON-NLS-1$
		weakListenersField.setAccessible(true);
		WeakGroupedListenerList weakListeners = (WeakGroupedListenerList) weakListenersField.get(c);

		Constructor<?> constructor = ContextChangeEvent.class.getDeclaredConstructors()[0];
		constructor.setAccessible(true);
		ContextChangeEvent event = (ContextChangeEvent) constructor.newInstance(c, Integer.valueOf(ContextChangeEvent.ADDED), null, null, null);
		for (Computation computation : localValueComputations.values()) {
			weakListeners.remove(computation);
			computation.handleInvalid(event, scheduled);
		}
		localValueComputations.clear();

		// We need to cleanup computations recursively see bug 468048
		for (EclipseContext cc : c.getChildren()) {
			invalidateLocalComputations(cc, scheduled);
		}
	}
}