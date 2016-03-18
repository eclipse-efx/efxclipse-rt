package org.eclipse.fx.code.editor.configuration;

public interface LanguageDef extends EditorBase {
	public String getFileSuffix();
	public java.util.List<Partition> getPartitionList();

	public interface Builder {
		public Builder fileSuffix(String fileSuffix);
		public Builder partitionList(java.util.List<Partition> partitionList);
		public Builder appendPartitionList(Partition partitionList);
		public Builder partitionList(java.util.function.Function<EditorGModel,java.util.List<Partition>> provider);
		public Builder appendPartitionList(java.util.function.Function<Partition.Builder,Partition> provider);
		public LanguageDef build();
	}
}
