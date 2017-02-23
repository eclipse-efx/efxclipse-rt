package test.issue12.app.themes;

import org.eclipse.fx.ui.theme.AbstractTheme;

/**
 * @author tomschindl
 *
 */
public class DefaultTheme extends AbstractTheme {
	/**
	 *
	 */
	public DefaultTheme() {
		super("theme.default", "Default theme", DefaultTheme.class.getClassLoader().getResource("css/default.css"));
	}
}
