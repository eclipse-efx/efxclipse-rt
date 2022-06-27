/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *     Martin Bluehweis<martin.bluehweis@bestsolution.at> - improvements
 *******************************************************************************/
package org.eclipse.fx.ui.controls.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.eclipse.fx.core.observable.FXObservableUtil.Instance;
import org.eclipse.jdt.annotation.NonNull;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Helper APIs when working with {@link TableView}
 * 
 * @since 3.1.0
 */
public class TableViewUtil {
	/**
	 * Properties of a {@link TableView} one can capture in an {@link Memento}
	 * 
	 * @since 3.1.0
	 */
	public enum TableView_Properties {
		/**
		 * Width of the column
		 */
		COLUMN_WIDTH,
		/**
		 * Column order
		 */
		COLUMN_ORDER,
		/**
		 * Is column visible
		 */
		COLUMN_VISIBLE
	}

	private static final double DEFAULT = Double.NEGATIVE_INFINITY;

	private static final int VISIBLE_DEFAULT = 0;
	private static final int VISIBLE_YES = 1;
	private static final int VISIBLE_NO = 2;

	private static final String AUTOCAPTURE_KEY = "autoCapture"; //$NON-NLS-1$
	private static final @NonNull String COLUMN_ORDER_KEY = "column_order"; //$NON-NLS-1$

	/**
	 * Restore the state of the {@link TableView} and use the
	 * {@link TableColumn#getId()} for the lookup
	 * 
	 * @param view
	 *            the view
	 * @param m
	 *            the memento used to retrieve stored data from
	 * @param properties
	 *            list of properties to restore or empty to restore all possible
	 *            properties
	 * @return the view you passed for fluent API useage
	 */
	public static <S> TableView<S> restoreState(TableView<S> view, Memento m, TableView_Properties... properties) {
		return restoreState(view, m, TableColumn::getId, properties);
	}

