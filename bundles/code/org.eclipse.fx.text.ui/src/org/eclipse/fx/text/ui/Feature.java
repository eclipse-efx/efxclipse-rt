package org.eclipse.fx.text.ui;

import java.util.function.Supplier;

import org.eclipse.fx.text.ui.internal.InvisibleCharSupport;
import org.eclipse.fx.text.ui.internal.LineNumberSupport;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

public enum Feature {
	SHOW_LINE_NUMBERS(()->new LineNumberSupport()),
	SHOW_HIDDEN_SYMBOLS(()->new InvisibleCharSupport());


	private Supplier<IFeature> featureFactory;
	private Feature(Supplier<IFeature> featureFactory) {
		this.featureFactory = featureFactory;
	}

	public Supplier<IFeature> getFeatureFactory() {
		return featureFactory;
	}

}
