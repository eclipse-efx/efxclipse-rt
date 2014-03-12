package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.CanvasGC;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Table.SWTTableRow;

public class Tree extends Composite {
	private AnchorPane container;
	
	private TreeView<TreeItem> treeView;
	private TreeTableView<TreeItem> treeTableView;
	private List<TreeColumn> columns;
	
	private WeakHashMap<SWTTreeRow, Boolean> currentCells = new WeakHashMap<>();
	
	private javafx.scene.control.TreeItem<TreeItem> rootItem;
	
	private boolean measureItem;
	private boolean paintItem;
	private boolean eraseItem;
	
	public interface SWTTreeRow {

		void swt_hideEditor(int column);

		void swt_showEditor(Control editor, int column);

		Rectangle swt_getBounds();

		TreeItem swt_getTreeItem();

		Rectangle swt_getBounds(int i);
		
		int swt_getItemHeight();
	}
	
	public Tree(Composite parent, int style) {
		super(parent, style);
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
//			paintItem = true;
			break;
		case SWT.EraseItem:
			eraseItem = true;
			break;
		default:
			break;
		}
	}

	@Override
	protected Region createWidget() {
		rootItem = new javafx.scene.control.TreeItem<TreeItem>();
		container = new AnchorPane();
		treeView = new TreeView<>(rootItem);
		registerConnection(treeView);
		treeView.setShowRoot(false);
		treeView.setCellFactory(new Callback<TreeView<TreeItem>, TreeCell<TreeItem>>() {
			
			@Override
			public TreeCell<TreeItem> call(TreeView<TreeItem> param) {
				return new TreeCellImpl();
			}
		});
		treeView.getSelectionModel().setSelectionMode((style & SWT.MULTI) == SWT.MULTI ? SelectionMode.MULTIPLE : SelectionMode.SINGLE);
		treeView.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				if( treeView.getSelectionModel().getSelectedItems().isEmpty() ) {
					internal_sendEvent(SWT.Selection, new Event(), true);
				} else {
					javafx.scene.control.TreeItem<TreeItem> treeItem = treeView.getSelectionModel().getSelectedItems().get(treeView.getSelectionModel().getSelectedItems().size()-1);
					Event evt = new Event();
					evt.item = treeItem.getValue();
					evt.index =  treeView.getRow(treeItem);
					internal_sendEvent(SWT.Selection, evt, true);
				}
			}
		});
		AnchorPane.setTopAnchor(treeView, 0.0);
		AnchorPane.setBottomAnchor(treeView, 0.0);
		AnchorPane.setLeftAnchor(treeView, 0.0);
		AnchorPane.setRightAnchor(treeView, 0.0);
		container.getChildren().add(treeView);
		return container;
	}
	
	public SWTTreeRow internal_getTreeRow(TreeItem item) {
		for( SWTTreeRow c : currentCells.keySet() ) {
			System.err.println(c.swt_getTreeItem().getText());
			if( item == c.swt_getTreeItem() ) {
				return c;
			}
		}
		return null;
	}
	
	public Region internal_getNativeControl() {
		return treeView != null ? treeView : treeTableView;
	}
	
	protected Region internal_getEventTarget() {
		return treeView != null ? treeView : treeTableView;
	}
	
	TreeTableView<TreeItem> internal_getTreeTable() {
		return treeTableView;
	}
	
	public void internal_columnAdded(TreeColumn column) {
		Util.logNotImplemented();
		if( treeTableView == null ) {
			treeTableView = new TreeTableView<TreeItem>();
			container.getChildren().setAll(treeTableView);
		}
	}
	
	protected void internal_setLayout(Layout layout) {
		// Not needed for trees!!!
	}
	
	protected Canvas internal_initCanvas() {
		Util.logNotImplemented();
		return null;
	}
	
	@Override
	public Region internal_getNativeObject() {
		return container;
	}
	
	void internal_itemAdded(TreeItem item) {
		rootItem.getChildren().add(item.internal_getNativeObject());
	}
	
	void internal_itemAdded(TreeItem item, int index) {
		rootItem.getChildren().add(index, item.internal_getNativeObject());
	}
	
	void internal_itemRemoved(TreeItem item) {
		rootItem.getChildren().remove(item.internal_getNativeObject());
	}
	
	static TreeItem[] extractItemArray(List<javafx.scene.control.TreeItem<TreeItem>> list) {
		TreeItem[] rv = new TreeItem[list.size()];
		int i = 0;
		for( javafx.scene.control.TreeItem<TreeItem> t : list ) {
			rv[i++] = t.getValue();
		}
		return rv;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void dispose() {
		javafx.scene.control.TreeItem<TreeItem>[] children = rootItem.getChildren().toArray(new javafx.scene.control.TreeItem[0]);
		// clear the list this makes the remove faster
		rootItem.getChildren().clear();
		
		for( javafx.scene.control.TreeItem<TreeItem> i : children ) {
			i.getValue().dispose();
		}
		
		super.dispose();
	}
	
	public void addSelectionListener(SelectionListener listener) {
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection, typedListener);
		addListener (SWT.DefaultSelection, typedListener);
	}
	
	public void addTreeListener(TreeListener listener) {
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Expand, typedListener);
		addListener (SWT.Collapse, typedListener);
		
	}
	
	public void clear (int index, boolean all) {
		Util.logNotImplemented();
	}
	
	public void clearAll (boolean all) {
		Util.logNotImplemented();
	}
	
	public void deselectAll () {
		Util.logNotImplemented();
	}
	
	public void deselect (TreeItem item) {
		Util.logNotImplemented();
	}
	
	public TreeColumn getColumn (int index) {
		if( columns != null && index < columns.size() ) {
			return columns.get(index);
		}
		
		throw new IllegalArgumentException();
	}
	
	public int getColumnCount () {
		return columns != null ? columns.size() : 0;
	}
	
	public int [] getColumnOrder () {
		int[] rv = new int[getColumnCount()];
		
		int i = 0;
		for( javafx.scene.control.TreeTableColumn<TreeItem,?> c : treeTableView.getColumns() ) {
			rv[i++] = columns.indexOf(Widget.getWidget(c)); 
		}
		
		return rv;		
	}
	
	public TreeColumn [] getColumns () {
		return columns != null ? columns.toArray(new TreeColumn[0]) : new TreeColumn[0];
	}
