package org.eclipse.fx.ui.controls.image;

import java.security.Provider;
import java.security.Provider.Service;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.eclipse.fx.ui.controls.image.spi.IconFontProvider;

import com.sun.javafx.Utils;
import com.sun.javafx.css.StyleConverterImpl;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;

public class FontIconStyleConverter extends StyleConverter<String, FontIcon> {

	@Override
	public FontIcon convert(ParsedValue<String, FontIcon> value, Font font) {
		System.err.println("convert " + value + ", " + font);
		String v = value.getValue();
		System.err.println(v);
		// this converts a java unicode (\\u....)
		// however css standard uses the syntax (\....) without u
		v = Utils.convertUnicode(v);
		System.err.println(v);
		
		
		if (v.length() == 1) {
			char c = v.charAt(0);
			System.err.println("creating char");
			return FontIcon.create(c);
		}
		else {
			System.err.println("creating name");
			return FontIcon.create(v);
//			IconFontProvider sup = getSupportForFont(font);
//			return FontIcon.create(sup.map(v));
		}
//		return super.convert(value, font);
	}
	
	
}
