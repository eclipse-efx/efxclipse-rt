/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.fx;

import org.eclipse.fx.core.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Wraps an EMF-URI
 */
public class EMFUri implements URI {
	private org.eclipse.emf.common.util.URI uri;

	/**
	 * Create a new uri
	 * 
	 * @param uri
	 *            the uri
	 */
	public EMFUri(org.eclipse.emf.common.util.@NonNull URI uri) {
		this.uri = uri;
	}

	@Override
	public boolean isPlatformPlugin() {
		return this.uri.isPlatformPlugin();
	}

	@Override
	public @Nullable String segment(int i) {
		return this.uri.segment(i);
	}

	@Override
	public int segmentCount() {
		return this.uri.segmentCount();
	}

	@Override
	public @Nullable String query() {
		return this.uri.query();
	}

	@Override
	public @Nullable String lastSegment() {
		return this.uri.lastSegment();
	}

	@Override
	public boolean hasQuery() {
		return this.uri.hasQuery();
	}

	@Override
	public String toString() {
		return this.uri.toString();
	}
	
	@Override
	public @Nullable String host() {
		return this.uri.host();
	}
}
