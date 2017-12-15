/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.log.internal;

import org.eclipse.fx.core.ExceptionHandler;
import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.service.component.annotations.Component;

/**
 * Log an exception
 */
@Component
public class ExceptionLogger implements ExceptionHandler {

	@SuppressWarnings("null")
	@Override
	public void handleException(ExceptionData data) {
		ServiceUtils.getService(LoggerFactory.class)
			.map( f -> f.createLogger(data.sourceClass()))
			.ifPresent( l -> l.error( data.throwable().getMessage(),data.throwable()));
	}

}
