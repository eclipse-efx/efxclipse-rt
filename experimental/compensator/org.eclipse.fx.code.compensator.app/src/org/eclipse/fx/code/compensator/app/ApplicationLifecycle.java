/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.app;

import java.io.IOException;

import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;

@SuppressWarnings("restriction")
public class ApplicationLifecycle {
	@PreSave
	public void shutdown(Workbench workbench) {
		try {
			workbench.eResource().save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
