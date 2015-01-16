package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.fx.code.compensator.editor.ProposalComputer.ProposalContext;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.ProposalComputerFactory;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Type;
import org.eclipse.fx.code.server.jdt.shared.JavaCodeCompleteProposal.Visibility;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.jface.text.contentassist.CompletetionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class JDTProposalComputerFactory implements ProposalComputerFactory {

	@Override
	public boolean applies(Input<?> input) {
		return input instanceof JDTServerInput;
	}

	@Override
	public ProposalComputer createProposalComputer() {
		return new ProposalComputer() {

			@Override
			public Future<List<ICompletionProposal>> compute(ProposalContext context) {
				try {
					JDTServerInput i = (JDTServerInput) context.input;
					Future<List<org.eclipse.fx.code.server.jdt.shared.Proposal>> proposals = i.server.getProposals(i.openFile.get(), context.location);
					System.err.println("GOING TO TRANSFORM: " + proposals.get());
					return CompletableFuture.supplyAsync(() -> {
						try {
							return proposals.get().stream().map((p) -> createProposal(context,p)).collect(Collectors.toList());
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					});
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return CompletableFuture.supplyAsync(() -> Collections.emptyList());
			}
		};
	}

	static ICompletionProposal createProposal(ProposalContext context, org.eclipse.fx.code.server.jdt.shared.Proposal proposal) {
		JavaCodeCompleteProposal cp = (JavaCodeCompleteProposal) proposal;
		StyledString s = new StyledString();
		s.appendSegment(cp.getLabel(), "java-element-name");
		if( cp.getAdditionalLabel() != null ) {
			s.appendSegment(cp.getAdditionalLabel(), "java-type-info");
		}

		List<String> styles = new ArrayList<>();

		if( cp.getType() == Type.CLASS ) {
			styles.add("java-class-"+visibilityAddon(cp.getVisibility()));
		} else if( cp.getType() == Type.METHOD ) {
			styles.add("java-method-"+visibilityAddon(cp.getVisibility()));
		} else if( cp.getType() == Type.FIELD ) {
			styles.add("java-field-"+visibilityAddon(cp.getVisibility()));
		}

		return new CompletetionProposal(cp.getValue(), cp.getReplacementOffset(), cp.getReplacementLength(),s, () -> null);
	}

	private static String visibilityAddon(Visibility v) {
		switch (v) {
		case PACKAGE_PRIVATE:
			return "default";
		case PRIVATE:
			return "private";
		case PROTECTED:
			return "protected";
		default:
			return "public";
		}
	}
}
