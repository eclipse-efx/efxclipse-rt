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
package org.eclipse.fx.core;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A status implementation built from child status instances
 * 
 * @since 3.0
 */
public interface MultiStatus extends Status {
	/**
	 * Add child status instances
	 * 
	 * @param status
	 *            status instance(s)
	 * @return the status itself
	 */
	public MultiStatus add(Status... status);

	/**
	 * Collector who is able to collect a {@link Stream} of {@link Status} to a
	 * {@link MultiStatus}
	 * 
	 * @param message
	 *            the {@link MultiStatus#getMessage()}
	 * @param code
	 *            the {@link MultiStatus#getCode()}
	 * @return the collector
	 */
	public static Collector<@NonNull Status, ?, MultiStatus> toMultiStatus(String message, int code) {
		return Collectors.collectingAndThen(Collectors.toList(), l -> new MultiStatusImpl(message, code, l, true));
	}
	
	/**
	 * @return unmodifiable list of child states
	 */
	public List<Status> getChildren();
}
