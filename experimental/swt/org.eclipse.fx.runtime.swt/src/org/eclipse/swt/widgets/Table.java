package org.eclipse.swt.widgets;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.FocusModel;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Skin;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.CanvasGC;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.TableColumn.TableColumnCell;
import org.eclipse.swt.widgets.TableItem.AttributeType;
import org.eclipse.swt.widgets.TableItem.Registration;

import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.sun.javafx.scene.control.skin.TableViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;

@SuppressWarnings("restriction")
public class Table extends Composite {
	private AnchorPane container; 
	private TableView<TableItem> tableView; 
	private ListView<TableItem> listView;
	private ObservableList<TableItem> list;
	
	private List<TableColumn> columns = new ArrayList<TableColumn>();
	private WeakHashMap<SWTTableRow, Boolean> currentRows = new WeakHashMap<>();
	private InvalidationListener selectionListener;
	
	private ScrollBar hBar;
	private ScrollBar vBar;
	
	private boolean measureItem;
	private boolean paintItem;
	private boolean eraseItem;
	
	public interface SWTTableRow {
		public double getHeight();
		public TableItem getTableItem();
		public void hideEditor(int column);
		public void showEditor(Control editor, int column);
		public Rectangle getBounds();
		public Rectangle getBounds(int index);
	}

	@Override
	protected Canvas internal_initCanvas() {
		return null;
	}
	
	public Table(Composite parent, int style) {
		super(parent, style);
	}
	
	public SWTTableRow internal_getTableRow(TableItem item) {
		for( SWTTableRow c : currentRows.keySet() ) {
			if( item == c.getTableItem() ) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public void setLayout(Layout layout) {
		Util.logNotImplemented();
	}
	
	boolean internal_isMeasureItem() {
		return measureItem;
	}
	
	boolean internal_isPaintItem() {
		return paintItem;
	}
	
	boolean internal_isEraseItem() {
		return eraseItem;
	}
	
	
	@Override
	public void addListener(int eventType, Listener listener) {
		super.addListener(eventType, listener);
		switch (eventType) {
		case SWT.MeasureItem:
			measureItem = true;
			break;
		case SWT.PaintItem:
			paintItem = true;
			break;
		case SWT.EraseItem:
			eraseItem = true;
			break;
		default:
			break;
		}
	}
		
	@Override
	protected AnchorPane createWidget() {
		this.list = FXCollections.observableArrayList();
		this.container = new AnchorPane();
		
		//TODO We could be smarter and init with no control
		this.listView = new ListView<TableItem>(list) {
			@Override
			protected Skin<?> createDefaultSkin() {
				return new CustomListViewSkin(this);
			}
		};
		this.listView.setCellFactory(new Callback<ListView<TableItem>, ListCell<TableItem>>() {
			
			@Override
			public ListCell<TableItem> call(ListView<TableItem> param) {
				TableListCell c = new TableListCell();
				c.addEventFilter(MouseEvent.MOUSE_CLICKED,new FXSelectionListener(c));
				return c;
			}
		});
		this.listView.getSelectionModel().setSelectionMode((style & SWT.MULTI) == SWT.MULTI ? SelectionMode.MULTIPLE : SelectionMode.SINGLE);
		
		selectionListener = new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				MultipleSelectionModel<TableItem> model = listView != null ? listView.getSelectionModel() : tableView.getSelectionModel();
				
				if( model.isEmpty() ) {
					internal_sendEvent(SWT.Selection, new Event(), true);
				} else {
					Event evt = new Event();
					TableItem tableItem = model.getSelectedItems().get(model.getSelectedItems().size()-1);
					evt.item = tableItem;
					evt.index = list.indexOf(list);
					internal_sendEvent(SWT.Selection, evt, true);
				}
			}
		};
		this.listView.getSelectionModel().getSelectedItems().addListener(selectionListener);
		registerConnection(listView);
		AnchorPane.setTopAnchor(listView, 0.0);
		AnchorPane.setBottomAnchor(listView, 0.0);
		AnchorPane.setLeftAnchor(listView, 0.0);
		AnchorPane.setRightAnchor(listView, 0.0);
		this.container.getChildren().add(listView);
		return this.container;
	}
	
