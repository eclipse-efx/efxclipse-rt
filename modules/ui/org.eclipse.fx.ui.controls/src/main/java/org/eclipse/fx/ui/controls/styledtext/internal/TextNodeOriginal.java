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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.styledtext.DecorationStrategyFactory;
import org.eclipse.fx.ui.controls.styledtext.model.DecorationStrategy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.ParsedValue;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

@SuppressWarnings("javadoc")
public class TextNodeOriginal extends HBox implements TextNode {

	@SuppressWarnings("null")
	@NonNull
	private static final CssMetaData<TextNodeOriginal, @NonNull Paint> FILL = new CssMetaData<TextNodeOriginal, @NonNull Paint>("-fx-fill", StyleConverter.getPaintConverter(), Color.BLACK) { //$NON-NLS-1$

		@Override
		public boolean isSettable(TextNodeOriginal styleable) {
			return !styleable.fillProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@NonNull Paint> getStyleableProperty(TextNodeOriginal styleable) {
			return (StyleableProperty<@NonNull Paint>) styleable.fill;
		}

	};
	@SuppressWarnings("null")
	@NonNull
	final ObjectProperty<@NonNull Paint> fill = new SimpleStyleableObjectProperty<>(FILL, this, "fill", Color.BLACK); //$NON-NLS-1$

	private static String[] BASIC_STRING_CACHE = new String[256];

	private static String toString(char c) {
		String rv = null;
		if( c < BASIC_STRING_CACHE.length ) {
			rv = BASIC_STRING_CACHE[c];
			if( rv == null ) {
				BASIC_STRING_CACHE[c] = String.valueOf(c);
			}
		}
		if( rv == null ) {
			rv = String.valueOf(c);
		}
		return rv;
	}

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
				FACTORIES = ServiceUtils.getServiceList(getClass(), DecorationStrategyFactory.class).stream().sorted((f1, f2) -> -1 * Integer.compare(f1.getRanking(), f2.getRanking())).collect(Collectors.toMap(f -> f.getDecorationStrategyName(), f -> f));
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
	private static final CssMetaData<TextNodeOriginal, @Nullable DecorationStrategy> DECORATIONSTRATEGY = new CssMetaData<TextNodeOriginal, @Nullable DecorationStrategy>("-efx-decoration", CONVERTER, null) { //$NON-NLS-1$

		@Override
		public boolean isSettable(TextNodeOriginal node) {
			return !node.decorationStrategyProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@Nullable DecorationStrategy> getStyleableProperty(TextNodeOriginal node) {
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

//	private ReuseCache<Text> letterCache = new ReuseCache<Text>(this::createText);

	private int startOffset;
	private List<Integer> tabPositions = new ArrayList<>();
	private String originalText;
//	private final HBox textNode;
//	private final Text textNode;

	private List<Text> activeLetters = new ArrayList<>();
	private ReuseCache<Text> cache;

	private final IntegerProperty tabCharAdvance;

	/**
	 * Create a new styled text node
	 *
	 * @param text
	 *            the text
	 * @param tabCharAdvance tab advance
	 */
	public TextNodeOriginal(String text, IntegerProperty tabCharAdvance) {
		this.tabCharAdvance = tabCharAdvance;
		setAlignment(Pos.CENTER_LEFT);
		setMinWidth(Region.USE_COMPUTED_SIZE);
		this.cache = new ReuseCache<>(()->{
			Text letter = new Text();
			letter.setBoundsType(TextBoundsType.LOGICAL_VERTICAL_CENTER);
			return letter;
		});
		this.cache.addOnActivate(node->{
			getChildren().add(node);
		});
		this.cache.addOnRelease(node-> {
			getChildren().remove(node);
		});
//		cache.addOnClear(node->getChildren().remove(node));

		getStyleClass().add("styled-text-node"); //$NON-NLS-1$
		this.originalText = text;

		rebuildText(text);

		// TODO We need to trigger this from ContentView / StyledTextAreaSkin
		InvalidationListener listener = o -> {
			rebuildText(this.originalText);
		};
		this.parentProperty().addListener( e -> {
			if( this.getParent() == null ) {
				this.tabCharAdvance.removeListener(listener);
			} else {
				this.tabCharAdvance.addListener(listener);
			}
		});

		this.cache.addOnActivate((n)->{
			((Text)n).fillProperty().bind(fillProperty());

		});
		this.cache.addOnRelease(n->{
			((Text)n).fillProperty().unbind();
		});

		this.decorationStrategy.addListener(this::handleDecorationChange);
	}

	public Subscription setStyledRange(String clazz, int start, int end) {
		return null;
	}

	public void updateText(String text) {
		rebuildText(text);
		this.originalText = text;
	}

	private void rebuildText(String text) {
		for (Text t : this.activeLetters) {
			this.cache.releaseElement(t);
		}
		this.activeLetters.clear();
		for( char c : processText(text).toCharArray() ) {
			Text textNode = this.cache.getElement();
			textNode.setText(toString(c));
			this.activeLetters.add(textNode);
		}
	}

	private String processText(String text) {
		String tmp = text;
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < this.tabCharAdvance.get(); i++) {
			b.append(" "); //$NON-NLS-1$
		}
		int position = -1;
		this.tabPositions.clear();
		while ((position = tmp.indexOf('\t')) != -1) {
			tmp = tmp.replaceFirst("\t", b.toString()); //$NON-NLS-1$
			this.tabPositions.add(Integer.valueOf(position));
		}
		return tmp;
	}

	private void handleDecorationChange(ObservableValue<? extends DecorationStrategy> observable, DecorationStrategy oldValue, DecorationStrategy newValue) {
		if (oldValue != null) {
			oldValue.unattach(this, this);
		}

		if (newValue != null) {
			newValue.attach(this, this);
		}
	}

	void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	/**
	 * @return the start offset in the file
	 */
	@Deprecated
	public int getStartOffset() {
		return this.startOffset;
	}

	/**
	 * @return the end offset in the file
	 */
	@Deprecated
	public int getEndOffset() {
		return this.startOffset + getText().length();
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
		return "'" + this.originalText + "'";  //$NON-NLS-1$//$NON-NLS-2$
	}

	@Override
	public ObservableList<Node> getChildren() {
		return super.getChildren();
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return this.originalText;
	}

//	protected double getFixedLetterWidth() {
//		return 8;
//	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();

//		double off = 0;
//
//		for (Text letter : this.activeLetters) {
//			letter.setLayoutX(off);
//			off += getFixedLetterWidth();
//		}

//		this.textNode.relocate(0, 0);
		DecorationStrategy decorationStrategy2 = this.decorationStrategy.get();
		if (decorationStrategy2 != null) {
			decorationStrategy2.layout(this, this);
		}
	}

	/**
	 * Get the caret index at the given point
	 *
	 * @param point
	 *            the point relative to this node
	 * @return the index or <code>-1</code>
	 */
	public int getCaretIndexAtPoint(Point2D point) {
		Point2D local = this.sceneToLocal(localToScene(point));

		Optional<Node> charNode = this.getChildren().stream().filter( n -> n.getBoundsInParent().contains(local)).findFirst();
		if( charNode.isPresent() ) {
			Node node = charNode.get();
			int idx = this.getChildren().indexOf(node);
			Bounds bounds = node.getBoundsInParent();

			// if it is the 2nd half of the character
			if( bounds.getMinX() + bounds.getWidth() / 2 < local.getX() ) {
				idx += 1;
			}

			int toRemove = 0;
			for (Integer i : this.tabPositions) {
				if (i.intValue() <= idx && idx < i.intValue() + this.tabCharAdvance.get()) {
					toRemove += idx - i.intValue();
					// If we are in the 2nd half of the tab we
					// simply move one past the value
					if ((idx - i.intValue()) % this.tabCharAdvance.get() >= this.tabCharAdvance.get() / 2) {
						idx += 1;
					}
					break;
				} else if (i.intValue() < idx) {
					toRemove += this.tabCharAdvance.get() - 1;
				}
			}
			idx -= toRemove;
			return idx;
		} else {
		}

//		@SuppressWarnings("deprecation")
//		HitInfo info = this.textNode.impl_hitTestChar(this.textNode.sceneToLocal(localToScene(point)));
//		if (info != null) {
//			int idx = info.getInsertionIndex();
//			int toRemove = 0;
//			for (Integer i : this.tabPositions) {
//				if (i.intValue() <= idx && idx < i.intValue() + this.tabCharAdvance.get()) {
//					toRemove += idx - i.intValue();
//					// If we are in the 2nd half of the tab we
//					// simply move one past the value
//					if ((idx - i.intValue()) % this.tabCharAdvance.get() >= this.tabCharAdvance.get() / 2) {
//						idx += 1;
//					}
//					break;
//				} else if (i.intValue() < idx) {
//					toRemove += this.tabCharAdvance.get() - 1;
//				}
//			}
//			idx -= toRemove;
//			return idx;
//		}
		return -1;
	}

	/**
	 * Find the x coordinate where we the character for the given index starts
	 *
	 * @param index
	 *            the index
	 * @return the location or <code>0</code> if not found
	 */
	public double getCharLocation(int index) {
		int realIndex = index;
		for (Integer i : this.tabPositions) {
			if (i.intValue() < realIndex) {
				realIndex += this.tabCharAdvance.get() - 1;
			}
		}

		if( realIndex >= 0 && realIndex < this.getChildren().size() ) {
			return this.localToParent(this.getChildren().get(realIndex).getBoundsInParent()).getMinX();
		} else if( ! this.getChildren().isEmpty() ) {
			return this.localToParent(this.getChildren().get(this.getChildren().size()-1).getBoundsInParent()).getMaxX();
		}

		return 0.0;

//		this.textNode.setImpl_caretPosition(realIndex);
//		PathElement[] pathElements = this.textNode.getImpl_caretShape();
//		for (PathElement e : pathElements) {
//			if (e instanceof MoveTo) {
//				return this.textNode.localToParent(((MoveTo) e).getX(), 0).getX();
//			}
//		}

	}
}
