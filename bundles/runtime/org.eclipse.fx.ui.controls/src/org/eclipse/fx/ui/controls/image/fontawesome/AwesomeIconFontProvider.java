package org.eclipse.fx.ui.controls.image.fontawesome;

import org.eclipse.fx.ui.controls.image.AwesomeIcons;
import org.eclipse.fx.ui.controls.image.spi.IconFontProvider;
import org.osgi.service.component.annotations.Component;

import javafx.scene.text.Font;

@Component(service=IconFontProvider.class)
public class AwesomeIconFontProvider extends IconFontProvider {

	private static Font font = Font.loadFont(AwesomeIconFontProvider.class.getResourceAsStream("FontAwesome.otf"), 24); //$NON-NLS-1$

	public AwesomeIconFontProvider() {

	}
	
	/**
	 * @return The font used by this font icon set
	 */
	public static Font getFont() {
		return font;
	}

	@Override
	public String getName() {
		return font.getName();
	}

	@Override
	public char map(String name) {
		AwesomeIcons i = AwesomeIcons.get(name);
		if (i != null) {
			return i.getValue();
		}
		return '?';
	}
}
