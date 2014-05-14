package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.lang.reflect.Field;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Skin;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * 
 */
public class DnDTabPane extends TabPane {
	private static Tab DRAGGED_TAB;
	private static final DataFormat TAB_MOVE = new DataFormat("DnDTabPane:tabMove");
	
	public static final EventType<TabPaneDragStartEvent> DND_TABPANE_DRAG_START = new EventType<> (Event.ANY, "DND_TABPANE_DRAG_START"); //$NON-NLS-1$
	public static final EventType<TabPaneDroppedEvent> DND_TABPANE_DROPPED = new EventType<> (Event.ANY, "DND_TABPANE_DROPPED"); //$NON-NLS-1$
	public static final EventType<TabPaneDragFinishedEvent> DND_TABPANE_DRAG_FINISHED = new EventType<> (Event.ANY, "DND_TABPANE_DRAG_FINISHED"); //$NON-NLS-1$
	public static final EventType<TabPaneFeedbackDragEvent> DND_TABPANE_DRAG_FEEDBACK = new EventType<> (Event.ANY, "DND_TABPANE_DRAG_FEEDBACK"); //$NON-NLS-1$
	
	public static class TabPaneDragStartEvent extends Event {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public final Tab tab;
		
		public TabPaneDragStartEvent(TabPane pane, Tab tab) {
			super(pane, pane, DND_TABPANE_DRAG_START);
			this.tab = tab;
		}
	}

	public static class TabPaneDragFinishedEvent extends Event {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public final Tab tab;
		
		public TabPaneDragFinishedEvent(TabPane pane, Tab tab) {
			super(pane, pane, DND_TABPANE_DRAG_FINISHED);
			this.tab = tab;
		}
	}

	public static class TabPaneDroppedEvent extends Event {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public final Tab sourceTab;
		
		public final Tab targetTab;
		
		public final DropType type;
		
		public TabPaneDroppedEvent(TabPane pane, Tab sourceTab, Tab targetTab, DropType type) {
			super(pane, pane, DND_TABPANE_DROPPED);
			this.sourceTab = sourceTab;
			this.targetTab = targetTab;
			this.type = type;
		}
	}
	
	public static class TabPaneFeedbackDragEvent extends Event {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public final Tab sourceTab;
		
		public final Tab targetTab; 
		
		public final DropType dropType;
		
		public final Bounds bounds;
		
		public TabPaneFeedbackDragEvent(TabPane pane, Tab sourceTab, Tab targetTab, Bounds bounds, DropType dropType) {
			super(pane, pane, DND_TABPANE_DRAG_FEEDBACK);
			this.sourceTab = sourceTab;
			this.targetTab = targetTab;
			this.dropType = dropType;
			this.bounds = bounds;
		}
	}
	
	public enum DropType {
		NONE,
		BEFORE,
		AFTER
	}
	
	private BooleanProperty dndEnabled = new SimpleBooleanProperty(this, "dndEnabled", true);
	
	
	@Override
	protected Skin<?> createDefaultSkin() {
		Skin<?> skin = super.createDefaultSkin();
		hookTabFolderSkin(skin);
		return skin;
	}
	
