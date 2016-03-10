package org.eclipse.fx.text.hover;

import java.util.Set;

import org.eclipse.jface.text.IDocument;

public interface DocumentHoverProvider {
	Set<HoverInfo> getHoverInfo(IDocument document, int offset);
}
