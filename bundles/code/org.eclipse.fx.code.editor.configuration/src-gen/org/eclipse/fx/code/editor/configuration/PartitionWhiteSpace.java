package org.eclipse.fx.code.editor.configuration;

public interface PartitionWhiteSpace extends EditorBase {
	public boolean isJavawhiteSpace();
	public java.util.List<String> getCharacterList();

	public interface Builder {
		public Builder javawhiteSpace(boolean javawhiteSpace);
		public Builder characterList(java.util.List<String> characterList);
		public Builder appendCharacterList(String characterList);
		public PartitionWhiteSpace build();
	}
}
