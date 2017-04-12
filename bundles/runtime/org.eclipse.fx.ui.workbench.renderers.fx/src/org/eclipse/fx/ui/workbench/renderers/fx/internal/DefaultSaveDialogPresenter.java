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
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler.Save;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;
import org.eclipse.fx.ui.controls.stage.FrameEvent;
import org.eclipse.fx.ui.dialogs.Dialog;
import org.eclipse.fx.ui.dialogs.MessageDialog;
import org.eclipse.fx.ui.dialogs.MessageDialog.QuestionCancelResult;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.fx.ui.workbench.renderers.fx.services.SaveDialogPresenter;
import org.eclipse.jdt.annotation.NonNull;

import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 */
public class DefaultSaveDialogPresenter implements SaveDialogPresenter {

	@Inject
	@Translation
	@NonNull
	private Messages messages;

	@Inject
	private ThreadSynchronize uiSync;

	@Inject
	GraphicsLoader graphicsLoader;

	@SuppressWarnings("null")
	@Override
	public CompletableFuture<List<@NonNull Save>> promptToSave(SaveData data) {
		if( data.dirtyParts.size() == 1 ) {
			return CompletableFuture.completedFuture(Collections.singletonList(promptToSave(data.lightweight, data.dirtyParts.iterator().next(), data.widget, data.window)));
		} else {
			return CompletableFuture.completedFuture(promptToSave(data.lightweight, data.dirtyParts, data.widget, data.window));
		}
	}

	@NonNull
	private List<@NonNull Save> promptToSave(boolean lightweight, @NonNull Collection<MPart> dirtyParts, @NonNull WWindow<?> widget, @NonNull Window window) {
		Save[] response = new Save[dirtyParts.size()];

		if( lightweight ) {
			Arrays.fill(response, Save.CANCEL);
			MultiMessageDialogContent multiMessageDialogContent = new MultiMessageDialogContent(this.messages.DefWindowRenderer_MultiMessageDialog_Message, dirtyParts, graphicsLoader);
			org.eclipse.fx.ui.controls.dialog.Dialog d = new org.eclipse.fx.ui.controls.dialog.Dialog(multiMessageDialogContent, this.messages.DefWindowRenderer_MultiMessageDialog_Title) {
				@Override
				protected void handleOk() {
					List<MPart> parts = new ArrayList<MPart>();
					for (Row r : multiMessageDialogContent.tabView.getItems()) {
						if (r.isSelected()) {
							parts.add(r.element.get());
						}
					}

					Arrays.fill(response, Save.NO);
					for (MPart p : parts) {
						response[parts.indexOf(p)] = Save.YES;
					}
					super.handleOk();
				}
			};
			d.getButtonList().addAll(d.createOKButton(), d.createCancelButton());
			widget.setDialog(d);
			BlockCondition<Object> condition = new BlockCondition<>();
			d.addEventHandler(FrameEvent.CLOSED, condition::release);
			this.uiSync.block(condition);
			widget.setDialog(null);
		} else {
			MultiMessageDialog d = new MultiMessageDialog(window, dirtyParts, graphicsLoader, this.messages.DefWindowRenderer_MultiMessageDialog_Title, this.messages.DefWindowRenderer_MultiMessageDialog_Message);
			if (d.open() == Dialog.OK_BUTTON) {
				List<MPart> parts = d.getSelectedParts();
				Arrays.fill(response, Save.NO);
				for (MPart p : parts) {
					response[parts.indexOf(p)] = Save.YES;
				}
			} else {
				Arrays.fill(response, Save.CANCEL);
			}
		}

		return Arrays.asList(response);
	}

	private Save promptToSave(boolean lightweight, MPart dirtyPart, WWindow<?> widget, Window stage) {
		if( lightweight ) { //$NON-NLS-1$
			org.eclipse.fx.ui.controls.dialog.MessageDialog.QuestionCancelResult r = org.eclipse.fx.ui.controls.dialog.MessageDialog.openQuestionCancelDialog(
					this.messages.DefWindowRenderer_promptToSave_Title,
					this.messages.DefWindowRenderer_promptToSave_Message(dirtyPart.getLocalizedLabel()),
					(d) -> {
						widget.setDialog(d);
					});
			widget.setDialog(null);
			switch (r) {
			case CANCEL:
				return Save.CANCEL;
			case NO:
				return Save.NO;
			case YES:
				return Save.YES;
			}

			return Save.CANCEL;
		} else {
			QuestionCancelResult r = MessageDialog.openQuestionCancelDialog((Stage) widget.getWidget(), this.messages.DefWindowRenderer_promptToSave_Title, this.messages.DefWindowRenderer_promptToSave_Message(dirtyPart.getLocalizedLabel()));

			switch (r) {
			case CANCEL:
				return Save.CANCEL;
			case NO:
				return Save.NO;
			case YES:
				return Save.YES;
			}

			return Save.CANCEL;
		}
	}
}
