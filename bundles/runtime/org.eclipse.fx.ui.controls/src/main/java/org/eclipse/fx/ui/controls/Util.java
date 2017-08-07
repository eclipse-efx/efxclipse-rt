/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.SystemUtils;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;
import org.eclipse.fx.core.geom.Size;
import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.BoundingBox;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * Utility methods
 *
 * @since 1.2
 */
public class Util {
	/**
	 * Tag used to exclude a node from finding
	 */
	public static final String FIND_NODE_EXCLUDE = "findNodeExclude"; //$NON-NLS-1$

	/**
	 * Boolean to indicate if mnemonic fixing is enabled
	 *
	 * @noreference
	 */
	public static final boolean MNEMONICS_FIX = !Boolean.getBoolean("efxclipse.mnemonicfix.disabled"); //$NON-NLS-1$

	/**
	 * Dump the scene graph to a formatted string
	 *
	 * @param n
	 *            the node to start with
	 * @return the dump as a formatted XML
	 */
	public static String dumpSceneGraph(Node n) {
		return new SceneGraphDumper().dump(n).toString();
	}

	static class SceneGraphDumper {
		private StringBuilder sb = new StringBuilder();
		private int ident = 0;

		public StringBuilder dump(Node n) {
			for (int i = 0; i < this.ident; i++) {
				this.sb.append("    "); //$NON-NLS-1$
			}
			this.ident++;

			this.sb.append("<" + n.getClass().getName() + " styleClass=\"" //$NON-NLS-1$ //$NON-NLS-2$
					+ n.getStyleClass() + "\">\n"); //$NON-NLS-1$
			if (n instanceof Parent) {
				for (Node subNode : ((Parent) n).getChildrenUnmodifiable()) {
					dump(subNode);
				}
			}

			this.ident--;
			for (int i = 0; i < this.ident; i++) {
				this.sb.append("    "); //$NON-NLS-1$
			}
			this.sb.append("</" + n.getClass().getName() + ">\n"); //$NON-NLS-1$ //$NON-NLS-2$

			return this.sb;
		}
	}

	/**
	 * Create a scenegraph node from the styled string
	 *
	 * @param s
	 *            the string
	 * @return a scenegraph node
	 */
	public static Node toNode(StyledString s) {
		List<Text> segList = new ArrayList<>();
		for (StyledStringSegment seg : s.getSegmentList()) {
			Text t = new Text(seg.getText());
			t.getStyleClass().addAll(seg.getStyleClass());
			segList.add(t);
		}

		TextFlow textFlow = new TextFlow(segList.toArray(new Node[0]));
		textFlow.getStyleClass().add("styled-string"); //$NON-NLS-1$
		return textFlow;
	}

	/**
	 * Find a node in all windows
	 *
	 * @param w
	 *            the preferred window
	 * @param screenX
	 *            the screen x
	 * @param screenY
	 *            the screen y
	 * @return the node or <code>null</code>
	 */
	@SuppressWarnings("deprecation")
	public static Node findNode(@Nullable Window w, double screenX, double screenY) {
		if (w != null && new BoundingBox(w.getX(), w.getY(), w.getWidth(), w.getHeight()).contains(screenX, screenY)) {
			return findNode(w.getScene().getRoot(), screenX, screenY);
		}

		Iterator<Window> impl_getWindows = JavaFXCompatUtil.getAllWindows().iterator();

		List<Window> sortedWindows = new ArrayList<>();
		Map<Window, List<Window>> parentChildRelation = new HashMap<>();

		while (impl_getWindows.hasNext()) {
			Window window = impl_getWindows.next();
			Window owner;
			if (window instanceof Stage) {
				owner = ((Stage) window).getOwner();
			} else if (window instanceof PopupWindow) {
				owner = ((PopupWindow) window).getOwnerWindow();
			} else {
				owner = null;
			}

			if (owner == null) {
				sortedWindows.add(window);
			} else {
				List<Window> list = parentChildRelation.get(owner);
				if (list == null) {
					list = new ArrayList<>();
					parentChildRelation.put(owner, list);
				}
				list.add(window);
			}
		}

		while (!parentChildRelation.isEmpty()) {
			for (Window rw : sortedWindows.toArray(new Window[0])) {
				List<Window> list = parentChildRelation.remove(rw);
				if (list != null) {
					sortedWindows.addAll(list);
				}
			}
		}

		Collections.reverse(sortedWindows);

		for (Window window : sortedWindows) {
			if (!FIND_NODE_EXCLUDE.equals(window.getUserData()) && new BoundingBox(window.getX(), window.getY(), window.getWidth(), window.getHeight()).contains(screenX, screenY)) {
				return findNode(window.getScene().getRoot(), screenX, screenY);
			}
		}

		return null;
	}

