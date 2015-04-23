package org.eclipse.fx.ui.workbench.renderers.fx.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface LightweightDialogTransitionService {
	public void showDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node dialog, Runnable finished);
	public void hideDialog(MUIElement container, Pane containerNode, Pane dialogOverlayContainer, Node dialog, Runnable finished);
}
