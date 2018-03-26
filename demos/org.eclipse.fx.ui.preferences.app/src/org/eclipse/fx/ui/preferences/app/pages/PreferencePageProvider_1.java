package org.eclipse.fx.ui.preferences.app.pages;

import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.ui.preferences.PreferencePage;
import org.eclipse.fx.ui.preferences.PreferencePageProvider;
import org.eclipse.fx.ui.preferences.page.BooleanFieldEditor;
import org.eclipse.fx.ui.preferences.page.ColorFieldEditor;
import org.eclipse.fx.ui.preferences.page.DirectoryFieldEditor;
import org.eclipse.fx.ui.preferences.page.FieldEditorPreferencePage;
import org.eclipse.fx.ui.preferences.page.IntegerFieldEditor;
import org.eclipse.fx.ui.preferences.page.TextFieldEditor;
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
		
		@Override
		protected void createFieldEditors() {
			addField(new BooleanFieldEditor("booleanProperty", "Boolean Property"));
			addField(new IntegerFieldEditor("integerProperty", "Integer Property"));
			addField(new ColorFieldEditor("colorProperty", "Color Property"));
			addField(new DirectoryFieldEditor("directoryProperty", "Directory Property"));
			addField(new TextFieldEditor("textProperty", "Text"));
		}
	}
}