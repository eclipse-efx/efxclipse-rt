/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.BufferedImageGC;
import org.eclipse.swt.internal.CanvasGC;
import org.eclipse.swt.internal.Util;


public class Composite extends Scrollable {

	private List<Control> children = new ArrayList<Control>();

	private FXLayoutPane controlContainer;

	private ToggleGroup group;

	private Layout layout;

	private AnchorPane scrollable;

	private Canvas canvas;

	private static final double SCROLLBAR_WIDTH = 20.0;

	private ScrollBar vScroll;
	private ScrollBar hScroll;
	private Node corner;

	private Menu menu;

	private String tooltipText;
	private Tooltip tooltip;

	private static EventHandler<MouseEvent> FOCUS_HANDLER;
	private static EventHandler<ContextMenuEvent> CONTEXT_MENU_HANDLER;

	public Composite(Composite parent, int style) {
		super(parent,style);
	}


	Composite(Display display, int style) {
		super(display,style);
	}

	@Override
	protected Region createWidget() {
		scrollable = new AnchorPane() {
			@Override
			protected void layoutChildren() {
				super.layoutChildren();
				double endCorrection = 0;
				if( corner != null && vScroll.getVisible() && hScroll.getVisible() ) {
					endCorrection = SCROLLBAR_WIDTH;
				}

				if( vScroll != null ) {
					vScroll.internal_getNativeObject().resizeRelocate(getWidth()-SCROLLBAR_WIDTH, 0, SCROLLBAR_WIDTH, getHeight()-endCorrection);
				}

				if( hScroll != null ) {
					hScroll.internal_getNativeObject().resizeRelocate(0, getHeight()-SCROLLBAR_WIDTH, getWidth()-endCorrection, SCROLLBAR_WIDTH);
				}

				if( corner != null ) {
					if( hScroll.getVisible() && vScroll.getVisible() ) {
						corner.setVisible(true);
					} else {
						corner.setVisible(false);
					}
					corner.resizeRelocate(getWidth()-SCROLLBAR_WIDTH, getHeight()-SCROLLBAR_WIDTH, SCROLLBAR_WIDTH, SCROLLBAR_WIDTH);
				}

			}
		};
		javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle();
		r.widthProperty().bind(scrollable.widthProperty());
		r.heightProperty().bind(scrollable.heightProperty());
		scrollable.setClip(r);

		scrollable.getStyleClass().add(getStyleClassname());
		controlContainer = internal_createLayoutPane();
		registerConnection(controlContainer);

		AnchorPane.setLeftAnchor(controlContainer, 0.0);
		AnchorPane.setTopAnchor(controlContainer, 0.0);

		scrollable.getChildren().add(controlContainer);

		if( (style & SWT.V_SCROLL) == SWT.V_SCROLL ) {
			AnchorPane.setRightAnchor(controlContainer, SCROLLBAR_WIDTH);
			vScroll = new ScrollBar(this,SWT.VERTICAL);
			Node n = vScroll.internal_getNativeObject();
			n.setManaged(false);
			scrollable.getChildren().add(n);
		} else {
			AnchorPane.setRightAnchor(controlContainer, 0.0);
		}

		if( (style & SWT.H_SCROLL) == SWT.H_SCROLL ) {
			AnchorPane.setBottomAnchor(controlContainer, SCROLLBAR_WIDTH);
			hScroll = new ScrollBar(this,SWT.HORIZONTAL);
			Node n = hScroll.internal_getNativeObject();
			n.setManaged(false);
			scrollable.getChildren().add(n);
		} else {
			AnchorPane.setBottomAnchor(controlContainer, 0.0);
		}

		if( hScroll != null && vScroll != null ) {
			corner = new StackPane();
	        corner.getStyleClass().setAll("corner");
	        scrollable.getChildren().add(corner);
		}

		applyBorderStyle();

		return scrollable;
	}

	protected FXLayoutPane internal_createLayoutPane() {
		return new FXLayoutPane(this);
	}

	protected void applyBorderStyle() {
		if( (style & SWT.BORDER) == SWT.BORDER && internal_getNativeObject() != null ) {
			internal_getNativeObject().setStyle("-fx-boder-style: solid; -fx-border-width: 1px; -fx-border-color: gray;");
		}
	}

	protected String getStyleClassname() {
		return "swt-composite";
	}

	@Override
	public Region internal_getNativeObject() {
		return scrollable;
	}

	@Override
	public Region internal_getNativeControl() {
		return controlContainer == null ? super.internal_getNativeControl() : controlContainer;
	}

	public void internal_controlAdded(Control c) {
		if( c instanceof Button && (c.getStyle() & SWT.RADIO) == SWT.RADIO && (getStyle() & SWT.NO_RADIO_GROUP) != SWT.NO_RADIO_GROUP ) {
			if( group == null ) {
				group = new ToggleGroup();
			}
			group.getToggles().add((Toggle) c.internal_getNativeObject());
		}
		children.add(c);
		internal_attachControl(c);
	}

