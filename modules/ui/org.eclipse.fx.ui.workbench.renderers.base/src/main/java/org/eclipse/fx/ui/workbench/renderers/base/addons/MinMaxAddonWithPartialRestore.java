/*******************************************************************************
 * Copyright (c) 2011, 2018 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel (Lars.Vogel@gmail.com) - Bug 331690
 *     Dirk Fauth (dirk.fauth@googlemail.com) - Bug 459285
 *     Eugen Neufeld (eneufeld@eclipsesource.com) - Bug 432466, Bug 455568
 ******************************************************************************/

package org.eclipse.fx.ui.workbench.renderers.base.addons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.SideValue;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.workbench.renderers.base.services.PartialRestoreMinMaxService;
import org.eclipse.fx.ui.workbench.renderers.base.services.PartialRestoreMinMaxService.TrimStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget.WMinMaxState;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget.WMinMaxWidgetState;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.event.Event;

/**
 * Workbench addon that provides methods to minimize, maximize and restore parts in the window
 */
public class MinMaxAddonWithPartialRestore {

	private static final String MIN_MAXIMIZEABLE_CHILDREN_AREA_TAG = IPresentationEngine.MIN_MAXIMIZEABLE_CHILDREN_AREA_TAG;

	/**
	 * The identifier for the shared area in the Eclipse Platform. This value should be identical to
	 * the value defined in org.eclipse.ui.IPageLayout.ID_EDITOR_AREA.
	 */
	private static final String ID_EDITOR_AREA = "org.eclipse.ui.editorss"; //$NON-NLS-1$

//	private static final String GLOBAL_CACHE_ID = "Global"; //$NON-NLS-1$

	// tags representing the min/max state (h
	private static final String MINIMIZED = IPresentationEngine.MINIMIZED;
	private static final String MAXIMIZED = IPresentationEngine.MAXIMIZED;
	private static final String MINIMIZED_BY_ZOOM = IPresentationEngine.MINIMIZED_BY_ZOOM;

	private final IEventBroker eventBroker;

	final EModelService modelService;
	
	private final IEclipseContext context;

	private final PartialRestoreMinMaxService minMaxRestoreService;
	
	// Allow 'local' changes to the tags
	private boolean ignoreTagChanges = false;

	final MAddon minMaxAddon;
	
