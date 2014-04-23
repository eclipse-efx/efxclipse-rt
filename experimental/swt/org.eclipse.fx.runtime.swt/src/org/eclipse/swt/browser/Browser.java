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
package org.eclipse.swt.browser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;

import org.eclipse.swt.SWTException;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Composite;

public class Browser extends Composite {
	private WebView nativeControl;
	
	private List<ProgressListener> progressListeners = new ArrayList<>();
	private List<StatusTextListener> statusTextListeners = new ArrayList<>();
	private List<LocationListener> locationListeners = new ArrayList<>();
	private List<TitleListener> titleListeners = new ArrayList<>();

	private AnchorPane container;
	private String text;
	
	public Browser(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected Region createWidget() {
		container = new AnchorPane();
		nativeControl = new WebView();
		nativeControl.getEngine().locationProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				LocationEvent evt = new LocationEvent(Browser.this);
				evt.top = true;
				evt.location = nativeControl.getEngine().getLocation();
				for( LocationListener l : locationListeners.toArray(new LocationListener[0]) ) {
					l.changed(evt);
				}
			}
		});
		nativeControl.getEngine().titleProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				TitleEvent evt = new TitleEvent(Browser.this);
				evt.title = nativeControl.getEngine().getTitle();
				for( TitleListener l : titleListeners.toArray(new TitleListener[0]) ) {
					l.changed(evt);
				}
			}
		});
//		nativeControl.getEngine().setOnStatusChanged(new EventHandler<WebEvent<String>>() {
//			
//			@Override
//			public void handle(WebEvent<String> event) {
//				StatusTextEvent evt = new StatusTextEvent(Browser.this);
//				evt.text = event.getData();
//				for( StatusTextListener l : statusTextListeners ) {
//					l.changed(evt);
//				}
//			}
//		});
		
		AnchorPane.setBottomAnchor(nativeControl, 0.0);
		AnchorPane.setTopAnchor(nativeControl, 0.0);
		AnchorPane.setLeftAnchor(nativeControl, 0.0);
		AnchorPane.setRightAnchor(nativeControl, 0.0);
		container.getChildren().add(nativeControl);
		return container;
	}
	
	@Override
	public Region internal_getNativeObject() {
		return container;
	}
	
//	public static void clearSessions () {
//		
//	}
//	
//	public static String getCookie (String name, String url) {
//		
//	}
//	
//	public static boolean setCookie (String value, String url) {
//		
//	}
//	
//	public void addAuthenticationListener (AuthenticationListener listener) {
//		
//	}
//	
	public void addCloseWindowListener (CloseWindowListener listener) {
		Util.logNotImplemented();
	}
	
	public void addLocationListener (LocationListener listener) {
		locationListeners.add(listener);
	}
	public void addOpenWindowListener(OpenWindowListener openWindowListener) {
		Util.logNotImplemented();
	}
	
	public void addProgressListener (ProgressListener listener) {
		progressListeners.add(listener);
	}
	
	public void addStatusTextListener (StatusTextListener listener) {
		statusTextListeners.add(listener);
	}
	
	public void addTitleListener (TitleListener listener) {
		titleListeners.add(listener);
	}
	
	public void addVisibilityWindowListener (VisibilityWindowListener listener) {
		Util.logNotImplemented();
	}
	
	public boolean back () {
		final int idx = nativeControl.getEngine().getHistory().getCurrentIndex()-1;
//		String url = nativeControl.getEngine().getHistory().getEntries().get(idx).getUrl();
		return runWithStateTracking(new Runnable() {
			
			@Override
			public void run() {
				nativeControl.getEngine().getHistory().go(idx);
			}
		});
	}
	
	public boolean execute (String script) {
		nativeControl.getEngine().executeScript(script);
		return true;
	}
//	
//	public boolean close () {
//		
//	}
//	
	public Object evaluate (String script) throws SWTException {
		Util.logNotImplemented();
		return null;
	}
	
	public boolean forward () {
		final int idx = nativeControl.getEngine().getHistory().getCurrentIndex()+1;
		return runWithStateTracking(new Runnable() {
			
			@Override
			public void run() {
				nativeControl.getEngine().getHistory().go(idx);
			}
		});

	}
	
	public String getBrowserType () {
		return "webkit/javafx";
	}
	
