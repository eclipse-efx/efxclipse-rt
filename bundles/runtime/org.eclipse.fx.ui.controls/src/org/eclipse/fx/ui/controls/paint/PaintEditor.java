/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.paint;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.panes.RowLayoutPane;

public class PaintEditor extends StackPane {
	private static final DecimalFormat FORMAT = new DecimalFormat("0.0#");
	private ObjectProperty<Consumer<Paint>> okConsumer = new SimpleObjectProperty<>();
	private ObjectProperty<Consumer<Paint>> applyConsumer = new SimpleObjectProperty<>();
	private ObjectProperty<Runnable> cancel = new SimpleObjectProperty<>();
	
	private Paint defaultPaint;
	
	public PaintEditor(Paint defaultPaint) {
		this.defaultPaint = defaultPaint;
		
		BorderPane pane = new BorderPane();
		
		TabPane p = new TabPane();
		p.getTabs().addAll(createLinearTab(), createRadialTab());
		
		pane.setCenter(p);
		
		GridLayoutPane gl = new GridLayoutPane();
		gl.setNumColumns(1);
		
		GridLayoutPane buttons = new GridLayoutPane();
		buttons.setMakeColumnsEqualWidth(true);
		buttons.setNumColumns(3);
		
		{
			Button b = new Button("Apply");
			buttons.getChildren().add(b);
			GridLayoutPane.setConstraint(b, new GridData(Alignment.FILL,Alignment.CENTER,false,false));
		}
		
		{
			Button b = new Button("Ok");
			buttons.getChildren().add(b);
			GridLayoutPane.setConstraint(b, new GridData(Alignment.FILL,Alignment.CENTER,false,false));
		}
		
		{
			Button b = new Button("Cancel");
			buttons.getChildren().add(b);
			GridLayoutPane.setConstraint(b, new GridData(Alignment.FILL,Alignment.CENTER,false,false));
		}
		
		GridLayoutPane.setConstraint(buttons, new GridData(Alignment.END,Alignment.CENTER,true,false));
		gl.getChildren().add(buttons);
		
		pane.setBottom(gl);
		
		getChildren().add(pane);
	}
	
	public void setOkConsumer(Consumer<Paint> okConsumer) {
		this.okConsumer.set(okConsumer);
	}
	
	public void setApplyConsumer(Consumer<Paint> applyConsumer) {
		this.applyConsumer.set(applyConsumer);
	}
	
	public void setCancel(Runnable r) {
		this.cancel.set(r);
	}
	
