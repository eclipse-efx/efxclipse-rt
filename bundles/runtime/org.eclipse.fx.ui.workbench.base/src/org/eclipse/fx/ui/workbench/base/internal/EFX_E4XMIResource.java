package org.eclipse.fx.ui.workbench.base.internal;

import org.eclipse.e4.ui.internal.workbench.E4XMIResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class EFX_E4XMIResource extends E4XMIResource {
	public EFX_E4XMIResource(URI uri) {
		super(uri);
	}
	
	@Override
	public String getID(EObject eObject) {
		String id = super.getID(eObject);
		setID(eObject, id);
		return id;
	}
}
