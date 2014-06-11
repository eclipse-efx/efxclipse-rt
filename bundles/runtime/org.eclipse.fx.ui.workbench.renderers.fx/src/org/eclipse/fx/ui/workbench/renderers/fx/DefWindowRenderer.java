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

import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler.Save;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
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
import org.eclipse.fx.ui.workbench.renderers.base.services.WindowTransitionService;
import org.eclipse.fx.ui.workbench.renderers.base.services.WindowTransitionService.AnimationDelegate;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.Messages;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.osgi.service.localization.BundleLocalization;
import org.osgi.framework.Bundle;

/**
 * Default implementation of a window renderer
 */
@SuppressWarnings("restriction")
public class DefWindowRenderer extends BaseWindowRenderer<Stage> {
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
		if( modelContext == null ) {
			getLogger().error("Model context should not be null at this point"); //$NON-NLS-1$
			Arrays.fill(response, Save.CANCEL);
			return Arrays.asList(response);
		}
		GraphicsLoader graphicsLoader = modelContext.get(GraphicsLoader.class);

		MultiMessageDialog d = new MultiMessageDialog((Stage) widget.getWidget(), dirtyParts, graphicsLoader);
		if (d.open() == Dialog.OK_BUTTON) {
			List<MPart> parts = d.getSelectedParts();
			Arrays.fill(response, Save.NO);
			for (MPart p : parts) {
				response[parts.indexOf(p)] = Save.YES;
			}
		} else {
			Arrays.fill(response, Save.CANCEL);
		}

