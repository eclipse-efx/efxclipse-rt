/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.modelviewer.internal;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class StyledString {
	
	public static TextFlow toTextFlow(String styledString) {
		int idx;
		List<Text> ts = new ArrayList<Text>();
		while( (idx = styledString.lastIndexOf("_#")) != -1 ) {
			String part = styledString.substring(idx);
			String style = part.substring(2,part.indexOf("#_"));
			String text = part.substring(part.indexOf("#_")+2);
			styledString = styledString.substring(0, idx);
			
			Text t = new Text(text);
			t.getStyleClass().add(style);
			ts.add(0,t);
		}
		
		if( ! styledString.isEmpty() ) {
			ts.add(0,new Text(styledString));
		}
		
		
		TextFlow t = new TextFlow();
		t.getChildren().setAll(ts);
		return t;
	}
}
