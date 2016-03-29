package org.eclipse.fx.code.editor.services;

import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jface.text.IRegion;

/**
 * represents the actual editor instance
 * <p>allows client code to interact with the editor caret and selection</p>
 *
 */
public interface EditingContext {

	int getCaretOffset();
	void setCaretOffset(int offset);

	void setCaretOffset(int offset, boolean keepSelection);

	IRegion getSelection();
	void setSelection(IRegion selection);

	Subscription registerOnCaretOffsetChanged(Consumer<Integer> listener);
	Subscription registerOnSelectionChanged(Consumer<IRegion> listener);

}
