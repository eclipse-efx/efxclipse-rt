package org.eclipse.fx.testcases.e4.lifecycle;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.fx.ui.services.restart.LifecycleRV;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.fx.ui.services.sync.UISynchronize.BlockCondition;

@SuppressWarnings("restriction")
public class ApplicationLifecycle {
	@PostContextCreate
	LifecycleRV showStartUp(UISynchronize sync) {
		BlockCondition<LifecycleRV> c = new BlockCondition<>();
		Stage s = new Stage();
		VBox box = new VBox();
		{
			Button b = new Button("Continue");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> c.release(LifecycleRV.CONTINUE));
			box.getChildren().add(b);
		}
		{
			Button b = new Button("Shutdown");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> c.release(LifecycleRV.SHUTDOWN));
			box.getChildren().add(b);
		}
		{
			Button b = new Button("Restart");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> c.release(LifecycleRV.RESTART));
			box.getChildren().add(b);
		}
		{
			Button b = new Button("Restart with cleared State");
			b.setMaxWidth(Double.MAX_VALUE);
			b.setOnAction((e) -> c.release(LifecycleRV.RESTART_CLEAR_STATE));
			box.getChildren().add(b);
		}
		
		s.setScene(new Scene(box,200,200));
		s.show();
		LifecycleRV rv = sync.block(c);
		s.close();
		
		return rv;
	}
}
