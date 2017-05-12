package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.ui.controls.styledtext.DecorationStrategyFactory;
import org.eclipse.fx.ui.controls.styledtext.model.DecorationStrategy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.sun.javafx.scene.text.HitInfo;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.CssMetaData;
import javafx.css.ParsedValue;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class TextNodeSingle extends Pane implements TextNode {

	@SuppressWarnings("null")
	@NonNull
	private static final CssMetaData<TextNodeSingle, @NonNull Paint> FILL = new CssMetaData<TextNodeSingle, @NonNull Paint>("-fx-fill", StyleConverter.getPaintConverter(), Color.BLACK) { //$NON-NLS-1$

		@Override
		public boolean isSettable(TextNodeSingle styleable) {
			return !styleable.fillProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@NonNull Paint> getStyleableProperty(TextNodeSingle styleable) {
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
	private static final CssMetaData<TextNodeSingle, @Nullable DecorationStrategy> DECORATIONSTRATEGY = new CssMetaData<TextNodeSingle, @Nullable DecorationStrategy>("-efx-decoration", CONVERTER, null) { //$NON-NLS-1$

		@Override
		public boolean isSettable(TextNodeSingle node) {
			return !node.decorationStrategyProperty().isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@Nullable DecorationStrategy> getStyleableProperty(TextNodeSingle node) {
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


	private final IntegerProperty tabCharAdvance;
	private String originalText;
	private final Text text;
	private final List<Integer> tabPositions = new ArrayList<>();

	public TextNodeSingle(String text, IntegerProperty tabCharAdvance) {
		this.tabCharAdvance = tabCharAdvance;
		this.originalText = text;
		this.text = new Text();
		this.text.setBoundsType(TextBoundsType.LOGICAL_VERTICAL_CENTER);
		this.text.fillProperty().bind(fillProperty());
		getStyleClass().add("styled-text-node"); //$NON-NLS-1$
//		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		rebuildText(text);
		getChildren().add(this.text);

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

		this.decorationStrategy.addListener(this::handleDecorationChange);
	}

	private void handleDecorationChange(ObservableValue<? extends DecorationStrategy> observable, DecorationStrategy oldValue, DecorationStrategy newValue) {
		if (oldValue != null) {
			oldValue.unattach(this, this);
		}

		if (newValue != null) {
			newValue.attach(this, this);
		}
	}

	private void rebuildText(String text) {
		this.text.setText( processText(text));
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

	@Override
	public void updateText(String text) {
		rebuildText(text);
		this.originalText = text;
	}

	@Override
	public int getCaretIndexAtPoint(Point2D point) {
		@SuppressWarnings("deprecation")
		HitInfo info = this.text.impl_hitTestChar(this.text.sceneToLocal(localToScene(point)));
		if (info != null) {
			int idx = info.getInsertionIndex();
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
		}
		return -1;
	}

	@Override
	protected double computePrefWidth(double height) {
		return this.text.prefWidth(-1);
	}

	@Override
	protected double computePrefHeight(double width) {
		return this.text.prefHeight(-1);
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		text.resizeRelocate(0, 0, text.prefWidth(-1), text.prefHeight(-1));
	}

	@Override
	public String getText() {
		return this.originalText;
	}

	@Override
	public double getCharLocation(int index) {
		int realIndex = index;
		for (Integer i : this.tabPositions) {
			if (i.intValue() < realIndex) {
				realIndex += this.tabCharAdvance.get() - 1;
			}
		}

		this.text.setImpl_caretPosition(realIndex);
		PathElement[] pathElements = this.text.getImpl_caretShape();
		for (PathElement e : pathElements) {
			if (e instanceof MoveTo) {
				double x = this.localToParent(((MoveTo) e).getX(), 0).getX();
				return x;
			}
		}
		return 0.0;
	}

}
