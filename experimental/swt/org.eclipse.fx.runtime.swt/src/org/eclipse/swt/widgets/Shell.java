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

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;

import com.sun.javafx.geom.Area;
import com.sun.javafx.geom.PathIterator;

public class Shell extends Decorations {
	private Stage stage;
	private static final double MIN_WIDTH = 500;
	private static final double MIN_HEIGHT = 200;
	private BorderPane nativeObject;
	private Shell parentShell;
	private org.eclipse.swt.graphics.Region region;

	public Shell() {
		super(Display.getCurrent(), SWT.DIALOG_TRIM);
	}
	
	public Shell(Display d) {
		super(d, SWT.DIALOG_TRIM);
	}

	public Shell(Display d, int style) {
		super(d, style);
	}
	
	public Shell(Shell s) {
		this(s.getDisplay());
		stage.initOwner(s.stage);
		this.parentShell = s;
	}

	public Shell(int style) {
		this(Display.getDefault(),style);
	}

	public Shell(Shell shell, int style) {
		this(shell.getDisplay(), style);
		stage.initOwner(shell.stage);
		this.parentShell = shell;
	}

	public Shell(Stage stage) {
		super(Display.getDefault(),SWT.NONE);
		this.stage = stage;
	}
	
	@Override
	protected Region createWidget() {
		if( stage != null ) {
			return nativeObject = new BorderPane();
		}
		
		Region r = super.createWidget();
		nativeObject = new BorderPane();
		nativeObject.setCenter(r);
		
		stage = new Stage();
		final Scene s = new Scene(internal_getNativeObject());
		s.getStylesheets().add(getClass().getClassLoader().getResource("org/eclipse/swt/internal/swt.css").toExternalForm());
		stage.setScene(s);
		//TODO what to do with SWT.TOOL???
		if( /* (getStyle() & SWT.TOOL) == SWT.TOOL ||*/ (getStyle() & SWT.NO_TRIM) == SWT.NO_TRIM ) {
			stage.initStyle(StageStyle.UNDECORATED);
		}
		if( (style & SWT.APPLICATION_MODAL) == SWT.APPLICATION_MODAL ) {
			stage.initModality(Modality.APPLICATION_MODAL);
		} else if( (style & SWT.PRIMARY_MODAL) == SWT.PRIMARY_MODAL ) {
			Util.logNotImplemented();
		}
		
		
		if( (getStyle() & SWT.NO_FOCUS) == SWT.NO_FOCUS ) {
			System.err.println("NO FOCUS NOT IMPLEMENTED");
		}
		stage.setOnShowing(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				if( stage.widthProperty().getValue().equals(Double.NaN) && stage.heightProperty().getValue().equals(Double.NaN) ) {
					stage.setWidth(MIN_WIDTH);
					stage.setHeight(MIN_HEIGHT);
				}
			}
		});
		stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				if( isListening(SWT.Close) ) {
					Event evt = new Event();
					internal_sendEvent(SWT.Close, evt, true);
					if( ! evt.doit ) {
						event.consume();
					}
				}
			}
		});
		stage.focusedProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				if( s.getFocusOwner() != null ) {
					Object o = Widget.getWidget(s.getFocusOwner());
					if( o instanceof Control ) {
						getDisplay().setFocusControl((Control) o);	
					}
				} else {
					getDisplay().setFocusControl(null);
				}
			}
		});
		s.focusOwnerProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				if( stage.isFocused() ) {
					if( s.getFocusOwner() != null ) {
						Object o = Widget.getWidget(s.getFocusOwner());
						if( o instanceof Control ) {
							getDisplay().setFocusControl((Control) o);	
						}
					} else {
						getDisplay().setFocusControl(null);
					}
				}
			}
		});
		
		getDisplay().registerShell(this);
		
		return nativeObject;
	}
	
	@Override
	public Region internal_getNativeObject() {
		return nativeObject;
	}
	
	@Override
	protected void initListeners() {
		super.initListeners();
		stage.setOnHidden(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				dispose();
			}
		});
	}

	public void open() {
		stage.show();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		setFullScreen(false);
		stage.setX(x);
		stage.setY(y);
		stage.setWidth(width);
		stage.setHeight(height);
	}

	@Override
	public void setLocation(int x, int y) {
		stage.setX(x);
		stage.setY(y);
	}
	
	@Override
	public void setText(String string) {
		stage.setTitle(string);
	}

	@Override
	public String getText() {
		return stage.getTitle();
	}
	
	@Override
	public void setImage(Image image) {
		Image oldImage = getImage();
		super.setImage(image);
		
		if( oldImage != null ) {
			stage.getIcons().remove(oldImage.internal_getImage());
		}
		
		if( image != null ) {
			stage.getIcons().add(image.internal_getImage());
		}
	}
	
	@Override
	protected double internal_getWidth() {
		return stage.getWidth();
	}
	
	@Override
	protected double internal_getHeight() {
		return stage.getHeight();
	}
	
	@Override
	public Point getLocation() {
		return new Point((int)stage.getX(), (int)stage.getY());
	}
	
	@Override
	public void setSize(int width, int height) {
		stage.setWidth(width);
		stage.setHeight(height);
	}
	
	@Override
	public Point getSize() {
		return new Point((int)stage.getWidth(), (int)stage.getHeight());
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)stage.getX(), (int)stage.getY(), (int)stage.getWidth(), (int)stage.getHeight());
	}

	public void setFullScreen(boolean selection) {
		stage.setFullScreen(selection);
	}
	
	@Override
	public Composite getParent() {
		// TODO Does it need another implementation???
		return super.getParent();
	}
	
	@Override
	public Shell getShell() {
		return this;
	}
	
	@Override
	public void pack() {
		stage.sizeToScene();
	}
	
	public Window internal_getWindow() {
		return stage;
	}
	
	@Override
	public void setDefaultButton(Button defaultButton) {
		Button b = getDefaultButton();
		if( b != null ) {
			b.internal_setDefault(false);
		}
		
		super.setDefaultButton(defaultButton);
		
		if( defaultButton != null ) {
			defaultButton.internal_setDefault(true);
		}
	}
	
	public void addShellListener(ShellListener listener) {
		Util.logNotImplemented();
	}
	
	public void close () {
		stage.close();
	}
	
	public int getAlpha () {
		return 255 - (int)(stage.getOpacity() * 255);
	}
	
