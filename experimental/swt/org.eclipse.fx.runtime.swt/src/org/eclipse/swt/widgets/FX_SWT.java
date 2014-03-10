package org.eclipse.swt.widgets;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;

public class FX_SWT {
	public static Composite new_Composite(AnchorPane pane) {
		Composite c = new FXSWTEmbed(Display.getCurrent(), SWT.NONE);
		c.setLayout(new FillLayout());
		
		Region n = c.internal_getNativeObject();
		AnchorPane.setBottomAnchor(n, 0.0);
		AnchorPane.setTopAnchor(n, 0.0);
		AnchorPane.setLeftAnchor(n, 0.0);
		AnchorPane.setRightAnchor(n, 0.0);
		pane.getChildren().add(n);
		return c;
	}
	
	public static Composite new_Composite(BorderPane pane) {
		Composite c = new FXSWTEmbed(Display.getCurrent(), SWT.NONE);
		c.setLayout(new FillLayout());
		pane.setCenter(c.internal_getNativeObject());
		return c;
	}
	
	static class FXSWTEmbed extends Composite {
		private static Map<Stage, Shell> SHELL_MAP = new HashMap<>();
		FXSWTEmbed(Display display, int style) {
			super(display, style);
		}
		
		@Override
		public Shell getShell() {
			Shell s = null;
			if( internal_getNativeObject().getScene() != null && internal_getNativeObject().getScene().getWindow() != null ) {
				final Stage w = (Stage) internal_getNativeObject().getScene().getWindow();
				s = SHELL_MAP.get(w);
				if( s == null ) {
					s = new Shell(w);
					w.setOnHidden(new EventHandler<WindowEvent>() {
						
						@Override
						public void handle(WindowEvent event) {
							SHELL_MAP.remove(w);
						}
					});	
				}
			}
			return s;
		}
	}
}
