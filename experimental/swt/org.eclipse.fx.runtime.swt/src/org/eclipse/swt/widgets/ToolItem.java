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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class ToolItem extends Item {
	private Region nativeControl;
	private ToolBar parent;
	private Tooltip tooltip;
	private String tooltipText;
	
	private InvalidationListener disabledListener;
	private EventHandler<MouseEvent> mouseHandler;
	private Image disabledImage;
	private Image hotImage;
	private boolean hover;
	private int width;
	private org.eclipse.swt.widgets.Control control;
	
	
	public ToolItem(ToolBar parent, int style) {
		super(parent, style);
		this.parent = parent;
		parent.internal_itemAdded(this);
	}
	
	public ToolItem (ToolBar parent, int style, int index) {
		super(parent, style);
		this.parent = parent;
		parent.internal_itemAdded(this, index);
	}

	@Override
	protected Node createWidget() {
		if( (style & SWT.CHECK) == SWT.CHECK ) {
			nativeControl = new CheckBox();
		} else if( (style & SWT.RADIO) == SWT.RADIO ) {
			nativeControl = new RadioButton();
		} else if( (style & SWT.SEPARATOR) == SWT.SEPARATOR ) {
			nativeControl = new StackPane(new Separator()); 
		} else if( (style & SWT.DROP_DOWN) == SWT.DROP_DOWN ) {
			MenuButton m = new MenuButton();
			m.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					Node n = (Node) event.getTarget();
					Event evt = new Event();
					if( n.getStyleClass().contains("arrow") ) {
						evt.detail = SWT.ARROW;
					}
					internal_sendEvent(SWT.Selection, evt, true);
				}
			});
			nativeControl = m;
		} else {
			nativeControl = new Button();
			nativeControl.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Event evt = new Event();
					internal_sendEvent(SWT.Selection, evt, true);
				}
			});
