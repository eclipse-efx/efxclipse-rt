/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.internal;

import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Region;

import org.eclipse.fx.ui.controls.ETab;
import org.eclipse.fx.ui.controls.ETabFolder;

/**
 * Skin for the tab folder
 */
public class ETabFolderSkin extends SkinBase<ETabFolder> {
	
	public ETabFolderSkin(ETabFolder control) {
		super(control);
		HeaderRegion headerRegion = new HeaderRegion(control);
		getChildren().add(headerRegion);
	}

	@Override
	protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
		super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
	}
	
	static class HeaderRegion extends Region {
		private Region tabArea;
		private Region toolArea; 
		
		public HeaderRegion(ETabFolder control) {
			for( ETab tab : control.getTabs() ) {
				addTab(tab);
			}
		}
		
		private void addTab(ETab tab) {
			getChildren().add(new TabButton(tab));
		}
		
		@Override
		protected void layoutChildren() {
			super.layoutChildren();
			
		}
	}
	
	static class ContentWrapper extends Region {
		private ETab tab;
		
		@Override
		protected void layoutChildren() {
			// TODO Auto-generated method stub
			super.layoutChildren();
		}
	}
	
	static class TabButton extends Region {
		private ETab tab;
		
		private Label label; 
		
		public TabButton(ETab tab) {
			this.tab = tab;
			this.label = new Label();
			this.label.textProperty().bind(tab.textProperty());
			
			getChildren().add(label);
		}
		
		@Override
		protected void layoutChildren() {
			// TODO Auto-generated method stub
			super.layoutChildren();
		}
	}
}
