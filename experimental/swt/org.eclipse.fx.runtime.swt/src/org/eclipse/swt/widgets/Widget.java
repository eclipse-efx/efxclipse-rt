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

import java.util.WeakHashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.internal.SWTEventListener;

public abstract class Widget {
	static final int DISPOSED		= 1<<0;
	static final int KEYED_DATA		= 1<<2;
	static final int DISABLED       = 1 << 3;
	
	static final int LAYOUT_NEEDED	= 1<<12;
	static final int LAYOUT_CHANGED = 1<<13;
	static final int LAYOUT_CHILD = 1<<14;
	
	static final int DISPOSE_SENT = 1<<16;
	static final int RELEASED = 1<<15;
	
	static final int DATA_SET = 1 << 27;
	static final int MOUSE_EXIT = 1<<28;
	static final int MOUSE_ENTER = 1<<29;
	static final int CSS_PROCESSED  = 1<<30;
	static final int NO_EVENT = 1 << 31;
	
	static final int RESIZE_ATTACHED = 1 << 29;

	private boolean noEvent;
	
	static final int DEFAULT_WIDTH	= 64;
	static final int DEFAULT_HEIGHT	= 64;
	private EventTable eventTable;
	private Display display;
	int style;
	long state;
	Object data;
	
	static final WeakHashMap<Object, Widget> NATIVE_WIDGET_MAP = new WeakHashMap<Object, Widget>();
	protected Object nativeObject;
	
	public Widget(Display display, int style) {
		this.display = display;
		this.style = style;
		this.state |= MOUSE_EXIT;
		nativeObject = createWidget();
		initListeners();
		registerConnection(internal_getNativeObject()); 
	}
	
	public Widget(Display display, Object nativeObject, int style) {
		this.display = display;
		this.style = style;
		this.state |= MOUSE_EXIT;
		this.nativeObject = nativeObject;
		initListeners();
		registerConnection(internal_getNativeObject()); 
	}
	
	public Widget (Widget parent, int style) {
		this(parent.display,style);
	}
	
	protected void checkWidget () {
		//FIXME Implement
	}

	protected void registerConnection(Object o) {
//		System.err.println("m " + o + "<=>" + this);
		NATIVE_WIDGET_MAP.put(o, this);
	}
	
	protected void unregisterConnection(Object o) {
		NATIVE_WIDGET_MAP.remove(o);
	}
	
	@SuppressWarnings("unchecked")
	static <W extends Widget> W getWidget(Object o) {
		return (W) NATIVE_WIDGET_MAP.get(o);
	}
	
	public Display getDisplay() {
		if (display == null)
			display = Display.getCurrent();
		return display;
	}
	
	public int getStyle() {
		checkWidget();
		return style;
	}
	
	protected abstract Object createWidget();

	public abstract Object internal_getNativeObject();

	protected void registerListener(int eventType, Listener listener) {
		if (eventTable == null)
			eventTable = new EventTable();
		eventTable.hook(eventType, listener);
	}
	
	protected void unregisterListener(int eventType, SWTEventListener listener) {
		if (eventTable == null) return;
		eventTable.unhook (eventType, listener);
	}
	
	protected void initListeners() {
		
	}
	
	protected void uninitListeners() {
		
	}
	
	protected void internal_sendEvent (int eventType, Event event, boolean send) {
		if( noEvent ) {
			return;
		}
		
		if (eventTable == null && !display.filters (eventType)) {
			return;
		}
		if (event == null) event = new Event ();
		event.type = eventType;
		event.display = display;
		event.widget = this;
		if (event.time == 0) {
			event.time = display.getLastEventTime ();
		}
		if (send) {
			sendEvent (event);
		} else {
			display.postEvent (event);
		}
	}
	
	void sendEvent (Event event) {
		Display display = event.display;
		if (!display.filterEvent (event)) {
			if (eventTable != null) eventTable.sendEvent (event);
		}
	}
	
	protected static String notNullString(String s) {
		return s == null ? "" : s;
	}
	
	protected void error(int errorNullArgument) {
		// FIXME Implement
		
	}
	
