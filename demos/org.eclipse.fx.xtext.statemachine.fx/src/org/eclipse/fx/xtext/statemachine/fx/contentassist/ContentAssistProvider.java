package org.eclipse.fx.xtext.statemachine.fx.contentassist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.jface.text.contentassist.CompletetionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Singleton
public class ContentAssistProvider {
	@Inject
	Provider<ContentAssistContextFactory> contextFactoryProvider;
	@Inject
	Provider<XtextResourceSet> resourceSetProvider;
	@Inject
	ExecutorService pool;
	@Inject
	IScopeProvider scopeProvider;
	@Inject
	CurrentTypeFinder typeFinder;
	
	private Image referenceImage;
	
	public ContentAssistProvider() {
		referenceImage = new Image(getClass().getResource("field_public_obj.png").toExternalForm());
	}

	@SuppressWarnings("restriction")
	public List<ICompletionProposal> doContentAssist(String content, String uri, Integer offset) {
		ContentAssistContextFactory contextFactory = contextFactoryProvider.get();
		XtextResourceSet xtextResourceSet = resourceSetProvider.get();

		XtextResource resource = (XtextResource) xtextResourceSet.getResource(URI.createURI(uri), true);
		contextFactory.setPool(pool);
		ContentAssistContext[] contexts = contextFactory.create(content, new TextRegion(0, 0), offset, resource);

		List<ICompletionProposal> proposal = new ArrayList<>();
		for (int i = 0; i < contexts.length; i++) {
			for (AbstractElement abstractElement : contexts[i].getFirstSetGrammarElements()) {
				createProposals(contexts[i], abstractElement, offset, proposal);
			}
		}

		return proposal;
	}

	private void createProposals(ContentAssistContext context, AbstractElement abstractElement, int offset,
			List<ICompletionProposal> proposal) {
		if (abstractElement instanceof Assignment) {
			Assignment assignment = (Assignment) abstractElement;
			if (assignment.getTerminal() instanceof CrossReference) {
				createProposals(context, assignment.getTerminal(), offset, proposal);
			}
		} else if (abstractElement instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) abstractElement;
			if (ruleCall.getRule() instanceof TerminalRule && context.getPrefix().isEmpty()) {
				if (ruleCall.getRule().getName().equals("STRING")) {
					// val container = ruleCall.eContainer
					// if (container instanceof Assignment) {
					// proposal = '"' + container.feature + '"'
					// description = ruleCall.rule.name
					// } else {
					// proposal = '"' + ruleCall.rule.name + '"'
					// }
					// editPositions += new
					// ContentAssistResult.EditPosition(context.offset + 1,
					// proposal.length - 2)
				} else {
					EObject container = ruleCall.eContainer();
					if (container instanceof Assignment) {
						proposal.add(new CompletetionProposal(((Assignment) container).getFeature(), offset, 0,
								ruleCall.getRule().getName(), () -> null));
					} else {
						proposal.add(new CompletetionProposal(ruleCall.getRule().getName(), offset, 0,
								ruleCall.getRule().getName(), () -> null));
					}
					// editPositions += new
					// ContentAssistResult.EditPosition(context.offset,
					// proposal.length)
				}
			}
		} else if (abstractElement instanceof Keyword) {
			Keyword w = (Keyword) abstractElement;
			proposal.add(new CompletetionProposal(w.getValue(), offset, 0, w.getValue(), () -> null));
		} else if (abstractElement instanceof CrossReference) {
			CrossReference reference = (CrossReference) abstractElement;
			EClassifier type = typeFinder.findCurrentTypeAfter(reference);
			if (type instanceof EClass) {
				EReference ereference = GrammarUtil.getReference(reference, (EClass) type);
				if (ereference != null) {
					IScope scope = scopeProvider.getScope(context.getCurrentModel(), ereference);
					try {
						for (IEObjectDescription description : scope.getAllElements()) {
							String elementName = description.getName().toString();
							if (elementName.startsWith(context.getPrefix())) {
								StyledString s = new StyledString();
								s.appendSegment(elementName + " - ", "state-default-string");
								s.appendSegment(description.getEClass().getName(), "state-type-info");
								proposal.add(new CompletetionProposal(elementName, offset,
										0, s, () -> new ImageView(referenceImage)));
							}
						}
					} catch (UnsupportedOperationException uoe) {
						// LOG.error('Failed to create content assist proposals
						// for cross-reference.', uoe)
					}
				}
			}
		}
	}

}
