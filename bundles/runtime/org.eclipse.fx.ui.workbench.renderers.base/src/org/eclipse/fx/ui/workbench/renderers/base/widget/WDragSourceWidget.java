package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.jdt.annotation.NonNull;

public interface WDragSourceWidget {
	public void setDragStartCallback(@NonNull WCallback<DragData, Boolean> dragStackCallback);

	public static class DragData {
		public MPartStack stack;
		public MStackElement item;
		
		public DragData(MPartStack stack, MStackElement item) {
			this.stack = stack;
			this.item = item;
		}
	}
}
