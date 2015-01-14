package org.eclipse.fx.code.server.jdt;

public interface JDTServerFactory {
	public JDTServer getOrCreateServer(String projectName);
}
