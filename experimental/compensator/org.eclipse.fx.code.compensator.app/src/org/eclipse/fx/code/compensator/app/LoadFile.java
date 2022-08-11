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
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.app;

import java.nio.file.Paths;
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
						org.eclipse.fx.code.compensator.model.workbench.File wf = WorkbenchFactory.eINSTANCE.createFile();
						wf.setUrl(Paths.get(f.toURI()).toUri().toString());
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