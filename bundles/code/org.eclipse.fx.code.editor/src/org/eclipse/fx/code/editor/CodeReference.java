package org.eclipse.fx.code.editor;

import org.eclipse.jface.text.IRegion;

/**
 * references a region inside a document.
 *
 */
public interface CodeReference {
	Input<?> getInput();
	IRegion getRegion();
}
