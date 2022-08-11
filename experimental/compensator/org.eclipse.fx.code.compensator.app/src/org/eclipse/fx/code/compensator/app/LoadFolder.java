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
package org.eclipse.fx.code.compensator.app;

import java.nio.file.Paths;
import java.util.Optional;


import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;


import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.model.workbench.Folder;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchFactory;

public class LoadFolder {
	@Execute
	public void execute(Stage parent, IEventBroker eventBroker, Workbench wb) {
		DirectoryChooser chooser = new DirectoryChooser();
		Optional.ofNullable(chooser.showDialog(parent)).ifPresent((l) ->
		{
			try {
				Folder f = WorkbenchFactory.eINSTANCE.createFolder();
				f.setUrl(Paths.get(l.toURI()).toUri().toString());
				wb.getResources().add(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		);

	}
}
