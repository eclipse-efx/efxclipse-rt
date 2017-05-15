package org.eclipse.fx.code.editor.fx.services.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.SourceSelection;
import org.eclipse.fx.code.editor.fx.services.CompletionProposalPresenter;
import org.eclipse.fx.code.editor.services.BehaviorContributor;
import org.eclipse.fx.code.editor.services.BehaviorContributor.MappingRegistry;
import org.eclipse.fx.code.editor.services.CompletionProposal;
import org.eclipse.fx.code.editor.services.EditingContext;
import org.eclipse.fx.code.editor.services.EditorOpener;
import org.eclipse.fx.code.editor.services.HoverInformationProvider;
import org.eclipse.fx.code.editor.services.NavigationProvider;
import org.eclipse.fx.code.editor.services.ProposalComputer;
import org.eclipse.fx.code.editor.services.SearchProvider;
import org.eclipse.fx.core.AppMemento;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.navigation.NavigationRegion;
import org.eclipse.fx.text.navigation.NavigationTarget;
import org.eclipse.fx.text.ui.Feature;
import org.eclipse.fx.text.ui.ITextHover;
import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.text.ui.contentassist.ContentAssistContextData;
import org.eclipse.fx.text.ui.contentassist.ContentAssistant;
import org.eclipse.fx.text.ui.contentassist.ICompletionProposal;
import org.eclipse.fx.text.ui.contentassist.IContentAssistant;
import org.eclipse.fx.text.ui.contentassist.IContextInformation;
import org.eclipse.fx.text.ui.contentassist.IContextInformationValidator;
import org.eclipse.fx.text.ui.presentation.IPresentationReconciler;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.source.AnnotationPresenter;
import org.eclipse.fx.text.ui.source.ISourceViewer;
import org.eclipse.fx.text.ui.source.SourceViewerConfiguration;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.CustomQuickLink;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLink;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLinkable;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping.Context;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;

import com.google.common.collect.Range;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;

@SuppressWarnings("restriction")
public class DefaultSourceViewerConfiguration extends SourceViewerConfiguration {
	private final Input<?> input;
	private final PresentationReconciler reconciler;
	private final ProposalComputer proposalComputer;
	private final IAnnotationModel annotationModel;
	private final AnnotationPresenter annotationPresenter;
	private final HoverInformationProvider hoverInformationProvider;
	private final CompletionProposalPresenter proposalPresenter;
	private final SearchProvider searchProvider;
	private final NavigationProvider navigationProvider;
	private final EditorOpener editorOpener;
	private final BehaviorContributor behaviorContributor;

	@Inject private EventBus eventBus;

	private ContentAssistant contentAssistant;
	private SetProperty<Feature> featureSet = new SimpleSetProperty<Feature>(this, "featureSet", FXCollections.observableSet());

	private final ThreadSynchronize threadSynchronize;
	private final IContextInformationValidator contextInformationValidator;

	private final AppMemento appMemento;

	private final static String KEY_HOVER_WINDOW_WIDTH = DefaultSourceViewerConfiguration.class.getName() + ".hoverWindowWidth";
	private final static String KEY_HOVER_WINDOW_HEIGHT = DefaultSourceViewerConfiguration.class.getName() + ".hoverWindowHeight";
	private final static String KEY_PROPOSAL_WINDOW_WIDTH = DefaultSourceViewerConfiguration.class.getName() + ".proposalWindowWidth";
	private final static String KEY_PROPOSAL_WINDOW_HEIGHT = DefaultSourceViewerConfiguration.class.getName() + ".proposalWindowHeight";

	@Inject
	public DefaultSourceViewerConfiguration(
			ThreadSynchronize threadSynchronize,
			Input<?> input,
			PresentationReconciler reconciler,
			AppMemento appMemento,
			@Optional ProposalComputer proposalComputer,
			@Optional IAnnotationModel annotationModel,
			@Optional AnnotationPresenter annotationPresenter,
			@Optional HoverInformationProvider hoverInformationProvider,
			@Optional CompletionProposalPresenter proposalPresenter,
			@Optional SearchProvider searchProvider,
			@Optional NavigationProvider navigationProvider,
			@Optional EditorOpener editorOpener,
			@Optional BehaviorContributor behaviorContributor,
			@Optional IContextInformationValidator contextInformationValidator
			) {
		this.threadSynchronize = threadSynchronize;
		this.contextInformationValidator = contextInformationValidator;
		this.input = input;
		this.hoverInformationProvider = hoverInformationProvider;
		this.reconciler = reconciler;
		this.proposalComputer = proposalComputer;
		this.annotationModel = annotationModel;
		this.proposalPresenter = proposalPresenter == null ? DefaultProposal::new : proposalPresenter;

		this.annotationPresenter = annotationPresenter;
		this.searchProvider = searchProvider;
		this.navigationProvider = navigationProvider;
		this.editorOpener = editorOpener;
		this.behaviorContributor = behaviorContributor;
		this.appMemento = appMemento;
	}

