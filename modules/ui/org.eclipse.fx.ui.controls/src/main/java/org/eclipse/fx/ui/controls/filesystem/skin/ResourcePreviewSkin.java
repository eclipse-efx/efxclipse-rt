/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.ui.controls.filesystem.skin;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

import org.eclipse.fx.ui.controls.filesystem.DirItem;
import org.eclipse.fx.ui.controls.filesystem.FileItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.filesystem.ResourcePreview;
import org.eclipse.fx.ui.panes.GridLayoutPane;

import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Skin for the resource preview
 */
public class ResourcePreviewSkin extends
		SkinBase<ResourcePreview> {

	private Label nameProperty;
	private StackPane preview;
	private Label size;
	private Label lastModified;
	private GridLayoutPane fileProperties;
	private VBox box;
	private Label imageSizeValue;
	private Label imageSizeLabel;

	/**
	 * Create a new skin
	 *
	 * @param control
	 *            the control
	 */
	public ResourcePreviewSkin(ResourcePreview control) {
		super(control);
		this.box = new VBox();
		this.box.setVisible(false);
		this.box.setPadding(new Insets(10));
		this.preview = new StackPane();
		VBox.setVgrow(this.preview, Priority.ALWAYS);
		this.box.getChildren().add(this.preview);

		this.nameProperty = new Label();
		this.nameProperty.getStyleClass().addAll("preview", "resourceName");  //$NON-NLS-1$//$NON-NLS-2$
		this.nameProperty.setPrefWidth(Double.MAX_VALUE);
		this.nameProperty.setAlignment(Pos.CENTER);

		this.box.getChildren().add(this.nameProperty);

		this.fileProperties = new GridLayoutPane();
		this.fileProperties.setNumColumns(2);

		ResourceBundle b = ResourceBundle.getBundle("org.eclipse.fx.ui.controls.filesystem.skin.resource"); //$NON-NLS-1$

		{
			Label l = new Label(b.getString("ResourcePreviewSkin_Size")); //$NON-NLS-1$
			l.getStyleClass().addAll("preview", "resourcePropertyLabel");  //$NON-NLS-1$//$NON-NLS-2$
			this.fileProperties.getChildren().add(l);

			this.size = new Label();
			this.fileProperties.getChildren().add(this.size);
		}

		{
			Label l = new Label(b.getString("ResourcePreviewSkin_Lastmodified")); //$NON-NLS-1$
			l.getStyleClass().addAll("preview", "resourcePropertyLabel"); //$NON-NLS-1$ //$NON-NLS-2$
			this.fileProperties.getChildren().add(l);

			this.lastModified = new Label();
			this.fileProperties.getChildren().add(this.lastModified);
		}

		{
			this.imageSizeLabel = new Label(b.getString("ResourcePreviewSkin_Imagesize")); //$NON-NLS-1$
			this.imageSizeLabel.getStyleClass().addAll("preview", //$NON-NLS-1$
					"resourcePropertyLabel"); //$NON-NLS-1$
			this.fileProperties.getChildren().add(this.imageSizeLabel);

			this.imageSizeValue = new Label();
			this.fileProperties.getChildren().add(this.imageSizeValue);
		}
		this.box.getChildren().add(this.fileProperties);

		control.itemProperty().addListener(this::handleItemChanged);

		getChildren().add(this.box);

		handleItemChanged(control.itemProperty());
	}

	private void handleItemChanged(Observable o) {
		ResourceItem item = getSkinnable().getItem();
		this.imageSizeValue.textProperty().unbind();
		this.fileProperties.getChildren().removeAll(this.imageSizeLabel,
				this.imageSizeValue);
		if (item != null) {
			this.box.setVisible(true);
			this.nameProperty.setText(item.getName());

			ImageView v = new ImageView() {
				@Override
				public double minHeight(double width) {
					return 48;
				}

				@Override
				public double minWidth(double height) {
					return 48;
				}
			};
			v.setPreserveRatio(true);
			v.fitWidthProperty().bind(this.preview.widthProperty());
			if (item instanceof DirItem) {
				v.getStyleClass().add("folderBig"); //$NON-NLS-1$
				this.size.setText("--"); //$NON-NLS-1$
			} else {
				if (item.getName().endsWith(".png") || item.getName().endsWith(".jpg") || item.getName().endsWith(".gif")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					Image value = new Image(item.getUri(), true);
					v.setImage(value);
					this.imageSizeValue
							.textProperty()
							.bind(value
									.widthProperty()
									.asString("%.0f").concat(" x ").concat(value.heightProperty().asString("%.0f"))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					this.fileProperties.getChildren().addAll(
							this.imageSizeLabel, this.imageSizeValue);
				} else {
					v.getStyleClass().add("fileBig"); //$NON-NLS-1$
				}
				this.size.setText(((FileItem) item).getFormattedSize());
			}
			this.lastModified.setText(DateTimeFormatter.ofLocalizedDateTime(
					FormatStyle.SHORT)
					.format(item.lastModifiedProperty().get()));

			this.preview.getChildren().setAll(v);
		} else {
			this.box.setVisible(false);
			this.preview.getChildren().clear();
			this.nameProperty.setText(null);
		}
	}
}
