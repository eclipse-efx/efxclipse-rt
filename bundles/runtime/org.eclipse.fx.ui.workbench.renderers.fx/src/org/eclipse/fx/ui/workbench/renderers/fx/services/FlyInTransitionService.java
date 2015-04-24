package org.eclipse.fx.ui.workbench.renderers.fx.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FlyInTransitionService implements LightweightDialogTransitionService {

	@Override
	public void showDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node dialog, Runnable finished) {
		TranslateTransition t = new TranslateTransition(Duration.millis(700),dialog);
		t.setFromY(-1 * (dialog.getLayoutX() + dialog.maxHeight(-1)));
		t.setToY(0);
		t.setInterpolator(Interpolator.EASE_OUT);
		if( finished != null ) {
			t.setOnFinished( e -> {
				finished.run();
			});
		}
		t.play();
	}

	@Override
	public void hideDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node dialog, Runnable finished) {
		TranslateTransition t = new TranslateTransition(Duration.millis(700),dialog);
		t.setFromY(0);
		t.setToY(-1 * (dialog.getLayoutX() + dialog.maxHeight(-1)));
		t.setInterpolator(Interpolator.EASE_OUT);
		if( finished != null ) {
			t.setOnFinished( e -> {
				finished.run();
			});
		}
		t.play();
	}
}
