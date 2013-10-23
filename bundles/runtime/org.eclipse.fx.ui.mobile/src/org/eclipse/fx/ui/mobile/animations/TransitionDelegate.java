package org.eclipse.fx.ui.mobile.animations;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import org.eclipse.fx.ui.mobile.Card;

public abstract class TransitionDelegate {
	public void transitionTo(final BorderPane parent, final Card from, final Card to) {
		parent.setCenter(null);
		
		Bounds b = from.getBoundsInParent();
		to.resizeRelocate(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());

		parent.getChildren().add(0,to);
		parent.getChildren().add(1,from);
		
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
	
	public static TransitionDelegate fade() {
		return new TransitionDelegate() {
			
			@Override
			protected void resetProperties(Card from, Card to) {
				from.setOpacity(1);
				to.setOpacity(1);
			}
			
			@Override
			protected Animation createAndPrepareAnimation(Card from, Card to) {
				FadeTransition t = new FadeTransition(Duration.seconds(1));
				t.setNode(from);
				t.setInterpolator(Interpolator.EASE_BOTH);
				t.setFromValue(1.0);
				t.setToValue(0.0);
				return t;
			}
		};
	}
	
	public static TransitionDelegate zoomSlide() {
		return new TransitionDelegate() {
			
			@Override
			protected void resetProperties(Card from, Card to) {
				to.setTranslateX(0);
				to.setScaleX(1);
				to.setScaleY(1);
				
				from.setTranslateX(0);
				from.setScaleX(1);
				from.setScaleY(1);
				
				to.setEffect(null);
				from.setEffect(null);
			}
			
			@Override
			protected Animation createAndPrepareAnimation(Card from, Card to) {
				double deltaX = -from.getBoundsInLocal().getWidth();
				to.setTranslateX(-deltaX);
				
//				curNode.setEffect(new DropShadow(2, 2, 2, Color.RED));
//				newNode.setEffect(new DropShadow(2, 2, 2, Color.RED));
				
				TranslateTransition slideFrom = translateTransition(from,deltaX);
				TranslateTransition slideTo = translateTransition(to,deltaX);
				
				ScaleTransition zoomOutFrom = scaleTransition(from, 0.7);
				ScaleTransition zoomOutTo = scaleTransition(from, 0.7);
				
				ScaleTransition zoomInFrom = scaleTransition(from, 1);
				ScaleTransition zoomInTo = scaleTransition(from, 1);
				
				return new SequentialTransition(
						new ParallelTransition(zoomOutFrom, zoomOutTo),
						new ParallelTransition(slideFrom, slideTo),
						new ParallelTransition(zoomInFrom, zoomInTo)
						);
			}
			
			private TranslateTransition translateTransition(Node node, double deltaX) {
				TranslateTransition t = new TranslateTransition(Duration.millis(300));
				t.setNode(node);
				t.setInterpolator(Interpolator.EASE_BOTH);
				t.setByX(deltaX);
				return t;
			}
			
			private ScaleTransition scaleTransition(Node node, double to) {
				ScaleTransition t = new ScaleTransition(Duration.millis(300));
				t.setNode(node);
				t.setToX(to);
				t.setToY(to);
				t.setInterpolator(Interpolator.EASE_BOTH);
				return t;
			}
		};
	}
}
