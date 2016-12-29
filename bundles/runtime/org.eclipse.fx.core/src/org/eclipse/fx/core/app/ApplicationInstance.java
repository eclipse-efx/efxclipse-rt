package org.eclipse.fx.core.app;

import java.util.concurrent.CompletableFuture;

public interface ApplicationInstance {
	public CompletableFuture<ExitStatus> launch(ApplicationContext context);
	public void stop(ExitStatus status);
}
