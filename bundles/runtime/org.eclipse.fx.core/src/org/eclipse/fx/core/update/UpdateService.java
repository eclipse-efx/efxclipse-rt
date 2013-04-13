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
package org.eclipse.fx.core.update;

import org.eclipse.fx.core.Callback;

public interface UpdateService {
	public void update(UpdateCheckData data, Callback<UpdateData> callback);
	public void checkUpdate(Callback<UpdateCheckData> callback);
	
	public enum State {
		ERROR,
		WARNING,
		CANCEL,
		OK
	}
	
	public static class ReturnValueImpl<V> implements ReturnValue<V> {
		public final State state;
		public final String message;
		public final Throwable throwable;
		public final V value;
		
		public ReturnValueImpl(State state, String message, V value, Throwable throwable) {
			this.state = state; 
			this.message = message;
			this.throwable = throwable;
			this.value = value;
		}
		
		@Override
		public String getMessage() {
			return message;
		}
		
		public Throwable getThrowable() {
			return throwable;
		}
		
		public State getState() {
			return state;
		}
		
		public V getValue() {
			return value;
		}
	}
	
	interface ReturnValue<V> {
		public State getState();
		public String getMessage();
		public V getValue();
		public Throwable getThrowable();
	}
	
	interface UpdateCheckData extends ReturnValue<Boolean> {
		
	}
	
	interface UpdateData extends ReturnValue<Boolean> {
		
	}
}
