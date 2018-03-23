package org.eclipse.fx.ui.preferences;

import javafx.scene.layout.BorderPane;

public interface PreferencePageFactory {
	public PreferencePage make(BorderPane parent, PreferencePageProvider provider);
}
