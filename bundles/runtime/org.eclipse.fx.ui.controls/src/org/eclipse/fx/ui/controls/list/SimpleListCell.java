/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.list;

import java.util.List;
import java.util.function.Function;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import org.eclipse.fx.ui.controls.styledtext.StyledLabel;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A cell who knows how to deal {@link StyledString}
 *
 * @param <T>
 *            the domain type
 * @since 1.2
 */
public class SimpleListCell<T> extends ListCell<T> {
	@NonNull
	private final Function<@Nullable T, @Nullable CharSequence> labelExtractor;
	@NonNull
	private final Function<@Nullable T, @Nullable Node> graphicExtractor;
	@NonNull
	private final Function<@Nullable T, @NonNull List<@NonNull String>> cssClassProvider;

	/**
	 * Create a new instance
	 *
	 * @param labelExtractor
	 *            extract the text from the domain object
	 * @param cssClassProvider
	 *            get the CSS classes for the given domain object
	 */
	public SimpleListCell(
			@NonNull Function<@Nullable T, @Nullable CharSequence> labelExtractor,
			@NonNull Function<@Nullable T, @NonNull List<@NonNull String>> cssClassProvider) {
		this(labelExtractor, i -> null, cssClassProvider);
	}

	/**
	 * Create a new instance
	 *
	 * @param labelExtractor
	 *            extract the text from the domain object
	 * @param graphicExtractor
	 *            extracts the graphic from the domain object
	 * @param cssClassProvider
	 *            get the CSS classes for the given domain object
	 */
	public SimpleListCell(
			@NonNull Function<@Nullable T, @Nullable CharSequence> labelExtractor,
			@NonNull Function<@Nullable T, @Nullable Node> graphicExtractor,
			@NonNull Function<@Nullable T, @NonNull List<@NonNull String>> cssClassProvider) {
		this.labelExtractor = labelExtractor;
		this.graphicExtractor = graphicExtractor;
		this.cssClassProvider = cssClassProvider;
	}

	@Override
	protected void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);
		if (!empty) {
			CharSequence t = this.labelExtractor.apply(item);
			if (t == null) {
				setGraphic(null);
			} else if (t instanceof StyledString) {
				StyledLabel l = new StyledLabel((StyledString) t);
				l.getStyleClass().addAll(this.cssClassProvider.apply(item));
				Node g = this.graphicExtractor.apply(item);
				if( g != null ) {
					l.setGraphic(g);
				}
				setGraphic(l);
			} else {
				Label l = new Label(t.toString());
				l.getStyleClass().addAll(this.cssClassProvider.apply(item));
				Node g = this.graphicExtractor.apply(item);
				if( g != null ) {
					l.setGraphic(g);
				}
				setGraphic(l);
			}
		} else {
			setGraphic(null);
		}
	}
}
