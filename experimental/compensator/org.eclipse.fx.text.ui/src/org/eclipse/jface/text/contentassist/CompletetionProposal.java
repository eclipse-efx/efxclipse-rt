package org.eclipse.jface.text.contentassist;

import java.util.function.Supplier;

import javafx.scene.Node;

import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class CompletetionProposal implements ICompletionProposal {

	private final CharSequence label;

	private final String replacementString;
	private final int replacementOffset;
	private final int replacementLength;
	private final int cursorPosition;
	private final Supplier<Node> graphicSupplier;

	public CompletetionProposal(String replacementString, int replacementOffset, int replacementLength, CharSequence label, Supplier<Node> graphicSupplier) {
		this.replacementString = replacementString;
		this.replacementOffset = replacementOffset;
		this.replacementLength = replacementLength;
		this.cursorPosition = replacementString.length();
		this.label = label;
		this.graphicSupplier = graphicSupplier;
	}

	@Override
	public Node getGraphic() {
		return graphicSupplier.get();
	}

	@Override
	public CharSequence getLabel() {
		return label;
	}

	public int getReplacementOffset() {
		return replacementOffset;
	}

	public int getReplacementLength() {
		return replacementLength;
	}

	public String getReplacementString() {
		return replacementString;
	}

	public int getCursorPosition() {
		return cursorPosition;
	}

	@Override
	public void apply(IDocument document) {
		try {
			document.replace(replacementOffset, replacementLength, replacementString);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TextSelection getSelection(IDocument document) {
		return new TextSelection(replacementOffset+cursorPosition, 0);
	}
}
