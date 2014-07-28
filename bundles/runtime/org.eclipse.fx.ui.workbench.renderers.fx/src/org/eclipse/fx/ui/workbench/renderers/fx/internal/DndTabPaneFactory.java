package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.DroppedData;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.FeedbackData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public final class DndTabPaneFactory {
	private DndTabPaneFactory() {
		
	}
	
	public static TabPane createDndTabPane(Consumer<DragSetup> setup) {
		return new TabPane() {
			@Override
			protected javafx.scene.control.Skin<?> createDefaultSkin() {
				DnDTabPaneSkin skin = new DnDTabPaneSkin(this) {
					@Override
					protected String getClipboardContent(Tab t) {
						MStackElement domElement = ((WStackItem<?, ?>)t.getUserData()).getDomElement();
						if( domElement != null ) {
							EObject eo = (EObject) domElement;
							return ((XMIResource)eo.eResource()).getID(eo);
						}
						return null;
					}
				};
				setup.accept(skin);
				return skin;
			}
		};
	}
	
	public interface DragSetup {
		public void setStartFunction(@Nullable Function<@NonNull Tab, @NonNull Boolean> startFunction);
		public void setDragFinishedConsumer(@Nullable Consumer<@NonNull Tab> dragFinishedConsumer);
		public void setFeedbackConsumer(@Nullable Consumer<@NonNull FeedbackData> feedbackConsumer);
		public void setDropConsumer(@Nullable Consumer<@NonNull DroppedData> dropConsumer);
	}
}
