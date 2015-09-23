package org.eclipse.fx.ui.controls.image.fontawesome;

import org.eclipse.fx.ui.controls.image.spi.IconFontProvider;
import org.osgi.service.component.annotations.Component;

import javafx.scene.text.Font;

@Component(service=IconFontProvider.class)
public class AwesomeIconFontProvider extends IconFontProvider {
	public static String FONT_NAME;
	public static String FONT_FAMILY;

	static {
		Font font = Font.loadFont(AwesomeIconFontProvider.class.getResourceAsStream("FontAwesome.otf"), 24);
		FONT_NAME = font.getName();
		FONT_FAMILY = font.getFamily();
	}

	public AwesomeIconFontProvider() {

	}

	@Override
	public String getName() {
		return FONT_NAME;
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