	public void internal_controlAdded(int index, Control c) {
		if( c instanceof Button && (c.getStyle() & SWT.RADIO) == SWT.RADIO && (getStyle() & SWT.NO_RADIO_GROUP) != SWT.NO_RADIO_GROUP ) {
			if( group == null ) {
				group = new ToggleGroup();
			}
			group.getToggles().add(index,(Toggle) c.internal_getNativeObject());
		}
		children.add(index, c);
		internal_attachControl(index,c);
	}

	public void internal_controlRemoved(Control c) {
		if( c instanceof Button && (c.getStyle() & SWT.RADIO) == SWT.RADIO && (getStyle() & SWT.NO_RADIO_GROUP) != SWT.NO_RADIO_GROUP ) {
			if( group != null ) {
				group.getToggles().remove(c.internal_getNativeObject());
			}
		}
		children.remove(c);
		internal_detachControl(c);
	}

	public void internal_controlMoveAbove(Control control, Control reference) {
		System.err.println("SELF: " + control);
		System.err.println("REF: " + reference);
		System.err.println("PRE REMOVE: " + children.size());
		internal_controlRemoved(control);
		System.err.println("POST REMOVE: " + children.size());

		if( reference == null ) {
			internal_controlAdded(control);
		} else {
			for( int i = 0; i < children.size(); i++ ) {
				if( children.get(i) == reference ) {
					int idx = i+1;
					if( idx < children.size() ) {
						internal_controlAdded(idx, control);
					} else {
						internal_controlAdded(control);
					}
					return;
				}
			}
		}
	}

	public void internal_controlMoveBelow(Control control, Control reference) {
		System.out.println("SELF: " + control);
		System.out.println("REF: " + reference);
		System.out.println("PRE REMOVE: " + children.size());
		internal_controlRemoved(control);
		System.out.println("POST REMOVE: " + children.size());

		if( reference == null ) {
			internal_controlAdded(control);
		} else {
			for( int i = 0; i < children.size(); i++ ) {
				if( children.get(i) == reference ) {
					int idx = i;
					if( idx < children.size() ) {
						internal_controlAdded(idx, control);
					} else {
						internal_controlAdded(control);
					}
					return;
				}
			}
		}
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
		internal_setLayout(layout);
	}

	public Rectangle getClientArea() {
		forceSizeProcessing();
//		System.err.println(internal_getNativeObject().getHeight());
//		System.err.println(scrollable.getHeight());
		return new Rectangle(0, 0, (int)internal_getClientAreaWidth(), (int)internal_getClientAreaHeight());
	}

	public Control[] getChildren() {
		return children.toArray(new Control[0]);
	}

	public Point computeSize(int wHint, int hHint, boolean flushCache) {
		forceSizeProcessing();
		int width;
		int height;

		if( layout != null ) {
			Point size = layout.computeSize(this, wHint, hHint, flushCache);
			Rectangle trim = computeTrim (0, 0, size.x, size.y);
			width = trim.width;
			height = trim.height;
		} else {
			width = (int) Math.ceil(internal_getPrefWidth());
			height = (int) Math.ceil(internal_getPrefHeight());
		}

		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;

		return new Point(width, height);
	}

	protected double internal_getPrefWidth() {
		return ((Region)internal_getNativeObject()).prefWidth(-1);
	}

	protected double internal_getPrefHeight() {
		return ((Region)internal_getNativeObject()).prefHeight(-1);
	}

	protected double internal_getClientAreaWidth() {
		if( controlContainer != null ) {
			return controlContainer.getWidth();
		}
		return internal_getWidth();
	}

	protected double internal_getClientAreaHeight() {
		if( controlContainer != null ) {
			return controlContainer.getHeight();
		}
		return internal_getHeight();
	}

	protected void internal_setLayout(Layout layout) {
		controlContainer.setLayout(layout);
	}

	protected void internal_attachControl(Control c) {
		controlContainer.getChildren().add(c.internal_getNativeObject());
	}

	protected void internal_attachControl(int idx, Control c) {
		controlContainer.getChildren().add(idx, c.internal_getNativeObject());
	}

	protected void internal_detachControl(Control c) {
		controlContainer.getChildren().remove(c.internal_getNativeObject());
	}

	protected void internal_doLayout() {
		controlContainer.layout();
	}

	public void setBackgroundMode (int mode) {
//FIXME IMPLEMENT FOR FX
		Util.logNotImplemented();
	}

	public int getBackgroundMode () {
		Util.logNotImplemented();
		return 0;
	}


	public void layout(Control[] changed) {
		layout (changed, SWT.NONE);
	}

