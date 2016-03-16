package org.eclipse.fx.code.editor;

import org.eclipse.jface.text.IRegion;

public class SourceSelection {
	public final String uri;
	public final IRegion selection;

	public SourceSelection(String uri, IRegion selection) {
		this.uri = uri;
		this.selection = selection;
	}

}
