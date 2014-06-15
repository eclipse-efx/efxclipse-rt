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
package org.eclipse.fx.code.compensator.app;

import java.util.Optional;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchFactory;


public class LoadFile {
	@Execute
	public void execute(Stage parent, IEventBroker eventBroker, Workbench wb) {
		FileChooser chooser = new FileChooser();
		Optional.ofNullable(chooser.showOpenMultipleDialog(parent)).ifPresent((l) ->
			{
				l.forEach((f) -> {
					try {
						System.err.println("ATTACHING: " + f);
						org.eclipse.fx.code.compensator.model.workbench.File wf = WorkbenchFactory.eINSTANCE.createFile();
						wf.setUrl(f.toURI().toURL().toExternalForm());
						wb.getResources().add(wf);	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
			}
		);
		
	}
		
}