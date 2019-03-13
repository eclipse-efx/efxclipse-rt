/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
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
 *     Lars.Vogel@vogella.com - Bug 454712, 485851
 *     dirk.fauth@googlemail.com - Bug 446095
 ******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.addons.internal;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MGenericStack;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.SideValue;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.controls.image.GraphicNode;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;
import org.eclipse.fx.ui.workbench.renderers.base.addons.TrimStackIdHelper;
import org.eclipse.fx.ui.workbench.renderers.base.addons.TrimStackIdHelper.TrimStackIdPart;
import org.eclipse.fx.ui.workbench.renderers.base.services.PartialRestoreMinMaxService;
import org.eclipse.fx.ui.workbench.renderers.base.services.PartialRestoreMinMaxService.TrimStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMaximizationHost;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMaximizationHost.Location;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;

import com.google.common.base.Strings;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


@SuppressWarnings("javadoc")
public class DefaultTrimStackImpl implements TrimStack {
	private static final String MINIMIZED_AND_SHOWING = "MinimizedAndShowing"; //$NON-NLS-1$
	private static final String USE_OVERLAYS_KEY = "UseOverlays"; //$NON-NLS-1$
	
	private MUIElement minimizedElement;

	private boolean isShowing = false;
	
	@Inject
	EModelService modelService;

	@Inject
	MWindow window;

	@Inject
	MToolControl toolControl;
	
	@Inject
	EPartService partService;
	
	@Inject
	PartialRestoreMinMaxService minMaxService;
	
	@Inject
	private GraphicsLoader graphicsLoader;
	
	private Pane trimStackTB;
	
	private EventHandler<ActionEvent> toolItemSelectionListener = evt -> {
		ToggleButton source = (ToggleButton) evt.getTarget();
		MUIElement uiElement = (MUIElement) source.getUserData();
		
		if( ! source.isSelected() ) {
			this.partService.requestActivation();
			showStack(false);
			return;
		}
		
		if (uiElement instanceof MPart) {
			this.partService.activate((MPart) uiElement);
		} else if (uiElement instanceof MPerspective) {
			uiElement.getParent().setSelectedElement(uiElement);
		}
		showStack(true);
	};
	private boolean cachedUseOverlays = true;
	
	@Override
	public void restoreStack() {
		showStack(false);

		this.minimizedElement.setVisible(true);
		this.minimizedElement.getTags().remove(IPresentationEngine.MINIMIZED);

		// Activate the part that is being brought up...
//		if (this.minimizedElement instanceof MPartStack) {
//			MPartStack theStack = (MPartStack) this.minimizedElement;
//			MStackElement curSel = theStack.getSelectedElement();
////			Control ctrl = (Control) minimizedElement.getWidget();
////
////			// Hack for elems that are lazy initialized
////			if (ctrl instanceof CTabFolder && ((CTabFolder) ctrl).getSelection() == null) {
////				theStack.setSelectedElement(null);
////				theStack.setSelectedElement(curSel);
////			}
//		}

		this.toolControl.setToBeRendered(false);
	}

