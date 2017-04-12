/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.services;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler.Save;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.jdt.annotation.NonNull;

import javafx.stage.Window;

/**
 * Interface implemented by components who are able to display the save dialogs
 * used
 *
 * @since 2.3.0
 */
public interface SaveDialogPresenter {
	/**
	 * Informations passed to display the save dialog
	 */
	public static class SaveData {
		/**
		 * Is the dialog a lightweight
		 */
		public final boolean lightweight;
		/**
		 * List of dirty parts
		 */
		public final @NonNull Collection<MPart> dirtyParts;
		/**
		 * The native widget
		 */
		public final @NonNull WWindow<?> widget;
		/**
		 * The native window
		 */
		public final @NonNull Window window;

		/**
		 * Create the information object
		 *
		 * @param lightweight
		 *            Is the dialog a lightweight
		 * @param dirtyParts
		 *            List of dirty parts
		 * @param widget
		 *            The native widget
		 * @param window
		 *            The native window
		 */
		public SaveData(boolean lightweight, @NonNull Collection<MPart> dirtyParts, @NonNull WWindow<?> widget, @NonNull Window window) {
			super();
			this.lightweight = lightweight;
			this.dirtyParts = dirtyParts;
			this.widget = widget;
			this.window = window;
		}
	}

	/**
	 * Prompt the user to save
	 *
	 * @param data
	 *            the save data
	 * @return list of save data
	 */
	public @NonNull CompletableFuture<List<@NonNull Save>> promptToSave(@NonNull SaveData data);
}