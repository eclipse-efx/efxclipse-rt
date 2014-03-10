package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Callback;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Table.SWTTableRow;

public class TableItem extends Item {
	private String[] texts;
	private Image[] images;
	private Color[] backgrounds;
	private Font[] fonts;
	private Color[] foregrounds;
	private boolean checked;
	private boolean grayed;
	
	private Table parent;
	private List<Registration> registrations;
	
	public TableItem(Table parent, int style) {
		super(parent, style);
		this.parent = parent;
		this.registrations = new ArrayList<>();
		parent.internal_itemAdded(this);
	}
	
	public TableItem(Table parent, int style, int index) {
		super(parent, style);
		this.parent = parent;
		this.registrations = new ArrayList<>();
		parent.internal_itemAdded(this, index);
	}
	
	TableItem(Table parent) {
		super(parent, SWT.NONE);
		this.parent = parent;
		this.registrations = new ArrayList<>();
	}
	
	@Override
	public void setText(String string) {
		setText(0,string);
	}
	
	public void setText(int index, String text) {
		if( texts == null ) {
			texts = new String[index];
		}
		texts = Util.setIndexValue(index, texts, text);
		fireModification(index, AttributeType.TEXT);
	}
	
	
	public void setText (String [] texts) {
		if( texts.length == 0 ) {
			this.texts = null;
		} else {
			arrayUpdate(AttributeType.TEXT, this.texts == null ? new String[0] : this.texts, texts);
		}
	}
	
	public String getText(int index) {
		if( texts != null && index < texts.length ) {
			return Util.notNull(texts[index]);
		}
		
		return "";
	}
	
	@Override
	public String getText() {
		return getText(0);
	}
	
	public void setImage (Image [] images) {
		if( images.length == 0 ) {
			Image[] oldImages = this.images;
			this.images = null;
			
			if( oldImages != null ) {
				for( int i = 0; i < oldImages.length; i++ ) {
					fireModification(i, AttributeType.IMAGE);
				}	
			}
		} else {
			arrayUpdate(AttributeType.IMAGE, this.images == null ? new Image[0] : this.images, images);
		}
	}
	
	private <T> void arrayUpdate(AttributeType type, T[] originalAr, T[] newAr) {
		newAr = Arrays.copyOf(newAr,newAr.length);
		
		T[] i1;
		T[] i2;
		if( originalAr.length > newAr.length ) {
			i1 = originalAr;
			i2 = newAr;
		} else {
			i1 = newAr;
			i2 = originalAr;
		}
		
		switch (type) {
		case IMAGE:
			images = (Image[]) newAr;
			break;
		case TEXT:
			texts = (String[]) newAr;
			break;
		default:
			throw new IllegalArgumentException("Unsupported type '"+type+"'");
		}
		
		for( int i = 0; i < i1.length; i++ ) {
			if( i < i2.length ) {
				if( i1[i] != i2[i] ) {
					fireModification(i, type);
				}
			} else {
				fireModification(i, type);
			}
		}
	}
	
	public void setImage(int index, Image image) {
		if( images == null ) {
			images = new Image[index];
		}
		images = Util.setIndexValue(index, images, image);
		fireModification(index, AttributeType.IMAGE);
	}
	
	
	@Override
	public void setImage(Image image) {
		setImage(0,image);
	}
	
	@Override
	public Image getImage() {
		return getImage(0);
	}
	
	public Image getImage(int index) {
		if( images != null && index < images.length ) {
			return images[index];
		}
		return null;
	}
	
	
	
	@Override
	protected Object createWidget() {
		return null;
	}

	@Override
	public Object internal_getNativeObject() {
		return this;
	}

	public Color getBackground () {
		checkWidget();
		return getBackground(0); 
	}
	
	public Color getBackground (int index) {
		checkWidget();
		if( backgrounds != null ) {
			if( index <  backgrounds.length ) {
				return backgrounds[index];	
			} else if( backgrounds.length > 0 ) {
				return backgrounds[0];
			}
		}
		return null;
	}
	
	public Rectangle getBounds () {
		checkWidget();
		SWTTableRow row = parent.internal_getTableRow(this);
		if( row != null ) {
			return row.getBounds(0);
		}
		return new Rectangle(0, 0, 0, 0);
	}
	
	public Rectangle getBounds (int index) {
		checkWidget();
		SWTTableRow row = parent.internal_getTableRow(this);
		if( row != null ) {
			return row.getBounds(index);
		}
		return new Rectangle(0, 0, 0, 0);
	}
	
	public boolean getChecked () {
		checkWidget();
		return checked;
	}
	
	public Font getFont () {
		return getFont(0);
	}
	
	public Font getFont (int index) {
		checkWidget();
		if( fonts != null && index < fonts.length ) {
			return fonts[index];
		}
		return null;
	}
	
	public Color getForeground () {
		return getForeground(0);
	}
	
	public Color getForeground (int index) {
		checkWidget();
		if( foregrounds != null ) {
			if( index < foregrounds.length ) {
				System.err.println(index + " =>" + foregrounds[index]);
				return foregrounds[index];	
			} else if( foregrounds.length > 0 ) {
				return foregrounds[0];
			}
		}
		return null;
	}
	
	public boolean getGrayed () {
		checkWidget();
		return grayed;
	}

	
	public Rectangle getImageBounds (int index) {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
//	
//	public int getImageIndent () {
//		
//	}
//	
	public Table getParent () {
		return parent;
	}
	
	
	public Rectangle getTextBounds (int index) {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public void setBackground (int index, Color color) {
		checkWidget();
		if( backgrounds == null ) {
			backgrounds = new Color[index+1];
		}
		backgrounds = Util.setIndexValue(index, backgrounds, color);
	}
	
	public void setBackground (Color color) {
		setBackground(0, color);
	}
	
	public void setChecked (boolean checked) {
		checkWidget();
		this.checked = checked;
		fireModification(0, AttributeType.CHECK);
	}
	
	public void setFont (int index, Font font) {
		checkWidget();
		if( fonts == null ) {
			fonts = new Font[index+1];
		}
		Util.setIndexValue(index, fonts, font);
	}
	
	public void setFont (Font font){
		setFont(0, font);
	}
	
	public void setForeground (int index, Color color){
		checkWidget();
		if( foregrounds == null ) {
			foregrounds = new Color[index+1];
		}
		foregrounds = Util.setIndexValue(index, foregrounds, color);
	}
	
	public void setForeground (Color color){
		setForeground(0, color);
	}
	
	public void setGrayed (boolean grayed) {
		this.grayed = grayed;
		fireModification(0, AttributeType.CHECK);
	}
	
	private void fireModification(int index, AttributeType type) {
		for( Registration r : registrations.toArray(new Registration[0]) ) {
			if( r.index == index ) {
				r.callback.call(type);
			}
		}
	}
	
	Registration internal_registerModificationListener(int index, Callback<AttributeType, Void> callback) {
		Registration r = new Registration(index,callback);
		registrations.add(r);
		return r;
	}
	
	class Registration {
		private int index;
		private Callback<AttributeType, Void> callback;
		
		public Registration(int index, Callback<AttributeType, Void> callback) {
			this.index = index;
			this.callback = callback;
		}
		
		public void dispose() {
			registrations.remove(this);
		}
	}
	
	enum AttributeType {
		TEXT,
		IMAGE,
		CHECK
	}
}