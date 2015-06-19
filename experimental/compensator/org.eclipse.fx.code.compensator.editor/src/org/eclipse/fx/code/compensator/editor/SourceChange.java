package org.eclipse.fx.code.compensator.editor;

public class SourceChange {
	public final Input<?> input;
	public final int offset;
	public final int length;
	public final String replacement;
	
	public SourceChange(Input<?> input, int offset, int length, String replacement) {
		this.input = input;
		this.offset = offset;
		this.length = length;
		this.replacement = replacement;
	}
}
