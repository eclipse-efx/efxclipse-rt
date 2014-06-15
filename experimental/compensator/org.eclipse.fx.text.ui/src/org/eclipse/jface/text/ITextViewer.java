package org.eclipse.jface.text;

public interface ITextViewer {
	public IDocument getDocument();
	public void setDocument(IDocument document);
	public IRegion getVisibleRegion();
	void addTextListener(ITextListener listener);
	public void removeTextListener(ITextListener listener);
	void addTextInputListener(ITextInputListener listener);
	void removeTextInputListener(ITextInputListener listener);
	void changeTextPresentation(TextPresentation presentation, boolean controlRedraw);
}
