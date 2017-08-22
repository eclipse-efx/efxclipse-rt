package org.eclipse.fx.ui.controls.styledtext_ng;

import org.eclipse.fx.core.text.AnnotatedString;
import org.eclipse.fx.core.text.AnnotatedString.Builder;
import org.eclipse.fx.ui.controls.styledtext_ng.internal.SingleTextGradientStyledLineRendererFactory;
import org.eclipse.fx.ui.controls.styledtext_ng.internal.SingleTextStyledLineRendererFactory;
import org.eclipse.jdt.annotation.NonNull;

import javafx.application.Application;
import javafx.scene.Scene;
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
		Builder<@NonNull String> builder = AnnotatedString.create(String.class, 10);

		AnnotatedString<String> ss = builder
			.add("public", "keyword")
			.add(" ", "default")
			.add("class", "keyword")
			.add(" Hello ", "default")
			.add("implements", "keyword")
			.add(" Serializable ","default")
			.add("/* Allow to serialize */","comment")
			.add(" {", "default")
			.build();
		{
			StyledLine l = new StyledLine(new SingleTextStyledLineRendererFactory());
			l.setFont("Courier New", 40);
//			l.setVisibleRange(30, 1000);
			l.setText(ss);
			p.getChildren().add(l);
		}

		{
			StyledLine l = new StyledLine(new SingleTextGradientStyledLineRendererFactory());
			l.setFont("Courier New", 40);
			l.setText(ss);
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
