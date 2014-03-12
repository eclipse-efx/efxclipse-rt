/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

/**
 * A tab in the {@link ETabFolder}
 */
public class ETab {
	private StringProperty text = new SimpleStringProperty(this,"text");
	private ObjectProperty<Node> content = new SimpleObjectProperty<Node>(this,"content");
	
	public ETab() {
		this(null);
	}
	
	public ETab(String text) {
		this.text.set(text);
	}
	
	public String getText() {
		return text.get();
	}
	
	public void setText(String text) {
		this.text.set(text);
	}
	
	public StringProperty textProperty() {
		return this.text;
	}
	
	public Node getContent() {
		return this.content.get();
	}
	
	public void setContent(Node node) {
		this.content.set(node);
	}
	
	public ObjectProperty<Node> contentProperty() {
		return this.content;
	}
}
