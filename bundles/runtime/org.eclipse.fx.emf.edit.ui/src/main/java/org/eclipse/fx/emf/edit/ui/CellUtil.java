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
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;

/**
 * Utility for cells
 */
public class CellUtil {

	/**
	 * Helper to get the row node for a cell
	 *
	 * @param cell
	 *            the cell
	 * @return the row node
	 */
	public static Cell<?> getRowNode(final Cell<?> cell) {
		if (cell instanceof TableCell)
			return ((TableCell<?, ?>) cell).getTableRow();
		else if (cell instanceof TreeTableCell)
			return ((TreeTableCell<?, ?>) cell).getTreeTableRow();
		else
			return cell;
	}

	/**
	 * Helper to get the selection model of the view for a given cell
	 *
	 * @param cell
	 *            the cell
	 * @return the selection model
	 */
	public static MultipleSelectionModel<?> getSelectionModel(Cell<?> cell) {
		if (cell instanceof ListCell)
			return ((ListCell<?>) cell).getListView().getSelectionModel();
		else if (cell instanceof TreeCell)
			return ((TreeCell<?>) cell).getTreeView().getSelectionModel();
		else if (cell instanceof TableCell)
			return ((TableCell<?, ?>) cell).getTableView().getSelectionModel();
		else if (cell instanceof TableRow)
			return ((TableRow<?>) cell).getTableView().getSelectionModel();
		else if (cell instanceof TreeTableCell)
			return ((TreeTableCell<?, ?>) cell).getTreeTableView()
					.getSelectionModel();
		else if (cell instanceof TreeTableRow)
			return ((TreeTableRow<?>) cell).getTreeTableView()
					.getSelectionModel();
		else
			throw new IllegalArgumentException("Unsupported Cell type"); //$NON-NLS-1$
	}

	static MultipleSelectionModel<?> getSelectionModel(Control view) {
		if (view instanceof TreeView<?>)
			return ((TreeView<?>) view).getSelectionModel();
		else if (view instanceof TreeTableView<?>)
			return ((TreeTableView<?>) view).getSelectionModel();
		else
			throw new IllegalArgumentException("Unsupported View type"); //$NON-NLS-1$
	}

	/**
	 * Helper to get selected items for a cell
	 *
	 * @param cell
	 *            the cell
	 * @return list of items
	 */
	public static List<?> getSelectedItems(Cell<?> cell) {
		MultipleSelectionModel<?> selectionModel = getSelectionModel(cell);
		List<?> items = selectionModel.getSelectedItems();

		if (cell instanceof TreeCell || cell instanceof TreeTableCell) {
			List<Object> unwrappedItems = new ArrayList<>(items.size());
			for (Object item : items) {
				if( item != null ) {
					unwrappedItems.add(((TreeItem<?>) item).getValue());
				}
			}

			return unwrappedItems;
		}

		return items;
	}

}
