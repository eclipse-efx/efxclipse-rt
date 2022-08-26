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
package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;

import javafx.beans.property.ObjectProperty;

public interface DecoratedNode {
	public ObjectProperty<Status> statusProperty();
	public void setStatus(Status status);
	public Status getStatus();
}
