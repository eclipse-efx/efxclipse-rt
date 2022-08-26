/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.core.ExceptionHandler;
import org.eclipse.fx.core.ExceptionHandler.ExceptionData;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("javadoc")
@Component(immediate=true)
public class UncaughtExceptionSupport {
	private List<ExceptionHandler> handlers = new ArrayList<>();
	
	public UncaughtExceptionSupport() {
		Thread.setDefaultUncaughtExceptionHandler( this::handleException );
	}
	
	private void handleException(Thread t, Throwable e) {
		ExceptionHandler[] handlers;
		synchronized (this.handlers) {
			handlers = this.handlers.toArray(new ExceptionHandler[0]);
		}
		
		@SuppressWarnings("null")
		ExceptionDataImpl d = new ExceptionDataImpl(e);
		for( ExceptionHandler h : handlers ) {
			h.handleException(d);
		}
	}
	
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerExceptionHandler(ExceptionHandler handler) {
		synchronized (this.handlers) {
			this.handlers.add(handler);
		}
	}
	
	public void unregisterExceptionHandler(ExceptionHandler handler) {
		synchronized (this.handlers) {
			this.handlers.remove(handler);
		}
	}
	
	static class ExceptionDataImpl implements ExceptionData {
		@NonNull
		private final Throwable e;
		
		public ExceptionDataImpl(@NonNull Throwable e) {
			this.e = e;
		}
		
		@SuppressWarnings("null")
		@Override
		public @NonNull String sourceClass() {
			return this.e.getStackTrace()[0].getClassName();
		}

		@Override
		public @NonNull Throwable throwable() {
			return this.e;
		}
	}
}
