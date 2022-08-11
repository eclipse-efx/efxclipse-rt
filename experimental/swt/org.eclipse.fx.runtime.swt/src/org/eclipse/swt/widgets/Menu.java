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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.WindowEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

public class Menu extends Widget {
	private MenuBar bar;
	private ContextMenu contextMenu;
	private List<MenuItem> items = new ArrayList<>();
	private javafx.scene.control.Menu menu;
	private Decorations decoration;
	private Menu parentMenu;
	private Control control;
	private static EventHandler<javafx.event.Event> SHOWING_HANDLER;
	private static EventHandler<javafx.event.Event> CONTEXT_MENU_SHOWING_HANDLER;
	private ToggleGroup group;
	private static ChangeListener<Toggle> TOGGLE_CHANGE_LISTENER;
	private MenuItem parentItem;
	private static final String DUMMY = "DUMMY";
	
	public Menu (Control parent) {
		super(parent.getDisplay(),SWT.POP_UP);
		this.control = parent;
//		initArm();
	}
	
	public Menu (Decorations parent, int style) {
		super(parent.getDisplay(),style);
		this.decoration = parent;
//		initArm();
	}
	
	public Menu (Menu parentMenu) {
		super(parentMenu.getDisplay(), SWT.DROP_DOWN);
		this.parentMenu = parentMenu;
//		initArm();
	}
	
	public Menu (MenuItem parentItem) {
		super(parentItem.getDisplay(),SWT.DROP_DOWN);
		parentItem.setMenu(this);
		Util.logNotImplemented();
	}

	
//	private void initArm() {
//		if( menu != null ) {
//			if( menu.impl_styleableGetNode() != null ) {
//				final Node node = menu.impl_styleableGetNode();
//				node.focusedProperty().addListener(new InvalidationListener() {
//					
//					@Override
//					public void invalidated(Observable observable) {
//						if( node.isFocused() ) {
//							internal_sendEvent(SWT.Arm, new org.eclipse.swt.widgets.Event(), true);
//						}
//					}
//				});
//			} else if( parentMenu != null || bar != null ) {
//				EventHandler<Event> eventHandler = new EventHandler<Event>() {
//					private boolean initDone;
//					@Override
//					public void handle(Event event) {
//						if( initDone ) {
//							return;
//						}
//						initDone = true;
//						final Node node = menu.impl_styleableGetNode();
//						node.focusedProperty().addListener(new InvalidationListener() {
//							
//							@Override
//							public void invalidated(Observable observable) {
//								if( node.isFocused() ) {
//									System.err.println("ARMED MENU");
//									internal_sendEvent(SWT.Arm, new org.eclipse.swt.widgets.Event(), true);	
//								}
//							}
//						});
//					}
//				};
//				
//				if( this.parentMenu.internal_getNativeObject() instanceof javafx.scene.control.Menu ) {
//					((javafx.scene.control.Menu)this.parentMenu.internal_getNativeObject()).addEventHandler(javafx.scene.control.Menu.ON_SHOWN,eventHandler);			
//				} else if( this.parentMenu.internal_getNativeObject() instanceof ContextMenu ) {
//					((ContextMenu)this.parentMenu.internal_getNativeObject()).addEventHandler(javafx.scene.control.Menu.ON_SHOWN,eventHandler);
//				}
//				
//			}
//		}
//	}
	
	@Override
	protected Object createWidget() {
		if( (style & SWT.BAR) == SWT.BAR ) {
			bar = new MenuBar();
			return bar;
		} else if( (style & SWT.POP_UP) == SWT.POP_UP ) {
			contextMenu = new ContextMenu();
			javafx.scene.control.MenuItem m = new javafx.scene.control.MenuItem("Dummy");
			m.setUserData(DUMMY);
			contextMenu.getItems().add(m);
			contextMenu.addEventHandler(WindowEvent.WINDOW_SHOWING, getContextMenuShowingHandler());
			contextMenu.addEventHandler(WindowEvent.WINDOW_HIDDEN, getContextMenuShowingHandler());
			return contextMenu;
		} else if( (style & SWT.DROP_DOWN) == SWT.DROP_DOWN ) {
			menu = new javafx.scene.control.Menu();
			javafx.scene.control.MenuItem m = new javafx.scene.control.MenuItem("Dummy");
			m.setUserData(DUMMY);
			menu.getItems().add(m);
			menu.addEventHandler(javafx.scene.control.Menu.ON_SHOWING, getMenuShowingHandler());
			menu.addEventHandler(javafx.scene.control.Menu.ON_HIDDEN, getMenuShowingHandler());
		}
		
		return null;
	}
	
