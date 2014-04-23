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
package org.eclipse.fx.runtime.swtutil;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class SWTUtil {
	private static SWTUtil INSTANCE;
	
	public static SWTUtil getInstance() {
		if( INSTANCE == null ) {
			if( SWT.getPlatform().equals("javafx") ) {
				INSTANCE = new SWTFXUtil();
			} else {
				INSTANCE = new SWTNativeUtil();
			}
		}
		
		return INSTANCE;
	}
	
	public interface SWTAppStart {
		public BlockCondition createApp(Display display);
	}
	
	public abstract void bootstrap(SWTAppStart runnable);
	public abstract void openBlocking(Shell shell);
	public abstract void block(final Display d, final BlockCondition condition);
	public abstract BlockCondition createSimpleBlockCondition();
	public abstract BlockCondition createShellBlockCondition(Shell shell);
	
	
	public static abstract class BlockCondition {
		BlockCondition() {
		}
		public abstract void unblock();
	}
}