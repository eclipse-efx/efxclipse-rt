/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.event.spy.internal.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.fx.tool.event.spy.internal.core.model.IEventItem;
import org.eclipse.fx.tool.event.spy.internal.model.EventSpyModel;
import org.eclipse.fx.tool.event.spy.internal.util.MultilineFormatter;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;

/**
 * TreeTable gui element that gives an hierarchical overview over the captured events and its properties.
 */
public class EventOverview {

    private final class CustomTreeTableCell extends TextFieldTreeTableCell<IEventItem, IEventItem.PresentableItem> {

        private final boolean useMultilineFormatter;

        public CustomTreeTableCell(boolean useMultilineFormatter) {
            this.useMultilineFormatter = useMultilineFormatter;
        }

        @Override
        public void updateItem(IEventItem.PresentableItem item, boolean empty) {

            if (!empty) {
                setText(computeText(item));
                setTooltip(new Tooltip(item.getTooltip()));

                setOnContextMenuRequested(event -> {
                    ContextMenu contextMenu = new ContextMenu();

                    MenuItem item1 = new MenuItem("Create " + item.getTooltip() + " filter");
                    item1.setOnAction(ev -> {
                        eventSpyModel.autoCreateFilter(item.getTooltip(), item.toString());
                    });
                    contextMenu.getItems().add(item1);
                    contextMenu.show(this, event.getSceneX(), event.getSceneY());

                });

            } else {
                setText(null);
                setTooltip(null);
                setOnContextMenuRequested(null);
            }

        }

        private String computeText(IEventItem.PresentableItem item) {
            if (useMultilineFormatter) {
                return MultilineFormatter.format(item.toString(), eventSpyModel.lineWrapProperty().getValue());
            } else {
                return item.toString();
            }
        }
    }

    private TreeTableView<IEventItem> treeTableView;

    private final EventSpyModel eventSpyModel;

    /**
     * Main constructor.
     * 
     * @param eventSpyModel
     */
    public EventOverview(EventSpyModel eventSpyModel) {
        this.eventSpyModel = eventSpyModel;
    }

    /**
     * Returns the gui element.
     * 
     * @return
     */
    Region getGui() {
        if (treeTableView == null) {
            createGui();
        }
        return treeTableView;
    }

    private void createGui() {
        treeTableView = new TreeTableView<>();

        eventSpyModel.wrapOnProperty().addListener((event, oldValue, newValue) -> {
            treeTableView.refresh();
        });

        addTreeTableColumn("Topic", "name", false);
        addTreeTableColumn("Event publisher", "param1", true);
        addTreeTableColumn("Changed element", "param2", false);

        treeTableView.setShowRoot(false);
        
    

        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        treeTableView.rootProperty().bind(Bindings.createObjectBinding(() -> {

            TreeItem<IEventItem> root = new TreeItem<>();
            root.setExpanded(true);
            root.getChildren().clear();
            root.getChildren().addAll(eventSpyModel.getCapturedEvents().stream().map(this::createTreeItem).collect(Collectors.toList()));

            return root;

        }, eventSpyModel.getCapturedEvents()));

        treeTableView.setOnKeyPressed(t -> {

            if (t.isControlDown() && t.getCode() == KeyCode.F) {

                TextInputDialog dialog = new TextInputDialog(eventSpyModel.getLastSearchString());

                dialog.setTitle("Search dialog");
                dialog.setContentText("");
                dialog.setHeaderText("Search for ... ");

                dialog.showAndWait();

                String dialogResult = dialog.getResult();
                if (dialogResult != null) {

                    Optional<IEventItem> nextSelectedElement = eventSpyModel.search(dialogResult, 
                            treeTableView.getSelectionModel().getSelectedItem()!=null?
                            treeTableView.getSelectionModel().getSelectedItem().getValue():null);
                    nextSelectedElement.ifPresent(ele->{
                        
                        TreeItem<IEventItem> treeItem = treeItems.get(ele);
                        if (!treeItem.getParent().isExpanded()) {
                            treeItem.getParent().setExpanded(true);
                        }
                        treeTableView.getSelectionModel().select(treeItem);
                        treeTableView.scrollTo(
                                Math.max(0, 
                                treeTableView.getSelectionModel().getSelectedIndex()-3));
                        
                    });
                    
                }
            }

        });

    }

    private void addTreeTableColumn(String columnLabel, String propertyName, boolean useMultilineFormatter) {
        TreeTableColumn<IEventItem, IEventItem.PresentableItem> nameColumn = new TreeTableColumn<>(columnLabel);
        nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>(propertyName));
        treeTableView.getColumns().add(nameColumn);
        nameColumn.setCellFactory(tv -> new CustomTreeTableCell(useMultilineFormatter));
    }
    
    private Map<IEventItem, TreeItem<IEventItem>> treeItems = new HashMap<>();

    private TreeItem<IEventItem> createTreeItem(IEventItem element) {
        TreeItem<IEventItem> treeItem = new TreeItem<IEventItem>(element);
        treeItems.put(element, treeItem);
        treeItem.setExpanded(false);
        treeItem.getChildren().addAll(element.getChildren().stream().map(this::createTreeItem).collect(Collectors.toList()));
        return treeItem;
    }

}
