/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.hsl;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.fx.code.compensator.editor.ProposalComputer.ProposalContext;
import org.eclipse.fx.code.compensator.hsl.hSL.Damager;
import org.eclipse.fx.code.compensator.hsl.hSL.JSDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.fx.code.editor.hsl.internal.HSLRuleScanner;
import org.eclipse.fx.code.editor.hsl.internal.JavaScriptHelper;
import org.eclipse.fx.core.di.Service;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.AnnotationPresenter;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class HSLConfiguration extends SourceViewerConfiguration {
	private final Model model;
	private final ClassLoader cl;
	
	private final IAnnotationModel annotationModel;
	private final List<AnnotationPresenter> annotationPresenters;
	private final ProposalComputer proposalComputer;
	private final Input<?> input;

	@Inject
	public HSLConfiguration(
			Model model, 
			Input<?> input,
			@Optional ProposalComputer proposalComputer,
			@Optional IAnnotationModel annotationModel,
			@Service List<AnnotationPresenter> annotationPresenters) {
		this.cl = getClass().getClassLoader();
		this.model = model;
		this.input = input;
		this.annotationModel = annotationModel;
		this.annotationPresenters = annotationPresenters;
		this.proposalComputer = proposalComputer;
	}

	public final IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		for( Damager sc : model.getDamagers() ) {
			if( sc instanceof RuleDamager ) {
				RuleDamager rs = (RuleDamager) sc;
				HSLRuleScanner s = new HSLRuleScanner(rs);
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(s);
				reconciler.setDamager(dr, rs.getPartition().getName());
				reconciler.setRepairer(dr, rs.getPartition().getName());
			} else {
				JSDamager js = (JSDamager) sc;
				Object o = JavaScriptHelper.loadScript(cl, js, js.getFileURI());
				reconciler.setDamager((IPresentationDamager) o, js.getPartition().getName());
				reconciler.setRepairer((IPresentationRepairer) o, js.getPartition().getName());
			}
		}

		return reconciler;
	}
	
	@Override
	public String getStyleclassName() {
		return model.getName();
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
