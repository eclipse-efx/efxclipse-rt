package org.eclipse.fx.text.ui.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotation;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.source.IAnnotationModel;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;

import javafx.scene.Node;
import javafx.scene.text.Text;

public class InvisibleCharSupport {

	private StyledTextArea control;

	public InvisibleCharSupport(StyledTextArea control) {
		this.control = control;
	}


	public class InvisibleCharAnnotation implements TextAnnotation {

		private final Range range;
		private final String symbol;

		@Override
		public Range getRange() {
			return range;
		}

		public String getSymbol() {
			return symbol;
		}

		public InvisibleCharAnnotation(String symbol, Range range) {
			this.symbol = symbol;
			this.range = range;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((range == null) ? 0 : range.hashCode());
			result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			InvisibleCharAnnotation other = (InvisibleCharAnnotation) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (range == null) {
				if (other.range != null)
					return false;
			} else if (!range.equals(other.range))
				return false;
			if (symbol == null) {
				if (other.symbol != null)
					return false;
			} else if (!symbol.equals(other.symbol))
				return false;
			return true;
		}

		private InvisibleCharSupport getOuterType() {
			return InvisibleCharSupport.this;
		}


	}

	public class InvisibleCharAnnotationPresenter implements TextAnnotationPresenter {

		@Override
		public boolean isApplicable(Annotation annotation) {
			return annotation instanceof InvisibleCharAnnotation;
		}

		@Override
		public Node createNode() {
			Text n = new Text();
			n.getStyleClass().add("invisible-char");
			return n;
		}

		@Override
		public boolean isVisible(Annotation annotation) {
			return true;
		}

		@Override
		public void updateNode(Node node, Annotation annotation) {
			Text t = (Text) node;
			InvisibleCharAnnotation a = (InvisibleCharAnnotation) annotation;
			t.setText(a.getSymbol());
		}

	}

	public class InvisibleCharAnnotationProvider implements AnnotationProvider {

		@Override
		public Set<? extends Annotation> computeAnnotations(int index) {
			@NonNull
			StyledTextContent content = control.getContent();

			Set<InvisibleCharAnnotation> annotations = new HashSet<>();

			int lineBegin = content.getOffsetAtLine(index);
			int lineLength = content.getLine(index).length();

			String line = content.getTextRange(lineBegin, lineLength);


			int numOfLines = content.getLineCount();

			// ADD TABS
			Pattern tab = Pattern.compile("\\t");
			Matcher matcher = tab.matcher(line);
			while (matcher.find()) {
				annotations.add(new InvisibleCharAnnotation("\u21E5", Range.closed(matcher.start(), matcher.start() + 1)));
			}

			// ADD NEWLINE
			if (index < numOfLines-1) {
				annotations.add(new InvisibleCharAnnotation("\u21B5", Range.closed(lineLength, lineLength +1)));
			}

			return annotations;
		}

		@Override
		public Subscription registerChangeListener(Consumer<RangeSet<Integer>> onChange) {
			return new Subscription() {
				@Override
				public void dispose() {

				}
			};
		}

	}



	public void install() {
		this.control.getAnnotationProvider().add(new InvisibleCharAnnotationProvider());
		this.control.getAnnotationPresenter().add(new InvisibleCharAnnotationPresenter());
	}
}
