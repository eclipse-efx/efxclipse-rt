package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Tree.SWTTreeRow;

public class TreeItem extends Item {
	private javafx.scene.control.TreeItem<TreeItem> nativeObject;
	
	private Tree tree;
	private TreeItem parentItem;
	private List<Registration> registrations;
	
	private String[] texts;
	private Image[] images;
	private Color[] backgrounds;
	private Font[] fonts;
	private Color[] foregrounds;
	private boolean checked;
	private boolean grayed;

	
	public TreeItem(Tree tree, int style) {
		super(tree, style);
		this.tree = tree;
		this.registrations = new ArrayList<>();
		tree.internal_itemAdded(this);
	}

	public TreeItem(Tree tree, int style, int index) {
		super(tree, style);
		this.tree = tree;
		this.registrations = new ArrayList<>();
		tree.internal_itemAdded(this, index);
	}

	
	public TreeItem(TreeItem parent, int style) {
		super(parent, style);
		this.parentItem = parent;
		this.registrations = new ArrayList<>();
		parent.nativeObject.getChildren().add(nativeObject);
	}

	public TreeItem(TreeItem parent, int style, int index) {
		super(parent, style);
		this.parentItem = parent;
		this.registrations = new ArrayList<>();
		parent.nativeObject.getChildren().add(index, nativeObject);
	}

	
	@Override
	protected javafx.scene.control.TreeItem<TreeItem> createWidget() {
		nativeObject = new javafx.scene.control.TreeItem<>(this);
		nativeObject.expandedProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				Event evt = new Event();
				evt.item = TreeItem.this;
				getTree().internal_sendEvent(nativeObject.isExpanded() ? SWT.Expand : SWT.Collapse, evt, true);
			}
		});
		return nativeObject;
	}
	
	@Override
	public void dispose() {
		if( tree != null ) {
			tree.internal_itemRemoved(this);
			tree = null;
		} else {
			parentItem.internal_itemRemoved(this);
			nativeObject.setValue(null);
			parentItem = null;
		}
		
		javafx.scene.control.TreeItem<TreeItem>[] children = nativeObject.getChildren().toArray(new javafx.scene.control.TreeItem[0]);
		// clear the list this makes the remove faster
		nativeObject.getChildren().clear();
		
		for( javafx.scene.control.TreeItem<TreeItem> i : children ) {
			i.getValue().dispose();
		}
		
		super.dispose();
	}
	
	private void internal_itemRemoved(TreeItem item) {
		nativeObject.getChildren().remove(item.nativeObject);
	}
	
	private Tree getTree() {
		if( tree == null ) {
			return parentItem.getTree();
		}
		return tree;
	}

	@Override
	public javafx.scene.control.TreeItem<TreeItem> internal_getNativeObject() {
		return nativeObject;
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
					fireModification(i, AttributeType.IMAGE);
				}
			} else {
				fireModification(i, AttributeType.IMAGE);
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
	
	public void clear (int index, boolean all) {
		Util.logNotImplemented();
	}
	
	public void clearAll (boolean all) {
		Util.logNotImplemented();
	}
	
	public Color getBackground () {
		checkWidget();
		return getBackground(0); 
	}
	
	public Color getBackground (int index) {
		checkWidget();
		if( backgrounds != null && index <  backgrounds.length ) {
			return backgrounds[index];
		}
		return null;
	}

	
	public Rectangle getBounds () {
		return getBounds(0);
	}
	
	
	public Rectangle getBounds (int index) {
		SWTTreeRow row = getTree().internal_getTreeRow(this);
		if( row != null ) {
			return row.swt_getBounds(index);
		}
		return new Rectangle(0, 0, 0, 0);
	}
	
	public boolean getChecked () {
		return checked;
	}
	
	public boolean getExpanded () {
		return grayed;
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
		if( foregrounds != null && index < foregrounds.length ) {
			return foregrounds[index];
		}
		return null;
	}
	
	public boolean getGrayed () {
		return grayed;
	}
//	
//	public Image getImage () {
//		
//	}
//	public Image getImage (int index) {
//		
//	}
//	
	public Rectangle getImageBounds (int index) {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public TreeItem getItem (int index) {
		return nativeObject.getChildren().get(index).getValue();
	}
	
	public int getItemCount () {
		return nativeObject.getChildren().size();
	}
	
	public TreeItem [] getItems () {
		return Tree.extractItemArray(nativeObject.getChildren());
	}
	
	public Tree getParent () {
		return getTree();
	}
	
	public TreeItem getParentItem () {
		return parentItem;
	}
//	
//	public String getText () {
//		
//	}
//	
//	public String getText (int index) {
//		
//	}
//	
	public Rectangle getTextBounds (int index) {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public int indexOf (TreeItem item) {
		ObservableList<javafx.scene.control.TreeItem<TreeItem>> children = nativeObject.getChildren();
		for( int i = 0; i < children.size(); i++ ) {
			if( children.get(i).getValue() == item ) {
				return i;
			}
		}
		
		return -1;
	}
//	
//	public void removeAll () {
//		
//	}
//	
	public void setBackground (int index, Color color) {
		checkWidget();
		if( backgrounds == null ) {
			backgrounds = new Color[index+1];
		}
		Util.setIndexValue(index, backgrounds, color);
	}
	
	public void setBackground (Color color) {
		setBackground(0, color);
	}
	
	public void setChecked (boolean checked) {
		this.checked = checked;
		fireModification(0, AttributeType.CHECK);
	}
	
	public void setExpanded (final boolean expanded) {
		getTree().internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				nativeObject.setExpanded(expanded);
			}
		});
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
		Util.setIndexValue(0, foregrounds, color);
	}
	
	public void setForeground (Color color){
		setForeground(0, color);
	}
	
	public void setGrayed (boolean grayed) {
		this.grayed = grayed;
		fireModification(0, AttributeType.CHECK);
	}
	
//	public void setImage (Image [] images) {
//		
//	}
//	
//	public void setImage (int index, Image image) {
//		
//	}
//	
//	public void setImage (Image image) {
//		
//	}
//	
	public void setItemCount (int count) {
		Util.logNotImplemented();
	}
//	
//	public void setText (String [] strings) {
//		
//	}
//	
//	public void setText (int index, String string) {
//		
//	}
//	
//	public void setText (String string) {
//		
//	}
	private void fireModification(int index, AttributeType type) {
		for( Registration r : registrations.toArray(new Registration[0]) ) {
			if( r.index == index ) {
				r.callback.call(type);
			}
		}
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