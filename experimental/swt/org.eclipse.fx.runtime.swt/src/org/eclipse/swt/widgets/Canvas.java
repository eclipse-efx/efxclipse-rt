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

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.Region;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;


public class Canvas extends Composite {
	private Caret caret;
	private Region scrollable;

	private boolean focusListenerAttached;
	private javafx.scene.canvas.Canvas nativeCanvas;
	private IME ime;

	public Canvas(Composite parent, int style) {
		super(parent,style);
	}

	Canvas(Display display, int style) {
		super(display,style);
	}

	@Override
	protected Region createWidget() {
		scrollable = super.createWidget();
		return scrollable;
	}

	@Override
	protected FXLayoutPane internal_createLayoutPane() {
		return new FXLayoutPane(this) {
			@Override
			protected void layoutChildren() {
				super.layoutChildren();
				if( caret != null ) {
					Rectangle r = caret.getBounds();
					caret.internal_getNativeObject().resizeRelocate(r.x, r.y, r.width, r.height);
				}
			}
		};
	}

	public void setCaret(Caret caret) {
		if( this.caret != null ) {
			this.caret.internal_hide();
			((FXLayoutPane)internal_getNativeControl()).getChildren().remove(this.caret.internal_getNativeObject());
		}
		this.caret = caret;
		if( this.caret != null ) {
			if( ! focusListenerAttached ) {
				focusListenerAttached = true;
				scrollable.focusedProperty().addListener(getFocusChangeListener());
			}
			internal_enableFocusTraversable();
			if( scrollable.isFocused() ) {
				this.caret.internal_show();
			}
			((FXLayoutPane)internal_getNativeControl()).getChildren().add(this.caret.internal_getNativeObject());
		}
		internal_getNativeControl().layout();
	}

	public Caret getCaret() {
		return caret;
	}

	private InvalidationListener getFocusChangeListener() {
		return new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				if( caret != null ) {
					if( scrollable.isFocused() ) {
						caret.internal_show();
					} else {
						caret.internal_hide();
					}
				}
			}
		};
	}

	public void scroll (int destX, int destY, int x, int y, int width, int height, boolean all) {
//		nativeCanvas.getGraphicsContext2D().translate(destX - x, destY - y);
//		nativeCanvas.getGraphicsContext2D().save();
		redraw();
	}

	@Override
	protected javafx.scene.canvas.Canvas internal_initCanvas() {
		javafx.scene.canvas.Canvas c = super.internal_initCanvas();
		if( nativeCanvas == null ) {
			nativeCanvas = c;
		}
		return c;
	}

	@Override
	protected double internal_getClientAreaWidth() {
		return internal_getNativeObject().getWidth();
	}

	 @Override
	protected double internal_getClientAreaHeight() {
		return internal_getNativeObject().getHeight();
	}

	public void drawBackground (GC gc, int x, int y, int width, int height) {
		Color bg = gc.getBackground();
		gc.setBackground(getBackground());
		gc.fillRectangle(x, y, width, height);
		gc.setBackground(bg);
	}

	public IME getIME () {
		return ime;
	}

	public void setIME (IME ime) {
		this.ime = ime;
	}
}