package org.eclipse.fx.text.hover;

import org.eclipse.jface.text.IRegion;

public class HTMLHoverInfo extends HoverInfo {

	public HTMLHoverInfo(HoverInfoType type, IRegion region, CharSequence html, Object hoverModel) {
		super(type, region, html, hoverModel);
	}

}
