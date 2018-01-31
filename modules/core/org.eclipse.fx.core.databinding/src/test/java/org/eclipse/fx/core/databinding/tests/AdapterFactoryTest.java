/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.databinding.tests;

import javafx.util.Callback;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * 
 */
@RunWith(RealmRunner.class)
public class AdapterFactoryTest {
	
	@Test
	public void convertObservableList() {
		WritableList l = new WritableList();
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("1");
		
		IObservableList target = AdapterFactory.convertObservableList(l, new Callback<String, Integer>() {

			@Override
			public Integer call(String param) {
				return Integer.parseInt(param);
			}
		});
		assertEquals(l.size(), target.size());
		assertEquals(((Integer)target.get(0)).intValue(), 1);
		assertEquals(((Integer)target.get(1)).intValue(), 2);
		assertEquals(((Integer)target.get(2)).intValue(), 3);
		assertEquals(((Integer)target.get(3)).intValue(), 1);
		l.add("4");
		assertEquals(l.size(), target.size());
		assertEquals(((Integer)target.get(4)).intValue(), 4);
		l.remove("2");
		assertEquals(l.size(), target.size());
		assertEquals(((Integer)target.get(1)).intValue(), 3);
		l.add(1,"2");
		assertEquals(((Integer)target.get(1)).intValue(), 2);
	}
}
