/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TestTable extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane b = new BorderPane();
		b.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, new EventHandler<ContextMenuEvent>() {

			@Override
			public void handle(ContextMenuEvent event) {
				System.err.println("HELLO WORLD");
			}
		});
//		b.getChildren().add(new ProgressBar());
		Scene s = new Scene(b,400,400);
		primaryStage.setScene(s);
		primaryStage.show();
		
		
//		TableView<String> view = new TableView<>();
//		TableColumn<String, String> c = new TableColumn<>("Hello World");
//		view.getColumns().add(c);
//		
//		view.setItems(FXCollections.observableArrayList("A","B","C"));
//		
//		Scene s = new Scene(view,300,300);
//		s.focusOwnerProperty().addListener(new ChangeListener<Node>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Node> observable,
//					Node oldValue, Node newValue) {
//				System.err.println(oldValue);
//				System.err.println(newValue);
//			}
//		});
//		primaryStage.focusedProperty().addListener(new ChangeListener<Boolean>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Boolean> observable,
//					Boolean oldValue, Boolean newValue) {
//				System.err.println(oldValue);
//				System.err.println(newValue);
//			}
//		});
//		primaryStage.setScene(s);
//		primaryStage.show();
	}
	
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		HBox b = new HBox();
//		int type = TextLayout.TYPE_TEXT | TextLayout.TYPE_TOP;
//		Canvas canvas = new Canvas(300,300);
//		TextLayoutFactory factory = Toolkit.getToolkit().getTextLayoutFactory();
//		TextLayout layout = factory.createLayout();
//		System.err.println(Font.getDefault());
//		layout.setContent("Hello World!", Font.getDefault().impl_getNativeFont());
//		
//		BaseBounds bounds = layout.getBounds();
//		System.err.println(bounds);
//		canvas.getGraphicsContext2D().setFill(javafx.scene.paint.Color.RED);
//		canvas.getGraphicsContext2D().fillRect(0, 0, bounds.getWidth(), bounds.getHeight());
//		
//		canvas.getGraphicsContext2D().setStroke(javafx.scene.paint.Color.BLACK);
//		canvas.getGraphicsContext2D().setFill(javafx.scene.paint.Color.BLACK);
//		path(canvas, (Path2D) layout.getShape(type, null),true);
//		b.getChildren().add(canvas);
//				
//		Scene s = new Scene(b,300,300);
//		primaryStage.setScene(s);
//		primaryStage.show();
//	}
//	
//	private static void path(Canvas canvas, Path2D path, boolean fill) {
//		PathIterator pathIterator = path.getPathIterator(null);
//		float coords[] = new float[6];
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//		gc.beginPath();
//		
//		float x = 0;
//		float y = 0;
//		
//		while( ! pathIterator.isDone() ) {
//			switch (pathIterator.currentSegment(coords)) {
//			case PathIterator.SEG_CLOSE:
//				gc.lineTo(x, y);
//				break;
//			case PathIterator.SEG_CUBICTO:
//				gc.bezierCurveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
//				break;
//			case PathIterator.SEG_LINETO:
//				gc.lineTo(coords[0], coords[1]);
//				break;
//			case PathIterator.SEG_MOVETO:
//				gc.moveTo(coords[0], coords[1]);
//				x = coords[0];
//				y = coords[1];
//				break;
//			case PathIterator.SEG_QUADTO:
//				gc.quadraticCurveTo(coords[0], coords[1], coords[2], coords[3]);
//				break;
//			default:
//				break;
//			}
//			pathIterator.next();
//		}
//		
//		if( fill ) {
//			gc.fill();
//		} else {
//			gc.stroke();
//		}
//		gc.closePath();
//	}
	
}