	private static EventHandler<Event> getContextMenuShowingHandler() {
		if( CONTEXT_MENU_SHOWING_HANDLER == null ) {
			CONTEXT_MENU_SHOWING_HANDLER = new EventHandler<Event>() {
				
				@Override
				public void handle(Event event) {
					Menu c = Widget.getWidget(event.getSource());
					boolean show = event.getEventType() == javafx.scene.control.Menu.ON_SHOWING || event.getEventType() == WindowEvent.WINDOW_SHOWING;
					if( show ) {
						c.removeDummyItem();
					} else {
						c.addDummyItem();
					}
					c.internal_sendEvent( show ? SWT.Show : SWT.Hide, new org.eclipse.swt.widgets.Event(), true);
				}
			};
		}
		return CONTEXT_MENU_SHOWING_HANDLER;
	}
	
	private static EventHandler<Event> getMenuShowingHandler() {
		if( SHOWING_HANDLER == null ) {
			SHOWING_HANDLER = new EventHandler<Event>() {
				
				@Override
				public void handle(Event event) {
					Menu c = Widget.getWidget(event.getSource());
					if( event.getEventType() == javafx.scene.control.Menu.ON_SHOWING ) {
						c.removeDummyItem();
					} else {
						c.addDummyItem();
					}
					c.internal_sendEvent(event.getEventType() == javafx.scene.control.Menu.ON_SHOWING ? SWT.Show : SWT.Hide, new org.eclipse.swt.widgets.Event(), true);
				}
			};
		}
		return SHOWING_HANDLER;
	}
	
	@Override
	public Object internal_getNativeObject() {
		if( bar != null ) {
			return bar;
		} else if( menu != null ) {
			return menu;
		} else if( contextMenu != null ) {
			return contextMenu;
		}
		return null;
	}

	private void removeDummyItem() {
		if( menu != null ) {
			if( ! menu.getItems().isEmpty() && menu.getItems().get(0).getUserData() == DUMMY ) {
				menu.getItems().clear();
			}
		} else if( contextMenu != null ) {
			if( ! contextMenu.getItems().isEmpty() && contextMenu.getItems().get(0).getUserData() == DUMMY ) {
				contextMenu.getItems().clear();
			}
		}
	}
	
	private void addDummyItem() {
		if( menu != null ) {
			if( menu.getItems().isEmpty() ) {
				javafx.scene.control.MenuItem item = new javafx.scene.control.MenuItem();
				item.setUserData(DUMMY);
				menu.getItems().add(item);
			}
		} else if( contextMenu != null ) {
			if( contextMenu.getItems().isEmpty() ) {
				javafx.scene.control.MenuItem item = new javafx.scene.control.MenuItem();
				item.setUserData(DUMMY);
				contextMenu.getItems().add(item);
			}
		}
	}
	
	void internal_addItem(MenuItem item) {
		removeDummyItem();
		items.add(item);
			if( (item.getStyle() & SWT.RADIO) == SWT.RADIO ) {
				if( group == null ) {
					group = new ToggleGroup();
					group.selectedToggleProperty().addListener(getSelectedChangeListener());
				}
				group.getToggles().add((Toggle) item.internal_getNativeObject());
			}
			if( menu != null ) {
				menu.getItems().add(item.internal_getNativeObject());
			} else if( contextMenu != null ) {
				contextMenu.getItems().add(item.internal_getNativeObject());
			} else {
				bar.getMenus().add((javafx.scene.control.Menu) item.internal_getNativeObject());
			}
	}
	
	void internal_addItem(MenuItem item,int index) {
		removeDummyItem();
		items.add(index,item);
		if( item.internal_getNativeObject() != null ) {
			if( (item.getStyle() & SWT.RADIO) == SWT.RADIO ) {
				if( group == null ) {
					group = new ToggleGroup();
					group.selectedToggleProperty().addListener(getSelectedChangeListener());
				}
				group.getToggles().add((Toggle) item.internal_getNativeObject());
			}
			if( menu != null ) {
				menu.getItems().add(index,item.internal_getNativeObject());
			} else if( contextMenu != null ) {
				contextMenu.getItems().add(index,item.internal_getNativeObject());
			} else {
				bar.getMenus().add(index,(javafx.scene.control.Menu) item.internal_getNativeObject());
			}
		}
	}
	
	void internal_removeItem(MenuItem item) {
		items.remove(item);
		if( item.internal_getNativeObject() != null ) {
			if( (item.getStyle() & SWT.RADIO) == SWT.RADIO ) {
				if( group != null ) {
					group.getToggles().remove(item.internal_getNativeObject());
				}
			}
			if( menu != null ) {
				menu.getItems().remove(item.internal_getNativeObject());	
			} else if( contextMenu != null ) {
				contextMenu.getItems().remove(item.internal_getNativeObject());
			} else {
				bar.getMenus().remove(item.internal_getNativeObject());
			}
		}
		addDummyItem();
	}
	
