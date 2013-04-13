/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.e4.controls;

import javafx.scene.control.Tab;
import javafx.util.Callback;

public interface FXTab  {
	public void setCloseVetoHandler(Callback<Tab, Boolean> closeVetoHandler);
	public Callback<Tab, Boolean> getCloseVetoHandler();
}
