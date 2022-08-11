/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.ui.dialogs;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A font selection dialog
 */
public class FontDialog extends Dialog {
	@NonNull
	private final ObjectProperty<Font> font = new SimpleObjectProperty<>(this,
			"font", Font.getDefault()); //$NON-NLS-1$

	/**
	 * Create a new dialog
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 */
	public FontDialog(@Nullable Window parent, @NonNull String title) {
		super(parent, title);
	}

	/**
	 * @return the font selected
	 */
	@NonNull
	public ObjectProperty<Font> font() {
		return this.font;
	}

	/**
	 * Update the current selected font
	 * 
	 * @param f
	 *            the new font
	 */
	public void setFont(@Nullable Font f) {
		this.font.set(f);
	}

	/**
	 * @return the current font
	 */
	@Nullable
	public Font getFont() {
		return this.font.get();
	}

	@Override
	protected Node createDialogArea() {
		VBox p = new VBox(10);

		{
			HBox top = new HBox(10);

			{
				VBox container = new VBox();
				container.getChildren().add(new Label(Messages.getString("FontDialog.Family"))); //$NON-NLS-1$

				TextField f = new TextField();
				f.setText(this.font.get().getFamily());
				f.setOnKeyReleased(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {
						// TODO Auto-generated method stub

					}
				});
				container.getChildren().add(f);

				final ListView<String> v = new ListView<String>();
				v.setItems(FXCollections.observableArrayList(Font.getFamilies()));
				v.getSelectionModel().select(this.font.get().getFamily());
				v.scrollTo(this.font.get().getFamily());
				v.setPrefHeight(250);

				container.getChildren().add(v);

				top.getChildren().add(container);
			}

			{
				VBox container = new VBox();
				container.getChildren().add(new Label(Messages.getString("FontDialog.Posture"))); //$NON-NLS-1$

				FontPosture posture = this.font.get().getStyle().toLowerCase()
						.contains("italic") ? FontPosture.ITALIC //$NON-NLS-1$
						: FontPosture.REGULAR;
				TextField f = new TextField();
				f.setText(posture.name());
				container.getChildren().add(f);

				ListView<FontPosture> v = new ListView<>();
				v.setItems(FXCollections.observableArrayList(FontPosture
						.values()));

				v.getSelectionModel().select(posture);
				v.scrollTo(posture);
				v.setPrefWidth(120);
				v.setPrefHeight(250);

				container.getChildren().add(v);

				top.getChildren().add(container);
			}

			{
				VBox container = new VBox();
				container.getChildren().add(new Label(Messages.getString("FontDialog.Weight"))); //$NON-NLS-1$

				TextField f = new TextField();
				container.getChildren().add(f);

				ListView<FontWeight> v = new ListView<>();
				v.setItems(FXCollections.observableArrayList(FontWeight
						.values()));
				container.getChildren().add(v);
				v.setPrefHeight(250);
				v.setPrefWidth(120);

				top.getChildren().add(container);
			}

			{
				VBox container = new VBox();
				container.getChildren().add(new Label(Messages.getString("FontDialog.Size"))); //$NON-NLS-1$

				TextField f = new TextField();
				f.setText(this.font.get().getSize() + ""); //$NON-NLS-1$
				container.getChildren().add(f);

				ListView<Double> v = new ListView<Double>();
				ObservableList<Double> sizes = FXCollections
						.observableArrayList(Double.valueOf(8d), Double.valueOf(9d), Double.valueOf(10d), Double.valueOf(11d), Double.valueOf(12d), Double.valueOf(14d), Double.valueOf(16d),
								Double.valueOf(18d), Double.valueOf(20d), Double.valueOf(22d), Double.valueOf(24d), Double.valueOf(26d), Double.valueOf(28d), Double.valueOf(36d), Double.valueOf(48d), Double.valueOf(72d));
				if (!sizes.contains(Double.valueOf(this.font.get().getSize()))) {
					for (int i = 0; i < sizes.size(); i++) {
						if (this.font.get().getSize() > sizes.get(i).doubleValue()) {
							sizes.add(i, Double.valueOf(this.font.get().getSize()));
							break;
						}
					}
				}
				v.setItems(sizes);
				v.getSelectionModel().select(Double.valueOf(this.font.get().getSize()));
				v.setPrefWidth(80);
				v.setPrefHeight(250);
				container.getChildren().add(v);

				top.getChildren().add(container);
			}

			p.getChildren().add(top);
		}

		{
			TitledPane tb = new TitledPane();
			tb.setCollapsible(false);
			tb.setText(Messages.getString("FontDialog.Preview")); //$NON-NLS-1$

			TextField f = new TextField("AaBbYyZz"); //$NON-NLS-1$
			f.fontProperty().bind(this.font);
			f.setPrefHeight(80);
			tb.setContent(f);

			p.getChildren().add(tb);
		}

		return p;
	}

//	public static void main(String[] args) {
//		Application.launch(TempApp.class, args);
//	}

//	public static class TempApp extends Application {
//		@Override
//		public void start(Stage primaryStage) throws Exception {
//			FontDialog fd = new FontDialog(null, "Fonts");
//			fd.open();
//		}
//	}
}