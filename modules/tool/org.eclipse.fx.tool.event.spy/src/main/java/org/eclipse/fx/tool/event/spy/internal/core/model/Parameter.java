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
package org.eclipse.fx.tool.event.spy.internal.core.model;

import java.util.Collections;
import java.util.List;

/**
 * Parameter of a captured event.
 */
public class Parameter implements IEventItem {

    private static final String EMPTY_VALUE = "";

    private final String name;
    private final Object value;

    public Parameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public PresentableItem getName() {
        return new PresentableItem(this, ItemToFilter.ParameterName, i -> ((Parameter) i).getNameInternal());
    }

    public String getNameInternal() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public PresentableItem getParam1() {
        return new PresentableItem(this, ItemToFilter.ParameterValue, i -> {
            if (((Parameter) i).getValue() == null) {
                return SpecialValue.Null.toString();
            }

            return ((Parameter) i).getValue().toString();
        });
    }

    @Override
    public PresentableItem getParam2() {
        return new PresentableItem(this,null, i -> EMPTY_VALUE);
    }

    @Override
    public List<IEventItem> getChildren() {
        return Collections.emptyList();
    }
}
