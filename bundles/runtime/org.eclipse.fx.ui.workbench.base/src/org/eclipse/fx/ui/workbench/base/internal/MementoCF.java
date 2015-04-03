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
package org.eclipse.fx.ui.workbench.base.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.fx.core.Memento;

/**
 * Context function creating a memento instance backed by the {@link MApplicationElement}
 */
public class MementoCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		MApplicationElement mApplicationElement = context.get(MApplicationElement.class);
		if( mApplicationElement == null ) {
			return null;
		} else {
			return new MementoImpl(mApplicationElement.getPersistedState());
		}
	}
	
	static class MementoImpl implements Memento {
		private final Map<String, String> map;
		private static final String TYPE_PREFIX = "__type_"; //$NON-NLS-1$
		
		public MementoImpl(Map<String, String> map) {
			this.map = map;
		}
		
		private void _put(String key, Object value, String type) {
			this.map.put(key, value == null ? null : value.toString());
			this.map.put(TYPE_PREFIX + key, type);
		}
		
		public String _get(String key, String defaultValue, String type) {
			String rv = defaultValue;
			if(type.equals(this.map.get(TYPE_PREFIX+key))) {
				rv = this.map.get(key);
				if( rv == null ) {
					rv = defaultValue;
				}
			}
			return rv;
		}
		
		@Override
		public void put(String key, String value) {
			_put(key, value, String.class.getName());
		}

		@Override
		public void put(String key, boolean value) {
			_put(key, Boolean.valueOf(value), boolean.class.getName());
		}

		@Override
		public void put(String key, int value) {
			_put(key, Integer.valueOf(value), int.class.getName());
		}

		@Override
		public void put(String key, double value) {
			_put(key, Double.valueOf(value), double.class.getName());
		}

		@Override
		public void remove(String key) {
			this.map.remove(key);
			this.map.remove(TYPE_PREFIX+key);
		}

		@Override
		public boolean exists(String key) {
			return this.map.containsKey(key);
		}

		@Override
		public String get(String key, String defaultValue) {
			return _get(key, defaultValue, String.class.getName());
		}

		@Override
		public boolean get(String key, boolean defaultValue) {
			String rv = _get(key, Boolean.valueOf(defaultValue).toString(), boolean.class.getName());
			return Boolean.parseBoolean(rv);
		}

		@Override
		public int get(String key, int defaultValue) {
			String rv = _get(key, Integer.valueOf(defaultValue).toString(), int.class.getName());
			return Integer.parseInt(rv);
		}

		@Override
		public double get(String key, double defaultValue) {
			String rv = _get(key, Double.valueOf(defaultValue).toString(), double.class.getName());
			return Double.parseDouble(rv);
		}
		
	}
}
