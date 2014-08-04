package org.eclipse.fx.ui.controls.image.skin;

import java.util.Iterator;
import java.util.ServiceLoader;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.SkinBase;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import org.eclipse.fx.ui.controls.image.FontIcon;
import org.eclipse.fx.ui.controls.image.FontIconView;
import org.eclipse.fx.ui.controls.image.spi.IconFontLookup;
import org.eclipse.fx.ui.controls.image.spi.IconFontProvider;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

public class FontIconViewSkin extends SkinBase<FontIconView> {

	private Text text;

	public FontIconViewSkin(FontIconView control) {
		super(control);

//		System.err.println(System.identityHashCode(getSkinnable()) + " Skinnable BEGIN: " + getSkinnable().getIcon().getIconName() + " / " + getSkinnable().getFont());
		
		text = new Text();
		text.setMouseTransparent(true);

		getChildren().add(text);

		text.fontProperty().bind(getSkinnable().fontProperty());

		text.fillProperty().bind(getSkinnable().iconFillProperty());
		
		getSkinnable().fontProperty().addListener(new ChangeListener<Font>() {
			@Override
			public void changed(ObservableValue<? extends Font> observable,
					Font oldValue, Font newValue) {
				updateIcon(getSkinnable().getIcon(), newValue);
			}
		});
		getSkinnable().iconProperty().addListener(
				new ChangeListener<FontIcon>() {

					@Override
					public void changed(
							ObservableValue<? extends FontIcon> observable,
							FontIcon oldValue, FontIcon newValue) {
						updateIcon(newValue, getSkinnable().getFont());
					}
				});

//		System.err.println(System.identityHashCode(getSkinnable()) + " Skinnable END: " + getSkinnable().getIcon().getIconName() + " / " + getSkinnable().getFont());
		
		// TODO do we need this = ?
		text.setText(convert(getSkinnable().getIcon(), getSkinnable().getFont()));
	}

	private void updateIcon(FontIcon icon, Font font) {
//		System.err.println("UPDATE ICON " + icon.getIconName() + " / " + font);
		computeIconSize(icon, font);
		text.setText(convert(icon, font));
	}

	private String convert(FontIcon icon, Font font) {
		if (icon != null) {
			if (icon.getIconCode() != '0') {
				return Character.toString(icon.getIconCode());
			} else {
				IconFontProvider sup = getSupportForFont(font);
//				System.err.println("support = " + sup);
				if (sup != null) {
					char v = sup.map(icon.getIconName());
					return Character.toString(v);
				}
			}
		}
		return "?";
	}

	private IconFontProvider getSupportForFont(Font font) {
		
		return IconFontLookup.getProviderForFont(font);
//		System.err.println("using service loader");
//		ServiceLoader<IconFontProvider> load = ServiceLoader
//				.<IconFontProvider> load(IconFontProvider.class);
//		System.err.println(" => " + load);
//		load.forEach((r)->System.err.println(" * > " + r));
//		
//		
//		Iterator<IconFontProvider> it = load.iterator();
//		while (it.hasNext()) {
//			IconFontProvider sup = it.next();
//			if (sup.getName().equals(font.getName())) {
//				return sup;
//			}
//		}
//		return null;
	}

	private Point2D computeIconSize(FontIcon icon, Font font) {
		String iconString = convert(icon, font);
		
		FontMetrics metrics = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);
		
		float width = metrics.computeStringWidth(iconString);
		float height = metrics.getLineHeight();
//		System.err.println("icon size is : " + width + " x " + height);
		return new Point2D(width, height);
	}
	
//	@Override
//	protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
//		final Insets iconPadding = getSkinnable().getIconPadding();
//		super.layoutChildren(contentX + iconPadding.getLeft(), 
//				contentY + iconPadding.getTop(), 
//				contentWidth - (iconPadding.getLeft() + iconPadding.getRight()), 
//				contentHeight - (iconPadding.getTop() + iconPadding.getBottom()));
//	}
}
