package org.eclipse.fx.text.ui.source;

import java.util.Set;
import java.util.function.BiConsumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jface.text.source.Annotation;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public interface ILineRulerAnnotationPresenter extends IAnnotationPresenter {

	enum LayoutHint {
		ALIGN_LEFT,
		ALIGN_RIGHT,
		ALIGN_CENTER;
	}

	int getOrder();

	void updateNode(Node node, Set<Annotation> annotation);

	LayoutHint getLayoutHint();

	DoubleProperty getWidth();


	public static interface LineRuler {
		Subscription subscribeMousePressed(BiConsumer<Integer, MouseEvent> callback);
		Subscription subscribeMouseReleased(BiConsumer<Integer, MouseEvent> callback);
		Subscription subscribeMouseClicked(BiConsumer<Integer, MouseEvent> callback);
	}

	default void initialize(LineRuler lineRuler) {}

}
