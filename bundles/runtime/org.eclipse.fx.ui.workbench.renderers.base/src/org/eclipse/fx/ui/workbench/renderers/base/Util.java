package org.eclipse.fx.ui.workbench.renderers.base;

import java.util.Collection;
import java.util.Collections;

import org.osgi.service.event.Event;

public class Util {

	@SuppressWarnings("unchecked")
	public static <E> Collection<E> asCollection(Event event,
			String propertyName) {
		Object o = event.getProperty(propertyName);
		return o instanceof Collection<?> ? (Collection<E>) o : Collections
				.singleton((E) o);
	}

}
