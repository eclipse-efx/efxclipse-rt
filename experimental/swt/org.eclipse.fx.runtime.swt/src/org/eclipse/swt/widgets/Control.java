package org.eclipse.swt.widgets;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.Accessible;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.MeasureGC;
import org.eclipse.swt.internal.Util;

public abstract class Control extends Widget implements Drawable {

	private Object layoutData;
	private Composite parent;
	private Color foreground;
	private Color background;
	private Font font;

	private static EventHandler<MouseEvent> MOUSE_HANDLER;
	private static Control LAST_ENTER;
	private static EventHandler<KeyEvent> KEY_HANDLER;
	private static EventHandler<ContextMenuEvent> CONTEXT_MENU_HANDLER;
	// private static InvalidationListener FOCUS_LISTENER;
	// TODO we should make those a stack because if someone e.g. pressed A+S we
	// miss the A keyup event
	private Event lastTypedDown;
	private Event lastLetterDown;
	private Menu menu;
	private Tooltip tooltip;
	private String tooltipText;
	private Cursor cursor;

	// private static Control CURRENT_FOCUS_CONTROL;

	public Control(Composite parent, int style) {
		super(parent.getDisplay(), style);
		this.parent = parent;
		parent.internal_controlAdded(this);
	}

	public Control(Display display, int style) {
		super(display, style);
	}

	@Override
	public void dispose() {
		super.dispose();

		// In case it is a shell we might not have a parent
		if (parent != null) {
			parent.internal_controlRemoved(this);
		}
	}

