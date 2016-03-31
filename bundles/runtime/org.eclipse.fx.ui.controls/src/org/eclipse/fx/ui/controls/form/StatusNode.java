package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;

import javafx.beans.property.ReadOnlyProperty;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class StatusNode extends Region {
	private static PseudoClass error = PseudoClass.getPseudoClass("error");
	private static PseudoClass warning = PseudoClass.getPseudoClass("warning");
	private static PseudoClass ok = PseudoClass.getPseudoClass("ok");
	private static PseudoClass cancel = PseudoClass.getPseudoClass("cancel");

	static final String BASE_STYLESHEET = SimpleStatusDecorator.class.getResource("status-icon.css").toExternalForm(); //$NON-NLS-1$

	public StatusNode(ReadOnlyProperty<Status> statusProperty) {
		Label statusIcon = new Label();
		statusIcon.getStyleClass().add("status-icon"); //$NON-NLS-1$
		updatePseudoState(statusIcon, statusProperty.getValue());
		statusProperty.addListener( (o, ol, ne) -> {
			updatePseudoState(statusIcon, ne);
		});
		getChildren().add(statusIcon);
	}

	@Override
	public String getUserAgentStylesheet() {
		return BASE_STYLESHEET;
	}

	private static void updatePseudoState(Node statusIcon, Status status) {
		statusIcon.pseudoClassStateChanged(error, status.getState() == State.ERROR);
		statusIcon.pseudoClassStateChanged(warning, status.getState() == State.WARNING);
		statusIcon.pseudoClassStateChanged(ok, status.getState() == State.OK);
		statusIcon.pseudoClassStateChanged(cancel, status.getState() == State.CANCEL);
	}
}
