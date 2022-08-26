/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.paint;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An editor to define paints
 */
public class PaintEditor extends StackPane {
	private static final int PREVIEW_SIZE = 200;

	@NonNull
	static final DecimalFormat FORMAT = new DecimalFormat("0.0#"); //$NON-NLS-1$

	private ObjectProperty<BiConsumer<@NonNull State, @Nullable Paint>> stateConsumer = new SimpleObjectProperty<>();

	/**
	 * The different states
	 */
	public enum State {
		/**
		 * Ok pressed
		 */
		OK,
		/**
		 * Apply pressed
		 */
		APPLY,
		/**
		 * Cancel pressed
		 */
		CANCEL
	}

	@NonNull
	private final TabPane paintTabFolder;

	@Nullable
	private Rectangle linearGradientPreview;

	@Nullable
	private Rectangle radialGradientPreview;

	@Nullable
	private Rectangle solidPreview;

	@NonNull
	private final ReadOnlyObjectWrapper<@Nullable Paint> paint = new ReadOnlyObjectWrapper<>();

	/**
	 * Create a new paint editor
	 * 
	 * @param defaultPaint
	 *            the default paint
	 * @param states
	 *            the state buttons to show (empty == all buttons are shown)
	 */
	public PaintEditor(@Nullable Paint defaultPaint, State... states) {
		this.paint.set(defaultPaint);
		List<State> asList = Arrays.asList(states);

		BorderPane pane = new BorderPane();

		this.paintTabFolder = new TabPane();
		this.paintTabFolder.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		Tab solid = createColorTab();
		Tab linear = createLinearTab();
		Tab radial = createRadialTab();
		this.paintTabFolder.getTabs().addAll(solid, linear, radial);

		pane.setCenter(this.paintTabFolder);

		GridLayoutPane gl = new GridLayoutPane();
		gl.setNumColumns(1);

		GridLayoutPane buttons = new GridLayoutPane();
		buttons.setMakeColumnsEqualWidth(true);
		buttons.setNumColumns(states.length == 0 ? 3 : states.length);
		
		if( asList.isEmpty() || asList.contains(State.APPLY) )
		{
			Button b = new Button(Messages.getString("PaintEditor.Apply")); //$NON-NLS-1$
			b.setOnAction(this::handleApply);
			buttons.getChildren().add(b);
			GridLayoutPane.setConstraint(b, new GridData(Alignment.FILL, Alignment.CENTER, false, false));
		}

		if( asList.isEmpty() || asList.contains(State.OK) )
		{
			Button b = new Button(Messages.getString("PaintEditor.Ok")); //$NON-NLS-1$
			b.setOnAction(this::handleOk);
			buttons.getChildren().add(b);
			GridLayoutPane.setConstraint(b, new GridData(Alignment.FILL, Alignment.CENTER, false, false));
		}

		if( asList.isEmpty() || asList.contains(State.CANCEL) )
		{
			Button b = new Button(Messages.getString("PaintEditor.Cancel")); //$NON-NLS-1$
			b.setOnAction(this::handleCancel);
			buttons.getChildren().add(b);
			GridLayoutPane.setConstraint(b, new GridData(Alignment.FILL, Alignment.CENTER, false, false));
		}

		GridLayoutPane.setConstraint(buttons, new GridData(Alignment.END, Alignment.CENTER, true, false));
		gl.getChildren().add(buttons);

		pane.setBottom(gl);

		getChildren().add(pane);

		if (defaultPaint instanceof LinearGradient) {
			this.paintTabFolder.getSelectionModel().select(linear);
		} else if (defaultPaint instanceof RadialGradient) {
			this.paintTabFolder.getSelectionModel().select(radial);
		} else {
			this.paintTabFolder.getSelectionModel().select(solid);
		}

		// make sure it is still the default
		this.paint.set(defaultPaint);
		this.paintTabFolder.getSelectionModel().selectedItemProperty().addListener((o, oldTab, newTab) -> {
			Rectangle t = null;
			if (newTab == linear) {
				t = this.linearGradientPreview;
			} else if (newTab == radial) {
				t = this.radialGradientPreview;
			} else {
				t = this.solidPreview;
			}

			if (t != null) {
				this.paint.set(t.getFill());
			} else {
				this.paint.set(null);
			}
		});
	}

	/**
	 * Get the current paint
	 * 
	 * @return the paint
	 */
	public @Nullable Paint getPaint() {
		return this.paint.get();
	}

	/**
	 * @return the paint property
	 */
	@SuppressWarnings("null")
	public @NonNull ReadOnlyObjectProperty<@Nullable Paint> getPaintProperty() {
		return this.paint.getReadOnlyProperty();
	}

