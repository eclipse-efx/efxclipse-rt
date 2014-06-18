package org.eclipse.fx.testcases.e4.lifecycle;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.fx.ui.services.sync.UISynchronize.BlockCondition;

@SuppressWarnings("restriction")
public class ApplicationLifecycle {
	@PostContextCreate
	boolean showStartUp(UISynchronize sync) {
		BlockCondition<Boolean> c = new BlockCondition<Boolean>();
		Stage s = new Stage();
		HBox hBox = new HBox();
		{
			Button b = new Button("Proceed");
			b.setOnAction((e) -> c.release(Boolean.TRUE));
			hBox.getChildren().add(b);
		}
		
		{
			Button b = new Button("Cancel");
			b.setOnAction((e) -> c.release(Boolean.FALSE));
			hBox.getChildren().add(b);
		}
		
		s.setScene(new Scene(hBox,200,200));
		s.show();
		Boolean rv = sync.block(c);
		s.close();
		
		return rv;
	}
}
