package org.eclipse.fx.code.compensator.nashorn;

import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.editor.Outline;

public class JSOutline implements Outline {
	private OutlineItem i;

	public JSOutline(OutlineItem i) {
		this.i = i;
	}

	@Override
	public ObservableList<OutlineItem> getRootItems() {
		return i.getChildren();
	}

}