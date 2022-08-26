/*******************************************************************************
 * Copyright (c) 2014 __COMPANY/CONTRIBUTOR__ and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     tomschindl<__EMAIL__> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

/**
 * @author tomschindl
 *
 */
public class CloseWorkbench {
	@Execute
	void close(IWorkbench w) {
		w.close();
	}
}
