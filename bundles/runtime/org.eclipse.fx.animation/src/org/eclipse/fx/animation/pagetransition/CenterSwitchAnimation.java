package org.eclipse.fx.animation.pagetransition;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public abstract class CenterSwitchAnimation {

	protected ImageView imageView = null;
	
	public void animate(final BorderPane pane, final Node newNode) {
		
		final Node curNode = pane.getCenter();
		
		pane.setCenter(null);
		
		Bounds b = curNode.getBoundsInParent();
		newNode.resizeRelocate(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());

		pane.getChildren().add(0,newNode);
		pane.getChildren().add(1,curNode);
		
		if (imageView != null) {
			pane.getChildren().add(0,imageView);
		}
		
		Animation animation = createAndPrepareAnimation(curNode, newNode);
		
		animation.onFinishedProperty().set(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				pane.getChildren().remove(curNode);
				pane.getChildren().remove(newNode);
				pane.setCenter(newNode);
				resetProperties(curNode, newNode);
				
				if (imageView != null) {
					pane.getChildren().remove(imageView);
				}
			}
		});
		
		animation.play();
		
	}
	
	protected abstract Animation createAndPrepareAnimation(Node curNode, Node newNode);
	protected abstract void resetProperties(Node curNode, Node newNode);
}
