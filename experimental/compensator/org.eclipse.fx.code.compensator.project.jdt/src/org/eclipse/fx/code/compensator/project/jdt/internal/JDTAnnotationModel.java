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

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.editor.Constants;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.server.jdt.shared.Marker;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;

public class JDTAnnotationModel extends AnnotationModel {
	private final JDTServerInput input;
	private final IEventBroker eventBroker;

	@Inject
	public JDTAnnotationModel(Input<?> input, IEventBroker eventBroker) {
		this.input = (JDTServerInput) input;
		this.eventBroker = eventBroker;
		this.eventBroker.subscribe(Constants.EDITOR_DOCUMENT_SAVED, e -> requestProblems());
		requestProblems();
	}

	void requestProblems() {
		try {
			removeAllAnnotations();
			Future<List<Marker>> markers = input.server.getMarkers(input.openFile.get());
			List<Marker> list = markers.get();
			//TODO We should get smarter!
			// removeAllAnnotations();
			for( Marker m : list ) {
				addAnnotation(new JDTAnnotation(m), new Position(m.getStartPos(),m.getEndPos()-m.getStartPos()));
			}
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