	@Override
	protected void initListeners() {
		super.initListeners();
		final Region n = internal_getEventTarget();
		if (internal_mouseAsFilter()) {
			n.addEventFilter(MouseEvent.MOUSE_ENTERED, getMouseHandler());
			n.addEventFilter(MouseEvent.MOUSE_EXITED, getMouseHandler());
			n.addEventFilter(MouseEvent.MOUSE_MOVED, getMouseHandler());
		} else {
			n.addEventHandler(MouseEvent.MOUSE_ENTERED, getMouseHandler());
			n.addEventHandler(MouseEvent.MOUSE_EXITED, getMouseHandler());
			n.addEventHandler(MouseEvent.MOUSE_MOVED, getMouseHandler());
		}

		n.addEventHandler(MouseEvent.MOUSE_PRESSED, getMouseHandler());
		n.addEventHandler(MouseEvent.MOUSE_RELEASED, getMouseHandler());
		n.addEventHandler(MouseEvent.MOUSE_DRAGGED, getMouseHandler());

		// TODO Better do it on the scene???
		// n.focusedProperty().addListener(getFocusListener());
		// TODO Should we do it lazy??
		n.addEventHandler(KeyEvent.KEY_RELEASED, getKeyEventHandler());
		n.addEventHandler(KeyEvent.KEY_TYPED, getKeyEventHandler());
		n.addEventHandler(KeyEvent.KEY_PRESSED, getKeyEventHandler());

		n.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED,
				getContextMenuHandler());
	}

	boolean internal_mouseAsFilter() {
		return false;
	}

	private EventHandler<ContextMenuEvent> getContextMenuHandler() {
		if (CONTEXT_MENU_HANDLER == null) {
			CONTEXT_MENU_HANDLER = new EventHandler<ContextMenuEvent>() {

				@Override
				public void handle(ContextMenuEvent event) {
					Widget widget = Widget.getWidget(event.getTarget());
					if (widget instanceof Control) {
						Event evt = new Event();
						evt.x = (int) event.getScreenX();
						evt.y = (int) event.getScreenY();
						internal_sendEvent(SWT.MenuDetect, evt, true);
					}
				}
			};
		}
		return CONTEXT_MENU_HANDLER;
	}

	@Override
	protected void uninitListeners() {
		super.uninitListeners();
		final Region n = internal_getEventTarget();
		n.removeEventHandler(MouseEvent.MOUSE_ENTERED, getMouseHandler());
		n.removeEventHandler(MouseEvent.MOUSE_EXITED, getMouseHandler());
		n.removeEventHandler(MouseEvent.MOUSE_MOVED, getMouseHandler());

		n.removeEventHandler(MouseEvent.MOUSE_PRESSED, getMouseHandler());
		n.removeEventHandler(MouseEvent.MOUSE_RELEASED, getMouseHandler());
		n.removeEventHandler(MouseEvent.MOUSE_DRAGGED, getMouseHandler());

		// TODO Better do it on the scene???
		// n.focusedProperty().addListener(getFocusListener());
		// TODO Should we do it lazy??
		n.removeEventHandler(KeyEvent.KEY_RELEASED, getKeyEventHandler());
		n.removeEventHandler(KeyEvent.KEY_TYPED, getKeyEventHandler());
		n.removeEventHandler(KeyEvent.KEY_PRESSED, getKeyEventHandler());
	}

	// private static InvalidationListener getFocusListener() {
	// if( FOCUS_LISTENER == null ) {
	// FOCUS_LISTENER = new InvalidationListener() {
	//
	// @Override
	// public void invalidated(Observable observable) {
	// ReadOnlyBooleanProperty p = (ReadOnlyBooleanProperty) observable;
	// Node n = (Node) p.getBean();
	//
	// Widget widget = Widget.getWidget(n);
	// if( widget != null && widget instanceof Control) {
	// if( n.isFocused() ) {
	// if( CURRENT_FOCUS_CONTROL != widget ) {
	// Event evt = new Event();
	// widget.internal_sendEvent(SWT.FocusIn, evt, true);
	// CURRENT_FOCUS_CONTROL = (Control) widget;
	// }
	// } else {
	// Event evt = new Event();
	// widget.internal_sendEvent(SWT.FocusOut, evt, true);
	// }
	// }
	// }
	// };
	// }
	// return FOCUS_LISTENER;
	// }

	@Override
	public abstract Region internal_getNativeObject();

	public Region internal_getNativeControl() {
		return internal_getNativeObject();
	}

	protected Region internal_getEventTarget() {
		return internal_getNativeObject();
	}

	public void setBounds(int x, int y, int width, int height) {
		checkWidget();
		internal_getNativeObject().resizeRelocate(x, y, width, height);
	}

	public Point computeSize(int wHint, int hHint) {
		checkWidget();
		return computeSize(wHint, hHint, true);
	}

	public Point computeSize(int wHint, int hHint, boolean flushCache) {
		checkWidget();
		forceSizeProcessing();
		int width = (int) internal_getNativeObject().prefWidth(
				javafx.scene.control.Control.USE_COMPUTED_SIZE);
		int height = (int) internal_getNativeObject().prefHeight(
				javafx.scene.control.Control.USE_COMPUTED_SIZE);
		
		if (width <= 0) {
			width = DEFAULT_WIDTH;
		}

		if (height <= 0) {
			height = DEFAULT_HEIGHT;
		}

		if (wHint != SWT.DEFAULT)
			width = wHint;
		if (hHint != SWT.DEFAULT)
			height = hHint;
		int border = getBorderWidth();
		width += border * 2;
		height += border * 2;
		return new Point(width, height);
	}

	protected void forceSizeProcessing() {
		if ((state & CSS_PROCESSED) != CSS_PROCESSED
				&& (internal_getNativeObject().getScene() == null
						|| internal_getNativeObject().getScene().getWindow() == null || !internal_getNativeObject()
						.getScene().getWindow().isShowing())) {
			state |= CSS_PROCESSED;
			internal_getNativeObject().impl_processCSS(true);
		}
	}

	public void setLayoutData(Object layoutData) {
		checkWidget();
		this.layoutData = layoutData;
	}

	public Object getLayoutData() {
		checkWidget();
		return layoutData;
	}

	public int getBorderWidth() {
		// FIXME Implement
		return 0;
	}

	public void addControlListener(ControlListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Resize, typedListener);
		addListener(SWT.Move, typedListener);
	}

	
	 public void addDragDetectListener (DragDetectListener listener) {
		 Util.logNotImplemented();
	 }
	
	public void addFocusListener(FocusListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.FocusIn, typedListener);
		addListener(SWT.FocusOut, typedListener);
	}

	//
	// public void addGestureListener (GestureListener listener) {
	//
	// }
	//

	public void addHelpListener(HelpListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Help, typedListener);
	}

	public void addKeyListener(KeyListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.KeyUp, typedListener);
		addListener(SWT.KeyDown, typedListener);
	}

	
	 public void addMenuDetectListener (MenuDetectListener listener) {
		 Util.logNotImplemented();
	 }
	
	public void addMouseListener(MouseListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.MouseDown, typedListener);
		addListener(SWT.MouseUp, typedListener);
		addListener(SWT.MouseDoubleClick, typedListener);
	}

	public void addMouseMoveListener(MouseMoveListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.MouseMove, typedListener);
	}

	
	 public void addMouseTrackListener (MouseTrackListener listener) {
		 Util.logNotImplemented();
	 }
	//
	// public void addMouseWheelListener (MouseWheelListener listener) {
	//
	// }
	//
	public void addPaintListener(PaintListener listener) {
		checkWidget();
		if (listener == null)
			error(SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Paint, typedListener);
	}

	@Override
	public void addListener(int eventType, Listener listener) {
		super.addListener(eventType, listener);
		if (eventType == SWT.Resize
				&& (state & RESIZE_ATTACHED) != RESIZE_ATTACHED) {
			InvalidationListener l = new InvalidationListener() {

				@Override
				public void invalidated(Observable observable) {
					Event evt = new Event();
					internal_sendEvent(SWT.Resize, evt, true);
				}
			};
			internal_getNativeControl().widthProperty().addListener(l);
			internal_getNativeControl().heightProperty().addListener(l);
		}
	}

	//
	// public void addTouchListener (TouchListener listener) {
	//
	// }
	//
	public void addTraverseListener(TraverseListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Traverse, typedListener);
	}

	//
	// public Point computeSize (int wHint, int hHint) {
	//
	// }
	//
	// // public Point computeSize (int wHint, int hHint, boolean changed) {
	// //
	// // }
	//
	// public boolean dragDetect (MouseEvent event) {
	//
	// }
	//
	// public boolean dragDetect (Event event) {
	//
	// }
	//
	// public boolean forceFocus () {
	//
	// }
	//
	public Accessible getAccessible() {
		return new Accessible();
	}

	public Color getBackground() {
		return this.background == null ? getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND) : background;
	}

	public Image getBackgroundImage () {
		Util.logNotImplemented();
		return null;
	 }
	
	public Rectangle getBounds() {
		Point location = getLocation();
		Point size = getSize();
		return new Rectangle(location.x, location.y, size.x, size.y);
	}

	public Cursor getCursor() {
		return cursor;
	}

	//
	// public boolean getDragDetect () {
	//
	// }
	//
	public boolean getEnabled() {
		checkWidget();
		return !internal_getNativeObject().isDisabled();
	}

	public Font getFont() {
		return font == null ? font = getDefaultFont() : font;
	}

	public Color getForeground() {
		return this.foreground == null ? getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_FOREGROUND) : foreground;
	}

	protected Font getDefaultFont() {
		return getDisplay().getSystemFont();
	}

	public Point getLocation() {
		checkWidget();
		return new Point((int) internal_getNativeObject().getLayoutX(),
				(int) internal_getNativeObject().getLayoutY());
	}

	public Monitor getMonitor() {
		Monitor[] monitors = getDisplay().getMonitors();
		if (monitors.length == 1) {
			return monitors[0];

		}
		Rectangle bounds = getBounds();
		if (!(this instanceof Shell)) {
			bounds = getDisplay().map(getParent(), null, bounds);
		}
		
		int index = -1, value = -1;
		for (int i = 0; i < monitors.length; i++) {
			Rectangle rect = bounds.intersection(monitors[i].getBounds());
			int area = rect.width * rect.height;
			if (area > 0 && area > value) {
				index = i;
				value = area;
			}
		}
		if (index >= 0)
			return monitors[index];
		int centerX = bounds.x + bounds.width / 2, centerY = bounds.y
				+ bounds.height / 2;
		for (int i = 0; i < monitors.length; i++) {
			Rectangle rect = monitors[i].getBounds();
			int x = centerX < rect.x ? rect.x - centerX : centerX > rect.x
					+ rect.width ? centerX - rect.x - rect.width : 0;
			int y = centerY < rect.y ? rect.y - centerY : centerY > rect.y
					+ rect.height ? centerY - rect.y - rect.height : 0;
			int distance = x * x + y * y;
			if (index == -1 || distance < value) {
				index = i;
				value = distance;
			}
		}
		return monitors[index];
	}

	public int getOrientation() {
		if ((style & SWT.RIGHT_TO_LEFT) == SWT.RIGHT_TO_LEFT) {
			return SWT.RIGHT_TO_LEFT;
		}
		return SWT.LEFT_TO_RIGHT;
	}

	public Composite getParent() {
		checkWidget();
		return parent;
	}

	//
	// public Region getRegion () {
	//
	// }
	//
	public Shell getShell() {
		return getParent().getShell();
	}

	public Point getSize() {
		forceSizeProcessing();
		return new Point((int) internal_getWidth(), (int) internal_getHeight());
	}

	protected double internal_getWidth() {
		return internal_getNativeObject().getWidth();
	}

	protected double internal_getHeight() {
		return internal_getNativeObject().getHeight();
	}

	public String getToolTipText() {
		return tooltipText;
	}

	//
	// public boolean getTouchEnabled () {
	//
	// }

	public boolean getVisible() {
		return internal_getNativeObject().isVisible();
	}

	 public boolean isEnabled () {
		 return getEnabled () && parent.isEnabled ();
	 }
	
	public boolean isFocusControl() {
		return internal_getEventTarget().isFocused();
	}

	//
	// public boolean isReparentable () {
	//
	// }
	//
	public boolean isVisible() {
		return getVisible() && parent.isVisible();
	}

	public void moveAbove(Control control) {
		parent.internal_controlMoveAbove(this, control);
	}

	
	 public void moveBelow (Control control) {
		 parent.internal_controlMoveBelow(this, control);
	 }
	
	public void pack() {
		forceSizeProcessing();
		// TODO is it min size??
		setSize((int) internal_getNativeControl().prefWidth(-1),
				(int) internal_getNativeControl().prefHeight(-1));
	}

	
	 public void pack (boolean changed) {
		forceSizeProcessing();
		// TODO is it min size??
		setSize((int) internal_getNativeControl().prefWidth(-1),
				(int) internal_getNativeControl().prefHeight(-1));	
	 }
	//
	// public boolean print (GC gc) {
	//
	// }
	//
	public void redraw() {
		// Util.logNotImplemented();
	}

	public void redraw(int x, int y, int width, int height, boolean all) {
		// Util.logNotImplemented();
	}

	 public void removeControlListener (ControlListener listener) {
		 removeListener(SWT.Resize, listener);
		 removeListener(SWT.Move, listener);	
	 }
	
	 public void removeDragDetectListener(DragDetectListener listener) {
		 Util.logNotImplemented();
	 }
	
	public void removeFocusListener(FocusListener listener) {
		removeListener(SWT.FocusIn, listener);
		removeListener(SWT.FocusOut, listener);

	}

	//
	// public void removeGestureListener (GestureListener listener) {
	//
	// }
	//
	public void removeHelpListener(HelpListener listener) {
		removeListener(SWT.Help, listener);
	}

	public void removeKeyListener(KeyListener listener) {
		removeListener(SWT.KeyUp, listener);
		removeListener(SWT.KeyDown, listener);
	}

	//
	// public void removeMenuDetectListener (MenuDetectListener listener) {
	//
	// }
	//
	public void removeMouseListener(MouseListener listener) {
		removeListener(SWT.MouseDown, listener);
		removeListener(SWT.MouseUp, listener);
		removeListener(SWT.MouseDoubleClick, listener);
	}

	
	 public void removeMouseMoveListener(MouseMoveListener listener) {
		 removeListener(SWT.MouseMove, listener);
	 }
	
	 public void removeMouseTrackListener(MouseTrackListener listener) {
		 Util.logNotImplemented();
	 }
	//
	// public void removeMouseWheelListener (MouseWheelListener listener) {
	//
	// }
	//
	 public void removePaintListener(PaintListener listener) {
		 removeListener(SWT.Paint, listener);
	 }
	//
	// public void removeTouchListener(TouchListener listener) {
	//
	// }

	public void removeTraverseListener(TraverseListener listener) {
		removeListener(SWT.Traverse, listener);
	}

	public void setBackground(Color color) {
		this.background = color;
		internal_reapplyStyle();
//		if (color != null) {
////			internal_getNativeObject().setBackground(
////					new Background(new BackgroundFill(color
////							.internal_getNativeObject(), CornerRadii.EMPTY,
////							Insets.EMPTY)));
//		} else {
//			internal_getNativeObject().setBackground(null);
//		}
	}

	public void setBackgroundImage(Image image) {
		Util.logNotImplemented();
	}

	public void setBounds(Rectangle rect) {
		setBounds(rect.x, rect.y, rect.width, rect.height);
	}

	public void setCapture (boolean capture) {
		Util.logNotImplemented();
	}
	
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
		internal_getNativeObject().setCursor(
				cursor == null ? null : cursor.internal_getNativeObject());
	}

	public void setDragDetect(boolean dragDetect) {
		// TODO
		Util.logNotImplemented();
	}

	public void setEnabled(boolean enabled) {
		checkWidget();
		internal_getNativeObject().setDisable(!enabled);
	}

	public boolean setFocus() {
		checkWidget();
		internal_getNativeControl().requestFocus();
		return internal_getNativeControl().isFocused();
	}

	public boolean forceFocus() {
		return setFocus();
	}

	public void setFont(Font font) {
		this.font = font;
		internal_reapplyStyle();
	}

	protected final void internal_reapplyStyle() {
		internal_getNativeObject().setStyle(internal_calculateStyleString());
	}

	protected String internal_calculateStyleString() {
		StringBuffer b = new StringBuffer();
		if (font != null) {
			b.append(font.internal_getAsCSSString());
		}
		
		if (foreground != null) {
			String rgb = "rgb(" + foreground.getRed() + ","
					+ foreground.getGreen() + "," + foreground.getBlue() + ")";
			b.append("-fx-text-inner-color: " + rgb
					+ "; -fx-text-background-color: " + rgb + ";");
		}
		
		if( background != null ) {
			String rgb = "rgb(" + background.getRed() + ","
					+ background.getGreen() + "," + background.getBlue() + ")";
			b.append("-fx-background-color: " + rgb);
		}
		
		return b.toString();
	}

	public void setForeground(Color color) {
		this.foreground = color;
		internal_reapplyStyle();
	}

	// public void setLayoutData (Object layoutData) {
	//
	// }
	//
	public void setLocation(int x, int y) {
		checkWidget();
		internal_getNativeObject().relocate(x, y);
	}

	public void setLocation(Point location) {
		setLocation(location.x, location.y);
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
		Region r = internal_getNativeControl();
		if (r instanceof javafx.scene.control.Control) {
			javafx.scene.control.Control c = (javafx.scene.control.Control) r;
			c.setContextMenu((ContextMenu) (menu == null ? null : menu
					.internal_getNativeObject()));
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setOrientation(int orientation) {
		Util.logNotImplemented();
	}

	
	 public boolean setParent (Composite parent) {
		 this.parent.internal_detachControl(this);
		 parent.internal_attachControl(this);
		 this.parent = parent;
		 return true;
	 }
	
	public void setRedraw(boolean redraw) {
		// Not needed in FX
	}

	//
	// public void setRegion (Region region) {
	//
	// }
	//
	public void setSize(int width, int height) {
		internal_getNativeObject().resize(width, height);
	}

	public void setSize(Point size) {
		setSize(size.x, size.y);
	}

	public void setToolTipText(String string) {
		this.tooltipText = string;
		if (internal_getNativeControl() instanceof javafx.scene.control.Control) {
			javafx.scene.control.Control control = (javafx.scene.control.Control) internal_getNativeControl();
			if (string == null || string.length() == 0) {
				tooltip = null;
			} else {
				if (tooltip == null) {
					tooltip = new Tooltip();
				}
				tooltip.setText(string);
			}

			control.setTooltip(tooltip);
		}
	}

	//
	// public void setTouchEnabled(boolean enabled) {
	//
	// }
	//
	public void setVisible(boolean visible) {
		checkWidget();
		internal_getNativeObject().setVisible(visible);
	}

	public Point toControl(int x, int y) {
		return getDisplay().map(null, this, x, y);
	}

	public Point toControl(Point point) {
		return toControl(point.x, point.y);
	}

	public Point toDisplay(int x, int y) {
		return getDisplay().map(this, null, x, y);
	}

	public Point toDisplay(Point point) {
		return toDisplay(point.x, point.y);
	}

	
	 public boolean traverse (int traversal) {
		 Util.logNotImplemented();
		 return false;
	 }
	
	 public boolean traverse (int traversal, KeyEvent event) {
		 Util.logNotImplemented();
		 return false;
	 }
	
	 public boolean traverse (int traversal, Event event) {
		 Util.logNotImplemented();
		 return false;
	 }
	
	public void update() {
		Util.logNotImplemented();
	}
	
	public void setTextDirection(int dir) {
		Util.logNotImplemented();
	}

	void sendMouseEvent(int type, MouseEvent event) {
		if (type == SWT.MouseEnter && (state & MOUSE_EXIT) != MOUSE_EXIT) {
			return;
		}
		if (type == SWT.MouseExit && (state & MOUSE_ENTER) != MOUSE_ENTER) {
			return;
		}

		Event evt = new Event();
		evt.type = type;
		switch (type) {
		case SWT.MouseDown:
		case SWT.MouseUp:
		case SWT.MouseDoubleClick:
		case SWT.MouseMove:
			switch (event.getButton()) {
			case PRIMARY:
				evt.button = 1;
				break;
			case SECONDARY:
				evt.button = 2;
				break;
			case MIDDLE:
				evt.button = 3;
				break;
			case NONE:
				evt.button = 4;
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}

		if (evt.button != 0) {
			evt.count = event.getClickCount();
		}

		evt.x = (int) event.getX();
		evt.y = (int) event.getY();

		updateStateMask(evt, event);

		internal_sendEvent(type, evt, true);

		if (type == SWT.MouseExit) {
			state &= ~MOUSE_ENTER;
			state |= MOUSE_EXIT;
			if (getParent() != null && event.getSceneX() > 0
					&& event.getSceneY() > 0) {
				Composite p = getParent();
				Point2D p2 = getParent().internal_getNativeObject()
						.sceneToLocal(event.getSceneX(), event.getSceneY());
				while (p != null) {
					if (p.internal_getNativeObject().contains(p2)) {
						break;
					}
					p = p.getParent();
				}

				if (p != null) {
					Event e2 = new Event();
					e2.type = SWT.MouseEnter;
					e2.x = (int) p2.getX();
					e2.y = (int) p2.getY();
					e2.stateMask = evt.stateMask;
					p.state |= MOUSE_ENTER;
					p.state &= ~MOUSE_EXIT;
					p.internal_sendEvent(SWT.MouseEnter, e2, true);
				}
				LAST_ENTER = p;
			} else {
				LAST_ENTER = null;
			}
		} else if (type == SWT.MouseEnter) {
			state |= MOUSE_ENTER;
			state &= ~MOUSE_EXIT;
			if (LAST_ENTER != null) {
				Point2D p2 = LAST_ENTER.internal_getNativeObject()
						.sceneToLocal(event.getSceneX(), event.getSceneY());
				if (LAST_ENTER.internal_getNativeObject().contains(p2)) {
					Event e2 = new Event();
					e2.type = SWT.MouseExit;
					e2.x = (int) p2.getX();
					e2.y = (int) p2.getY();
					e2.stateMask = evt.stateMask;
					LAST_ENTER.state &= ~MOUSE_ENTER;
					LAST_ENTER.state |= MOUSE_EXIT;
					LAST_ENTER.internal_sendEvent(SWT.MouseExit, e2, true);
				}
			}
			LAST_ENTER = this;
		} else if (type == SWT.MouseMove) {
			// FIXME We need to emulate hover
		}
	}

	void sendKeyEvent(KeyEvent event) {
		Event evt = new Event();

		if (event.getEventType() == KeyEvent.KEY_TYPED) {
			if (event.isAltDown())
				evt.stateMask |= SWT.ALT;
			if (event.isShiftDown())
				evt.stateMask |= SWT.SHIFT;
			if (event.isControlDown())
				evt.stateMask |= SWT.CONTROL;
			if (event.isMetaDown())
				evt.stateMask |= SWT.COMMAND;

			// FIXME Alt/Control modifiers don't yet work
			evt.keyCode = lastLetterDown != null ? lastLetterDown.keyCode : 0;
			evt.character = event.getCharacter() != KeyEvent.CHAR_UNDEFINED
					&& event.getCharacter().length() > 0 ? event.getCharacter()
					.charAt(0) : lastLetterDown != null ? (char) lastLetterDown.keyCode : 0;
			internal_sendEvent(SWT.KeyDown, evt, true);
			if (!evt.doit) {
				event.consume();
				lastTypedDown = null;
			} else {
				lastTypedDown = evt;
			}
		} else {
			evt.keyCode = translateKey(event.getCode());

			switch (evt.keyCode) {
			case SWT.LF:
				evt.keyCode = SWT.KEYPAD_CR;
				evt.character = '\r';
				break;
			case SWT.BS:
				evt.character = '\b';
				break;
			case SWT.CR:
				evt.character = '\r';
				break;
			case SWT.DEL:
				evt.character = 0x7F;
				break;
			case SWT.ESC:
				evt.character = 0x1B;
				break;
			case SWT.TAB:
				evt.character = '\t';
				break;
			}

			if (event.getEventType() == KeyEvent.KEY_RELEASED) {
				if (lastTypedDown != null) {
					internal_sendEvent(SWT.KeyUp, lastTypedDown, true);
					lastTypedDown = null;
					lastLetterDown = null;
				}
			}

			if (evt.keyCode != 0) {
				int type;
				if (event.getEventType() == KeyEvent.KEY_RELEASED) {
					type = SWT.KeyUp;

					if (event.isAltDown() || event.getCode() == KeyCode.ALT)
						evt.stateMask |= SWT.ALT;
					if (event.isShiftDown() || event.getCode() == KeyCode.SHIFT)
						evt.stateMask |= SWT.SHIFT;
					if (event.isControlDown()
							|| event.getCode() == KeyCode.CONTROL)
						evt.stateMask |= SWT.CONTROL;
					if (event.isMetaDown() || event.getCode() == KeyCode.META)
						evt.stateMask |= SWT.COMMAND;

				} else {
					type = SWT.KeyDown;

					if (event.isAltDown() && event.getCode() != KeyCode.ALT)
						evt.stateMask |= SWT.ALT;
					if (event.isShiftDown() && event.getCode() != KeyCode.SHIFT)
						evt.stateMask |= SWT.SHIFT;
					if (event.isControlDown()
							&& event.getCode() != KeyCode.CONTROL)
						evt.stateMask |= SWT.CONTROL;
					if (event.isMetaDown() && event.getCode() != KeyCode.META)
						evt.stateMask |= SWT.COMMAND;
				}

				internal_sendEvent(type, evt, true);
				if (!evt.doit) {
					event.consume();
					return;
				}

				if (event.getEventType() == KeyEvent.KEY_PRESSED) {
					Event tEvt = new Event();
					switch (event.getCode()) {
					case RIGHT:
						tEvt.detail = SWT.TRAVERSE_ARROW_NEXT;
						break;
					case LEFT:
						tEvt.detail = SWT.TRAVERSE_ARROW_PREVIOUS;
						break;
					case ESCAPE:
						tEvt.detail = SWT.TRAVERSE_ESCAPE;
						break;
					case PAGE_DOWN:
						tEvt.detail = SWT.TRAVERSE_PAGE_NEXT;
						break;
					case PAGE_UP:
						tEvt.detail = SWT.TRAVERSE_PAGE_PREVIOUS;
						break;
					case ENTER:
						tEvt.detail = SWT.TRAVERSE_RETURN;
						break;
					case TAB:
						if (event.isShiftDown()) {
							tEvt.detail = SWT.TRAVERSE_TAB_PREVIOUS;
						} else {
							tEvt.detail = SWT.TRAVERSE_TAB_NEXT;
						}
						break;
					default:
						if (event.isAltDown() && event.getCode() != KeyCode.ALT) {
							tEvt.detail = SWT.TRAVERSE_MNEMONIC;
						}

						break;
					}
					if (tEvt.detail != 0) {
						internal_sendEvent(SWT.Traverse, tEvt, true);
						if (!tEvt.doit) {
							event.consume();
						}
					}
				}

			} else if (event.getCode().isLetterKey()) {
				evt.keyCode = Character.toLowerCase(event.getCode()
						.impl_getCode());
				lastLetterDown = evt;
			}
		}
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new MeasureGC(this);
	}
	
	void markLayout (boolean changed, boolean all) {
		// nothing todo
	}

	void updateStateMask(Event swtEvent, MouseEvent event) {
		if (event.isAltDown()) {
			swtEvent.stateMask |= SWT.ALT;
		}
		if (event.isShiftDown()) {
			swtEvent.stateMask |= SWT.SHIFT;
		}
		if (event.isControlDown()) {
			swtEvent.stateMask |= SWT.CONTROL;
		}
		// TODO Is this correct???
		if (event.isMetaDown()) {
			swtEvent.stateMask |= SWT.COMMAND;
		}

		if (swtEvent.type == SWT.MouseDown || swtEvent.type == SWT.MouseMove) {
			switch (swtEvent.button) {
			case 1:
				swtEvent.stateMask |= SWT.BUTTON1;
				break;
			case 2:
				swtEvent.stateMask |= SWT.BUTTON2;
				break;
			case 3:
				swtEvent.stateMask |= SWT.BUTTON3;
				break;
			case 4:
				swtEvent.stateMask |= SWT.BUTTON4;
				break;
			case 5:
				swtEvent.stateMask |= SWT.BUTTON5;
				break;
			default:
				break;
			}
		}
	}

	static class MouseHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			int type = SWT.None;

			if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
				type = SWT.MouseExit;
			} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
				type = SWT.MouseEnter;
			} else if (event.getEventType() == MouseEvent.MOUSE_MOVED
					|| event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
				type = SWT.MouseMove;
			} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
				type = SWT.MouseDown;
			} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
				type = SWT.MouseUp;
			}

			if (type != SWT.None) {
				Object o = Widget.getWidget(event.getSource());

				if (o instanceof Control) {
					Control c = (Control) o;
					if (c != null) {
						if (type == SWT.MouseEnter) {
							c.getDisplay().setHoverControl(c);
						} else if (type == SWT.MouseExit) {
							c.getDisplay().setHoverControl(null);
						} else if (type == SWT.MouseMove) {
							c.getDisplay().setHoverControl(c);
						}

						c.sendMouseEvent(type, event);

						if (type == SWT.MouseUp && event.getClickCount() > 1) {
							c.sendMouseEvent(SWT.MouseDoubleClick, event);
						}
					}
				}
			}
		}
	}

	private static EventHandler<MouseEvent> getMouseHandler() {
		if (MOUSE_HANDLER == null) {
			MOUSE_HANDLER = new MouseHandler();
		}
		return MOUSE_HANDLER;
	}

	private static EventHandler<KeyEvent> getKeyEventHandler() {
		if (KEY_HANDLER == null) {
			KEY_HANDLER = new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					Control c = Widget.getWidget(event.getTarget());
					if (c != null) {
						c.sendKeyEvent(event);
						event.consume();
					}
				}
			};
		}
		return KEY_HANDLER;
	}

	private static int translateKey(KeyCode keyCode) {
		switch (keyCode) {
		case ALT:
			return SWT.ALT;
		case SHIFT:
			return SWT.SHIFT;
		case CONTROL:
			return SWT.CONTROL;
		case COMMAND:
			return SWT.COMMAND;
		case UP:
			return SWT.ARROW_UP;
		case DOWN:
			return SWT.ARROW_DOWN;
		case LEFT:
			return SWT.ARROW_LEFT;
		case RIGHT:
			return SWT.ARROW_RIGHT;
		case PAGE_UP:
			return SWT.PAGE_UP;
		case PAGE_DOWN:
			return SWT.PAGE_DOWN;
		case HOME:
			return SWT.HOME;
		case END:
			return SWT.END;
		case BACK_SPACE:
			return SWT.BS;
		case DELETE:
			return SWT.DEL;
		case ESCAPE:
			return SWT.ESC;
		case TAB:
			return SWT.TAB;
			// case ...:
			// return SWT.CR;
			// case ...:
			// return SWT.LF;
		case F1:
			return SWT.F1;
		case F2:
			return SWT.F2;
		case F3:
			return SWT.F3;
		case F4:
			return SWT.F4;
		case F5:
			return SWT.F5;
		case F6:
			return SWT.F6;
		case F7:
			return SWT.F7;
		case F8:
			return SWT.F8;
		case F9:
			return SWT.F9;
		case F10:
			return SWT.F10;
		case F11:
			return SWT.F11;
		case F12:
			return SWT.F12;
		case F13:
			return SWT.F13;
		case F14:
			return SWT.F14;
		case F15:
			return SWT.F15;
		case F16:
			return SWT.F16;
		case F17:
			return SWT.F17;
		case F18:
			return SWT.F18;
		case F19:
			return SWT.F19;
		case F20:
			return SWT.F20;
		case MULTIPLY:
			return SWT.KEYPAD_MULTIPLY;
		case ADD:
			return SWT.KEYPAD_ADD;
		case ENTER:
			return SWT.KEYPAD_CR;
		case SUBTRACT:
			return SWT.KEYPAD_SUBTRACT;
		case DECIMAL:
			return SWT.KEYPAD_DECIMAL;
		case DIVIDE:
			return SWT.KEYPAD_DIVIDE;
		case NUMPAD0:
			return SWT.KEYPAD_0;
		case NUMPAD1:
			return SWT.KEYPAD_1;
		case NUMPAD2:
			return SWT.KEYPAD_2;
		case NUMPAD3:
			return SWT.KEYPAD_3;
		case NUMPAD4:
			return SWT.KEYPAD_4;
		case NUMPAD5:
			return SWT.KEYPAD_5;
		case NUMPAD6:
			return SWT.KEYPAD_6;
		case NUMPAD7:
			return SWT.KEYPAD_7;
		case NUMPAD8:
			return SWT.KEYPAD_8;
		case NUMPAD9:
			return SWT.KEYPAD_9;
		case EQUALS:
			return SWT.KEYPAD_EQUAL;
		case CAPS:
			return SWT.CAPS_LOCK;
		case NUM_LOCK:
			return SWT.NUM_LOCK;
		case SCROLL_LOCK:
			return SWT.SCROLL_LOCK;
		case PAUSE:
			return SWT.PAUSE;
		case PRINTSCREEN:
			return SWT.PRINT_SCREEN;
		case HELP:
			return SWT.HELP;
		default:
			break;
		}
		return 0;
	}
}
