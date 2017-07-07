/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.table;

import java.util.ArrayList;
import java.util.Arrays;
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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Helper APIs when working with {@link TableView}
 * 
 * @since 3.1.0
 */
public class TableUtil {
	/**
	 * Properties of a {@link TableView} one can capture in an memento
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
		Map<String, TableColumn<S, ?>> idToNodeMap = view.getColumns().stream().collect(Collectors.toMap(columnKeyProvider, c -> c));
		Map<TableColumn<S, ?>, String> nodeToIdMap = idToNodeMap.entrySet().stream().collect(Collectors.toMap(Entry::getValue, Entry::getKey));

		for (TableColumn<S, ?> c : view.getColumns()) {
			String key = nodeToIdMap.get(c);

			if (key == null) {
				continue;
			}

			if (isPropertySet(properties, TableView_Properties.COLUMN_WIDTH)) {
				double val = m.get(key(key, TableView_Properties.COLUMN_WIDTH), DEFAULT);
				if (val != DEFAULT) {
					c.setPrefWidth(val);
				}
			}

			if (isPropertySet(properties, TableView_Properties.COLUMN_VISIBLE)) {
				int val = m.get(key(key, TableView_Properties.COLUMN_VISIBLE), VISIBLE_DEFAULT);
				if (val != VISIBLE_DEFAULT) {
					c.setVisible(val == VISIBLE_YES);
				}
			}
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_ORDER)) {
			List<String> currentOrder = view.getColumns().stream().map(columnKeyProvider).collect(Collectors.toList());
			@SuppressWarnings("unchecked")
			List<String> restoredOrder = m.get("column_order", List.class, currentOrder); //$NON-NLS-1$
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

		for (TableColumn<S, ?> c : view.getColumns()) {
			String key = nodeToIdMap.get(c);
			if (key == null) {
				continue;
			}

			if (isPropertySet(properties, TableView_Properties.COLUMN_WIDTH)) {
				m.put(key(key, TableView_Properties.COLUMN_WIDTH), c.getWidth());
			}

			if (isPropertySet(properties, TableView_Properties.COLUMN_VISIBLE)) {
				m.put(key(key, TableView_Properties.COLUMN_VISIBLE), c.isVisible() ? VISIBLE_YES : VISIBLE_NO);
			}
		}
		if (isPropertySet(properties, TableView_Properties.COLUMN_ORDER)) {
			m.put("column_order", view.getColumns().stream().map(nodeToIdMap::get).collect(Collectors.toList()), ObjectSerializer.JAXB_SERIALIZER); //$NON-NLS-1$
		}
		return view;
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
		if( view.getProperties().containsKey(AUTOCAPTURE_KEY) ) {
			((FXObservableUtil.Instance)view.getProperties().get(AUTOCAPTURE_KEY)).dispose();
		}
		FXObservableUtil.Instance i = new FXObservableUtil.Instance();
		for (TableColumn<S, ?> c : view.getColumns()) {
			captureColumnState(i, m, c, columnKeyProvider, properties);
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_ORDER)) {
			i.onChange(view.getColumns(), c -> {
				while (c.next()) {
					c.getAddedSubList().forEach(cc -> captureColumnState(i, m, cc, columnKeyProvider, properties));
					c.getRemoved().forEach(cc -> {
						if( cc == null ) {
							return;
						}
						Subscription.disposeIfExists((Subscription) cc.getProperties().get(TableView_Properties.COLUMN_WIDTH));
						Subscription.disposeIfExists((Subscription) cc.getProperties().get(TableView_Properties.COLUMN_VISIBLE));
					});
				}

				m.put("column_order", view.getColumns().stream().map(columnKeyProvider).collect(Collectors.toList()), ObjectSerializer.JAXB_SERIALIZER); //$NON-NLS-1$
			});
		}

		view.getProperties().put(AUTOCAPTURE_KEY, i);
		return () -> {
			FXObservableUtil.Instance r = (Instance) view.getProperties().get(AUTOCAPTURE_KEY);
			if( r == i ) {
				view.getProperties().remove(AUTOCAPTURE_KEY);
				i.dispose();
			}
		};
	}

	private static <S> void captureColumnState(FXObservableUtil.Instance i, Memento m, TableColumn<S, ?> c, Function<TableColumn<S, ?>, String> columnKeyProvider, TableView_Properties... properties) {
		if (isPropertySet(properties, TableView_Properties.COLUMN_WIDTH)) {
			c.getProperties().put(TableView_Properties.COLUMN_WIDTH, i.onChange(c.widthProperty(), v -> m.put(key(columnKeyProvider.apply(c), TableView_Properties.COLUMN_WIDTH), v.doubleValue())));
		}

		if (isPropertySet(properties, TableView_Properties.COLUMN_VISIBLE)) {
			c.getProperties().put(TableView_Properties.COLUMN_VISIBLE, i.onChange(c.visibleProperty(), v -> m.put(key(columnKeyProvider.apply(c), TableView_Properties.COLUMN_VISIBLE), v.booleanValue() ? VISIBLE_YES : VISIBLE_NO)));
		}
	}

	private static @NonNull String key(String key, Enum<?> property) {
		return key + "_" + property.name(); //$NON-NLS-1$
	}

	private static boolean isPropertySet(TableView_Properties[] properties, TableView_Properties property) {
		return properties.length == 0 || Arrays.asList(properties).contains(property);
	}
}
