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
package org.eclipse.fx.test.junit.internal;

import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ApplicationLaunch {
	private static boolean launched;
	private static CountDownLatch l;

	public static synchronized void bootstrap() {
		if (launched) {
			return;
		}
		launched = true;
		l = new CountDownLatch(1);
		Thread t = new Thread() {
			@Override
			public void run() {
				Application.launch(BootApplication.class);
			}
		};
		t.start();
		try {
			l.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class BootApplication extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			Platform.setImplicitExit(false);
			l.countDown();
		}

	}
}