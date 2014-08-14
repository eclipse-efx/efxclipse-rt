/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.controlprovider;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.image.FontIcon;
import org.eclipse.fx.ui.controls.image.FontIconView;
import org.eclipse.fx.ui.controls.image.spi.IconFontProvider;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;

public class FontIconViewNodeProvider implements GraphicNodeProvider {

	@Override
	public String getName() {
		return "fx.iconprovider";
	}

	@Override
	public List<String> getFileSuffix() {
		return Arrays.asList("icon");
	}
	
	public void bindIconFontProvider(IconFontProvider provider) {
		System.err.println("provider+: " + provider);
	}

	
//   supported formats:
//   generic
//   <font-uri>?iconId=<iconUTF8>
//	 bundle-resource:///User/tom/awesome.ttf?iconId=0xffa1
//
//   with supported mapping
//	 awesome = some.ttf
//	 fa-flask = 0x....
//   icon://<type>:<id>
//	 icon://awesome:fa-flask
	
	private static Pattern PATTERN_URI_MAPPING = Pattern.compile("^icon://([^:]+):([^?]+).*");
	private static Pattern PATTERN_GENERIC = Pattern.compile("^(.*)?iconId=(.+)$");
	
	@Override
	public Node getGraphicNode(URI uri) throws IOException {
		final String uriString = uri.toString();
		System.err.println("FontIconNodeProvider#getGraphicNode " + uriString);
		if (uriString.startsWith("icon://")) {
			Matcher matcher = PATTERN_URI_MAPPING.matcher(uriString);
			if (matcher.matches()) {
				String type = matcher.group(1);
				String iconName = matcher.group(2);
				System.err.println("  MATCH: " + type + " / " + iconName);
				
				FontIconView node = new FontIconView();
				System.err.println("  Icon node: " + System.identityHashCode(node));
				Font font = Font.font(type);
				System.err.println("  Setting font to " + font);
				node.setFont(font);
				System.err.println("  Setting icon to " + iconName);
				node.setIcon(FontIcon.create(iconName));
//				node.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));
//				System.err.println("  Readback: " + node.getFont());
				return node;
			}
			else {
				// error
				System.err.println("could not parse " + uriString);
			}
			
		}
		else {
			Matcher matcher = PATTERN_GENERIC.matcher(uriString);
			if (matcher.matches())  {
				String fontURI = matcher.group(1);
				String iconId = matcher.group(2);
				
				final Font font = Font.loadFont(fontURI, 24);
				FontIconView node = new FontIconView();
				node.setFont(font);
				node.setIcon(FontIcon.create(iconId.charAt(0)));
				return node;
			}
			else {
				// error
				System.err.println("  could not parse " + uriString);
			}
		}
		
		// error
		Label l = new Label();
		l.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), new Insets(0))));
		l.setMinSize(10, 10);
		return l;
	}

}
