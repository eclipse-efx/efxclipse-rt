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
package org.eclipse.fx.runtime.fswt.graphics;

public class FFadeTransition implements FTransition {

	public static class Basic extends FFadeTransition {
		public final double fromOpacity;
		public final double toOpacity;
		public final long duration;

		Basic(double fromOpacity, double toOpacity, long duration) {
			this.fromOpacity = fromOpacity;
			this.toOpacity = toOpacity;
			this.duration = duration;
		}
	}

	public static FFadeTransition basic(double fromOpacity, double toOpacity, long duration) {
		return new Basic(fromOpacity, toOpacity, duration);
	}
}
