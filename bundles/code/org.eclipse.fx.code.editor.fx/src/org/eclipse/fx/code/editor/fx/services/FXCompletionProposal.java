package org.eclipse.fx.code.editor.fx.services;

import java.util.function.Supplier;

import org.eclipse.fx.code.editor.services.CompletionProposal;
import org.eclipse.fx.text.ui.contentassist.ICompletionProposal;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.IDocument;

import javafx.scene.Node;

@SuppressWarnings("restriction")
public class FXCompletionProposal implements ICompletionProposal {
	private final CompletionProposal proposal;
	private final Supplier<Node> graphicSupplier;
	private final CharSequence label;

	public FXCompletionProposal(CompletionProposal proposal, Supplier<Node> graphicSupplier) {
		this(proposal,proposal.getLabel(),graphicSupplier);
	}

	public FXCompletionProposal(CompletionProposal proposal, CharSequence label, Supplier<Node> graphicSupplier) {
		this.proposal = proposal;
		this.label = label;
		this.graphicSupplier = graphicSupplier;
	}

	@Override
	public Node getGraphic() {
		return graphicSupplier.get();
	}

	@Override
	public CharSequence getLabel() {
		return label;
	}

	@Override
	public void apply(IDocument document) {
		proposal.apply(document);
	}

	@Override
	public TextSelection getSelection(IDocument document) {
		org.eclipse.fx.code.editor.services.CompletionProposal.TextSelection selection = proposal.getSelection(document);
		return new TextSelection(selection.offset, selection.length);
	}
}
