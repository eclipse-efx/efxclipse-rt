package org.eclipse.jface.text;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

public interface ITextViewer {
	public IDocument getDocument();
	public void setDocument(IDocument document);
	void setDocument(IDocument document, int modelRangeOffset, int modelRangeLength);
	public IRegion getVisibleRegion();
	void addTextListener(ITextListener listener);
	public void removeTextListener(ITextListener listener);
	void addTextInputListener(ITextInputListener listener);
	void removeTextInputListener(ITextInputListener listener);
	void changeTextPresentation(TextPresentation presentation, boolean controlRedraw);
	StyledTextArea getTextWidget();
	public boolean overlapsWithVisibleRegion(int start, int length);
	public void invalidateTextPresentation();

}