	private void hookTabFolderSkin(Skin<?> skin) {
		try {
			Field f_tabHeaderArea = skin.getClass().getDeclaredField("tabHeaderArea"); //$NON-NLS-1$
			f_tabHeaderArea.setAccessible(true);
			
			Pane tabHeaderArea = (StackPane) f_tabHeaderArea.get(skin);
			
			Field f_headersRegion = tabHeaderArea.getClass().getDeclaredField("headersRegion"); //$NON-NLS-1$
			f_headersRegion.setAccessible(true);
			
			Pane headersRegion = (StackPane) f_headersRegion.get(tabHeaderArea);
			EventHandler<MouseEvent> handler = this::tabPane_handleDragStart;
			EventHandler<DragEvent> handlerFinished = this::tabPane_handleDragDone;
			
			for( Node tabHeaderSkin : headersRegion.getChildren() ) {
				tabHeaderSkin.addEventHandler(MouseEvent.DRAG_DETECTED, handler);
				tabHeaderSkin.addEventHandler(DragEvent.DRAG_DONE, handlerFinished);
			}
			
			headersRegion.getChildren().addListener((javafx.collections.ListChangeListener.Change<? extends Node> change) -> {
				while (change.next()) {
					if (change.wasRemoved()) {
						change.getRemoved().forEach((e) -> e.removeEventHandler(MouseEvent.DRAG_DETECTED, handler));
						change.getRemoved().forEach((e) -> e.removeEventHandler(DragEvent.DRAG_DONE, handlerFinished));
					}
					if( change.wasAdded() ) {
						change.getAddedSubList().forEach((e) -> e.addEventHandler(MouseEvent.DRAG_DETECTED, handler));
						change.getRemoved().forEach((e) -> e.addEventHandler(DragEvent.DRAG_DONE, handlerFinished));
					}
				}
			});
			
			tabHeaderArea.addEventHandler(DragEvent.DRAG_OVER, (e) -> tabPane_handleDragOver(tabHeaderArea, headersRegion, e));
			tabHeaderArea.addEventHandler(DragEvent.DRAG_DROPPED, (e) -> tabPane_handleDragDropped(tabHeaderArea, headersRegion, e));
			tabHeaderArea.addEventHandler(DragEvent.DRAG_EXITED, this::tabPane_handleDragDone);
		} catch (Throwable t) {
//			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	}
	
	void tabPane_handleDragStart(MouseEvent event) {
		if( this.dndEnabled.get() ) {
			try {		        
				Field f_tab = event.getSource().getClass().getDeclaredField("tab"); //$NON-NLS-1$
				f_tab.setAccessible(true);
				Tab t = (Tab) f_tab.get(event.getSource());
				
				TabPaneDragStartEvent dndStartEvent = new TabPaneDragStartEvent(this,t);
		        Event.fireEvent(this, dndStartEvent);
				
				if( ! dndStartEvent.isConsumed() ) {
					DRAGGED_TAB = t;
					Node node = (Node)event.getSource();
					Dragboard db = node.startDragAndDrop(TransferMode.MOVE);
					
					WritableImage snapShot = node.snapshot(new SnapshotParameters(), null);
					PixelReader reader = snapShot.getPixelReader();
					int padX = 10;
					int padY = 10;
					int width = (int)snapShot.getWidth();
					int height = (int)snapShot.getHeight();
					WritableImage image = new WritableImage(width+padX,height+padY);
					PixelWriter writer = image.getPixelWriter();
					
					int h = 0;
					int v = 0;
					while( h < width+padX ) {
						v = 0;
						while( v < height+padY ) {
							if( h >= padX && h <= width + padX && v >= padY && v <= height + padY ) {
								writer.setColor(h, v, reader.getColor(h - padX, v - padY));
							} else {
								writer.setColor(h, v, Color.TRANSPARENT);	
							}
							
							v++;
						}
						h++;
					}
					
					db.setDragView(image, image.getWidth(), image.getHeight()*-1);
					
					ClipboardContent content = new ClipboardContent();
		        	content.put(TAB_MOVE, Boolean.TRUE);
		            db.setContent(content);
				}
			} catch(Throwable t) {
//				// TODO Auto-generated catch block
				t.printStackTrace();
			}	
		}
	}
	
	void tabPane_handleDragOver(Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		if( DRAGGED_TAB == null ) {
			return;
		}
		
		double x = event.getX() - headersRegion.getBoundsInParent().getMinX();
		
		Node referenceNode = null;
		DropType type = DropType.AFTER;
		for( Node n : headersRegion.getChildren() ) {
			Bounds b = n.getBoundsInParent();
			if( b.getMaxX() > x ) {
				if( b.getMinX() + b.getWidth()/2 > x ) {
					referenceNode = n;
					type = DropType.BEFORE;
				} else {
					referenceNode = n;
					type = DropType.AFTER;
				}
				break;
			}
		}
		
		if( referenceNode == null && headersRegion.getChildren().size() > 0 ) {
			referenceNode = headersRegion.getChildren().get(headersRegion.getChildren().size()-1);
			type = DropType.AFTER;
		}
		
		if( referenceNode != null ) {
			try {
				Field field = referenceNode.getClass().getDeclaredField("tab"); //$NON-NLS-1$
				field.setAccessible(true);
				Tab tab = (Tab) field.get(referenceNode);
				
				boolean noMove = false;
				if( tab == DRAGGED_TAB ) {
					noMove = true;
				} else if( type == DropType.BEFORE ) {
					int idx = getTabs().indexOf(tab);
					if( idx > 0 ) {
						if( getTabs().get(idx-1) == DRAGGED_TAB ) {
							noMove = true;
						}
					}
				} else {
					int idx = getTabs().indexOf(tab);
					
					if( idx + 1  < getTabs().size() ) {
						if( getTabs().get(idx+1) == DRAGGED_TAB ) {
							noMove = true;	
						}
					}
				}
				
				if( noMove ) {
					TabPaneFeedbackDragEvent feedbackEvent = new TabPaneFeedbackDragEvent(this, DRAGGED_TAB, null, null, DropType.NONE);
					Event.fireEvent(this, feedbackEvent);
					return;
				}
				
				Bounds b = referenceNode.getBoundsInLocal();
				b = referenceNode.localToScene(b);
				b = this.sceneToLocal(b);
				
				TabPaneFeedbackDragEvent feedbackEvent = new TabPaneFeedbackDragEvent(this, DRAGGED_TAB, tab, b, type);
				Event.fireEvent(this, feedbackEvent);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			event.acceptTransferModes(TransferMode.MOVE);
	        event.consume();
		} else {
			TabPaneFeedbackDragEvent feedbackEvent = new TabPaneFeedbackDragEvent(this, DRAGGED_TAB, null, null, DropType.NONE);
			Event.fireEvent(this, feedbackEvent);
		}
	}
	
	void tabPane_handleDragDropped(Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		if( DRAGGED_TAB == null ) {
			return;
		}
		
		double x = event.getX() - headersRegion.getBoundsInParent().getMinX();
		
		Node referenceNode = null;
		DropType type = DropType.AFTER;
		for( Node n : headersRegion.getChildren() ) {
			Bounds b = n.getBoundsInParent();
			if( b.getMaxX() > x ) {
				if( b.getMinX() + b.getWidth()/2 > x ) {
					referenceNode = n;
					type = DropType.BEFORE;
				} else {
					referenceNode = n;
					type = DropType.AFTER;
				}
				break;
			}
		}
		
		if( referenceNode == null && headersRegion.getChildren().size() > 0 ) {
			referenceNode = headersRegion.getChildren().get(headersRegion.getChildren().size()-1);
			type = DropType.AFTER;
		}
		
		if( referenceNode != null ) {
			try {
				Field field = referenceNode.getClass().getDeclaredField("tab"); //$NON-NLS-1$
				field.setAccessible(true);
				Tab tab = (Tab) field.get(referenceNode);
				
				boolean noMove = false;
				if( tab == DRAGGED_TAB ) {
					noMove = true;
				} else if( type == DropType.BEFORE ) {
					int idx = getTabs().indexOf(tab);
					if( idx > 0 ) {
						if( getTabs().get(idx-1) == DRAGGED_TAB ) {
							noMove = true;
						}
					}
				} else {
					int idx = getTabs().indexOf(tab);
					
					if( idx + 1  < getTabs().size() ) {
						if( getTabs().get(idx+1) == DRAGGED_TAB ) {
							noMove = true;	
						}
					}
				}
				
				
				if( ! noMove ) {
					TabPaneDroppedEvent dropped = new TabPaneDroppedEvent(this, DRAGGED_TAB, tab, type);
					Event.fireEvent(this, dropped);
					event.setDropCompleted(true);
				} else {
					event.setDropCompleted(false);
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        event.consume();
		}
	}
	
	void tabPane_handleDragDone(DragEvent event)  {
		if( DRAGGED_TAB == null ) {
			return;
		}
		
		TabPaneDragFinishedEvent dndStartEvent = new TabPaneDragFinishedEvent(this,DRAGGED_TAB);
        Event.fireEvent(this, dndStartEvent);
	}
}
