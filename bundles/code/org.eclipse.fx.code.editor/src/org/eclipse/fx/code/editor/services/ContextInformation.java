package org.eclipse.fx.code.editor.services;

public interface ContextInformation {

	public CharSequence getText();
	public int getOffset();

	public static class BaseContextInformation implements ContextInformation {

		private final CharSequence label;

		private final int offset;

		public BaseContextInformation(int offset, CharSequence label) {
			this.offset = offset;
			this.label = label;
		}

		@Override
		public CharSequence getText() {
			return label;
		}

		@Override
		public int getOffset() {
			return offset;
		}

	}



}