	private static ChangeListener<Toggle> getSelectedChangeListener() {
		if( TOGGLE_CHANGE_LISTENER == null ) {
			TOGGLE_CHANGE_LISTENER = new ChangeListener<Toggle>() {
				
				@Override
				public void changed(ObservableValue<? extends Toggle> observable,
						Toggle oldValue, Toggle newValue) {
					if( oldValue != null ) {
						org.eclipse.swt.widgets.Event evt = new org.eclipse.swt.widgets.Event();
//						evt.item = Widget.getWidget(oldValue); 
						Widget.getWidget(oldValue).internal_sendEvent(SWT.Selection, evt, true);
					}
					if( newValue != null ) {
						org.eclipse.swt.widgets.Event evt = new org.eclipse.swt.widgets.Event();
//						evt.item = Widget.getWidget(newValue);
						Widget.getWidget(newValue).internal_sendEvent(SWT.Selection, evt, true);
					}
				}
			};
		}
		return TOGGLE_CHANGE_LISTENER;
	}

	void internal_menuAttached(MenuItem menuItem, Menu menu) {
		int idx = items.indexOf(menuItem);
		if( bar != null ) {
			bar.getMenus().remove(idx);
			bar.getMenus().add(idx,(javafx.scene.control.Menu) menu.internal_getNativeObject());
		} else if( this.menu != null ) {
			this.menu.getItems().remove(idx);
			this.menu.getItems().add(idx,(javafx.scene.control.Menu) menu.internal_getNativeObject());
		} else if( this.contextMenu != null ) {
			this.contextMenu.getItems().remove(idx);
			this.contextMenu.getItems().add(idx,(javafx.scene.control.Menu) menu.internal_getNativeObject());
		}
	}
	
	public void addHelpListener (HelpListener listener) {
		Util.logNotImplemented();
	}
	
	public void addMenuListener (MenuListener listener) {
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Hide,typedListener);
		addListener (SWT.Show,typedListener);		
	}
	
//	public MenuItem getDefaultItem () {
//		
//	}
	public boolean getEnabled () {
		if( bar != null ) {
			return ! bar.isDisable();
		} else if( menu != null ) {
			return ! menu.isDisable();
		} else if( contextMenu != null ) {
			return false;
		}
		return false;
	}
	public MenuItem getItem (int index) {
		return items.get(index); 
	}
	public int getItemCount () {
		return items.size();
	}
	public MenuItem [] getItems () {
		return items.toArray(new MenuItem[0]);
	}
//	public int getOrientation () {
//		
//	}
	public Decorations getParent () {
		Util.logNotImplemented();
		return null;
	}
	public MenuItem getParentItem () {
		return parentItem;
	}
	
	void setParentItem(MenuItem parentItem) {
		this.parentItem = parentItem;
		((javafx.scene.control.Menu)menu).setText(parentItem.getText());
	}
	
	public Menu getParentMenu () {
		return parentMenu;
	}
	public Shell getShell () {
		if( parentMenu != null ) {
			return parentMenu.getShell();
		} else if( control != null ) {
			return control.getShell();
		}
		Util.logNotImplemented();
		return null;
	}
	public boolean getVisible () {
		if( menu != null ) {
			return menu.isVisible();
		} else if( contextMenu != null ) {
			return contextMenu.isShowing();
		} else {
			return bar.isVisible();
		}
	}
	public int indexOf (MenuItem item) {
		return items.indexOf(item);
	}
	public boolean isEnabled () {
		return menu != null ? ! menu.isDisable() : true;
	}
	
	public boolean isVisible () {
		if( parentMenu != null ) {
			return getVisible() && parentMenu.isVisible();
		} else if( decoration != null ) {
			return getVisible() && decoration.isVisible();
		} else if( control != null ) {
			return getVisible() && control.isVisible();
		}
		return getVisible();
	}
	
	public void removeHelpListener (HelpListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeMenuListener (MenuListener listener) {
		removeListener (SWT.Hide,listener);
		removeListener (SWT.Show,listener);		
	}
//	public void setDefaultItem (MenuItem item) {
//		
//	}
	public void setEnabled (boolean enabled) {
		if( menu != null ) {
			menu.setDisable(! enabled);
		}
	}
	public void setLocation (int x, int y) {
		if( contextMenu != null ) {
			contextMenu.setX(x);
			contextMenu.setY(y);
		}
	}
	public void setLocation (Point location) {
		setLocation(location.x, location.y);
	}
//	public void setOrientation (int orientation) {
//		
//	}
	public void setVisible (boolean visible) {
		if( contextMenu != null ) {
			Shell s = (Shell) (control != null ? control.getShell() : decoration);
			contextMenu.show(s.internal_getWindow());
		}
	}
}
