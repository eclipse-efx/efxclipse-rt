package org.eclipse.fx.code.editor.fx.services.internal;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.fx.services.ProposalComputer;
import org.eclipse.fx.code.editor.fx.services.ProposalComputer.ProposalContext;
import org.eclipse.fx.core.di.Service;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.AnnotationPresenter;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class DefaultSourceViewerConfiguration extends SourceViewerConfiguration {
	private Input<?> input;
	private PresentationReconciler reconciler;
	private ProposalComputer proposalComputer;
	private IAnnotationModel annotationModel;
	private List<AnnotationPresenter> annotationPresenters;

	@Inject
	public DefaultSourceViewerConfiguration(
			Input<?> input,
			PresentationReconciler reconciler,
			@Optional ProposalComputer proposalComputer,
			@Optional IAnnotationModel annotationModel,
			@Service List<AnnotationPresenter> annotationPresenters) {
		this.input = input;
		this.reconciler = reconciler;
		this.proposalComputer = proposalComputer;
		this.annotationModel = annotationModel;
		this.annotationPresenters = annotationPresenters;
	}

	@Override
	public String getStyleclassName() {
		return "source-viewer";
	}

	public final IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		return reconciler;
	}

	@Override
	public IContentAssistant getContentAssist() {
		if( proposalComputer != null ) {
			return new ContentAssistant(this::computeProposals);
		}
		return super.getContentAssist();
	}

	List<ICompletionProposal> computeProposals(Integer offset) {
		try {
			return proposalComputer.compute(new ProposalContext(input, offset)).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public IAnnotationModel getAnnotationModel() {
		return annotationModel;
	}

	@Override
	public List<AnnotationPresenter> getAnnotationPresenters() {
		return annotationPresenters;
	}
}
