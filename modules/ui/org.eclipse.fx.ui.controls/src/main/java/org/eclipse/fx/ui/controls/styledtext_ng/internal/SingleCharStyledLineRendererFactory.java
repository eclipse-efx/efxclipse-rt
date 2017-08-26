package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import org.eclipse.fx.ui.controls.styledtext_ng.StyledLineRenderer;
import org.eclipse.fx.ui.controls.styledtext_ng.StyledLineRendererFactory;

public class SingleCharStyledLineRendererFactory implements StyledLineRendererFactory {

	@Override
	public StyledLineRenderer createRenderer() {
		return new SingleCharStyledLineRenderer();
	}

}
