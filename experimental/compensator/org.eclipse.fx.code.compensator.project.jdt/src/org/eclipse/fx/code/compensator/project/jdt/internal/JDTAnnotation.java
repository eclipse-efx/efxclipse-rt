/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.project.jdt.internal;

import org.eclipse.fx.code.server.jdt.shared.Marker;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;

public class JDTAnnotation extends Annotation {
	private final Marker marker;

	public JDTAnnotation(Marker marker) {
		super("jdt.annotation."+marker.getSeverity(), false, marker.getMessage());
		this.marker = marker;
	}

	public Marker getMarker() {
		return marker;
	}
}
