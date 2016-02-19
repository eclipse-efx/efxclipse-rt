package org.eclipse.fx.code.editor.fx.services;

import java.util.function.Supplier;

import org.eclipse.fx.code.editor.services.CompletionProposal;
import org.eclipse.fx.text.ui.contentassist.ICompletionProposal;
import org.eclipse.fx.text.ui.contentassist.IContextInformation;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.IDocument;

import javafx.scene.Node;

@SuppressWarnings("restriction")
public class FXCompletionProposal implements ICompletionProposal {
	private final CompletionProposal proposal;
	private final Supplier<Node> graphicSupplier;
	private final CharSequence label;
	private final String fHoverInfo;

	private final IContextInformation fContextInformation;

	public FXCompletionProposal(CompletionProposal proposal, Supplier<Node> graphicSupplier, IContextInformation contextInformation, String hoverInfo) {
		this(proposal, proposal.getLabel(), graphicSupplier, contextInformation, hoverInfo);
	}

	public FXCompletionProposal(CompletionProposal proposal, CharSequence label, Supplier<Node> graphicSupplier, IContextInformation contextInformation, String hoverInfo) {
		this.proposal = proposal;
		this.label = label;
		this.graphicSupplier = graphicSupplier;
		this.fContextInformation = contextInformation;
		this.fHoverInfo = hoverInfo;
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

	@Override
	public IContextInformation getContextInformation() {
		return fContextInformation;
	}

	@Override
	public String getHoverInfo() {
		return this.fHoverInfo;
	}
}
