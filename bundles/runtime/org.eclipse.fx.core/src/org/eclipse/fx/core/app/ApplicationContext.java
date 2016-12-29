package org.eclipse.fx.core.app;

import java.net.URL;
import java.util.Optional;

public interface ApplicationContext {
	String[] getApplicationArguments();

	void applicationRunning();

	Optional<URL> getSplashImage();

	Object getApplicationProperty(String key);
}
