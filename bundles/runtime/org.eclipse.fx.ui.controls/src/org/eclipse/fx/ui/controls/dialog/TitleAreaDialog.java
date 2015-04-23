package org.eclipse.fx.ui.controls.dialog;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TitleAreaDialog extends Dialog {
	public TitleAreaDialog(String frameTitle, String title, String message) {
		this(null, frameTitle, title, message);
	}
	
	public TitleAreaDialog(Node clientArea, String frameTitle, String title, String message) {
		super(new TitleAreaDialogPane(), clientArea, frameTitle);
		getDialogPane().titleProperty().set(title);
		getDialogPane().titleMessageProperty().set(message);
	}
	
	@Override
	protected TitleAreaDialogPane getDialogPane() {
		return (TitleAreaDialogPane) super.getDialogPane();
	}
	
	public static class TitleAreaDialogPane extends DefaultDialogContentPane {
		private final Label titleLabel;
		private final Label titleMessage;
		
		public TitleAreaDialogPane() {
			HBox box = new HBox();
			box.getStyleClass().add("efx-dialog-title-area");
			
			VBox messageArea = new VBox();
			messageArea.getStyleClass().add("efx-dialog-messageArea-area");
			
			this.titleLabel = new Label();
			this.titleLabel.getStyleClass().add("efx-dialog-title"); //$NON-NLS-1$
			
			this.titleMessage = new Label();
			this.titleMessage.setWrapText(true);
			this.titleMessage.getStyleClass().add("efx-dialog-title-message"); //$NON-NLS-1$
			
			messageArea.getChildren().add(this.titleLabel);
			messageArea.getChildren().add(this.titleMessage);
			
			HBox.setHgrow(messageArea, Priority.ALWAYS);
			
			ImageView titleImage = new ImageView();
			titleImage.getStyleClass().add("efx-dialog-title-image"); //$NON-NLS-1$
			box.getChildren().addAll(messageArea, titleImage);
			
			setTop(box);
		}
		
		public StringProperty titleProperty() {
			return this.titleLabel.textProperty();
		}
		
		public StringProperty titleMessageProperty() {
			return this.titleMessage.textProperty();
		}
	}
}
