/*******************************************************************************
 * Copyright (c) 2000, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Tom Eicher (Avaloq Evolution AG) - block selection mode
 *     Markus Schorn <markus.schorn@windriver.com> - shift with trailing empty line - https://bugs.eclipse.org/325438
 *******************************************************************************/
package org.eclipse.fx.text.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.scene.layout.AnchorPane;

import org.eclipse.core.runtime.Assert;
import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.DocumentRewriteSessionEvent;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IDocumentInformationMapping;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentRewriteSessionListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISlaveDocumentManager;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.SlaveDocumentEvent;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.projection.ChildDocument;
import org.eclipse.jface.text.projection.ChildDocumentManager;

public class TextViewer extends AnchorPane implements
	ITextViewer, ITextViewerExtension, ITextViewerExtension2, ITextViewerExtension4, ITextViewerExtension6, ITextViewerExtension7, ITextViewerExtension8
	/*,
	IEditingSupportRegistry, ITextOperationTarget, ITextOperationTargetExtension,
	IWidgetTokenOwner, IWidgetTokenOwnerExtension, IPostSelectionProvider*/ {
	private StyledTextArea fTextWidget;
	private IDocument fVisibleDocument;
	private VisibleDocumentListener fVisibleDocumentListener= new VisibleDocumentListener();
	private ISlaveDocumentManager fSlaveDocumentManager;
	private IDocumentInformationMapping fInformationMapping;
	private IDocumentAdapter fDocumentAdapter;
	private WidgetCommand fWidgetCommand= new WidgetCommand();
	protected List fTextListeners;
	private int fRedrawCounter= 0;
	private IRegion fLastSentSelectionChange;
	private String fPartitioning;
	private IDocument fDocument;
	private boolean fReplaceTextPresentation;
	private DocumentRewriteSessionListener fDocumentRewriteSessionListener= new DocumentRewriteSessionListener();
	private IRewriteTarget fRewriteTarget;
	private ViewerState fViewerState;
	private List fTextInputListeners;
	protected Position fMarkPosition;
	private final String MARK_POSITION_CATEGORY="__mark_category_" + hashCode(); //$NON-NLS-1$
	private final IPositionUpdater fMarkPositionUpdater= new DefaultPositionUpdater(MARK_POSITION_CATEGORY);
	private List fTextPresentationListeners;
	protected Map<TextHoverKey,ITextHover> fTextHovers;
	private TextViewerHoverManager fTextHoverManager;

	public TextViewer() {
		createControl();
	}

	protected void createControl() {
		fTextWidget = createTextWidget();
		AnchorPane.setLeftAnchor(fTextWidget, 0.0);
		AnchorPane.setRightAnchor(fTextWidget, 0.0);
		AnchorPane.setTopAnchor(fTextWidget, 0.0);
		AnchorPane.setBottomAnchor(fTextWidget, 0.0);
		getChildren().add(fTextWidget);
	}

	public StyledTextArea getTextWidget() {
		return fTextWidget;
	}

	protected StyledTextArea createTextWidget() {
		StyledTextArea styledText= new StyledTextArea();
		styledText.setLineRulerVisible(true);
//		styledText.setLeftMargin(Math.max(styledText.getLeftMargin(), 2));
		return styledText;
	}

	public void setInput(Object input) {

		IDocument document= null;
		if (input instanceof IDocument)
			document= (IDocument) input;

		setDocument(document);
	}

	public Object getInput() {
		return getDocument();
	}

	public void setDocumentPartitioning(String partitioning) {
		fPartitioning= partitioning;
	}

	protected String getDocumentPartitioning() {
		return fPartitioning;
	}

	/**
	 * Sets this viewer's visible document. The visible document represents the
	 * visible region of the viewer's input document.
	 *
	 * @param document the visible document
	 */
	protected void setVisibleDocument(IDocument document) {
		if (fVisibleDocument == document && fVisibleDocument instanceof ChildDocument) {
			// optimization for new child documents
			return;
		}

		if (fVisibleDocument != null) {
			if (fVisibleDocumentListener != null)
				fVisibleDocument.removeDocumentListener(fVisibleDocumentListener);
			if (fVisibleDocument != document)
				freeSlaveDocument(fVisibleDocument);
		}

		fVisibleDocument= document;
		initializeDocumentInformationMapping(fVisibleDocument);

		initializeWidgetContents();

//TODO needs porting
//		fFindReplaceDocumentAdapter= null;
		if (fVisibleDocument != null && fVisibleDocumentListener != null)
			fVisibleDocument.addDocumentListener(fVisibleDocumentListener);
	}

	public IDocument getDocument() {
		return fDocument;
	}

	public void setDocument(IDocument document) {
		fReplaceTextPresentation= true;
		fireInputDocumentAboutToBeChanged(fDocument, document);

		IDocument oldDocument= fDocument;
		fDocument= document;

		setVisibleDocument(fDocument);
//TODO needs porting
//		resetPlugins();
		inputChanged(fDocument, oldDocument);

		fireInputDocumentChanged(oldDocument, fDocument);
		fLastSentSelectionChange= null;
		fReplaceTextPresentation= false;
	}

	public void setDocument(IDocument document, int modelRangeOffset, int modelRangeLength) {

		fReplaceTextPresentation= true;
		fireInputDocumentAboutToBeChanged(fDocument, document);

		IDocument oldDocument= fDocument;
		fDocument= document;

		try {

			IDocument slaveDocument= createSlaveDocument(document);
			updateSlaveDocument(slaveDocument, modelRangeOffset, modelRangeLength);
			setVisibleDocument(slaveDocument);

		} catch (BadLocationException x) {
//			throw new IllegalArgumentException(JFaceTextMessages.getString("TextViewer.error.invalid_visible_region_1")); //$NON-NLS-1$
			throw new IllegalArgumentException();
		}

		//TODO needs porting
//		resetPlugins();
		inputChanged(fDocument, oldDocument);

		fireInputDocumentChanged(oldDocument, fDocument);
		fLastSentSelectionChange= null;
		fReplaceTextPresentation= false;
	}

	/**
	 * Creates a slave document for the given document if there is a slave document manager
	 * associated with this viewer.
	 *
	 * @param document the master document
	 * @return the newly created slave document
	 * @since 2.1
	 */
	protected IDocument createSlaveDocument(IDocument document) {
		ISlaveDocumentManager manager= getSlaveDocumentManager();
		if (manager != null) {
			if (manager.isSlaveDocument(document))
				return document;
			return manager.createSlaveDocument(document);
		}
		return document;
	}

	/**
	 * Updates the given slave document to show the specified range of its master document.
	 *
	 * @param slaveDocument the slave document
	 * @param modelRangeOffset the offset of the master document range
	 * @param modelRangeLength the length of the master document range
	 * @return <code>true</code> if the slave has been adapted successfully
	 * @throws BadLocationException in case the specified range is not valid in the master document
	 * @since 3.0
	 */
	protected boolean updateSlaveDocument(IDocument slaveDocument, int modelRangeOffset, int modelRangeLength) throws BadLocationException {
		return updateVisibleDocument(slaveDocument, modelRangeOffset, modelRangeLength);
	}

	/**
	 * Sets the given slave document to the specified range of its master document.
	 *
	 * @param visibleDocument the slave document
	 * @param visibleRegionOffset the offset of the master document range
	 * @param visibleRegionLength the length of the master document range
	 * @return <code>true</code> if the slave has been adapted successfully
	 * @throws BadLocationException in case the specified range is not valid in the master document
	 * @since 2.1
 	 * @deprecated use <code>updateSlaveDocument</code> instead
	 */
	protected boolean updateVisibleDocument(IDocument visibleDocument, int visibleRegionOffset, int visibleRegionLength) throws BadLocationException {
		if (visibleDocument instanceof ChildDocument) {
			ChildDocument childDocument= (ChildDocument) visibleDocument;

			IDocument document= childDocument.getParentDocument();
			int line= document.getLineOfOffset(visibleRegionOffset);
			int offset= document.getLineOffset(line);
			int length= (visibleRegionOffset - offset) + visibleRegionLength;

			Position parentRange= childDocument.getParentDocumentRange();
			if (offset != parentRange.getOffset() || length != parentRange.getLength()) {
				childDocument.setParentDocumentRange(offset, length);
				return true;
			}
		}
		return false;
	}

	public IRegion getVisibleRegion() {

		IDocument document= getVisibleDocument();
		if (document instanceof ChildDocument) {
			Position p= ((ChildDocument) document).getParentDocumentRange();
			return new Region(p.getOffset(), p.getLength());
		}

		return new Region(0, document == null ? 0 : document.getLength());
	}

	protected void fireInputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
		List listener= fTextInputListeners;
		if (listener != null) {
			for (int i= 0; i < listener.size(); i++) {
				ITextInputListener l= (ITextInputListener) listener.get(i);
				l.inputDocumentAboutToBeChanged(oldInput, newInput);
			}
		}
	}

	protected void fireInputDocumentChanged(IDocument oldInput, IDocument newInput) {
		List listener= fTextInputListeners;
		if (listener != null) {
			for (int i= 0; i < listener.size(); i++) {
				ITextInputListener l= (ITextInputListener) listener.get(i);
				l.inputDocumentChanged(oldInput, newInput);
			}
		}
	}

	protected IDocument getVisibleDocument() {
		return fVisibleDocument;
	}

	protected void freeSlaveDocument(IDocument slave) {
		ISlaveDocumentManager manager= getSlaveDocumentManager();
		if (manager != null && manager.isSlaveDocument(slave))
			manager.freeSlaveDocument(slave);
	}

	protected ISlaveDocumentManager getSlaveDocumentManager() {
		if (fSlaveDocumentManager == null)
			fSlaveDocumentManager= createSlaveDocumentManager();
		return fSlaveDocumentManager;
	}

	protected ISlaveDocumentManager createSlaveDocumentManager() {
		return new ChildDocumentManager();
	}

	protected void initializeDocumentInformationMapping(IDocument visibleDocument) {
		ISlaveDocumentManager manager= getSlaveDocumentManager();
		fInformationMapping= manager == null ? null : manager.createMasterSlaveMapping(visibleDocument);
	}

	protected void inputChanged(Object newInput, Object oldInput) {

		IDocument oldDocument= (IDocument) oldInput;
		if (oldDocument != null) {

			if (fMarkPosition != null && !fMarkPosition.isDeleted())
				oldDocument.removePosition(fMarkPosition);

			try {
				oldDocument.removePositionUpdater(fMarkPositionUpdater);
				oldDocument.removePositionCategory(MARK_POSITION_CATEGORY);

			} catch (BadPositionCategoryException e) {
			}
		}

		fMarkPosition= null;

		if (oldDocument instanceof IDocumentExtension4) {
			IDocumentExtension4 document= (IDocumentExtension4) oldDocument;
			document.removeDocumentRewriteSessionListener(fDocumentRewriteSessionListener);
		}

//		super.inputChanged(newInput, oldInput);

		if (newInput instanceof IDocumentExtension4) {
			IDocumentExtension4 document= (IDocumentExtension4) newInput;
			document.addDocumentRewriteSessionListener(fDocumentRewriteSessionListener);
		}

		IDocument newDocument= (IDocument) newInput;
		if (newDocument != null) {
			newDocument.addPositionCategory(MARK_POSITION_CATEGORY);
			newDocument.addPositionUpdater(fMarkPositionUpdater);
		}
	}

	private void initializeWidgetContents() {

		if (fTextWidget != null && fVisibleDocument != null) {

			// set widget content
			if (fDocumentAdapter == null)
				fDocumentAdapter= createDocumentAdapter();

			fDocumentAdapter.setDocument(fVisibleDocument);
			fTextWidget.setContent(fDocumentAdapter);
			System.err.println(fDocumentAdapter);

			// invalidate presentation
			invalidateTextPresentation();
		}
	}

	protected IDocumentAdapter createDocumentAdapter() {
		return new DefaultDocumentAdapter();
	}

	public final void invalidateTextPresentation() {
		if (fVisibleDocument != null) {
			fWidgetCommand.event= null;
			fWidgetCommand.start= 0;
			fWidgetCommand.length= fVisibleDocument.getLength();
			fWidgetCommand.text= fVisibleDocument.get();
			updateTextListeners(fWidgetCommand);
		}
	}

	protected void updateTextListeners(WidgetCommand cmd) {
		List textListeners= fTextListeners;
		if (textListeners != null) {
			textListeners= new ArrayList(textListeners);
			DocumentEvent event= cmd.event;
			if (event instanceof SlaveDocumentEvent)
				event= ((SlaveDocumentEvent) event).getMasterEvent();

			TextEvent e= new TextEvent(cmd.start, cmd.length, cmd.text, cmd.preservedText, event, redraws());
			for (int i= 0; i < textListeners.size(); i++) {
				ITextListener l= (ITextListener) textListeners.get(i);
				l.textChanged(e);
			}
		}
	}

	protected final boolean redraws() {
		return fRedrawCounter <= 0;
	}

	protected void handleVisibleDocumentAboutToBeChanged(DocumentEvent event) {
	}

	protected void handleVisibleDocumentChanged(DocumentEvent event) {
	}

	public void addTextListener(ITextListener listener) {

		Assert.isNotNull(listener);

		if (fTextListeners == null)
			fTextListeners= new ArrayList();

		if (!fTextListeners.contains(listener))
			fTextListeners.add(listener);
	}

	public void removeTextListener(ITextListener listener) {
		Assert.isNotNull(listener);

		if (fTextListeners != null) {
			fTextListeners.remove(listener);
			if (fTextListeners.size() == 0)
				fTextListeners= null;
		}
	}

	public void addTextInputListener(ITextInputListener listener) {

		Assert.isNotNull(listener);

		if (fTextInputListeners == null)
			fTextInputListeners= new ArrayList();

		if (!fTextInputListeners.contains(listener))
			fTextInputListeners.add(listener);
	}

	public void removeTextInputListener(ITextInputListener listener) {

		Assert.isNotNull(listener);

		if (fTextInputListeners != null) {
			fTextInputListeners.remove(listener);
			if (fTextInputListeners.size() == 0)
				fTextInputListeners= null;
		}
	}

	public void changeTextPresentation(TextPresentation presentation, boolean controlRedraw) {

		if (presentation == null || !redraws())
			return;

		if (fTextWidget == null)
			return;


		/*
		 * Call registered text presentation listeners
		 * and let them apply their presentation.
		 */
		if (fTextPresentationListeners != null) {
			ArrayList listeners= new ArrayList(fTextPresentationListeners);
			for (int i= 0, size= listeners.size(); i < size; i++) {
				ITextPresentationListener listener= (ITextPresentationListener)listeners.get(i);
				listener.applyTextPresentation(presentation);
			}
		}

		if (presentation.isEmpty())
			return;

//		if (controlRedraw)
//			fTextWidget.setRedraw(false);

		if (fReplaceTextPresentation)
			applyTextPresentation(presentation);
		else
			addPresentation(presentation);

//		if (controlRedraw)
//			fTextWidget.setRedraw(true);
	}

	private void addPresentation(TextPresentation presentation) {

		StyleRange range= presentation.getDefaultStyleRange();
		if (range != null) {

			range= modelStyleRange2WidgetStyleRange(range);
			if (range != null)
				fTextWidget.setStyleRange(range);

			ArrayList ranges= new ArrayList(presentation.getDenumerableRanges());
			Iterator e= presentation.getNonDefaultStyleRangeIterator();
			while (e.hasNext()) {
				range= (StyleRange) e.next();
				range= modelStyleRange2WidgetStyleRange(range);
				if (range != null)
					ranges.add(range);
			}

			if (!ranges.isEmpty())
				fTextWidget.replaceStyleRanges(0, 0, (StyleRange[])ranges.toArray(new StyleRange[ranges.size()]));

		} else {
			IRegion region= modelRange2WidgetRange(presentation.getCoverage());
			if (region == null)
				return;

			List list= new ArrayList(presentation.getDenumerableRanges());
			Iterator e= presentation.getAllStyleRangeIterator();
			while (e.hasNext()) {
				range= (StyleRange) e.next();
				range= modelStyleRange2WidgetStyleRange(range);
				if (range != null)
					list.add(range);
			}

			if (!list.isEmpty()) {
				StyleRange[] ranges= new StyleRange[list.size()];
				list.toArray(ranges);
				fTextWidget.replaceStyleRanges(region.getOffset(), region.getLength(), ranges);
			}
		}
	}

	private void applyTextPresentation(TextPresentation presentation) {
		List list= new ArrayList(presentation.getDenumerableRanges());
		Iterator e= presentation.getAllStyleRangeIterator();
		while (e.hasNext()) {
			StyleRange range= (StyleRange) e.next();
			range= modelStyleRange2WidgetStyleRange(range);
			if (range != null)
				list.add(range);
		}

		if (!list.isEmpty()) {
			StyleRange[] ranges= new StyleRange[list.size()];
			list.toArray(ranges);
			fTextWidget.setStyleRanges(ranges);
		}
	}

	protected StyleRange modelStyleRange2WidgetStyleRange(StyleRange range) {
		IRegion region= modelRange2WidgetRange(new Region(range.start, range.length));
		if (region != null) {
			StyleRange result= (StyleRange) range.clone();
			result.start= region.getOffset();
			result.length= region.getLength();
			return result;
		}
		return null;
	}

	public IRegion modelRange2WidgetRange(IRegion modelRange) {
		if (fInformationMapping == null)
			return modelRange;

		try {

			if (modelRange.getLength() < 0) {
				Region reversed= new Region(modelRange.getOffset() + modelRange.getLength(), -modelRange.getLength());
				IRegion result= fInformationMapping.toImageRegion(reversed);
				if (result != null)
					return new Region(result.getOffset() + result.getLength(), -result.getLength());
			}
			return fInformationMapping.toImageRegion(modelRange);

		} catch (BadLocationException x) {
		}

		return null;
	}

	public IRewriteTarget getRewriteTarget() {
		if (fRewriteTarget == null)
			fRewriteTarget= new RewriteTarget();
		return fRewriteTarget;
	}

	public final void setRedraw(boolean redraw) {
//TODO needs porting
//		setRedraw(redraw, -1);
	}

	public void setVisibleRegion(int start, int length) {

		IRegion region= getVisibleRegion();
		if (start == region.getOffset() && length == region.getLength()) {
			// nothing to change
			return;
		}

		setRedraw(false);
		try {

			IDocument slaveDocument= createSlaveDocument(getVisibleDocument());
			if (updateSlaveDocument(slaveDocument, start, length))
				setVisibleDocument(slaveDocument);

		} catch (BadLocationException x) {
			throw new IllegalArgumentException("TextViewer.error.invalid_visible_region_2"); //$NON-NLS-1$
		} finally {
			setRedraw(true);
		}
	}

	public void resetVisibleRegion() {
		ISlaveDocumentManager manager= getSlaveDocumentManager();
		if (manager != null) {
			IDocument slave= getVisibleDocument();
			IDocument master= manager.getMasterDocument(slave);
			if (master != null) {
				setVisibleDocument(master);
				manager.freeSlaveDocument(slave);
			}
		}
	}

	class VisibleDocumentListener implements IDocumentListener {

		public void documentAboutToBeChanged(DocumentEvent e) {
			if (e.getDocument() == getVisibleDocument())
				fWidgetCommand.setEvent(e);
			handleVisibleDocumentAboutToBeChanged(e);
		}

		public void documentChanged(DocumentEvent e) {
			if (fWidgetCommand.event == e)
				updateTextListeners(fWidgetCommand);
			fLastSentSelectionChange= null;
			handleVisibleDocumentChanged(e);
		}
	}

	/**
	 * Represents a replace command that brings the text viewer's text widget
	 * back in synchronization with text viewer's document after the document
	 * has been changed.
	 */
	protected class WidgetCommand {

		/** The document event encapsulated by this command. */
		public DocumentEvent event;
		/** The start of the event. */
		public int start;
		/** The length of the event. */
		public int length;
		/** The inserted and replaced text segments of <code>event</code>. */
		public String text;
		/** The replaced text segments of <code>event</code>. */
		public String preservedText;

		/**
		 * Translates a document event into the presentation coordinates of this text viewer.
		 *
		 * @param e the event to be translated
		 */
		public void setEvent(DocumentEvent e) {

			event= e;

			start= e.getOffset();
			length= e.getLength();
			text= e.getText();

			if (length != 0) {
				try {

					if (e instanceof SlaveDocumentEvent) {
						SlaveDocumentEvent slave= (SlaveDocumentEvent) e;
						DocumentEvent master= slave.getMasterEvent();
						if (master != null)
							preservedText= master.getDocument().get(master.getOffset(), master.getLength());
					} else {
						preservedText= e.getDocument().get(e.getOffset(), e.getLength());
					}

				} catch (BadLocationException x) {
					preservedText= null;
//					if (TRACE_ERRORS)
//						System.out.println(JFaceTextMessages.getString("TextViewer.error.bad_location.WidgetCommand.setEvent")); //$NON-NLS-1$
				}
			} else
				preservedText= null;
		}
	}

	private class DocumentRewriteSessionListener implements IDocumentRewriteSessionListener {

		/*
		 * @see org.eclipse.jface.text.IDocumentRewriteSessionListener#documentRewriteSessionChanged(org.eclipse.jface.text.DocumentRewriteSessionEvent)
		 */
		public void documentRewriteSessionChanged(DocumentRewriteSessionEvent event) {
			IRewriteTarget target= TextViewer.this.getRewriteTarget();
			final boolean toggleRedraw;
//			if (REDRAW_BUG_158746)
//				toggleRedraw= true;
//			else
				toggleRedraw= event.getSession().getSessionType() != DocumentRewriteSessionType.UNRESTRICTED_SMALL;
			final boolean viewportStabilize= !toggleRedraw;
			if (DocumentRewriteSessionEvent.SESSION_START == event.getChangeType()) {
				if (toggleRedraw)
					target.setRedraw(false);
				target.beginCompoundChange();
				if (viewportStabilize && fViewerState == null)
					fViewerState= new ViewerState();
			} else if (DocumentRewriteSessionEvent.SESSION_STOP == event.getChangeType()) {
				if (viewportStabilize && fViewerState != null) {
					fViewerState.restore(true);
					fViewerState= null;
				}
				target.endCompoundChange();
				if (toggleRedraw)
					target.setRedraw(true);
			}
		}
	}

	public boolean overlapsWithVisibleRegion(int start, int length) {
		IDocument document= getVisibleDocument();
		if (document instanceof ChildDocument) {
			ChildDocument cdoc= (ChildDocument) document;
			return cdoc.getParentDocumentRange().overlapsWith(start, length);
		} else if (document != null) {
			int size= document.getLength();
			return (start >= 0 && length >= 0 && start + length <= size);
		}
		return false;
	}

	public final void invalidateTextPresentation(int offset, int length) {
		if (fVisibleDocument != null) {

			IRegion widgetRange= modelRange2WidgetRange(new Region(offset, length));
			if (widgetRange != null) {

				fWidgetCommand.event= null;
				fWidgetCommand.start= widgetRange.getOffset();
				fWidgetCommand.length= widgetRange.getLength();

				try {
					fWidgetCommand.text= fVisibleDocument.get(widgetRange.getOffset(), widgetRange.getLength());
					updateTextListeners(fWidgetCommand);
				} catch (BadLocationException x) {
					// can not happen because of previous checking
				}
			}
		}
	}

	public void addTextPresentationListener(ITextPresentationListener listener) {

		Assert.isNotNull(listener);

		if (fTextPresentationListeners == null)
			fTextPresentationListeners= new ArrayList();

		if (!fTextPresentationListeners.contains(listener))
			fTextPresentationListeners.add(listener);
	}

	public void removeTextPresentationListener(ITextPresentationListener listener) {

		Assert.isNotNull(listener);

		if (fTextPresentationListeners != null) {
			fTextPresentationListeners.remove(listener);
			if (fTextPresentationListeners.size() == 0)
				fTextPresentationListeners= null;
		}
	}

	@Override
	public void setTextHover(ITextHover textViewerHover, String contentType, int stateMask) {
		TextHoverKey key= new TextHoverKey(contentType, stateMask);
		if (textViewerHover != null) {
			if (fTextHovers == null) {
				fTextHovers= new HashMap<>();
			}
			fTextHovers.put(key, textViewerHover);
		} else if (fTextHovers != null)
			fTextHovers.remove(key);

		ensureHoverControlManagerInstalled();
	}

	@Override
	public void removeTextHovers(String contentType) {
		if (fTextHovers == null)
			return;

		Iterator iter= new HashSet<>(fTextHovers.keySet()).iterator();
		while (iter.hasNext()) {
			TextHoverKey key= (TextHoverKey)iter.next();
			if (key.fContentType.equals(contentType))
				fTextHovers.remove(key);
		}
	}

	public ITextHover getTextHover(int offset, int stateMask) {
		if (fTextHovers == null)
			return null;

		IDocument document= getDocument();
		if (document == null)
			return null;

		try {
			String contentType = TextUtilities.getContentType(document, getDocumentPartitioning(), offset, true);
			TextHoverKey key= new TextHoverKey(contentType, stateMask);
			Object textHover= fTextHovers.get(key);
			if (textHover == null) {
				// Use default text hover
				key.setStateMask(ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
				textHover= fTextHovers.get(key);
			}
			return (ITextHover) textHover;
		} catch (BadLocationException x) {
//			if (TRACE_ERRORS)
//				System.out.println(JFaceTextMessages.getString("TextViewer.error.bad_location.selectContentTypePlugin")); //$NON-NLS-1$
		}
		return null;
	}

//	@Override
//	public ITextHover getCurrentTextHover() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private void ensureHoverControlManagerInstalled() {
		if (fTextHovers != null && !fTextHovers.isEmpty() /*&& fHoverControlCreator != null*/ && fTextHoverManager == null) {
			fTextHoverManager= createTextHovermanager();
			fTextHoverManager.install(this.getTextWidget());
//			fTextHoverManager.setSizeConstraints(TEXT_HOVER_WIDTH_CHARS, TEXT_HOVER_HEIGHT_CHARS, false, true);
//			fTextHoverManager.setInformationControlReplacer(new StickyHoverManager(this));
		}
	}

	protected TextViewerHoverManager createTextHovermanager() {
		return new TextViewerHoverManager(this/*, fHoverControlCreator*/);
	}

	/**
	 * The viewer's rewrite target.
	 * @since 2.0
	 */
	class RewriteTarget implements IRewriteTarget {

		/*
		 * @see org.eclipse.jface.text.IRewriteTarget#beginCompoundChange()
		 */
		public void beginCompoundChange() {
//TODO needs porting
//			if (fUndoManager != null)
//				fUndoManager.beginCompoundChange();
		}

		/*
		 * @see org.eclipse.jface.text.IRewriteTarget#endCompoundChange()
		 */
		public void endCompoundChange() {
//TODO needs porting
//			if (fUndoManager != null)
//				fUndoManager.endCompoundChange();
		}

		/*
		 * @see org.eclipse.jface.text.IRewriteTarget#getDocument()
		 */
		public IDocument getDocument() {
			return TextViewer.this.getDocument();
		}

		/*
		 * @see org.eclipse.jface.text.IRewriteTarget#setRedraw(boolean)
		 */
		public void setRedraw(boolean redraw) {
			TextViewer.this.setRedraw(redraw);
		}
	}

	private final class ViewerState {
//TODO needs porting
		public void restore(boolean restoreViewport) {

		}
	}

	/**
	 * Value object used as key in the text hover configuration table. It is
	 * modifiable only inside this compilation unit to allow the reuse of created
	 * objects for efficiency reasons
	 *
	 * @since 2.1
	 */
	protected class TextHoverKey {

		/** The content type this key belongs to */
		private String fContentType;
		/** The state mask */
		private int fStateMask;

		/**
		 * Creates a new text hover key for the given content type and state mask.
		 *
		 * @param contentType the content type
		 * @param stateMask the state mask
		 */
		protected TextHoverKey(String contentType, int stateMask) {
			Assert.isNotNull(contentType);
			fContentType= contentType;
			fStateMask= stateMask;
		}

		/*
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			TextHoverKey textHoverKey= (TextHoverKey)obj;
			return textHoverKey.fContentType.equals(fContentType) && textHoverKey.fStateMask == fStateMask;
		}

		/*
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {
	 		return fStateMask << 16 | fContentType.hashCode();
		}

		/**
		 * Sets the state mask of this text hover key.
		 *
		 * @param stateMask the state mask
		 */
		private void setStateMask(int stateMask) {
			fStateMask= stateMask;
		}
	}
}
