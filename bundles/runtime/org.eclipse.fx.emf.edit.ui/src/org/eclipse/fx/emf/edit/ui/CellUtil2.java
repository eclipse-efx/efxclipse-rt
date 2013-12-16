package org.eclipse.fx.emf.edit.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Cell;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

class CellUtil2 {

	static Cell<?> getRowNode(final Cell<?> cell) {
		if (cell instanceof TableCell)
			return ((TableCell<?, ?>) cell).getTableRow();
		else
			return cell;
	}

	static MultipleSelectionModel<?> getSelectionModel(Cell<?> cell) {
		if (cell instanceof ListCell)
			return ((ListCell<?>) cell).getListView().getSelectionModel();
		else if (cell instanceof TreeCell)
			return ((TreeCell<?>) cell).getTreeView().getSelectionModel();
		else if (cell instanceof TableCell)
			return ((TableCell<?, ?>) cell).getTableView().getSelectionModel();
		else if (cell instanceof TableRow)
			return ((TableRow<?>) cell).getTableView().getSelectionModel();
		else
			throw new IllegalArgumentException("Unsupported Cell type"); //$NON-NLS-1$
	}

	static MultipleSelectionModel<?> getSelectionModel(Control view) {
		if (view instanceof TreeView<?>)
			return ((TreeView<?>) view).getSelectionModel();
		else
			throw new IllegalArgumentException("Unsupported View type"); //$NON-NLS-1$
	}

	static List<?> getSelectedItems(Cell<?> cell) {
		MultipleSelectionModel<?> selectionModel = getSelectionModel(cell);
		List<?> items = selectionModel.getSelectedItems();

		if (cell instanceof TreeCell) {
			List<Object> unwrappedItems = new ArrayList<>(items.size());
			for (Object item : items)
				unwrappedItems.add(((TreeItem<?>) item).getValue());
			return unwrappedItems;
		}

		return items;
	}

}
