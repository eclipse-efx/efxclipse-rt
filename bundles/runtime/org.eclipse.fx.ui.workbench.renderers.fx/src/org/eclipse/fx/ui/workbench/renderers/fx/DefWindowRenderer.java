/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler.Save;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.controls.stage.Frame;
import org.eclipse.fx.ui.controls.stage.FrameEvent;
import org.eclipse.fx.ui.controls.stage.TrimmedWindow;
import org.eclipse.fx.ui.di.InjectingFXMLLoader;
import org.eclipse.fx.ui.dialogs.Dialog;
import org.eclipse.fx.ui.dialogs.MessageDialog;
import org.eclipse.fx.ui.dialogs.MessageDialog.QuestionCancelResult;
import org.eclipse.fx.ui.panes.FillLayoutPane;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.fx.ui.services.theme.ThemeManager.Registration;
import org.eclipse.fx.ui.workbench.fx.EMFUri;
import org.eclipse.fx.ui.workbench.fx.key.KeyBindingDispatcher;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseWindowRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.services.MaximizationTransitionService;
import org.eclipse.fx.ui.workbench.renderers.base.services.WindowTransitionService;
import org.eclipse.fx.ui.workbench.renderers.base.services.WindowTransitionService.AnimationDelegate;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.Messages;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.MultiMessageDialog;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.MultiMessageDialogContent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.Row;
import org.eclipse.fx.ui.workbench.renderers.fx.services.LightweightDialogTransitionService;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.osgi.service.localization.BundleLocalization;
import org.osgi.framework.Bundle;

import com.google.common.base.Strings;
import com.sun.javafx.tk.Toolkit;

import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * Default implementation of a window renderer
 */
@SuppressWarnings("restriction")
public class DefWindowRenderer extends BaseWindowRenderer<Stage> {
	private static final String CSS_TRIM_CONTAINER = "window-trim-container"; //$NON-NLS-1$
	private static final String CSS_CONTENT_CONTAINER = "window-content-container"; //$NON-NLS-1$

	private static final String ID_CLIENT_AREA = "client-area"; //$NON-NLS-1$
	private static final String ID_MENU_BAR_AREA = "menu-bar-area"; //$NON-NLS-1$
	private static final String ID_TOP_TRIM_AREA = "top-trim-area"; //$NON-NLS-1$
	private static final String ID_BOTTOM_TRIM_AREA = "bottom-trim-area"; //$NON-NLS-1$
	private static final String ID_LEFT_TRIM_AREA = "left-trim-area"; //$NON-NLS-1$
	private static final String ID_RIGHT_TRIM_AREA = "right-trim-area"; //$NON-NLS-1$

	@Inject
	@Translation
	@NonNull
	Messages messages;

