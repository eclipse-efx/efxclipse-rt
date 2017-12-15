package org.eclipse.fx.ui.controls.styledtext_ng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Range;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.Triple;
import org.eclipse.fx.core.Tuple;

import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableBooleanProperty;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class DefaultStyleProxyFactory implements StyleProxyFactory {
	private final ObservableList<Node> nodeList;
	private Map<String[], StyleProxyNode> nodeProxyCache = new HashMap<>();
	Map<String[], StyleProxyNode> scheduledForRemoval = new HashMap<>();

	public DefaultStyleProxyFactory(ObservableList<Node> nodeList) {
		this.nodeList = nodeList;
	}

	@Override
	public StyleProxy get(String[] stylenames) {
		return this.nodeProxyCache.computeIfAbsent(stylenames, st -> {
			this.scheduledForRemoval.remove(st);
			StyleProxyNode proxy = new WrappedStyleProxyNode(st);
			this.nodeList.add(proxy);
			return proxy;
		});
	}

	class WrappedStyleProxyNode extends StyleProxyNode {

		public WrappedStyleProxyNode(String[] stylenames) {
			super(stylenames);
		}

		public Subscription addRange(StyledLineRenderer renderer, Range range) {
			Subscription sub = super.addRange(renderer, range);
			return () -> {
				sub.dispose();
				if( this.ranges.isEmpty() ) {
					DefaultStyleProxyFactory.this.scheduledForRemoval.put(this.stylenames, this);
				}
			};
		}
	}

	static class StyleProxyNode extends Group implements StyleProxy {
		final Map<StyledLineRenderer,List<Range>> ranges = new HashMap<>();
		final Map<StyledLineRenderer,Map<Range,Subscription>> boldSubscriptions = new HashMap<>();
		final Map<StyledLineRenderer,Map<Range,Subscription>> italicSubscriptions = new HashMap<>();
		final Map<StyledLineRenderer,Map<Range,Subscription>> fillSubscriptions = new HashMap<>();
		final String[] stylenames;

		public StyleProxyNode(String[] stylenames) {
			this.stylenames = stylenames;
			getStyleClass().setAll(stylenames);
			setManaged(false);
			setVisible(false);
		}

		@Override
		public Subscription addRange(StyledLineRenderer renderer, Range range) {
			this.ranges.computeIfAbsent(renderer, r -> new ArrayList<>()).add(range);

			if( this.bold.get() ) {
				this.boldSubscriptions.computeIfAbsent(renderer, r -> new HashMap<>()).put(range,renderer.setBold(range));
			}

			if( this.italic.get() ) {
				this.italicSubscriptions.computeIfAbsent(renderer, r -> new HashMap<>()).put(range,renderer.setItalic(range) );
			}

			this.fillSubscriptions.computeIfAbsent(renderer, r -> new HashMap<>()).put(range, renderer.setForeground(this.fill.getValue(), range) );

			return () -> {
				List<Range> list = this.ranges.getOrDefault(renderer, new ArrayList<>());
				list.remove(range);
				if( list.isEmpty() ) {
					this.ranges.remove(renderer);
				}

				Subscription v = this.boldSubscriptions.getOrDefault(renderer, new HashMap<>()).remove(range);
				if( v != null ) {
					v.dispose();
				}

				v = this.italicSubscriptions.getOrDefault(renderer, new HashMap<>()).remove(range);
				if( v != null ) {
					v.dispose();
				}

				v = this.fillSubscriptions.getOrDefault(renderer, new HashMap<>()).remove(range);
				if( v != null ) {
					v.dispose();
				}
			};
		}

		private static StyleablePropertyFactory<StyleProxyNode> FACTORY = new StyleablePropertyFactory<>(Group.getClassCssMetaData());

		private static final CssMetaData<StyleProxyNode, Boolean> BOLD = FACTORY.createBooleanCssMetaData("-efx-styled-bold", s -> s.bold, false, false);
		private static final CssMetaData<StyleProxyNode, Boolean> ITALIC = FACTORY.createBooleanCssMetaData("-efx-styled-italic", s -> s.italic, false, false);
		private static final CssMetaData<StyleProxyNode, Paint> FILL = FACTORY.createPaintCssMetaData("-efx-fill", s -> s.fill, Color.BLACK, false);

		private final SimpleStyleableBooleanProperty bold = new SimpleStyleableBooleanProperty(BOLD, this, "bold") {
			@Override
			protected void invalidated() {
				super.invalidated();

				for( Entry<StyledLineRenderer, List<Range>> e : StyleProxyNode.this.ranges.entrySet() ) {
					e.getKey().combinedAction( () -> {
						Map<Range, Subscription> map = StyleProxyNode.this.boldSubscriptions.getOrDefault(e.getKey(), new HashMap<>());
						map.values().forEach(Subscription::dispose);
						map.clear();

						if( get() ) {
							StyleProxyNode.this.boldSubscriptions.put(e.getKey(),e.getValue().stream()
									.map( r -> new Tuple<>(r,e.getKey().setBold(r))).collect(Collectors.toMap( t -> t.value1, t -> t.value2)));
						}
					});
				}
			}
		};

		private final SimpleStyleableBooleanProperty italic = new SimpleStyleableBooleanProperty(ITALIC, this, "italic") {
			@Override
			protected void invalidated() {
				super.invalidated();

				for( Entry<StyledLineRenderer, List<Range>> e : StyleProxyNode.this.ranges.entrySet() ) {
					e.getKey().combinedAction( () -> {
						Map<Range, Subscription> map = StyleProxyNode.this.italicSubscriptions.getOrDefault(e.getKey(), new HashMap<>());
						map.values().forEach(Subscription::dispose);
						map.clear();

						if( get() ) {
							StyleProxyNode.this.italicSubscriptions.put(e.getKey(),e.getValue().stream()
									.map( r -> new Tuple<>(r,e.getKey().setItalic(r))).collect(Collectors.toMap( t -> t.value1, t -> t.value2)));
						}
					});
				}
			}
		};

		private final StyleableProperty<Paint> fill = new SimpleStyleableObjectProperty<Paint>(FILL, this, "fill", Color.BLACK) {
			@Override
			protected void invalidated() {
				super.invalidated();
				for( Entry<StyledLineRenderer, List<Range>> e : StyleProxyNode.this.ranges.entrySet() ) {
					e.getKey().combinedAction( () -> {
						Map<Range, Subscription> map = StyleProxyNode.this.fillSubscriptions.getOrDefault(e.getKey(), new HashMap<>());
						map.values().forEach(Subscription::dispose);
						map.clear();

						Paint paint = get();
						StyleProxyNode.this.fillSubscriptions.put(e.getKey(),e.getValue().stream()
								.map( r -> new Tuple<>(r,e.getKey().setForeground(paint,r))).collect(Collectors.toMap( t -> t.value1, t -> t.value2)));

					});
				}
			}
		};

		public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
			return FACTORY.getCssMetaData();
		}

		@Override
		public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
			return FACTORY.getCssMetaData();
		}
	}

}