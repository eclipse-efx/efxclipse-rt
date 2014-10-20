/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.fswt.sample;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.FSWTProvider;
import org.eclipse.fx.runtime.fswt.graphics.FFadeTransition;
import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.fx.runtime.fswt.widgets.FShell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SampleApp {
	public static void main(String[] args) {
		FSWT facade = FSWTProvider.getFacade();
		facade.boostrap(SampleApp::bootstrap);
	}

	static FBlockCondition bootstrap(FDisplay<Display> display) {
		Shell s = new Shell();

		FShell<Shell> as = FSWTProvider.getFacade().adapt(s, FShell.class);
		as.openBlocking(FFadeTransition.basic(0, 1.0, 1000), () -> {});

		return null;
	}
}
