package org.eclipse.fx.xtext.sample.editor.java.text;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationPainter.ITextStyleStrategy;
import org.eclipse.jface.text.source.AnnotationPresenter;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class JavaSourceConfiguration extends SourceViewerConfiguration {

	private JavaCodeScanner fCodeScanner;
	private JavaDocScanner fJavaDocScanner;
	private JavaCommentScanner fMultilineCommentScanner;
	private JavaCommentScanner fSinglelineCommentScanner;
	private SingleTokenJavaScanner fStringScanner;
//	private final Optional<ProposalComputer> computer;
//	private Input<?> input;
	private IAnnotationModel annotationModel;
	private List<AnnotationPresenter> annotationPresenters;

	public JavaSourceConfiguration() {
		this(null,null);
	}
			
	
	public JavaSourceConfiguration(
//			Input<?> input,
//			ProposalComputer computer,
			IAnnotationModel annotationModel,
			List<AnnotationPresenter> annotationPresenters) {
//		this.computer = Optional.ofNullable(computer);
		this.annotationModel = annotationModel;
//		this.input = input;
		this.annotationPresenters = annotationPresenters;
		initializeScanners();
	}

	@Override
	public IAnnotationModel getAnnotationModel() {
		return annotationModel;
	}

	private void initializeScanners() {
		fCodeScanner= new JavaCodeScanner();
		fMultilineCommentScanner= new JavaCommentScanner(IJavaColorConstants.JAVA_MULTI_LINE_COMMENT);
		fSinglelineCommentScanner= new JavaCommentScanner(IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT);
		fStringScanner= new SingleTokenJavaScanner(IJavaColorConstants.JAVA_STRING);
		fJavaDocScanner= new JavaDocScanner();
	}

	@Override
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return IJavaPartitions.JAVA_PARTITIONING;
	}

	@Override
	public IContentAssistant getContentAssist() {
//		if( computer.isPresent() ) {
//			return new ContentAssistant(this::computeProposals);
//		}
		return super.getContentAssist();
	}

//	private List<ICompletionProposal> computeProposals(Integer offset) {
//		Future<List<ICompletionProposal>> computedProposals = computer.get().compute(new ProposalContext(input, offset));
//		try {
//			return computedProposals.get();
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Collections.emptyList();
//	}

	@Override
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler= new /*JavaPresentationReconciler*/ PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		dr= new DefaultDamagerRepairer(getJavaDocScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_DOC);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_DOC);

		dr= new DefaultDamagerRepairer(getMultilineCommentScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getSinglelineCommentScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_STRING);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_STRING);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_CHARACTER);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_CHARACTER);

		return reconciler;
	}

	private ITokenScanner getStringScanner() {
		return fStringScanner;
	}

	private ITokenScanner getSinglelineCommentScanner() {
		return fSinglelineCommentScanner;
	}

	private ITokenScanner getMultilineCommentScanner() {
		return fMultilineCommentScanner;
	}

	private ITokenScanner getJavaDocScanner() {
		return fJavaDocScanner;
	}

	private ITokenScanner getCodeScanner() {
		return fCodeScanner;
	}

	@Override
	public String getStyleclassName() {
		return "java";
	}
	
	@Override
	public List<AnnotationPresenter> getAnnotationPresenters() {
		return annotationPresenters;
	}

	private static final ITextStyleStrategy PROBLEM_UNDERLINE = new ITextStyleStrategy() {

		@Override
		public void applyTextStyle(StyleRange styleRange, String annotationColor) {
			System.err.println("=======> Applying on" + annotationColor);
		}
	};

	@Override
	public AnnotationPainter getAnnotationPainter(ISourceViewer sourceViewer) {
		AnnotationPainter painter = new AnnotationPainter(sourceViewer, new AnnotationAccess());
		painter.addTextStyleStrategy("PROBLEM_UNDERLINE", PROBLEM_UNDERLINE);
		painter.addAnnotationType("PROBLEM_UNDERLINE", "PROBLEM_UNDERLINE");
		painter.setAnnotationTypeColor("jdt.annotation.WARNING", "jdt_warning");
		painter.setAnnotationTypeColor("jdt.annotation.TASK", "jdt_task");
		painter.setAnnotationTypeColor("jdt.annotation.ERROR", "jdt_error");

//		painter.addTextStyleStrategy(AnnotationPreference.STYLE_SQUIGGLES, fgSquigglesStrategy);
//		painter.addTextStyleStrategy(AnnotationPreference.STYLE_PROBLEM_UNDERLINE, fgProblemUnderlineStrategy);
//		painter.addTextStyleStrategy(AnnotationPreference.STYLE_BOX, fgBoxStrategy);
//		painter.addTextStyleStrategy(AnnotationPreference.STYLE_DASHED_BOX, fgDashedBoxStrategy);
//		painter.addTextStyleStrategy(AnnotationPreference.STYLE_UNDERLINE, fgUnderlineStrategy);

//		return painter;
		return null;
	}

	static class AnnotationAccess implements IAnnotationAccess, IAnnotationAccessExtension {

		@Override
		public String getTypeLabel(Annotation annotation) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getLayer(Annotation annotation) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isPaintable(Annotation annotation) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isSubtype(Object annotationType,
				Object potentialSupertype) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object[] getSupertypes(Object annotationType) {
			System.err.println("THE ANNOTATION TYPE: " + annotationType);
			return new Object[] { "PROBLEM_UNDERLINE" };
		}

		@Override
		public Object getType(Annotation annotation) {
			System.err.println("Extrac type: " + annotation);
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isMultiLine(Annotation annotation) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isTemporary(Annotation annotation) {
			// TODO Auto-generated method stub
			return false;
		}

	}
}
