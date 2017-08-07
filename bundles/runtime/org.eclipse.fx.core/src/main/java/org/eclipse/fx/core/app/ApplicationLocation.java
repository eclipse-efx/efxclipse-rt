/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.app;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

/**
 * A location who supports locking
 *
 * <p>
 * This provisional API and subject to change
 * </p>
 *
 * @since 3.0
 * @noimplement
 * @noreference
 */
public interface ApplicationLocation {
	/**
	 * Try to lock the location
	 *
	 * @return <code>true</code> if the lock succeeded
	 * @throws IOException
	 *             if something fails while locking
	 */
	public boolean lock() throws IOException;

	/**
	 * Release a lock
	 */
	public void release();

	/**
	 * @return the path of the file or directory
	 */
	public Path getPath();

	/**
	 * @return url to the file or directory
	 */
	public URL getURL();

	/**
	 * @return <code>true</code> if the file or directory is read only
	 */
	public boolean isReadOnly();
}