	@Inject
	public void setFeatureSet(@Preference(key=Constants.PREFERENCE_KEY_EDITOR_FEATURE,nodePath=Constants.PREFERENCE_NODE_PATH) Set<Feature> featureSet) {
		this.featureSet.clear();
		if( featureSet != null ) {
			this.featureSet.addAll(featureSet);
		} else {
			this.featureSet.add(Feature.SHOW_LINE_NUMBERS);
		}
	}

	private Range<Integer> convertRegion(IRegion region) {
		return Range.closed(region.getOffset(), region.getOffset() + region.getLength());
	}

	private QuickLink convertNavigationTarget(NavigationTarget target) {
		return new CustomQuickLink() {

			@Override
			public String getLabel() {
				// TODO
				return "need some label here!";
			}

			@Override
			public Runnable getAction() {
				return () -> {
					editorOpener.openEditor(target.getFile().toString());
					eventBus.publish(Constants.TOPIC_SELECT_SOURCE, new SourceSelection(target.getFile().toString(), target.getRegion()), true);
				};
			}

			@Override
			public String toString() {
				return "CustombQuickLink in " + target.getFile() + " @ " + target.getRegion();
			}

		};
	}

	private QuickLinkable convertNavigationRegion(NavigationRegion region) {
		return new QuickLinkable() {
			@Override
			public Range<Integer> getRegion() {
				return convertRegion(region.getRegion());
			}

			@Override
			public List<QuickLink> getLinks() {
				return region.getTargets().stream().map(DefaultSourceViewerConfiguration.this::convertNavigationTarget).collect(Collectors.toList());
			}
		};
	}

	@Override
	public Function<Integer, java.util.Optional<QuickLinkable>> getQuicklinkCallback() {

		if (navigationProvider != null) {

			return (offset) -> {
				try {
					return navigationProvider.getNavigationRegion(offset)
							.get(400, TimeUnit.MILLISECONDS)
							.map(this::convertNavigationRegion);
				}
				catch (InterruptedException | TimeoutException | ExecutionException e) {
					e.printStackTrace();
				}

				return java.util.Optional.empty();
			};
		}
		else {
			return super.getQuicklinkCallback();
		}
	}

	@Override
	public SetProperty<Feature> getFeatures() {
		return this.featureSet;
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
			if( contentAssistant == null ) {
				contentAssistant = new ContentAssistant(this.contextInformationValidator, this.threadSynchronize, this::computeProposals);
				contentAssistant.configureWindowSize(this::getProposalWindowSize, this::storeProposalWindowSize);
			}

			return contentAssistant;
		}
		return super.getContentAssist();
	}

	List<ICompletionProposal> computeProposals(ContentAssistContextData data) {
		try {
			return proposalComputer.compute(/*new ProposalContext(input, data.document, data.offset)*/).get()
						.stream()
						.map(proposalPresenter::createProposal)
						.collect(Collectors.toList());
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
	public AnnotationPresenter getAnnotationPresenter() {
		return annotationPresenter;
	}

	@Override
	public Set<HoverInfo> getDocumentHoverInfo(IDocument document, int offset) {
		if (hoverInformationProvider != null) {
			return hoverInformationProvider.getDocumentHoverProvider().getHoverInfo(document, offset);
		}
		return super.getDocumentHoverInfo(document, offset);
	}

	@Override
	public Set<HoverInfo> getAnnotationHoverInfo(Annotation annotation) {
		if (hoverInformationProvider != null) {
			return hoverInformationProvider.getAnnotationHoverProviders().stream()
					.filter(p->p.isApplicable(annotation.getClass()))
					.map(p->p.getHoverInfo(annotation))
					.collect(Collectors.toSet());
		}
		return super.getAnnotationHoverInfo(annotation);
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		if( hoverInformationProvider != null ) {
			return new ITextHover() {

				@Override
				public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
					return hoverInformationProvider.getHoverRegion(contentType, offset);
				}

				@Override
				public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
					CharSequence information = hoverInformationProvider.getHoverInformation(contentType, hoverRegion);
					return information == null ? null : information.toString();
				}
			};
		}
		return super.getTextHover(sourceViewer, contentType);
	}

	static class DefaultProposal implements ICompletionProposal {
		private final CompletionProposal proposal;

		public DefaultProposal(CompletionProposal proposal) {
			this.proposal = proposal;
		}

		@Override
		public Node getContentNode() {
			CharSequence label = this.proposal.getLabel();
			if( label instanceof StyledString ) {
				return Util.toNode((StyledString) label);
			}
			return new Label(label != null ? label.toString() : "<unknown>");
		}

		@Override
		public Node getGraphic() {
			return null;
		}

		@Override
		public void apply(IDocument document) {
			this.proposal.apply(document);
		}

		@Override
		public TextSelection getSelection(IDocument document) {
			org.eclipse.fx.code.editor.services.CompletionProposal.TextSelection selection = proposal.getSelection(document);
			return selection == null ? TextSelection.EMPTY : new TextSelection(selection.offset, selection.length);
		}

		@Override
		public IContextInformation getContextInformation() {
			return new IContextInformation() {
				// TODO fix this here
				@Override
				public String getInformationDisplayString() {
					return null;
				}

				@Override
				public Node getGraphic() {
					return null;
				}

				@Override
				public int getContextInformationPosition() {
					return 0;
				}

				@Override
				public String getContextDisplayString() {
					return null;
				}
			};
		}

		@Override
		public String getHoverInfo() {
			return null;
		}
	}

	@Inject private IDocument document;

