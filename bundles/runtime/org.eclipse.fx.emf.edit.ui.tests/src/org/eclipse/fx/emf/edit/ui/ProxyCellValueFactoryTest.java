/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;

import org.eclipse.fx.emf.edit.ui.ProxyCellValueFactory;
import org.junit.Test;

public class ProxyCellValueFactoryTest {

	@Test
	@SuppressWarnings({"rawtypes", "unchecked"})
 	public void call() {
		ProxyCellValueFactory factory = new ProxyCellValueFactory();
		CellDataFeatures features = mock(CellDataFeatures.class);
		Object dummy = new Object();
		when(features.getValue()).thenReturn(dummy);
		ObservableValue<Object> observableValue = factory.call(features);
		assertEquals(dummy, observableValue.getValue());
	}

}
