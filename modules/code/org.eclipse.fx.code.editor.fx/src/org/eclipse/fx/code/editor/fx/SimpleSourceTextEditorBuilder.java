/*******************************************************************************
* Copyright (c) 2015 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.fx;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.fx.services.CompletionProposalPresenter;
import org.eclipse.fx.code.editor.fx.services.EditorContextMenuProvider;
import org.eclipse.fx.code.editor.fx.services.internal.DefaultSourceViewerConfiguration;
import org.eclipse.fx.code.editor.services.BehaviorContributor;
import org.eclipse.fx.code.editor.services.EditorOpener;
import org.eclipse.fx.code.editor.services.HoverInformationProvider;
import org.eclipse.fx.code.editor.services.NavigationProvider;
import org.eclipse.fx.code.editor.services.ProposalComputer;
import org.eclipse.fx.code.editor.services.SearchProvider;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.event.SimpleEventBus;
import org.eclipse.fx.text.rules.CombinedWordRule;
import org.eclipse.fx.text.rules.JavaLikeWordDetector;
import org.eclipse.fx.text.ui.TextAttribute;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer;
import org.eclipse.fx.text.ui.source.AnnotationPresenter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.source.IAnnotationModel;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;

/**
 * A builder who allows to build a source editor for programming languages like
 * java, javascript, ...
 *
 * @since 2.2.0
 */
@SuppressWarnings("restriction")
public class SimpleSourceTextEditorBuilder {
	private List<String> keywordList = new ArrayList<>();
	private List<String> singleLineCommentStart = new ArrayList<>();
	private List<String> singleLineDocCommentStart = new ArrayList<>();
	private List<MultiLine> multiLineComment = new ArrayList<>();
	private List<MultiLine> multiLineDocComment = new ArrayList<>();
	private List<Character> stringIdentifier = new ArrayList<>();
	private char stringEscapeChar;

	private ProposalComputer proposalComputer;
	private AnnotationPresenter annotationPresenter;
	private final String languageName;
	private CompletionProposalPresenter completionProposalPresenter;
	private HoverInformationProvider hoverInformationProvider;
	private SearchProvider searchProvider;
	private NavigationProvider navigationProvider;
	private EditorOpener editorOpener;
	private BehaviorContributor behaviorContributor;

	static class MultiLine {
		private final String start;
		private final String end;

		public MultiLine(String start, String end) {
			this.start = start;
			this.end = end;
		}
	}

	private SimpleSourceTextEditorBuilder(String languageName) {
		this.languageName = languageName;
	}

	public SimpleSourceTextEditorBuilder addKeyWord(String keyword) {
		keywordList.add(keyword);
		return this;
	}

	public SimpleSourceTextEditorBuilder addSingleLineCommentStart(String start) {
		singleLineCommentStart.add(start);
		return this;
	}

	public SimpleSourceTextEditorBuilder addSingleLineDocCommentStart(String start) {
		singleLineDocCommentStart.add(start);
		return this;
	}

	public SimpleSourceTextEditorBuilder addMultiLineComment(String start, String end) {
		multiLineComment.add(new MultiLine(start, end));
		return this;
	}

	public SimpleSourceTextEditorBuilder addMultiLineDocComment(String start, String end) {
		multiLineDocComment.add(new MultiLine(start, end));
		return this;
	}

	public SimpleSourceTextEditorBuilder addStringStartEnd(char c) {
		stringIdentifier.add(c);
		return this;
	}

	public SimpleSourceTextEditorBuilder setProposalComputer(ProposalComputer proposalComputer) {
		this.proposalComputer = proposalComputer;
		return this;
	}

	public SimpleSourceTextEditorBuilder setAnnotationPresenter(AnnotationPresenter annotationPresenter) {
		this.annotationPresenter = annotationPresenter;
		return this;
	}

	public SimpleSourceTextEditorBuilder setCompletionProposalPresenter(CompletionProposalPresenter completionProposalPresenter) {
		this.completionProposalPresenter = completionProposalPresenter;
		return this;
	}

	public SimpleSourceTextEditorBuilder setHoverInformationProvider(HoverInformationProvider hoverInformationProvider) {
		this.hoverInformationProvider = hoverInformationProvider;
		return this;
	}

