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

/**
 * Implementation of an {@link ILoggerProvider} routing informations to the
 * {@link org.eclipse.fx.core.log.Logger}
 */
@SuppressWarnings("restriction")
public class LoggerProviderImpl implements ILoggerProvider {
	@Inject
	LoggerFactory factory;

	@Override
	public Logger getClassLogger(Class<?> clazz) {
		@SuppressWarnings("null")
		final org.eclipse.fx.core.log.Logger logger = this.factory.createLogger(clazz.getName());
		return new Logger() {

			@Override
			public void warn(Throwable t, String message) {
				if( message != null && t != null ) {
					logger.warning(message, t);
				} else if( message == null && t != null ) {
					logger.error("", t); //$NON-NLS-1$
                } else if(message != null && t == null) {
                    logger.info( message );
                } else {    
                    logger.info("<no message & no throwable>"); //$NON-NLS-1$
				}
			}

			@Override
			public void trace(Throwable t, String message) {
				if( message != null && t != null ) {
					logger.trace(message, t);
				} else if( message == null && t != null ) {
					logger.trace("", t); //$NON-NLS-1$
                } else if(message != null && t == null) {
                    logger.info( message );
                } else {    
                    logger.info("<no message & no throwable>"); //$NON-NLS-1$
				}
				
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
				if( message != null && t != null ) {
					logger.info(message, t);	
				} else if( message == null && t != null ) {
					logger.info("", t); //$NON-NLS-1$
				} else if(message != null && t == null) {
				    logger.info( message );
				} else {    
					logger.info("<no message & no throwable>"); //$NON-NLS-1$
				}
			}

			@Override
			public void error(Throwable t, String message) {
				if( message != null && t != null ) {
					logger.error(message, t);
				} else if( message == null && t != null ) {
					logger.error("",t); //$NON-NLS-1$
                } else if(message != null && t == null) {
                    logger.info( message );
                } else {    
                    logger.info("<no message & no throwable>"); //$NON-NLS-1$
				}
			}

			@Override
			public void debug(Throwable t, String message) {
				if( message != null && t != null ) {
					logger.debug(message, t);	
				} else if( message == null && t != null ) {
					logger.error("", t); //$NON-NLS-1$
                } else if(message !=null && t == null) {
                    logger.info( message );
                } else {    
                    logger.info("<no message & no throwable>"); //$NON-NLS-1$
				}
			}

			@Override
			public void debug(Throwable t) {
				if( t != null ) {
					logger.debug("", t); //$NON-NLS-1$	
				} else {
					logger.debug("<no throwable>"); //$NON-NLS-1$					
				}
			}
		};
	}
}
