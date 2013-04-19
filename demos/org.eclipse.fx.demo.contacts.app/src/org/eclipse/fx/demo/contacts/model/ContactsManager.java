/*******************************************************************************
 *  Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
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