	public SimpleSourceTextEditorBuilder setStringEscapeChar(char c) {
		this.stringEscapeChar = c;
		return this;
	}

	public TextEditor build(ThreadSynchronize threadSynchronize, BorderPane pane, IDocument document, Input<?> input) {
		return build(threadSynchronize, pane, document, input, null);
	}

	public TextEditor build(ThreadSynchronize threadSynchronize, BorderPane pane, IDocument document, Input<?> input, IAnnotationModel annotationModel) {
		TextEditor editor = new TextEditor();
//		editor.setInput(input);
//		editor.setDocument(document);

		List<String> contentTypes = new ArrayList<String>();
		if (singleLineCommentStart.isEmpty()) {
			contentTypes.add("__" + languageName + "_singlelinecomment");
		}

		if (singleLineDocCommentStart.isEmpty()) {
			contentTypes.add("__" + languageName + "_singlelinedoccomment");
		}

		if (multiLineComment.isEmpty()) {
			contentTypes.add("__" + languageName + "_multilinecomment");
		}

		if (multiLineDocComment.isEmpty()) {
			contentTypes.add("__" + languageName + "_multilinedoccomment");
		}

		if (stringIdentifier.isEmpty()) {
			contentTypes.add("__" + languageName + "_string");
		}

		FastPartitioner partitioner = new FastPartitioner(new PartitionerImpl(this), contentTypes.toArray(new String[0]));
		ReconcilerImpl reconciler = new ReconcilerImpl(this);
		DefaultSourceViewerConfiguration c = new DefaultSourceViewerConfiguration(threadSynchronize, input, reconciler, null, proposalComputer, annotationModel, annotationPresenter, hoverInformationProvider, completionProposalPresenter, searchProvider, navigationProvider, editorOpener, behaviorContributor, null);
		
		editor.initUI(pane,new SimpleEventBus(),new EditorContextMenuProvider() {
			
			@Override
			public void attacheMenu(Control styledText, Type type) {
				// TODO Auto-generated method stub
				
			}
		},null,null,document,c,partitioner,input,new SimpleObjectProperty<>(),new SimpleObjectProperty<>(1.0));
		return editor;
	}

	public static SimpleSourceTextEditorBuilder create(String languageName) {
		return new SimpleSourceTextEditorBuilder(languageName);
	}

	static class PartitionerImpl extends RuleBasedPartitionScanner {
		public PartitionerImpl(SimpleSourceTextEditorBuilder textEditorBuilder) {
			List<IPredicateRule> rules = new ArrayList<>();

			if (textEditorBuilder.singleLineCommentStart.isEmpty()) {
				Token token = new Token("__" + textEditorBuilder.languageName + "_singlelinecomment");
				for (String s : textEditorBuilder.singleLineCommentStart) {
					rules.add(new SingleLineRule(s, null, token));
				}
			}

			if (textEditorBuilder.singleLineDocCommentStart.isEmpty()) {
				Token token = new Token("__" + textEditorBuilder.languageName + "_singlelinedoccomment");
				for (String s : textEditorBuilder.singleLineDocCommentStart) {
					rules.add(new SingleLineRule(s, null, token));
				}
			}

			if (textEditorBuilder.multiLineComment.isEmpty()) {
				Token token = new Token("__" + textEditorBuilder.languageName + "_multilinecomment");
				for (MultiLine m : textEditorBuilder.multiLineComment) {
					rules.add(new MultiLineRule(m.start, m.end, token));
				}
			}

			if (textEditorBuilder.multiLineDocComment.isEmpty()) {
				Token token = new Token("__" + textEditorBuilder.languageName + "_multilinedoccomment");
				for (MultiLine m : textEditorBuilder.multiLineDocComment) {
					rules.add(new MultiLineRule(m.start, m.end, token));
				}
			}

			if (textEditorBuilder.stringIdentifier.isEmpty()) {
				Token token = new Token("__" + textEditorBuilder.languageName + "_string");
				for (Character c : textEditorBuilder.stringIdentifier) {
					rules.add(new SingleLineRule(c.toString(), c.toString(), token, textEditorBuilder.stringEscapeChar));
				}
			}

			setPredicateRules(rules.toArray(new IPredicateRule[0]));
		}
	}