//	public int getImeInputMode () {
//		
//	}
	
	public boolean getMaximized () {
		return stage.isMaximized();
	}
	
//	public boolean getModified () {
//		return false;
//	}
	
	public boolean getMinimized () {
		return stage.isIconified();
	}
	
	public Point getMinimumSize () {
		return new Point((int)stage.getMinWidth(), (int)stage.getMinHeight());
	}
	
	public org.eclipse.swt.graphics.Region getRegion () {
		return region;
	}
	
	public Shell [] getShells () {
		java.util.List<Shell> shells = new ArrayList<>();
		for( Shell s : getDisplay().getShells() ) {
			if( s.parentShell == this ) {
				shells.add(s);
			}
		}
		return shells.toArray(new Shell[shells.size()]);
	}
	
//	public ToolBar getToolBar() {
//		
//	}
	
//	public boolean isEnabled () {
//		return true;
//	}
	public boolean isVisible () {
		return getVisible();
	}
	
	@Override
	public boolean isEnabled() {
		return getEnabled();
	}
	
//	
//	public boolean print (GC gc) {
//		
//	}
//	
	public void removeShellListener(ShellListener listener) {
		Util.logNotImplemented();
	}
	
	public void setActive () {
		stage.toFront();
		stage.setFocused(true);
	}
	
	public void setAlpha (int alpha) {
		stage.setOpacity(alpha/255.0);
	}
//	
//	public void setFullScreen (boolean fullScreen) {
//		
//	}
//	
	public void setMenuBar (Menu menu) {
		if( (menu.style & SWT.BAR) == SWT.BAR ) {
			nativeObject.setTop((Node)menu.internal_getNativeObject());
		}
		super.setMenuBar(menu);
	}
//	
//	public void setImeInputMode (int mode) {
//		
//	}
//	
	public void setMaximized (boolean maximized) {
		stage.setMaximized(true);
		super.setMaximized(maximized);
	}
	
	public void setMinimized (boolean minimized) {
		stage.setIconified(true);
		super.setMinimized(minimized);
	}
	
	public void setMinimumSize (int width, int height) {
		stage.setMinWidth(width);
		stage.setMinHeight(height);
	}
	
	public void setMinimumSize (Point size) {
		setMinimumSize(size.x, size.y);
	}
	
	public void setModified (boolean modified) {
		Util.logNotImplemented();
	}
	
	public void setRegion (org.eclipse.swt.graphics.Region region) {
		float coords[] = new float[6];
		
		float x = 0;
		float y = 0;
		
		PathIterator pathIterator = region.internal_getNativeObject().getPathIterator(null);
		
		Path p = new Path();
		
		p.getElements().add(new MoveTo(0, 0));
		
		while( ! pathIterator.isDone() ) {
			switch (pathIterator.currentSegment(coords)) {
			case PathIterator.SEG_CLOSE:
				p.getElements().add(new LineTo(x, y));
				break;
			case PathIterator.SEG_CUBICTO:
//				p.getElements().add( new BezierCurveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
				break;
			case PathIterator.SEG_LINETO:
				p.getElements().add(new LineTo(coords[0], coords[1]));
				break;
			case PathIterator.SEG_MOVETO:
				p.getElements().add(new MoveTo(coords[0], coords[1]));
				x = coords[0];
				y = coords[1];
				break;
			case PathIterator.SEG_QUADTO:
//				gc.quadraticCurveTo(coords[0], coords[1], coords[2], coords[3]);
				break;
			default:
				break;
			}
			pathIterator.next();
		}
		
		stage.getScene().getRoot().setClip(p);
		this.region = region;
	}
	
	public void setVisible (boolean visible) {
		if( visible ) {
			stage.show();	
		} else {
			if( stage.isShowing() ) {
				stage.hide();	
			}
		}
		
	}
	
	@Override
	public void dispose() {
		getDisplay().unregisterShell(this);
		super.dispose();
		stage.close();
	}
	
	@Override
	public void setImages(Image[] images) {
		super.setImages(images);
		javafx.scene.image.Image[] imgs = new javafx.scene.image.Image[images.length];
		
		for(int i = 0; i < imgs.length; i++) {
			imgs[i] = images[i].internal_getImage();
		}
		
		stage.getIcons().setAll(imgs);
	}

	public void forceActive () {
		Util.logNotImplemented();
	}
	
	@Override
	public void moveAbove(Control control) {
//		super.moveAbove(control);
	}
	
	@Override
	public void moveBelow(Control control) {
//		super.moveBelow(control);
	}
}
