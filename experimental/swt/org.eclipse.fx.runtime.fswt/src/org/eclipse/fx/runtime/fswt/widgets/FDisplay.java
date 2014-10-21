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
package org.eclipse.fx.runtime.fswt.widgets;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.FSWTObject;
import org.eclipse.swt.widgets.Display;

public interface FDisplay<T extends Display> extends FSWTObject<T> {
	public FSWT getFSWT();
	public void block(FBlockCondition blockCondition);
}
