package org.eclipse.jface.text.source;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;

public interface ISourceViewer extends ITextViewer {
	void configure(SourceViewerConfiguration configuration);
	void setDocument(IDocument document, IAnnotationModel annotationModel);
	public void setDocument(IDocument document, IAnnotationModel annotationModel, int modelRangeOffset, int modelRangeLength);
	IAnnotationModel getAnnotationModel();
}
