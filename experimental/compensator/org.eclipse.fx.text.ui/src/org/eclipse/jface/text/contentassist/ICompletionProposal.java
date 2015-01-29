package org.eclipse.jface.text.contentassist;

import javafx.scene.Node;

import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.IDocument;

public interface ICompletionProposal {
	public CharSequence getLabel();
	public Node getGraphic();
//	public List<String> getStyles();

	public void apply(IDocument document);
	public TextSelection getSelection(IDocument document);
}