//	
//	public int getGridLineWidth () {
//		
//	}
//	
//	public int getHeaderHeight () {
//		
//	}
//	
	public boolean getHeaderVisible () {
		Util.logNotImplemented();
		return true;
	}
	
	public TreeItem getItem (int index) {
		if( treeView != null ) {
			return rootItem.getChildren().get(index).getValue();
		} else {
			//TODO Implement
			Util.logNotImplemented();
			return null;
		}
	}
	
	public TreeItem getItem (Point point) {
		for( SWTTreeRow t : currentCells.keySet() ) {
			if( t.swt_getBounds().contains(point.x, point.y) ) {
				return t.swt_getTreeItem();
			}
		}
		//TODO We can only search visible cells!!!
		return null;
	}
	
	public int getItemCount () {
		return rootItem.getChildren().size();
	}
	
	public int getItemHeight() {
		int itemHeight = 1;
		for( SWTTreeRow c : currentCells.keySet() ) {
			itemHeight = (int) Math.max(itemHeight, c.swt_getItemHeight());
		}
		return itemHeight;
	}
	
	public TreeItem [] getItems () {
		return extractItemArray(rootItem.getChildren());
	}
	
	public boolean getLinesVisible () {
		Util.logNotImplemented();
		return true;
	}
	
	public TreeItem getParentItem () {
		return null;
	}
	
	public TreeItem [] getSelection () {
		ObservableList<javafx.scene.control.TreeItem<TreeItem>> selectedItems;
		if( treeView != null ) {
			selectedItems = treeView.getSelectionModel().getSelectedItems();
		} else {
			selectedItems = treeTableView.getSelectionModel().getSelectedItems();
		}
		
		TreeItem[] rv = new TreeItem[selectedItems.size()];
		int i = 0;
		for( javafx.scene.control.TreeItem<TreeItem> t : selectedItems ) {
			rv[i++] = t.getValue();
		}
		
		return rv;
	}
	
	public int getSelectionCount () {
		if( treeView != null ) {
			return treeView.getSelectionModel().getSelectedIndices().size();
		} else {
			return treeTableView.getSelectionModel().getSelectedIndices().size();
		}
	}
	
	public TreeColumn getSortColumn () {
		Util.logNotImplemented();
		return null;
	}
	
	public int getSortDirection () {
		Util.logNotImplemented();
		return SWT.NONE;
	}
	
	public TreeItem getTopItem () {
		Util.logNotImplemented();
		return null;
	}
	
	public int indexOf (TreeColumn column) {
		return columns != null ? columns.indexOf(column) : -1;
	}
	
	public int indexOf (TreeItem item) {
		return rootItem.getChildren().indexOf(item);
	}
	
	public void removeAll () {
		javafx.scene.control.TreeItem<TreeItem>[] children = rootItem.getChildren().toArray(new javafx.scene.control.TreeItem[0]);
		rootItem.getChildren().clear();
		for( javafx.scene.control.TreeItem<TreeItem> t : children ) {
			t.getValue().dispose();
		}
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection, listener);
	}
	
	public void removeTreeListener (TreeListener listener) {
		removeListener(SWT.Expand, listener);
		removeListener(SWT.Collapse, listener);
	}