	/**
	 * Find all node at the given x/y location starting the search from the
	 * given node
	 *
	 * @param n
	 *            the node to use as the start
	 * @param screenX
	 *            the screen x
	 * @param screenY
	 *            the screen y
	 * @return the node or <code>null</code>
	 */
	public static Node findNode(Node n, double screenX, double screenY) {
		Node rv = null;
		if (!n.isVisible()) {
			return rv;
		}
		Point2D b = n.screenToLocal(screenX, screenY);
		if (n.getBoundsInLocal().contains(b) && !FIND_NODE_EXCLUDE.equals(n.getUserData())) {
			rv = n;
			if (n instanceof Parent) {
				List<Node> cList = ((Parent) n).getChildrenUnmodifiable().stream().filter(no -> no.isVisible()).collect(Collectors.toList());

				for (Node c : cList) {
					Node cn = findNode(c, screenX, screenY);
					if (cn != null) {
						rv = cn;
						break;
					}
				}
			}
		}
		return rv;
	}

	/**
	 * Get the window property of a node
	 *
	 * @param n
	 *            the node the window property to observe
	 * @return the property
	 */
	public static ObservableValue<Window> windowProperty(Node n) {
		ObjectProperty<Window> w = new SimpleObjectProperty<Window>();

		ChangeListener<Window> l = (o, oldV, newV) -> w.set(newV);

		n.sceneProperty().addListener((o, oldV, newV) -> {
			if (oldV != null) {
				oldV.windowProperty().removeListener(l);
			}

			if (newV != null) {
				newV.windowProperty().addListener(l);
			}
		});

		return w;
	}

	/**
	 * Bind the content to the source list to the target and apply the converter
	 * in between
	 *
	 * @param target
	 *            the target list
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the function used to convert
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source type
	 * @return the subscription to dispose the binding
	 * @deprecated use
	 *             {@link FXObservableUtils#bindContent(List, ObservableList, Function)}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T, E> Subscription bindContent(List<T> target, ObservableList<E> sourceList, Function<E, T> converterFunction) {
		List<T> list = sourceList.stream().map(converterFunction).collect(Collectors.toList());

		if (target instanceof ObservableList<?>) {
			((ObservableList) target).setAll(list);
		} else {
			target.clear();
			((List) target).addAll(list);
		}

		ListChangeListener<E> l = change -> {
			while (change.next()) {
				if (change.wasPermutated()) {
					target.subList(change.getFrom(), change.getTo()).clear();
					target.addAll(change.getFrom(), transformList(change.getList().subList(change.getFrom(), change.getTo()), converterFunction));
				} else {
					if (change.wasRemoved()) {
						target.subList(change.getFrom(), change.getFrom() + change.getRemovedSize()).clear();
					}
					if (change.wasAdded()) {
						target.addAll(change.getFrom(), transformList(change.getAddedSubList(), converterFunction));
					}
				}
			}
		};
		sourceList.addListener(l);
		return new Subscription() {

			@Override
			public void dispose() {
				sourceList.removeListener(l);
			}
		};
	}

	/**
	 * Transform the list to another list
	 *
	 * @param list
	 *            the list
	 * @param converterFunction
	 *            the converter function
	 * @return the list
	 */
	public static <T, E> List<T> transformList(List<? extends E> list, Function<E, T> converterFunction) {
		return list.stream().map(converterFunction).collect(Collectors.toList());
	}

