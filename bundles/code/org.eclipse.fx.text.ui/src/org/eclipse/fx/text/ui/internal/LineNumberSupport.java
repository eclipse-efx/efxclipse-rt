package org.eclipse.fx.text.ui.internal;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.text.ui.IFeature;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;

import com.google.common.collect.RangeSet;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class LineNumberSupport implements IFeature {

	public class LineNrAnnotation implements Annotation {

		private final int nr;

		public LineNrAnnotation(int nr) {
			this.nr = nr;
		}
		public int getNr() {
			return this.nr;
		}

		@Override
		public Object getModel() {
			return this.nr;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + this.nr;
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
			LineNrAnnotation other = (LineNrAnnotation) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (this.nr != other.nr)
				return false;
			return true;
		}
		private LineNumberSupport getOuterType() {
			return LineNumberSupport.this;
		}


	}

	public class LineNrAnnotationPresenter implements LineRulerAnnotationPresenter {

		@Override
		public LayoutHint getLayoutHint() {
			return LayoutHint.ALIGN_RIGHT;
		}

		@Override
		public boolean isApplicable(Annotation annotation) {
			return annotation instanceof LineNrAnnotation;
		}

		@Override
		public Node createNode() {
			Text node = new Text();
			node.setBoundsType(TextBoundsType.LOGICAL_VERTICAL_CENTER);
			node.getStyleClass().add("line-ruler-text");
			return new StackPane(node);
		}

		private DoubleProperty w = new SimpleDoubleProperty(16);

		@Override
		public DoubleProperty getWidth() {
			return this.w;
		}

		@Override
		public int getOrder() {
			return 10000;
		}

		@Override
		public boolean isVisible(Set<Annotation> annotation) {
			return true;
		}

		@Override
		public void updateNode(Node node, Set<Annotation> annotation) {
			Text n = (Text) ((Pane)node).getChildren().get(0);
			annotation.stream().findFirst().ifPresent(m->{
				int nr = ((LineNrAnnotation)m).getNr();
				n.setText("" + nr);
			});
		}

		@Override
		public String toString() {
			return "LineNrAP@" + hashCode(); //$NON-NLS-1$
		}
		
		@Override
		public Optional<String> getStyleClass() {
			return Optional.of("line-number-ruler"); //$NON-NLS-1$
		}

	}

	public class LineNrAnnotationProvider implements AnnotationProvider {

		@Override
		public Set<? extends Annotation> computeAnnotations(int index) {
			return Collections.singleton(new LineNrAnnotation(index + 1));
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

	@Override
	public Subscription install(final StyledTextArea control) {
		LineNrAnnotationPresenter presenter = new LineNrAnnotationPresenter();
		LineNrAnnotationProvider provider = new LineNrAnnotationProvider();

		DoubleBinding charWidth = Util.createTextWidthBinding("C", control.fontProperty(), control.fontZoomFactorProperty());
		
		DoubleBinding width = Bindings.createDoubleBinding(()->Integer.toString(control.lineCountProperty().get()).length() * charWidth.get(), control.lineCountProperty(), charWidth);
		presenter.w.bind(width);
		control.getAnnotationProvider().add(provider);
		control.getAnnotationPresenter().add(presenter);

		return new Subscription() {
			@Override
			public void dispose() {
				presenter.w.unbind();
				width.dispose();
				control.getAnnotationProvider().remove(provider);
				control.getAnnotationPresenter().remove(presenter);
			}
		};
	}


}
