package org.eclipse.fx.emf.edit.ui;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;

/**
 * A cell value factory that simply forwards {@link CellDataFeatures#getValue()} as an {@link ObservableValue}
 * .
 */
public class TreeTableProxyCellValueFactory implements Callback<TreeTableColumn.CellDataFeatures<Object, Object>, ObservableValue<Object>> {

	@Override
	public ObservableValue<Object> call(final CellDataFeatures<Object, Object> features) {

		return new ObservableValueBase<Object>() {

			@Override
			public Object getValue() {
				TreeItem<Object> value = features.getValue();
				return value.getValue();
			}

		};

	}

}