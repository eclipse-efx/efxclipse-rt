package org.eclipse.fx.emf.edit.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Cell;
import javafx.scene.control.TextField;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellEditHandler;

/**
 * Cell editor handler for {@link EAttribute}
 */
public class EAttributeCellEditHandler implements ICellEditHandler {

	EAttribute attribute;
	EditingDomain editingDomain;
	TextField textField;

	/**
	 * Create a new instance
	 * 
	 * @param attribute
	 *            the attribute
	 * @param editingDomain
	 *            the editing domain
	 */
	public EAttributeCellEditHandler(EAttribute attribute, EditingDomain editingDomain) {
		this.attribute = attribute;
		this.editingDomain = editingDomain;
	}

	@Override
	public boolean canEdit(Cell<?> cell) {
		Object item = cell.getItem();
		return item instanceof EObject && ((EObject) item).eClass().getEAllAttributes().contains(this.attribute);
	}

	@Override
	public void startEdit(final Cell<?> cell) {
		EObject item = (EObject) cell.getItem();
		String string = EcoreUtil.convertToString(this.attribute.getEAttributeType(), item.eGet(this.attribute));
		this.textField = new TextField();
		this.textField.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue.booleanValue())
					commitEdit(cell, EAttributeCellEditHandler.this.textField.getText());
			}

		});
		cell.setText(null);
		cell.setGraphic(this.textField);
		this.textField.setText(string);
		// textField.requestFocus();
		this.textField.selectPositionCaret(0);// selectAll();
	}

	@Override
	public void cancelEdit(Cell<?> treeCell) {
		// do nothing
	}

	@Override
	public void commitEdit(Cell<?> treeCell, Object newValue) {
		Object item = treeCell.getItem();
		Object value = EcoreUtil.createFromString(this.attribute.getEAttributeType(), (String) newValue);
		Command command = SetCommand.create(this.editingDomain, item, this.attribute, value);
		if (command.canExecute())
			this.editingDomain.getCommandStack().execute(command);
	}

}