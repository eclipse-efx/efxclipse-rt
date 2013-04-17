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
package org.eclipse.fx.emf.edit.ui.dnd;

import javafx.scene.input.Dragboard;

/**
 * Replacement for the {@link Dragboard} that transfers the content without serializing it.
 */
public class LocalTransfer {

	public static LocalTransfer INSTANCE = new LocalTransfer();

	/**
	 * The object being transfered
	 */
	private Object object;

	public void setObject(Object object) {
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

}
