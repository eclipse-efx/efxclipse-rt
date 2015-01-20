package org.eclipse.fx.code.compensator.nashorn;

import java.util.function.Supplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;

public class JSOutlineItem implements OutlineItem {
	private final CharSequence name;
	private final ObservableList<OutlineItem> list = FXCollections
			.observableArrayList();

	private final Supplier<Node> graphicSupplier;

	public JSOutlineItem(CharSequence name, Supplier<Node> graphicSupplier) {
		this.name = name;
		this.graphicSupplier = graphicSupplier;
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
		return graphicSupplier != null ? graphicSupplier.get() : null;
	}
}