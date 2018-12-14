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

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.runners.model.Statement;

import javafx.application.Platform;

/**
 * Run a Test on the JavaFX Thread and in a running JavaFX application
 */
public class FXTestStatement extends Statement {
	private Statement base;

	public FXTestStatement(Statement base) {
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		AtomicReference<Throwable> t = new AtomicReference<>();
		CountDownLatch l = new CountDownLatch(1);
		Platform.runLater(() -> {
			try {
				base.evaluate();
			} catch (Throwable e) {
				t.set(e);
			} finally {
				l.countDown();
			}
		});
		l.await();
		if (t.get() != null) {
			throw t.get();
		}
	}

}