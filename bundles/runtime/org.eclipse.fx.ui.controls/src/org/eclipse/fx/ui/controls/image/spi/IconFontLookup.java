/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.spi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;

import javafx.scene.text.Font;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Icon look up
 */
public class IconFontLookup {

	/**
	 * Get a provider for the given font
	 * 
	 * @param font
	 *            the font
	 * @return the provider
	 */
	public static IconFontProvider getProviderForFont(Font font) {
		IconFontProvider result = null;
		try {
			Class<?> util = Class.forName("org.osgi.framework.FrameworkUtil"); //$NON-NLS-1$
			if (util != null) {
				final Method method = util.getMethod("getBundle", Class.class); //$NON-NLS-1$
				Bundle bundle = (Bundle) method.invoke(null, IconFontLookup.class);
				if (bundle != null) {
					result = getProviderForFontOSGi(bundle, font);
					return result;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		if (result == null) {
			result = getProviderForFontSPI(font);
		}

		return result;
	}

	private static IconFontProvider getProviderForFontOSGi(Bundle bundle, Font font) {
		// System.err.println("getProviderForFontOSGi " + font);
		IconFontProvider result = null;
		try {
			final BundleContext bundleContext = bundle.getBundleContext();
			final Collection<ServiceReference<IconFontProvider>> serviceReferences = bundleContext.getServiceReferences(IconFontProvider.class, null);
			for (ServiceReference<IconFontProvider> ref : serviceReferences) {
				final IconFontProvider service = bundleContext.getService(ref);
				if (service.getName().equals(font.getName())) {
					result = service;
					break;
				}
			}
			// System.err.println("getProviderForFontOSGi => " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	private static IconFontProvider getProviderForFontSPI(Font font) {
		// System.err.println("getProviderForFontSPI " + font);
		IconFontProvider result = null;

		ServiceLoader<IconFontProvider> load = ServiceLoader.<IconFontProvider> load(IconFontProvider.class);
		// System.err.println(" => " + load);
		// load.forEach((r)->System.err.println(" * > " + r));

		Iterator<IconFontProvider> it = load.iterator();
		while (it.hasNext()) {
			IconFontProvider sup = it.next();
			if (sup.getName().equals(font.getName())) {
				result = sup;
				break;
			}
		}

		// System.err.println("getProviderForFontSPI => " + result);
		return result;
	}

}
