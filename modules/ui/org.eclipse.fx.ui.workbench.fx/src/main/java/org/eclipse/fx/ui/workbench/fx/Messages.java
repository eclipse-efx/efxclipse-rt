/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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

import org.eclipse.osgi.util.NLS;

/**
 * Translation keys
 * @noreference
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.fx.ui.workbench.fx.messages"; //$NON-NLS-1$
	
	/**
	 * 
	 */
	public static String E4Application_LockFail_Message;
	/**
	 * 
	 */
	public static String E4Application_LockFail_Title;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
