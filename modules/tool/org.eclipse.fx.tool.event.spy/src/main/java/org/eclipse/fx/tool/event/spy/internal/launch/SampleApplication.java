/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.event.spy.internal.launch;

import org.eclipse.fx.tool.event.spy.internal.model.EventSpyModel;
import org.eclipse.fx.tool.event.spy.internal.view.EventSpyView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Sample Application for starting the event spy without an osgi application.
 */
public class SampleApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        EventSpyModel eventSpyModel = new EventSpyModel(new DummyEventBrokerProvider().getIEventBroker());

        EventSpyView eventSpyView = new EventSpyView(eventSpyModel);

        primaryStage.setScene(new Scene(eventSpyView.getGui(), 900, 800));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
