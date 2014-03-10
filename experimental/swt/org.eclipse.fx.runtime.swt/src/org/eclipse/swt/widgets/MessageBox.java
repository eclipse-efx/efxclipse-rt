package org.eclipse.swt.widgets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.eclipse.swt.SWT;

public class MessageBox extends Dialog {
	private String message;
	private int type = SWT.CANCEL;
	private Stage stage;
	
	public MessageBox(Shell parent) {
		this (parent, SWT.OK | SWT.ICON_INFORMATION | SWT.APPLICATION_MODAL);
	}

	public MessageBox (Shell parent, int style) {
		super(parent, style);
	}
	
	public String getMessage () {
		return message;
	}
	
	
	public int open () {
		stage = new Stage();
		stage.initOwner(getParent().internal_getWindow());
		if( (getStyle() & SWT.APPLICATION_MODAL) == SWT.APPLICATION_MODAL ) {
			stage.initModality(Modality.APPLICATION_MODAL);	
		}
		
		VBox b = new VBox();
		b.getStyleClass().add("swt-message-box");
		Label l = new Label(message);
		l.getStyleClass().add(getImageStyle());
		b.getChildren().add(l);
		
		int mask = (SWT.YES | SWT.NO | SWT.OK | SWT.CANCEL | SWT.ABORT | SWT.RETRY | SWT.IGNORE);
		int bits = getStyle() & mask;
		
		HBox buttonsContainer = new HBox(5);
		
		switch (bits) {
		case SWT.OK:
		{
			Button button = new Button("Ok");
			button.setOnAction(new ActionHandler(SWT.OK));
			button.setDefaultButton(true);
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.CANCEL:
		{
			Button button = new Button("Cancel");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.CANCEL));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.OK | SWT.CANCEL:
		{
			Button button = new Button("Ok");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.OK));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("Cancel");
			button.setOnAction(new ActionHandler(SWT.CANCEL));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.YES:
		{
			Button button = new Button("Yes");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.YES));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.NO:
		{
			Button button = new Button("No");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.NO));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.YES | SWT.NO:
		{
			Button button = new Button("Yes");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.YES));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("No");
			button.setOnAction(new ActionHandler(SWT.NO));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.YES | SWT.NO | SWT.CANCEL:
		{
			Button button = new Button("Yes");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.YES));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("Cancel");
			button.setOnAction(new ActionHandler(SWT.CANCEL));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("No");
			button.setOnAction(new ActionHandler(SWT.NO));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.RETRY | SWT.CANCEL:
		{
			Button button = new Button("Retry");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.RETRY));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("Cancel");
			button.setOnAction(new ActionHandler(SWT.CANCEL));
			buttonsContainer.getChildren().add(button);
			break;
		}
		case SWT.ABORT | SWT.RETRY | SWT.IGNORE:
		{
			Button button = new Button("Abort");
			button.setDefaultButton(true);
			button.setOnAction(new ActionHandler(SWT.ABORT));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("Ignore");
			button.setOnAction(new ActionHandler(SWT.IGNORE));
			buttonsContainer.getChildren().add(button);
			
			button = new Button("Retry");
			button.setOnAction(new ActionHandler(SWT.RETRY));
			buttonsContainer.getChildren().add(button);
			break;
		}
		default:
			break;
		}
		
		BorderPane p = new BorderPane();
		p.setRight(buttonsContainer);
		b.getChildren().add(p);
		
		stage.setTitle(getText());
		
		Scene scene = new Scene(b);
		scene.getStylesheets().add(getClass().getClassLoader().getResource("org/eclipse/swt/internal/swt.css").toExternalForm());
		stage.setScene(scene);
		stage.showAndWait();
		
		return type;
	}
	
	private String getImageStyle() {
		if( (getStyle() & SWT.ICON_ERROR) == SWT.ICON_ERROR ) {
			return "swt-message-error";
		} else if( (getStyle() & SWT.ICON_QUESTION) == SWT.ICON_QUESTION ) {
			return "swt-message-question";
		} else if( (getStyle() & SWT.ICON_WARNING) == SWT.ICON_WARNING ) {
			return "swt-message-warning";
		} else if( (getStyle() & SWT.ICON_WORKING) == SWT.ICON_WORKING ) {
			return "swt-message-working";
		} else {
			return "swt-message-information";
		}
	}
	
	public void setMessage (String string) {
		this.message = string;
	}
	
	class ActionHandler implements EventHandler<ActionEvent> {
		private final int type;
		
		public ActionHandler(int type) {
			this.type = type;
		}
		
		@Override
		public void handle(ActionEvent event) {
			MessageBox.this.type = type;
			MessageBox.this.stage.close();
		}
		
	}
}