	static class ReconcilerImpl extends PresentationReconciler {
		public ReconcilerImpl(SimpleSourceTextEditorBuilder textEditorBuilder) {
			{
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new CodeRuleScanner(textEditorBuilder));
				setDamager(dr, "__dftl_partition_content_type");
				setRepairer(dr, "__dftl_partition_content_type");				
			}
			
			if (textEditorBuilder.singleLineCommentStart.isEmpty()) {
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new NoRuleRuleScanner(textEditorBuilder.languageName + "_comment"));
				setDamager(dr, "__" + textEditorBuilder.languageName + "_singlelinecomment");
				setRepairer(dr, "__" + textEditorBuilder.languageName + "_singlelinecomment");
			}

			if (textEditorBuilder.singleLineDocCommentStart.isEmpty()) {
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new NoRuleRuleScanner(textEditorBuilder.languageName + "_doccomment"));
				setDamager(dr, "__" + textEditorBuilder.languageName + "_singlelinedoccomment");
				setRepairer(dr, "__" + textEditorBuilder.languageName + "_singlelinedoccomment");
			}

			if (textEditorBuilder.multiLineComment.isEmpty()) {
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new NoRuleRuleScanner(textEditorBuilder.languageName + "_comment"));
				setDamager(dr, "__" + textEditorBuilder.languageName + "_multilinecomment");
				setRepairer(dr, "__" + textEditorBuilder.languageName + "_multilinecomment");
			}

			if (textEditorBuilder.multiLineDocComment.isEmpty()) {
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new NoRuleRuleScanner(textEditorBuilder.languageName + "_doccomment"));
				setDamager(dr, "__" + textEditorBuilder.languageName + "_multilinedoccomment");
				setRepairer(dr, "__" + textEditorBuilder.languageName + "_multilinedoccomment");
			}

			if (textEditorBuilder.stringIdentifier.isEmpty()) {
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new NoRuleRuleScanner(textEditorBuilder.languageName + "_string"));
				setDamager(dr, "__" + textEditorBuilder.languageName + "_string");
				setRepairer(dr, "__" + textEditorBuilder.languageName + "_string");
			}
		}
	}

	static class NoRuleRuleScanner extends RuleBasedScanner {
		public NoRuleRuleScanner(String defaultTokenName) {
			setDefaultReturnToken(new Token(new TextAttribute(defaultTokenName)));
		}
	}

	static class CodeRuleScanner extends RuleBasedScanner {
		public CodeRuleScanner(SimpleSourceTextEditorBuilder textEditorBuilder) {
			Token defaultToken = new Token(new TextAttribute(textEditorBuilder.languageName + "_default"));

			IRule[] rules = new IRule[2];
			rules[0] = new WhitespaceRule(new IWhitespaceDetector() {

				@Override
				public boolean isWhitespace(char c) {
					return Character.isWhitespace(c);
				}
			});

			JavaLikeWordDetector wordDetector = new JavaLikeWordDetector();
			CombinedWordRule combinedWordRule = new CombinedWordRule(wordDetector, defaultToken);

			Token keywordToken = new Token(new TextAttribute(textEditorBuilder.languageName + "_keyword"));
			CombinedWordRule.WordMatcher wordRule = new CombinedWordRule.WordMatcher();

			for (String keyword : textEditorBuilder.keywordList) {
				wordRule.addWord(keyword, keywordToken);
			}

			combinedWordRule.addWordMatcher(wordRule);

			rules[1] = combinedWordRule;

			setRules(rules);
			setDefaultReturnToken(defaultToken);
		}
		
		@Override
		public IToken nextToken() {
			IToken nextToken = super.nextToken();
			return nextToken;
		}
	}

//	public static void main(String[] args) {
//		BorderPane p = new BorderPane();
//		LocalSourceFileInput in = new LocalSourceFileInput(Paths.get("/tmp/Sample.java"),null);
//
//		SimpleSourceTextEditorBuilder.create("java")
//			.addMultiLineComment("/*", "*/")
//			.addMultiLineDocComment("/**", "*/")
//			.addSingleLineCommentStart("//")
//			.addStringStartEnd('"')
//			.addStringStartEnd('\'')
//			.setStringEscapeChar('\\')
//			.addKeyWord("abstract")
//			.addKeyWord("assert")
//			.build(p, new Document(in.getData()), in);
//	}
}
