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
package org.eclipse.fx.testcases.e4.parts;

import java.awt.Button;
import java.awt.Label;

import javafx.embed.swing.SwingNode;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestSwingPart {
	@PostConstruct
	void init(BorderPane pane) {
		SwingNode n = new SwingNode();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				n.setContent(new SwingPartPanel());
			}
			
		});
		
		pane.setCenter(n);
	}
	
	public class SwingPartPanel extends JPanel {

	    private static final long serialVersionUID = -2529807437953504842L;

	    public SwingPartPanel() {
	        add(new JLabel("I'm a " + JLabel.class.getName()));
	        add(new JButton("I'm a " + JButton.class.getName()));
//	        add(new Label("I'm a " + Label.class.getName()));
//	        add(new Button("I'm a " + Button.class.getName()));
	    } 
	}
}
