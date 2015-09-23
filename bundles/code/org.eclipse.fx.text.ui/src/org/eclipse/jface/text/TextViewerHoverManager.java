package org.eclipse.jface.text;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

import javafx.scene.layout.BorderPane;
import javafx.stage.PopupWindow;

public class TextViewerHoverManager {
	private final TextViewer textViewer;
	private final PopupWindow popup;
	private final BorderPane root;

	public TextViewerHoverManager(TextViewer textViewer) {
		this.textViewer = textViewer;
		this.popup = new PopupWindow() {
		};
		this.popup.setAutoFix(false);
		this.popup.setAutoHide(false);
		this.textViewer.getTextWidget().sceneProperty().addListener( e -> {
			if( textViewer.getTextWidget().getScene() != null ) {
				popup.getScene().getStylesheets().setAll(textViewer.getTextWidget().getScene().getStylesheets());
			}

		});
		root = new BorderPane();
		root.getStyleClass().add("styled-text-hover");
		popup.getScene().setRoot(root);
	}

	public void install(StyledTextArea styledTextArea) {
//		styledTextArea.addEventHandler(TextHoverEvent.HOVER, e -> {
//			if( e.getOffset() > 0 ) {
//				final ITextHover hover= textViewer.getTextHover(e.getOffset(), /*getHoverEventStateMask()*/ ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
//				if( hover != null ) {
//					String text = hover.getHoverInfo(textViewer, hover.getHoverRegion(textViewer, e.getOffset()));
//					if( text != null && ! text.isEmpty() ) {
//						Label value = new Label(text);
//						value.getStyleClass().add("styled-text-hover-text");
//						root.setCenter(value);
//						Point2D locationAtOffset = textViewer.getTextWidget().getLocationAtOffset(e.getOffsetTokenStart());
//						double x = e.getScreenX();
//						if( locationAtOffset != null ) {
//							x = textViewer.getTextWidget().localToScreen(locationAtOffset.getX(),0).getX();
//						}
//						popup.show(textViewer.getTextWidget().getScene().getWindow(), x, e.getScreenY()+5);
//					} else {
//						popup.hide();
//					}
//				} else {
//					popup.hide();
//				}
//			} else {
//				popup.hide();
//			}
//		});
	}
}