	public void layout() {
		layout (true);
	}

	public void layout (boolean changed) {
		if (layout == null) return;
		layout (changed, false);
//		layout(getChildren(), SWT.NONE);
	}

	public void layout (boolean changed, boolean all) {
		if (layout == null && !all) return;
		markLayout (changed, all);
		updateLayout (all);
	}

	public void layout (Control [] changed, int flags) {
		if (changed != null) {
			for (int i=0; i<changed.length; i++) {
				Control control = changed [i];
				if (control == null) error (SWT.ERROR_INVALID_ARGUMENT);
				if (control.isDisposed ()) error (SWT.ERROR_INVALID_ARGUMENT);
				boolean ancestor = false;
				Composite composite = control.getParent();
				while (composite != null) {
					ancestor = composite == this;
					if (ancestor) break;
					composite = composite.getParent();
				}
				if (!ancestor) error (SWT.ERROR_INVALID_PARENT);
			}
			int updateCount = 0;
			Composite [] update = new Composite [16];
			for (int i=0; i<changed.length; i++) {
				Control child = changed [i];
				Composite composite = child.getParent();
				while (child != this) {
					if (composite.layout != null) {
						composite.state |= LAYOUT_NEEDED;
						if (!composite.layout.flushCache (child)) {
							composite.state |= LAYOUT_CHANGED;
						}
					}
					if (updateCount == update.length) {
						Composite [] newUpdate = new Composite [update.length + 16];
						System.arraycopy (update, 0, newUpdate, 0, update.length);
						update = newUpdate;
					}
					child = update [updateCount++] = composite;
					composite = child.getParent();
				}
			}
			if ((flags & SWT.DEFER) != 0) {
//				setLayoutDeferred (true);
//				display.addLayoutDeferred (this);
			}
			for (int i=updateCount-1; i>=0; i--) {
				update [i].updateLayout (false);
			}
		} else {
			if (layout == null && (flags & SWT.ALL) == 0) return;
//			markLayout ((flags & SWT.CHANGED) != 0, (flags & SWT.ALL) != 0);
//			if ((flags & SWT.DEFER) != 0) {
//				setLayoutDeferred (true);
//				display.addLayoutDeferred (this);
//			}
//			updateLayout ((flags & SWT.ALL) != 0);
		}
	}

	void updateLayout(boolean all) {
//		Composite parent = findDeferredControl ();
//		if (parent != null) {
//			parent.state |= LAYOUT_CHILD;
//			return;
//		}
		if ((state & LAYOUT_NEEDED) != 0) {
			boolean changed = (state & LAYOUT_CHANGED) != 0;
			state &= ~(LAYOUT_NEEDED | LAYOUT_CHANGED);
			getDisplay().runSkin ();
			layout.layout (this, changed);
		}
		if (all) {
			state &= ~LAYOUT_CHILD;
			Control [] children = this.children.toArray(new Control[0]);
			for (int i=0; i<children.length; i++) {
				if( children[i] instanceof Composite ) {
					((Composite)children [i]).updateLayout (all);
				}

			}
		}
	}

	void markLayout (boolean changed, boolean all) {
		if (layout != null) {
			state |= LAYOUT_NEEDED;
			if (changed) state |= LAYOUT_CHANGED;
		}
		if (all) {
			Control [] children = getChildren ();
			for (int i=0; i<children.length; i++) {
				children [i].markLayout (changed, all);
			}
		}
	}

	@Override
	public void addPaintListener(PaintListener listener) {
		super.addPaintListener(listener);
		internal_initCanvas();
	}

	@Override
	public void addListener(int eventType, Listener listener) {
		super.addListener(eventType, listener);
		if( eventType == SWT.Paint ) {
			internal_initCanvas();
		} else if( eventType == SWT.KeyDown || eventType == SWT.KeyUp ) {
			internal_enableFocusTraversable();
		}
	}

	void internal_enableFocusTraversable() {
		if( scrollable != null && ! scrollable.isFocusTraversable() ) {
			scrollable.setFocusTraversable(true);
			scrollable.addEventHandler(MouseEvent.MOUSE_RELEASED, getFocusHandler());
		}
	}

