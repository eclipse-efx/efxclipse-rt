package org.eclipse.fx.ui.workbench.renderers.base;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;

/**
 * Collection of utility methods
 */
public class Util {

	/**
	 * Extract a collection from an event property
	 * 
	 * @param event
	 *            the event
	 * @param propertyName
	 *            the property
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
	
	public static IEclipseContext createLocalHandlerContext(IEclipseContext parent, IEclipseContext activeLeaf, String name) {
		IEclipseContext rv = parent.createChild(name);
		rv.set("efx_handler_context", activeLeaf); //$NON-NLS-1$
		return rv;
	}
	
	public static IEclipseContext getActiveHandlerContext(IEclipseContext context) {
		return (IEclipseContext) context.get("efx_handler_context");
	}
	
	public static boolean isLocalHandlerContext(IEclipseContext context) {
		return context.get("efx_handler_context") != null; //$NON-NLS-1$
	}
}
