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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An event that has been captured and should be presented in the tree table view.
 */
public class CapturedEvent implements IEventItem {

    private String topic;

    private String publisherClassName = "";

    private String changedElementClassName = "";

    private List<Parameter> parameters;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setPublisherClassName(String publisherClassName) {
        this.publisherClassName = publisherClassName;
    }

    public String getPublisherClassName() {
        return publisherClassName;
    }

    public void setChangedElementClassName(String changedElementClassName) {
        this.changedElementClassName = changedElementClassName;
    }

    public String getChangedElementClassName() {
        return changedElementClassName;
    }

    public void addParameter(String name, Object value) {
        if (parameters == null) {
            parameters = new ArrayList<Parameter>();
        }
        parameters.add(new Parameter(name, value));
    }

    @SuppressWarnings("unchecked")
    public List<Parameter> getParameters() {
        return parameters != null ? parameters : Collections.EMPTY_LIST;
    }

    public boolean hasParameters() {
        return parameters != null;
    }

    @Override
    public String toString() {
        return topic;
    }

    @Override
    public PresentableItem getName() {
        return new PresentableItem(this, ItemToFilter.Topic, i -> ((CapturedEvent) i).getTopic());
    }

    @Override
    public PresentableItem getParam1() {
        return new PresentableItem(this, ItemToFilter.Publisher, i -> ((CapturedEvent) i).getPublisherClassName());
    }

    @Override
    public PresentableItem getParam2() {
        return new PresentableItem(this, ItemToFilter.ChangedElement, i -> ((CapturedEvent) i).getChangedElementClassName());
    }

    @Override
    public List<? extends IEventItem> getChildren() {
        return getParameters();
    }

}