	/**
	 * Install a hover callback
	 *
	 * @param node
	 *            the node the hover is installed on
	 * @param delay
	 *            the delay
	 * @param hoverConsumer
	 *            the consumer
	 * @return subscription
	 */
	public static Subscription installHoverCallback(Node node, Duration delay, Consumer<MouseEvent> hoverConsumer) {
		Timeline t = new Timeline(new KeyFrame(delay));
		AtomicReference<MouseEvent> event = new AtomicReference<>();
		t.setOnFinished(e -> {
			if (event.get() != null) {
				hoverConsumer.accept(event.get());
			}
		});

		EventHandler<MouseEvent> moveHandler = e -> {
			event.set(e);
			t.stop();
			t.playFromStart();
		};
		EventHandler<MouseEvent> exitHandler = e -> {
			t.stop();
		};

		node.addEventHandler(MouseEvent.MOUSE_MOVED, moveHandler);
		node.addEventHandler(MouseEvent.MOUSE_EXITED, exitHandler);

		return () -> {
			node.removeEventHandler(MouseEvent.MOUSE_MOVED, moveHandler);
			node.removeEventHandler(MouseEvent.MOUSE_EXITED, exitHandler);
		};
	}

	/**
	 * Enter a nested event loop
	 *
	 * @param id
	 *            the id of the nested event loop
	 * @since 2.3.0
	 */
	public static void enterNestedEventLoop(String id) {
		if (SystemUtils.isFX9()) {
			enterNestedEventLoop9(id);
		} else {
			enterNestedEventLoop8(id);
		}
	}

