package org.eclipse.fx.text.ui.contentassist;

import org.eclipse.jface.text.IDocument;

public class ContentAssistContextData {
	public final int offset;
	public final IDocument document;
//	public final String prefix;

	public ContentAssistContextData(int offset, IDocument document/*, String prefix*/) {
		this.offset = offset;
		this.document = document;
//		this.prefix = prefix;
	}
}