	@Inject
	MinMaxAddonWithPartialRestore(IEventBroker eventBroker, 
			EModelService modelService, 
			IEclipseContext context,
			PartialRestoreMinMaxService minMaxRestoreService,
			MAddon minMaxAddon) {
		this.eventBroker = eventBroker;
		this.modelService = modelService;
		this.context = context;
		this.minMaxRestoreService = minMaxRestoreService;
		this.minMaxAddon = minMaxAddon;
		this.eventBroker.subscribe(UIEvents.UIElement.TOPIC_WIDGET, this::subscribeTopicWidget);
		this.eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, this::subscribeTopicChildren);
		this.eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, this::subscribeTopicSelectedElement);
		this.eventBroker.subscribe(UIEvents.ApplicationElement.TOPIC_TAGS, this::subscribeTopicTagsChanged);
		this.eventBroker.subscribe(UIEvents.ApplicationElement.TOPIC_ELEMENTID, this::subscribeTopicElementId);
		this.eventBroker.subscribe(UIEvents.UILifeCycle.PERSPECTIVE_SAVED, this::subscribeTopicPerspSaved);
		this.eventBroker.subscribe(UIEvents.UILifeCycle.PERSPECTIVE_RESET, this::subscribeTopicPerspReset);
		this.eventBroker.subscribe(UIEvents.UILifeCycle.PERSPECTIVE_OPENED, this::subscribeTopicPerspOpened);
	}

	private static void setState(MUIElement element, String state) {
		if (MINIMIZED.equals(state)) {
			element.getTags().remove(MAXIMIZED);
			element.getTags().add(MINIMIZED);
		} else if (MAXIMIZED.equals(state)) {
			element.getTags().remove(MINIMIZED);
			element.getTags().add(MAXIMIZED);
		} else {
			element.getTags().remove(MINIMIZED);
			element.getTags().remove(MAXIMIZED);
		}

	}

	private void subscribeTopicWidget(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
		if (!(changedElement instanceof MPartStack) && !(changedElement instanceof MArea)) {
			return;
		}
		
		final WMinMaxableWidget ctf = getCTFFor(changedElement);
		if (ctf == null) {
			return;
		}

		MUIElement stateElement = changedElement;
		if (changedElement instanceof MPartStack) {
			MPartStack stack = (MPartStack) changedElement;
			MArea area = MinMaxAddonUtil.getAreaFor(stack);
			if (area != null && !(area.getWidget() instanceof WMinMaxableWidget)) {
				stateElement = area.getCurSharedRef();
			}
		} else if (changedElement instanceof MArea) {
			stateElement = changedElement.getCurSharedRef();
		}

		adjustCTFButtons(stateElement);

		MUIElement fStateElement = stateElement;
		ctf.setMinMaxCallback( param -> {
			if( param == WMinMaxState.TOGGLE ) {
				handleMinMaxToggle(fStateElement);
			} else if( param == WMinMaxState.MINIMIZE ) {
				setState(fStateElement, MINIMIZED);
			} else if( param == WMinMaxState.RESTORE ) {
				setState(fStateElement, null);
			}
			
			return null;
		});
	}
	
	private void handleMinMaxToggle(MUIElement fStateElement) {
		if (!fStateElement.getTags().contains(MAXIMIZED)) {
			if( this.minMaxRestoreService.isMaximizable(fStateElement) ) {
				setState(fStateElement, MAXIMIZED);
			}
		} else {
			setState(fStateElement, null);
		}
	}

	/**
	 * Handles removals from the perspective
	 *
	 * @param event
	 */
	private void subscribeTopicChildren(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
		MWindow window = this.modelService.getTopLevelWindowFor(changedElement);

		// this method is intended to update the minimized stacks in a trim
		// if the removed element is no perspective and the top level window
		// is not a trimmed window, we don't need to do anything here
		if (!(changedElement instanceof MPerspectiveStack) || window == null
				|| !(window instanceof MTrimmedWindow)) {
			return;
		}

		if (UIEvents.isREMOVE(event)) {
			for (Object removedElement : UIEvents.asIterable(event, UIEvents.EventTags.OLD_VALUE)) {
				MUIElement removed = (MUIElement) removedElement;
				if( removed == null ) {
					continue;
				}
				String perspectiveId = removed.getElementId();

				MTrimBar bar = this.modelService.getTrim((MTrimmedWindow) window, SideValue.TOP);

				// gather up any minimized stacks for this perspective...
				List<MToolControl> toRemove = new ArrayList<>();
				for (MUIElement child : bar.getChildren()) {
					String trimElementId = child.getElementId();
					if (child instanceof MToolControl && trimElementId.contains(perspectiveId)) {
						toRemove.add((MToolControl) child);
					}
				}

				// ...and remove them
				for (MToolControl minStack : toRemove) {
					minStack.setToBeRendered(false);
					bar.getChildren().remove(minStack);
				}
			}
		}
	}

	private void subscribeTopicSelectedElement(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
		if (!(changedElement instanceof MPerspectiveStack)) {
			return;
		}

		MPerspectiveStack ps = (MPerspectiveStack) changedElement;
		MWindow window = this.modelService.getTopLevelWindowFor(ps);
		List<MToolControl> tcList = this.modelService.findElements(window, null, MToolControl.class, null);

		final MPerspective curPersp = ps.getSelectedElement();
		if (curPersp != null) {
			List<String> tags = new ArrayList<>();
			tags.add(IPresentationEngine.MINIMIZED);

			List<MUIElement> minimizedElements = this.modelService.findElements(curPersp, null,
					MUIElement.class, tags);
			// Show any minimized stack from the current perspective
			for (MUIElement ele : minimizedElements) {
				String fullId = TrimStackIdHelper.createTrimStackId(ele, curPersp, window);

				for (MToolControl tc : tcList) {
					if (fullId.equals(tc.getElementId())) {
						tc.setToBeRendered(true);
					}
				}
			}

			// Find the editor 'area'
			MUIElement eaPlaceholder = this.modelService.find(ID_EDITOR_AREA, curPersp);
			adjustCTFButtons(eaPlaceholder);
		}

		// Hide any minimized stacks from the old perspective
		if (event.getProperty(EventTags.OLD_VALUE) instanceof MPerspective) {
			MPerspective oldPersp = (MPerspective) event.getProperty(EventTags.OLD_VALUE);
			String perspId = '(' + oldPersp.getElementId() + ')';
			for (MToolControl tc : tcList) {
				if (tc.getObject() instanceof TrimStack && tc.getElementId().contains(perspId)) {
					TrimStack ts = (TrimStack) tc.getObject();
					ts.showStack(false);
					tc.setToBeRendered(false);
				}
			}
		}
	}

	/**
	 * Handles changes in tags
	 *
	 * @param event
	 */
	private void subscribeTopicTagsChanged(Event event) {
		if (this.ignoreTagChanges) {
			return;
		}

		Object changedObj = event.getProperty(EventTags.ELEMENT);

		if (!(changedObj instanceof MUIElement)) {
			return;
		}

		final MUIElement changedElement = (MUIElement) changedObj;

		if (UIEvents.isADD(event)) {
			if (UIEvents.contains(event, UIEvents.EventTags.NEW_VALUE, MINIMIZED)) {
				minimize(changedElement);
			} else if (UIEvents.contains(event, UIEvents.EventTags.NEW_VALUE, MAXIMIZED)) {
				maximize(changedElement);
			}
		} else if (UIEvents.isREMOVE(event)) {
			if (UIEvents.contains(event, UIEvents.EventTags.OLD_VALUE, MINIMIZED)) {
				restore(changedElement);
			} else if (UIEvents.contains(event, UIEvents.EventTags.OLD_VALUE, MAXIMIZED)) {
				unzoom(changedElement);
			}
		}
	}

	/**
	 * Handles changes in the id of the element If a perspective ID changes fix any TrimStacks that
	 * reference the old id to point at the new id.
	 *
	 * This keeps trim stacks attached to the correct perspective when a perspective is saved with a
	 * new name.
	 *
	 * @param event
	 */
	private void subscribeTopicElementId(Event event) {
		Object changedObject = event.getProperty(EventTags.ELEMENT);

		// Only care about MPerspective id changes
		if (!(changedObject instanceof MPerspective)) {
			return;
		}

		MPerspective perspective = (MPerspective) changedObject;

		String newID = (String) event.getProperty(UIEvents.EventTags.NEW_VALUE);
		String oldID = (String) event.getProperty(UIEvents.EventTags.OLD_VALUE);

		// pattern is trimStackID(perspectiveID)
		newID = '(' + newID + ')';
		oldID = '(' + oldID + ')';

		// Search the trim for the window containing the perspective
		MWindow perspWin = this.modelService.getTopLevelWindowFor(perspective);
		if (perspWin == null) {
			return;
		}

		List<MToolControl> trimStacks = this.modelService.findElements(perspWin, null, MToolControl.class, null);
		for (MToolControl trimStack : trimStacks) {
			// Only care about MToolControls that are TrimStacks
			if (getTrimStackContributionURI().equals(trimStack.getContributionURI())) {
				trimStack.setElementId(trimStack.getElementId().replace(oldID, newID));
			}
		}
	}
	
	private String getTrimStackContributionURI() {
		Class<? extends TrimStack> type = this.minMaxRestoreService.getTrimStackType();
		Bundle bundle = FrameworkUtil.getBundle(type);
		return "bundleclass://"+bundle.getSymbolicName()+"/" + type.getName();
	}

	/**
	 * Handles the event that the perspective is saved
	 *
	 * @param event
	 */

	@Inject
	@Optional
	private void subscribeTopicPerspSaved(Event event) {
		final MPerspective savedPersp = (MPerspective) event.getProperty(EventTags.ELEMENT);
		String cache = getTrimCache(savedPersp);
		this.minMaxAddon.getPersistedState().put(savedPersp.getElementId(), cache);
	}

	private String getTrimCache(MPerspective savedPersp) {
		MWindow topWin = this.modelService.getTopLevelWindowFor(savedPersp);
		StringBuilder cache = new StringBuilder(getWinCache(topWin, savedPersp));
		for (MWindow dw : savedPersp.getWindows()) {
			cache.append(getWinCache(dw, savedPersp));
		}
		return cache.toString();
	}

	private String getWinCache(MWindow win, MPerspective perspective) {
		StringBuilder winStrBuilder = new StringBuilder();
		List<MPartStack> stackList = this.modelService.findElements(win, null, MPartStack.class, null);
		for (MPartStack stack : stackList) {
			winStrBuilder.append(getStackTrimLoc(stack, perspective));
		}
		return winStrBuilder.toString();
	}

	private String getStackTrimLoc(MPartStack stack, MPerspective perspective) {
		MWindow stackWin = this.modelService.getTopLevelWindowFor(stack);
		MUIElement tcElement = this.modelService.find(TrimStackIdHelper.createTrimStackId(stack, perspective, stackWin),
				stackWin);
		if (tcElement == null)
		 {
			return ""; //$NON-NLS-1$
		}

		MTrimBar bar = (MTrimBar) ((MUIElement) tcElement.getParent());
		int sideVal = bar.getSide().getValue();
		int index = bar.getChildren().indexOf(tcElement);
		return stack.getElementId() + ' ' + sideVal + ' ' + index + "#"; //$NON-NLS-1$
	}

	/**
	 * Handles the event that the perspective is reset
	 *
	 * @param event
	 */
	private void subscribeTopicPerspReset(Event event) {
		final MPerspective resetPersp = (MPerspective) event.getProperty(EventTags.ELEMENT);

		// Find any minimized stacks and show their trim
		List<MUIElement> minimizedElements = this.modelService.findElements(resetPersp, null,
				MUIElement.class, Arrays.asList(IPresentationEngine.MINIMIZED));
		for (MUIElement element : minimizedElements) {
			createTrim(element);
		}
	}

	/**
	 * Handles the event that the perspective is opened
	 *
	 * @param event
	 */
	private void subscribeTopicPerspOpened(Event event) {
		final MPerspective openedPersp = (MPerspective) event.getProperty(EventTags.ELEMENT);

		// Find any minimized stacks and show their trim
		List<MUIElement> minimizedElements = this.modelService.findElements(openedPersp, null,
				MUIElement.class, Arrays.asList(IPresentationEngine.MINIMIZED));
		for (MUIElement element : minimizedElements) {
			createTrim(element);
		}
	}



	private void setCTFButtons(WMinMaxableWidget ctf, MUIElement stateElement, boolean hideButtons) {
		if( ! this.minMaxRestoreService.isMaximizable(stateElement) ) {
			ctf.setMinMaxState(WMinMaxWidgetState.NONE);
		} else {
			if (stateElement.getTags().contains(MINIMIZED)) {
				ctf.setMinMaxState(WMinMaxWidgetState.MINIMIZED);
			} else if (stateElement.getTags().contains(MAXIMIZED)) {
				ctf.setMinMaxState(WMinMaxWidgetState.MAXIMIZED);
			} else {
				ctf.setMinMaxState(WMinMaxWidgetState.DEFAULT);
			}			
		}
	}

	/**
	 * Set the state of the min / max buttons on the CTF based on the model element's state. The
	 * input is expected to be the element that contains the min/max state info which should either
	 * be an MPartStack or an MPlaceholder for the shared area.
	 *
	 * @param element
	 *            The element to test
	 */
	void adjustCTFButtons(MUIElement element) {
		if (!(element instanceof MPartStack) && !(element instanceof MPlaceholder)) {
			return;
		}

		WMinMaxableWidget ctf = getCTFFor(element);
		if (ctf == null) {
			return;
		}

		if (element instanceof MPlaceholder) {
			setCTFButtons(ctf, element, false);
		} else {
			MArea area = MinMaxAddonUtil.getAreaFor((MPartStack) element);
			if (area == null) {
				setCTFButtons(ctf, element, false);
			}
			else if (area.getTags().contains(MIN_MAXIMIZEABLE_CHILDREN_AREA_TAG)) {
				setCTFButtons(ctf, element, false);
			}
		}
	}

	private WMinMaxableWidget getCTFFor(MUIElement element) {
		if (element instanceof MArea) {
			if (element.getWidget() instanceof WMinMaxableWidget) {
				return (WMinMaxableWidget) element.getWidget();
			}
			List<MPartStack> stacks = this.modelService.findElements(element, null, MPartStack.class, null);
			for (MPartStack stack : stacks) {
				if (stack.getWidget() instanceof WMinMaxableWidget) {
					return (WMinMaxableWidget) stack.getWidget();
				}
			}
		} else if (element.getWidget() instanceof WMinMaxableWidget) {
			return (WMinMaxableWidget) element.getWidget();
		} else if (element instanceof MPlaceholder) {
			MPlaceholder ph = (MPlaceholder) element;
			if (ph.getRef() instanceof MArea) {
				return getCTFFor(ph.getRef());
			}
		}
		return null;
	}

	static boolean isEmptyPerspectiveStack(MUIElement element) {
		if (!(element instanceof MPerspectiveStack)) {
			return false;
		}
		MPerspectiveStack ps = (MPerspectiveStack) element;
		return ps.getChildren().isEmpty();
	}

	void minimize(MUIElement element) {
		// Can't minimize a non-rendered element
		if (!element.isToBeRendered()) {
			return;
		}

		if (isEmptyPerspectiveStack(element)) {
			element.setVisible(false);
			return;
		}

		createTrim(element);
		element.setVisible(false);
		adjustCTFButtons(element);
		// Activate a part other than the trimStack so that if the tool item is pressed
		// immediately it will still open the stack.
		MWindow win = MinMaxAddonUtil.getWindowFor(element);
		EPartService partService = win.getContext().get(EPartService.class);
		partService.requestActivation();
	}

	void restore(MUIElement element) {
		MWindow window = this.modelService.getTopLevelWindowFor(element);
		String trimId = getTrimId(element, MinMaxAddonUtil.getWindowFor(element));
		MToolControl trimStack = (MToolControl) this.modelService.find(trimId, window);
		if (trimStack == null || trimStack.getObject() == null) {
			// try legacy id
			trimId = TrimStackIdHelper.createTrimStackId(element, this.modelService.getPerspectiveFor(element), null);
			trimStack = (MToolControl) this.modelService.find(trimId, window);
			if (trimStack == null || trimStack.getObject() == null) {
				if (element instanceof MPerspectiveStack) {
					element.setVisible(true);
				}
				return;
			}
		}

		TrimStack ts = (TrimStack) trimStack.getObject();
		ts.restoreStack();

		adjustCTFButtons(element);

		List<String> maximizeTag = new ArrayList<>();
		maximizeTag.add(IPresentationEngine.MAXIMIZED);
		List<MUIElement> curMax = this.modelService.findElements(window, null, MUIElement.class,
				maximizeTag, EModelService.PRESENTATION);

		MinMaxAddonUtil.ignoreChildrenOfMinMaxChildrenArea(this.modelService, element, curMax);

		if (curMax.size() > 0) {
			MUIElement maxElement = curMax.get(0);
			List<MUIElement> elementsLeftToRestore = getElementsToRestore(maxElement);

			// Are any stacks still minimized ?
			boolean unMax = true;
			for (MUIElement toRestore : elementsLeftToRestore) {
				if (!toRestore.isVisible()) {
					unMax = false;
				}
			}
			if (unMax) {
				maxElement.getTags().remove(IPresentationEngine.MAXIMIZED);
			}
		}
		MinMaxAddonUtil.restoreStacksOfMinMaxChildrenArea(this, element, maximizeTag);
	}

	void executeWithIgnoredTagChanges(Runnable runnable) {
		this.ignoreTagChanges = true;
		try {
			runnable.run();
		} finally {
			this.ignoreTagChanges = false;
		}
	}

	void maximize(final MUIElement element) {
		if (!element.isToBeRendered()) {
			return;
		}

		List<MUIElement> elementsToMinimize = getElementsToMinimize(element);
//		Shell hostShell = (Shell) modelService.getTopLevelWindowFor(element).getWidget();
		MWindow win = MinMaxAddonUtil.getWindowFor(element);

//		if (hostShell != null) {
//			FaderAnimationFeedback fader = new FaderAnimationFeedback(hostShell);
//			AnimationEngine engine = new AnimationEngine(win.getContext(), fader, 300);
//			engine.schedule();
//		}

		// Restore any currently maximized element
		restoreMaximizedElement(element, win);

		for (MUIElement toMinimize : elementsToMinimize) {
			toMinimize.getTags().add(MINIMIZED);
			toMinimize.getTags().add(MINIMIZED_BY_ZOOM);
		}

		adjustCTFButtons(element);

		MinMaxAddonUtil.maximizeMinMaxChildrenArea(this, element);
	}

	/**
	 * @param element
	 * @return The list of elements that need to be minimized during a maximize
	 */
	private List<MUIElement> getElementsToMinimize(MUIElement element) {
		MWindow win = MinMaxAddonUtil.getWindowFor(element);
		MPerspective persp = this.modelService.getActivePerspective(win);

		List<MUIElement> elementsToMinimize = new ArrayList<>();
		int loc = this.modelService.getElementLocation(element);
		if ((loc & EModelService.OUTSIDE_PERSPECTIVE) != 0) {
			// Minimize all other global stacks
			List<MPartStack> partStacksToMinimize = findValidElementsToMinimize(element, win, win,
					null, MPartStack.class, EModelService.OUTSIDE_PERSPECTIVE, false);
			elementsToMinimize.addAll(partStacksToMinimize);

			// Minimize the Perspective Stack
			MUIElement perspStack = null;
			if (persp == null) {
				// special case for windows with no perspectives (eg bug 372614:
				// intro part with no perspectives). We know we're outside
				// of the perspective stack, so find it top-down
				List<MPerspectiveStack> pStacks = this.modelService.findElements(win, null, MPerspectiveStack.class, null);
				perspStack = (pStacks.size() > 0) ? pStacks.get(0) : null;
			} else {
				perspStack = persp.getParent();
			}
			if (perspStack != null) {
				if (perspStack.getElementId() == null || perspStack.getElementId().length() == 0)
				 {
					perspStack.setElementId("PerspectiveStack"); //$NON-NLS-1$
				}

				elementsToMinimize.add(perspStack);
			}

			// Find all editor 'area' outside the perspective
			List<MPlaceholder> placeholderToMinimize = findValidElementsToMinimize(element, win,
					win, ID_EDITOR_AREA, MPlaceholder.class, EModelService.OUTSIDE_PERSPECTIVE,
					true);
			elementsToMinimize.addAll(placeholderToMinimize);

		} else {
			List<MPartStack> partStacksToMinimize = findValidElementsToMinimize(element, win,
					persp == null ? win : persp, null, MPartStack.class,
					EModelService.PRESENTATION, false);
			elementsToMinimize.addAll(partStacksToMinimize);
			// Find any 'standalone' views *not* in a stack
			List<String> standaloneTag = new ArrayList<>();
			standaloneTag.add(IPresentationEngine.STANDALONE);
			List<MPlaceholder> standaloneViews = this.modelService.findElements(persp == null ? win
					: persp, null, MPlaceholder.class, standaloneTag, EModelService.PRESENTATION);
			for (MPlaceholder part : standaloneViews) {
				if (!part.isToBeRendered()) {
					continue;
				}
				elementsToMinimize.add(part);
			}

			// Find the editor 'area'
			List<MPlaceholder> placeholderToMinimize = findValidElementsToMinimize(element, win,
					win, ID_EDITOR_AREA, MPlaceholder.class, EModelService.PRESENTATION, true);
			elementsToMinimize.addAll(placeholderToMinimize);
		}

		MinMaxAddonUtil.handleMinimizeOfMinMaxChildrenArea(this.modelService, element, win, persp, elementsToMinimize);

		return elementsToMinimize;
	}

	/**
	 * Find all elements based on
	 * {@link EModelService#findElements(MUIElement, String, Class, List, int)} and filter them for
	 * correct window and visibility.
	 *
	 * First all possible elements based on the parameters of EModelService#findElements(MUIElement,
	 * String, Class, List, int)} are retrieved. Then they are checked to be in the correct window.
	 * Then a check for the correct location is made and in the end the elements are checked to be
	 * valid (visible, not yet minimized and have a widget).
	 *
	 * @param elementToMaximize
	 *            the {@link MUIElement} being maximized
	 * @param currentWindow
	 *            the window of the elementToMaximize
	 * @param searchRoot
	 *            the searchRoot for possible elements
	 * @param id
	 *            the id of the element to search
	 * @param clazz
	 *            the Class of the elements to find
	 * @param searchFlag
	 *            the search flags as defined in {@link EModelService}
	 * @param allowSharedArea
	 *            whether the found element is allowed to be in a shared area
	 * @return the list of elements which should be minimized
	 */
	private <T extends MUIElement> List<T> findValidElementsToMinimize(
			MUIElement elementToMaximize, MWindow currentWindow, MUIElement searchRoot, String id,
			Class<T> clazz, int searchFlag, boolean allowSharedArea) {
		List<T> elementsToMinimize = new ArrayList<>();
		List<T> elements = this.modelService.findElements(searchRoot, id, clazz, null, searchFlag);
		for (T element : elements) {
			if (element == null || element == elementToMaximize || !element.isToBeRendered()) {
				continue;
			}

			// Exclude stacks in DW's
			if (MinMaxAddonUtil.getWindowFor(element) != currentWindow) {
				continue;
			}

			int loc = this.modelService.getElementLocation(element);
			boolean inSharedArea = loc == EModelService.IN_SHARED_AREA;
			boolean validLocation = allowSharedArea || !inSharedArea;
			if (validLocation && element.getWidget() != null && element.isVisible()
					&& !element.getTags().contains(MINIMIZED)) {
				elementsToMinimize.add(element);
			} else {
				System.err.println("Skipping: " + element);
			}
		}
		return elementsToMinimize;
	}

	/**
	 * Restore any currently maximized element (except the one we're in the process of maximizing
	 *
	 * @param element
	 * @param win
	 */
	private void restoreMaximizedElement(final MUIElement element, MWindow win) {
		MPerspective elePersp = this.modelService.getPerspectiveFor(element);
		List<String> maxTag = new ArrayList<>();
		maxTag.add(MAXIMIZED);
		List<MUIElement> curMax = this.modelService.findElements(win, null, MUIElement.class, maxTag);
		if (curMax.size() > 0) {
			for (MUIElement maxElement : curMax) {
				// Only unmax elements in this window
				if (MinMaxAddonUtil.getWindowFor(maxElement) != win) {
					continue;
				}

				MPerspective maxPersp = this.modelService.getPerspectiveFor(maxElement);
				if (maxPersp != elePersp) {
					continue;
				}
				if (maxElement == element) {
					continue;
				}
				if (MinMaxAddonUtil.isPartOfMinMaxChildrenArea(maxElement)) {
					continue;
				}
				this.ignoreTagChanges = true;
				try {
					maxElement.getTags().remove(MAXIMIZED);
				} finally {
					this.ignoreTagChanges = false;
				}
			}
		}
	}



	void unzoom(final MUIElement element) {
		MWindow win = MinMaxAddonUtil.getWindowFor(element);

//		Shell hostShell = (Shell) win.getWidget();
//		if (hostShell != null) {
//			FaderAnimationFeedback fader = new FaderAnimationFeedback(hostShell);
//			AnimationEngine engine = new AnimationEngine(win.getContext(), fader, 300);
//			engine.schedule();
//		}

		List<MUIElement> elementsToRestore = getElementsToRestore(element);
		for (MUIElement toRestore : elementsToRestore) {
			toRestore.getTags().remove(IPresentationEngine.MINIMIZED_BY_ZOOM);
			toRestore.getTags().remove(IPresentationEngine.MINIMIZED);
		}

		adjustCTFButtons(element);

		MinMaxAddonUtil.unzoomStackOfMinMaxChildrenArea(this, element);

		// There are more views available to be active...
		EPartService partService = win.getContext().get(EPartService.class);
		partService.requestActivation();
	}


	/**
	 * @param element
	 * @return The list of elements that need to be restored by an unzoom
	 */
	private List<MUIElement> getElementsToRestore(MUIElement element) {
		MWindow win = MinMaxAddonUtil.getWindowFor(element);
		MPerspective persp = this.modelService.getActivePerspective(win);

		List<MUIElement> elementsToRestore = new ArrayList<>();

		List<String> minTag = new ArrayList<>();
		minTag.add(IPresentationEngine.MINIMIZED_BY_ZOOM);

		// Restore any minimized stacks
		boolean outsidePerspectives = (this.modelService.getElementLocation(element) & EModelService.OUTSIDE_PERSPECTIVE) != 0;
		List<MPartStack> stacks = this.modelService.findElements(win, null, MPartStack.class, minTag,
				EModelService.PRESENTATION);
		for (MPartStack theStack : stacks) {
			if (theStack.getWidget() != null) {
				// Make sure we don't restore perspective-based stacks if we're
				// unzoooming an element outside the perspectives
				if (outsidePerspectives) {
					int stackLoc = this.modelService.getElementLocation(theStack);
					if ((stackLoc & EModelService.OUTSIDE_PERSPECTIVE) == 0) {
						continue;
					}
				}

				// Make sure we're only working on *our* window
				if (MinMaxAddonUtil.getWindowFor(theStack) == win) {
					elementsToRestore.add(theStack);
				}
			}
		}

		// Restore any minimized standalone views
		List<MPlaceholder> views = this.modelService.findElements(win, null, MPlaceholder.class, minTag,
				EModelService.PRESENTATION);
		for (MPlaceholder ph : views) {
			if (ph.getWidget() != null && MinMaxAddonUtil.getWindowFor(ph) == win) {
				elementsToRestore.add(ph);
			}
		}

		// Find the editor 'area'
		MPlaceholder eaPlaceholder = (MPlaceholder) this.modelService.find(ID_EDITOR_AREA,
				persp == null ? win : persp);
		if (element != eaPlaceholder && eaPlaceholder != null
				&& eaPlaceholder.getTags().contains(MINIMIZED_BY_ZOOM)) {
			elementsToRestore.add(eaPlaceholder);
		}

		// Find the Perspective Stack
		int loc = this.modelService.getElementLocation(element);
		if ((loc & EModelService.OUTSIDE_PERSPECTIVE) != 0) {
			List<MPerspectiveStack> psList = this.modelService.findElements(win, null, MPerspectiveStack.class, null);
			if (psList.size() == 1) {
				MPerspectiveStack perspStack = psList.get(0);
				if (element != perspStack && perspStack != null
						&& perspStack.getTags().contains(MINIMIZED_BY_ZOOM)) {
					elementsToRestore.add(perspStack);
				}
			}
		}

		MinMaxAddonUtil.addChildrenOfMinMaxChildrenAreaToRestoreList(this.modelService, element, win, persp, elementsToRestore);

		return elementsToRestore;
	}

	private void createTrim(MUIElement element) {
		MWindow win = MinMaxAddonUtil.getWindowFor(element);
		if (!(win instanceof MTrimmedWindow)) {
			return;
		}

		MTrimmedWindow window = (MTrimmedWindow) win;
		WWindow<?> winShell = (WWindow<?>) window.getWidget();

		// Is there already a TrimControl there ?
		String trimId = getTrimId(element, window);
		MToolControl trimStack = (MToolControl) this.modelService.find(trimId, window);

		if (trimStack == null) {
			trimStack = this.modelService.createModelElement(MToolControl.class);
			trimStack.setElementId(trimId);
			trimStack.setContributionURI(getTrimStackContributionURI());
			trimStack.getTags().add("TrimStack"); //$NON-NLS-1$
			trimStack.getTags().add("Container:StackPane"); //$NON-NLS-1$

			// Check if we have a cached location
			MTrimBar bar = this.minMaxRestoreService.findTrimBarForElement(this.modelService,element, window);
			bar.getChildren().add(trimStack);

			bar.setVisible(true);

			// get the parent trim bar, see bug 320756
			if (bar.getWidget() == null) {
				// ask it to be rendered
				bar.setToBeRendered(true);

				// create the widget
				this.context.get(IPresentationEngine.class)
						.createGui(bar, winShell, window.getContext());
			}
		} else {
			// get the parent trim bar, see bug 320756
			MUIElement parent = trimStack.getParent();
			parent.setVisible(true);
			if (parent.getWidget() == null) {
				// ask it to be rendered
				parent.setToBeRendered(true);
				// create the widget
				this.context.get(IPresentationEngine.class).createGui(parent, winShell,
						window.getContext());
			}
			trimStack.setToBeRendered(true);
		}
	}

	private String getTrimId(MUIElement element, MWindow window) {
		String trimId;
		if (MinMaxAddonUtil.isPartOfMinMaxChildrenArea(element)) {
			trimId = TrimStackIdHelper.createTrimStackId(element, null, window);
		} else {
			trimId = TrimStackIdHelper.createTrimStackId(element, this.modelService.getPerspectiveFor(element), window);
		}
		return trimId;
	}
}