	private static void enterNestedEventLoop8(String id) {
		try {
			Class<?> toolkit = Class.forName("com.sun.javafx.tk.Toolkit"); //$NON-NLS-1$
			Object tk = toolkit.getMethod("getToolkit").invoke(null); //$NON-NLS-1$
			toolkit.getMethod("enterNestedEventLoop", Object.class).invoke(tk, id); //$NON-NLS-1$
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void enterNestedEventLoop9(String id) {
		try {
			Method m = Platform.class.getMethod("enterNestedEventLoop", Object.class); //$NON-NLS-1$
			m.invoke(null, id);
		} catch (Throwable t) {
			enterNestedEventLoop8(id);
		}
	}

	/**
	 * Exit the nested event loop
	 *
	 * @param id
	 *            the nested event loop
	 * @since 2.3.0
	 */
	public static void exitNestedEventLoop(String id) {
		if (SystemUtils.isFX9()) {
			exitNestedEventLoop9(id);
		} else {
			exitNestedEventLoop8(id);
		}
	}

	private static void exitNestedEventLoop8(String id) {
		try {
			Class<?> toolkit = Class.forName("com.sun.javafx.tk.Toolkit"); //$NON-NLS-1$
			Object tk = toolkit.getMethod("getToolkit").invoke(null); //$NON-NLS-1$
			toolkit.getMethod("exitNestedEventLoop", Object.class, Object.class).invoke(tk, id, null); //$NON-NLS-1$
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void exitNestedEventLoop9(String id) {
		try {
			Method m = Platform.class.getMethod("exitNestedEventLoop", Object.class, Object.class); //$NON-NLS-1$
			m.invoke(null, id, null);
		} catch (Throwable t) {
			exitNestedEventLoop8(id);
		}
	}

	/**
	 * Wait until the condition is satisfied without blocking the UI-Thread
	 *
	 * @param blockCondition
	 *            the condition
	 * @return the return value of the condition
	 * @since 2.3.0
	 * @deprecated deprecated since 3.0 to to be replaced by {@link ThreadSynchronize#block(BlockCondition)}
	 */
	@Deprecated
	public static <T> @Nullable T waitUntil(@NonNull BlockCondition<T> blockCondition) {
		AtomicReference<@Nullable T> rv = new AtomicReference<>();
		String uuid = UUID.randomUUID().toString();
		blockCondition.subscribeUnblockedCallback(new Consumer<T>() {

			@Override
			public void accept(@Nullable T value) {
				rv.set(value);
				Util.exitNestedEventLoop(uuid);
			}
		});
		Util.enterNestedEventLoop(uuid);
		return rv.get();
	}

	/**
	 * Calculate the size of the text with the given font
	 *
	 * @param text
	 *            the text
	 * @param font
	 *            the font
	 * @return the width
	 * @since 2.3.0
	 */
	public static double getTextWidth(String text, Font font, double fontZoomFactor) {
		Text t = new Text(text);
		t.setFont(Font.font(font.getName(), font.getSize() * fontZoomFactor));
		return t.getLayoutBounds().getWidth();
	}

	/**
	 * Create a binding for text width calculation.
	 *
	 * @param text
	 * @param font
	 * @return
	 */
	public static DoubleBinding createTextWidthBinding(ObservableValue<String> text, ObservableValue<Font> font, ObservableValue<Number> fontZoomFactor) {
		return Bindings.createDoubleBinding(() -> {
			return getTextWidth(text.getValue(), font.getValue(), fontZoomFactor.getValue().doubleValue());
		}, text, font, fontZoomFactor);
	}

	public static DoubleBinding createTextWidthBinding(String text, ObservableValue<Font> font, ObservableValue<Number> fontZoomFactor) {
		return Bindings.createDoubleBinding(() -> {
			return getTextWidth(text, font.getValue(), fontZoomFactor.getValue().doubleValue());
		}, font, fontZoomFactor);
	}

	public static double getTextHeight(String text, Font font, double fontZoomFactor) {
		Text t = new Text(text);
		t.setFont(Font.font(font.getName(), font.getSize() * fontZoomFactor));
		return t.getLayoutBounds().getHeight();
	}

	public static DoubleBinding createTextHeightBinding(String text, ObservableValue<Font> font, ObservableValue<Number> fontZoomFactor) {
		return Bindings.createDoubleBinding(() -> {
			return getTextHeight(text, font.getValue(), fontZoomFactor.getValue().doubleValue());
		}, font, fontZoomFactor);
	}

	public static boolean isCopyEvent(MouseEvent event) {
		if (SystemUtils.isMacOS()) {
			return event.isAltDown();
		} else {
			return event.isControlDown();
		}
	}

	private static Cache<CacheKey, Size> FONT_SIZE_CACHE;

	private static class CacheKey {
		private final Font f;
		private final char c;

		CacheKey(Font f, char c) {
			this.f = f;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.c;
			result = prime * result + ((this.f == null) ? 0 : f.hashCode());
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
			CacheKey other = (CacheKey) obj;
			if (this.c != other.c)
				return false;
			if (this.f == null) {
				if (other.f != null)
					return false;
			} else if (!this.f.equals(other.f))
				return false;
			return true;
		}
	}

	/**
	 * Get the size for the provided character
	 *
	 * @param font
	 *            the font
	 * @param c
	 *            the character
	 * @return the size
	 */
	public static Size getSize(Font font, char c) {
		if (FONT_SIZE_CACHE == null) {
			FONT_SIZE_CACHE = CacheBuilder.newBuilder().maximumSize(20).build();
		}
		Size rv = FONT_SIZE_CACHE.getIfPresent(new CacheKey(font, c));
		if (rv == null) {
			Text t = new Text(TextUtil.toString(c));
			t.setFont(font);
			FONT_SIZE_CACHE.put(new CacheKey(font, c), rv = new Size(t.prefWidth(-1), t.prefHeight(-1)));
		}

		return rv;
	}

	/**
	 * Create a simple background fill
	 *
	 * @param p
	 *            the paint
	 * @return the background
	 */
	public static Background getSimpleBackground(Paint p) {
		return new Background(new BackgroundFill(p, CornerRadii.EMPTY, Insets.EMPTY));
	}
}