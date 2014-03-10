package org.eclipse.fx.runtime.swtutil;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.sun.javafx.tk.Toolkit;

final class SWTFXUtil extends SWTUtil {

	private static SWTAppStart runnable;
	
	public void bootstrap(SWTAppStart runnable) {
		SWTFXUtil.runnable = runnable;
		Application.launch(FXApp.class);
	}
	
	public static class FXApp extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			final Display d = new Display();
			BlockCondition condition = runnable.createApp(d);
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
					SWTUtil.getInstance().block(d, condition);
					d.dispose();
				}
			} else {
				d.dispose();	
			}
		}
	}
	
	public void openBlocking(Shell shell) {
		Stage s = (Stage) shell.internal_getWindow();
		s.showAndWait();
	}
	
	public void block(Display d, BlockCondition condition) {
		final DefaultBlockCondition fCondition = (DefaultBlockCondition) condition;
		Thread t = new Thread() {
			@Override
			public void run() {
				fCondition.cleanLoop();
			}
		};
		t.setDaemon(true);
		t.start();
		Toolkit.getToolkit().enterNestedEventLoop(condition);
	}
	
	@Override
	public BlockCondition createShellBlockCondition(Shell shell) {
		return new ShellBlockCondition(shell);
	}
	
	@Override
	public BlockCondition createSimpleBlockCondition() {
		return new DefaultBlockCondition();
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
	
	public static class DefaultBlockCondition extends BlockCondition {
		private boolean blocked = true;
		
		public synchronized void unblock() {
			this.blocked = false;
			notifyAll();
		}
		
		public synchronized boolean isBlocked() {
			return blocked;
		}
		
		@SuppressWarnings("restriction")
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