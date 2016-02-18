package org.eclipse.fx.code.editor.fx.services;

import org.eclipse.fx.code.editor.services.ContextInformation;
import org.eclipse.fx.text.ui.contentassist.IContextInformation;


public interface ContextInformationPresenter {
	public IContextInformation createInformation(ContextInformation information);
}