	@SuppressWarnings("null")
	@Override
	@NonNull
	protected List<@NonNull Save> promptToSave(@NonNull MWindow element, @NonNull Collection<MPart> dirtyParts, @NonNull WWindow<Stage> widget) {
		Save[] response = new Save[dirtyParts.size()];
		IEclipseContext modelContext = getModelContext(element);
		if (modelContext == null) {
			getLogger().error("Model context should not be null at this point"); //$NON-NLS-1$
			Arrays.fill(response, Save.CANCEL);
			return Arrays.asList(response);
		}
		GraphicsLoader graphicsLoader = modelContext.get(GraphicsLoader.class);

		if( element.getTags().contains("efx-lightweight-dialogs") ) { //$NON-NLS-1$
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
			((WWindowImpl)element.getWidget()).setDialog(d);
			String id = UUID.randomUUID().toString();
			d.addEventHandler(FrameEvent.CLOSED, (e) -> Toolkit.getToolkit().exitNestedEventLoop(id, null));
			Toolkit.getToolkit().enterNestedEventLoop(id);
			((WWindowImpl)element.getWidget()).setDialog(null);
		} else {
			MultiMessageDialog d = new MultiMessageDialog((Stage) widget.getWidget(), dirtyParts, graphicsLoader, this.messages.DefWindowRenderer_MultiMessageDialog_Title, this.messages.DefWindowRenderer_MultiMessageDialog_Message);
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

	@Override
	protected Save promptToSave(MWindow element, MPart dirtyPart, WWindow<Stage> widget) {
		if( element.getTags().contains("efx-lightweight-dialogs") ) { //$NON-NLS-1$
			org.eclipse.fx.ui.controls.dialog.MessageDialog.QuestionCancelResult r = org.eclipse.fx.ui.controls.dialog.MessageDialog.openQuestionCancelDialog(
					this.messages.DefWindowRenderer_promptToSave_Title,
					this.messages.DefWindowRenderer_promptToSave_Message(dirtyPart.getLocalizedLabel()),
					(d) -> {
						((WWindowImpl)element.getWidget()).setDialog(d);
					});
			((WWindowImpl)element.getWidget()).setDialog(null);
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

	@Override
	protected Class<? extends WWindow<Stage>> getWidgetClass(MWindow window) {
		return WWindowImpl.class;
	}

	/**
	 * Default implementation of a window
	 */
	public static class WWindowImpl extends WLayoutedWidgetImpl<Stage, Pane, MWindow>implements WWindow<Stage> {
		private boolean support3d;
		private Pane rootPane;
		private BorderPane trimPane;
		private FillLayoutPane contentPane;
		private KeyBindingDispatcher dispatcher;
		private BorderPane decoratorPane;
		WindowResizeButton windowResizeButton;
		Stage stage;

		@Inject
		@Optional
		ThemeManager themeManager;

		private Registration sceneRegistration;

		private String decorationFXML;

		private String rootFXML;

		private boolean fullscreen;

		IEclipseContext modelContext;

		@NonNull
		MWindow mWindow;

		@Inject
		TranslationService translationService;

		@Inject
		@NonNull
		BundleLocalization localizationService; // FIXME We should get rid of
												// this

		@Inject
		@Optional
		WindowTransitionService<Stage> windowTransitionService;

		@Inject
		@Optional
		LightweightDialogTransitionService dialogTransitionService;

		@Inject
		private GraphicsLoader graphicsLoader;

		@Inject
		private IEventBroker eventBroker;

		boolean initDone;

		private boolean undecorated;

		private StageStyle stageStyle;

		IEclipseContext applicationContext;

		private List<WWindow<?>> windows = new ArrayList<>();

		WCallback<WWindow<Stage>, Boolean> onCloseCallback;

		private boolean maximizedShell;

		List<WWidget<?>> lastActivationTree = new ArrayList<WWidget<?>>();
		List<WWidget<?>> queuedTree = new ArrayList<WWidget<?>>();

		private static final String KEY_SCENE_3D_DEPRECATED = "fx.scene.3d"; //$NON-NLS-1$
		private static final String KEY_SCENE_3D = "efx.window.scene.3d"; //$NON-NLS-1$

		private static final String KEY_STAGE_DECORATION_DEPRECATED = "fx.stage.decoration"; //$NON-NLS-1$
		private static final String KEY_STAGE_DECORATION = "efx.window.decoration.fxml"; //$NON-NLS-1$

		private static final String KEY_STAGE_STYLE = "efx.window.stagestyle"; //$NON-NLS-1$
		private static final String KEY_STAGE_MODALITY = "efx.window.stagemodality"; //$NON-NLS-1$
		private static final String KEY_STAGE_UNDECORATED_DEPRECATED = "efx.window.undecorated"; //$NON-NLS-1$

		private static final String KEY_STAGE_ROOT_CONTENT = "efx.window.root.fxml"; //$NON-NLS-1$

		private StackPane overlayContainer;

		/**
		 * Pane used to mask background while maximized content is displayed
		 */
		private FillLayoutPane greyPane;
		/**
		 * Pane hosting the maximized component
		 */
		private FillLayoutPane maximizationContainer;
		/**
		 * Reference to the currently maximized widget
		 */
		private WLayoutedWidget<? extends MUIElement> maximizedWidget;

		@Inject
		@Optional
		private MaximizationTransitionService<Pane, Region> maximizationTransition;

		/**
		 * Create a new window
		 *
		 * @param mWindow
		 *            the window model element
		 * @param dispatcher
		 *            the keybinding dispatcher
		 * @param application
		 *            the application model element
		 * @param logger
		 *            the logger
		 */
		@Inject
		public WWindowImpl(@NonNull @Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MWindow mWindow, @Optional KeyBindingDispatcher dispatcher, MApplication application, @Log Logger logger) {
			this.mWindow = mWindow;

			this.applicationContext = application.getContext();

			if (mWindow.getPersistedState().get(KEY_SCENE_3D_DEPRECATED) != null) {
				logger.warning("Usage of deprecated persisted state 'fx.scene.3d' please use 'efx.window.scene.3d' instead."); //$NON-NLS-1$
				this.support3d = Boolean.parseBoolean(mWindow.getPersistedState().get(KEY_SCENE_3D_DEPRECATED));
			} else {
				this.support3d = Boolean.parseBoolean(mWindow.getPersistedState().get(KEY_SCENE_3D));
			}

			this.dispatcher = dispatcher;
			this.modelContext = mWindow.getContext();
			this.decorationFXML = mWindow.getPersistedState().get(KEY_STAGE_DECORATION_DEPRECATED);

			if (this.decorationFXML == null) {
				this.decorationFXML = mWindow.getPersistedState().get(KEY_STAGE_DECORATION);
			} else {
				logger.warning("Useage of deprecated persisted state 'fx.stage.decoration' please use 'efx.window.decoration.fxml' instead."); //$NON-NLS-1$
			}

			if (mWindow.getPersistedState().get(KEY_STAGE_STYLE) != null) {
				this.stageStyle = StageStyle.valueOf(mWindow.getPersistedState().get(KEY_STAGE_STYLE));
			} else if (mWindow.getPersistedState().get(KEY_STAGE_UNDECORATED_DEPRECATED) != null) {
				logger.warning("Usage of deprecated persisted state 'efx.window.undecorated' please use 'efx.window.stagestyle'"); //$NON-NLS-1$
				this.undecorated = Boolean.parseBoolean(mWindow.getPersistedState().get(KEY_STAGE_UNDECORATED_DEPRECATED));
			}

			this.rootFXML = mWindow.getPersistedState().get(KEY_STAGE_ROOT_CONTENT);
			if (this.decorationFXML != null && this.rootFXML != null) {
				logger.warning("You've specified a decorationXML and a rootFXML. Only rootFXML is used"); //$NON-NLS-1$
			}
		}

		@Override
		@PostConstruct
		protected void init() {
			this.initDone = true;
			super.init();
		}

		@Override
		protected void doCleanup() {
			super.doCleanup();
			this.sceneRegistration.dispose();
		}

		private static MWindow findParent(final EObject tmp) {
			EObject e = tmp;
			if (e.eContainer() instanceof MApplication) {
				return null;
			}

			do {
				e = e.eContainer();
				if (e instanceof MWindow) {
					return (MWindow) e;
				}
			} while (e.eContainer() != null);

			return null;
		}

		@Override
		public void setDialog(Object dialogNode) {
			@NonNull
			Pane staticLayoutNode = (@NonNull Pane) getStaticLayoutNode();
			if (dialogNode == null) {
				if (this.overlayContainer != null) {
					if( this.dialogTransitionService != null ) {
						this.dialogTransitionService.hideDialog(this.mWindow, staticLayoutNode, this.overlayContainer, this.overlayContainer, this.overlayContainer.getChildren().size() == 1 ? this.overlayContainer.getChildren().get(0) : null, () -> {
							((Pane) staticLayoutNode).getChildren().remove(this.overlayContainer);
							this.overlayContainer.getChildren().clear();
						});
					} else {
						((Pane) staticLayoutNode).getChildren().remove(this.overlayContainer);
						this.overlayContainer.getChildren().clear();
					}
				}
			} else {
				if (this.overlayContainer == null) {
					this.overlayContainer = new StackPane() {
						@Override
						protected void layoutChildren() {
							Insets insets = getInsets();
					        final double w = getWidth() - insets.getLeft() - insets.getRight();
					        final double h = getHeight() - insets.getTop() - insets.getBottom();

					        for( Node n : getManagedChildren() ) {
					        	double x,y;
					        	n.autosize();
					        	if( n instanceof Region ) {
					        		x = (w / 2) - (Math.min(w,((Region) n).getWidth()) / 2);
					        		y = (h / 2) - (Math.min(h,((Region) n).getHeight()) / 2);
					        	} else {
					        		x = (w / 2) - (Math.min(w,n.prefWidth(-1)) / 2);
					        		y = (h / 2) - (Math.min(h,n.prefHeight(-1)) / 2);
					        	}
					        	n.relocate(x, y);
					        }
						}
					};
					this.overlayContainer.getStyleClass().add("overlay-container"); //$NON-NLS-1$
					this.overlayContainer.setManaged(false);
					this.overlayContainer.setMouseTransparent(false);
					staticLayoutNode.layoutBoundsProperty().addListener( o -> {
						staticLayoutNode.layoutBoundsProperty().get();
						this.overlayContainer.resize(staticLayoutNode.getWidth(), staticLayoutNode.getHeight());
					});
				}

				this.overlayContainer.resize(staticLayoutNode.getWidth(), staticLayoutNode.getHeight());
				this.overlayContainer.getChildren().setAll((Node)dialogNode);
				this.overlayContainer.layout();
				((Pane) staticLayoutNode).getChildren().add(this.overlayContainer);
				if( this.dialogTransitionService != null ) {
					this.dialogTransitionService.showDialog(this.mWindow, staticLayoutNode, this.overlayContainer, this.overlayContainer, (Node)dialogNode, null);
				}
			}
		}

		@Override
		protected Stage createWidget() {
			Stage stage = new Stage();
			this.stage = stage;
			this.modelContext.set(E4Workbench.LOCAL_ACTIVE_SHELL, stage);
			MWindow parent = findParent((EObject) this.mWindow);
			if (parent != null) {
				this.stage.initOwner((Window) ((WWindow<?>) parent.getWidget()).getWidget());
			}

			this.stage.setOnCloseRequest(this::handleOnCloseRequest);

			this.stage.focusedProperty().addListener(this::handledFocus);
			this.stage.setFullScreen(this.fullscreen);
			this.stage.maximizedProperty().addListener((o) -> {
				if( this.stage.isMaximized() ) {
					this.mWindow.getTags().add(BaseWindowRenderer.TAG_SHELLMAXIMIZED);
				} else {
					this.mWindow.getTags().remove(BaseWindowRenderer.TAG_SHELLMAXIMIZED);
				}
			});
			if( this.mWindow.getPersistedState().containsKey(KEY_STAGE_MODALITY) ) {
				this.stage.initModality(Modality.valueOf(this.mWindow.getPersistedState().get(KEY_STAGE_MODALITY)));
			}

			this.stage.fullScreenProperty().addListener(this::handleFullscreen);

			if (this.dispatcher != null) {
				this.stage.addEventFilter(KeyEvent.KEY_PRESSED, this.dispatcher.getKeyHandler());
			}

			this.trimPane = new BorderPane();
			this.trimPane.getStyleClass().add(CSS_TRIM_CONTAINER);
			this.contentPane = new FillLayoutPane();
			this.contentPane.getStyleClass().add(CSS_CONTENT_CONTAINER);
			this.trimPane.setCenter(new StackPane(this.contentPane));

			if (this.rootFXML != null) {
				this.rootPane = createRootContainer(stage);
				if (this.rootPane != null) {
					if (this.rootPane instanceof org.eclipse.fx.ui.controls.stage.Frame) {
						((org.eclipse.fx.ui.controls.stage.Frame) this.rootPane).setClientArea(this.trimPane);
					} else if (this.rootPane instanceof BorderPane) {
						Node clientArea = this.rootPane.lookup("#" + ID_CLIENT_AREA); //$NON-NLS-1$
						if (clientArea != null) {
							addNodeToCustomParent(java.util.Optional.ofNullable(this.trimPane), clientArea, ID_CLIENT_AREA);
						} else {
							((BorderPane) this.rootPane).setCenter(this.trimPane);
						}
					} else {
						this.logger.warning("Unhandled type of root pane: " + this.rootPane.getClass().getName()); //$NON-NLS-1$
					}
				}
			}
			if (this.rootPane == null) {
				BorderPane rootPane = new BorderPane() {
					@Override
					protected void layoutChildren() {
						super.layoutChildren();
						if (WWindowImpl.this.windowResizeButton != null) {
							WWindowImpl.this.windowResizeButton.autosize();

							WWindowImpl.this.windowResizeButton.setLayoutX(getWidth() - WWindowImpl.this.windowResizeButton.getLayoutBounds().getWidth());
							WWindowImpl.this.windowResizeButton.setLayoutY(getHeight() - WWindowImpl.this.windowResizeButton.getLayoutBounds().getHeight());
						}
					}
				};
				this.rootPane = rootPane;

				rootPane.setCenter(this.trimPane);

				if (this.decorationFXML != null) {
					this.windowResizeButton = new WindowResizeButton(this.stage, 50, 50);
					this.decoratorPane = new BorderPane();
					this.decoratorPane.setTop(createTopDecoration(this.stage));
					rootPane.setTop(this.decoratorPane);
				}
			}

			if (this.stageStyle != null) {
				this.stage.initStyle(this.stageStyle);
			} else if (this.undecorated) {
				this.stage.initStyle(StageStyle.UNDECORATED);
			}

			// TODO Should we create the scene on show???
			Scene s;
			if (this.support3d && Platform.isSupported(ConditionalFeature.SCENE3D)) {
				s = new Scene(this.rootPane, this.mWindow.getWidth(), this.mWindow.getHeight(), true);
				s.setCamera(new PerspectiveCamera());
			} else {
				s = new Scene(this.rootPane, this.mWindow.getWidth(), this.mWindow.getHeight());
			}

			if( this.stage.getStyle() == StageStyle.TRANSPARENT ) {
				s.setFill(Color.TRANSPARENT);
			}

			// Add a css which sets defaults
			{
				URL url = getClass().getClassLoader().getResource("css/efx-default.css"); //$NON-NLS-1$
				if (url != null) {
					s.getStylesheets().add(url.toExternalForm());
				} else {
					this.logger.error("Unable to load css 'css/efx-default.css'"); //$NON-NLS-1$
				}
			}

			s.focusOwnerProperty().addListener(this::handleFocusOwner);

			if (this.themeManager != null) {
//				Theme theme = this.themeManager.getCurrentTheme();
//				if (theme != null) {
//					List<String> sUrls = new ArrayList<String>();
//					for (URL url : theme.getStylesheetURL()) {
//						sUrls.add(url.toExternalForm());
//					}
//
//					s.getStylesheets().addAll(sUrls);
//				}
				this.sceneRegistration = this.themeManager.registerScene(s);
			}

			if (this.windowResizeButton != null) {
				this.rootPane.getChildren().add(this.windowResizeButton);
			}

			this.stage.setScene(s);

			this.modelContext.set(Stage.class, this.stage);
			this.modelContext.set(Scene.class, s);

			return stage;
		}

		private void handleOnCloseRequest(WindowEvent event) {
			if (this.onCloseCallback != null) {
				if (!Boolean.TRUE.equals(this.onCloseCallback.call(this))) {
					event.consume();
				}
			}
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull Node getStaticLayoutNode() {
			return this.rootPane;
		}

		private void handleFullscreen(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {
			this.mWindow.getPersistedState().put(BaseWindowRenderer.KEY_FULL_SCREEN, newValue.toString());
		}

		private void handledFocus(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			if (newValue.booleanValue()) {
				activateWindow();
			} else {
				deactivate();
			}
		}

		private void activateWindow() {
			if (this.stage.getScene() != null) {
				this.applicationContext.set(Constants.APP_FOCUS_NODE, this.stage.getScene().getFocusOwner());
			}

			if (!isActive()) {
				activate();
				this.eventBroker.send(Constants.WINDOW_ACTIVATED, getDomElement());
			}
		}

		@Override
		public void activate() {
			super.activate();
			if( this.stage != null && ! this.stage.isFocused() ) {
				this.stage.requestFocus();
			}
		}

		private void handleFocusOwner(ObservableValue<? extends Node> observable, Node oldValue, Node _newValue) {
			Node newValue = _newValue;
			WWindowImpl.this.modelContext.set(Constants.WINDOW_FOCUS_NODE, newValue);
			if (WWindowImpl.this.stage.isFocused()) {
				WWindowImpl.this.applicationContext.set(Constants.APP_FOCUS_NODE, newValue);
			}

			if (newValue != null) {
				final List<WWidget<?>> activationTree = new ArrayList<WWidget<?>>();

				do {
					if (newValue.getUserData() instanceof WWidget<?>) {
						activationTree.add((WWidget<?>) newValue.getUserData());
					}
				} while ((newValue = newValue.getParent()) != null);

				if (!this.lastActivationTree.equals(activationTree)) {
					final List<WWidget<?>> oldTreeReversed = new ArrayList<WWidget<?>>(this.lastActivationTree);
					final List<WWidget<?>> newTreeReversed = new ArrayList<WWidget<?>>(activationTree);
					Collections.reverse(oldTreeReversed);
					Collections.reverse(newTreeReversed);
					Iterator<WWidget<?>> it = newTreeReversed.iterator();

					while (it.hasNext()) {
						if (!oldTreeReversed.isEmpty()) {
							if (oldTreeReversed.get(0) == it.next()) {
								oldTreeReversed.remove(0);
								it.remove();
							} else {
								break;
							}
						} else {
							break;
						}
					}

					Collections.reverse(oldTreeReversed);
					Collections.reverse(newTreeReversed);

					this.queuedTree = activationTree;

					// Delay the execution maybe there's an intermediate
					// state we are not interested in
					// http://javafx-jira.kenai.com/browse/RT-24069
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							if (WWindowImpl.this.queuedTree == activationTree) {
								WWindowImpl.this.lastActivationTree = activationTree;
								for (WWidget<?> w : oldTreeReversed) {
									w.deactivate();
								}

								for (WWidget<?> w : newTreeReversed) {
									w.activate();
								}
							}
						}
					});
				}
			}
		}

		private Pane createRootContainer(final Stage stage) {
			URI uri = URI.createURI(this.rootFXML);

			if (uri != null) {
				stage.initStyle(StageStyle.UNDECORATED);

				Bundle b = org.eclipse.core.runtime.Platform.getBundle(uri.segment(1));
				if (b != null) {
					try {
						StringBuilder sb = new StringBuilder();
						for (int i = 2; i < uri.segmentCount(); i++) {
							if (sb.length() != 0) {
								sb.append("/"); //$NON-NLS-1$
							}
							sb.append(uri.segment(i));
						}

						@SuppressWarnings("null")
						InjectingFXMLLoader<Node> loader = InjectingFXMLLoader.create(this.modelContext, b, sb.toString());
						ResourceBundle resourceBundle = this.localizationService.getLocalization(b, Locale.getDefault().toString());
						if (resourceBundle != null) {
							loader.resourceBundle(resourceBundle);
						}

						Pane load = (Pane) loader.load();
						ContextInjectionFactory.inject(load, this.modelContext);
						return load;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			return null;
		}

		private Node createTopDecoration(final Stage stage) {
			URI uri = URI.createURI(this.decorationFXML);

			if (uri != null) {
				stage.initStyle(StageStyle.UNDECORATED);

				Bundle b = org.eclipse.core.runtime.Platform.getBundle(uri.segment(1));
				if (b != null) {
					try {
						StringBuilder sb = new StringBuilder();
						for (int i = 2; i < uri.segmentCount(); i++) {
							if (sb.length() != 0) {
								sb.append("/"); //$NON-NLS-1$
							}
							sb.append(uri.segment(i));
						}

						@SuppressWarnings("null")
						InjectingFXMLLoader<Node> loader = InjectingFXMLLoader.create(this.modelContext, b, sb.toString());
						ResourceBundle resourceBundle = this.localizationService.getLocalization(b, Locale.getDefault().toString());
						if (resourceBundle != null) {
							loader.resourceBundle(resourceBundle);
						}

						return (Node) loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			return null;
		}

		@SuppressWarnings("null")
		@Override
		protected void bindProperties(Stage widget) {
			super.bindProperties(widget);
			bindProperty(UIEvents.Window.X, widget.xProperty());
			bindProperty(UIEvents.Window.Y, widget.yProperty());
			bindProperty(UIEvents.Window.WIDTH, widget.widthProperty());
			bindProperty(UIEvents.Window.HEIGHT, widget.heightProperty());
		}

		@Override
		public void setMainMenu(WLayoutedWidget<MMenu> menuWidget) {
			Node node = getStaticLayoutNodeOrNull(menuWidget);
			if (this.decoratorPane == null) {
				if (this.rootPane instanceof org.eclipse.fx.ui.controls.stage.Window) {
					((org.eclipse.fx.ui.controls.stage.Window) this.rootPane).setMenuBar(node);
				} else {
					// Check if a custom location for the MenuBar has been provided
					Node menuBarArea = this.rootPane.lookup("#" + ID_MENU_BAR_AREA); //$NON-NLS-1$
					if (menuBarArea != null) {
						addNodeToCustomParent(java.util.Optional.ofNullable(node), menuBarArea, ID_MENU_BAR_AREA);
					} else {
						((BorderPane) this.rootPane).setTop(node);
					}
				}
			} else {
				this.decoratorPane.setBottom(node);
			}
		}

		/*
		 * Adds or removes a node from a custom parent. The parameter optionalNode signals, whether this
		 * is a removal, or an addition.
		 */
		private void addNodeToCustomParent(java.util.Optional<Node> optionalNode, Node customParent, String id) {
			if (customParent instanceof BorderPane) {
				if (id.equals(ID_MENU_BAR_AREA)) {
					((BorderPane)customParent).setTop(optionalNode.orElse(null));
				} else {
					((BorderPane)customParent).setCenter(optionalNode.orElse(null));
				}
			} else if (customParent instanceof Pane) {
				if (optionalNode.isPresent()) {
					Node node = optionalNode.get();
					((Pane)customParent).getChildren().add(0, node);

					if (customParent instanceof HBox) {
						HBox.setHgrow(node, Priority.ALWAYS);
					} else if (customParent instanceof HBox) {
						VBox.setVgrow(node, Priority.ALWAYS);
					} else if (customParent instanceof AnchorPane) {
						AnchorPane.setTopAnchor(node, new Double(0));
						AnchorPane.setRightAnchor(node, new Double(0));
						AnchorPane.setBottomAnchor(node, new Double(0));
						AnchorPane.setLeftAnchor(node, new Double(0));
					}
				} else {
					((Pane)customParent).getChildren().remove(0);
				}
			} else {
				this.logger.error("Could not add child to customParent: Expecting BorderPane or Pane"); //$NON-NLS-1$
			}
		}

		@Override
		public Pane getWidgetNode() {
			return this.rootPane;
		}

		@Override
		public void setOnCloseCallback(WCallback<WWindow<Stage>, Boolean> onCloseCallback) {
			this.onCloseCallback = onCloseCallback;
		}

		/**
		 * set a new x coordinate
		 *
		 * @param _x
		 *            the new x
		 */
		@SuppressWarnings("null")
		@Inject
		public void setX(@Named(UIEvents.Window.X) int _x) {
			if (!isPropertyChangeInProgress(UIEvents.Window.X)) {
				int x = _x;
				if (x == -2147483648) {
					x = 0;
				}
				getWidget().setX(x);
			}
		}

		/**
		 * set a new y coordinate
		 *
		 * @param _y
		 *            the new y
		 */
		@SuppressWarnings("null")
		@Inject
		public void setY(@Named(UIEvents.Window.Y) int _y) {
			if (!isPropertyChangeInProgress(UIEvents.Window.Y)) {
				int y = _y;
				if (y == -2147483648) {
					y = 0;
				}
				getWidget().setY(y);
			}
		}

		/**
		 * set a new width
		 *
		 * @param w
		 *            the new width
		 */
		@SuppressWarnings("null")
		@Inject
		public void setWidth(@Named(UIEvents.Window.WIDTH) int w) {
			if (!isPropertyChangeInProgress(UIEvents.Window.WIDTH)) {
				Stage widget = getWidget();
				double cw = Util.unsignedConstraintValue(w, this.rootPane.getMinWidth(), this.rootPane.getMaxWidth());
				widget.setWidth(cw);
			}
		}

		/**
		 * set a new height
		 *
		 * @param h
		 *            the new height
		 */
		@SuppressWarnings("null")
		@Inject
		public void setHeight(@Named(UIEvents.Window.HEIGHT) int h) {
			if (!isPropertyChangeInProgress(UIEvents.Window.HEIGHT)) {
				Stage widget = getWidget();
				double ch = Util.unsignedConstraintValue(h, this.rootPane.getMinHeight(), this.rootPane.getMaxHeight());
				widget.setHeight(ch);
			}
		}

		/**
		 * update the visibility of the window
		 *
		 * @param visible
		 *            the new visible value
		 */
		@Inject
		public void setVisible(@Named(UIEvents.UIElement.VISIBLE) boolean visible) {
			// Skip the init injection because the renderer will take care of
			// showing the stage
			if (!this.initDone) {
				return;
			}

			if (visible) {
				internalShow();
			} else {
				internalHide();
			}
		}

		/**
		 * Set the new tags list
		 *
		 * @param tags
		 *            the tags
		 */
		@Inject
		public void setTags(@Optional @Named(UIEvents.ApplicationElement.TAGS) List<String> tags) {
			if (tags != null) {
				this.maximizedShell = tags.contains(BaseWindowRenderer.TAG_SHELLMAXIMIZED);
				if (this.stage != null) {
					this.stage.setMaximized(this.maximizedShell);
				}
			}
		}

		/**
		 * Make stage shown in fullscreen
		 *
		 * @param fullScreen
		 *            the new state
		 */
		@Inject
		public void setFullscreen(@Named(UIEvents.ApplicationElement.PERSISTEDSTATE + "_" + BaseWindowRenderer.KEY_FULL_SCREEN) @Optional String fullScreen) {
			if (fullScreen != null) {
				this.fullscreen = Boolean.parseBoolean(fullScreen);
				if (this.stage != null) {
					this.stage.setFullScreen(this.fullscreen);
				}
			} else {
				this.fullscreen = false;
			}
		}

		@Override
		public void addStyleClasses(List<String> classnames) {
			this.rootPane.getStyleClass().addAll(classnames);
		}

		@Override
		public void setStyleId(String id) {
			this.rootPane.setId(id);
		}

		@Override
		public void show() {
			internalShow();
			getWidget().toFront();
		}

		@Override
		public void close() {
			if( this.rootPane instanceof Frame ) {
				((Frame)this.rootPane).close();
			} else {
				getWidget().close();
			}

		}

		@Override
		public void addChildWindow(WWindow<?> widget) {
			this.windows.add(widget);
			if (this.initDone && this.stage.isShowing()) {
				Stage s = (Stage) widget.getWidget();
				s.show();
			}
		}

		@Override
		public void removeChildWindow(@NonNull WWindow<?> widget) {
			Stage s = (Stage) widget.getWidget();
			s.hide();
			this.windows.remove(widget);
		}

		private void internalShow() {
			if (getWidget().isShowing()) {
				return;
			}

			if (this.windowTransitionService != null) {
				AnimationDelegate<Stage> delegate = this.windowTransitionService.getShowDelegate(this.mWindow);
				if (delegate != null) {
					delegate.animate(getWidget(), () -> {
						activateWindow();
						// Need to delay bit else maximize different things
						// don't operation appropiately!
						// need to file FX-Bug for that
						Platform.runLater(() -> {
								this.stage.setMaximized(this.maximizedShell);
						} );
						this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
					} );
				} else {
					getWidget().show();
					// force activation of the stage see 435273
					activateWindow();
					// Need to delay bit else maximize different things don't
					// operation appropiately!
					// need to file FX-Bug for that
					Platform.runLater(() -> {
						this.stage.setMaximized(this.maximizedShell);
					} );
					this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
				}
			} else {
				getWidget().show();
				// force activation of the stage see 435273
				activateWindow();
				// Need to delay bit else maximize different things don't
				// operation appropiately!
				// need to file FX-Bug for that
				Platform.runLater(() -> {
					this.stage.setMaximized(this.maximizedShell);
				} );
				this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
			}

			// I don't think sub-windows should be activated
			for (WWindow<?> c : this.windows) {
				c.show();
				this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
			}

			// Force the focus back on ourselves
			if (this.windows.size() > 0) {
				this.stage.requestFocus();
				// force activation of the stage see 435273
				activateWindow();
			}
		}

		private void internalHide() {
			// TODO Do we need to hide them recursively???
			if (this.windowTransitionService != null) {
				AnimationDelegate<Stage> delegate = this.windowTransitionService.getShowDelegate(this.mWindow);
				if (delegate != null) {
					delegate.animate(getWidget(), () -> {
						this.eventBroker.send(Constants.WINDOW_HIDDEN, this.mWindow);
					} );
				} else {
					getWidget().hide();
					this.eventBroker.send(Constants.WINDOW_HIDDEN, this.mWindow);
				}
			} else {
				getWidget().hide();
				this.eventBroker.send(Constants.WINDOW_HIDDEN, this.mWindow);
			}
		}

		/**
		 * Set a new window title
		 *
		 * @param title
		 *            the new title
		 */
		@Inject
		public void setTitle(@Named(UIEvents.UILabel.LOCALIZED_LABEL) String title) {
			getWidget().setTitle(title);
			if (this.rootPane instanceof org.eclipse.fx.ui.controls.stage.Window) {
				((org.eclipse.fx.ui.controls.stage.Window) this.rootPane).setTitle(title);
			}
		}

		/**
		 * Set a window icon. Icons of multiple sizes can be set by separating
		 * the urls using a ; (semicolon)
		 *
		 * @param iconUri
		 *            the new icon
		 */
		@Inject
		public void setImageUrl(@Named(UIEvents.UILabel.ICONURI) @Optional String iconUri) {
			if (!Strings.isNullOrEmpty(iconUri)) {

				String[] split = iconUri.split(";"); //$NON-NLS-1$
				List<Image> images = new ArrayList<>();
				for (String uri : split) {
					@SuppressWarnings("null")
					Image img = this.graphicsLoader.getImage(new EMFUri(URI.createURI(uri)));
					if (img != null) {
						images.add(img);
					}
				}

				getWidget().getIcons().setAll(images);
			} else {
				getWidget().getIcons().clear();
			}
		}

		@Override
		public void setBottomTrim(WLayoutedWidget<MTrimBar> trimBar) {
			Node node = getStaticLayoutNodeOrNull(trimBar);
			if (this.rootPane instanceof TrimmedWindow) {
				((TrimmedWindow) this.rootPane).setBottomTrim(node);
			} else {
				// Check if a custom location has been provided
				Node area = this.rootPane.lookup("#" + ID_BOTTOM_TRIM_AREA); //$NON-NLS-1$
				if (area != null) {
					addNodeToCustomParent(java.util.Optional.ofNullable(node), area, ID_BOTTOM_TRIM_AREA);
				} else {
					this.trimPane.setBottom(node);
				}
			}
		}

		@Override
		public void setLeftTrim(WLayoutedWidget<MTrimBar> trimBar) {
			Node node = getStaticLayoutNodeOrNull(trimBar);
			if (this.rootPane instanceof TrimmedWindow) {
				((TrimmedWindow) this.rootPane).setLeftTrim(node);
			} else {
				// Check if a custom location has been provided
				Node area = this.rootPane.lookup("#" + ID_LEFT_TRIM_AREA); //$NON-NLS-1$
				if (area != null) {
					addNodeToCustomParent(java.util.Optional.ofNullable(node), area, ID_LEFT_TRIM_AREA);
				} else {
					this.trimPane.setLeft(node);
				}
			}
		}

		@Override
		public void setRightTrim(WLayoutedWidget<MTrimBar> trimBar) {
			Node node = getStaticLayoutNodeOrNull(trimBar);
			if (this.rootPane instanceof TrimmedWindow) {
				((TrimmedWindow) this.rootPane).setRightTrim(node);
			} else {
				// Check if a custom location has been provided
				Node area = this.rootPane.lookup("#" + ID_RIGHT_TRIM_AREA); //$NON-NLS-1$
				if (area != null) {
					addNodeToCustomParent(java.util.Optional.ofNullable(node), area, ID_RIGHT_TRIM_AREA);
				} else {
					this.trimPane.setRight(node);
				}
			}
		}

		@Override
		public void setTopTrim(WLayoutedWidget<MTrimBar> trimBar) {
			Node node = getStaticLayoutNodeOrNull(trimBar);
			if (this.rootPane instanceof TrimmedWindow) {
				((TrimmedWindow) this.rootPane).setTopTrim(node);
			} else {
				// Check if a custom location has been provided
				Node area = this.rootPane.lookup("#" + ID_TOP_TRIM_AREA); //$NON-NLS-1$
				if (area != null) {
					addNodeToCustomParent(java.util.Optional.ofNullable(node), area, ID_TOP_TRIM_AREA);
				} else {
					this.trimPane.setTop(node);
				}
			}
		}

		private static Node getStaticLayoutNodeOrNull(WLayoutedWidget<?> trimBar) {
			if (trimBar != null) {
				return (Node) trimBar.getStaticLayoutNode();
			}
			return null;
		}

		@Override
		public void addChild(WLayoutedWidget<MWindowElement> widget) {
			this.contentPane.getChildren().add((Node) widget.getStaticLayoutNode());
		}

		@Override
		public void removeChild(WLayoutedWidget<MWindowElement> widget) {
			this.contentPane.getChildren().remove((Node) widget.getStaticLayoutNode());
		}

		@Override
		public void addChild(int idx, WLayoutedWidget<MWindowElement> widget) {
			this.contentPane.getChildren().add(idx, (Node) widget.getStaticLayoutNode());
		}

		@Override
		public void setMaximizedContent(WLayoutedWidget<? extends MUIElement> widget) {
			if (this.maximizedWidget != null) {
				return;
			}

			final WLayoutedWidget<? extends MUIElement> childWidget = widget;

			Pane staticLayoutNode = (Pane) this.trimPane.getCenter();
			this.maximizedWidget = widget;

			final FillLayoutPane maximizationContainer = new FillLayoutPane();
			final FillLayoutPane greyPane = new FillLayoutPane();
			greyPane.getStyleClass().add("maximization-container"); //$NON-NLS-1$
			greyPane.setOpacity(0.0);

			int size = staticLayoutNode.getChildren().size();
			if (this.overlayContainer == staticLayoutNode.getChildren().get(size - 1)) {
				// do not cover overlay container
				staticLayoutNode.getChildren().add(size - 1, greyPane);
				staticLayoutNode.getChildren().add(size, maximizationContainer);
			} else {
				staticLayoutNode.getChildren().add(greyPane);
				staticLayoutNode.getChildren().add(maximizationContainer);
			}

			Runnable finisher = () -> {
				maximizationContainer.getChildren().clear();
				maximizationContainer.getChildren().add((Region) childWidget.getWidgetNode());
				greyPane.setOpacity(1.0);
				this.maximizationContainer = maximizationContainer;
				this.greyPane = greyPane;
			};

			if(this.maximizationTransition != null) {
				this.maximizationTransition.maximize(staticLayoutNode, greyPane, maximizationContainer, (Region) childWidget.getWidgetNode(), finisher);
			} else {
				finisher.run();
			}
		}

		@Override
		public void removeMaximizedContent() {
			if (this.maximizationContainer != null) {
				Pane staticLayoutNode = (Pane) this.trimPane.getCenter();

				Pane childStaticNode = (Pane) this.maximizedWidget.getStaticLayoutNode();
				Region childPane = (Region) this.maximizedWidget.getWidgetNode();

				FillLayoutPane maximizationContainer = this.maximizationContainer;
				FillLayoutPane greyPane = this.greyPane;
				this.maximizationContainer = null;
				this.maximizedWidget = null;

				Runnable finisher = () -> {
					staticLayoutNode.getChildren().remove(greyPane);
					staticLayoutNode.getChildren().remove(maximizationContainer);
					childStaticNode.getChildren().add(childPane);
				};

				if(this.maximizationTransition != null) {
					this.maximizationTransition.restore(staticLayoutNode, greyPane, maximizationContainer, childStaticNode, childPane, finisher);
				} else {
					finisher.run();
				}
			}
		}
	}

	static class WindowResizeButton extends Region {
		double dragOffsetX;
		double dragOffsetY;
		final Stage stage;
		final double stageMinimumWidth;
		final double stageMinimumHeight;

		public WindowResizeButton(final Stage stage, final double stageMinimumWidth, final double stageMinimumHeight) {
			this.stage = stage;
			this.stageMinimumWidth = stageMinimumWidth;
			this.stageMinimumHeight = stageMinimumHeight;
			setId("window-resize-button"); //$NON-NLS-1$
			setPrefSize(11, 11);
			setOnMousePressed(this::handleMousePressed);
			setOnMouseDragged(this::handleMouseDragged);
		}

		void handleMousePressed(MouseEvent e) {
			this.dragOffsetX = (this.stage.getX() + this.stage.getWidth()) - e.getScreenX();
			this.dragOffsetY = (this.stage.getY() + this.stage.getHeight()) - e.getScreenY();
			e.consume();
		}

		void handleMouseDragged(MouseEvent e) {
			ObservableList<Screen> screens = Screen.getScreensForRectangle(this.stage.getX(), this.stage.getY(), 1, 1);
			final Screen screen;
			if (screens.size() > 0) {
				screen = Screen.getScreensForRectangle(this.stage.getX(), this.stage.getY(), 1, 1).get(0);
			} else {
				screen = Screen.getScreensForRectangle(0, 0, 1, 1).get(0);
			}
			Rectangle2D visualBounds = screen.getVisualBounds();
			double maxX = Math.min(visualBounds.getMaxX(), e.getScreenX() + WindowResizeButton.this.dragOffsetX);
			double maxY = Math.min(visualBounds.getMaxY(), e.getScreenY() - WindowResizeButton.this.dragOffsetY);
			this.stage.setWidth(Math.max(this.stageMinimumWidth, maxX - this.stage.getX()));
			this.stage.setHeight(Math.max(this.stageMinimumHeight, maxY - this.stage.getY()));
			e.consume();
		}
	}
}
