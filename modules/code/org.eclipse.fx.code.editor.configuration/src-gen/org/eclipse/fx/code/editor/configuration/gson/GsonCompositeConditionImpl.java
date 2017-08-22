package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonCompositeConditionImpl implements GsonBase, CompositeCondition, Condition {
	public GsonCompositeConditionImpl(JsonObject jsonObject) {
		this.and = jsonObject.has("and") ? jsonObject.get("and").getAsBoolean() : false;
		this.elementList = jsonObject.has("elementList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("elementList").spliterator(), false )
								.map( e -> GsonElementFactory.createCondition(e.getAsJsonObject())).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
	}
	public GsonCompositeConditionImpl(boolean and, java.util.List<Condition> elementList, String name) {
		this.and = and;
		this.elementList = elementList;
		this.name = name;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "CompositeCondition" );
		o.addProperty( "and", isAnd() );
		o.add( "elementList", GsonBase.toDomainJsonArray(getElementList()) );
		o.addProperty( "name", getName() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "and : " + and + ", "
					 + "elementList : " + elementList.stream().map( e -> e.getClass().getSimpleName() + "@" + Integer.toHexString(e.hashCode()) ).collect(java.util.stream.Collectors.toList()) + ", "
					 + "name : " + name
					+" }";
	}

	private final boolean and;
	public boolean isAnd() {
		return this.and;
	}
	

	private final java.util.List<Condition> elementList;
	public java.util.List<Condition> getElementList() {
		return this.elementList;
	}
	

	private final String name;
	public String getName() {
		return this.name;
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
		private final java.util.List<Condition> elementList = new java.util.ArrayList<>();
		public Builder elementList(java.util.List<Condition> elementList) {
			this.elementList.addAll(elementList);
			return this;
		}
		public Builder appendElementList(Condition elementList) {
			this.elementList.add(elementList);
			return this;
		}
		public Builder elementList(java.util.function.Function<EditorGModel,java.util.List<Condition>> provider) {
			elementList( provider.apply( instance ) );
			return this;
		}

		public Builder appendElementList(java.util.function.Function<Condition.Builder,Condition> provider) {
			appendElementList( provider.apply( new GsonConditionImpl.Builder(instance) ) );
			return this;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public CompositeCondition build() {
			return new GsonCompositeConditionImpl(and, elementList, name);
		}
	}
}
