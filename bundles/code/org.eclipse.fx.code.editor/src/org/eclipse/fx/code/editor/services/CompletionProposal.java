package org.eclipse.fx.code.editor.services;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public interface CompletionProposal {
	public static final class TextSelection {
		public final int offset;
		public final int length;

		public TextSelection(int offset, int length) {
			this.offset = offset;
			this.length = length;
		}
	}

	public CharSequence getLabel();
	public void apply(IDocument document);
	public TextSelection getSelection(IDocument document);

	public ContextInformation getContextInformation();

	public static class BaseCompletetionProposal implements CompletionProposal {

		private final CharSequence label;

		private final String replacementString;
		private final int replacementOffset;
		private final int replacementLength;
		private final int cursorPosition;
		private final ContextInformation contextInformation;

		public BaseCompletetionProposal(String replacementString, int replacementOffset, int replacementLength, CharSequence label, ContextInformation contextInformation) {
			this.replacementString = replacementString;
			this.replacementOffset = replacementOffset;
			this.replacementLength = replacementLength;
			this.cursorPosition = replacementString.length();
			this.label = label;
			this.contextInformation = contextInformation;
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

		@Override
		public ContextInformation getContextInformation() {
			return contextInformation;
		}
	}

}
