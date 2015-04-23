package org.eclipse.fx.ui.controls.dialog;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.ui.controls.stage.DefaultFramePane;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class Dialog extends DefaultFramePane {
	private final DialogContentPane dialogPane;
	
	public Dialog(Node clientArea, String frameTitle) {
		this(new DefaultDialogContentPane(),clientArea,frameTitle);
	}
	
	public <D extends Pane & DialogContentPane> Dialog(D pane, Node clientArea, String frameTitle) {
		super(pane,true);
		this.dialogPane = pane;
		this.dialogPane.setActionConsumer(this::handleButtonPress);
		setClientArea(clientArea);
		this.setTitle(frameTitle);
		getStyleClass().add("efx-dialog");
	}
	
	@Override
	protected final void requestCancelClose() {
		handleCancel();
	}
	
	protected void handleButtonPress(DialogButton button) {
		if( button.type == ButtonType.OK ) {
			handleOk();
		} else if( button.type == ButtonType.CANCEL ) {
			handleCancel();
		}
	}
	
	protected void handleOk() {
		close();
	}
	
	protected void handleCancel() {
		close();
	}
	
	protected DialogContentPane getDialogPane() {
		return this.dialogPane;
	}
	
	public ObservableList<DialogButton> getButtonList() {
		return this.dialogPane.getButtonList();
	}
	
	@Override
	protected void updateClientArea(ObservableValue<? extends Node> o, Node oldClientArea, Node newClientArea) {
		this.dialogPane.getDialogContentNodeProperty().set(newClientArea);
	}
	
	public static class DialogButton {
		public String label;
		private ButtonType type;
		
		DialogButton(ButtonType type, String label) {
			this.type = type;
			this.label = label;
		}
		
		public DialogButton(String label) {
			this(ButtonType.CUSTOM,label);
		}
	}
	
	public DialogButton createOKButton() {
		return new DialogButton(ButtonType.OK, "OK");
	}
	
	public DialogButton createCancelButton() {
		return new DialogButton(ButtonType.CANCEL, "Cancel");
	}
	
	public static enum ButtonType {
		OK,
		CANCEL,
		CUSTOM
	}

	public interface DialogContentPane {
		ObjectProperty<Node> getDialogContentNodeProperty();
		ObservableList<DialogButton> getButtonList();
		void setActionConsumer(Consumer<DialogButton> actionConsumer);
	}
	
	public static class DefaultDialogContentPane extends BorderPane implements DialogContentPane {
		private final GridLayoutPane buttonArea = new GridLayoutPane();
		private final ObservableList<DialogButton> buttonList = FXCollections.observableArrayList();
		private Consumer<DialogButton> actionConsumer;
		private BorderPane clientAreaContainer = new BorderPane();
		
		public DefaultDialogContentPane() {
			getStyleClass().add("efx-dialog-pane");
			buttonArea.setMakeColumnsEqualWidth(true);
			
			this.buttonList.addListener( (javafx.collections.ListChangeListener.Change<? extends DialogButton> c) -> {
				buttonArea.setNumColumns(buttonList.size());
				while( c.next() ) {
					if( c.wasAdded() ) {
						this.buttonArea.getChildren().addAll(c.getFrom(),c.getAddedSubList().stream().map( b -> {
							Button bu = new Button(b.label);
							bu.setOnAction( e -> actionConsumer.accept(b));
							GridLayoutPane.setConstraint(bu, new GridData(Alignment.FILL, Alignment.FILL, false, false));
							return bu;
						}).collect(Collectors.toList()));
					}
					if( c.wasRemoved() ) {
						this.buttonArea.getChildren().removeIf( b -> c.getRemoved().contains(b.getUserData()));
					}
				}
			});
			BorderPane.setAlignment(this.buttonArea, Pos.BOTTOM_RIGHT);
			HBox box = new HBox(this.buttonArea);
			box.getStyleClass().add("efx-dialog-button-area");
			box.setAlignment(Pos.CENTER_RIGHT);
			setBottom(box);
			BorderPane.setAlignment(this.buttonArea, Pos.BOTTOM_RIGHT);
			
			clientAreaContainer = new BorderPane();
			clientAreaContainer.getStyleClass().add("efx-dialog-client-area");
			setCenter(clientAreaContainer);
		}
		
		public void setActionConsumer(Consumer<DialogButton> actionConsumer) {
			this.actionConsumer = actionConsumer;
		}
		
		@Override
		public ObservableList<DialogButton> getButtonList() {
			return this.buttonList;
		}
		
		@Override
		public ObjectProperty<Node> getDialogContentNodeProperty() {
			return clientAreaContainer.centerProperty();
		}
		
		@Override
		public String getUserAgentStylesheet() {
			return Dialog.class.getResource("dialog.css").toExternalForm(); //$NON-NLS-1$
		}
	}
	
	protected void addDefaultButtons() {
		getButtonList().addAll(
				createOKButton(),
				createCancelButton());
	}
	
	public static Dialog createSimpleDialog(Node clientArea, String frameTitle) {
		Dialog d = new Dialog(clientArea,frameTitle);
		d.addDefaultButtons();
		return d;
	}
}