	/**
	 * Restore the state of the {@link TableView}
	 * 
	 * @param view
	 *            the view
	 * @param m
	 *            the memento used to retrieve stored data from
	 * @param columnKeyProvider
	 *            function used to compute the id for a column
	 * @param properties
	 *            list of properties to restore or empty to restore all possible
	 *            properties
	 * @return the view you passed for fluent API useage
	 */
	public static <S> TableView<S> restoreState(TableView<S> view, Memento m, Function<TableColumn<S, ?>, String> columnKeyProvider, TableView_Properties... properties) {
		Map<String, TableColumn<S, ?>> idToNodeMap = view.getColumns().stream().filter(c -> columnKeyProvider.apply(c) != null).collect(Collectors.toMap(columnKeyProvider, c -> c));
		Map<TableColumn<S, ?>, String> nodeToIdMap = idToNodeMap.entrySet().stream().collect(Collectors.toMap(Entry::getValue, Entry::getKey));

		@SuppressWarnings("unchecked")
		final List<String> savedOrder = m.get(COLUMN_ORDER_KEY, List.class, Collections.emptyList());
		
		if( savedOrder == null ) {
			throw new IllegalStateException();
		}

		view.getColumns().addListener((ListChangeListener<TableColumn<S, ?>>) change -> {
			change.reset();
			while (change.next()) {

				if (change.wasAdded()) {
					change.getAddedSubList().forEach(col -> {
						idToNodeMap.put(columnKeyProvider.apply(col), col);
						nodeToIdMap.put(col, columnKeyProvider.apply(col));
						restoreStateForColumn(m, nodeToIdMap, col, properties);
						if (isPropertySet(properties, TableView_Properties.COLUMN_ORDER) && !change.wasRemoved()) {
							Collections.sort(view.getColumns(), (c1, c2) -> {
								return savedOrder.indexOf(columnKeyProvider.apply(c1)) - savedOrder.indexOf(columnKeyProvider.apply(c2));
							});
						}
					});
				}
				if (change.wasRemoved()) {
					change.getRemoved().forEach(col -> {
						idToNodeMap.remove(columnKeyProvider.apply(col));
						nodeToIdMap.remove(col);
					});
				}
			}
		});

		for (TableColumn<S, ?> c : view.getColumns()) {
			restoreStateForColumn(m, nodeToIdMap, c, properties);
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_ORDER)) {
			List<String> currentOrder = view.getColumns().stream().map(columnKeyProvider).collect(Collectors.toList());
			@SuppressWarnings("unchecked")
			List<String> restoredOrder = m.get(COLUMN_ORDER_KEY, List.class, currentOrder);
			if (!currentOrder.equals(restoredOrder)) {
				// Unable to restore if the column count matches
				if (restoredOrder != null && currentOrder.size() == restoredOrder.size()) {
					List<TableColumn<S, ?>> newOrder = new ArrayList<>();
					for (String key : restoredOrder) {
						TableColumn<S, ?> column = idToNodeMap.get(key);
						// Unknown column we can not restore the width
						if (column == null) {
							break;
						}

						newOrder.add(column);
					}

					if (newOrder.size() == view.getColumns().size()) {
						view.getColumns().setAll(newOrder);
					}
				}
			}
		}
		return view;
	}

	private static <S> void restoreStateForColumn(Memento m, Map<TableColumn<S, ?>, String> nodeToIdMap, TableColumn<S, ?> c, TableView_Properties... properties) {
		String key = nodeToIdMap.get(c);

		if (key == null) {
			return;
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_WIDTH)) {
			@SuppressWarnings("null")
			double val = m.get(key(key, TableView_Properties.COLUMN_WIDTH), DEFAULT);
			if (val != DEFAULT) {
				c.setPrefWidth(val);
			}
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_VISIBLE)) {
			@SuppressWarnings("null")
			int val = m.get(key(key, TableView_Properties.COLUMN_VISIBLE), VISIBLE_DEFAULT);
			if (val != VISIBLE_DEFAULT) {
				c.setVisible(val == VISIBLE_YES);
			}
		}
	}

	/**
	 * Capture the state of the {@link TableView} and use the
	 * {@link TableColumn#getId()} for the lookup
	 * 
	 * @param view
	 *            the view the state is captured of
	 * @param m
	 *            the memento used to store the state
	 * @param properties
	 *            list of properties to restore or empty to restore all possible
	 *            properties
	 * @return the view you passed for fluent API useage
	 */
	public static <S> TableView<S> captureState(TableView<S> view, Memento m, TableView_Properties... properties) {
		return captureState(view, m, TableColumn::getId, properties);
	}

	/**
	 * Capture the state of the {@link TableView}
	 * 
	 * @param view
	 *            the view the state is captured of
	 * @param m
	 *            the memento used to store the state
	 * @param columnKeyProvider
	 *            function used to compute the id for a column
	 * @param properties
	 *            list of properties to restore or empty to restore all possible
	 *            properties
	 * @return the view you passed for fluent API useage
	 */
	public static <S> TableView<S> captureState(TableView<S> view, Memento m, Function<TableColumn<S, ?>, String> columnKeyProvider, TableView_Properties... properties) {
		Map<TableColumn<S, ?>, String> nodeToIdMap = view.getColumns().stream().collect(Collectors.toMap(c -> c, columnKeyProvider));

		view.getColumns().addListener((ListChangeListener<TableColumn<S, ?>>) change -> {
			change.reset();
			while (change.next()) {
				if (change.wasAdded()) {
					change.getAddedSubList().forEach(col -> {
						nodeToIdMap.put(col, columnKeyProvider.apply(col));
						captureStateForColumn(m, nodeToIdMap, col, properties);
					});
				}
			}
		});

		for (TableColumn<S, ?> c : view.getColumns()) {
			captureStateForColumn(m, nodeToIdMap, c, properties);
		}
		return view;
	}

	@SuppressWarnings("null")
	private static <S> void captureStateForColumn(Memento m, Map<TableColumn<S, ?>, String> nodeToIdMap, TableColumn<S, ?> c, TableView_Properties... properties) {
		String key = nodeToIdMap.get(c);
		if (key == null) {
			return;
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_WIDTH)) {
			m.put(key(key, TableView_Properties.COLUMN_WIDTH), c.getWidth());
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_VISIBLE)) {
			m.put(key(key, TableView_Properties.COLUMN_VISIBLE), c.isVisible() ? VISIBLE_YES : VISIBLE_NO);
		}
	}

	/**
	 * Enabled automatic capturing of property changes and use the
	 * {@link TableColumn#getId()} for the lookup
	 * 
	 * @param view
	 *            the view
	 * @param m
	 *            the memento
	 * @param properties
	 *            list of properties to restore or empty to restore all possible
	 *            properties
	 * @return subscription object who can be disposed to end the capturing
	 */
	public static <S> Subscription enableAutomaticCaptureing(TableView<S> view, Memento m, TableView_Properties... properties) {
		return enableAutomaticCaptureing(view, m, TableColumn::getId, properties);
	}

	/**
	 * Enabled automatic capturing of property changes
	 * 
	 * @param view
	 *            the view
	 * @param m
	 *            the memento
	 * @param columnKeyProvider
	 *            function used to compute the id for a column
	 * @param properties
	 *            list of properties to restore or empty to restore all possible
	 *            properties
	 * @return subscription object who can be disposed to end the capturing
	 */
	public static <S> Subscription enableAutomaticCaptureing(TableView<S> view, Memento m, Function<TableColumn<S, ?>, String> columnKeyProvider, TableView_Properties... properties) {
		if (view.getProperties().containsKey(AUTOCAPTURE_KEY)) {
			((FXObservableUtil.Instance) view.getProperties().get(AUTOCAPTURE_KEY)).dispose();
		}
		FXObservableUtil.Instance i = new FXObservableUtil.Instance();
		for (TableColumn<S, ?> c : view.getColumns()) {
			captureColumnState(i, m, c, columnKeyProvider, properties);
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_ORDER)) {
			i.onChange(view.getColumns(), c -> {
				while (c.next()) {
					if (c.wasAdded()) {
						c.getAddedSubList().forEach(cc -> captureColumnState(i, m, cc, columnKeyProvider, properties));
					}
					if (c.wasRemoved()) {
						c.getRemoved().forEach(cc -> {
							if (cc == null) {
								return;
							}
							Subscription.disposeIfExists((Subscription) cc.getProperties().get(TableView_Properties.COLUMN_WIDTH));
							Subscription.disposeIfExists((Subscription) cc.getProperties().get(TableView_Properties.COLUMN_VISIBLE));
						});
					}
					if (c.wasPermutated() || c.wasAdded() && c.wasRemoved()) {
						m.put(COLUMN_ORDER_KEY, view.getColumns().stream().map(columnKeyProvider).collect(Collectors.toList()), ObjectSerializer.JAXB_SERIALIZER);
					}
				}
			});
		}

		view.getProperties().put(AUTOCAPTURE_KEY, i);
		return () -> {
			FXObservableUtil.Instance r = (Instance) view.getProperties().get(AUTOCAPTURE_KEY);
			if (r == i) {
				view.getProperties().remove(AUTOCAPTURE_KEY);
				i.dispose();
			}
		};
	}

	@SuppressWarnings("null")
	private static <S> void captureColumnState(FXObservableUtil.Instance i, Memento m, TableColumn<S, ?> c, Function<TableColumn<S, ?>, String> columnKeyProvider, TableView_Properties... properties) {
		if (isPropertySet(properties, TableView_Properties.COLUMN_WIDTH)) {
			c.getProperties().put(TableView_Properties.COLUMN_WIDTH, i.onChange(c.widthProperty(), v -> m.put(key(columnKeyProvider.apply(c), TableView_Properties.COLUMN_WIDTH), v.doubleValue())));
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_VISIBLE)) {
			c.getProperties().put(TableView_Properties.COLUMN_VISIBLE, i.onChange(c.visibleProperty(), v -> m.put(key(columnKeyProvider.apply(c), TableView_Properties.COLUMN_VISIBLE), v.booleanValue() ? VISIBLE_YES : VISIBLE_NO)));
		}
	}

	private static String key(String key, Enum<?> property) {
		return key + "_" + property.name(); //$NON-NLS-1$
	}

	private static boolean isPropertySet(TableView_Properties[] properties, TableView_Properties property) {
		return properties.length == 0 || Arrays.asList(properties).contains(property);
	}
}