	private Tab createLinearTab() {
		Tab t = new Tab();
		t.setText("Linear Gradient");
		
		GridLayoutPane p = new GridLayoutPane();
		p.setNumColumns(3);
		
		Rectangle r = new Rectangle(200, 200);
		
		
		TextField startX = new TextField();
		TextField startY = new TextField();
		TextField endX = new TextField();
		TextField endY = new TextField();
		CheckBox proportional = new CheckBox();
		ChoiceBox<CycleMethod> cycleMethod = new ChoiceBox<>(FXCollections.observableArrayList(CycleMethod.values()));
		
		GridLayoutPane dataPane = new GridLayoutPane();
		dataPane.setNumColumns(2);
		
		dataPane.getChildren().addAll(new Label("Start X"),startX);
		dataPane.getChildren().addAll(new Label("Start Y"),startY);
		dataPane.getChildren().addAll(new Label("End X"),endX);
		dataPane.getChildren().addAll(new Label("End Y"),endY);
		dataPane.getChildren().addAll(new Label("Proportional"),proportional);
		dataPane.getChildren().addAll(new Label("CycleMethod"),cycleMethod);
		
		
		ListView<Stop> colorStops = new ListView<Stop>();
		
		if(!(defaultPaint instanceof LinearGradient)) {
			startX.setText(FORMAT.format(0));
			startY.setText(FORMAT.format(0));
			endX.setText(FORMAT.format(1));
			endY.setText(FORMAT.format(1));
			proportional.setSelected(true);
			cycleMethod.getSelectionModel().select(0);
			colorStops.setItems(FXCollections.observableArrayList(new Stop(0,Color.WHITE), new Stop(1, Color.BLACK)));
			r.setFill(createLinearGradient(startX.getText(), startY.getText(), endX.getText(), endY.getText(), proportional.isSelected(), cycleMethod.getSelectionModel().getSelectedItem(), colorStops.getItems()));
		}
		else {
			r.setFill(defaultPaint);
			LinearGradient g = (LinearGradient) this.defaultPaint;
			startX.setText(FORMAT.format(g.getStartX()));
			startY.setText(FORMAT.format(g.getStartY()));
			endX.setText(FORMAT.format(g.getEndY()));
			endY.setText(FORMAT.format(g.getEndY()));
			proportional.setSelected(g.isProportional());
			cycleMethod.setValue(g.getCycleMethod());
		}
		
		StopColorPane pane = new StopColorPane((oldStop,newStop) -> {
			ObservableList<Stop> items = colorStops.getItems();
			items.set(items.indexOf(oldStop), newStop);
			colorStops.getSelectionModel().select(newStop);
			r.setFill(createLinearGradient(startX.getText(), startY.getText(), endX.getText(), endY.getText(), proportional.isSelected(), cycleMethod.getSelectionModel().getSelectedItem(), items));
		});
		
		InvalidationListener l = (o) -> { r.setFill(createLinearGradient(startX.getText(), startY.getText(), endX.getText(), endY.getText(), proportional.isSelected(), cycleMethod.getSelectionModel().getSelectedItem(), colorStops.getItems())); };
		startX.textProperty().addListener(l);
		startY.textProperty().addListener(l);
		endX.textProperty().addListener(l);
		endY.textProperty().addListener(l);
		proportional.selectedProperty().addListener(l);
		cycleMethod.getSelectionModel().selectedItemProperty().addListener(l);
		
		colorStops.getSelectionModel().selectedItemProperty().addListener((o) -> {
			Stop item = colorStops.getSelectionModel().getSelectedItem();
			if( item != null ) {
				pane.setStop(item);
			}
		});
		
		GridLayoutPane.setConstraint(r, new GridData(Alignment.CENTER,Alignment.CENTER,false,false,1,2));
		GridLayoutPane.setConstraint(colorStops, new GridData(Alignment.CENTER,Alignment.FILL,false,true,1,2));
		GridLayoutPane.setConstraint(pane, new GridData(Alignment.FILL,Alignment.BEGINNING,true,false));
		
		TitledPane dtp = new TitledPane("Data", dataPane);
		GridLayoutPane.setConstraint(dtp, new GridData(Alignment.FILL,Alignment.BEGINNING,true,false));
		p.getChildren().addAll(r, colorStops, pane, dtp);
		
		t.setContent(p);
		
		return t;
	}
	
	private LinearGradient createLinearGradient(String startX, String startY, String endX, String endY, boolean proportional, CycleMethod cycleMethod, List<Stop> stops) {
		try {
			double dsx = FORMAT.parse(startX).doubleValue();
			double dsy = FORMAT.parse(startY).doubleValue();
			double dex = FORMAT.parse(endX).doubleValue();
			double dey = FORMAT.parse(endY).doubleValue();
			
			return new LinearGradient(dsx, dsy, dex, dey, proportional, cycleMethod, stops);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Tab createRadialTab() {
		Tab t = new Tab();
		t.setText("Radial Gradient");
		
		return t;
	}
	
	static class StopColorPane extends TitledPane {
		
		private ColorPicker picker;
		private TextField f;
		private Stop stop;
		private BiConsumer<Stop, Stop> consumer;
		private boolean inSet;
		
		public StopColorPane(BiConsumer<Stop, Stop> consumer) {
			setText("Color Stop");
			this.consumer = consumer;
			setCollapsible(false);
			setDisable(true);
			
			GridLayoutPane p = new GridLayoutPane();
			p.setNumColumns(2);
			
			{
				picker = new ColorPicker();
				picker.valueProperty().addListener(this::update);
				GridLayoutPane.setConstraint(picker, new GridData(GridData.FILL_HORIZONTAL));
				p.getChildren().addAll(new Label("Color"),picker);
			}
			
			{
				f = new TextField();
				f.textProperty().addListener(this::update);
				GridLayoutPane.setConstraint(f, new GridData(GridData.FILL_HORIZONTAL));
				p.getChildren().addAll(new Label("Offset"),f);
			}
			
			setContent(p);
		}
		
		void update(Observable t) {
			if( inSet ) {
				return;
			}
			try {
				consumer.accept(stop,new Stop(new DecimalFormat("0.0#").parse(f.getText()).doubleValue(), picker.getValue()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void setStop(Stop stop) {
			this.stop = stop;
			try {
				inSet = true;
				if( stop != null ) {
					picker.setValue(stop.getColor());
					f.setText(new DecimalFormat("0.0#").format(stop.getOffset()));
					setDisable(false);
				} else {
					setDisable(true);
				}
			} finally {
				inSet = false;
			}
		}
		
	}
}
