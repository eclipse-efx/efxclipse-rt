package org.eclipse.fx.code.editor.configuration;

public interface Range extends EditorBase, Check {
	public int getMin();
	public boolean isMinIncl();
	public int getMax();
	public boolean isMaxIncl();

	public interface Builder {
		public Builder min(int min);
		public Builder minIncl(boolean minIncl);
		public Builder max(int max);
		public Builder maxIncl(boolean maxIncl);
		public Range build();
	}
}
