package org.eclipse.fx.text.ui.hover.internal;

import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.beans.Observable;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.stage.PopupWindow;
import javafx.stage.Screen;
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
		
		// sizing
		if (this.windowSizeRetriever != null) {
			Point2D size = this.windowSizeRetriever.get();
			
			double w = size.getX();
			double h = size.getY();
			
			this.root.layout();
			this.root.applyCss();
			
			w = Math.max(w, this.root.computeMinWidth(-1) + 30);
			h = Math.max(h, this.root.computeMinHeight(-1) + 20);
			
			this.root.setMinWidth(w);
			this.root.setMaxWidth(w);
			this.root.setPrefWidth(w);
			this.root.setMinHeight(h);
			this.root.setMaxHeight(h);
			this.root.setPrefHeight(h);
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
				y -= popupArea.getHeight() + this.lineHeight;
			}
		}
		
		// we pop
		setX(x);
		setY(y);
		super.show();
	}
	
}
