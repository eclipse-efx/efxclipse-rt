/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