	private VirtualFlow<?> getFlow() {
		VirtualFlow<?> flow = null;
		if( listView != null ) {
			if( listView.getSkin() != null ) {
				flow = ((CustomListViewSkin)listView.getSkin()).swt_getFlow();	
			}
		} else {
			if( tableView.getSkin() != null ) {
				flow = ((CustomTableViewSkin)tableView.getSkin()).swt_getFlow();	
			}
		}
		
		return flow;
	}
	
	@Override
	public ScrollBar getVerticalBar() {
		if( vBar != null ) {
			return vBar;
		}
		
		VirtualFlow<?> flow;
		if( listView != null ) {
			flow = ((CustomListViewSkin)listView.getSkin()).swt_getFlow();
		} else {
			flow = ((CustomTableViewSkin)tableView.getSkin()).swt_getFlow();
		}
		
		try {
			Method m = VirtualFlow.class.getDeclaredMethod("getVbar");
			m.setAccessible(true);
			javafx.scene.control.ScrollBar bar = (javafx.scene.control.ScrollBar) m.invoke(flow);
			vBar = new ScrollBar(this, bar, SWT.VERTICAL);
			return vBar;
		} catch (Throwable t) {
			throw new IllegalStateException(t);
		}
	}
	
	@Override
	public ScrollBar getHorizontalBar() {
		if( hBar != null ) {
			return hBar;
		}
		
		VirtualFlow<?> flow;
		forceSizeProcessing();
		if( listView != null ) {
			flow = ((CustomListViewSkin)listView.getSkin()).swt_getFlow();
		} else {
			flow = ((CustomTableViewSkin)tableView.getSkin()).swt_getFlow();
		}
		
		try {
			Method m = VirtualFlow.class.getDeclaredMethod("getHbar");
			m.setAccessible(true);
			javafx.scene.control.ScrollBar bar = (javafx.scene.control.ScrollBar) m.invoke(flow);
			hBar = new ScrollBar(this, bar, SWT.HORIZONTAL);
			return hBar;
		} catch (Throwable t) {
			throw new IllegalStateException(t);
		}
	}
	
	@Override
	protected Region internal_getEventTarget() {
		return internal_getNativeControl();
	}
	
	@Override
	public AnchorPane internal_getNativeObject() {
		return container;
	}
	
	@Override
	public Region internal_getNativeControl() {
		return tableView != null ? tableView : listView;
	}
	
	@Override
	protected void internal_attachControl(Control c) {
		if( c instanceof TableCursor ) { 
			c.internal_getNativeObject().setManaged(false);
			container.getChildren().add(c.internal_getNativeObject());
		}
	}
	
	@Override
	protected void internal_attachControl(int idx, Control c) {
	}
	
	@Override
	protected void internal_detachControl(Control c) {
	}
	
	@Override
	protected double internal_getHeight() {
		return container.getHeight();
	}
	
	@Override
	protected double internal_getPrefHeight() {
		return container.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getPrefWidth() {
		return container.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}
	
	@Override
	protected double internal_getWidth() {
		return container.getHeight();
	}
	
	public void internal_itemAdded(TableItem item) {
		list.add(item);
	}

	public void internal_itemAdded(TableItem item, int index) {
		list.add(index,item);
	}

	public void internal_columnAdded(TableColumn column) {
		columns.add(column);
		initTableView();
		tableView.getColumns().add(column.internal_getNativeObject());
	}
	
	public void internal_columnAdded(TableColumn column, int index) {
		columns.add(index,column);
		initTableView();
		tableView.getColumns().add(index, column.internal_getNativeObject());
	}
	
	private void initTableView() {
		if( tableView == null ) {
			currentRows.clear();
			uninitListeners();
			unregisterConnection(listView);
			ListView<TableItem> listView = this.listView;
			ContextMenu contextMenu = listView.getContextMenu();
			this.listView = null;
			
			listView.getSelectionModel().getSelectedItems().removeListener(selectionListener);
			listView.setItems(null);
			listView.setContextMenu(null);
			
			tableView = new TableView<TableItem>(list) {
				@Override
				protected Skin<?> createDefaultSkin() {
					return new CustomTableViewSkin(this);
				}
			};
			registerConnection(tableView);
			tableView.setRowFactory(new Callback<TableView<TableItem>, TableRow<TableItem>>() {
				
				@Override
				public TableRow<TableItem> call(TableView<TableItem> param) {
					return new TableRowImpl();
				}
			});
			tableView.getSelectionModel().getSelectedItems().addListener(selectionListener);
			tableView.setContextMenu(contextMenu);
			AnchorPane.setTopAnchor(tableView, 0.0);
			AnchorPane.setBottomAnchor(tableView, 0.0);
			AnchorPane.setLeftAnchor(tableView, 0.0);
			AnchorPane.setRightAnchor(tableView, 0.0);
			container.getChildren().setAll(tableView);
			initListeners();
		}
	}
	
	public void addSelectionListener (SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		registerListener (SWT.Selection,typedListener);
		registerListener (SWT.DefaultSelection,typedListener);
	}
	
	public void clear(int index) {
		if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
			list.get(index).state &= ~Widget.DATA_SET;
		}
	}

