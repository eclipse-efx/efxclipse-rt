/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.animation.morph;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Interpolatable;
import javafx.animation.Transition;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

/**
 * Transition for paths
 */
public class PathMorphTransition extends Transition {
	private final List<PathElement> sourceElements;
	private final List<PathElement> targetElements;
	private final Path pathNode;

	private List<Interpolatable<? extends PathElement>> interpolateList = new ArrayList<>();

	/**
	 * Create a transition
	 *
	 * @param sourceElements
	 *            the source elements
	 * @param targetElements
	 *            the target elements
	 * @param duation
	 *            the duration
	 * @param pathNode
	 *            the path not the morph is done on
	 */
	public PathMorphTransition(List<PathElement> sourceElements, List<PathElement> targetElements, Duration duation, Path pathNode) {
		this.pathNode = pathNode;
		setCycleDuration(duation);

		if (sourceElements.size() != targetElements.size()) {
			throw new IllegalArgumentException("Only equal paths are allowed"); //$NON-NLS-1$
		}

		for (int i = 0; i < sourceElements.size(); i++) {
			PathElement sourceElement = sourceElements.get(i);
			PathElement targetElement = targetElements.get(i);
			if (sourceElement.getClass() != targetElement.getClass()) {
				throw new IllegalArgumentException("Only equal paths are allowed"); //$NON-NLS-1$
			}
			if (sourceElement instanceof ArcTo) {
				this.interpolateList.add(new ArcToInterpolatable((ArcTo) sourceElement));
			} else if (sourceElement instanceof CubicCurveTo) {
				this.interpolateList.add(new CubicCurveToInterpolatable((CubicCurveTo) sourceElement));
			} else if (sourceElement instanceof HLineTo) {
				this.interpolateList.add(new HLineToInterpolatable((HLineTo) sourceElement));
			} else if (sourceElement instanceof LineTo) {
				this.interpolateList.add(new LineToInterpolatable((LineTo) sourceElement));
			} else if (sourceElement instanceof MoveTo) {
				this.interpolateList.add(new MoveToInterpolatable((MoveTo) sourceElement));
			} else if (sourceElement instanceof QuadCurveTo) {
				this.interpolateList.add(new QuadCurveToInterpolatable((QuadCurveTo) sourceElement));
			} else if (sourceElement instanceof VLineTo) {
				this.interpolateList.add(new VLineToInterpolatable((VLineTo) sourceElement));
			}
		}

		this.sourceElements = sourceElements;
		this.targetElements = targetElements;
	}

	@Override
	public void play() {
		super.play();
	}

	@Override
	protected void interpolate(double frac) {
		List<PathElement> elements = new ArrayList<PathElement>(this.sourceElements.size());
		for (int i = 0; i < this.interpolateList.size(); i++) {
			@SuppressWarnings("unchecked")
			Interpolatable<PathElement> interpolatable = (Interpolatable<PathElement>) this.interpolateList.get(i);
			elements.add(interpolatable.interpolate(this.targetElements.get(i), frac));
		}
		this.pathNode.getElements().setAll(elements);
	}

	static class ArcToInterpolatable implements Interpolatable<ArcTo> {
		private final ArcTo source;

		public ArcToInterpolatable(ArcTo source) {
			this.source = source;
		}

		@Override
		public ArcTo interpolate(ArcTo endValue, double t) {
			ArcTo rv = new ArcTo(this.source.getRadiusX() + (endValue.getRadiusX() - this.source.getRadiusX()) * t, this.source.getRadiusY() + (endValue.getRadiusY() - this.source.getRadiusY()) * t, this.source.getXAxisRotation() + (endValue.getXAxisRotation() - this.source.getXAxisRotation()) * t,
					this.source.getX() + (endValue.getX() - this.source.getX()) * t, this.source.getY() + (endValue.getY() - this.source.getY()) * t, this.source.isLargeArcFlag(), this.source.isSweepFlag());
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

	static class ClosePathInterpolatable implements Interpolatable<ClosePath> {

		@Override
		public ClosePath interpolate(ClosePath endValue, double t) {
			return new ClosePath();
		}
	}

	static class CubicCurveToInterpolatable implements Interpolatable<CubicCurveTo> {
		private final CubicCurveTo source;

		public CubicCurveToInterpolatable(CubicCurveTo source) {
			this.source = source;
		}

		@Override
		public CubicCurveTo interpolate(CubicCurveTo endValue, double t) {
			CubicCurveTo rv = new CubicCurveTo(this.source.getControlX1() + (endValue.getControlX1() - this.source.getControlX1()) * t, this.source.getControlY1() + (endValue.getControlY1() - this.source.getControlY1()) * t, this.source.getControlX2()
					+ (endValue.getControlX2() - this.source.getControlX2()) * t, this.source.getControlY2() + (endValue.getControlY2() - this.source.getControlY2()) * t, this.source.getX() + (endValue.getX() - this.source.getX()) * t, this.source.getY() + (endValue.getY() - this.source.getY()) * t);
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

	static class HLineToInterpolatable implements Interpolatable<HLineTo> {
		private final HLineTo source;

		public HLineToInterpolatable(HLineTo source) {
			this.source = source;
		}

		@Override
		public HLineTo interpolate(HLineTo endValue, double t) {
			HLineTo rv = new HLineTo(this.source.getX() + (endValue.getX() - this.source.getX()) * t);
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

	static class LineToInterpolatable implements Interpolatable<LineTo> {
		private final LineTo source;

		public LineToInterpolatable(LineTo source) {
			this.source = source;
		}

		@Override
		public LineTo interpolate(LineTo endValue, double t) {
			LineTo rv = new LineTo(this.source.getX() + (endValue.getX() - this.source.getX()) * t, this.source.getY() + (endValue.getY() - this.source.getY()) * t);
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

	static class MoveToInterpolatable implements Interpolatable<MoveTo> {
		private final MoveTo source;

		public MoveToInterpolatable(MoveTo source) {
			this.source = source;
		}

		@Override
		public MoveTo interpolate(MoveTo endValue, double t) {
			MoveTo rv = new MoveTo(this.source.getX() + (endValue.getX() - this.source.getX()) * t, this.source.getY() + (endValue.getY() - this.source.getY()) * t);
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

	static class QuadCurveToInterpolatable implements Interpolatable<QuadCurveTo> {
		private final QuadCurveTo source;

		public QuadCurveToInterpolatable(QuadCurveTo source) {
			this.source = source;
		}

		@Override
		public QuadCurveTo interpolate(QuadCurveTo endValue, double t) {
			QuadCurveTo rv = new QuadCurveTo(this.source.getControlX() + (endValue.getControlX() - this.source.getControlX()) * t, this.source.getControlY() + (endValue.getControlY() - this.source.getControlY()) * t, this.source.getX() + (endValue.getX() - this.source.getX()) * t,
					this.source.getY() + (endValue.getY() - this.source.getY()) * t);
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

	static class VLineToInterpolatable implements Interpolatable<VLineTo> {
		private VLineTo source;

		public VLineToInterpolatable(VLineTo source) {
			this.source = source;
		}

		@Override
		public VLineTo interpolate(VLineTo endValue, double t) {
			VLineTo rv = new VLineTo(this.source.getY() + (endValue.getY() - this.source.getY()) * t);
			rv.setAbsolute(this.source.isAbsolute());
			return rv;
		}
	}

}
