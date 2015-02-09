/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An URI representation
 *
 */
class SimpleURI implements URI {
	@SuppressWarnings("null")
	@NonNull
	private String[] segments = new String[0];

	@Nullable
	private String query;

	@NonNull
	private String uri;
	
	@Nullable
	private String host = null;

	/**
	 * Create a new uri
	 *
	 * @param uri
	 *            the uri
	 */
	public SimpleURI(@NonNull String uri) {
		this.uri = uri;
		parseURI(uri);
	}

	@SuppressWarnings("null")
	private void parseURI(final String uri) {
		String _uri = uri;

		int schemeEnd = _uri.indexOf(':');
		if (schemeEnd != -1) {
			_uri = _uri.substring(schemeEnd + 1);
		}
		
		int queryStart = _uri.indexOf('?');

		if (queryStart != -1) {
			this.query = _uri.substring(queryStart + 1);
			_uri = _uri.substring(0, queryStart);
		}

		if( _uri.startsWith("//") ) { //$NON-NLS-1$
			String[] vals = _uri.substring(2).split("/"); //$NON-NLS-1$
			if( vals.length > 0 ) {
				this.segments = new String[vals.length-1];  
				for( int i = 1; i < vals.length; i++ ) {
					this.segments[i-1] = vals[i];
				}
				this.host = vals[0];
			}
		} else {
			this.segments = _uri.substring(1).split("/"); //$NON-NLS-1$
		}
	}
	
	@Override
	public String host() {
		return this.host;
	}

	@Override
	public boolean isPlatformPlugin() {
		return this.segments.length > 0 && "plugin".equals(this.segments[0]); //$NON-NLS-1$
	}

	@Override
	public @Nullable String segment(int i) {
		if( i < this.segments.length ) {
			return this.segments[i];
		}
		return null;
	}

	@Override
	public int segmentCount() {
		return this.segments.length;
	}

	@Override
	public @Nullable String query() {
		return this.query;
	}

	@Override
	public @Nullable String lastSegment() {
		int l = this.segments.length;
		if (l == 0) {
			return null;
		}

		return this.segments[l - 1];
	}

	@Override
	public String toString() {
		return this.uri;
	}

	@Override
	public boolean hasQuery() {
		return this.query != null;
	}
}