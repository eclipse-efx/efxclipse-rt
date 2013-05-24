package org.eclipse.fx.demo.media.model;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Media {
	private ReadOnlyObjectProperty<MediaType> type;
	private SimpleStringProperty name = new SimpleStringProperty(this, "name");
	private SimpleStringProperty url = new SimpleStringProperty(this, "url");
	
	public Media(MediaType type) {
		this.type = new SimpleObjectProperty<MediaType>(this, "type", type);
	}
	
	public Media(MediaType type, String name, String url) {
		this(type);
		this.name.set(name);
		this.url.set(url);
	}
	
	public MediaType getType() {
		return this.type.get();
	}
	
	public ReadOnlyObjectProperty<MediaType> type() {
		return type;
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getName() {
		return this.name.get();
	}
	
	public StringProperty name() {
		return this.name;
	}
	
	public void setUrl(String url) {
		this.url.set(url);
	}
	
	public String getUrl() {
		return this.url.get();
	}
	
	public StringProperty url() {
		return this.url;
	}
	
	public static final String serialize(Media media) {
		return media.type.getValue().name() + "##_##" + media.name.getValue() + "##_##" + media.url.getValue();
	}
	
	public static final Media deserialize(String serializedObject) {
		String[] parts = serializedObject.split("##_##");
		Media m = new Media(MediaType.valueOf(parts[0]));
		m.setName(parts[1]);
		m.setUrl(parts[2]);
		return m;
	}
}
