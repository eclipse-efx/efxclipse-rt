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
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import org.eclipse.fx.ui.controls.styledtext.internal.TextNode;
import org.eclipse.fx.ui.controls.styledtext.model.DecorationStrategy;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Strategy who creates an underlined text
 */
@Component
public class UnderlineStrategyFactory implements DecorationStrategyFactory {

	@Override
	public int getRanking() {
		return 0;
	}

	@Override
	public @NonNull String getDecorationStrategyName() {
		return "underline"; //$NON-NLS-1$
	}

	@Override
	public DecorationStrategy create(String definition) {
		return new UnderlineStrategy();
	}

	static class UnderlineStrategy implements DecorationStrategy {
		@Override
		public void attach(Pane node, TextNode textNode) {
			Line l = (Line) textNode.getUserData();
			if( l == null ) {
				l = new Line();
				l.setMouseTransparent(true);
				l.setManaged(false);
				l.setStartY(textNode.getBoundsInLocal().getHeight() - 2);
				l.strokeProperty().bind(textNode.fillProperty());
				l.setEndY(textNode.getBoundsInLocal().getHeight() - 2 );
				l.setEndX(textNode.getBoundsInLocal().getWidth());
				//l.setTranslateY(textNode.getBaselineOffset() + 2.0);
				textNode.setUserData(l);

			}
			node.getChildren().add(l);
		}

		@Override
		public void unattach(Pane node, TextNode textNode) {
			Line l = (Line) textNode.getUserData();
			if( l != null ) {
				textNode.setUserData(null);
				node.getChildren().remove(l);
				l.fillProperty().unbind();
			}
		}

		@Override
		public void layout(Pane node, TextNode textNode) {
			Line l = (Line) textNode.getUserData();
			if( l != null ) {
				l.setEndX(node.getWidth());
			}
		}

	}

}
