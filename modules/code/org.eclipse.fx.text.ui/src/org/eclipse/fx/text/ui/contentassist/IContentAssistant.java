/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
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
package org.eclipse.fx.text.ui.contentassist;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.eclipse.fx.text.ui.ITextViewer;

import javafx.geometry.Point2D;

public interface IContentAssistant {
	void install(ITextViewer textViewer);
	void showContextInformation(IContextInformation info);
	
	void configureWindowSize(Supplier<Point2D> windowSizeRetriever, Consumer<Point2D> windowSizePersister);
}
