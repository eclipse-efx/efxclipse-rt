package org.eclipse.jface.text.source;

import org.eclipse.jface.text.ITextViewer;

public interface ISourceViewer extends ITextViewer {
	void configure(SourceViewerConfiguration configuration);
}
