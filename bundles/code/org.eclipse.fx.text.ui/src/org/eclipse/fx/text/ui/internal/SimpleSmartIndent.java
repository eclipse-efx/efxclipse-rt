package org.eclipse.fx.text.ui.internal;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.text.DefaultTextEditActions;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.fx.text.ui.TextViewer;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping.Context;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class SimpleSmartIndent {

	private TextViewer viewer;

	Subscription subscription;

	public SimpleSmartIndent(TextViewer viewer) {
		this.viewer = viewer;
		this.subscription = viewer.subscribeAction(this::handle);
	}

	public void dispose() {
		this.subscription.dispose();
	}

	private int findIndentAt(int index) {
		String beforeEnter = this.viewer.getDocument().get().substring(0, index);

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

	private boolean handle(TextEditAction action, Context context) {

		if (action == DefaultTextEditActions.NEW_LINE) {
			try {
				IDocument doc = this.viewer.getDocument();
				int caret = this.viewer.getTextWidget().getCaretOffset();

				int count = findIndentAt(caret);

				String tabString = "\t";
				if( this.viewer.getTextWidget().isInsertSpacesForTab() ) {
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



				this.viewer.getDocument().replace(replaceAt, replaceLen, replace);
				this.viewer.getTextWidget().setCaretOffset(caret - replaceLen + replace.length());
				return true;


			}
			catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
