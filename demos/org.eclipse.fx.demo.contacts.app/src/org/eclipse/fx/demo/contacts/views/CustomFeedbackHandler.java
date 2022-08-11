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
package org.eclipse.fx.demo.contacts.views;

import org.eclipse.fx.emf.edit.ui.dnd.EditingDomainCellDropAdapter.IDnDFeedbackHandler;

import javafx.scene.control.Cell;
import javafx.scene.control.TableView;

/**
 * A custom {@link IDnDFeedbackHandler} that increases the padding to make room
 * for the dragged {@link Cell}. This does not work well with {@link TableView}s.
 */
public class CustomFeedbackHandler implements IDnDFeedbackHandler {

	@Override
	public void onFeedbackInsertBefore(Cell<?> cell) {
		cell.setStyle("-fx-padding: 15 3 3 3;");
	}

	@Override
	public void onFeedbackInsertAfter(Cell<?> cell) {
		cell.setStyle("-fx-padding: 3 3 15 3;");
	}

	@Override
	public void onFeedbackSelect(Cell<?> cell) {
		cell.setStyle(null);
	}

	@Override
	public void onFeedbackNone(Cell<?> cell) {
		cell.setStyle(null);
	}

}