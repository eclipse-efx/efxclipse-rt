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
 */
public interface URI {

	/**
	 * @return <code>true</code> if it is a plug-in URI (platform:/plugin/....)
	 */
	public boolean isPlatformPlugin();

	/**
	 * Get the segment at the specified index
	 * 
	 * @param i
	 *            the index
	 * @return the segment
	 */
	public @Nullable String segment(int i);

	/**
	 * @return the segment count
	 */
	public int segmentCount();

	/**
	 * @return the query or <code>null</code>
	 */
	public @Nullable String query();

	/**
	 * @return the last segment
	 */
	public @Nullable String lastSegment();

	/**
	 * @return check if there is a query
	 */
	public boolean hasQuery();

	/**
	 * Create a new uri
	 * 
	 * @param s
	 *            the uri value
	 * @return the new uri
	 */
	public URI createURI(@NonNull String s);
}
