package org.eclipse.fx.code.editor.fx.services;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.fx.code.editor.services.CompletionProposal;
import org.eclipse.fx.text.ui.contentassist.ICompletionProposal;
import org.eclipse.fx.text.ui.contentassist.IContextInformation;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.IDocument;

import javafx.scene.Node;

@SuppressWarnings("restriction")
public class FXCompletionProposal<T extends CompletionProposal> implements ICompletionProposal {
	private final T proposal;

	private Node graphicNode;
	private Function<T, Node> graphicComputer;

	private final Function<T, CharSequence> labelComputer;
	private CharSequence label;

	private CharSequence fHoverInfo;
	private final Function<T, CharSequence> hoverInfoComputer;

	private final IContextInformation fContextInformation;

	public FXCompletionProposal(T proposal, Supplier<Node> graphicSupplier, IContextInformation contextInformation, CharSequence hoverInfo) {
		this(proposal, proposal.getLabel(), graphicSupplier, contextInformation, hoverInfo);
	}

	public FXCompletionProposal(T proposal, CharSequence label, Supplier<Node> graphicSupplier, IContextInformation contextInformation, CharSequence hoverInfo) {
		this(proposal, p -> label, p -> graphicSupplier.get(), contextInformation, p -> hoverInfo);
	}

	public FXCompletionProposal(T proposal, Function<T, CharSequence> labelComputer, Function<T, Node> graphicComputer, IContextInformation contextInformation, Function<T,CharSequence> hoverInfoComputer) {
		this.proposal = proposal;

		this.label = null;
		this.labelComputer = labelComputer;

		this.graphicNode = null;
		this.graphicComputer = graphicComputer;

		this.fContextInformation = contextInformation;

		this.fHoverInfo = null;
		this.hoverInfoComputer = hoverInfoComputer;
	}

	@Override
	public Node getGraphic() {
		if( graphicNode == null ) {
			graphicNode = graphicComputer.apply(this.proposal);
		}
		return graphicNode;
	}

	@Override
	public CharSequence getLabel() {
		if( label == null ) {
			label = labelComputer.apply(this.proposal);
		}
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
	public CharSequence getHoverInfo() {
		if( this.fHoverInfo == null ) {
			this.fHoverInfo = hoverInfoComputer.apply(this.proposal);
		}
		return this.fHoverInfo;
	}
}
