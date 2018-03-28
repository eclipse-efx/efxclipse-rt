/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.preferences;

import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.text.TextUtil;

import javafx.beans.value.ObservableValue;

/**
 * Service interface providing a page to display
 */
public interface PreferencePageProvider {
	/**
	 * Checks if the page matches the keywork
	 * 
	 * @param term
	 *            the term used for selection
	 * @return <code>true</code> if matched
	 */
	public default boolean select(CharSequence term) {
		Predicate<String> wildcardFilter = TextUtil.createTextMatcher(term.toString(), true, false);
		return wildcardFilter.test(titleProperty().getValue().toString());
	}

	/**
	 * @return the title of the page
	 */
	public ObservableValue<CharSequence> titleProperty();

	/**
	 * @return the id of this page
	 */
	public String id();

	/**
	 * @return the id of the parent
	 */
	public default Optional<String> parentId(){
		return Optional.empty();
	}
	
	/**
	 * @return an optional memento used for storing
	 */
	public default Optional<Memento> memento() {
		return Optional.empty();
	}

	/**
	 * @return the type who makes up the page
	 */
	public Class<? extends PreferencePage> pageType();
}
