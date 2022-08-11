/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeItem;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AdapterFactoryTreeItemTest extends AbstractAdapterFactoryCellFactoryTest {

	AdapterFactory adapterFactory;

	@Before
	public void setUp() {
		createTestBench();
		adapterFactory = mock(AdapterFactory.class);
	}

	@Ignore
	@Test
	public void test() {
		ITreeItemContentProvider contentProvider = mock(ITreeItemContentProvider.class);
		ArrayList childItems = new ArrayList();
		Object childItem1 = new Object();
		childItems.add(childItem1);
		when(contentProvider.getChildren(item1)).thenReturn(childItems);
		when(adapterFactory.adapt((Object) item1, ITreeItemContentProvider.class)).thenReturn(contentProvider);
		AdapterFactoryTreeItem treeItem = new AdapterFactoryTreeItem(item1, null, adapterFactory);

		assertEquals(childItems.get(0), treeItem.getChildren().get(0).getValue());

		Object childItem2 = new Object();
		childItems.add(childItem2);
		
		Notification notification = mock(Notification.class);
		when(notification.getFeature()).thenReturn(mock(EReference.class));
		adapter1.notifyChanged(notification);

		assertEquals(childItems.get(0), treeItem.getChildren().get(0).getValue());
		assertEquals(childItems.get(1), treeItem.getChildren().get(1).getValue());
	}

}
