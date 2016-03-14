package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonCompositeConditionImpl implements GsonBase, CompositeCondition, Condition {
	public GsonCompositeConditionImpl(JsonObject jsonObject) {
		this.and = jsonObject.has("and") ? jsonObject.get("and").getAsBoolean() : false;
		this.elementList = jsonObject.has("elementList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("elementList").spliterator(), false )
								.map( e -> GsonElementFactory.createCompositeConditionElement(e.getAsJsonObject())).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
		this.primary = jsonObject.has("primary") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("primary")) : null;
	}
	public GsonCompositeConditionImpl(boolean and, java.util.List<CompositeConditionElement> elementList, String name, Condition primary) {
		this.and = and;
		this.elementList = elementList;
		this.name = name;
		this.primary = primary;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "CompositeCondition" );
		o.addProperty( "and", isAnd() );
		o.add( "elementList", GsonBase.toDomainJsonArray(getElementList()) );
		o.addProperty( "name", getName() );
		o.add( "primary", getPrimary() == null ? null : ((GsonBase)getPrimary()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "and : " + and + ", "
					 + "elementList : " + elementList.stream().map( e -> e.getClass().getSimpleName() + "@" + Integer.toHexString(e.hashCode()) ).collect(java.util.stream.Collectors.toList()) + ", "
					 + "name : " + name + ", "
					 + "primary : " + (primary == null ? null : primary.getClass().getSimpleName() + "@" + Integer.toHexString(primary.hashCode()))
					+" }";
	}

	private final boolean and;
	public boolean isAnd() {
		return this.and;
	}
	

	private final java.util.List<CompositeConditionElement> elementList;
	public java.util.List<CompositeConditionElement> getElementList() {
		return this.elementList;
	}
	

	private final String name;
	public String getName() {
		return this.name;
	}
	

	private final Condition primary;
	public Condition getPrimary() {
		return this.primary;
	}
	


	public static class Builder implements CompositeCondition.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private boolean and;
		public Builder and(boolean and) {
			this.and = and;
			return this;
		}
		private final java.util.List<CompositeConditionElement> elementList = new java.util.ArrayList<>();
		public Builder elementList(java.util.List<CompositeConditionElement> elementList) {
			this.elementList.addAll(elementList);
			return this;
		}
		public Builder appendElementList(CompositeConditionElement elementList) {
			this.elementList.add(elementList);
			return this;
		}
		public Builder elementList(java.util.function.Function<EditorGModel,java.util.List<CompositeConditionElement>> provider) {
			elementList( provider.apply( instance ) );
			return this;
		}

		public Builder appendElementList(java.util.function.Function<CompositeConditionElement.Builder,CompositeConditionElement> provider) {
			appendElementList( provider.apply( new GsonCompositeConditionElementImpl.Builder(instance) ) );
			return this;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		private Condition primary;
		public Builder primary(Condition primary) {
			this.primary = primary;
			return this;
		}

		public CompositeCondition build() {
			return new GsonCompositeConditionImpl(and, elementList, name, primary);
		}
	}
}
