package org.eclipse.fx.code.server.jdt.inmemory;

import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.code.server.jdt.JDTServerFactory;

public class MemJDTServerFactory implements JDTServerFactory {
	private static MemJDTServer SERVER;

	@Override
	public JDTServer getOrCreateServer(String projectName) {
		if( SERVER == null ) {
			SERVER = new MemJDTServer();
		}
		return SERVER;
	}

}
