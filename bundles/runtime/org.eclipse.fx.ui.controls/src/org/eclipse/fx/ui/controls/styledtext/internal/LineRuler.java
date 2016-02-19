package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.eclipse.fx.ui.controls.styledtext.VerticalLineFlow;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter.LayoutHint;

import javafx.scene.Node;

public class LineRuler extends VerticalLineFlow<Integer, Annotation>{

	private LineRulerAnnotationPresenter.LayoutHint h;

	public LineRuler(LineRulerAnnotationPresenter.LayoutHint h, Function<Integer, Set<Annotation>> converter, Predicate<Set<Annotation>> needsPresentation, Supplier<Node> nodeFactory, BiConsumer<Node, Set<Annotation>> nodePopulator) {
		super(converter, needsPresentation, nodeFactory, nodePopulator);
		this.h = h;
	}

	@Override
	protected void layoutChildren() {
		this.activeNodes.entrySet().forEach(e -> {
			if (!yOffsetData.containsKey(e.getKey())) {
				System.err.println("NO DATA FOR " + e);
				return;
			}
			double x = 0;
			double y = yOffsetData.get(e.getKey());
			double width = getWidth();
			double height = getLineHeight();

			if (h == LayoutHint.ALIGN_RIGHT) {
				e.getValue().autosize();
				double w = e.getValue().getBoundsInLocal().getWidth();

				x = width - w;
				width = w;
			}
			else if (h == LayoutHint.ALIGN_CENTER) {
				e.getValue().autosize();
				double w = e.getValue().getBoundsInLocal().getWidth();

				x = width / 2 - w / 2;
				width = w;
			}

			e.getValue().resizeRelocate(x, y, width, height);
		});
	}


}
