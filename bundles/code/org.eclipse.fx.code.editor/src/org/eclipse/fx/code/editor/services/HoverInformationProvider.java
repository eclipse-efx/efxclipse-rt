/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.services;

import java.util.Set;

import org.eclipse.fx.text.hover.AnnotationHoverProvider;
import org.eclipse.fx.text.hover.DocumentHoverProvider;
import org.eclipse.jface.text.IRegion;

@Deprecated
public interface HoverInformationProvider {
	public CharSequence getHoverInformation(String partitionType, IRegion region);
	public IRegion getHoverRegion(String partitionType, int offset);

	DocumentHoverProvider getDocumentHoverProvider();
	Set<AnnotationHoverProvider> getAnnotationHoverProviders();

}
