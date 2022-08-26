/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.ui.dialogs.Dialog;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.Node;
import javafx.stage.Window;

@SuppressWarnings("javadoc")
public class MultiMessageDialog extends Dialog {
		private Collection<MPart> parts;
		private MultiMessageDialogContent content;

		GraphicsLoader graphicsLoader;
		private List<MPart> selectedParts;
		private String message;

		public MultiMessageDialog(Window parent, Collection<MPart> parts, GraphicsLoader graphicsLoader, @NonNull String title, String message) {
			super(parent, title);
			this.parts = parts;
			this.graphicsLoader = graphicsLoader;
			this.message = message;
		}

		public List<MPart> getSelectedParts() {
			return this.selectedParts;
		}

		@Override
		protected void okPressed() {
			this.selectedParts = new ArrayList<MPart>();
			for (Row r : this.content.tabView.getItems()) {
				if (r.isSelected()) {
					this.selectedParts.add(r.element.get());
				}
			}
			super.okPressed();
		}

		@Override
		protected Node createDialogArea() {
			return this.content = new MultiMessageDialogContent(this.message,this.parts, this.graphicsLoader);
		}
	}