	private void handleApply(ActionEvent e) {
		BiConsumer<@NonNull State, @Nullable Paint> consumer = this.stateConsumer.get();
		if (consumer != null) {
			consumer.accept(State.APPLY, getPaint());
		}
	}

	private void handleOk(ActionEvent e) {
		BiConsumer<@NonNull State, @Nullable Paint> consumer = this.stateConsumer.get();
		if (consumer != null) {
			consumer.accept(State.OK, getPaint());
		}
	}

	private void handleCancel(ActionEvent e) {
		BiConsumer<@NonNull State, @Nullable Paint> consumer = this.stateConsumer.get();
		if (consumer != null) {
			consumer.accept(State.CANCEL, null);
		}
	}

	/**
	 * Set a state consumer
	 * 
	 * @param stateConsumer
	 *            the consumer
	 */
	public void setStateConsumer(BiConsumer<@NonNull State, @Nullable Paint> stateConsumer) {
		this.stateConsumer.set(stateConsumer);
	}

	/**
	 * @return the current state consumer
	 */
	public BiConsumer<@NonNull State, @Nullable Paint> getStateConsumer() {
		return this.stateConsumer.get();
	}

	private Tab createColorTab() {
		Tab t = new Tab();
		t.setText(Messages.getString("PaintEditor.Color")); //$NON-NLS-1$

		GridLayoutPane p = new GridLayoutPane();
		p.setNumColumns(3);

		Rectangle solidPreview = new Rectangle(PREVIEW_SIZE, PREVIEW_SIZE);

		this.solidPreview = solidPreview;

		GridLayoutPane dataPane = new GridLayoutPane();
		dataPane.setNumColumns(2);

		ColorPicker picker = new ColorPicker();
		picker.valueProperty().addListener((o) -> {
			solidPreview.setFill(picker.getValue());
			this.paint.set(picker.getValue());
		});
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.Color")), picker); //$NON-NLS-1$

		Color color = (Color) this.paint.get();
		if (color instanceof Color) {
			picker.setValue(color);
		}

		TitledPane dtp = new TitledPane(Messages.getString("PaintEditor.Data"), dataPane); //$NON-NLS-1$
		dtp.setCollapsible(false);

		TitledPane pane = new TitledPane(Messages.getString("PaintEditor.Preview"), solidPreview); //$NON-NLS-1$
		pane.setCollapsible(false);

		GridLayoutPane.setConstraint(dtp, new GridData(Alignment.FILL, Alignment.FILL, true, true));
		GridLayoutPane.setConstraint(pane, new GridData(Alignment.BEGINNING, Alignment.BEGINNING, false, false));

		p.getChildren().addAll(pane, dtp);

		t.setContent(p);

		return t;
	}

