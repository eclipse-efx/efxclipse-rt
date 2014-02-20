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
package org.eclipse.fx.ui.workbench.base.internal;

import javax.inject.Inject;

import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.core.log.LoggerFactory;


@SuppressWarnings("restriction")
public class LoggerProviderImpl implements ILoggerProvider{
	@Inject
	LoggerFactory factory;
	
	@Override
	public Logger getClassLogger(Class<?> clazz) {
		final org.eclipse.fx.core.log.Logger logger = factory.createLogger(clazz.getName());
		return new Logger() {
			
			@Override
			public void warn(Throwable t, String message) {
				logger.warning(message, t);
			}
			
			@Override
			public void trace(Throwable t, String message) {
				logger.trace(message, t);
			}
			
			@Override
			public boolean isWarnEnabled() {
				return logger.isEnabled(Level.WARNING);
			}
			
			@Override
			public boolean isTraceEnabled() {
				return logger.isEnabled(Level.TRACE);
			}
			
			@Override
			public boolean isInfoEnabled() {
				return logger.isEnabled(Level.INFO);
			}
			
			@Override
			public boolean isErrorEnabled() {
				return logger.isEnabled(Level.ERROR);
			}
			
			@Override
			public boolean isDebugEnabled() {
				return logger.isEnabled(Level.DEBUG);
			}
			
			@Override
			public void info(Throwable t, String message) {
				logger.info(message, t);
			}
			
			@Override
			public void error(Throwable t, String message) {
				logger.error(message, t);
			}
			
			@Override
			public void debug(Throwable t, String message) {
				logger.debug(message, t);
			}
			
			@Override
			public void debug(Throwable t) {
				logger.debug("",t);
			}
		};
	}
}