	public void clear(int start, int end) {
		if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
			for( ; start <= end; start++ ) {
				list.get(start).state &= ~Widget.DATA_SET;
			}
		}
	}

	public void clear(int[] indices) {
		if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
			for( int i = 0; i < indices.length; i++ ) {
				list.get(i).state &= ~Widget.DATA_SET;
			}
		}
	}

	public void clearAll() {
		if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
			for( TableItem i : list ) {
				i.state &= ~Widget.DATA_SET;
			}	
		}		
	}

	private MultipleSelectionModel<TableItem> getSelectionModel() {
		return listView != null ? listView.getSelectionModel() : tableView.getSelectionModel();
	}
	
	private FocusModel<TableItem> getFocusModel() {
		return listView != null ? listView.getFocusModel() : tableView.getFocusModel();
	}
	
	public void deselect(int index) {
		checkWidget();
		getSelectionModel().clearSelection(index);
	}

	public void deselect(int start, int end) {
		checkWidget();
		SelectionModel<TableItem> model = getSelectionModel();
		for (; start <= end; start++) {
			model.clearSelection(start);
		}
	}

	public void deselect(int[] indices) {
		checkWidget();
		SelectionModel<TableItem> model = getSelectionModel();
		for (int idx : indices) {
			model.clearSelection(idx);
		}
	}

	public void deselectAll() {
		checkWidget();
		getSelectionModel().clearSelection();
	}

	public TableColumn getColumn(int index) {
		checkWidget();
		if (!(0 <= index && index < getColumnCount())) {
			error(SWT.ERROR_INVALID_RANGE);
		}
		return columns.get(index);
	}

	public int getColumnCount() {
		return columns.size();
	}

	public int[] getColumnOrder() {
		int[] rv = new int[columns.size()];
		
		int i = 0;
		for( javafx.scene.control.TableColumn<TableItem,?> c : tableView.getColumns() ) {
			rv[i++] = columns.indexOf(Widget.getWidget(c)); 
		}
		
		return rv;
	}

	public TableColumn[] getColumns() {
		checkWidget();
		return columns.toArray(new TableColumn[0]);
	}

	public int getGridLineWidth() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public int getHeaderHeight() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public boolean getHeaderVisible() {
		// TODO Not implemented
		Util.logNotImplemented();
		return true;
	}

	public TableItem getItem(int index) {
		if (!(0 <= index && index < getItemCount())) {
			error(SWT.ERROR_INVALID_RANGE);
		}
		return list.get(index);
	}

	public TableItem getItem(Point point) {
		for( SWTTableRow r : currentRows.keySet()) {
			if( columns.isEmpty() ) {
				if( r.getBounds(0).contains(point) ) {
					return r.getTableItem();
				}
			}
			
		}
		// TODO Not implemented
		Util.logNotImplemented();
		return null;
	}

	public int getItemCount() {
		checkWidget();
		return list.size();
	}

	public int getItemHeight() {
		int itemHeight = 1;
		for( SWTTableRow c : currentRows.keySet() ) {
			itemHeight = (int) Math.max(itemHeight, c.getHeight());
		}
		return itemHeight;
	}

	public TableItem[] getItems() {
		checkWidget();
		return list.toArray(new TableItem[0]);
	}

	public boolean getLinesVisible() {
		// TODO Not implemented
		Util.logNotImplemented();
		return true;
	}

	public TableItem[] getSelection() {
		checkWidget();
		return getSelectionModel().getSelectedItems().toArray(new TableItem[0]);
	}

	public int getSelectionCount() {
		checkWidget();
		return getSelectionModel().getSelectedIndices().size();
	}

	public int getSelectionIndex() {
		checkWidget();
		return getSelectionModel().getSelectedIndex();
	}

	public int[] getSelectionIndices() {
		checkWidget();
		ObservableList<Integer> l = getSelectionModel().getSelectedIndices();
		int[] rv = new int[l.size()];
		int j = 0;
		for( Integer i : l ) {
			rv[j++] = i.intValue();
		}
		return rv;
	}

	public TableColumn getSortColumn() {
		// TODO Not implemented
		Util.logNotImplemented();
		return null;
	}

	public int getSortDirection() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public int getTopIndex() {
		IndexedCell<TableItem> cell;
		if( tableView != null ) {
			CustomTableViewSkin skin = (CustomTableViewSkin) tableView.getSkin();
			cell = skin.swt_getFlow().getFirstVisibleCell();
		} else {
			CustomListViewSkin skin = (CustomListViewSkin) listView.getSkin();
			cell = skin.swt_getFlow().getFirstVisibleCell();
		}
		if( cell != null ) {
			return cell.getIndex();
		}
		return -1;
	}

	public int indexOf(TableColumn column) {
		checkWidget();
		return columns.indexOf(column);
	}

	public int indexOf(TableItem item) {
		checkWidget();
		return list.indexOf(item);
	}

	public boolean isSelected(int index) {
		checkWidget();
		return getSelectionModel().isSelected(index);
	}

	public void remove(int index) {
		checkWidget();
		//TODO Dispose
		list.remove(index);
	}

	public void remove(int start, int end) {
		checkWidget();
		//TODO Dispose
		list.remove(start, end);
	}

	public void remove(int[] indices) {
		checkWidget();
		//TODO Dispose
		Util.removeListIndices(list, indices);
	}

	public void removeAll() {
		checkWidget();
		//TODO Dispose
		list.clear();
	}

	public void removeSelectionListener(SelectionListener listener) {
		checkWidget ();
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection,listener);	
	}

	public void select(final int index) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().select(index);
			}
		});
	}

	public void select(final int start, final int end) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().selectRange(start, end);
			}
		});
		
	}

	public void select(final int[] indices) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				if( indices.length == 0 ) {
					getSelectionModel().clearSelection();
				} else if( indices.length == 1 ) {
					getSelectionModel().selectIndices(indices[0]);
				} else {
					int idx = indices[0];
					int[] rest = new int[indices.length-1];
					System.arraycopy(indices, 1, rest, 0, indices.length-1);
					getSelectionModel().selectIndices(idx,rest);
				}				
			}
		});
	}

	public void selectAll() {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().clearSelection();
			}
		});
	}

	public void setColumnOrder(int[] order) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setHeaderVisible(boolean show) {
		// TODO Not implemented
		Util.logNotImplemented();
	}
	
	private void remove(TableItem[] items) {
		for( int i = 0; i < items.length; i++ ) {
			items[i].dispose();
		}
	}

	public void setItemCount(int count) {
		if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
			if( count < list.size() ) {
				List<TableItem> sublist = list.subList(count, list.size()-1);
				TableItem[] items = new TableItem[sublist.size()];
				sublist.toArray(items);
				sublist.clear();
				remove(items);
			} else if( count > list.size() ) {
				int l = count - list.size();
				TableItem[] items = new TableItem[l];
				for( int i = 0; i < l; i++ ) {
					items[i] = new TableItem(this);
				}
				list.addAll(items);
			}
		}
	}

	public void setLinesVisible(boolean show) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setSelection(final int index) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().clearAndSelect(index);
				getFocusModel().focus(index);
				showItem(list.get(index));
			}
		});
	}

	public void setSelection(final int start, final int end) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().clearSelection();
				select(start, end);
				getFocusModel().focus(end);
			}
		});
	}

	public void setSelection(final int[] indices) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().clearSelection();
				if( indices.length > 0 ) {
					int[] sorted = new int[indices.length];
					System.arraycopy(indices, 0, sorted, 0, indices.length);
					Arrays.sort(sorted);
					getFocusModel().focus(sorted[sorted.length-1]);
				}
			}
		});
	}

	public void setSelection(final TableItem item) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().clearSelection();
				getSelectionModel().select(item);
				getFocusModel().focus(tableView.getSelectionModel().getSelectedIndex());
			}
		});
		
	}

	public void setSelection(final TableItem[] items) {
		checkWidget();
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				getSelectionModel().clearSelection();
				for( TableItem t : items ) {
					getSelectionModel().select(t);	
				}
				getFocusModel().focus(getSelectionModel().getSelectedIndex());
			}
		});
	}

	public void setSortColumn(TableColumn column) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setSortDirection(int direction) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setTopIndex(int index) {
		if( tableView != null ) {
			tableView.scrollTo(index);
		} else {
			listView.scrollTo(index);
		}
	}

	public void showColumn(TableColumn column) {
		if( tableView != null ) {
			tableView.scrollToColumn(column.internal_getNativeObject());
		}
	}

	public void showItem(TableItem item) {
		// Only scroll if not yet visible
		VirtualFlow<?> flow = getFlow();
		if( flow != null ) {
			SWTTableRow first = (SWTTableRow) getFlow().getFirstVisibleCellWithinViewPort();
			SWTTableRow last = (SWTTableRow) getFlow().getLastVisibleCellWithinViewPort();
			if( first == null ) {
				return;
			}
			int i = list.indexOf(first.getTableItem());
			int j;
			
			if( last != null && last.getTableItem() != null ) {
				j = list.indexOf(last.getTableItem());	
			} else {
				j = list.size()-1;
			}
			
			for( ; i <= j; i++ ) {
				if( list.get(i) == item ) {
					return;
				}
			}
		}
		
		if( tableView != null ) {
			tableView.scrollTo(item);
		} else {
			listView.scrollTo(item);
		}
	}

	public void showSelection() {
		int idx = getSelectionIndex();
		if( idx >= 0 ) {
			showItem(list.get(idx));
		}
	}
	
	@Override
	protected void internal_doLayout() {
		// no layouting needed
	}
	
	class TableRowImpl extends TableRow<TableItem> implements SWTTableRow {
		private TableItem currentItem;
		
		@Override
		protected void updateItem(TableItem item, boolean empty) {
			if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
				if( item != null && (item.state & Widget.DATA_SET) != Widget.DATA_SET ) {
					item.state |= Widget.DATA_SET;
					Event evt = new Event();
					evt.item = item;
					internal_sendEvent(SWT.SetData, evt, true);
				}
			}
			super.updateItem(item, empty);
			currentItem = item;
			
			if( item != null && ! empty ) {
				currentRows.put(this, Boolean.TRUE);
			} else {
				currentRows.remove(this);
			}
		}

		@Override
		public TableItem getTableItem() {
			return currentItem;
		}

		@Override
		public void hideEditor(int column) {
			TableColumnCell cell = getColumn(column).getCell(currentItem);
			if( cell != null ) {
				cell.hideEditor();
			}
		}

		@Override
		public void showEditor(Control editor, int column) {
			TableColumnCell cell = getColumn(column).getCell(currentItem);
			if( cell != null ) {
				cell.showEditor(editor);
			}
		}
		
		@Override
		public Rectangle getBounds(int index) {
			TableColumnCell cell = getColumn(index).getCell(currentItem);
			return cell.getBounds();
		}
		
		@Override
		public Rectangle getBounds() {
			Bounds bounds = getBoundsInParent();
			Point2D coords = internal_getNativeObject().sceneToLocal(localToScene(0, 0));
			
			return new Rectangle((int)coords.getX(), (int)coords.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		}
	}
	
	class TableListCell extends ListCell<TableItem> implements SWTTableRow, Callback<TableItem.AttributeType, Void>, Drawable {
		private ImageView imageView;
		private CheckBox checkbox;
		private HBox graphicItemsContainer;
		private TableItem currentItem;
		private Registration updateRegistration;
		private Control editor;
		private Canvas ownerDrawCanvas;
		private StackPane ownerDrawContainer;
		
		@Override
		protected void layoutChildren() {
			super.layoutChildren();
		}
		
		@Override
		public TableItem getTableItem() {
			return currentItem;
		}
		
		@Override
		public Rectangle getBounds(int index) {
			Bounds bounds = getBoundsInParent();
			Point2D coords = internal_getNativeObject().sceneToLocal(localToScene(0, 0));
			
			return new Rectangle((int)coords.getX(), (int)coords.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		}
		
		@Override
		public Rectangle getBounds() {
			Bounds bounds = getBoundsInParent();
			Point2D coords = internal_getNativeObject().sceneToLocal(localToScene(0, 0));
			
			return new Rectangle((int)coords.getX(), (int)coords.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		}
		
		@Override
		protected void updateItem(TableItem item, boolean empty) {
			if( (style & SWT.VIRTUAL) == SWT.VIRTUAL ) {
				if( item != null && (item.state & Widget.DATA_SET) != Widget.DATA_SET ) {
					item.state |= Widget.DATA_SET;
					Event evt = new Event();
					evt.item = item;
					internal_sendEvent(SWT.SetData, evt, true);
				}
			}
			
			// remove the old registration
			if( updateRegistration != null ) {
				updateRegistration.dispose();
				updateRegistration = null;
			}
			
			if( item != null ) {
				updateRegistration = item.internal_registerModificationListener(0, this);
			}
			
			currentItem = item;
			
			if( item != null && ! empty ) {
				if( measureItem ) {
					initCanvas();
					sendMeasureEvent();	
				}
				updateText();
				updateImage();
				if( Table.this.listView != null ) {
					Table.this.currentRows.put(this, Boolean.TRUE);	
				}
			} else {
				setText(null);
				setGraphic(null);
				if( Table.this.listView != null ) {
					Table.this.currentRows.remove(this);	
				}
			}
			
			super.updateItem(item, empty);
		}
		
		private void updateText() {
			if( editor != null || paintItem ) {
				setText(null);
			} else {
				setText(currentItem.getText());	
			}
		}
		
		private void updateImage() {
			Image img = currentItem.getImage();
			
			if( (Table.this.getStyle() & SWT.CHECK) == SWT.CHECK ) {
				if( checkbox == null ) {
					checkbox = new CheckBox();
					checkbox.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							currentItem.setChecked(checkbox.isSelected());
							Event evt = new Event();
							evt.item = currentItem;
							evt.detail = SWT.CHECK;
							internal_sendEvent(SWT.Selection, evt, true);
						}
					});
				}
				
				checkbox.setSelected(currentItem.getChecked());
				checkbox.setIndeterminate(currentItem.getGrayed());
			}
			
			//TODO Keep or hide image???
			if( img != null ) {
				if( imageView == null ) {
					imageView = new ImageView(img.internal_getImage());
				} else {
					imageView.setImage(img.internal_getImage());
				}
								
				if( editor != null ) {
					HBox h = new HBox();
					h.getChildren().setAll(checkbox, imageView, editor.internal_getNativeObject());
					setGraphic(h);
				} else {
					if( checkbox != null ) {
						if( graphicItemsContainer == null ) {
							graphicItemsContainer = new HBox();
						}
						graphicItemsContainer.getChildren().setAll(checkbox,imageView);
						setGraphic(graphicItemsContainer);
					} else {
						if( paintItem ) {
							if( graphicItemsContainer == null ) {
								graphicItemsContainer = new HBox();
							}
							if( ownerDrawCanvas == null ) {
								initCanvas();
							}
							graphicItemsContainer.getChildren().setAll(imageView,ownerDrawContainer);
						} else {
							setGraphic(imageView);	
						}
					}
				}
			} else {
				if( editor != null ) {
					if( checkbox != null ) {
						if( graphicItemsContainer == null ) {
							graphicItemsContainer = new HBox();
						}
						graphicItemsContainer.getChildren().setAll(checkbox, editor.internal_getNativeObject());
					} else {
						setGraphic(editor.internal_getNativeObject());	
					}
				} else {
					if( checkbox != null ) {
						setGraphic(checkbox);
					} else {
						if( paintItem ) {
							if( ownerDrawCanvas == null ) {
								initCanvas();
							}
							setGraphic(ownerDrawContainer);
						} else {
							setGraphic(null);	
						}
					}
				}
			}
		}
		
		private void initCanvas() {
			ownerDrawCanvas = new Canvas();
			ownerDrawContainer = new StackPane();
			InvalidationListener l = o -> { ownerDrawCanvas.setHeight(ownerDrawContainer.getHeight()); sendPaintEvent(); };
			ownerDrawContainer.heightProperty().addListener(l);
			
			l = o -> { ownerDrawCanvas.setWidth(ownerDrawContainer.getWidth()); sendPaintEvent(); };
			ownerDrawContainer.widthProperty().addListener(l);
			ownerDrawContainer.getChildren().add(ownerDrawCanvas);
		}
		
		@Override
		public DrawableGC internal_new_GC() {
			Font f = currentItem.getFont();
			if( f == null ) {
				f = currentItem.getParent().getFont();
			}
			return new CanvasGC(ownerDrawCanvas, f, currentItem.getBackground(), currentItem.getForeground());
		}
		
		@Override
		public void internal_dispose_GC(DrawableGC gc) {
			gc.dispose();
		}
		
		private void sendPaintEvent() {
			Event event = new Event();
			event.item = currentItem;
			event.gc = new GC(this);
			ownerDrawCanvas.getGraphicsContext2D().clearRect(0,0,ownerDrawCanvas.getWidth(),ownerDrawCanvas.getHeight());
			internal_sendEvent(SWT.PaintItem, event, true);
			event.gc.dispose();
		}
		
		private void sendMeasureEvent() {
			Event event = new Event();
			event.item = currentItem;
			event.gc = new GC(this);
			internal_sendEvent(SWT.MeasureItem, event, true);
			ownerDrawCanvas.setWidth(event.width);
			ownerDrawCanvas.setHeight(event.height);
			event.gc.dispose();
		}
		
		private void sendEraseEvent() {
			
		}
		
		@Override
		public Void call(AttributeType param) {
			switch (param) {
			case IMAGE:
			case CHECK:
				updateImage();
				break;
			case TEXT:
				updateText();
				break;
			default:
				break;
			}
			return null;
		}

		@Override
		public void hideEditor(int column) {
			this.editor = null;
			updateImage();
			updateText();
		}

		@Override
		public void showEditor(final Control editor, int column) {
			this.editor = editor;
			updateImage();
			updateText();
			if( editor != null ) {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						editor.setFocus();
					}
				});
			}
		}
	}

	class FXSelectionListener implements EventHandler<MouseEvent> {
		private TableListCell cell;
		
		public FXSelectionListener(TableListCell cell) {
			this.cell = cell;
		}
		
		@Override
		public void handle(MouseEvent event) {
			if( event.getClickCount() == 2 && cell.currentItem != null ) {
				Event evt = new Event();
				evt.item = cell.currentItem;
				internal_sendEvent(SWT.DefaultSelection, evt, true);
			}
		}
	}
	
	static class CustomListViewSkin extends ListViewSkin<TableItem> {

		public CustomListViewSkin(ListView<TableItem> arg0) {
			super(arg0);
		}
		
		public VirtualFlow<ListCell<TableItem>> swt_getFlow() {
			return flow;
		}
	}
	
	static class CustomTableViewSkin extends TableViewSkin<TableItem> {

		public CustomTableViewSkin(TableView<TableItem> arg0) {
			super(arg0);
		}
		
		public VirtualFlow<TableRow<TableItem>> swt_getFlow() {
			return flow;
		}
	}
}
