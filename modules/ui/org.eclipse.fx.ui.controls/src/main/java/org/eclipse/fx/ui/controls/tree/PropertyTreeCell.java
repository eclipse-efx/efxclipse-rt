/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
//package org.eclipse.fx.ui.controls.tree;
//
//import java.util.function.Function;
//
//import org.eclipse.jdt.annotation.NonNull;
//import org.eclipse.jdt.annotation.Nullable;
//
//import javafx.beans.InvalidationListener;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.Property;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.scene.Node;
//import javafx.scene.control.TreeCell;
//
//public class PropertyTreeCell<T> extends TreeCell<T> {
//	@NonNull
//	private final ObjectProperty<@NonNull Function<@Nullable T, @Nullable Property<@Nullable CharSequence>>> labelExtractor;
//	@NonNull
//	private final ObjectProperty<@NonNull Function<@Nullable T, @Nullable Property<@Nullable Node>>> graphicExtractor;
//	@NonNull
//	private final InvalidationListener labelFunctionChangeTracker;
//
//	Property<@Nullable CharSequence> labelProperty;
//
//	/**
//	 * Create a new instance
//	 *
//	 * @param labelExtractor
//	 *            property with a function used to extract the string
//	 */
//	public PropertyTreeCell(
//			@NonNull ObjectProperty<@NonNull Function<@Nullable T, @Nullable Property<@Nullable CharSequence>>> labelExtractor) {
//		this(labelExtractor,new SimpleObjectProperty<>(i -> null));
//	}
//
//	/**
//	 * Create a new instance
//	 *
//	 * @param labelExtractor
//	 *            property with a function used to extract the string
//	 * @param graphicExtractor
//	 * 			  property with a function used to extract a graphic node
//	 */
//	public PropertyTreeCell(
//			@NonNull ObjectProperty<@NonNull Function<@Nullable T, Property<@Nullable CharSequence>>> labelExtractor,
//			@NonNull ObjectProperty<@NonNull Function<@Nullable T, Property<@Nullable Node>>> graphicExtractor) {
//		this.labelExtractor = labelExtractor;
//		this.graphicExtractor = graphicExtractor;
//		this.labelFunctionChangeTracker = ( o ) -> {
//			@Nullable
//			Property<@Nullable CharSequence> apply = this.labelExtractor.get().apply(getItem());
//		};
//	}
//
//	@Override
//	protected void updateItem(T item, boolean empty) {
//		super.updateItem(item, empty);
//		if( ! empty ) {
//			updateText(this.labelExtractor.get());
//		} else {
//			setGraphic(null);
//			setText(null);
//		}
//	}
//
//	private void updateText(@NonNull Function<@Nullable T, @Nullable Property<@Nullable CharSequence>> function) {
//		this.labelProperty = this.labelExtractor.get().apply(getItem());
//		if( this.labelProperty != null ) {
//			updateText(this.labelProperty.getValue());
//		}
//	}
//
//	private void updateText(CharSequence t) {
//
//	}
//}
