/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter.LayoutHint;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.text.Font;

@SuppressWarnings("javadoc")
public class LineRuler extends VerticalLineFlow<Integer, Annotation>{

	private LineRulerAnnotationPresenter.LayoutHint h;

	private DoubleProperty fixedWidth = new SimpleDoubleProperty(this, "fixedWidth"); //$NON-NLS-1$

	private DoubleProperty yOffset = new SimpleDoubleProperty(this, "yOffset"); //$NON-NLS-1$

	private ObjectProperty<Font> font = new SimpleObjectProperty<>(this, "font", Font.getDefault()); //$NON-NLS-1$

	public DoubleProperty yOffsetProperty() {
		return this.yOffset;
	}


	public LineRuler(LineRulerAnnotationPresenter.LayoutHint h, Function<Integer, Set<Annotation>> converter, Predicate<Set<Annotation>> needsPresentation, Supplier<Node> nodeFactory, BiConsumer<Node, Set<Annotation>> nodePopulator) {
		super(converter, needsPresentation, nodeFactory, nodePopulator);
		this.h = h;

		this.yOffset.addListener((x, o, n)->{
			requestLayout();
		});
	}

	@Override
	protected double computeMinWidth(double height) {
		return this.fixedWidth.get();
	}

	@Override
	protected double computeMaxWidth(double height) {
		return this.fixedWidth.get();
	}

	public DoubleProperty fixedWidthProperty() {
		return this.fixedWidth;
	}

	@Override
	protected void layoutChildren() {
		this.activeNodes.entrySet().forEach(e -> {
//			if (!this.yOffsetData.containsKey(e.getKey())) {
//				return;
//			}
			double x = 0;
			//double y = this.yOffsetData.getOrDefault(e.getKey(),Double.valueOf(0.0)).doubleValue();

			double y = - this.yOffset.get() + e.getKey() * this.lineHeightProperty().get();

			double width = getWidth();
			double height = getLineHeight();

			if (this.h == LayoutHint.ALIGN_RIGHT) {
				e.getValue().autosize();
				double w = e.getValue().getBoundsInLocal().getWidth();

				x = width - w;
				width = w;
			}
			else if (this.h == LayoutHint.ALIGN_CENTER) {
				e.getValue().autosize();
				double w = e.getValue().getBoundsInLocal().getWidth();

				x = width / 2 - w / 2;
				width = w;
			}

			double dy = 0; //height - e.getValue().getBoundsInLocal().getHeight();

			e.getValue().resizeRelocate(x, y + dy, width, height);
		});
	}


}
