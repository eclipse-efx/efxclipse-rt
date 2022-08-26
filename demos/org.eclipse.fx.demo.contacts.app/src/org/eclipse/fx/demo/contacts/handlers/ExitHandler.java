/*******************************************************************************
 * Copyright (c) 2009 Siemens AG and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Kai T??dter - initial implementation
 ******************************************************************************/

package org.eclipse.fx.demo.contacts.handlers;

import javafx.application.Platform;
import org.eclipse.e4.core.di.annotations.Execute;

@SuppressWarnings("restriction")
public class ExitHandler {
	@Execute
	public void exit() {
		// TODO better life cycle support
		Platform.exit();
	}
}
