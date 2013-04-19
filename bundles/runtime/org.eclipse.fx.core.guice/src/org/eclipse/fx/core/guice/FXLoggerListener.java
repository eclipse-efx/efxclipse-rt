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

import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class FXLoggerListener implements TypeListener {
	
	@Override
	public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
		 for (Field field : typeLiteral.getRawType().getDeclaredFields()) {
			 if( field.getType() == Logger.class && field.isAnnotationPresent(Log.class) ) {
				 String loggerName = field.getAnnotation(Log.class).value();
				 if( loggerName == null || loggerName.isEmpty() ) {
					 loggerName = typeLiteral.getRawType().getName();
				 }
				 typeEncounter.register(new FieldLoggerInjector<T>(field,loggerName,typeEncounter.getProvider(LoggerFactory.class)));
			 }
		 }
	}
	
	static class FieldLoggerInjector<T> implements MembersInjector<T> {
		private Provider<LoggerFactory> provider;
		private Field field;
		private String loggerName;
		
		public FieldLoggerInjector(Field field, String loggerName, Provider<LoggerFactory> provider) {
			this.provider = provider;
			this.field = field;
			this.loggerName = loggerName;
			this.field.setAccessible(true);
		}
		
		@Override
		public void injectMembers(T instance) {
			try {
				field.set(instance,provider.get().createLogger(loggerName));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}