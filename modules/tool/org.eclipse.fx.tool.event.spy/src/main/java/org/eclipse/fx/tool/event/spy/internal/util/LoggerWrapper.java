/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.tool.event.spy.internal.util;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.fx.tool.event.spy.internal.constants.Constants;

/**
 * Wraps the logger.
 */
@Creatable
public class LoggerWrapper extends Logger {

    @Optional
    @Inject
    private Logger logger;

    @Override
    public boolean isErrorEnabled() {
        if (logger != null) {
            return logger.isErrorEnabled();
        }
        return false;
    }

    @Override
    public boolean isTraceEnabled() {
        if (logger != null) {
            return logger.isTraceEnabled();
        }
        return false;
    }

    @Override
    public boolean isWarnEnabled() {
        if (logger != null) {
            return logger.isWarnEnabled();
        }
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        if (logger != null) {
            return logger.isInfoEnabled();
        }
        return false;
    }

    @Override
    public boolean isDebugEnabled() {
        if (logger != null) {
            return logger.isDebugEnabled();
        }
        return false;
    }

    @Override
    public void error(Throwable t, String message) {
        if (logger != null && isErrorEnabled()) {
            logger.error(t, withPluginInfo(message));
        }
    }

    @Override
    public void warn(Throwable t, String message) {
        if (logger != null && isWarnEnabled()) {
            logger.warn(t, withPluginInfo(message));
        }
    }

    @Override
    public void info(Throwable t, String message) {
        if (logger != null && isInfoEnabled()) {
            logger.info(t, withPluginInfo(message));
        }
    }

    @Override
    public void trace(Throwable t, String message) {
        if (logger != null && isTraceEnabled()) {
            logger.trace(t, withPluginInfo(message));
        }
    }

    @Override
    public void debug(Throwable t) {
        if (logger != null && isDebugEnabled()) {
            logger.debug(t);
        }
    }

    @Override
    public void debug(Throwable t, String message) {
        if (logger != null && isDebugEnabled()) {
            logger.debug(t, withPluginInfo(message));
        }
    }

    private String withPluginInfo(String message) {
        return String.format("Plugin '%s': %s", Constants.PLUGIN_ID, message);
    }
}
