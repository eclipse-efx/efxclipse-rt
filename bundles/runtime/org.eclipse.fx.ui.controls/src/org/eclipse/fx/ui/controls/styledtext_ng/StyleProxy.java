package org.eclipse.fx.ui.controls.styledtext_ng;

import org.eclipse.fx.core.Range;
import org.eclipse.fx.core.Subscription;

public interface StyleProxy {
	public Subscription addRange(StyledLineRenderer renderer, Range range);
}