//	
//	public void setInsertMark (TreeItem item, boolean before) {
//		
//	}
	
	public void selectAll () {
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				if( treeView != null ) {
					treeView.getSelectionModel().selectAll();	
				} else {
					treeTableView.getSelectionModel().selectAll();
				}
			}
		});
	}
	
	public void select (final TreeItem item) {
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				if( treeView != null ) {
					treeView.getSelectionModel().select(item.internal_getNativeObject());
				} else {
					treeTableView.getSelectionModel().select(item.internal_getNativeObject());
				}
			}
		});
	}
	
	public void setColumnOrder (int [] order) {
		Util.logNotImplemented();
	}
	
	public void setHeaderVisible (boolean show) {
		Util.logNotImplemented();
	}
	
	public void setItemCount (int count) {
		Util.logNotImplemented();
	}
	
	public void setLinesVisible (boolean show) {
		Util.logNotImplemented();
	}
//	
//	public void setRedraw (boolean redraw) {
//		
//	}
//	
	public void setSelection (final TreeItem item) {
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				if( treeView != null ) {
					treeView.getSelectionModel().select(item.internal_getNativeObject());
					treeView.scrollTo(treeView.getRow(item.internal_getNativeObject()));
				} else {
					treeTableView.getSelectionModel().select(item.internal_getNativeObject());
					treeTableView.scrollTo(treeTableView.getRow(item.internal_getNativeObject()));
				}
			}
		});
	}
	
	public void setSelection (final TreeItem [] items) {
		internal_runNoEvent(new Runnable() {
			
			@Override
			public void run() {
				List<javafx.scene.control.TreeItem<TreeItem>> l = new ArrayList<>(items.length);
				for( TreeItem i : items ) {
					l.add(i.internal_getNativeObject());
				}
				
				if( treeView != null ) {
					MultipleSelectionModel<javafx.scene.control.TreeItem<TreeItem>> selectionModel = treeView.getSelectionModel();
					selectionModel.clearSelection();
					
					for( javafx.scene.control.TreeItem<TreeItem> i : l ) {
						selectionModel.select(i);
					}
					if( ! l.isEmpty() ) {
						treeView.getFocusModel().focus(treeView.getRow(l.get(0)));
						treeView.scrollTo(treeView.getRow(l.get(0)));
					}
				} else {
					TreeTableViewSelectionModel<TreeItem> selectionModel = treeTableView.getSelectionModel();
					selectionModel.clearSelection();
					
					for( javafx.scene.control.TreeItem<TreeItem> i : l ) {
						selectionModel.select(i);
					}
					
					if( ! l.isEmpty() ) {
						treeTableView.scrollTo(treeTableView.getRow(l.get(0)));	
					}
				}
			}
		});
	}
	
	public void setSortColumn (TreeColumn column) {
		Util.logNotImplemented();
	}
	
	public void setSortDirection  (int direction) {
		Util.logNotImplemented();
	}
	
	public void setTopItem (TreeItem item) {
		Util.logNotImplemented();
	}
	
	public void showColumn (TreeColumn column) {
		treeTableView.scrollToColumn(column.internal_getNativeObject());
	}
	
	public void showItem (TreeItem item) {
		Util.logNotImplemented();
	}
	
	public void showSelection () {
		Util.logNotImplemented();
	}
	
	@Override
	protected void internal_attachControl(Control c) {
		Util.logNotImplemented();
	}
	
	@Override
	protected void internal_attachControl(int idx, Control c) {
		Util.logNotImplemented();
	}
	
	@Override
	protected void internal_detachControl(Control c) {
		Util.logNotImplemented();
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
	class TreeCellImpl extends TreeCell<TreeItem> implements SWTTreeRow, Drawable {
		private ImageView imageView;
		private TreeItem currentItem;
		private CheckBox checkbox;
		private HBox graphicItemsContainer;
		private Control editor;
		private Canvas ownerDrawCanvas;
		private StackPane ownerDrawContainer;
		
		@Override
		protected void updateItem(TreeItem item, boolean empty) {
			this.currentItem = item;
			System.err.println(item != null ? " =========> " + item.getText() : "");
			if( item != null && ! empty ) {
				if( measureItem ) {
					initCanvas();
					sendMeasureEvent();	
				}
				
				updateText();
				updateImage();
				currentCells.put(this, Boolean.TRUE);
			} else {
				setText(null);
				setGraphic(null);
				currentCells.remove(this);
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
			if( (Tree.this.getStyle() & SWT.CHECK) == SWT.CHECK ) {
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
		public void swt_hideEditor(int column) {
			this.editor = null;
			updateText();
			updateImage();
		}

		@Override
		public void swt_showEditor(Control editor, int column) {
			this.editor = editor;
			updateText();
			updateImage();
		}
		
		@Override
		public Rectangle getBounds() {
			return swt_getBounds();
		}
		
		@Override
		public Rectangle swt_getBounds() {
			Bounds bounds = getBoundsInParent();
			Point2D coords = internal_getNativeObject().sceneToLocal(localToScene(0, 0));
			
			return new Rectangle((int)coords.getX(), (int)coords.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		}
		
		@Override
		public Rectangle swt_getBounds(int i) {
			return swt_getBounds();
		}

		@Override
		public TreeItem swt_getTreeItem() {
			return currentItem;
		}
		
		@Override
		public int swt_getItemHeight() {
			return (int) getHeight();
		}
	}
}
