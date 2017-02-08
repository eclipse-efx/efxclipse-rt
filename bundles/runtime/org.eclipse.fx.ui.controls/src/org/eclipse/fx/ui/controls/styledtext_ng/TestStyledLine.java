package org.eclipse.fx.ui.controls.styledtext_ng;

import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext_ng.internal.SingleCharStyledLineRendererFactory;
import org.eclipse.fx.ui.controls.styledtext_ng.internal.SingleTextStyledLineRendererFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestStyledLine extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox p = new VBox();
		StyledString ss = new StyledString();
		ss.appendSegment("public", "keyword");
		ss.appendSegment(" ", "default");
		ss.appendSegment("class", "keyword");
		ss.appendSegment(" Hello {", "default");

//		{
//			StyledLine l = new StyledLine(new SingleCharStyledLineRendererFactory());
//			l.setFont("monospace", 20);
//			l.setStyledString(ss);
//			p.getChildren().add(l);
//		}

		{
			StyledLine l = new StyledLine(new SingleTextStyledLineRendererFactory());
			l.setFont("monospace", 20);
			l.setStyledString(ss);
			p.getChildren().add(l);
		}


		Scene s = new Scene(p, 400,400);

		String changeColor = getClass().getResource("color-change.css").toExternalForm();

		ToggleButton b = new ToggleButton("Change Styles");
		b.setOnAction( e -> {
			if( s.getStylesheets().contains(changeColor) ) {
				s.getStylesheets().remove(changeColor);
			} else {
				s.getStylesheets().add(changeColor);
			}
		});
		p.getChildren().add(b);

		s.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