	@Override
	public void showStack(boolean show) {
		WWidget<?> ctrl = (WWidget<?>) this.minimizedElement.getWidget();
		if (ctrl == null) {
			return;
		}

		if (show && !this.isShowing) {
			if (useOverlays()) {
				Object widget = this.window.getWidget();
				
				if( widget instanceof WMaximizationHost && ((WMaximizationHost)widget).supportPartialRestore() ) {
					MTrimBar tb = (MTrimBar)(MUIElement)this.toolControl.getParent();
					((WMaximizationHost) widget).addPartialWidget((WLayoutedWidget<? extends MUIElement>) ctrl, tb.getSide() == SideValue.LEFT ? Location.UPPER_LEFT : Location.UPPER_RIGHT);
				} else {
					this.minimizedElement.setVisible(true);
				}
				this.cachedUseOverlays = true;
			} else {
				this.minimizedElement.setVisible(true);
				// Cache the value to ensure that a stack is hidden using the same mode it was
				// opened in
				this.cachedUseOverlays = false;
			}

			this.isShowing = true;
			this.toolControl.getTags().add(MINIMIZED_AND_SHOWING);

			// Activate the part that is being brought up...
			if (this.minimizedElement instanceof MPartStack) {
				MPartStack theStack = (MPartStack) this.minimizedElement;
				MStackElement curSel = theStack.getSelectedElement();

//				// Hack for elems that are lazy initialized
//				if (ctf != null && ctf.getSelection() == null) {
//					theStack.setSelectedElement(null);
//					theStack.setSelectedElement(curSel);
//				}

				if (curSel instanceof MPart) {
					this.partService.activate((MPart) curSel);
				} else if (curSel instanceof MPlaceholder) {
					MPlaceholder ph = (MPlaceholder) curSel;
					if (ph.getRef() instanceof MPart) {
						this.partService.activate((MPart) ph.getRef());
					}
				}
			} else if (isEditorStack()) {
				MArea area = (MArea) ((MPlaceholder) this.minimizedElement).getRef();

				// See if we can find an element to activate...
				MPart partToActivate = null;
				MUIElement selectedElement = area.getSelectedElement();
				while (partToActivate == null && selectedElement != null) {
					if (selectedElement instanceof MPart) {
						partToActivate = (MPart) selectedElement;
					} else if (selectedElement instanceof MPlaceholder) {
						MPlaceholder ph = (MPlaceholder) selectedElement;
						if (ph.getRef() instanceof MPart) {
							partToActivate = (MPart) ph.getRef();
						} else {
							selectedElement = null;
						}
					} else if (selectedElement instanceof MElementContainer<?>) {
						MElementContainer<?> container = (MElementContainer<?>) selectedElement;
						selectedElement = container.getSelectedElement();
					}
				}

				// If we haven't found one then use the first
				if (partToActivate == null) {
					List<MPart> parts = this.modelService.findElements(area, null, MPart.class, null);
					for (MPart part : parts) {
						if (this.partService.isPartVisible(part)) {
							partToActivate = part;
							break;
						}
					}
				}

				if (partToActivate != null) {
					this.partService.activate(partToActivate);
				}
			} else if (this.minimizedElement instanceof MPlaceholder) {
				MPlaceholder ph = (MPlaceholder) this.minimizedElement;
				if (ph.getRef() instanceof MPart) {
					MPart part = (MPart) ph.getRef();
					this.partService.activate(part);
				}
			}

			fixToolItemSelection();
		} else if (!show && this.isShowing) {
			if (this.cachedUseOverlays) {
				WMaximizationHost host = (WMaximizationHost) this.window.getWidget();
				host.removePartialWidget((WLayoutedWidget<? extends MUIElement>) ctrl);
			} else {
				this.minimizedElement.setVisible(false);
			}

			this.isShowing = false;
			this.toolControl.getTags().remove(MINIMIZED_AND_SHOWING);

			fixToolItemSelection();
		} else {
			fixToolItemSelection();
		}
	}
	
	private boolean isEditorStack() {
		if (!(this.minimizedElement instanceof MPlaceholder)) {
			return false;
		}

		MPlaceholder ph = (MPlaceholder) this.minimizedElement;
		return ph.getRef() instanceof MArea;
	}

	private void fixToolItemSelection() {
		if (this.trimStackTB == null ) {
			return;
		}

		if (!this.isShowing) {
			// Not open...no selection
			for (Node item : this.trimStackTB.getChildren()) {
				if( item instanceof ToggleButton ) {
					((ToggleButton)item).setSelected(false);	
				}
				
			}
		} else {
			if (isEditorStack() || this.minimizedElement instanceof MPlaceholder) {
				((ToggleButton)this.trimStackTB.getChildren().get(1)).setSelected(true);
			} else if (isPerspectiveStack()) {
				MPerspectiveStack pStack = (MPerspectiveStack) this.minimizedElement;
				MUIElement selElement = pStack.getSelectedElement();
				for (Node item : this.trimStackTB.getChildren()) {
					if( item instanceof ToggleButton ) {
						((ToggleButton)item).setSelected(item.getUserData() == selElement);
					}
				}
			} else {
				MPartStack partStack = (MPartStack) this.minimizedElement;
				MUIElement selElement = partStack.getSelectedElement();
				if (selElement instanceof MPlaceholder) {
					selElement = ((MPlaceholder) selElement).getRef();
				}

				for (Node item : this.trimStackTB.getChildren()) {
					if( item instanceof ToggleButton ) {
						boolean isSel = item.getUserData() == selElement;
						((ToggleButton)item).setSelected(isSel);	
					}
				}
			}
		}
	}
	
