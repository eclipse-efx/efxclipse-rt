package org.eclipse.fx.text.ui;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

public interface IFeature {

	/** installs the feature into the control.
	 * <p>
	 * by disposing the returned subscription, the feature gets uninstalled
	 * </p>
	 *
	 * @param control
	 * @return
	 */
	public Subscription install(StyledTextArea control);


}
