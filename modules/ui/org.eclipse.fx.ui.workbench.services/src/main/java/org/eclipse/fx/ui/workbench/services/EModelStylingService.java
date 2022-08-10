/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.services;

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

/**
 * Service to set style classes on model elements.
 */
public interface EModelStylingService {
	
	/**
	 * Add style classes to the given element.
	 * 
	 * @param element
	 * 		the element to add style classes to
	 * @param classes
	 * 		the style classes to add
	 */
	public void addStyles(MUIElement element, String... classes);
	
	/**
	 * Remove style classes from the given element.
	 * 
	 * @param element
	 * 		the element to remove style classes from
	 * @param classes
	 * 		the style classes to remove
	 */
	public void removeStyles(MUIElement element, String... classes);
	
	/**
	 * Returns the style classes currently assigned to an element.
	 * 
	 * @param element
	 * 		the element to get the style classes of
	 * @return
	 * 		the style classes
	 */
	public List<String> getStyles(MUIElement element);
	
	/**
	 * Returns the style classes from a list of element tags.
	 * 
	 * @param tags
	 * 		A list of tags
	 * @return
	 * 		the list of style classes found in tags
	 */
	public List<String> getStylesFromTags(List<String> tags);
}
