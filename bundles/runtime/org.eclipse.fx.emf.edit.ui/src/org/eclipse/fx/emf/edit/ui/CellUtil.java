package org.eclipse.fx.emf.edit.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;

public class CellUtil {

	/**
	 * Finds the row for a {@link Cell} so the feedback can be applied to the whole row
	 * 
	 * @return the containing {@link TableRow} for {@link TableCell}s or the {@link TreeTableRow} for
	 *         {@link TreeTableCell}s and the {@link Cell} itself otherwise
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
	 * Retrieves the {@link MultipleSelectionModel} from the {@link ListView}, {@link TreeView},
	 * {@link TableView} or {@link TreeTableView} in which <code>cell</code> is displayed
	 * 
	 * @param cell the {@link Cell} for which the {@link MultipleSelectionModel} is to be retrieved
	 * @return the {@link MultipleSelectionModel} for this {@link Cell}
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
			return ((TreeTableCell<?, ?>) cell).getTreeTableView().getSelectionModel();
		else if (cell instanceof TreeTableRow)
			return ((TreeTableRow<?>) cell).getTreeTableView().getSelectionModel();
		else
			throw new IllegalArgumentException("Unsupported Cell type");
	}

	/**
	 * Retrieves the selected items from the {@link ListView}, {@link TreeView}, {@link TableView} or
	 * {@link TreeTableView} in which <code>cell</code> is displayed. {@link TreeItem}s will be replaced with
	 * {@link TreeItem#getValue()}.
	 * 
	 * @param cell the {@link Cell} for which the selected items should be retrieved
	 * @return a {@link List} with the selected items
	 */
	public static List<?> getSelectedItems(Cell<?> cell) {
		MultipleSelectionModel<?> selectionModel = getSelectionModel(cell);
		List<?> items = selectionModel.getSelectedItems();

		if (cell instanceof TreeCell || cell instanceof TreeTableCell) {
			List<Object> unwrappedItems = new ArrayList<>(items.size());
			for (Object item : items)
				unwrappedItems.add(((TreeItem<?>) item).getValue());
			return unwrappedItems;
		}

		return items;
	}

}
