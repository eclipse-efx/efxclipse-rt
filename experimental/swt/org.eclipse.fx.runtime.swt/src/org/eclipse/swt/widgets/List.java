package org.eclipse.swt.widgets;

import java.util.Arrays;
import java.util.WeakHashMap;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;

@SuppressWarnings("restriction")
public class List extends Scrollable {
	private ListView<String> control;
	private ObservableList<String> items;
	private WeakHashMap<Cell<String>, Boolean> currentCells = new WeakHashMap<>();
	
	public List(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public ListView<String> internal_getNativeObject() {
		return control;
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean flushCache) {
		forceSizeProcessing();
		int width = (int) control.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
		int height = (int) control.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
		
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;
				
		return new Point(width, height);
	}

	@Override
	protected ListView<String> createWidget() {
		control = new ListView<String>() {
			@Override
			protected Skin<?> createDefaultSkin() {
				return new CustomListViewSkin(this);
			}
		};
		control.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				SWTListCell c = new SWTListCell();
				c.addEventHandler(MouseEvent.MOUSE_CLICKED, new FXSelectionListener(c));
				return c;
			}
		});
		control.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				Event evt = new Event();
				internal_sendEvent(SWT.Selection, evt, true);
			}
		});
		items = FXCollections.observableArrayList();
		control.setItems(items);
		return control;
	}

	public void add (String string) {
		checkWidget ();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		items.add(string);
	}
	
	public void add (String string, int index) {
		checkWidget ();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		items.add(index, string);
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection,typedListener);
		addListener (SWT.DefaultSelection,typedListener);
	}
	
	public void deselect (int index) {
		checkWidget ();
		control.getSelectionModel().clearSelection(index);
	}

	public void deselect (int start, int end) {
		checkWidget ();
		for( ; start <= end; start++ ) {
			control.getSelectionModel().clearSelection(start);
		}
	}
	
	public void deselect (int [] indices) {
		checkWidget ();
		for( int i : indices ) {
			control.getSelectionModel().clearSelection(i);
		}
	}
	
	public void deselectAll () {
		checkWidget ();
		control.getSelectionModel().clearSelection();
	}
	
	public int getFocusIndex () {
		checkWidget ();
		return control.getFocusModel().getFocusedIndex();
	}
	
	public String getItem (int index) {
		checkWidget ();
		return items.get(index);
	}
	
	public int getItemCount () {
		checkWidget ();
		return items.size();
	}
	
	public int getItemHeight () {
		int itemHeight = 1;
		for( Cell<String> c : currentCells.keySet() ) {
			itemHeight = (int) Math.max(itemHeight, c.getHeight());
		}
		return itemHeight;
	}
	
	public String [] getItems () {
		checkWidget ();
		return items.toArray(new String[0]);
	}
	
	public String [] getSelection () {
		checkWidget ();
		return control.getSelectionModel().getSelectedItems().toArray(new String[0]);
	}
	
	public int getSelectionCount () {
		checkWidget ();
		return control.getSelectionModel().getSelectedIndices().size();
	}
	
	public int getSelectionIndex () {
		checkWidget ();
		return control.getSelectionModel().getSelectedIndex();
	}
	
	public int [] getSelectionIndices () {
		checkWidget ();
		ObservableList<Integer> l = control.getSelectionModel().getSelectedIndices();
		int[] rv = new int[l.size()];
		for( int i = 0; i < l.size(); i++ ) {
			rv[i] = l.get(i).intValue();
		}
		return rv;
	}
	
	public int getTopIndex () {
		if( control != null && control.getSkin() != null && ((CustomListViewSkin)control.getSkin()).swt_getFlow() != null ) {
			ListCell<String> c = ((CustomListViewSkin)control.getSkin()).swt_getFlow().getFirstVisibleCell();
			if( c != null ) {
				return c.getIndex();
			}	
		}
		
		return -1;
	}
	
	public int indexOf (String string) {
		checkWidget ();
		return items.indexOf(string);
	}
	
	public int indexOf (String string, int start) {
		checkWidget ();
		return items.subList(start, items.size()-1).indexOf(string);
	}
	
	public boolean isSelected (int index) {
		checkWidget ();
		return control.getSelectionModel().isSelected(index);
	}
	
	public void remove (int index) {
		checkWidget ();
		items.remove(index);
	}
	
	public void remove (int start, int end) {
		checkWidget ();
		items.remove(start, end);
	}
	
	public void remove (int [] indices) {
		checkWidget ();
		Util.removeListIndices(items, indices);
	}
	
	public void remove (String string) {
		checkWidget ();
		items.remove(string);
	}
	
	public void removeAll () {
		checkWidget ();
		items.clear();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection, listener);
	}
	
	public void select (int index) {
		checkWidget ();
		control.getSelectionModel().select(index);
	}
	
	public void select (int start, int end) {
		checkWidget ();
		control.getSelectionModel().selectRange(start, end);
	}
	
	public void select (int [] indices) {
		checkWidget ();
		if( indices.length == 0 ) {
			control.getSelectionModel().clearSelection();
		} else if( indices.length == 1 ) {
			control.getSelectionModel().selectIndices(indices[0]);
		} else {
			int idx = indices[0];
			int[] rest = new int[indices.length-1];
			System.arraycopy(indices, 1, rest, 0, indices.length-1);
			control.getSelectionModel().selectIndices(idx,rest);
		}
	}
	
	public void selectAll () {
		checkWidget ();
		control.getSelectionModel().selectAll();
	}
	
	public void setItem (int index, String string) {
		checkWidget ();
		items.set(index, string);
	}
	
	public void setItems (String [] items) {
		checkWidget ();
		this.items.setAll(items);
	}
	
	public void setSelection (int index) {
		checkWidget ();
		control.getSelectionModel().clearAndSelect(index);
		control.getFocusModel().focus(index);
	}
	
	public void setSelection (int start, int end) {
		checkWidget ();
		control.getSelectionModel().clearSelection();
		select(start, end);
		control.getFocusModel().focus(end);
	}
	
	public void setSelection(int [] indices) {
		checkWidget ();
		control.getSelectionModel().clearSelection();
		select(indices);
		if( indices.length > 0 ) {
			int[] sorted = new int[indices.length];
			System.arraycopy(indices, 0, sorted, 0, indices.length);
			Arrays.sort(sorted);
			control.getFocusModel().focus(sorted[sorted.length-1]);
		}
	}
	
	public void setSelection (String [] items) {
		checkWidget ();
		for( String i : items ) {
			control.getSelectionModel().select(i);	
		}
	}
	
	public void setTopIndex (int index) {
		control.scrollTo(index);
	}
	
	public void showSelection () {
		checkWidget ();
		int indices[] = getSelectionIndices();
		if( indices.length > 0 ) {
			int[] sorted = new int[indices.length];
			System.arraycopy(indices, 0, sorted, 0, indices.length);
			Arrays.sort(sorted);
			control.getFocusModel().focus(sorted[sorted.length-1]);
		}
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this,getFont());
	}
	
	class FXSelectionListener implements EventHandler<MouseEvent> {
		private SWTListCell cell;
		
		public FXSelectionListener(SWTListCell cell) {
			this.cell = cell;
		}
		
		@Override
		public void handle(MouseEvent event) {
			if( event.getClickCount() > 1 && ! cell.isEmpty() ) {
				Event evt = new Event();
				internal_sendEvent(SWT.DefaultSelection, evt, true);
			}
		}
	}
	
	static class CustomListViewSkin extends ListViewSkin<String> {

		public CustomListViewSkin(ListView<String> arg0) {
			super(arg0);
		}
		
		public VirtualFlow<ListCell<String>> swt_getFlow() {
			return flow;
		}
	}
	
	class SWTListCell extends ListCell<String> {
		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			if( item != null && ! empty ) {
				setText(item);
				currentCells.put(this, Boolean.TRUE);
			} else {
				setText(null);
				currentCells.remove(this);
			}
		}
	}
}
