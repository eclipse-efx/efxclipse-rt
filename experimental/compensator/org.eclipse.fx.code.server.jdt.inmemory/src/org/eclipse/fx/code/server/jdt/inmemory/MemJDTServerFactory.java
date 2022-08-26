/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
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
