/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface ShellListener extends SWTEventListener {

	public void shellActivated(ShellEvent e);

	public void shellClosed(ShellEvent e);

	public void shellDeactivated(ShellEvent e);

	public void shellDeiconified(ShellEvent e);

	public void shellIconified(ShellEvent e);
}