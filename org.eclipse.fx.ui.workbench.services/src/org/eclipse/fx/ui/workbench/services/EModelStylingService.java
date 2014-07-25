package org.eclipse.fx.ui.workbench.services;

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

public interface EModelStylingService {
	public void addModelTag(MUIElement element, String... tags);
	public void removeModelTag(MUIElement element, String... tags);
	public List<String> getModelTags(MUIElement element);
}
