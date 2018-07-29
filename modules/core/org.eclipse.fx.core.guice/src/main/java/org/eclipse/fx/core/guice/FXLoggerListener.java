/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.guice;

import java.lang.reflect.Field;

import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.jdt.annotation.NonNull;

import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * Listener to support the injection of @Log
 * <pre><code>
 * class MyBean {
 *   &#64;Log
 *   Logger logger;
 * }
 * </code>
 * </pre>
 */
public class FXLoggerListener implements TypeListener {

	@Override
	public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
		 for (Field field : typeLiteral.getRawType().getDeclaredFields()) {
			 if( field.getType() == Logger.class && field.isAnnotationPresent(Log.class) ) {
				 String loggerName = field.getAnnotation(Log.class).value();
				 if( loggerName == null || loggerName.isEmpty() ) {
					 loggerName = typeLiteral.getRawType().getName();
				 }
				 if( loggerName == null ) {
					 loggerName = "unknown"; //$NON-NLS-1$
				 }

				 Provider<LoggerFactory> provider = typeEncounter.getProvider(LoggerFactory.class);
				 if( provider == null ) {
					 throw new IllegalStateException("No " + LoggerFactory.class + " provider registered");  //$NON-NLS-1$//$NON-NLS-2$
				 }

				 typeEncounter.register(new FieldLoggerInjector<T>(field,loggerName,provider));
			 }
		 }
	}

	static class FieldLoggerInjector<T> implements MembersInjector<T> {
		@NonNull
		private Provider<LoggerFactory> provider;

		@NonNull
		private Field field;

		@NonNull
		private String loggerName;

		public FieldLoggerInjector(@NonNull Field field, @NonNull String loggerName, @NonNull Provider<LoggerFactory> provider) {
			this.provider = provider;
			this.field = field;
			this.loggerName = loggerName;
			this.field.setAccessible(true);
		}

		@Override
		public void injectMembers(T instance) {
			Logger logger = this.provider.get().createLogger(this.loggerName);
			try {
				this.field.set(instance,logger);
			} catch (IllegalArgumentException e) {
				logger.error("Unable to inject the logger",e); //$NON-NLS-1$
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				logger.error("Unable to inject the logger",e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}
		}
	}
}