package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.jdt.annotation.NonNull;

public interface WDialog {
	/**
	 * Append a child widget shown in the center
	 * 
	 * @param widget
	 *            the widget
	 */
	public void addChild(@NonNull WLayoutedWidget<MWindowElement> widget);

	/**
	 * Insert a child widget at the given index
	 * 
	 * @param idx
	 *            the index
	 * @param widget
	 *            the widget
	 */
	public void addChild(int idx, @NonNull WLayoutedWidget<MWindowElement> widget);

	/**
	 * Remove a child widget
	 * 
	 * @param widget
	 *            the widget
	 */
	public void removeChild(@NonNull WLayoutedWidget<MWindowElement> widget);
	
	public void open();
}