	private boolean isPerspectiveStack() {
		return this.minimizedElement instanceof MPerspectiveStack;
	}
	
	@PostConstruct
	void createWidget(Parent parent, MToolControl me/*, CSSRenderingUtils cssUtils*/) {
		if (this.minimizedElement == null) {
			this.minimizedElement = findElement();
		}

		MUIElement meParent = me.getParent();
		if (meParent instanceof MTrimBar) {
			MTrimBar bar = (MTrimBar) meParent;
			if (bar.getSide() == SideValue.RIGHT || bar.getSide() == SideValue.LEFT) {
				this.trimStackTB = new VBox();
			} else {
				this.trimStackTB = new HBox();
			}
		}
		
		if( parent instanceof Pane ) {
			((Pane)parent).getChildren().add(this.trimStackTB);
		} else {
			((Group)parent).getChildren().add(this.trimStackTB);
		}
		
		this.trimStackTB.getStyleClass().add("trim-stack"); //$NON-NLS-1$
		
		if( this.minMaxService.supportPartialRestore(this.minimizedElement) ) {
			this.trimStackTB.getChildren().add(createRestoreButton());
		}
		
		updateTrimStackItems();
	}
	
	private MUIElement findElement() {
		MUIElement result;
		List<MPerspectiveStack> ps = this.modelService.findElements(this.window, null, MPerspectiveStack.class, null);
		if (ps.isEmpty()) {
			String toolControlId = this.toolControl.getElementId();
			int index = toolControlId.indexOf('(');
			String stackId = toolControlId.substring(0, index);
			result = this.modelService.find(stackId, this.window);
		} else {
			String toolControlId = this.toolControl.getElementId();
			Map<TrimStackIdPart, String> parsedIds = TrimStackIdHelper.parseTrimStackId(toolControlId);

			String stackId = parsedIds.get(TrimStackIdPart.ELEMENT_ID);
			String perspId = parsedIds.get(TrimStackIdPart.PERSPECTIVE_ID);

			MPerspective persp = null;
			if (perspId != null) {
				List<MPerspective> perspectives = this.modelService.findElements(ps.get(0), perspId, MPerspective.class, null);
				if (perspectives != null && !perspectives.isEmpty()) {
					persp = perspectives.get(0);
				}
			}

			if (persp != null) {
				result = this.modelService.find(stackId, persp);
			} else {
				result = this.modelService.find(stackId, this.window);
			}
		}

		return result;
	}
	
	private void updateTrimStackItems() {
		if( ! this.trimStackTB.getChildren().isEmpty() ) {
			if( this.minMaxService.supportPartialRestore(this.minimizedElement) ) {
				Node restore = this.trimStackTB.getChildren().get(0);
				this.trimStackTB.getChildren().removeIf( n -> n != restore);
			}
		}
		
		if (isEditorStack() && this.trimStackTB.getChildren().size() == 1) {
			ToggleButton ti = new ToggleButton();
			ti.getStyleClass().add("shared-area"); //$NON-NLS-1$
			ti.setTooltip(new Tooltip(Messages.getString("TrimStack.SharedArea"))); //$NON-NLS-1$
			ti.setGraphic(new GraphicNode());
			ti.setOnAction(this.toolItemSelectionListener);
			this.trimStackTB.getChildren().add(ti);
		} else if (this.minimizedElement instanceof MPlaceholder) {
			MPlaceholder ph = (MPlaceholder) this.minimizedElement;
			if (ph.getRef() instanceof MPart) {
				MPart part = (MPart) ph.getRef();
				this.trimStackTB.getChildren().add(createButton(part));
			}
		} else if (this.minimizedElement instanceof MGenericStack<?>) {
			// Handle *both* PartStacks and PerspectiveStacks here...
			MGenericStack<?> theStack = (MGenericStack<?>) this.minimizedElement;

			// check to see if this stack has any valid elements
			boolean hasRenderedElements = theStack.getChildren().stream()
					.anyMatch( stackElement -> stackElement != null && stackElement.isToBeRendered());
			
			if (hasRenderedElements) {
				for (MUIElement stackElement : theStack.getChildren()) {
					if (stackElement == null || !stackElement.isToBeRendered()) {
						continue;
					}
					
					this.trimStackTB.getChildren().add(createButton((MUILabel) stackElement));
				}
			} else if (theStack.getTags().contains(IPresentationEngine.NO_AUTO_COLLAPSE)) {
				// OK to be empty and still minimized
				this.trimStackTB.getChildren().add(createEmptyStackButton());
			} else {
				// doesn't have any children that's showing, place it back in the presentation
				restoreStack();
				return;
			}
		}
	}
	