	private static EventHandler<MouseEvent> getFocusHandler() {
		if( FOCUS_HANDLER == null ) {
			FOCUS_HANDLER = new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					Control c = Widget.getWidget(event.getSource());
					if( c != null ) {
						c.setFocus();
					}
				}
			};
		}
		return FOCUS_HANDLER;
	}

	@Override
	public void redraw() {
		redraw(0, 0, internal_getWidth(), internal_getPrefHeight(), true);
	}

	@Override
	public void redraw(int x, int y, int width, int height, boolean all) {
		redraw(x*1.0, y, width, height, all);
		for( Control c : getChildren() ) {
			c.redraw(x, y, width, height, all);
		}
	}

	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		gc.dispose();
	}

	@Override
	public DrawableGC internal_new_GC() {
		if( canvas == null ) {
			return super.internal_new_GC();
		} else {
			return new CanvasGC(canvas,
					getFont(),
					getBackground(),
					getForeground()
					);
//			return new BufferedImageGC(canvas, getFont(),
//					getBackground(),
//					getForeground());
		}
	}

	protected Canvas internal_initCanvas() {
		if( canvas == null ) {
			canvas = new Canvas(scrollable.getWidth(),scrollable.getHeight()) {
				@Override
				public double minWidth(double height) {
					return 0;
				}

				@Override
				public double minHeight(double width) {
					return 0;
				}

				@Override
				public double prefHeight(double width) {
					return 0;
				}

				@Override
				public double prefWidth(double height) {
					return 0;
				}

			};

			//TODO Do we need to remove the scrollbars????
			scrollable.getChildren().add(0, canvas);
			InvalidationListener l = new InvalidationListener() {

				@Override
				public void invalidated(Observable observable) {
					double w = scrollable.getWidth();
					double h = scrollable.getHeight();

					if( vScroll != null ) {
						w -= vScroll.internal_getNativeObject().getWidth();
					}

					if( hScroll != null ) {
						h -= hScroll.internal_getNativeObject().getHeight();
					}

					canvas.setWidth(w);
					canvas.setHeight(h);
					redraw();
				}
			};
			scrollable.widthProperty().addListener(l);
			scrollable.heightProperty().addListener(l);
			redraw();
		}
		return canvas;
	}

	private boolean inRedraw;

	void redraw(double x, double y, double width, double height, boolean all) {
		if( canvas != null ) {
			if( inRedraw ) {
				return;
			}
			try {
				inRedraw = true;
				if( all ) {
					canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
					x = 0;
					y = 0;
					width = canvas.getWidth();
					height = canvas.getHeight();
				} else {
					canvas.getGraphicsContext2D().clearRect(x,y,width,height);
				}

				Event event = new Event ();
				GC gc = new GC(this);
				event.gc = gc;
				event.x = (int)x;
				event.y = (int)y;
				event.width = (int)width;
				event.height = (int)height;
				internal_sendEvent (SWT.Paint, event,true);
				event.gc = null;
				gc.dispose ();
			} finally {
				inRedraw = false;
			}

		}
	}

	@Override
	public ScrollBar getHorizontalBar() {
		return hScroll;
	}

	@Override
	public ScrollBar getVerticalBar() {
		return vScroll;
	}

	public Layout getLayout() {
		return layout;
	}

	@Override
	public void setMenu(Menu menu) {
		if( controlContainer != null ) {
			controlContainer.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, getContextMenuHandler());
			this.menu = menu;
		} else {
			super.setMenu(menu);
		}
	}

	@Override
	public Menu getMenu() {
		return menu;
	}

	private static EventHandler<ContextMenuEvent> getContextMenuHandler() {
		if( CONTEXT_MENU_HANDLER == null ) {
			CONTEXT_MENU_HANDLER = new EventHandler<ContextMenuEvent>() {

				@Override
				public void handle(ContextMenuEvent event) {
					Node n = (Node) event.getTarget();
					Control c = (Control) Widget.getWidget(n);

					if( c != null ) {
						ContextMenu ctm = (ContextMenu) c.getMenu().internal_getNativeObject();
						ctm.show(n, event.getScreenX(), event.getScreenY());
					}

					//TODO Do we need more code e.g. to hide?
				}
			};
		}
		return CONTEXT_MENU_HANDLER;
	}

	@Override
	public void setToolTipText(String string) {
		if( controlContainer != null ) {
			if( string == null || string.length() == 0 ) {
				if( tooltip != null ) {
					Tooltip.uninstall(controlContainer, tooltip);
				}
				tooltip = null;
			} else {
				if( tooltip == null ) {
					tooltip = new Tooltip();
				}
				tooltip.setText(string);
				Tooltip.install(controlContainer, tooltip);
			}
		} else {
			super.setToolTipText(string);
		}

	}

	@Override
	public String getToolTipText() {
		if( controlContainer != null ) {
			return tooltipText;
		}
		return super.getToolTipText();
	}

	public void setTabList(Control[] controls) {
		Util.logNotImplemented();
	}

	public Control [] getTabList () {
		Util.logNotImplemented();
		return getChildren();
	}


	public void drawBackground(GC gc, int x, int y, int width, int height,
			int x2, int y2) {
		Util.logNotImplemented();
	}

	public boolean isLayoutDeferred () {
		Util.logNotImplemented();
		return false;
	}

	public void setLayoutDeferred(boolean deferred) {
		Util.logNotImplemented();
	}

}
