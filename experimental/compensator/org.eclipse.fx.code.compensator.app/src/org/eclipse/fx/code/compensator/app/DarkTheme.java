package org.eclipse.fx.code.compensator.app;

import org.eclipse.fx.ui.services.theme.MultiURLStylesheet;
import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.theme.AbstractTheme;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component(service=Theme.class)
public class DarkTheme extends AbstractTheme {

	public DarkTheme() {
		super("dark", "Dark theme", DarkTheme.class.getClassLoader().getResource("css/dark-default.css"));
	}

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC)
	public void registerStylesheet(Stylesheet stylesheet) {
		super.registerStylesheet(stylesheet);
	}
	
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC)
	public void registerMultiURLStylesheet(MultiURLStylesheet stylesheet) {
		super.registerMultiURLStylesheet(stylesheet);
	}
}
