package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.lang.reflect.Field;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Skin;
import javafx.scene.control.Tab;
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

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.MarkerFeedback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;

public class DnDSupporter {
	public static DragData DRAG_DATA = null;
	public static MarkerFeedback CURRENT_FEEDBACK = null;
	
	private static final DataFormat TAB_MOVE = new DataFormat("EFX-TabPane:tabMove");
	
	private final WCallback<Void, WCallback<DragData, Boolean>> dragStartCallbackProvider;
	private final WCallback<Void, WCallback<DropData, Boolean>> dropCallbackProvider;
	private final DnDFeedbackService feedbackService;
	private final MPartStack stack;
	
	
	private DnDSupporter(DnDFeedbackService feedbackService, MPartStack stack, WCallback<Void, WCallback<DragData, Boolean>> dragStartCallbackProvider, WCallback<Void, WCallback<DropData, Boolean>> dropCallbackProvider) {
		this.dragStartCallbackProvider = dragStartCallbackProvider;
		this.dropCallbackProvider = dropCallbackProvider;
		this.stack = stack;
		this.feedbackService = feedbackService;
	}
	
	public static void hookTabPane(Skin<?> skin, MPartStack stack, DnDFeedbackService feedbackService, WCallback<Void, WCallback<DragData, Boolean>> dragStartCallbackProvider, WCallback<Void, WCallback<DropData, Boolean>> dropCallbackProvider) {
		new DnDSupporter(feedbackService, stack, dragStartCallbackProvider, dropCallbackProvider).hookTabFolderSkin(skin);
	}
	
	public void hookTabFolderSkin(Skin<?> skin) {
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
			
			tabHeaderArea.addEventHandler(DragEvent.DRAG_OVER, (e) -> tabPane_handleDragOver(this.stack, this.feedbackService, tabHeaderArea, headersRegion, e));
//			tabHeaderArea.addEventHandler(DragEvent.DRAG_ENTERED, this::tabPane_handleDragEntered);
			tabHeaderArea.addEventHandler(DragEvent.DRAG_DROPPED, (e) -> tabPane_handleDragDropped(this.stack, tabHeaderArea, headersRegion, e));
			tabHeaderArea.addEventHandler(DragEvent.DRAG_EXITED, DnDSupporter::tabPane_handleDragExit);		
		} catch (Throwable t) {
//			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	}
	
	static void tabPane_handleDragExit(DragEvent e) {
		cleanup();
	}
	
	void tabPane_handleDragDropped(MPartStack stack, Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		if( DRAG_DATA == null || DRAG_DATA.item == null ) {
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
				MStackElement reference = ((WStackItem<?, ?>)tab.getUserData()).getDomElement();
				
				boolean noMove = false;
				if( reference == DRAG_DATA.item ) {
					noMove = true;
				} else if( type == DropType.BEFORE ) {
					int idx = reference.getParent().getChildren().indexOf(reference);
					if( idx > 0 ) {
						if( reference.getParent().getChildren().get(idx-1) == DRAG_DATA.item ) {
							noMove = true;
						}
					}
				} else {
					int idx = reference.getParent().getChildren().indexOf(reference);
					
					if( idx + 1  < reference.getParent().getChildren().size() ) {
						if( reference.getParent().getChildren().get(idx+1) == DRAG_DATA.item ) {
							noMove = true;	
						}
					}
				}
				
				if( ! noMove ) {
					WCallback<DropData, Boolean> call = this.dropCallbackProvider.call(null);
					if( call != null ) {
						if( call.call(new DropData(reference, DRAG_DATA.item, type)).booleanValue() ) {
							event.setDropCompleted(true);
						} else {
							event.setDropCompleted(false);
						}
					}
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void tabPane_handleDragOver(MPartStack stack, DnDFeedbackService feedbackService, Pane tabHeaderArea, Pane headersRegion, DragEvent event) {
		if( DRAG_DATA == null || DRAG_DATA.item == null ) {
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
				MStackElement reference = ((WStackItem<?, ?>)tab.getUserData()).getDomElement();
				
				boolean noMove = false;
				if( reference == DRAG_DATA.item ) {
					noMove = true;
				} else if( type == DropType.BEFORE ) {
					int idx = reference.getParent().getChildren().indexOf(reference);
					if( idx > 0 ) {
						if( reference.getParent().getChildren().get(idx-1) == DRAG_DATA.item ) {
							noMove = true;
						}
					}
				} else {
					int idx = reference.getParent().getChildren().indexOf(reference);
					
					if( idx + 1  < reference.getParent().getChildren().size() ) {
						if( reference.getParent().getChildren().get(idx+1) == DRAG_DATA.item ) {
							noMove = true;	
						}
					}
				}
				
				if( noMove ) {
					cleanup();
					return;
				}
				
				Bounds b = referenceNode.getBoundsInLocal();
				b = referenceNode.localToScene(b);
				Node n = (Node) ((WLayoutedWidget<?>)stack.getWidget()).getStaticLayoutNode();
				b = n.sceneToLocal(b);
				
				DnDFeedbackData data = new DnDFeedbackData(
						reference, 
						DRAG_DATA.item, 
						type,
						stack,
						new DnDFeedbackService.Region(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight())
						);
				
				if( CURRENT_FEEDBACK == null || ! CURRENT_FEEDBACK.equals(data) ) {
					cleanup();
					CURRENT_FEEDBACK = feedbackService.showFeedback(data);
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			event.acceptTransferModes(TransferMode.MOVE);
	        event.consume();
		} else {
			cleanup();
		}
		
    		
	}
	
	static void cleanup() {
		if( CURRENT_FEEDBACK != null ) {
			CURRENT_FEEDBACK.hide();
			CURRENT_FEEDBACK = null;
		}
	}
	
	void tabPane_handleDragStart(MouseEvent event) {
		WCallback<DragData, Boolean> dragStartCallback = this.dragStartCallbackProvider.call(null); 
		if( dragStartCallback != null ) {
			try {
				Field f_tab = event.getSource().getClass().getDeclaredField("tab"); //$NON-NLS-1$
				f_tab.setAccessible(true);
				Tab t = (Tab) f_tab.get(event.getSource());
				
				WStackItem<?, ?> item = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) t.getUserData();
				MStackElement itemElement = item.getDomElement();
				MPartStack itemContainer = (MPartStack)(MUIElement)itemElement.getParent();
				DragData dragData = new DragData(itemContainer, itemElement);
				if( dragStartCallback.call(dragData).booleanValue() ) {
					DRAG_DATA = dragData;
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
	
	void tabPane_handleDragDone(DragEvent event)  {
		if( CURRENT_FEEDBACK != null ) {
			cleanup();
		}
		DRAG_DATA = null;
	}
}
