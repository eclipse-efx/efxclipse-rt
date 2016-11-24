package org.eclipse.fx.text.ui.hover.internal;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.sun.javafx.scene.SceneHelper;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.PopupBuilder;
import javafx.stage.PopupWindow;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class ResizeablePopupWindow extends PopupWindow {

	private ResizeablePane root;
	
	private Consumer<Point2D> windowSizePersister;
	private Supplier<Point2D> windowSizeRetriever;
	
	public void configureWindowSize(Supplier<Point2D> windowSizeRetriever, Consumer<Point2D> windowSizePersister) {
		this.windowSizePersister = windowSizePersister;
		this.windowSizeRetriever = windowSizeRetriever;
	}
	
	public ResizeablePopupWindow(Node content) {
		this.root = new ResizeablePane();
		this.root.setContent(content);
		this.root.setWindow(this);
		
		this.root.widthProperty().addListener((x, o, n) -> {
			setWidth(n.doubleValue());
		});
		this.root.heightProperty().addListener((x, o, n) -> {
			setHeight(n.doubleValue());
		});
		
		this.getScene().setRoot(this.root);
		
		this.root.widthProperty().addListener(this::saveWindowSize);
		this.root.heightProperty().addListener(this::saveWindowSize);
	}
	
	private void saveWindowSize(Observable o) {
		if (this.windowSizePersister != null) {
			Point2D size = new Point2D(this.root.getWidth(), this.root.getHeight());
			this.windowSizePersister.accept(size);
		}
	}
	
	private double lineHeight = 20;
	
	public void show(Node ownerNode, double anchorX, double anchorY, double lineHeight) {
		this.lineHeight = lineHeight;
		super.show(ownerNode, anchorX, anchorY);
	}
	
	public void show(Window ownerWindow, double anchorX, double anchorY, double lineHeight) {
		this.lineHeight = lineHeight;
		super.show(ownerWindow, anchorX, anchorY);
	}
	
	@Override
	protected void show() {
		if (this.windowSizeRetriever != null) {
			Point2D size = this.windowSizeRetriever.get();
			this.root.setMinWidth(size.getX());
			this.root.setMaxWidth(size.getX());
			this.root.setPrefWidth(size.getX());
			this.root.setMinHeight(size.getY());
			this.root.setMaxHeight(size.getY());
			this.root.setPrefHeight(size.getY());
		}
		
		//positioning
		Screen screen = Screen.getScreensForRectangle(getAnchorX(), getAnchorY(), 0, 0).get(0);
		Rectangle2D popupArea = new Rectangle2D(getAnchorX(), getAnchorY(), this.root.getWidth(), this.root.getHeight());
		double x = getAnchorX();
		double y = getAnchorY();
		
		if (!screen.getVisualBounds().contains(popupArea)) {
			// reposition to the left 
			if (popupArea.getMaxX() > screen.getVisualBounds().getMaxX()) {
				x = screen.getVisualBounds().getMaxX() - popupArea.getWidth();
			}
			
			// reposition above
			if (popupArea.getMaxY() > screen.getVisualBounds().getMaxY()) {
				y -= popupArea.getHeight() + lineHeight;
			}
		}
		
		// we pop
		setX(x);
		setY(y);
		super.show();
	}
	
}
