/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.runtime.fswt.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.FCallback;
import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.fx.internal.widgets.FXComposite;
import org.eclipse.fx.runtime.fswt.fx.internal.widgets.FXControl;
import org.eclipse.fx.runtime.fswt.fx.internal.widgets.FXDisplay;
import org.eclipse.fx.runtime.fswt.fx.internal.widgets.FXShell;
import org.eclipse.fx.runtime.fswt.widgets.FComposite;
import org.eclipse.fx.runtime.fswt.widgets.FControl;
import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.fx.runtime.fswt.widgets.FShell;
import org.eclipse.fx.runtime.fswt.widgets.FWidget;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

import com.sun.javafx.tk.Toolkit;

@SuppressWarnings("restriction")
public class FXSWT implements FSWT {
	private static FXSWT SELF;
	private FCallback<FDisplay<Display>, FBlockCondition> initialize;

	public FXSWT() {
		SELF = this;
	}

	@Override
	public int getRanking() {
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Widget, F extends FWidget<T>> F adapt(T widget,
			Class<F> clazz) {
		if( clazz == FShell.class ) {
			return (F) new FXShell<>((Shell) widget,this);
		} else if( clazz == FComposite.class ) {
			return (F) new FXComposite<>((Composite)widget,this);
		} else if( clazz == FControl.class ) {
			return (F) new FXControl<>((Control)widget,this);
		}
		throw new IllegalArgumentException("Unsupported adapter '"+clazz+"'");
	}

	@Override
	public void boostrap(FCallback<FDisplay<Display>, FBlockCondition> initialize) {
		FXSWT.SELF.initialize = initialize;
		Application.launch(FXApp.class);
	}

	public static class FXApp extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			final Display d = new Display();
			FXDisplay<Display> fxd = new FXDisplay<>(d,SELF);
			FBlockCondition condition = SELF.initialize.invoke(fxd);
			if( condition != null ) {
				if( condition instanceof ShellBlockCondition ) {
					ShellBlockCondition c = (ShellBlockCondition) condition;
					c.closeRunnable = new Runnable() {

						@Override
						public void run() {
							d.dispose();
						}
					};
				} else {
					fxd.block(condition);
					d.dispose();
				}
			} else {
				d.dispose();
			}
		}
	}

	public static class ShellBlockCondition extends DefaultBlockCondition {
		private Shell shell;
		private Runnable closeRunnable;

		public ShellBlockCondition(Shell shell) {
			this.shell = shell;
			this.shell.addDisposeListener(new DisposeListener() {

				@Override
				public void widgetDisposed(DisposeEvent e) {
					unblock();
				}
			});
		}

		@Override
		public synchronized void unblock() {
			super.unblock();
			if( closeRunnable != null ) {
				closeRunnable.run();
			}
		}

		@Override
		public boolean isBlocked() {
			return super.isBlocked() && ! shell.isDisposed();
		}
	}

	public static class DefaultBlockCondition implements FBlockCondition {
		private boolean blocked = true;

		public synchronized void unblock() {
			this.blocked = false;
			notifyAll();
		}

		public synchronized boolean isBlocked() {
			return blocked;
		}

		synchronized void cleanLoop() {
			if( ! isBlocked() ) {
				Toolkit.getToolkit().exitNestedEventLoop(this, null);
				return;
			}
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					Toolkit.getToolkit().exitNestedEventLoop(DefaultBlockCondition.this, null);
				}
			});
		}
	}
}