//			nativeControl.setMouseTransparent(true);
		}
		return nativeControl;
	}

	@Override
	public Node internal_getNativeObject() {
		return nativeControl;
	}
	
	@Override
	public void setImage(Image image) {
		super.setImage(image);
		
		if( hotImage != null || disabledImage != null ) {
			updateStateImage();
		} else {
			if( nativeControl instanceof ButtonBase ) {
				((ButtonBase) nativeControl).setGraphic(image == null ? null : new ImageView(image.internal_getImage()));
			}	
		}		
	}
	
	@Override
	public void setText(String string) {
		super.setText(string);
		if( nativeControl instanceof ButtonBase ) {
			((ButtonBase) nativeControl).setText(string);
		}
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Selection,typedListener);
		addListener(SWT.DefaultSelection,typedListener);
	}
	
	@Override
	public void dispose() {
		parent.internal_itemRemoved(this);
		super.dispose();
	}
	
	public Rectangle getBounds () {
		return new Rectangle((int)nativeControl.getLayoutX(), (int)nativeControl.getLayoutY(), (int)nativeControl.getWidth(), (int)nativeControl.getHeight());
	}
	
	public org.eclipse.swt.widgets.Control getControl () {
		return control;
	}

	public Image getDisabledImage () {
		return disabledImage;
	}
	
	public boolean getEnabled () {
		return ! nativeControl.isDisable();
	}
	
	public Image getHotImage () {
		return hotImage;
	}
	
	public ToolBar getParent () {
		return parent;
	}
	
	public boolean getSelection () {
		if( nativeControl instanceof CheckBox ) {
			return ((CheckBox) nativeControl).isSelected();
		} else if( nativeControl instanceof RadioButton ) {
			return ((RadioButton) nativeControl).isSelected();
		}
		return false;
	}
	
	public String getToolTipText () {
		return tooltipText;
	}
	
	public int getWidth () {
		return width;
	}
	
	public boolean isEnabled () {
		return ! nativeControl.isDisabled();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection, listener);
	}

	public void setControl (org.eclipse.swt.widgets.Control control) {
		this.control = control;
		if( (style & SWT.SEPARATOR) == SWT.SEPARATOR ) {
			if( control == null ) {
				((StackPane)nativeControl).getChildren().setAll(new Separator());
			} else {
				((StackPane)nativeControl).getChildren().setAll(control.internal_getNativeObject());	
			}
		}
	}
	
	public void setEnabled (boolean enabled) {
		nativeControl.setDisable(!enabled);
	}
	
	public void setDisabledImage (Image image) {
		this.disabledImage = image;
		if( image != null ) {
			if( disabledListener == null ) {
				nativeControl.disabledProperty().addListener(getDisabledListener());
			}			
		} else {
			if( disabledListener != null ) {
				nativeControl.disabledProperty().removeListener(getDisabledListener());
				disabledListener = null;
			}
		}
	}
	
	public void setHotImage (Image image) {
		this.hotImage = image;
		if( image != null ) {
			if( mouseHandler == null ) {
				nativeControl.addEventHandler(MouseEvent.MOUSE_ENTERED, getMouseHandler());	
				nativeControl.addEventHandler(MouseEvent.MOUSE_EXITED, getMouseHandler());	
			}
		} else {
			if( mouseHandler != null ) {
				nativeControl.removeEventHandler(MouseEvent.MOUSE_ENTERED, getMouseHandler());	
				nativeControl.removeEventHandler(MouseEvent.MOUSE_EXITED, getMouseHandler());	
				hover = false;
				mouseHandler = null;
			}
		}
		
	}
	
	public void setSelection (boolean selected) {
		if( nativeControl instanceof CheckBox ) {
			((CheckBox) nativeControl).setSelected(selected);
		} else if( nativeControl instanceof RadioButton ) {
			((RadioButton) nativeControl).setSelected(selected);
		}
	}
	
	public void setToolTipText (String string) {
		this.tooltipText = string;
		if( nativeControl instanceof Control ) {
			Control control = (Control) nativeControl; 
			if( string == null ) {
				tooltip = null;
			} else {
				if( tooltip == null ) {
					tooltip = new Tooltip();
				}
				tooltip.setText(string);
			}
			
			control.setTooltip(tooltip);
		}
	}
	
	public void setWidth (int width) {
		this.width = width;
		nativeControl.setPrefWidth(width);
	}
	
	private void updateStateImage() {
		//TODO We should probably reuse ImageView
		if( nativeControl instanceof ButtonBase ) {
			if( nativeControl.isDisabled() ) {
				if( disabledImage != null ) {
					((ButtonBase) nativeControl).setGraphic(new ImageView(disabledImage.internal_getImage()));
				} else {
					((ButtonBase) nativeControl).setGraphic(getImage() == null ? null : new ImageView(getImage().internal_getImage()));
				}
			} else if( hover ) {
				if( hotImage != null ) {
					((ButtonBase) nativeControl).setGraphic(new ImageView(hotImage.internal_getImage()));
				} else {
					((ButtonBase) nativeControl).setGraphic(getImage() == null ? null : new ImageView(getImage().internal_getImage()));
				}
			} else {
				((ButtonBase) nativeControl).setGraphic(getImage() == null ? null : new ImageView(getImage().internal_getImage()));
			}
		} 
	}
	
	private InvalidationListener getDisabledListener() {
		if( disabledListener == null ) {
			disabledListener = new InvalidationListener() {
				
				@Override
				public void invalidated(Observable observable) {
					updateStateImage();
				}
			}; 
		}
		return disabledListener;
	}
	
	private EventHandler<MouseEvent> getMouseHandler() {
		if( mouseHandler == null ) {
			mouseHandler = new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					hover = event.getEventType() == MouseEvent.MOUSE_ENTERED;
					updateStateImage();
				}
			};
		}
		return mouseHandler;
	}
}