	public void addDisposeListener (DisposeListener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Dispose, typedListener);
	}
	
	public void addListener (int eventType, Listener listener) {
		if (eventTable == null) eventTable = new EventTable ();
		eventTable.hook (eventType, listener);
	}
	
	public void removeListener (int eventType, Listener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		if (eventTable == null) return;
		eventTable.unhook (eventType, listener);
	}

	protected void removeListener (int eventType, SWTEventListener handler) {
		checkWidget();
		if (handler == null) error (SWT.ERROR_NULL_ARGUMENT);
		if (eventTable == null) return;
		eventTable.unhook (eventType, handler);
	}
	
	public void dispose () {
		Object o = internal_getNativeObject();
		state |= DISPOSED;
		release(true);
		unregisterConnection(o);
	}
	
	void release(boolean destroy) {
		if ((state & DISPOSE_SENT) == 0) {
			state |= DISPOSE_SENT;
			internal_sendEvent (SWT.Dispose, new Event(), true);
		}
		
//		if ((state & DISPOSED) == 0) {
//			releaseChildren (destroy);
//		}
//		if ((state & RELEASED) == 0) {
//			state |= RELEASED;
//			if (destroy) {
//				releaseParent ();
//				releaseWidget ();
//				destroyWidget ();
//			} else {
//				releaseWidget ();
//				releaseHandle ();
//			}
//		}
	}
	
	public Object getData () {
		checkWidget();
		return (state & KEYED_DATA) != 0 ? ((Object []) data) [0] : data;
	}
	
	public Object getData (String key) {
		checkWidget();
		if (key == null) error (SWT.ERROR_NULL_ARGUMENT);
		if ((state & KEYED_DATA) != 0) {
			Object [] table = (Object []) data;
			for (int i=1; i<table.length; i+=2) {
				if (key.equals (table [i])) return table [i+1];
			}
		}
		return null;
	}
	
	public Listener[] getListeners (int eventType) {
		checkWidget();
		if (eventTable == null) return new Listener[0];
		return eventTable.getListeners(eventType);
	}
	
	public boolean isDisposed () {
		return (state & DISPOSED) != 0;
	}
//	
//	public boolean isListening (int eventType) {
//		
//	}
//	
	public void notifyListeners (int eventType, Event event) {
		if (event == null) event = new Event ();
		internal_sendEvent(eventType, event, true);
	}
	
	public void removeDisposeListener (DisposeListener listener) {
		if (eventTable == null) return;
		eventTable.unhook (SWT.Dispose, listener);
	}
//	
//	public void removeListener (int eventType, Listener listener) {
//		
//	}
//	
//	public void reskin (int flags) {
//		
//	}
//	
	public void setData (Object data) {
		checkWidget();
		if ((state & KEYED_DATA) != 0) {
			((Object []) this.data) [0] = data;
		} else {
			this.data = data;
		}
	}
	
	public void setData (String key, Object value) {
		checkWidget();
		if (key == null) error (SWT.ERROR_NULL_ARGUMENT);
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
		if (key.equals(SWT.SKIN_CLASS) || key.equals(SWT.SKIN_ID)) this.reskin(SWT.ALL);
	}

	public void reskin (int flags) {
		checkWidget ();
		reskinWidget ();
		if ((flags & SWT.ALL) != 0) reskinChildren (flags);
	}
	
	void reskinChildren (int flags) {	
	}

	void reskinWidget() {
//		if ((state & SKIN_NEEDED) != SKIN_NEEDED) {
//			this.state |= SKIN_NEEDED;
//			display.addSkinnableWidget(this);
//		}
	}

	
	public String toString () {
		String string = "*Disposed*"; //$NON-NLS-1$
		if (!isDisposed ()) {
			string = "*Wrong Thread*"; //$NON-NLS-1$
			if (isValidThread ()) string = getNameText ();
		}
		return getName () + " {" + string + "}"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	boolean isValidThread () {
		return getDisplay ().isValidThread ();
	}
	
	protected String getNameText () {
		return "";
	}
	
	protected String getName () {
		String string = getClass ().getName ();
		int index = string.lastIndexOf ('.');
		if (index == -1) return string;
		return string.substring (index + 1, string.length ());
	}
	
	protected void internal_runNoEvent(Runnable runnable) {
		try {
			noEvent = true;
			runnable.run();
		} finally {
			noEvent = false;
		}
		
	}
	
	public boolean isListening (int eventType) {
		return eventTable != null && eventTable.hooks (eventType);
	}
	
	protected void checkSubclass() {
		//TODO Call and implement
	}
}