	private static MUILabel getLabelElement(MUIElement element) {
		if (element instanceof MPlaceholder) {
			element = ((MPlaceholder) element).getRef(); 
		}

		return (MUILabel) (element instanceof MUILabel ? element : null);
	}

	private static String getLabelText(MUILabel label) {
		// Use override text if available
		if (label instanceof MUIElement) { 
			String text = getOverrideTitleToolTip((MUIElement) label);
			if (text != null && text.length() > 0) {
				return text;
			}
		}

		String string = label.getLocalizedLabel();
		return string == null ? "" : string; //$NON-NLS-1$
	}
	
	private static String getOverrideTitleToolTip(MUIElement element) {
		String result = null;

		Object stringObject = element.getTransientData().get(
				IPresentationEngine.OVERRIDE_TITLE_TOOL_TIP_KEY);
		if (stringObject instanceof String) {
			result = (String) stringObject;
		}

		if (result == null || result.length() == 0) {
			return null;
		}

		if (element instanceof MUILabel) {
			String label = ((MUILabel)element).getLocalizedLabel();
			if (label != null && label.length() > 0) {
				result = label + ' ' + '(' + result + ')';
			}
		}

		return result;
	}
	
	private boolean useOverlays() {
		if (this.toolControl == null) {
			return true;
		}

		String useOverlays = this.toolControl.getPersistedState().get(USE_OVERLAYS_KEY);
		if (useOverlays == null)
		 {
			useOverlays = "true"; //$NON-NLS-1$
		}
		return Boolean.parseBoolean(useOverlays);
	}
	
	protected Node createRestoreButton() {
		Button b = new Button(Messages.getString("TrimStack.Restore")); //$NON-NLS-1$
		b.setGraphic(new GraphicNode());
		b.getStyleClass().add("restore"); //$NON-NLS-1$
		b.setOnAction( evt -> this.minimizedElement.getTags().remove(IPresentationEngine.MINIMIZED));
		return b;
	}
	
	protected Node createButton(MUILabel element) {
		ToggleButton ti = new ToggleButton();
		ti.getStyleClass().add("part-button"); //$NON-NLS-1$
		ti.setId(((MUIElement)element).getElementId());
		ti.setUserData(element);
		if (!Strings.isNullOrEmpty(element.getIconURI())) {
			EMFUri uri = new EMFUri(URI.createURI(element.getIconURI()));
			ti.setGraphic(this.graphicsLoader.getGraphicsNode(uri));
		} else {
			ti.setGraphic(new GraphicNode());
		}
		ti.setText(getLabelText(element));
		ti.setTooltip(new Tooltip(getLabelText(element)));
		ti.setOnAction(this.toolItemSelectionListener);
		return ti;
	}
	
	protected Node createEmptyStackButton() {
		ToggleButton ti = new ToggleButton();
		ti.setTooltip(new Tooltip(Messages.getString("TrimStack.EmptyStack"))); //$NON-NLS-1$
		ti.getStyleClass().add("empty-stack"); //$NON-NLS-1$
		ti.setGraphic(new GraphicNode());
		ti.setOnAction(this.toolItemSelectionListener);
		return ti;
	}
}