//	private EditingContext getEditingContext(Context context) {
//		return new EditingContext(input, document, context.control.getCaretOffset(), new IEditor() {
//			@Override
//			public int getCaret() {
//				return context.control.getCaretOffset();
//			}
//
//			@Override
//			public void setCaret(int loc) {
//				context.control.setCaretOffset(loc);
//			}
//
//			@Override
//			public void setCaret(int loc, boolean keepSelection) {
//				context.control.impl_setCaretOffset(loc, keepSelection);
//			}
//
//			@Override
//			public IRegion getSelection() {
//				return new Region(context.control.getSelection().offset, context.control.getSelection().length);
//			}
//
//			@Override
//			public void setSelection(IRegion selection) {
//				context.control.setSelection(new TextSelection(selection.getOffset(), selection.getLength()));
//			}
//
//		});
//	}

	@Override
	public TriggerActionMapping getOverrideMapping() {
		if (behaviorContributor != null) {
			TriggerActionMapping x = new TriggerActionMapping();
			behaviorContributor.initializeMapping(new MappingRegistry() {
				@Override
				public void map(String combo, TextEditAction action) {
					x.map(combo, action);
				}

				@Override
				public void map(char typedChar, TextEditAction action) {
					x.map(typedChar, action);
				}

				@Override
				public void mapConditional(String conditionId, Supplier<Boolean> condition, String combo, TextEditAction action) {
					x.mapConditional(conditionId, condition, combo, action);
				}

				@Override
				public void mapConditional(String conditionId, Supplier<Boolean> condition, char typedChar, TextEditAction action) {
					x.mapConditional(conditionId, condition, typedChar, action);
				}
			});
			x.subscribe((e, c)->behaviorContributor.handle(e));
			return x;
		}
		return super.getOverrideMapping();
	}

	@Override
	public Point2D getHoverWindowSize() {
		if (appMemento == null) return super.getHoverWindowSize();
		double width = appMemento.get(KEY_HOVER_WINDOW_WIDTH, 600d);
		double height = appMemento.get(KEY_HOVER_WINDOW_HEIGHT, 400d);
		return new Point2D(width, height);
	}

	@Override
	public void storeHoverWindowSize(Point2D size) {
		if (appMemento != null) {
			appMemento.put(KEY_HOVER_WINDOW_WIDTH, size.getX());
			appMemento.put(KEY_HOVER_WINDOW_HEIGHT, size.getY());
		}
	}

	@Override
	public Point2D getProposalWindowSize() {
		if (appMemento == null) return super.getProposalWindowSize();
		double width = appMemento.get(KEY_PROPOSAL_WINDOW_WIDTH, 600d);
		double height = appMemento.get(KEY_PROPOSAL_WINDOW_HEIGHT, 400d);
		return new Point2D(width, height);
	}

	@Override
	public void storeProposalWindowSize(Point2D size) {
		if (appMemento != null) {
			appMemento.put(KEY_PROPOSAL_WINDOW_WIDTH, size.getX());
			appMemento.put(KEY_PROPOSAL_WINDOW_HEIGHT, size.getY());
		}
	}
}
