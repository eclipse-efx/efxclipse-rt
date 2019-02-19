package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.osgi.service.component.annotations.Component;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.control.Tooltip;

@Component
public class GraphicDecorator implements NodeDecorator {
	static final String BASE_STYLESHEET = GraphicDecorator.class.getResource("graphic-status-decorator.css").toExternalForm(); //$NON-NLS-1$

	public enum Location {
		TOP_LEFT,
		TOP_RIGHT,
		BOTTOM_LEFT,
		BOTTOM_RIGHT
	}

//	public interface LocationProvider extends Predicate<Control> {
//		public Location getLocation(Control node);
//	}

	private Location location;

	public GraphicDecorator() {
		this(Location.TOP_LEFT);
	}

	public GraphicDecorator(Location location) {
		this.location = location;
	}

	@Override
	public DecoratedNode decorate(Node node) {
		if( node instanceof Control ) {
			return new GraphicDecoratedControl((Control) node, this.location);
		}
		throw new IllegalArgumentException("Unable to decorate '"+node+"'");  //$NON-NLS-1$//$NON-NLS-2$
	}

	static class GraphicDecoratedControl implements DecoratedNode {
		private final Label icon;
		private final ObjectProperty<Status> statusProperty = new SimpleObjectProperty<>(this, "status", Status.ok()); //$NON-NLS-1$

		private static PseudoClass error = PseudoClass.getPseudoClass("error"); //$NON-NLS-1$
		private static PseudoClass warning = PseudoClass.getPseudoClass("warning"); //$NON-NLS-1$
		private static PseudoClass ok = PseudoClass.getPseudoClass("ok"); //$NON-NLS-1$
		private static PseudoClass cancel = PseudoClass.getPseudoClass("cancel"); //$NON-NLS-1$

		public GraphicDecoratedControl(Control c, Location location) {
			this.icon = new Label() {
				@Override
				public String getUserAgentStylesheet() {
					return BASE_STYLESHEET;
				}
			};
			this.icon.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			this.icon.getStyleClass().add("status-decorator-icon"); //$NON-NLS-1$
			this.icon.setManaged(false);

			if( c.getSkin() != null ) {
				((SkinBase<?>)c.getSkin()).getChildren().add(this.icon);
			}

			c.skinProperty().addListener( ( ob, ol, ne ) -> {
				if( ol != null ) {
					((SkinBase<?>)ol).getChildren().remove(this.icon);
				}

				if( ne != null ) {
					((SkinBase<?>)ne).getChildren().add(this.icon);
				}
			});

			if( location == Location.TOP_LEFT ) {
				this.icon.layoutXProperty().bind(this.icon.widthProperty().divide(-2));
				this.icon.layoutYProperty().bind(this.icon.heightProperty().divide(-2));
			} else if( location == Location.TOP_RIGHT ) {
				this.icon.layoutXProperty().bind(Bindings.createDoubleBinding(() -> {
					return Double.valueOf(c.getWidth() - this.icon.widthProperty().get() / 2);
				},this.icon.widthProperty(), c.widthProperty()));
				this.icon.layoutYProperty().bind(this.icon.heightProperty().divide(-2));
			} else if( location == Location.BOTTOM_LEFT ) {
				this.icon.layoutXProperty().bind(this.icon.widthProperty().divide(-2));
				this.icon.layoutYProperty().bind(Bindings.createDoubleBinding(() -> {
					return Double.valueOf(c.getHeight() - this.icon.heightProperty().get() / 2);
				}, this.icon.heightProperty(), c.heightProperty()));
			} else if( location == Location.BOTTOM_RIGHT ) {
				this.icon.layoutXProperty().bind(Bindings.createDoubleBinding(() -> {
					return Double.valueOf(c.getWidth() - this.icon.widthProperty().get() / 2);
				},this.icon.widthProperty(), c.widthProperty()));
				this.icon.layoutYProperty().bind(Bindings.createDoubleBinding(() -> {
					return Double.valueOf(c.getHeight() - this.icon.heightProperty().get() / 2);
				}, this.icon.heightProperty(), c.heightProperty()));
			}

			// FIXME Platform.runLater is not perfectly correct, we should become part of the layout bus
			Platform.runLater(() -> updatePseudoState(this.icon, this.statusProperty.getValue()));
			this.statusProperty.addListener( (o, ol, ne) -> {
				updatePseudoState(this.icon, ne);
			});

			this.icon.translateXProperty().addListener( o -> {
				System.err.println(this.icon.translateXProperty().get());
			});
		}

		private static void updatePseudoState(Label statusIcon, Status status) {
			statusIcon.pseudoClassStateChanged(error, status != null && status.getState() == State.ERROR);
			statusIcon.pseudoClassStateChanged(warning, status != null && status.getState() == State.WARNING);
			statusIcon.pseudoClassStateChanged(ok, status == null || status.getState() == State.OK);
			statusIcon.pseudoClassStateChanged(cancel, status != null && status.getState() == State.CANCEL);
			statusIcon.autosize();
			if( statusIcon.getTooltip() == null ) {
				if( status != null && status.getState() != State.OK ) {
					statusIcon.setTooltip(new Tooltip(status.getMessage()));
				}
			} else {
				statusIcon.getTooltip().setText(status == null ? "" : status.getMessage()); //$NON-NLS-1$
			}
		}

		@Override
		public ObjectProperty<Status> statusProperty() {
			return this.statusProperty;
		}

		@Override
		public void setStatus(Status status) {
			statusProperty().set(status);
		}

		@Override
		public Status getStatus() {
			return statusProperty().get();
		}
	}
}
