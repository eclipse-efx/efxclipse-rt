/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.event;

/**
 * Represents a topic
 *
 * @param <T>
 *            the data type send through this topic
 * @since 2.2.0
 */
public final class Topic<T> {
	/**
	 * The topic identifier
	 */
	public final String topic;

	/**
	 * Create a new topic
	 *
	 * @param topic
	 *            the topic
	 */
	public Topic(String topic) {
		this.topic = topic;
	}
}
