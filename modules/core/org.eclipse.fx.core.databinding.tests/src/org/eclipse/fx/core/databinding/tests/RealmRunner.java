/*******************************************************************************
 * Copyright (c) 2013 __COMPANY/CONTRIBUTOR__ and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     tomschindl<__EMAIL__> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.databinding.tests;

import org.eclipse.core.databinding.observable.Realm;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * 
 */
public class RealmRunner extends BlockJUnit4ClassRunner {
	static class DummyRealm extends Realm {

		@Override
		public boolean isCurrent() {
			return true;
		}
		
	}
	
	/**
	 * @param klass
	 * @throws InitializationError
	 */
	public RealmRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	public void run(RunNotifier notifier) {
		Realm.runWithDefault(new DummyRealm(), new Runnable() {
			
			@Override
			public void run() {
				RealmRunner.super.run(notifier);
			}
		});
	}
}
