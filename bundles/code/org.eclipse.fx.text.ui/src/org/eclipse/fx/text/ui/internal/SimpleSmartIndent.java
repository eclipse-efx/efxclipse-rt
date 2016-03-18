package org.eclipse.fx.text.ui.internal;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.text.ui.TextViewer;
import org.eclipse.fx.ui.controls.styledtext.ActionEvent;
import org.eclipse.fx.ui.controls.styledtext.ActionEvent.ActionType;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class SimpleSmartIndent {

	private TextViewer viewer;

	public SimpleSmartIndent(TextViewer viewer) {
		this.viewer = viewer;
		this.viewer.getTextWidget().addEventHandler(ActionEvent.ACTION, this::handle);
	}

	public void dispose() {
		this.viewer.getTextWidget().removeEventHandler(ActionEvent.ACTION, this::handle);
	}

	private int findIndentAt(int index) {
		String beforeEnter = viewer.getDocument().get().substring(0, index);

		int count = 0;
		for (int idx = 0; idx < beforeEnter.length(); idx++) {
			char curChar = beforeEnter.charAt(idx);
			if (curChar == '{') {
				count ++;
			}
			if (curChar == '}') {
				count --;
			}
		}

		return Math.max(0, count);
	}

	private void handle(ActionEvent event) {

		if (event.type == ActionType.NEW_LINE) {
			try {
				IDocument doc = viewer.getDocument();
				int caret = viewer.getTextWidget().getCaretOffset();

				int count = findIndentAt(caret);

				String tabString = "\t";
				if( viewer.getTextWidget().isInsertSpacesForTab() ) {
					tabString = Util.createRepeatedString(' ', viewer.getTextWidget().getTabAdvance());
				}

				int replaceAt = caret;
				int replaceLen = 0;
				String replace = "\n";
				for (int i = 0; i < count; i++) {
					replace += tabString;
				}


				// endfix
				int indent = findIndentAt(caret);
				int lineBegin = doc.getLineInformationOfOffset(caret).getOffset();
				String before = doc.get().substring(lineBegin, caret);
				if (before.matches("^\\s*}")) {
					String tabs = "";
					for (int i = 0; i < indent; i++) {
						tabs += tabString;
					}
					replaceAt = lineBegin;
					replaceLen = before.length();
					replace = tabs + '}' + replace;
				}



				viewer.getDocument().replace(replaceAt, replaceLen, replace);
				viewer.getTextWidget().setCaretOffset(caret - replaceLen + replace.length());
				event.consume();


			}
			catch (BadLocationException e) {
				e.printStackTrace();
			}
		}

	}

}
