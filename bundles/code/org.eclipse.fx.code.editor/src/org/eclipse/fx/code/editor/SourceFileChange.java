package org.eclipse.fx.code.editor;

public class SourceFileChange {
	public final LocalSourceFileInput input;
	public final int offset;
	public final int length;
	public final String replacement;

	public SourceFileChange(LocalSourceFileInput input, int offset, int length, String replacement) {
		this.input = input;
		this.offset = offset;
		this.length = length;
		this.replacement = replacement;
	}
}
