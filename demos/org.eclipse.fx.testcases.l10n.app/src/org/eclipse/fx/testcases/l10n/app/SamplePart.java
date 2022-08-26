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
package org.eclipse.fx.testcases.l10n.app;

import java.util.Date;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class SamplePart {
	@Inject
	SamplePartMessagesRegistry r;
	
	@PostConstruct
	void init(BorderPane parent) {
		VBox b = new VBox();
		
		{
			Label label = new Label();
			r.register(label::setText, r::SimpleText);
			
			b.getChildren().add(label);			
		}
		
		{
			Label label = new Label();
			r.register(label::setText, r.SimpleDateText_supplier(new Date()));
			
			b.getChildren().add(label);
		}
		
		{
			Label label = new Label();
			r.register(label::setText, r.SimpleNumberText_supplier(10_000));
			
			b.getChildren().add(label);
		}
		
		{
			Label label = new Label();
			r.register(label::setText, r.CustFormatText_supplier(null));
			
			b.getChildren().add(label);
		}
		
		{
			Label label = new Label();
			r.register(label::setText, r::ReferenceText);
			
			b.getChildren().add(label);
		}
		
		parent.setTop(b);
	}
}
