/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem.skin;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

import org.eclipse.fx.ui.controls.filesystem.DirItem;
import org.eclipse.fx.ui.controls.filesystem.DirectoryView;
import org.eclipse.fx.ui.controls.filesystem.FileItem;
import org.eclipse.fx.ui.controls.filesystem.IconSize;
import org.eclipse.fx.ui.controls.filesystem.ResourceEvent;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Skin for {@link DirectoryView}
 *
 * @since 1.2
 */
public class DirectoryViewSkin extends
		SkinBase<DirectoryView> {

	private final ObservableList<ResourceItem> selectedItems;
	private DirItem currentItem;
	private TableView<ResourceItem> tableView;

	/**
	 * Create a new instance
	 *
	 * @param control
	 *            the control
	 * @param selectedItems
	 *            the selected items
	 */
	public DirectoryViewSkin(DirectoryView control,
			ObservableList<ResourceItem> selectedItems) {
		super(control);
		this.selectedItems = selectedItems;
		control.dirProperty().addListener(this::pathChangedHandler);
		setupView();
		pathChangedHandler(getSkinnable().dirProperty());
	}

	private void openSelectedResources() {
		Event.fireEvent(getSkinnable(), ResourceEvent.createOpenResource(getSkinnable(), getSkinnable().getSelectedItems()));
	}

	private void setupView() {
		Node n;
		switch (getSkinnable().getDisplayType()) {
		default:
			n = setupListView();
			break;
		}

		getChildren().setAll(n);
	}

	private Node setupListView() {
		this.tableView = new TableView<>();
		this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		ResourceBundle b = ResourceBundle
				.getBundle("org.eclipse.fx.ui.controls.filesystem.skin.resource"); //$NON-NLS-1$

		{
			TableColumn<ResourceItem, ResourceItem> c = new TableColumn<>(
					b.getString("DirectoryViewSkin_Name")); //$NON-NLS-1$
			c.setPrefWidth(400);
			c.setMinWidth(400);
			c.setCellFactory((co) -> new NameTableCell());
			c.setCellValueFactory((cdf) -> new SimpleObjectProperty<>(cdf
					.getValue()));
			this.tableView.getColumns().add(c);
		}

		{
			TableColumn<ResourceItem, LocalDateTime> c = new TableColumn<>(
					b.getString("DirectoryViewSkin_ChangeDate")); //$NON-NLS-1$
			c.setMinWidth(100);
			c.setCellFactory((co) -> new LastModifiedCell());
			c.setCellValueFactory((cdf) -> cdf.getValue()
					.lastModifiedProperty());
			this.tableView.getColumns().add(c);
		}

		{
			TableColumn<ResourceItem, Long> c = new TableColumn<>(
					b.getString("DirectoryViewSkin_Size")); //$NON-NLS-1$
			c.setCellFactory((co) -> new SizeCell());
			c.setCellValueFactory((cdf) -> {
				if (cdf.getValue() instanceof DirItem) {
					return new SimpleObjectProperty<>(null);
				}
				return ((FileItem) cdf.getValue()).fileSizeProperty();
			});

			c.setMinWidth(100);
			this.tableView.getColumns().add(c);
		}

		this.tableView.setOnMouseReleased((e) -> {
			if (e.getClickCount() == 2) {
				openSelectedResources();
			}
		});
		Bindings.bindContent(this.selectedItems, this.tableView.getSelectionModel()
				.getSelectedItems());
		return this.tableView;
	}

	private void pathChangedHandler(Observable o) {
		this.currentItem = getSkinnable().getDir();
		if (this.currentItem != null) {
			this.tableView.setItems(this.currentItem.getChildren());
		} else {
			this.tableView.setItems(FXCollections.observableArrayList());
		}
	}

	static int size(IconSize s) {
		switch (s) {
		case SMALL:
			return 26;
		case MEDIUM:
			return 42;
		default:
			return 58;
		}
	}

	static class SizeCell extends TableCell<ResourceItem, Long> {
		private static NumberFormat BYTE_FORMAT = new DecimalFormat(
				"#,##0 'Bytes'"); //$NON-NLS-1$
		private static NumberFormat KB_FORMAT = new DecimalFormat("#,##0 'KB'"); //$NON-NLS-1$
		private static NumberFormat MB_FORMAT = new DecimalFormat(
				"#,##0.0 'MB'"); //$NON-NLS-1$

		public SizeCell() {
			setAlignment(Pos.CENTER_RIGHT);
		}

		@Override
		protected void updateItem(Long item, boolean empty) {
			if (!empty) {
				if (item == null) {
					setText("--"); //$NON-NLS-1$
				} else if (item.longValue() >= 1000 * 1000) {
					setText(MB_FORMAT
							.format(item.longValue() / (1024.0 * 1024)));
				} else if (item.longValue() >= 1000) {
					setText(KB_FORMAT.format(item.longValue() / 1000.0));
				} else {
					setText(BYTE_FORMAT.format(item.longValue()));
				}
			} else {
				setText(null);
			}
			super.updateItem(item, empty);
		}
	}

	class LastModifiedCell extends TableCell<ResourceItem, LocalDateTime> {
		public LastModifiedCell() {
			setAlignment(Pos.CENTER_LEFT);
		}

		@Override
		protected void updateItem(LocalDateTime item, boolean empty) {
			if (item != null && !empty) {
				setText(DateTimeFormatter
						.ofLocalizedDateTime(FormatStyle.SHORT).format(item));

			} else {
				setText(null);
			}
			super.updateItem(item, empty);
		}
	}

	class NameTableCell extends TableCell<ResourceItem, ResourceItem> {
		@Override
		protected void updateItem(ResourceItem item, boolean empty) {
			if (item != null && !empty) {
				Label l = new Label();
				ImageView v = new ImageView();
				if (item instanceof DirItem) {
					String styleClass;
					switch (getSkinnable().getIconSize()) {
					case SMALL:
						styleClass = "folderSmall"; //$NON-NLS-1$
						break;
					case MEDIUM:
						styleClass = "folderMedium"; //$NON-NLS-1$
						break;
					default:
						styleClass = "folderBig"; //$NON-NLS-1$
						break;
					}
					v.getStyleClass().add(styleClass);
				} else {
					if (item.getName().endsWith(".gif") || item.getName().endsWith(".png") || item.getName().endsWith(".jpg")) { //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
						int size;

						switch (getSkinnable().getIconSize()) {
						case SMALL:
							size = 16;
							break;
						case MEDIUM:
							size = 32;
							break;
						default:
							size = 48;
							break;
						}

						Image img = new Image(item.getUri(), size, size, true,
								true, true);
						v.setImage(img);
					} else {
						String styleClass;
						switch (getSkinnable().getIconSize()) {
						case SMALL:
							styleClass = "fileSmall"; //$NON-NLS-1$
							break;
						case MEDIUM:
							styleClass = "fileMedium"; //$NON-NLS-1$
							break;
						default:
							styleClass = "fileBig"; //$NON-NLS-1$
							break;
						}
						v.getStyleClass().add(styleClass);
					}
				}
				l.setGraphic(v);
				l.setText(item.getName());
				v.setFitWidth(size(getSkinnable().getIconSize()) - 10);
				v.setPreserveRatio(true);
				l.setMaxHeight(size(getSkinnable().getIconSize()));
				setGraphic(l);
			} else {
				setGraphic(null);
			}
			super.updateItem(item, empty);
		}
	}
}