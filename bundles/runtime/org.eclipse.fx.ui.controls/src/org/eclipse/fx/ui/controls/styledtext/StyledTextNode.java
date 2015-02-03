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
package org.eclipse.fx.ui.controls.styledtext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.ParsedValue;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import org.eclipse.fx.core.Util;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.sun.javafx.css.converters.PaintConverter;
import com.sun.javafx.scene.text.HitInfo;

/**
 * A node who allows to decorate the text
 * 
 * @since 2.0
 */
@SuppressWarnings("restriction")
public class StyledTextNode extends Region {

	/**
	 * A strategy to decorate the text
	 */
	public interface DecorationStrategy {
		/**
		 * Attach the decoration on the text
		 * 
		 * @param node
		 *            the node the decoration is attached to
		 * @param textNode
		 *            the text node decorated
		 */
		public void attach(StyledTextNode node, Text textNode);

		/**
		 * Remove the decoration from the text
		 * 
		 * @param node
		 *            the node the decoration is attached to
		 * @param textNode
		 *            the text node decorated
		 */
		public void unattach(StyledTextNode node, Text textNode);

		/**
		 * Layout the decoration
		 * 
		 * @param node
		 *            the node the layout pass is done on
		 * @param textNode
		 *            the text node decorated
		 */
		public void layout(StyledTextNode node, Text textNode);
	}

	private final Text textNode;

