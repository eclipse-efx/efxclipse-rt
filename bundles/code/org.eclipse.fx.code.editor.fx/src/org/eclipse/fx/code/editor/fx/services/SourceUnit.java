package org.eclipse.fx.code.editor.fx.services;

import org.eclipse.jface.text.source.AnnotationModel;

public interface SourceUnit {
	public Outline getOutline();
	public AnnotationModel getAnnotationModel();
	public ProposalComputer getProposalComputer();
}