		return Arrays.asList(response);
	}
	
	@Override
	protected Save promptToSave(MWindow element, MPart dirtyPart, WWindow<Stage> widget) { 
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

	@Override
	protected Class<? extends WWindow<Stage>> getWidgetClass(MWindow window) {
		return WWindowImpl.class;
	}

	/**
	 * Default implementation of a window
	 */
	public static class WWindowImpl extends WLayoutedWidgetImpl<Stage, BorderPane, MWindow> implements WWindow<Stage> {
		private boolean support3d;
		private BorderPane rootPane;
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

		private boolean fullscreen;

		@Inject
		IEclipseContext context;

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
		private GraphicsLoader graphicsLoader;
		
		@Inject
		private IEventBroker eventBroker;

		boolean initDone;

		private boolean undecorated;

		private StageStyle stageStyle;

		IEclipseContext applicationContext;

		private List<WWindow<Stage>> windows = new ArrayList<>();

		WCallback<WWindow<Stage>, Boolean> onCloseCallback;

		private Boolean maximizedShell;

		List<WWidget<?>> lastActivationTree = new ArrayList<WWidget<?>>();
		List<WWidget<?>> queuedTree = new ArrayList<WWidget<?>>();

		private static final String KEY_SCENE_3D_DEPRECATED = "fx.scene.3d"; //$NON-NLS-1$
		private static final String KEY_SCENE_3D = "efx.window.scene.3d"; //$NON-NLS-1$

		private static final String KEY_STAGE_DECORATION_DEPRECATED = "fx.stage.decoration"; //$NON-NLS-1$
		private static final String KEY_STAGE_DECORATION = "efx.window.decoration.fxml"; //$NON-NLS-1$

		private static final String KEY_STAGE_STYLE = "efx.window.stagestyle"; //$NON-NLS-1$
		private static final String KEY_STAGE_UNDECORATED_DEPRECATED = "efx.window.undecorated"; //$NON-NLS-1$

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

			if (mWindow.getTags().contains(BaseWindowRenderer.TAG_SHELLMAXIMIZED)) {
				this.maximizedShell = Boolean.TRUE;
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
		protected Stage createWidget() {
			Stage stage = new Stage();
			this.stage = stage;
			MWindow parent = findParent((EObject) this.mWindow);
			if (parent != null) {
				this.stage.initOwner((Window) ((WWindow<?>) parent.getWidget()).getWidget());
			}

			this.stage.setOnCloseRequest(this::handleOnCloseRequest);

			this.stage.focusedProperty().addListener(this::handledFocus);
			if (this.maximizedShell != null) {
				this.stage.setMaximized(this.maximizedShell.booleanValue());
			}
			this.stage.setFullScreen(this.fullscreen);
			this.stage.fullScreenProperty().addListener(this::handleFullscreen);

			if (this.dispatcher != null) {
				this.stage.addEventFilter(KeyEvent.KEY_PRESSED, this.dispatcher.getKeyHandler());
			}

			this.rootPane = new BorderPane() {
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

			this.trimPane = new BorderPane();
			this.rootPane.setCenter(this.trimPane);
			this.contentPane = new FillLayoutPane();
			this.trimPane.setCenter(this.contentPane);

			if (this.decorationFXML != null) {
				this.windowResizeButton = new WindowResizeButton(this.stage, 50, 50);
				this.decoratorPane = new BorderPane();
				this.decoratorPane.setTop(createTopDecoration(this.stage));
				this.rootPane.setTop(this.decoratorPane);
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
			
			// Add a css which sets defaults
			{
				URL url = getClass().getClassLoader().getResource("css/efx-default.css"); //$NON-NLS-1$
				if( url != null ) {
					s.getStylesheets().add(url.toExternalForm());				
				} else {
					this.logger.error("Unable to load css 'css/efx-default.css'"); //$NON-NLS-1$
				}
			}

			s.focusOwnerProperty().addListener(this::handleFocusOwner);

			if (this.themeManager != null) {
				Theme theme = this.themeManager.getCurrentTheme();
				if (theme != null) {
					List<String> sUrls = new ArrayList<String>();
					for (URL url : theme.getStylesheetURL()) {
						sUrls.add(url.toExternalForm());
					}

					s.getStylesheets().addAll(sUrls);
				}
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

		private void handleFullscreen(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {
			this.mWindow.getPersistedState().put(BaseWindowRenderer.KEY_FULL_SCREEN, newValue.toString());
		}

		private void handledFocus(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			if (newValue.booleanValue()) {
				activateWindow();
			}
		}
		
		private void activateWindow() {
			if (this.stage.getScene() != null) {
				this.applicationContext.set(Constants.APP_FOCUS_NODE, this.stage.getScene().getFocusOwner());
			}

			if( ! isActive() ) {
				activate();
				this.eventBroker.send(Constants.WINDOW_ACTIVATED, getDomElement());
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

						InjectingFXMLLoader<Node> loader = InjectingFXMLLoader.create(this.context, b, sb.toString());
						ResourceBundle resourceBundle = this.localizationService.getLocalization(b, Locale.getDefault().toString());
						if( resourceBundle != null ) {
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
			if (this.decoratorPane == null) {
				if( menuWidget == null ) {
					this.rootPane.setTop(null);
				} else {
					this.rootPane.setTop((Node) menuWidget.getStaticLayoutNode());	
				}
			} else {
				if( menuWidget == null ) {
					this.decoratorPane.setBottom(null);
				} else {
					this.decoratorPane.setBottom((Node) menuWidget.getStaticLayoutNode());	
				}
				
			}
		}

		@Override
		protected BorderPane getWidgetNode() {
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
		@Inject
		public void setX(@Named(UIEvents.Window.X) int _x) {
			int x = _x;
			if (x == -2147483648) {
				x = 0;
			}
			getWidget().setX(x);
		}

		/**
		 * set a new y coordinate
		 * 
		 * @param _y
		 *            the new y
		 */
		@Inject
		public void setY(@Named(UIEvents.Window.Y) int _y) {
			int y = _y;
			if (y == -2147483648) {
				y = 0;
			}
			getWidget().setY(y);
		}

		/**
		 * set a new width
		 * 
		 * @param w
		 *            the new width
		 */
		@Inject
		public void setWidth(@Named(UIEvents.Window.WIDTH) int w) {
			getWidget().setWidth(w);
		}

		/**
		 * set a new height
		 * 
		 * @param h
		 *            the new height
		 */
		@Inject
		public void setHeight(@Named(UIEvents.Window.HEIGHT) int h) {
			getWidget().setHeight(h);
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
			getWidget().close();
		}

		@Override
		public void addChildWindow(WWindow<Stage> widget) {
			this.windows.add(widget);
			if (this.initDone && this.stage.isShowing()) {
				Stage s = (Stage) widget.getWidget();
				s.show();
			}
		}

		@Override
		public void removeChildWindow(@NonNull WWindow<Stage> widget) {
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
						this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
					});
				} else {
					getWidget().show();
					// force activation of the stage see 435273
					activateWindow();
					this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
				}
			} else {
				getWidget().show();
				// force activation of the stage see 435273
				activateWindow();
				this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
			}
			
			// I don't think sub-windows should be activated
			for (WWindow<Stage> c : this.windows) {
				c.show();
				this.eventBroker.send(Constants.WINDOW_SHOWN, this.mWindow);
			}
			
			// Force the focus back on ourselves
			if( this.windows.size() > 0 ) {
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
					});
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
		public void setTitle(@Named(ATTRIBUTE_localizedLabel) String title) {
			getWidget().setTitle(title);
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
			if (iconUri != null) {

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
			if( trimBar == null ) {
				this.trimPane.setBottom(null);
			} else {
				this.trimPane.setBottom((Node) trimBar.getStaticLayoutNode());	
			}
			
		}

		@Override
		public void setLeftTrim(WLayoutedWidget<MTrimBar> trimBar) {
			if( trimBar == null ) {
				this.trimPane.setLeft(null);
			} else {
				this.trimPane.setLeft((Node) trimBar.getStaticLayoutNode());	
			}
			
		}

		@Override
		public void setRightTrim(WLayoutedWidget<MTrimBar> trimBar) {
			if( trimBar == null ) {
				this.trimPane.setRight(null);
			} else {
				this.trimPane.setRight((Node) trimBar.getStaticLayoutNode());	
			}
			
		}

		@Override
		public void setTopTrim(WLayoutedWidget<MTrimBar> trimBar) {
			if( trimBar == null ) {
				this.trimPane.setTop(null);
			} else {
				Node g = (Node) trimBar.getStaticLayoutNode();
				this.trimPane.setTop(g);				
			}
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
	}

	class MultiMessageDialog extends Dialog {
		private Collection<MPart> parts;
		TableView<Row> tabView;

		GraphicsLoader graphicsLoader;
		private List<MPart> selectedParts;

		public MultiMessageDialog(Window parent, Collection<MPart> parts, GraphicsLoader graphicsLoader) {
			super(parent, DefWindowRenderer.this.messages.DefWindowRenderer_MultiMessageDialog_Title);
			this.parts = parts;
			this.graphicsLoader = graphicsLoader;
		}

		public List<MPart> getSelectedParts() {
			return this.selectedParts;
		}

		@Override
		protected void okPressed() {
			this.selectedParts = new ArrayList<MPart>();
			for (Row r : this.tabView.getItems()) {
				if (r.isSelected()) {
					this.selectedParts.add(r.element.get());
				}
			}
			super.okPressed();
		}

		@Override
		protected Node createDialogArea() {
			BorderPane p = new BorderPane();
			Label l = new Label(DefWindowRenderer.this.messages.DefWindowRenderer_MultiMessageDialog_Message);
			p.setTop(l);

			this.tabView = new TableView<Row>();

			{
				TableColumn<Row, Boolean> column = new TableColumn<Row, Boolean>();
				column.setCellFactory(this::createCheckboxCell);
				column.setOnEditCommit((event) -> event.getRowValue().selected.set(event.getNewValue().booleanValue()));
				column.setCellValueFactory(new PropertyValueFactory<Row, Boolean>("selected")); //$NON-NLS-1$
				this.tabView.getColumns().add(column);
			}

			{
				TableColumn<Row, MPart> column = new TableColumn<Row, MPart>();
				column.setCellFactory(this::createTextCell);
				column.setCellValueFactory(new PropertyValueFactory<Row, MPart>("element")); //$NON-NLS-1$
				this.tabView.getColumns().add(column);
			}
			this.tabView.setEditable(true);

			List<Row> list = new ArrayList<Row>();
			for (MPart m : this.parts) {
				list.add(new Row(m));
			}
			this.tabView.setItems(FXCollections.observableArrayList(list));
			p.setCenter(this.tabView);

			return p;
		}

		TableCell<Row, Boolean> createCheckboxCell(final TableColumn<Row, Boolean> param) {
			final CheckBox checkBox = new CheckBox();
			final TableCell<Row, Boolean> cell = new TableCell<Row, Boolean>() {

				@Override
				protected void updateItem(Boolean item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null) {
						checkBox.setDisable(true);
						checkBox.setSelected(false);
						checkBox.setOnAction(null);
					} else {
						checkBox.setDisable(false);
						checkBox.setSelected(item.booleanValue());
						checkBox.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								MultiMessageDialog.this.tabView.edit(0, param);
								commitEdit(Boolean.valueOf(checkBox.isSelected()));
							}
						});
					}
				}
			};

			cell.setGraphic(checkBox);
			return cell;
		}

		TableCell<Row, MPart> createTextCell(TableColumn<Row, MPart> param) {
			return new TableCell<DefWindowRenderer.Row, MPart>() {
				@SuppressWarnings("null")
				@Override
				protected void updateItem(MPart item, boolean empty) {
					super.updateItem(item, empty);
					if (item != null) {
						setText(item.getLocalizedLabel());
						String uri = item.getIconURI();
						if (uri != null) {
							setGraphic(MultiMessageDialog.this.graphicsLoader.getGraphicsNode(new EMFUri(URI.createURI(uri))));
						}
					}
				}
			};
		}
	}

	static class Row {
		BooleanProperty selected = new SimpleBooleanProperty(this, "selected", true); //$NON-NLS-1$
		ObjectProperty<MPart> element = new SimpleObjectProperty<MPart>(this, "element"); //$NON-NLS-1$

		public Row(MPart element) {
			this.element.set(element);
		}

		public boolean isSelected() {
			return this.selected.get();
		}

		public void setSelected(boolean value) {
			this.selected.set(value);
		}

		public BooleanProperty selectedProperty() {
			return this.selected;
		}

		public MPart getElement() {
			return this.element.get();
		}

		public void setElement(MPart value) {
			this.element.set(value);
		}

		public ObjectProperty<MPart> elementProperty() {
			return this.element;
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
