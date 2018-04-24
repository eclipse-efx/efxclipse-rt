package org.eclipse.fx.ui.preferences.app.pages;

import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.MementoStore;
import org.eclipse.fx.ui.preferences.PreferencePage;
import org.eclipse.fx.ui.preferences.PreferencePageProvider;
import org.eclipse.fx.ui.preferences.page.BooleanFieldEditor;
import org.eclipse.fx.ui.preferences.page.ColorFieldEditor;
import org.eclipse.fx.ui.preferences.page.DirectoryFieldEditor;
import org.eclipse.fx.ui.preferences.page.FieldEditorPreferencePage;
import org.eclipse.fx.ui.preferences.page.FileFieldEditor;
import org.eclipse.fx.ui.preferences.page.FloatFieldEditor;
import org.eclipse.fx.ui.preferences.page.IntegerFieldEditor;
import org.eclipse.fx.ui.preferences.page.RadioGroupFieldEditor;
import org.eclipse.fx.ui.preferences.page.StringFieldEditor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;

@Component
public class PreferencePageProvider_1 implements PreferencePageProvider {
	private ObjectProperty<CharSequence> title = new SimpleObjectProperty<>(this, "title", "Page 1");
	private MementoStore mementoStore;
	
	@Reference
	public void setMementoStore(MementoStore mementoStore) {
		this.mementoStore = mementoStore;
		initDefaultPreferences();
	}

	private void initDefaultPreferences() {
		// Initialize some default preferences... Here, we assume that the default Eclipse-based Memento will be used
		IEclipsePreferences defaultNode = DefaultScope.INSTANCE.getNode(getClass().getName());
		defaultNode.putInt("integerProperty", 12);
		defaultNode.put("colorProperty", "204,255,204");
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
	
	@Override
	public Optional<Memento> memento() {
		return Optional.of(mementoStore.getMemento(getClass().getName()));
	}

	static class Page1 extends FieldEditorPreferencePage {
		@Inject
		public Page1(Memento memento, BorderPane parent) {
			super(memento, parent);
		}
		
		@Override
		protected void createFieldEditors() {
			addField(new BooleanFieldEditor("booleanProperty", "Boolean Property"));
			IntegerFieldEditor intEditor = new IntegerFieldEditor("integerProperty", "Integer Property");
			intEditor.addValidator(intValue -> { return intValue > 20 ? "The value must be lower than 20" : null; });
			addField(intEditor);
			addField(new ColorFieldEditor("colorProperty", "Color Property"));
			addField(new DirectoryFieldEditor("directoryProperty", "Directory Property"));
			addField(new StringFieldEditor("textProperty", "Text"));
			addField(new FloatFieldEditor("floatProperty", "Float Property"));
			addField(new RadioGroupFieldEditor("radioProperty", "Radio Property", 3, new String[][] {
				{"Radio value 1", "value1"},
				{"Radio value 2", "value2"},
				{"Radio value 3", "value3"},
				{"Radio value 4", "value4"},
				{"Radio value 5", "value5"},
				{"Radio value 6", "value6"},
				{"Radio value 7", "value7"},
			}));
			FileFieldEditor editor = new FileFieldEditor("fileProperty", "File Property");
			editor.setExtensionFilters("*.txt", "*.png");
			addField(editor);
		}
	}
}