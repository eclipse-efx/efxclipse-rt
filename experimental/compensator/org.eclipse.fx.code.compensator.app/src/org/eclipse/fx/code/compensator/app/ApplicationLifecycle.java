/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.code.compensator.app;

import java.io.File;
import java.io.IOException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;

@SuppressWarnings("restriction")
public class ApplicationLifecycle {
	@PostContextCreate
	public void init(IEclipseContext context) {
		// We should show a selection dialog
		File folder = new File(System.getProperty("user.home")+"/.compensator");
		if( ! folder.exists() ) {
			folder.mkdirs();
		}
		context.set("data-dir", folder);
	}


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
