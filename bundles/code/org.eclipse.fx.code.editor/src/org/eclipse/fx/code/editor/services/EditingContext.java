package org.eclipse.fx.code.editor.services;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

public class EditingContext {

	public static interface IEditor {
		int getCaret();
		void setCaret(int loc);
		void setCaret(int loc, boolean keepSelection);
		IRegion getSelection();
		void setSelection(IRegion selection);
	}

	public final Input<?> input;
	public final IDocument document;
	public final int location;
	public final IEditor editor;

	public EditingContext(Input<?> input, IDocument document, int location, IEditor editor) {
		this.input = input;
		this.document = document;
		this.location = location;
		this.editor = editor;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [input=" + input + ", document=" + document + ", location=" + location + "]";
	}
}
