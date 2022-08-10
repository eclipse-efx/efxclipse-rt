/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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