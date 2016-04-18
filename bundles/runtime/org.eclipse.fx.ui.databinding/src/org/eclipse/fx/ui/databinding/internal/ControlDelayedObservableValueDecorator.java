package org.eclipse.fx.ui.databinding.internal;

import org.eclipse.core.databinding.observable.value.IObservableValue;

import javafx.beans.Observable;
import javafx.scene.Node;

public class ControlDelayedObservableValueDecorator extends ControlObservableValueDecorator {
	private final Node control;

	public ControlDelayedObservableValueDecorator(IObservableValue decorated, Node control) {
		super(decorated);
		this.control = control;
		control.focusedProperty().addListener( this::handleFocusChange );
	}

	private void handleFocusChange(Observable o) {
		if( ! this.control.focusedProperty().get()
				&& isStale() ) {
			getValue();
		}
	}


	@Override
	public synchronized void dispose() {
		this.control.focusedProperty().removeListener(this::handleFocusChange);
		super.dispose();
	}
}
