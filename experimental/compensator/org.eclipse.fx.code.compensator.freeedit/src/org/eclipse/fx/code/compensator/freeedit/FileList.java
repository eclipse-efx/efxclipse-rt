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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.code.compensator.model.workbench.File;
import org.eclipse.fx.code.compensator.model.workbench.Resource;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

@SuppressWarnings("restriction")
public class FileList {
	@Inject
	private Workbench workbench;
	
	@Inject
	private ECommandService commandService;
	
	@Inject
	private EHandlerService handlerService;
	
	private ObservableList<Resource> inputList = FXCollections.observableArrayList();

	private ListView<Resource> view;
	
	@PostConstruct
	public void initUI(BorderPane parent) {
		view = new ListView<>();
		view.setCellFactory(FileList::listCell);
		for( Resource r : workbench.getResources() ) {
			inputList.add(r);
		}
		view.setItems(inputList);
		view.setOnMouseClicked(this::open);
		parent.setCenter(view);
		workbench.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if( msg.getFeature() == WorkbenchPackage.Literals.WORKBENCH_ELEMENT__RESOURCES ) {
					if( msg.getEventType() == Notification.ADD ) {
						inputList.add((Resource) msg.getNewValue());
					}
				}
			}
		});
	}
	
	private void open(MouseEvent event) {
		if( event.getClickCount() == 2 ) {
			Command cmd = commandService.getCommand("org.eclipse.fx.code.compensator.app.command.1");
			IEclipseContext staticCtx = EclipseContextFactory.create();
			staticCtx.set(File.class, (File)view.getSelectionModel().getSelectedItem());
			ParameterizedCommand pCmd = ParameterizedCommand.generateCommand(cmd, Collections.emptyMap());
			handlerService.executeHandler(pCmd, staticCtx);
			staticCtx.dispose();
		}
	}
	
	private static ListCell<Resource> listCell(ListView<Resource> param) {
		return new ListCell<Resource>() {
			@Override
			protected void updateItem(Resource item, boolean empty) {
				if( item != null && ! empty ) {
					if( item instanceof File ) {
						URI uri = URI.createURI(((File) item).getUrl());
						setText(uri.lastSegment());
					}
				} else {
					setText(null);
					setGraphic(null);
				}
				super.updateItem(item, empty);
			}
		};
	}
}