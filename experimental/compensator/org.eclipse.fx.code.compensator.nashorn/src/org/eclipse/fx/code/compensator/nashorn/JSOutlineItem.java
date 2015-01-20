package org.eclipse.fx.code.compensator.nashorn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;

public class JSOutlineItem implements OutlineItem {
	private final CharSequence name;
	private final ObservableList<OutlineItem> list = FXCollections
			.observableArrayList();

	public JSOutlineItem(CharSequence name, String type) {
		this.name = name;
	}

	@Override
	public CharSequence getLabel() {
		return name;
	}

	@Override
	public ObservableList<OutlineItem> getChildren() {
		return list;
	}

	@Override
	public Node getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}
}