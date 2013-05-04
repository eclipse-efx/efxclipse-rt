package org.eclipse.fx.emf.edit.ui;

import java.util.List;

import javafx.scene.control.Cell;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;

import org.eclipse.fx.core.Util;

public class CellUtil {

	/**
	 * Finds the row for a {@link Cell} so the feedback can be applied to the
	 * whole row
	 * 
	 * @return the containing {@link TableRow} for {@link TableCell}s or the
	 *         {@link TreeTableRow} for {@link TreeTableCell}s and the
	 *         {@link Cell} itself otherwise
	 */
	public static Cell<?> getRowNode(final Cell<?> cell) {
		return Util.isFX2() ? CellUtil2.getRowNode(cell) : CellUtil8.getRowNode(cell);
	}

	/**
	 * Retrieves the {@link MultipleSelectionModel} from the {@link ListView},
	 * {@link TreeView}, {@link TableView} or {@link TreeTableView} in which
	 * <code>cell</code> is displayed
	 * 
	 * @param cell
	 *            the {@link Cell} for which the {@link MultipleSelectionModel}
	 *            is to be retrieved
	 * @return the {@link MultipleSelectionModel} for this {@link Cell}
	 */
	public static MultipleSelectionModel<?> getSelectionModel(Cell<?> cell) {
		return Util.isFX2() ? CellUtil2.getSelectionModel(cell) : CellUtil8.getSelectionModel(cell);
	}

	public static MultipleSelectionModel<?> getSelectionModel(Control view) {
		return Util.isFX2() ? CellUtil2.getSelectionModel(view) : CellUtil8.getSelectionModel(view);
	}

	/**
	 * Retrieves the selected items from the {@link ListView}, {@link TreeView},
	 * {@link TableView} or {@link TreeTableView} in which <code>cell</code> is
	 * displayed. {@link TreeItem}s will be replaced with
	 * {@link TreeItem#getValue()}.
	 * 
	 * @param cell
	 *            the {@link Cell} for which the selected items should be
	 *            retrieved
	 * @return a {@link List} with the selected items
	 */
	public static List<?> getSelectedItems(Cell<?> cell) {
		return Util.isFX2() ? CellUtil2.getSelectedItems(cell) : CellUtil8.getSelectedItems(cell);
	}

}
