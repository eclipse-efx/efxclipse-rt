package org.eclipse.fx.ui.preferences.app.pages;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.ui.preferences.PreferencePage;
import org.eclipse.fx.ui.preferences.PreferencePageProvider;
import org.eclipse.fx.ui.preferences.page.FieldEditorPreferencePage;
import org.osgi.service.component.annotations.Component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;

@Component
public class PreferencePageProvider_1 implements PreferencePageProvider {
	private ObjectProperty<CharSequence> title = new SimpleObjectProperty<>(this, "title", "Page 1");

	@Override
	public boolean select(CharSequence term) {
		return true;
	}

	@Override
	public ObservableValue<CharSequence> titleProperty() {
		return title;
	}

	@Override
	public String id() {
		return "Page_1";
	}

	@Override
	public Class<? extends PreferencePage> pageType() {
		return Page1.class;
	}

	@Override
	public Optional<String> parentId() {
		return Optional.empty();
	}

	static class Page1 extends FieldEditorPreferencePage {
		@Inject
		public Page1(Memento memento, BorderPane parent) {
			super(memento, parent);
		}
		
		@PostConstruct
		void init() {
			System.err.println("CREATED");
		}
	}
}