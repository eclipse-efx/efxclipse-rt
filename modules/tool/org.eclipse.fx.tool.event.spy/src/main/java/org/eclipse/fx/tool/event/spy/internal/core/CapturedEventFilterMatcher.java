/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.tool.event.spy.internal.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.fx.tool.event.spy.internal.core.model.CapturedEvent;
import org.eclipse.fx.tool.event.spy.internal.core.model.CapturedEventFilter;
import org.eclipse.fx.tool.event.spy.internal.core.model.ItemToFilter;
import org.eclipse.fx.tool.event.spy.internal.core.model.Operator;
import org.eclipse.fx.tool.event.spy.internal.core.model.Parameter;
import org.eclipse.fx.tool.event.spy.internal.core.model.SpecialValue;

/**
 * For filtering the captured events according to user defined filter criteria.
 */
public class CapturedEventFilterMatcher {

    public boolean matches(CapturedEvent event, CapturedEventFilter filter) {
        Object value = getItemToFilterValue(event, filter.getItemToFilter());

        boolean positive = filter.getOperator().isPositive();

        String filterCmpValue = filter.getValue();
        if (value instanceof List) {
            List<?> list = (List<?>) value;
            for (Object item : list) {
                if (!(positive ^ matches(filterCmpValue, item, filter.getOperator()))) {
                    return positive;
                }
            }
            return !positive;
        } else if (value instanceof Map) {
            Map<String, ?> list = (Map<String, ?>) value;
            String[] splitFilterCmpValues = filterCmpValue.split("=");
            if (splitFilterCmpValues.length == 2) {
                for (Map.Entry<String, ?> item : list.entrySet()) {
                    if (!(positive ^ (matches(splitFilterCmpValues[0], item.getKey(), filter.getOperator())
                            && matches(splitFilterCmpValues[1], item.getValue(), filter.getOperator())))) {
                        return positive;
                    }
                }
            }
            return !positive;
        }
        return matches(filterCmpValue, value, filter.getOperator());
    }

    private Object getItemToFilterValue(CapturedEvent event, ItemToFilter itemToFilter) {
        if (itemToFilter.equals(ItemToFilter.Topic)) {
            return event.getTopic();
        }
        if (itemToFilter.equals(ItemToFilter.Publisher)) {
            return event.getPublisherClassName();
        }
        if (itemToFilter.equals(ItemToFilter.ChangedElement)) {
            return event.getChangedElementClassName();
        }
        if (itemToFilter.equals(ItemToFilter.ParameterName)) {
            List<String> names = new ArrayList<String>();
            for (Parameter parameter : event.getParameters()) {
                names.add(parameter.getNameInternal());
            }
            return names;
        }
        if (itemToFilter.equals(ItemToFilter.ParameterValue)) {
            List<Object> values = new ArrayList<Object>();
            for (Parameter parameter : event.getParameters()) {
                values.add(parameter.getValue());
            }
            return values;
        }
        if (itemToFilter.equals(ItemToFilter.ParameterNameAndValue)) {
            Map<String, Object> nameAndValues = new HashMap<>();
            for (Parameter parameter : event.getParameters()) {                
                nameAndValues.put(parameter.getNameInternal().trim(),
                        (parameter.getValue() == null ? SpecialValue.Null : parameter.getValue().toString().trim()));
            }
            return nameAndValues;
        }

        throw new IllegalArgumentException("Not supported item to filter found: " + itemToFilter.toString());
    }

    private boolean matches(String expected, Object current, Operator operator) {
        if (SpecialValue.Null.toString().equalsIgnoreCase(expected)) {
            return operator.isPositive() ? matchesToNull(current) : !matchesToNull(current);
        }
        if (SpecialValue.EmptyString.toString().equalsIgnoreCase(expected)) {
            return operator.isPositive() ? matchesToEmptyString(current) : !matchesToEmptyString(current);
        }
        if (Operator.Equals.equals(operator)) {
            return equalsTo(expected, current);
        }
        if (Operator.NotEquals.equals(operator)) {
            return !equalsTo(expected, current);
        }
        if (Operator.Contains.equals(operator)) {
            return contains(expected, current);
        }
        if (Operator.NotContains.equals(operator)) {
            return !contains(expected, current);
        }
        if (Operator.StartsWith.equals(operator)) {
            return startsWith(expected, current);
        }
        if (Operator.NotStartsWith.equals(operator)) {
            return !startsWith(expected, current);
        }

        throw new IllegalArgumentException("Not supported operator found: " + operator);
    }

    private boolean matchesToEmptyString(Object current) {
        return current != null && current instanceof String && current.toString().length() == 0;
    }

    private boolean matchesToNull(Object current) {
        return current == null || current.toString().equalsIgnoreCase(SpecialValue.Null.toString());
    }

    private boolean equalsTo(String expected, Object current) {
        return current != null && expected.equalsIgnoreCase(current.toString());
    }

    private boolean contains(String expected, Object current) {
        return current != null && current.toString().toLowerCase().contains(expected.toLowerCase());
    }

    private boolean startsWith(String expected, Object current) {
        return current != null && current.toString().toLowerCase().startsWith(expected.toLowerCase());
    }
}
