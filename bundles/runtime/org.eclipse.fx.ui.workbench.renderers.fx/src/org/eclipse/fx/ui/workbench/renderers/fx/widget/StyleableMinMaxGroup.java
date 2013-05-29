/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.StringProperty;
import javafx.css.CssMetaData;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.css.StyleableStringProperty;
import javafx.scene.layout.StackPane;

/**
 * @author tomschindl
 *
 */
public class StyleableMinMaxGroup extends MinMaxGroup {
	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
	
	private static final CssMetaData<StyleableMinMaxGroup,String> MAXIMIZE_GRAPHIC = 
            new CssMetaData<StyleableMinMaxGroup,String>("-fx-graphic",
                StringConverter.INSTANCE) {

            @Override
            public boolean isSettable(StyleableMinMaxGroup n) {
                // Note that we care about the graphic, not imageUrl
                return n.maximizeGraphic == null || !n.maximizeGraphic.isBound();
            }

			@SuppressWarnings("unchecked")
			@Override
            public StyleableProperty<String> getStyleableProperty(StyleableMinMaxGroup n) {
                return (StyleableProperty<String>)n.maximizeUrlProperty();
            }
        };
	
	static {
		final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<CssMetaData<? extends Styleable, ?>>(StackPane.getClassCssMetaData());
		STYLEABLES = Collections.unmodifiableList(styleables);
	}
		
	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return STYLEABLES;
	}
	
	private StringProperty maximizeUrl;
	
	private StringProperty maximizeUrlProperty() {
		if( maximizeUrl == null ) {
			maximizeUrl = new StyleableStringProperty() {

				@Override
				public CssMetaData<? extends Styleable, String> getCssMetaData() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Object getBean() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return null;
				}
				
			};
		}
		return maximizeUrl;
	}
	
	
	
	static class StringConverter extends StyleConverter<String, String> {
		final static StringConverter INSTANCE = new StringConverter();
	}
}
