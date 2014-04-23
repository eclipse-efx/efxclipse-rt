/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class Caret extends Widget {
	private Label nativeControl;
	
	private int x = 0;
	private int y = 0;
	private int width = 1;
	private int height = 1;
	private boolean isVisible;
	
	private Canvas parent;
	
	private Font font;
	private Image image;
	
	static final int DEFAULT_WIDTH	= 1;
	
	private Timeline blinkTimeline;
	
	public Caret(Canvas parent, int style) {
		super(parent.getDisplay(), style);
		this.parent = parent;
		parent.setCaret(this);
	}

	@Override
	protected Object createWidget() {
		nativeControl = new Label();
		nativeControl.setManaged(false);
		nativeControl.setVisible(false);
		nativeControl.setStyle("-fx-background-color: black;");
		
		blinkTimeline = new Timeline();
		blinkTimeline.setCycleCount(Timeline.INDEFINITE);
		blinkTimeline.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO,
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent event) {
                            	 nativeControl.setOpacity(0);
                             }
                         }),
            new KeyFrame(Duration.seconds(.5),
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent event) {
                            	 nativeControl.setOpacity(1);
                             }
                         }),
            new KeyFrame(Duration.seconds(1)));
		
		return nativeControl;
	}

	@Override
	public Node internal_getNativeObject() {
		return nativeControl;
	}
	
	public Rectangle getBounds () {
		Point l = getLocation();
		Point s = getSize();
		return new Rectangle(l.x, l.y, s.x, s.y);
	}

	public Font getFont () {
		if( font == null ) {
			return parent.getFont();
		}
		return font;
	}
	
	public Image getImage () {
		return image;
	}
	
	public Point getLocation () {
		return new Point(x, y);
	}
	
	public Canvas getParent () {
		return parent;
	}

	public Point getSize () {
		if( image == null ) {
			if( width == 0 ) {
				return new Point(DEFAULT_WIDTH, height);
			}
			return new Point(width, height);
		}
		
		Rectangle r = image.getBounds();
		return new Point(r.width, r.height);
	}
	
	public boolean getVisible () {
		return isVisible;
	}
	
	public boolean isVisible () {
		return isVisible && parent.isVisible() && parent.internal_getNativeObject().isFocused();
	}
	
	public void setBounds (int x, int y, int width, int height) {
		if( this.x == x && this.y == y && this.width == width && this.height == height ) {
			return;
		}
		this.x = x;
		this.y = y;
		this.width = Math.max(width,1);
		this.height = Math.max(height,1);
//		TODO How can we force a relayout??
		nativeControl.relocate(x, y);
//		getParent().internal_getNativeControl().layout();
	}
	
	public void setBounds (Rectangle rect) {
		setBounds(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void setFont (Font font) {
		this.font = font;
	}
	
	public void setImage (Image image) {
		this.image = image;
		nativeControl.setGraphic(image == null ? null : new ImageView(image.internal_getImage()));
		if( image == null ) {
			nativeControl.setBlendMode(null);
			nativeControl.setStyle("-fx-background-color: black;");
		} else {
			nativeControl.setBlendMode(BlendMode.DIFFERENCE);
			nativeControl.setStyle(null);
		}
	}
	
	public void setLocation (int x, int y) {
		setBounds(x, y, width, height);
	}
	
	public void setLocation (Point location) {
		setLocation(location.x, location.y);
	}
	
	public void setSize (int width, int height) {
		setBounds(x, y, width, height);
	}
	
	public void setSize (Point size) {
		setSize(size.x, size.y);
	}
	
	public void setVisible (boolean visible) {
		this.isVisible = visible;
	}
	
	void internal_hide() {
		nativeControl.setVisible(false);
		blinkTimeline.stop();
	}
	
	void internal_show() {
		if( ! nativeControl.isVisible() ) {
			nativeControl.setVisible(true);
			blinkTimeline.play();			
		}
	}
}
