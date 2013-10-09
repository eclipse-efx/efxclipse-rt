package org.eclipse.fx.ui.mobile.animations;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import org.eclipse.fx.ui.mobile.Card;

public abstract class TransitionDelegate {
	public void transitionTo(final BorderPane parent, final Card from, final Card to) {
		parent.setCenter(null);
		
		Bounds b = from.getBoundsInParent();
		to.resizeRelocate(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());

		parent.getChildren().add(0,from);
		parent.getChildren().add(1,to);
		
		Animation animation = createAndPrepareAnimation(from, to);
		
		animation.onFinishedProperty().set(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				parent.getChildren().remove(from);
				parent.getChildren().remove(to);
				parent.setCenter(to);
				resetProperties(from, to);				
			}
		});
		
		animation.play();
	}
	
	protected abstract Animation createAndPrepareAnimation(Card from, Card to);
	protected abstract void resetProperties(Card from, Card to);
	
	public static TransitionDelegate slideLeft() {
		return new TransitionDelegate() {
			
			@Override
			protected void resetProperties(Card from, Card to) {
				to.setTranslateX(0);
				from.setTranslateX(0);
			}
			
			@Override
			protected Animation createAndPrepareAnimation(Card from, Card to) {
				from.setOpacity(1);
				
				double deltaX = -from.getBoundsInLocal().getWidth();
				to.setTranslateX(-deltaX);
				
				return new ParallelTransition(createTransition(deltaX, from), createTransition(deltaX, to));
			}
			
			private TranslateTransition createTransition(double deltaX, Card node) {
				TranslateTransition t = new TranslateTransition(new Duration(1000));
				t.setInterpolator(Interpolator.EASE_BOTH);
				t.setByX(deltaX);
				t.setNode(node);
				return t;
			}
		};
	}
	
	public static TransitionDelegate slideRight() {
		return new TransitionDelegate() {
			
			@Override
			protected void resetProperties(Card from, Card to) {
				to.setTranslateX(0);
				from.setTranslateX(0);
			}
			
			@Override
			protected Animation createAndPrepareAnimation(Card from, Card to) {
				from.setOpacity(1);
				
				double deltaX = from.getBoundsInLocal().getWidth();
				to.setTranslateX(-deltaX);
				
				return new ParallelTransition(createTransition(deltaX, from), createTransition(deltaX, to));
			}
			
			private TranslateTransition createTransition(double deltaX, Card node) {
				TranslateTransition t = new TranslateTransition(new Duration(1000));
				t.setInterpolator(Interpolator.EASE_BOTH);
				t.setByX(deltaX);
				t.setNode(node);
				return t;
			}
		};
	}
	
}
