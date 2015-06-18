package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class MultiMessageDialogContent extends BorderPane {
		public final TableView<Row> tabView;
		final GraphicsLoader graphicsLoader;

		public MultiMessageDialogContent(String message, Collection<MPart> parts, GraphicsLoader graphicsLoader) {
			this.graphicsLoader = graphicsLoader;
			Label l = new Label(message);
			setTop(l);

			this.tabView = new TableView<Row>();

			{
				TableColumn<Row, Boolean> column = new TableColumn<Row, Boolean>();
				column.setCellFactory(this::createCheckboxCell);
				column.setOnEditCommit((event) -> event.getRowValue().selected.set(event.getNewValue().booleanValue()));
				column.setCellValueFactory(new PropertyValueFactory<Row, Boolean>("selected")); //$NON-NLS-1$
				this.tabView.getColumns().add(column);
			}

			{
				TableColumn<Row, MPart> column = new TableColumn<Row, MPart>();
				column.setCellFactory(this::createTextCell);
				column.setCellValueFactory(new PropertyValueFactory<Row, MPart>("element")); //$NON-NLS-1$
				this.tabView.getColumns().add(column);
			}
			this.tabView.setEditable(true);

			List<Row> list = new ArrayList<Row>();
			for (MPart m : parts) {
				list.add(new Row(m));
			}
			this.tabView.setItems(FXCollections.observableArrayList(list));
			setCenter(this.tabView);
		}
		
		TableCell<Row, Boolean> createCheckboxCell(final TableColumn<Row, Boolean> param) {
			final CheckBox checkBox = new CheckBox();
			final TableCell<Row, Boolean> cell = new TableCell<Row, Boolean>() {

				@Override
				protected void updateItem(Boolean item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null) {
						checkBox.setDisable(true);
						checkBox.setSelected(false);
						checkBox.setOnAction(null);
					} else {
						checkBox.setDisable(false);
						checkBox.setSelected(item.booleanValue());
						checkBox.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								MultiMessageDialogContent.this.tabView.edit(0, param);
								commitEdit(Boolean.valueOf(checkBox.isSelected()));
							}
						});
					}
				}
			};

			cell.setGraphic(checkBox);
			return cell;
		}

		TableCell<Row, MPart> createTextCell(TableColumn<Row, MPart> param) {
			return new TableCell<Row, MPart>() {
				@SuppressWarnings("null")
				@Override
				protected void updateItem(MPart item, boolean empty) {
					super.updateItem(item, empty);
					if (item != null) {
						setText(item.getLocalizedLabel());
						String uri = item.getIconURI();
						if (uri != null) {
							setGraphic(MultiMessageDialogContent.this.graphicsLoader.getGraphicsNode(new EMFUri(URI.createURI(uri))));
						}
					}
				}
			};
		}
	}