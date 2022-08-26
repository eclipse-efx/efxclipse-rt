/*******************************************************************************
 *  Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors: 
 *      Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation
 ******************************************************************************/
package org.eclipse.fx.demo.contacts.model;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.demo.contacts.Group;

public interface ContactsManager {
	
	Group getRootGroup();

	AdapterFactory getAdapterFactory();

	EditingDomain getEditingDomain();

}