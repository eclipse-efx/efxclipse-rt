/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.core.fxml;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;

import javafx.util.Builder;

/**
 * Builder for URLs
 */
public class URLBuilder implements Builder<URL> {
	private String value;

	/**
	 * @return a new builder instance
	 */
	@NonNull
	public static URLBuilder create() {
		return new URLBuilder();
	}

	/**
	 * Set an url
	 * 
	 * @param value
	 *            the url value
	 * @return the builder
	 */
	public URLBuilder value(String value) {
		this.value = value;
		return this;
	}

	@Override
	@NonNull
	public URL build() throws IllegalStateException {
		try {
			return new URL(this.value);
		} catch (MalformedURLException e) {
			throw new IllegalStateException(e);
		}
	}

}
