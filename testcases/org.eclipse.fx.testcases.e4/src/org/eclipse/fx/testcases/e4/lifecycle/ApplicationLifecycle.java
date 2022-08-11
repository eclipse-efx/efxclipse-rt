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
package org.eclipse.fx.testcases.e4.lifecycle;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.fx.ui.services.restart.LifecycleRV;
import org.eclipse.fx.ui.services.sync.UISynchronize;

@SuppressWarnings("restriction")
public class ApplicationLifecycle {
	@PostContextCreate
	LifecycleRV showStartUp(UISynchronize sync) {
		Stage s = new Stage();
		VBox box = new VBox();
		AtomicReference<LifecycleRV> rv = new AtomicReference<>(LifecycleRV.CONTINUE);
		{
			Button b = new Button("Continue");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> {rv.set(LifecycleRV.CONTINUE); s.close();});
			box.getChildren().add(b);
		}
		{
			Button b = new Button("Shutdown");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> {rv.set(LifecycleRV.SHUTDOWN); s.close();});
			box.getChildren().add(b);
		}
		{
			Button b = new Button("Restart");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> {rv.set(LifecycleRV.RESTART); s.close();});
			box.getChildren().add(b);
		}
		{
			Button b = new Button("Restart with cleared State");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> {rv.set(LifecycleRV.RESTART_CLEAR_STATE); s.close();});
			box.getChildren().add(b);
		}
		
		s.setScene(new Scene(box,200,200));
		s.showAndWait();
		
		return rv.get();
	}
}
