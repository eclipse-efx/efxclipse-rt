package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonLanguageDefImpl implements GsonBase, LanguageDef {
	public GsonLanguageDefImpl(JsonObject jsonObject) {
		this.fileSuffix = jsonObject.has("fileSuffix") ? jsonObject.get("fileSuffix").getAsString() : null;
		this.partitionList = jsonObject.has("partitionList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("partitionList").spliterator(), false )
								.map( e -> GsonElementFactory.createPartition(e.getAsJsonObject())).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
	}
	public GsonLanguageDefImpl(String fileSuffix, java.util.List<Partition> partitionList) {
		this.fileSuffix = fileSuffix;
		this.partitionList = partitionList;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "LanguageDef" );
		o.addProperty( "fileSuffix", getFileSuffix() );
		o.add( "partitionList", GsonBase.toDomainJsonArray(getPartitionList()) );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "fileSuffix : " + fileSuffix + ", "
					 + "partitionList : " + partitionList.stream().map( e -> e.getClass().getSimpleName() + "@" + Integer.toHexString(e.hashCode()) ).collect(java.util.stream.Collectors.toList())
					+" }";
	}

	private final String fileSuffix;
	public String getFileSuffix() {
		return this.fileSuffix;
	}
	

	private final java.util.List<Partition> partitionList;
	public java.util.List<Partition> getPartitionList() {
		return this.partitionList;
	}
	


	public static class Builder implements LanguageDef.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private String fileSuffix;
		public Builder fileSuffix(String fileSuffix) {
			this.fileSuffix = fileSuffix;
			return this;
		}
		private final java.util.List<Partition> partitionList = new java.util.ArrayList<>();
		public Builder partitionList(java.util.List<Partition> partitionList) {
			this.partitionList.addAll(partitionList);
			return this;
		}
		public Builder appendPartitionList(Partition partitionList) {
			this.partitionList.add(partitionList);
			return this;
		}
		public Builder partitionList(java.util.function.Function<EditorGModel,java.util.List<Partition>> provider) {
			partitionList( provider.apply( instance ) );
			return this;
		}

		public Builder appendPartitionList(java.util.function.Function<Partition.Builder,Partition> provider) {
			appendPartitionList( provider.apply( new GsonPartitionImpl.Builder(instance) ) );
			return this;
		}

		public LanguageDef build() {
			return new GsonLanguageDefImpl(fileSuffix, partitionList);
		}
	}
}
