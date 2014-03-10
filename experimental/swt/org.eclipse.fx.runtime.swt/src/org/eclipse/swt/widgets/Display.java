package org.eclipse.swt.widgets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.util.Duration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.DeviceData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;

import com.sun.glass.ui.Robot;
import com.sun.javafx.tk.Toolkit;

@SuppressWarnings("restriction")
public class Display extends Device {
	private static Display DEFAULT;
//	private volatile boolean inSleep;
//	private Thread wakeThread;
	private Timer timer;
	private int state;
	private List<DisplayTimerTask> currentTasks = new Vector<>();
	private Color[] widgetColors = new Color[SWT.COLOR_LINK_FOREGROUND + 1];
	private volatile Vector<String> innerLoops = new Vector<>();
	
	private static final int WAKEUP_INITED = 1;
	private static final int KEYED_DATA = 1 << 1;
	private Control focusControl;
	private Timeline hoverTimer = new Timeline();
	
	Cursor [] cursors = new Cursor [SWT.CURSOR_HAND + 1];
	private Control hoverControl;
	private List<Shell> shells = new ArrayList<>();
	private List<Runnable> disposeList;
	private Image[] systemImages = new Image[5];
	private EventTable filterTable;
	private Thread thread;
	private Object data;
	
	public Display() {
		DEFAULT = this;
		this.thread = Thread.currentThread();
		hoverTimer.getKeyFrames().add(new KeyFrame(Duration.millis(560)));
		hoverTimer.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.err.println("ELAPSED: " + hoverControl);
				if( hoverControl != null ) {
					Event evt = new Event();
					Point p = hoverControl.toControl(getCursorLocation());
					evt.x = p.x;
					evt.y = p.y;
					hoverControl.internal_sendEvent(SWT.MouseHover, evt, true);
				}
			}
		});
		initColors();
	}
	
	public Display(DeviceData data2) {
		this();
	}

	private void initColors() {
		widgetColors[SWT.COLOR_INFO_FOREGROUND] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_INFO_BACKGROUND] = new DisplayColor(this, 250, 251, 197);
		widgetColors[SWT.COLOR_TITLE_FOREGROUND] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_TITLE_BACKGROUND] = new DisplayColor(this, 56, 117, 215);
		widgetColors[SWT.COLOR_TITLE_BACKGROUND_GRADIENT] = new DisplayColor(this, 180, 213, 255);
		widgetColors[SWT.COLOR_TITLE_INACTIVE_FOREGROUND] = new DisplayColor(this, 127, 127, 127);
		widgetColors[SWT.COLOR_TITLE_INACTIVE_BACKGROUND] = new DisplayColor(this, 212, 212, 212);
		widgetColors[SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT] = new DisplayColor(this, 212, 212, 212);
		widgetColors[SWT.COLOR_WIDGET_DARK_SHADOW] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_WIDGET_NORMAL_SHADOW] = new DisplayColor(this, 159, 159, 159);
		widgetColors[SWT.COLOR_WIDGET_LIGHT_SHADOW] = new DisplayColor(this, 232, 232, 232);
		widgetColors[SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW] = new DisplayColor(this, 254, 255, 254);
		widgetColors[SWT.COLOR_WIDGET_BACKGROUND] = new DisplayColor(this, 232, 232, 232);
		widgetColors[SWT.COLOR_WIDGET_FOREGROUND] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_WIDGET_BORDER] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_LIST_FOREGROUND] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_LIST_BACKGROUND] = new DisplayColor(this, 255, 255, 255);
		widgetColors[SWT.COLOR_LIST_SELECTION_TEXT] = new DisplayColor(this, 0, 0, 0);
		widgetColors[SWT.COLOR_LIST_SELECTION] = new DisplayColor(this, 180, 213, 255);
		widgetColors[SWT.COLOR_LINK_FOREGROUND] = new DisplayColor(this, 0, 0, 255);
	}
	
	public static Display getCurrent() {
		return Platform.isFxApplicationThread() ? getDefault() : null;
	}
	
	private Timer timer() {
		if( timer == null ) {
			timer = new Timer(true);
		}
		return timer;
	}

	private void initWakeupTask() {
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				if( ! innerLoops.isEmpty() & ! isDisposed() ) {
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							if( ! innerLoops.isEmpty() ) {
								Toolkit.getToolkit().exitNestedEventLoop(innerLoops.remove(0), null);	
							}
						}
					});
				}
			}
			
		};
		timer().scheduleAtFixedRate(task, 200, 200);
	}
	
	public boolean filters(int eventType) {
		if (filterTable == null) return false;
		return filterTable.hooks (eventType);
	}

	public int getLastEventTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void postEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	public boolean filterEvent(Event event) {
		if (filterTable != null) filterTable.sendEvent (event);
		return false;
	}

	public boolean isValidThread() {
		return Platform.isFxApplicationThread();
	}

	public static Display getDefault() {
		if( DEFAULT == null ) {
			DEFAULT = new Display();
		}
		return DEFAULT;
	}

	void runSkin() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean readAndDispatch() {
		return false;
	}
	
	public boolean sleep() {
		innerLoops.add(UUID.randomUUID().toString());
		if( (state & WAKEUP_INITED) == 0 ) {
			state |= WAKEUP_INITED;
			System.err.println("WARNING: Custom even loopspinning in JavaFX is not good. Use SWTUtil to e.g. open a blocking dialog");
			initWakeupTask();
		}
//		System.err.println("Entering: " + innerLoops.get(innerLoops.size()-1));
		Toolkit.getToolkit().enterNestedEventLoop(innerLoops.get(innerLoops.size()-1));
		return true;
	}
	
	@Override
	public Color getSystemColor(int id) {
		Color color = getWidgetColor (id);
		if (color != null) {
			return color;
		}
		return super.getSystemColor(id);
	}
	
	Color getWidgetColor (int id) {
		if (0 <= id && id < widgetColors.length && widgetColors [id] != null) {
			return widgetColors[id];
		}
		return null;
	}
	
	public void syncExec(final Runnable r) {
		if( isValidThread() ) {
			r.run();
		} else {
			final CountDownLatch c = new CountDownLatch(1);
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					try {
						r.run();	
					} finally {
						c.countDown();	
					}
				}
			});
			try {
				c.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void asyncExec(Runnable r) {
		Platform.runLater(r);
	}

	public Point getCursorLocation() {
		Robot r = null;
		try {
			r = com.sun.glass.ui.Application.GetApplication().createRobot();
			return new Point(r.getMouseX(), r.getMouseY());
		} finally {
			if( r != null) {
				r.destroy();
			}
		}
	}

	public void timerExec(int time, final Runnable runnable) {
		if( time < 0 ) {
			DisplayTimerTask[] tasks = currentTasks.toArray(new DisplayTimerTask[0]);
			for( DisplayTimerTask t : tasks ) {
				if( t.r == runnable ) {
					t.cancel();
					currentTasks.remove(t);
				}
			}
		} else {
			timer().schedule(new DisplayTimerTask(currentTasks,runnable), time);	
		}
	}

	public Rectangle getBounds () {
		double minX = 0;
		double minY = 0;
		double width = 0;
		double height = 0;
		for( Screen s : Screen.getScreens() ) {
			minX = Math.min(s.getBounds().getMinX(), minX);
			minY = Math.min(s.getBounds().getMinY(), minY);
			width += s.getBounds().getWidth();
			height += s.getBounds().getHeight();
		}
		return new Rectangle((int)minX, (int)minY, (int)width, (int)height);
	}
	
	public Rectangle getClientArea() {
		double minX = 0;
		double minY = 0;
		double width = 0;
		double height = 0;
		for( Screen s : Screen.getScreens() ) {
			minX = Math.min(s.getVisualBounds().getMinX(), minX);
			minY = Math.min(s.getVisualBounds().getMinY(), minY);
			width += s.getVisualBounds().getWidth();
			height += s.getVisualBounds().getHeight();
		}
		return new Rectangle((int)minX, (int)minY, (int)width, (int)height);
	}
	
	public Point map (Control from, Control to, Point point) {
		return map(from, to, point.x, point.y);
	}
	
	public Point map (Control from, Control to, int x, int y) {
		if( from == to ) {
			return new Point(x, y);
		}
		
		if( from == null ) {
			Point2D localToScreen = to.internal_getNativeObject().screenToLocal(x, y);
			return new Point((int)localToScreen.getX(), (int)localToScreen.getY());
		}
		
		Point2D localToScreen = from.internal_getNativeObject().localToScreen(x, y);
		if( to == null ) {
			return new Point((int)localToScreen.getX(), (int)localToScreen.getY());
		} else {			Point2D sceneToLocal = to.internal_getNativeObject().screenToLocal(localToScreen);
			return new Point((int)sceneToLocal.getX(), (int)sceneToLocal.getY());
		}
	}
	
	public Rectangle map (Control from, Control to, int x, int y, int width, int height) {
		Point p = map(from, to, x, y);
		return new Rectangle(p.x, p.y, width, height);
	}
	
	public Rectangle map (Control from, Control to, Rectangle r) {
		return map(from, to, r.x, r.y, r.width, r.height); 
	}
	
	public Cursor getSystemCursor(int id) {
		if( id < cursors.length ) {
			if( cursors[id] == null ) {
				cursors[id] = new DisplayCursor(this, id);
			}
			return cursors[id];
		}
		return null;
	}
	
	public void setCursorLocation(Point p) {
		Robot r = null;
		try {
			r = com.sun.glass.ui.Application.GetApplication().createRobot();
			r.mouseMove(p.x, p.y);
		} finally {
			if( r != null) {
				r.destroy();
			}
		}
	}
	
	public int getDepth() {
		Util.logNotImplemented();
		return 32;
	}
	
	public Point getDPI() {
		return new Point((int)Screen.getPrimary().getDpi(),(int)Screen.getPrimary().getDpi());
	}
	
	void setFocusControl(Control focusControl) {
		if( this.focusControl != focusControl ) {
			Control oldFocusControl = this.focusControl;
			this.focusControl = focusControl;
			
			if( oldFocusControl != null ) {
				oldFocusControl.internal_sendEvent(SWT.FocusOut, new Event(), true);
			}
			if( this.focusControl != null ) {
				this.focusControl.internal_sendEvent(SWT.FocusIn, new Event(), true);
			}
		}
	}
	
	public Control getFocusControl() {
		return focusControl;
	}
	
	public Control getCursorControl() {
		for( Widget w : Widget.NATIVE_WIDGET_MAP.values() ) {
			if( w instanceof Shell ) {
				Shell s = (Shell) w;
				if( s.internal_getWindow().isFocused() ) {
					Point p = getCursorLocation();
					if( s.getBounds().contains(p.x, p.y) ) {
						return findControl(s, p.x, p.y);
					}
					return null;
				}
			}
		}
		return null;
	}
	
	private Control findControl(Composite parent, int x, int y) {
		for( Control c : parent.getChildren() ) {
			if( c.getBounds().contains(c.toControl(x, y)) ) {
				Control rv = findControl(parent, x, y);
				if( rv != null ) {
					return rv;
				}
				return c;
			}
		}
		return null;
	}
	
	public Monitor getPrimaryMonitor() {
		return new Monitor(Screen.getPrimary());
	}
	
	public Monitor [] getMonitors () {
		ObservableList<Screen> screens = Screen.getScreens();
		Monitor[] rv = new Monitor[screens.size()];
		for( int i = 0; i < rv.length; i++ ) {
			rv[i] = new Monitor(screens.get(i));
		}
		return rv;
	}
	
	void setHoverControl(Control control) {
		this.hoverControl = control;
		hoverTimer.stop();
		hoverTimer.playFromStart();
	}
	
	static class DisplayColor extends Color {

		public DisplayColor(Device device, int red, int green, int blue) {
			super(device, red, green, blue);
		}
		
	}
	
	static class DisplayCursor extends Cursor {

		public DisplayCursor(Device device, int style) {
			super(device, style);
		}
		
		@Override
		public void dispose() {
			
		}
	}
	
	static class DisplayTimerTask extends TimerTask {
		private List<DisplayTimerTask> tasks;
		private Runnable r;

		public DisplayTimerTask(List<DisplayTimerTask> tasks, Runnable r) {
			this.tasks = tasks;
			this.r = r;
			this.tasks.add(this);
		}
		
		@Override
		public void run() {
			this.tasks.remove(this);
			Platform.runLater(r);
			this.r = null;
		}
	}

	public void wake() {
		Util.logNotImplemented();
	}
	
	public Shell[] getShells() {
		return shells.toArray(new Shell[0]);
	}
	
	public int getDoubleClickTime() {
		return 500; //TODO Can we read this from the OS???
	}
	
	public int getDismissalAlignment() {
		return SWT.LEFT; //TODO Should we check of OS-X and return RIGHT??
	}
	
	void registerShell(Shell shell) {
		shells.add(shell);
	}
	
	void unregisterShell(Shell shell) {
		shells.remove(shell);
	}
	
	public Shell getActiveShell() {
		for( Shell s : shells ) {
			if( s.internal_getWindow().isFocused() ) {
				return s;
			}
		}
		return null;
	}
	
	public void beep() {
		Util.logNotImplemented();
	}
	
	public void post(Event event) {
		Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
		switch (event.type) {
		case SWT.MouseMove:
			robot.mouseMove(event.x, event.y);
			break;
		case SWT.MouseDown:
			robot.mousePress(event.button); 
			break;
		case SWT.MouseUp:
			robot.mouseRelease(event.button);
			break;
		case SWT.KeyDown:
			robot.keyPress(fromSWT(event).impl_getCode());
			break;
		case SWT.KeyUp:
			robot.keyRelease(fromSWT(event).impl_getCode());
			break;
		default:
			break;
		}
		
		robot.destroy();
	}
	
	private static KeyCode fromSWT(Event evt) {
		if( evt.character != 0 ) {
			KeyCode keyCode = KeyCode.getKeyCode(Character.toUpperCase(evt.character)+"");
			if( keyCode == null ) {
				switch (evt.character) {
				case ' ':
					keyCode = KeyCode.SPACE;
					break;
				case '.':
					keyCode = KeyCode.PERIOD;
					break;
				default:
					break;
				}
			}
			
			if( keyCode == null ) {
				System.err.println("Unable to convert: " + evt.character);
			}
			
			return keyCode == null ? KeyCode.UNDEFINED : keyCode;
		} else if( evt.keyCode != 0 ) {
			switch (evt.keyCode) {
			case SWT.SHIFT:
				return KeyCode.SHIFT;
			case SWT.CTRL:
				return KeyCode.CONTROL;
			case SWT.COMMAND:
				return KeyCode.COMMAND;
			case SWT.ALT:
				return KeyCode.ALT;
			default:
				break;
			}
		}
		
		return KeyCode.UNDEFINED;
	}

	public void update() {
		Util.logNotImplemented();
	}
	
	public void disposeExec (Runnable runnable) {
		if( disposeList == null ) {
			disposeList = new ArrayList<>();
		}
		disposeList.add(runnable);
	}
	
	@Override
	public void dispose() {
		if( disposeList != null ) {
			for( Runnable r : disposeList ) {
				r.run();
			}
		}
		super.dispose();
	}
	
	public Image getSystemImage (int id) {
		switch (id) {
		case SWT.ICON_ERROR:
			if( systemImages[0] == null ) {
				try(InputStream in = getClass().getResourceAsStream("dialog-error.png")) {
					systemImages[0] = new Image(this, in);	
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return systemImages[0];
		case SWT.ICON_INFORMATION:
			if( systemImages[1] == null ) {
				try(InputStream in = getClass().getResourceAsStream("dialog-information.png")) {
					systemImages[1] = new Image(this, in);	
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return systemImages[1];
		case SWT.ICON_QUESTION:
			if( systemImages[2] == null ) {
				try(InputStream in = getClass().getResourceAsStream("help-contents.png")) {
					systemImages[2] = new Image(this, in);	
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return systemImages[2];
		case SWT.ICON_WORKING:
			if( systemImages[3] == null ) {
				try(InputStream in = getClass().getResourceAsStream("user-away-extended.png")) {
					systemImages[3] = new Image(this, in);	
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return systemImages[3];
		case SWT.ICON_WARNING:
			if( systemImages[4] == null ) {
				try(InputStream in = getClass().getResourceAsStream("dialog-warning.png")) {
					systemImages[4] = new Image(this, in);	
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return systemImages[4];
		default:
			break;
		}
		return null;
	}

	public boolean getHighContrast() {
		Util.logNotImplemented();
		return false;
	}

	public void addFilter(int eventType, Listener listener) {
		if (filterTable == null) 
			filterTable = new EventTable ();
		
		filterTable.hook (eventType, listener);
	}

	public void removeFilter(int eventType, Listener listener) {
		if (filterTable != null) 
			filterTable.unhook(eventType, listener);
	}
	
	public void addListener(int eventType, Listener listener) {
		Util.logNotImplemented();
	}
	
	public Thread getThread () {
		return thread;
	}

	public Tray getSystemTray() {
		Util.logNotImplemented();
		return null;
	}
	
	public void setData (Object data) {
		if ((state & KEYED_DATA) != 0) {
			((Object []) this.data) [0] = data;
		} else {
			this.data = data;
		}
	}

	public void setData (String key, Object value) {
		if (key == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		int index = 1;
		Object [] table = null;
		if ((state & KEYED_DATA) != 0) {
			table = (Object []) data;
			while (index < table.length) {
				if (key.equals (table [index])) break;
				index += 2;
			}
		}
		if (value != null) {
			if ((state & KEYED_DATA) != 0) {
				if (index == table.length) {
					Object [] newTable = new Object [table.length + 2];
					System.arraycopy (table, 0, newTable, 0, table.length);
					data = table = newTable;
				}
			} else {
				table = new Object [3];
				table [0] = data;
				data = table;
				state |= KEYED_DATA;
			}
			table [index] = key;
			table [index + 1] = value;
		} else {
			if ((state & KEYED_DATA) != 0) {
				if (index != table.length) {
					int length = table.length - 2;
					if (length == 1) {
						data = table [0];
						state &= ~KEYED_DATA;
					} else {
						Object [] newTable = new Object [length];
						System.arraycopy (table, 0, newTable, 0, index);
						System.arraycopy (table, index + 2, newTable, index, length - index);
						data = newTable;
					}
				}
			}
		}
	}
	
	public Object getData () {
		return (state & KEYED_DATA) != 0 ? ((Object []) data) [0] : data;
	}
	
	public Object getData (String key) {
		if (key == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
		if ((state & KEYED_DATA) != 0) {
			Object [] table = (Object []) data;
			for (int i=1; i<table.length; i+=2) {
				if (key.equals (table [i])) return table [i+1];
			}
		}
		return null;
	}

	public static void setAppName(String name) {
		com.sun.glass.ui.Application.GetApplication().setName(name);
	}
	
	public static Display findDisplay(Thread thread) {
		//TODO Should we allow more displays????
		if( DEFAULT == null ) {
			return null;
		}
		
		if( DEFAULT.thread == thread ) {
			return DEFAULT;
		}
		return null;
	}

	void wakeThread() {
		Util.logNotImplemented();
	}

	public void removeListener(int settings, Listener settingsChangeListener) {
		Util.logNotImplemented();
	}

	public void setWarnings(boolean b) {
		Util.logNotImplemented();
	}

	public void setSynchronizer(Synchronizer synchronizer) {
		Util.logNotImplemented();
	}
}