/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.junit;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.test.rcontrol.RController;
import org.eclipse.fx.test.rcontrol.RControllerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class FXComponentTest<N extends Parent, O> {
	
	@Rule
	public FXTestRule r = new FXTestRule();

	private final Class<N> root;
	private O component;

	private Stage stage;
	
	private static RControllerFactory FACTORY = ServiceUtils.getService(RControllerFactory.class).get();
	private RController controller;

	public FXComponentTest(Class<N> root) {
		this.root = root;
	}
	
	protected Stage createStage() {
		return new Stage();
	}
	
	protected Scene createScene(N parent) {
		return new Scene(parent, 800, 600);
	}
	
	protected abstract O createComponent(N parent);
	
	public O component() {
		return component;
	}
	
	@Before
	public void init() {
		stage = createStage();
		try {
			N instance = root.newInstance();
			component = createComponent(instance);
			Scene scene = createScene(instance);
			stage.setScene(scene);
			stage.show();
			controller = FACTORY.create(scene);
			controller.waitForRender();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public final RController rcontroller() {
		return controller;
	}
	
	@After
	public void cleanup() {
		stage.close();
	}
}
