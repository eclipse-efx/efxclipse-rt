/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.tool.event.spy.internal.core.model;

/**
 * Lists all item that can be searched by.
 */
public enum ItemToFilter {
    NotSelected("-- item to filter --", null),

    Topic("Topic", Operator.Equals),

    ParameterName("Parameter name", Operator.Equals),

    ParameterNameAndValue("Parameter name and value", Operator.Contains),

    ParameterValue("Some parameter value", Operator.Contains),

    Publisher("Event publisher", Operator.Contains),

    ChangedElement("Changed element", Operator.Contains);

    private String text;

    private Operator defaultOperator;

    private ItemToFilter(String text, Operator defaultOperator) {
        this.text = text;
        this.defaultOperator = defaultOperator;
    }

    public Operator getDefaultOperator() {
        return defaultOperator;
    }

    @Override
    public String toString() {
        return text;
    }

    public static ItemToFilter toItem(String text) {
        for (ItemToFilter item : values()) {
            if (item.text.equals(text)) {
                return item;
            }
        }
        throw new IllegalArgumentException(String.format("%s not found for: %s", ItemToFilter.class.getSimpleName(), text));
    }
}