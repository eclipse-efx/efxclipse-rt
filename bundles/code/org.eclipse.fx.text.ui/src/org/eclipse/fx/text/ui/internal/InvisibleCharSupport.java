package org.eclipse.fx.text.ui.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.text.ui.IFeature;
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
import com.google.common.collect.TreeRangeSet;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class InvisibleCharSupport implements IFeature {

	public class InvisibleCharAnnotation implements TextAnnotation {

		private final String styleClass;
		private final Range range;
		private final String symbol;
		private int tabWidth;

		@Override
		public Range getRange() {
			return range;
		}

		public String getSymbol() {
			return symbol;
		}

		@Override
		public Object getModel() {
			return symbol;
		}

		public InvisibleCharAnnotation(String styleClass, String symbol, Range range, int tabWidth) {
			this.styleClass = styleClass;
			this.symbol = symbol;
			this.range = range;
			this.tabWidth = tabWidth;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((range == null) ? 0 : range.hashCode());
			result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
			result = prime * result + tabWidth;
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
			if (tabWidth != other.tabWidth)
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
			InvisibleCharNode node = new InvisibleCharNode();
			return node;
//			Text n = new Text();
//			n.getStyleClass().add("invisible-char");
//			return n;
		}

		@Override
		public boolean isVisible(Annotation annotation) {
			return true;
		}

		@Override
		public void updateNode(Node node, Annotation annotation) {
			InvisibleCharNode n = (InvisibleCharNode) node;
			InvisibleCharAnnotation a = (InvisibleCharAnnotation) annotation;
			n.getStyleClass().setAll("invisible-char", a.styleClass);
		}

		@Override
		public String toString() {
			return "InvisibleCharAP@" + hashCode(); //$NON-NLS-1$
		}

	}

	public class InvisibleCharAnnotationProvider implements AnnotationProvider {

		private StyledTextArea control;

		public InvisibleCharAnnotationProvider(StyledTextArea control) {
			this.control = control;
		}

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
				annotations.add(new InvisibleCharAnnotation("tab", "", Range.closed(matcher.start(), matcher.start() + 1), control.getTabAdvance()));
			}

			// ADD SPACE
			Pattern space = Pattern.compile("[ ]");
			matcher = space.matcher(line);
			while (matcher.find()) {
				annotations.add(new InvisibleCharAnnotation("space", "", Range.closed(matcher.start(), matcher.start() + 1), control.getTabAdvance()));
			}

			// ADD NEWLINE
			if (index < numOfLines-1) {
				annotations.add(new InvisibleCharAnnotation("enter", "", Range.closed(lineLength, lineLength +1), control.getTabAdvance()));
			}

			return annotations;
		}

		private List<Consumer<RangeSet<Integer>>> listeners = new ArrayList<>();

		public void notify(RangeSet<Integer> c) {
			this.listeners.stream().forEach(x->x.accept(c));
		}

		@Override
		public Subscription registerChangeListener(Consumer<RangeSet<Integer>> onChange) {
			this.listeners.add(onChange);
			return new Subscription() {
				@Override
				public void dispose() {
					InvisibleCharAnnotationProvider.this.listeners.remove(onChange);
				}
			};
		}

	}

	@Override
	public Subscription install(final StyledTextArea control) {
		final InvisibleCharAnnotationProvider provider = new InvisibleCharAnnotationProvider(control);
		final InvisibleCharAnnotationPresenter presenter = new InvisibleCharAnnotationPresenter();

		final ChangeListener<? super Number> onTabAdvanceChange = (x, o, n)->{
			RangeSet<Integer> rs = TreeRangeSet.<Integer>create().complement();
			provider.notify(rs);
		};

		control.getAnnotationProvider().add(provider);
		control.getAnnotationPresenter().add(presenter);
		control.tabAvanceProperty().addListener(onTabAdvanceChange);

		return new Subscription() {
			@Override
			public void dispose() {
				control.getAnnotationProvider().remove(provider);
				control.getAnnotationPresenter().remove(presenter);
				control.tabAvanceProperty().removeListener(onTabAdvanceChange);
			}
		};
	}

}
