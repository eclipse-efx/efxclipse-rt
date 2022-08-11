/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.text.undo.DocumentUndoEvent;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoListener;
import org.eclipse.text.undo.IDocumentUndoManager;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class DefaultUndoManager implements IUndoManager {

	private IDocument fDocument;
	private IDocumentUndoManager fDocumentUndoManager;
	private ITextViewer fTextViewer;

	private int fUndoLevel;

	public DefaultUndoManager(int undoLevel) {
		this.fUndoLevel = undoLevel;
	}

	private boolean isConnected() {
		return fTextViewer != null && fDocumentUndoManager != null;
	}

	private void onKeyPressed(KeyEvent e) {
		switch(e.getCode()) {
		case UP:
		case DOWN:
		case LEFT:
		case RIGHT:
			if (isConnected()) {
				fDocumentUndoManager.commit();
			}
			break;
		}
	}

	private void onMousePressed(MouseEvent e) {
		if (e.getClickCount() == 1) {
			if (isConnected()) {
				fDocumentUndoManager.commit();
			}
		}
	}

	private ITextInputListener fTextInputListener = new ITextInputListener() {
		@Override
		public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
			connectDocumentUndoManager(newInput);
		}

		@Override
		public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
			disconnectDocumentUndoManager();
		}
	};

	
	private IDocumentUndoListener fDocumentUndoListener = createUndoListener();
	private IDocumentUndoListener createUndoListener() {
		return new IDocumentUndoListener() {
			@Override
			public void documentUndoNotification(DocumentUndoEvent event ){
				if (!isConnected()) return;
	
				int eventType= event.getEventType();
				if (((eventType & DocumentUndoEvent.ABOUT_TO_UNDO) != 0) || ((eventType & DocumentUndoEvent.ABOUT_TO_REDO) != 0))  {
					if (event.isCompound()) {
	//					ITextViewerExtension extension= null;
	//					if (fTextViewer instanceof ITextViewerExtension)
	//						extension= (ITextViewerExtension) fTextViewer;
	//
	//					if (extension != null)
	//						extension.setRedraw(false);
					}
					// TODO turn of auto edit strategies
	//				fTextViewer.getTextWidget().getDisplay().syncExec(new Runnable() {
	//					@Override
	//					public void run() {
	//						if (fTextViewer instanceof TextViewer)
	//							((TextViewer)fTextViewer).ignoreAutoEditStrategies(true);
	//					}
	//			    });
	
				} else if (((eventType & DocumentUndoEvent.UNDONE) != 0) || ((eventType & DocumentUndoEvent.REDONE) != 0))  {
					// TODO turn on auto edit strategies
	//				fTextViewer.getTextWidget().getDisplay().syncExec(new Runnable() {
	//					@Override
	//					public void run() {
	//						if (fTextViewer instanceof TextViewer)
	//							((TextViewer)fTextViewer).ignoreAutoEditStrategies(false);
	//					}
	//			    });
					if (event.isCompound()) {
	//					ITextViewerExtension extension= null;
	//					if (fTextViewer instanceof ITextViewerExtension)
	//						extension= (ITextViewerExtension) fTextViewer;
	//
	//					if (extension != null)
	//						extension.setRedraw(true);
					}
	
					// Reveal the change if this manager's viewer has the focus.
					if (fTextViewer != null) {
						StyledTextArea widget= fTextViewer.getTextWidget();
						// TODO select?
	//					if (widget != null && !widget.isDisposed() && (widget.isFocusControl()))// || fTextViewer.getTextWidget() == control))
						if( (eventType & DocumentUndoEvent.UNDONE) != 0 ) {
							reveal(event.getOffset(), event.getText() == null ? 0 : event.getText().length());
						} else {
							selectAndReveal(event.getOffset(), event.getText() == null ? 0 : event.getText().length());
						}
					}
				}
			}
	
		};
	}

	/**
	 * Selects and reveals the specified range.
	 *
	 * @param offset the offset of the range
	 * @param length the length of the range
	 */
	private void selectAndReveal(int offset, int length) {
		if (fTextViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension= (ITextViewerExtension5) fTextViewer;
			extension.exposeModelRange(new Region(offset, length));
		} else if (!fTextViewer.overlapsWithVisibleRegion(offset, length))
			fTextViewer.resetVisibleRegion();

		fTextViewer.getTextWidget().setSelection(new TextSelection(offset, length));
//		fTextViewer.revealRange(offset, length);
	}

	private void reveal(int offset, int length) {
		if (fTextViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension= (ITextViewerExtension5) fTextViewer;
			extension.exposeModelRange(new Region(offset, length));
		} else if (!fTextViewer.overlapsWithVisibleRegion(offset, length))
			fTextViewer.resetVisibleRegion();

		fTextViewer.getTextWidget().setCaretOffset(offset);
//		fTextViewer.revealRange(offset, length);
	}

	private void connectDocumentUndoManager(IDocument document) {
		disconnectDocumentUndoManager();
		if (document != null) {
			fDocument= document;
			DocumentUndoManagerRegistry.connect(fDocument);
			fDocumentUndoManager= DocumentUndoManagerRegistry.getDocumentUndoManager(fDocument);
			fDocumentUndoManager.connect(this);
			setMaximalUndoLevel(fUndoLevel);
			if (fDocumentUndoListener == null) {
				fDocumentUndoListener = createUndoListener();
			}
			fDocumentUndoManager.addDocumentUndoListener(fDocumentUndoListener);
		}
	}

	private void disconnectDocumentUndoManager() {
		if (fDocumentUndoManager != null) {
			DocumentUndoManagerRegistry.disconnect(fDocument);
			fDocumentUndoManager.disconnect(this);
			fDocumentUndoManager.removeDocumentUndoListener(fDocumentUndoListener);
			fDocumentUndoListener= null;
			fDocumentUndoManager= null;
		}
	}

	@Override
	public void connect(ITextViewer viewer) {
		this.fTextViewer = viewer;

		this.fTextViewer.getTextWidget().addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
		this.fTextViewer.getTextWidget().addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);

		this.fTextViewer.addTextInputListener(this.fTextInputListener);

		connectDocumentUndoManager(fTextViewer.getDocument());
	}

	@Override
	public void disconnect() {

		this.fTextViewer.getTextWidget().removeEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
		this.fTextViewer.getTextWidget().removeEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);

		this.fTextViewer.removeTextInputListener(this.fTextInputListener);

		this.fTextViewer = null;

		disconnectDocumentUndoManager();
	}

	@Override
	public void beginCompoundChange() {
		if (isConnected()) {
			fDocumentUndoManager.beginCompoundChange();
		}
	}

	@Override
	public void endCompoundChange() {
		if (isConnected()) {
			fDocumentUndoManager.endCompoundChange();
		}
	}

	@Override
	public void reset() {
		if (isConnected())
			fDocumentUndoManager.reset();
	}

	@Override
	public void setMaximalUndoLevel(int undoLevel) {
		fUndoLevel= Math.max(0, undoLevel);
		if (isConnected()) {
			fDocumentUndoManager.setMaximalUndoLevel(fUndoLevel);
		}
	}

	@Override
	public boolean undoable() {
		if (isConnected())
			return fDocumentUndoManager.undoable();
		return false;
	}

	@Override
	public boolean redoable() {
		if (isConnected())
			return fDocumentUndoManager.redoable();
		return false;
	}

	@Override
	public void undo() {
		if (isConnected()) {
			try {
				fDocumentUndoManager.undo();
			} catch (ExecutionException ex) {
				ex.printStackTrace();
//				openErrorDialog(JFaceTextMessages.getString("DefaultUndoManager.error.undoFailed.title"), ex); //$NON-NLS-1$
			}
		}
	}

	@Override
	public void redo() {
		if (isConnected()) {
			try {
				fDocumentUndoManager.redo();
			} catch (ExecutionException ex) {
				ex.printStackTrace();
//				openErrorDialog(JFaceTextMessages.getString("DefaultUndoManager.error.redoFailed.title"), ex); //$NON-NLS-1$
			}
		}
	}

}