	@SuppressWarnings("null")
	private static final CssMetaData<StyledTextNode, @NonNull Paint> FILL = new CssMetaData<StyledTextNode, @NonNull Paint>("-fx-fill", PaintConverter.getInstance(), Color.BLACK) { //$NON-NLS-1$

		@Override
		public boolean isSettable(StyledTextNode styleable) {
			return !styleable.fillProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@NonNull Paint> getStyleableProperty(StyledTextNode styleable) {
			return (StyleableProperty<@NonNull Paint>) styleable.fill;
		}

	};
	@SuppressWarnings("null")
	@NonNull
	final ObjectProperty<@NonNull Paint> fill = new SimpleStyleableObjectProperty<>(FILL, this, "fill", Color.BLACK); //$NON-NLS-1$

	/**
	 * The paint used to fill the text
	 * 
	 * @return the property to observe
	 */
	public final @NonNull ObjectProperty<@NonNull Paint> fillProperty() {
		return (ObjectProperty<@NonNull Paint>) this.fill;
	}

	/**
	 * @return the paint used to fill the text
	 */
	public final @NonNull Paint getFill() {
		return this.fillProperty().get();
	}

	/**
	 * Set a new paint
	 * 
	 * @param color
	 *            the paint used to fill the text
	 */
	public final void setFill(final @NonNull Paint color) {
		this.fillProperty().set(color);
	}

	static class DecorationStyleConverter extends StyleConverter<ParsedValue<?, DecorationStrategy>, DecorationStrategy> {
		private static Map<String, DecorationStrategyFactory> FACTORIES;

		@SuppressWarnings("null")
		@Override
		public DecorationStrategy convert(ParsedValue<ParsedValue<?, DecorationStrategy>, DecorationStrategy> value, Font font) {
			String definition = value.getValue() + ""; //$NON-NLS-1$

			if (FACTORIES == null) {
				FACTORIES = Util.lookupServiceList(getClass(), DecorationStrategyFactory.class).stream().sorted((f1, f2) -> -1 * Integer.compare(f1.getRanking(), f2.getRanking())).collect(Collectors.toMap(f -> f.getDecorationStrategyName(), f -> f));
			}

			String type;
			if (definition.contains("(")) { //$NON-NLS-1$
				type = definition.substring(0, definition.indexOf('('));
			} else {
				type = definition + ""; //$NON-NLS-1$
			}

			DecorationStrategyFactory strategy = FACTORIES.get(type);
			if (strategy != null) {
				return strategy.create(definition.contains("(") ? definition.substring(definition.indexOf('(') + 1, definition.lastIndexOf(')')) : null); //$NON-NLS-1$
			}

			return null;
		}
	}

	@NonNull
	private static final DecorationStyleConverter CONVERTER = new DecorationStyleConverter();

	@SuppressWarnings("null")
	@NonNull
	private static final CssMetaData<StyledTextNode, @Nullable DecorationStrategy> DECORATIONSTRATEGY = new CssMetaData<StyledTextNode, @Nullable DecorationStrategy>("-efx-decoration", CONVERTER, null) { //$NON-NLS-1$

		@Override
		public boolean isSettable(StyledTextNode node) {
			return !node.decorationStrategyProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@Nullable DecorationStrategy> getStyleableProperty(StyledTextNode node) {
			return (StyleableProperty<@Nullable DecorationStrategy>) node.decorationStrategyProperty();
		}

	};

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(Region.getClassCssMetaData());
		styleables.add(DECORATIONSTRATEGY);
		styleables.add(FILL);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return getClassCssMetaData();
	}

	private @NonNull ObjectProperty<@Nullable DecorationStrategy> decorationStrategy = new SimpleStyleableObjectProperty<@Nullable DecorationStrategy>(DECORATIONSTRATEGY, this, "decorationStrategy"); //$NON-NLS-1$

	/**
	 * The current strategy used for decoration
	 * 
	 * @return the property to observe
	 */
	public final @NonNull ObjectProperty<@Nullable DecorationStrategy> decorationStrategyProperty() {
		return this.decorationStrategy;
	}

	/**
	 * @return strategy used for decoration
	 */
	public final @Nullable DecorationStrategy getDecorationStrategy() {
		return this.decorationStrategyProperty().get();
	}

	/**
	 * Set a new strategy used for decoration
	 * 
	 * @param strategy
	 *            the strategy
	 */
	public final void setDecorationStrategy(final @Nullable DecorationStrategy strategy) {
		this.decorationStrategyProperty().set(strategy);
	}

	private int startOffset;

	/**
	 * Create a new styled text node
	 * 
	 * @param text
	 *            the text
	 */
	public StyledTextNode(String text) {
		getStyleClass().add("styled-text-node"); //$NON-NLS-1$
		this.textNode = new Text(text);
		this.textNode.fillProperty().bind(fillProperty());
		getChildren().add(this.textNode);
		this.decorationStrategy.addListener(this::handleDecorationChange);
	}

	private void handleDecorationChange(ObservableValue<? extends DecorationStrategy> observable, DecorationStrategy oldValue, DecorationStrategy newValue) {
		if (oldValue != null) {
			oldValue.unattach(this, this.textNode);
		}

		if (newValue != null) {
			newValue.attach(this, this.textNode);
		}
	}

	void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	int getStartOffset() {
		return this.startOffset;
	}

	int getEndOffset() {
		return this.startOffset + getText().length();
	}

	/**
	 * Find the x coordinate where we the character for the given index starts
	 * 
	 * @param index
	 *            the index
	 * @return the location or <code>0</code> if not found
	 */
	@SuppressWarnings("deprecation")
	public double getCharLocation(int index) {
		this.textNode.setImpl_caretPosition(index);
		PathElement[] pathElements = this.textNode.getImpl_caretShape();
		for (PathElement e : pathElements) {
			if (e instanceof MoveTo) {
				return this.textNode.localToParent(((MoveTo) e).getX(), 0).getX();
			}
		}

		return 0.0;
	}

	/**
	 * Check if the text node intersects with the start and end locations
	 * 
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return <code>true</code> if intersects
	 */
	public boolean intersectOffset(int start, int end) {
		if (getStartOffset() > end) {
			return false;
		} else if (getEndOffset() < start) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.textNode.toString();
	}

	@Override
	public ObservableList<Node> getChildren() {
		return super.getChildren();
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return this.textNode.getText();
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		this.textNode.relocate(0, 0);
		DecorationStrategy decorationStrategy2 = this.decorationStrategy.get();
		if (decorationStrategy2 != null) {
			decorationStrategy2.layout(this, this.textNode);
		}

	}

	// private Path createZigZag(Point2D from, Point2D to, double period) {
	// double len = from.distance(to);
	//
	// Point2D dir = to.subtract(from).normalize();
	// Point2D up = new Point2D(-dir.getY(), dir.getX());
	//
	// Path path = new Path();
	//
	// Point2D cur = from.add(up.multiply(period / 2));
	//
	// path.getElements().add(new MoveTo(cur.getX(), cur.getY()));
	//
	// int s = 0;
	// double dist = 0;
	// while (dist < len) {
	// if (s % 2 == 0) {
	// // up
	// cur = cur.add(dir.multiply(period / 2)).add(up.multiply(period / 2));
	// } else if (s % 2 == 1) {
	// // down
	// cur = cur.add(dir.multiply(period / 2)).add(up.multiply(-period / 2));
	// }
	//
	// path.getElements().add(new LineTo(cur.getX(), cur.getY()));
	// s++;
	// dist += period / 2;
	// }
	//
	// return path;
	// }
	//
	// private Path createSine(Point2D from, Point2D to, double period) {
	// double len = from.distance(to);
	//
	// Point2D dir = to.subtract(from).normalize();
	// Point2D up = new Point2D(-dir.getY(), dir.getX());
	//
	// Path path = new Path();
	//
	// Point2D cur = from.add(up.multiply(period / 2));
	//
	// path.getElements().add(new MoveTo(cur.getX(), cur.getY()));
	//
	// int s = 0;
	// double dist = 0;
	// while (dist < len) {
	// if (s % 2 == 0) {
	// // up
	// Point2D control = cur.add(dir.multiply(period /
	// 4)).add(up.multiply(period / 4));
	// cur = cur.add(dir.multiply(period / 2));
	//
	// path.getElements().add(new QuadCurveTo(control.getX(), control.getY(),
	// cur.getX(), cur.getY()));
	// } else if (s % 2 == 1) {
	// // down
	// Point2D control = cur.add(dir.multiply(period /
	// 4)).add(up.multiply(-period / 4));
	// cur = cur.add(dir.multiply(period / 2));
	//
	// path.getElements().add(new QuadCurveTo(control.getX(), control.getY(),
	// cur.getX(), cur.getY()));
	// }
	//
	// s++;
	// dist += period / 2;
	// }
	//
	// return path;
	// }

	/**
	 * Get the caret index at the given point
	 * 
	 * @param point
	 *            the point relative to this node
	 * @return the index or <code>-1</code>
	 */
	public int getCaretIndexAtPoint(Point2D point) {
		@SuppressWarnings("deprecation")
		HitInfo info = this.textNode.impl_hitTestChar(this.textNode.sceneToLocal(localToScene(point)));
		if (info != null) {
			return info.getInsertionIndex();
		}
		return -1;
	}
}