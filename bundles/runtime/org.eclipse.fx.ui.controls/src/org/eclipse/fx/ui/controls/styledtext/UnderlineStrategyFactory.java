/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import org.eclipse.fx.ui.controls.styledtext.StyledTextNode.DecorationStrategy;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

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
		public void attach(StyledTextNode node, Text textNode) {
			Line l = (Line) textNode.getUserData();
			if( l == null ) {
				l = new Line();
				l.setManaged(false);
				l.setEndX(textNode.getBoundsInLocal().getWidth());
				l.setTranslateY(textNode.getBaselineOffset() + 2.0);
				textNode.setUserData(l);
			}
			node.getChildren().add(l);
		}

		@Override
		public void unattach(StyledTextNode node, Text textNode) {
			Line l = (Line) textNode.getUserData();
			if( l != null ) {
				textNode.setUserData(null);
				node.getChildren().remove(l);
			}
		}

		@Override
		public void layout(StyledTextNode node, Text textNode) {
			Line l = (Line) textNode.getUserData();
			if( l != null ) {
				l.setEndX(node.getWidth());
			}
		}

	}

}
