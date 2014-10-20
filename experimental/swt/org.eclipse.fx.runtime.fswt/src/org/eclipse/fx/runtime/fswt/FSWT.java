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
package org.eclipse.fx.runtime.fswt;

import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.fx.runtime.fswt.widgets.FWidget;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public interface FSWT {
	public int getRanking();
	public <T extends Widget,F extends FWidget<T>> F adapt(T widget, Class<F> clazz);
	public void boostrap(FCallback<FDisplay<Display>,FBlockCondition> initialize);
}