	private Tab createLinearTab() {
		Tab t = new Tab();
		t.setText(Messages.getString("PaintEditor.LinearGradient")); //$NON-NLS-1$

		GridLayoutPane p = new GridLayoutPane();
		p.setNumColumns(3);

		Rectangle linearGradientPreview = new Rectangle(PREVIEW_SIZE, PREVIEW_SIZE);

		this.linearGradientPreview = linearGradientPreview;

		TextField startX = new TextField();
		TextField startY = new TextField();
		TextField endX = new TextField();
		TextField endY = new TextField();
		CheckBox proportional = new CheckBox();
		ChoiceBox<CycleMethod> cycleMethod = new ChoiceBox<>(FXCollections.observableArrayList(CycleMethod.values()));

		GridLayoutPane dataPane = new GridLayoutPane();
		dataPane.setNumColumns(2);

		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.StartX")), startX); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.StartY")), startY); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.EndX")), endX); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.EndY")), endY); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.Proportional")), proportional); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.CycleMethod")), cycleMethod); //$NON-NLS-1$

		ListView<Stop> colorStops = new ListView<>();
		colorStops.setCellFactory((v) -> new StopCell());

		@Nullable
		Paint paint = this.paint.get();

		Runnable updateLinear = () -> {
			linearGradientPreview.setFill(createLinearGradient(startX.getText(), startY.getText(), endX.getText(), endY.getText(), proportional.isSelected(), cycleMethod.getSelectionModel().getSelectedItem(), colorStops.getItems()));
			this.paint.set(linearGradientPreview.getFill());
		};

		if (!(paint instanceof LinearGradient)) {
			startX.setText(FORMAT.format(0));
			startY.setText(FORMAT.format(0));
			endX.setText(FORMAT.format(1));
			endY.setText(FORMAT.format(1));
			proportional.setSelected(true);
			cycleMethod.getSelectionModel().select(0);
			colorStops.setItems(FXCollections.observableArrayList(new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)));
			updateLinear.run();
		} else if (paint instanceof LinearGradient) {
			linearGradientPreview.setFill(paint);
			LinearGradient g = (LinearGradient) paint;
			startX.setText(FORMAT.format(g.getStartX()));
			startY.setText(FORMAT.format(g.getStartY()));
			endX.setText(FORMAT.format(g.getEndY()));
			endY.setText(FORMAT.format(g.getEndY()));
			proportional.setSelected(g.isProportional());
			cycleMethod.setValue(g.getCycleMethod());
		}

		StopColorPane pane = new StopColorPane((oldStop, newStop) -> {
			ObservableList<Stop> items = colorStops.getItems();
			items.set(items.indexOf(oldStop), newStop);
			colorStops.getSelectionModel().select(newStop);
			updateLinear.run();
		});

		InvalidationListener l = (o) -> {
			updateLinear.run();
		};
		startX.textProperty().addListener(l);
		startY.textProperty().addListener(l);
		endX.textProperty().addListener(l);
		endY.textProperty().addListener(l);
		proportional.selectedProperty().addListener(l);
		cycleMethod.getSelectionModel().selectedItemProperty().addListener(l);

		colorStops.getSelectionModel().selectedItemProperty().addListener((o) -> {
			Stop item = colorStops.getSelectionModel().getSelectedItem();
			if (item != null) {
				pane.setStop(item);
			}
		});

		TitledPane previewPane = new TitledPane(Messages.getString("PaintEditor.Preview"), linearGradientPreview); //$NON-NLS-1$
		previewPane.setCollapsible(false);

		BorderPane colorContainer = new BorderPane(colorStops);

		{
			Button newColor = new Button(Messages.getString("PaintEditor.New")); //$NON-NLS-1$
			newColor.setOnAction((e) -> {
				Stop s = new Stop(0, Color.RED);
				colorStops.getItems().add(s);
				colorStops.getSelectionModel().select(s);
			});
			GridLayoutPane.setConstraint(newColor, new GridData(Alignment.FILL, Alignment.CENTER, false, false));

			Button removeColor = new Button(Messages.getString("PaintEditor.Remove")); //$NON-NLS-1$
			removeColor.setOnAction((e) -> {
				colorStops.getItems().removeAll(colorStops.getSelectionModel().getSelectedItems());
			});
			GridLayoutPane.setConstraint(removeColor, new GridData(Alignment.FILL, Alignment.CENTER, false, false));

			GridLayoutPane buttonContainer = new GridLayoutPane();
			buttonContainer.setNumColumns(2);
			buttonContainer.setMakeColumnsEqualWidth(true);
			buttonContainer.getChildren().addAll(newColor, removeColor);

			colorContainer.setBottom(buttonContainer);
		}

		TitledPane colorStopPane = new TitledPane(Messages.getString("PaintEditor.Colors"), colorContainer); //$NON-NLS-1$
		colorStopPane.setCollapsible(false);

		GridLayoutPane.setConstraint(previewPane, new GridData(Alignment.BEGINNING, Alignment.BEGINNING, false, false, 1, 2));
		GridLayoutPane.setConstraint(colorStopPane, new GridData(Alignment.CENTER, Alignment.FILL, false, true, 1, 2));
		GridLayoutPane.setConstraint(pane, new GridData(Alignment.FILL, Alignment.BEGINNING, true, false));

		TitledPane dtp = new TitledPane(Messages.getString("PaintEditor.Data"), dataPane); //$NON-NLS-1$
		dtp.setCollapsible(false);

		GridLayoutPane.setConstraint(dtp, new GridData(Alignment.FILL, Alignment.FILL, true, true));

		p.getChildren().addAll(previewPane, colorStopPane, pane, dtp);

		t.setContent(p);

		return t;
	}

	private static LinearGradient createLinearGradient(String startX, String startY, String endX, String endY, boolean proportional, CycleMethod cycleMethod, List<Stop> stops) {
		double dsx = parseSafe(startX, 0);
		double dsy = parseSafe(startY, 0);
		double dex = parseSafe(endX, 1);
		double dey = parseSafe(endY, 1);
		return new LinearGradient(dsx, dsy, dex, dey, proportional, cycleMethod, stops);
	}

	private static RadialGradient createRadialGradient(String focusAngle, String focusDistance, String centerX, String centerY, String radius, boolean proportional, CycleMethod cycleMethod, List<Stop> stops) {
		double dFocusAngle = parseSafe(focusAngle, 0);
		double dFocusDistance = parseSafe(focusDistance, 0);
		double dCenterX = parseSafe(centerX, 0.5);
		double dCenterY = parseSafe(centerY, 0.5);
		double dRadius = parseSafe(radius, 1);
		return new RadialGradient(dFocusAngle, dFocusDistance, dCenterX, dCenterY, dRadius, proportional, cycleMethod, stops);
	}

	static double parseSafe(String value, double defaultVal) {
		try {
			return FORMAT.parse(value).doubleValue();
		} catch (ParseException e) {
			// skip and return default
		}
		return defaultVal;
	}

	private Tab createRadialTab() {
		Tab t = new Tab();
		t.setText(Messages.getString("PaintEditor.RadialGradient")); //$NON-NLS-1$

		GridLayoutPane p = new GridLayoutPane();
		p.setNumColumns(3);

		Rectangle radialGradientPreview = new Rectangle(PREVIEW_SIZE, PREVIEW_SIZE);
		this.radialGradientPreview = radialGradientPreview;

		TextField focusAngle = new TextField();
		TextField focusDistance = new TextField();
		TextField centerX = new TextField();
		TextField centerY = new TextField();
		TextField radius = new TextField();
		CheckBox proportional = new CheckBox();
		ChoiceBox<CycleMethod> cycleMethod = new ChoiceBox<>(FXCollections.observableArrayList(CycleMethod.values()));

		GridLayoutPane dataPane = new GridLayoutPane();
		dataPane.setNumColumns(2);

		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.FocusAngle")), focusAngle); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.FocusDistance")), focusDistance); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.CenterX")), centerX); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.CenterY")), centerY); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.Radius")), radius); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.Proportional")), proportional); //$NON-NLS-1$
		dataPane.getChildren().addAll(new Label(Messages.getString("PaintEditor.CycleMethod")), cycleMethod); //$NON-NLS-1$

		ListView<Stop> colorStops = new ListView<>();
		colorStops.setCellFactory((v) -> new StopCell());

		@Nullable
		Paint paint = this.paint.get();

		Runnable updateRadial = () -> {
			radialGradientPreview.setFill(createRadialGradient(focusAngle.getText(), focusDistance.getText(), centerX.getText(), centerY.getText(), radius.getText(), proportional.isSelected(), cycleMethod.getSelectionModel().getSelectedItem(), colorStops.getItems()));
			this.paint.set(radialGradientPreview.getFill());
		};

		if (!(paint instanceof RadialGradient)) {
			focusAngle.setText(FORMAT.format(0));
			focusDistance.setText(FORMAT.format(0));
			centerX.setText(FORMAT.format(0.5));
			centerY.setText(FORMAT.format(0.5));
			radius.setText(FORMAT.format(1));
			proportional.setSelected(true);
			cycleMethod.getSelectionModel().select(0);
			colorStops.setItems(FXCollections.observableArrayList(new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)));
			updateRadial.run();
		} else if (paint instanceof RadialGradient) {
			radialGradientPreview.setFill(paint);
			RadialGradient g = (RadialGradient) paint;
			focusAngle.setText(FORMAT.format(g.getFocusAngle()));
			focusDistance.setText(FORMAT.format(g.getFocusDistance()));
			centerX.setText(FORMAT.format(g.getCenterX()));
			centerY.setText(FORMAT.format(g.getCenterY()));
			radius.setText(FORMAT.format(g.getRadius()));
			proportional.setSelected(g.isProportional());
			cycleMethod.setValue(g.getCycleMethod());
		}

		StopColorPane pane = new StopColorPane((oldStop, newStop) -> {
			ObservableList<Stop> items = colorStops.getItems();
			items.set(items.indexOf(oldStop), newStop);
			colorStops.getSelectionModel().select(newStop);
			updateRadial.run();
		});

		InvalidationListener l = (o) -> {
			updateRadial.run();
		};
		focusAngle.textProperty().addListener(l);
		focusDistance.textProperty().addListener(l);
		centerX.textProperty().addListener(l);
		centerY.textProperty().addListener(l);
		radius.textProperty().addListener(l);
		proportional.selectedProperty().addListener(l);
		cycleMethod.getSelectionModel().selectedItemProperty().addListener(l);

		colorStops.getSelectionModel().selectedItemProperty().addListener((o) -> {
			Stop item = colorStops.getSelectionModel().getSelectedItem();
			if (item != null) {
				pane.setStop(item);
			}
		});

		TitledPane previewPane = new TitledPane(Messages.getString("PaintEditor.Preview"), radialGradientPreview); //$NON-NLS-1$
		previewPane.setCollapsible(false);

		BorderPane colorContainer = new BorderPane(colorStops);

		{
			Button newColor = new Button(Messages.getString("PaintEditor.New")); //$NON-NLS-1$
			newColor.setOnAction((e) -> {
				Stop s = new Stop(0, Color.RED);
				colorStops.getItems().add(s);
				colorStops.getSelectionModel().select(s);
			});
			GridLayoutPane.setConstraint(newColor, new GridData(Alignment.FILL, Alignment.CENTER, false, false));

			Button removeColor = new Button(Messages.getString("PaintEditor.Remove")); //$NON-NLS-1$
			removeColor.setOnAction((e) -> {
				colorStops.getItems().removeAll(colorStops.getSelectionModel().getSelectedItems());
			});
			GridLayoutPane.setConstraint(removeColor, new GridData(Alignment.FILL, Alignment.CENTER, false, false));

			GridLayoutPane buttonContainer = new GridLayoutPane();
			buttonContainer.setNumColumns(2);
			buttonContainer.setMakeColumnsEqualWidth(true);
			buttonContainer.getChildren().addAll(newColor, removeColor);

			colorContainer.setBottom(buttonContainer);
		}

		TitledPane colorStopPane = new TitledPane(Messages.getString("PaintEditor.Colors"), colorContainer); //$NON-NLS-1$
		colorStopPane.setCollapsible(false);

		GridLayoutPane.setConstraint(previewPane, new GridData(Alignment.BEGINNING, Alignment.BEGINNING, false, false, 1, 2));
		GridLayoutPane.setConstraint(colorStopPane, new GridData(Alignment.CENTER, Alignment.FILL, false, true, 1, 2));
		GridLayoutPane.setConstraint(pane, new GridData(Alignment.FILL, Alignment.BEGINNING, true, false));

		TitledPane dtp = new TitledPane(Messages.getString("PaintEditor.Data"), dataPane); //$NON-NLS-1$
		dtp.setCollapsible(false);
		GridLayoutPane.setConstraint(dtp, new GridData(Alignment.FILL, Alignment.FILL, true, true));
		p.getChildren().addAll(previewPane, colorStopPane, pane, dtp);

		t.setContent(p);

		return t;
	}
	
	static class StopCell extends ListCell<Stop> {
		@Override
		protected void updateItem(Stop item, boolean empty) {
			super.updateItem(item, empty);
			if( item != null && ! empty ) {
				Rectangle r = new Rectangle(20,20,item.getColor());
				r.setStrokeWidth(1);
				r.setStroke(Color.BLACK);
				setGraphic(r);
				setText(FORMAT.format(item.getOffset()*100)+"%"); //$NON-NLS-1$
			} else {
				setGraphic(null);
				setText(null);
			}
		}
	}

	static class StopColorPane extends TitledPane {
		@NonNull
		private final ColorPicker picker;

		@NonNull
		private final TextField f;

		private Stop stop;
		private BiConsumer<Stop, Stop> consumer;
		private boolean inSet;

		public StopColorPane(BiConsumer<Stop, Stop> consumer) {
			setText(Messages.getString("PaintEditor.ColorStop")); //$NON-NLS-1$
			this.consumer = consumer;
			setCollapsible(false);
			setDisable(true);

			GridLayoutPane p = new GridLayoutPane();
			p.setNumColumns(2);

			{
				this.picker = new ColorPicker();
				this.picker.valueProperty().addListener(this::update);
				GridLayoutPane.setConstraint(this.picker, new GridData(GridData.FILL_HORIZONTAL));
				p.getChildren().addAll(new Label(Messages.getString("PaintEditor.Color")), this.picker); //$NON-NLS-1$
			}

			{
				this.f = new TextField();
				this.f.textProperty().addListener(this::update);
				GridLayoutPane.setConstraint(this.f, new GridData(GridData.FILL_HORIZONTAL));
				p.getChildren().addAll(new Label(Messages.getString("PaintEditor.Offset")), this.f); //$NON-NLS-1$
			}

			setContent(p);
		}

		void update(Observable t) {
			if (this.inSet) {
				return;
			}
			try {
				this.inSet = true;
				this.consumer.accept(this.stop, new Stop(parseSafe(this.f.getText(), 0), this.picker.getValue()));
			} finally {
				this.inSet = false;
			}
		}

		public void setStop(Stop stop) {
			this.stop = stop;
			if (this.inSet) {
				return;
			}

			try {
				this.inSet = true;
				if (stop != null) {
					this.picker.setValue(stop.getColor());
					this.f.setText(FORMAT.format(stop.getOffset()));
					setDisable(false);
				} else {
					setDisable(true);
				}
			} finally {
				this.inSet = false;
			}
		}

	}
}
