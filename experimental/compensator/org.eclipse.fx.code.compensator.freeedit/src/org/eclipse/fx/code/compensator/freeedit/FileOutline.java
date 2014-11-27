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
package org.eclipse.fx.code.compensator.freeedit;

import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.ui.controls.Util;

public class FileOutline {
	private TreeView<OutlineItem> outlineView;

	@PostConstruct
	public void initUI(BorderPane parent) {
		outlineView = new TreeView<>();
		outlineView.setShowRoot(false);
		outlineView.setCellFactory(this::createCell);
		parent.setCenter(outlineView);
	}

	TreeCell<OutlineItem> createCell(TreeView<OutlineItem> param) {
		return new TreeCell<OutlineItem>() {
			@Override
			protected void updateItem(OutlineItem item, boolean empty) {

				if( item != null && ! empty ) {
					Label value = new Label(item.getLabel().toString());
					value.getStyleClass().addAll(item.getStyle());
					setGraphic(value);
				} else {
					setGraphic(null);
				}

				super.updateItem(item, empty);
			}
		};
	}

	@Inject
	void updateInput(@Optional @Named("activeOutline") Outline outline) {
		//TODO needs to be fixed
		if( outlineView == null ) {
			return;
		}
		if( outline != null ) {
			TreeItem<OutlineItem> root = new TreeItem<Outline.OutlineItem>();
			for( OutlineItem l : outline.getRootItems() ) {
				root.getChildren().add(createRec(l));
			}
			outlineView.setRoot(root);
		} else {
			outlineView.setRoot(new TreeItem<>());
		}
	}

	TreeItem<OutlineItem> createRec(OutlineItem i) {
		TreeItem<OutlineItem> l = new TreeItem<Outline.OutlineItem>(i);
		for( OutlineItem c : i.getChildren() ) {
			l.getChildren().add(createRec(c));
		}

		return l;
	}
}
