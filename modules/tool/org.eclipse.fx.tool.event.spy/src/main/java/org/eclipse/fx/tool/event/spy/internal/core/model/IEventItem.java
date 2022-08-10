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

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Common interface for items presentable in the treeview.
 */
public interface IEventItem {

    class PresentableItem {

        private final IEventItem item;
        private final Optional<ItemToFilter> itemToFilter;
        private final Function<IEventItem, String> f;

        PresentableItem(IEventItem item, ItemToFilter itemToFilter, Function<IEventItem, String> f) {
            this.item = item;
            this.f = f;
            this.itemToFilter = Optional.ofNullable(itemToFilter);
        }

        @Override
        public String toString() {
            return f.apply(item);
        }

        public String getTooltip() {
            return itemToFilter.map(f -> f.toString()).orElse(null);
        }
    }

    PresentableItem getName();

    PresentableItem getParam1();

    PresentableItem getParam2();

    List<? extends IEventItem> getChildren();
}
