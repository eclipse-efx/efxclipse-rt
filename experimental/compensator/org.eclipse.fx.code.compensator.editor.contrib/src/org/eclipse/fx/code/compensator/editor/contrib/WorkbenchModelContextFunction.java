/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.contrib;

import java.io.File;
import java.io.IOException;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchFactory;

public class WorkbenchModelContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		context = context.get(MApplication.class).getContext();
		Workbench wb = (Workbench) context.get("LocalWorkbench");
		if( wb == null ) {
			File f = new File(System.getProperty("user.home")+"/.compensator/workbench.xmi");
			if( f.exists() ) {
				try {
					Resource r = new XMIResourceImpl(URI.createFileURI(f.getAbsolutePath()));
					r.load(null);
					wb = (Workbench) r.getContents().get(0);
					context.set("LocalWorkbench", wb);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				wb = WorkbenchFactory.eINSTANCE.createWorkbench();
				context.set("LocalWorkbench", wb);
			}
		}
		return wb;
	}
}