//	public boolean getJavascriptEnabled () {
//		
//	}
//	
	public String getText () {
		return text;
	}
	
	public String getUrl () {
		return nativeControl.getEngine().getLocation();
	}
//	
//	public Object getWebBrowser () {
//		
//	}
//	
	public boolean isBackEnabled () {
		Util.logNotImplemented();
		return false;
	}
	
	public boolean isForwardEnabled () {
		Util.logNotImplemented();
		return false;
	}
	
	public void refresh () {
		nativeControl.getEngine().reload();
	}
//	
//	public void removeAuthenticationListener (AuthenticationListener listener) {
//		
//	}
//	
//	public void removeCloseWindowListener (CloseWindowListener listener) {
//		
//	}
//	
	public void removeLocationListener (LocationListener listener) {
		Util.logNotImplemented();
	}
//	
//	public void removeOpenWindowListener (OpenWindowListener listener) {
//		
//	}
//	
//	public void removeProgressListener (ProgressListener listener) {
//		
//	}
//	
//	public void removeStatusTextListener (StatusTextListener listener) {
//		
//	}
//	
//	public void removeTitleListener (TitleListener listener) {
//		
//	}
//	
//	public void removeVisibilityWindowListener (VisibilityWindowListener listener) {
//		
//	}
//	
	public void setJavascriptEnabled (boolean enabled) {
		Util.logNotImplemented();
	}
	
	public boolean setText (String html) {
		this.text = html;
		nativeControl.getEngine().loadContent(html);
//		ProgressEvent evt = new ProgressEvent(this);
//		for( ProgressListener l : progressListeners ) {
//			l.completed(evt);
//		}
		return true;
	}
//	
//	public boolean setText (String html, boolean trusted) {
//		
//	}
//	
	public boolean setUrl (final String url) {
		this.text = null;
		LocationEvent evt = new LocationEvent(Browser.this);
		evt.top = true;
		evt.doit = true;
		evt.location = url;
		
		for( LocationListener l : locationListeners.toArray(new LocationListener[0]) ) {
			l.changing(evt);
			if( ! evt.doit ) {
				return false;
			}
		}
		return runWithStateTracking(new Runnable() {
			@Override
			public void run() {
				nativeControl.getEngine().load(url);
			}
		});
	}
	
	private boolean runWithStateTracking(Runnable r) {
		final AtomicBoolean rv = new AtomicBoolean();
		final CountDownLatch wait = new CountDownLatch(1);
		nativeControl.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

			@Override
			public void changed(ObservableValue<? extends State> observable,
					State oldValue, State newValue) {
				if( newValue == State.SUCCEEDED ) {
					rv.set(true);
					ProgressEvent e = new ProgressEvent(Browser.this);
					for( ProgressListener l : progressListeners ) {
						l.completed(e);
					}
					StatusTextEvent te = new StatusTextEvent(Browser.this);
					te.text = nativeControl.getEngine().getLocation();
					for( StatusTextListener l : statusTextListeners ) {
						l.changed(te);
					}
					wait.countDown();
				} else if( newValue == State.FAILED || newValue == State.CANCELLED ) {
					rv.set(false);
					wait.countDown();
				} else if( newValue == State.RUNNING ) {
					ProgressEvent e = new ProgressEvent(Browser.this);
					e.total = 2;
					e.current = 1;
					for( ProgressListener l : progressListeners ) {
						l.changed(e);
					}
				}
			}
		});
		r.run();
//		try {
//			wait.await();
//		} catch (InterruptedException e) {
//			return false;
//		}
		return rv.get();		
	}
	
	
	public boolean setUrl (String url, String postData, String[] headers) {
		Util.logNotImplemented();
		return false;
	}
	
	public void stop () {
		nativeControl.getEngine().getLoadWorker().cancel();
	}


}
