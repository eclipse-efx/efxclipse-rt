/*******************************************************************************
 * Copyright (c) 2014 __COMPANY/CONTRIBUTOR__ and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
