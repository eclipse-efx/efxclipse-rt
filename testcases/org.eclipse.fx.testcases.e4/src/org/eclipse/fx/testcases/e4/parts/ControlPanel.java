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
package org.eclipse.fx.testcases.e4.parts;

import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicFactoryImpl;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.osgi.service.event.Event;

@SuppressWarnings("restriction")
public class ControlPanel {
	
	@Inject
	IPresentationEngine engine;
	private TextField focusField;
	
	@Inject
	ESelectionService selectionService;
	
	@Inject
	ECommandService commandService;
	
	@Inject
	EHandlerService handlerService;
	
	@Inject
	UISynchronize sync;
	
	@Inject
	org.eclipse.e4.ui.di.UISynchronize e4Sync;
	
	@Inject
	ThreadSynchronize coreSync;
	
	@SuppressWarnings("rawtypes")
	@Inject
	public ControlPanel(BorderPane p, final MApplication application, final MWindow window, @Optional final MPerspective perspective, final EPartService partService, final EModelService modelService, EMenuService menuService, final IEventBroker broker, final MPart self) {
		broker.subscribe(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE, new org.osgi.service.event.EventHandler() {
			
			@Override
			public void handleEvent(Event arg0) {
				System.err.println("=========> START UP COMPLETED");
			}
		});
		VBox box = new VBox();
		
		{
			TitledPane pane = new TitledPane();
			pane.setText("Part");
			
			VBox vbox = new VBox();
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MPart> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MPart>() {
					@Override
					protected void updateItem(MPart item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getLocalizedLabel());
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MPart>, ListCell<MPart>>() {
					
					@Override
					public ListCell<MPart> call(ListView<MPart> param) {
						return new ListCell<MPart>() {
							@Override
							protected void updateItem(MPart item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getLocalizedLabel());
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(perspective == null ? application : perspective, null, MPart.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Toggle Rendering");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MPart part = dd.getSelectionModel().getSelectedItem();
						part.setToBeRendered(!part.isToBeRendered());
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MPart> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MPart>() {
					@Override
					protected void updateItem(MPart item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getLocalizedLabel());
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MPart>, ListCell<MPart>>() {
					
					@Override
					public ListCell<MPart> call(ListView<MPart> param) {
						return new ListCell<MPart>() {
							@Override
							protected void updateItem(MPart item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getLocalizedLabel());
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(perspective == null ? application : perspective, null, MPart.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Toggle Visibile");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MPart part = dd.getSelectionModel().getSelectedItem();
						part.setVisible(!part.isVisible());
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MElementContainer> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MElementContainer>() {
					@Override
					protected void updateItem(MElementContainer item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getClass().getSimpleName());	
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MElementContainer>, ListCell<MElementContainer>>() {
					
					@Override
					public ListCell<MElementContainer> call(ListView<MElementContainer> param) {
						return new ListCell<MElementContainer>() {
							@Override
							protected void updateItem(MElementContainer item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getClass().getSimpleName());	
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(perspective == null ? application : perspective, null, MElementContainer.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Add new Part");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@SuppressWarnings("unchecked")
					@Override
					public void handle(ActionEvent event) {
						MElementContainer container = dd.getSelectionModel().getSelectedItem();
						
						MPart p = BasicFactoryImpl.eINSTANCE.createPart();
						p.setLabel("New Part");
						p.setContributionURI("bundleclass://org.eclipse.fx.testcases.e4/org.eclipse.fx.testcases.e4.parts.ContentPanel");
						container.getChildren().add(p);
						partService.showPart(p, PartState.ACTIVATE);
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MElementContainer> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MElementContainer>() {
					@Override
					protected void updateItem(MElementContainer item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getClass().getSimpleName());	
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MElementContainer>, ListCell<MElementContainer>>() {
					
					@Override
					public ListCell<MElementContainer> call(ListView<MElementContainer> param) {
						return new ListCell<MElementContainer>() {
							@Override
							protected void updateItem(MElementContainer item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getClass().getSimpleName());	
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(perspective == null ? application : perspective, null, MElementContainer.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Remove last Part");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MElementContainer container = dd.getSelectionModel().getSelectedItem();
						container.getChildren().remove(container.getChildren().size()-1);
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MElementContainer> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MElementContainer>() {
					@Override
					protected void updateItem(MElementContainer item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getClass().getSimpleName());	
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MElementContainer>, ListCell<MElementContainer>>() {
					
					@Override
					public ListCell<MElementContainer> call(ListView<MElementContainer> param) {
						return new ListCell<MElementContainer>() {
							@Override
							protected void updateItem(MElementContainer item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getClass().getSimpleName());	
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(perspective == null ? application : perspective, null, MElementContainer.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Move last Part");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MElementContainer container = dd.getSelectionModel().getSelectedItem();
						Object o = container.getChildren().remove(container.getChildren().size()-1);
						container.getChildren().add(container.getChildren().size()-1, o);
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MPart> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MPart>() {
					@Override
					protected void updateItem(MPart item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getLocalizedLabel());
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MPart>, ListCell<MPart>>() {
					
					@Override
					public ListCell<MPart> call(ListView<MPart> param) {
						return new ListCell<MPart>() {
							@Override
							protected void updateItem(MPart item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getLocalizedLabel());
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(perspective == null ? application : perspective, null, MPart.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Detach");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MPart part = dd.getSelectionModel().getSelectedItem();
						modelService.detach(part, 0, 0, 300, 300);
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				
				final ComboBox<MPerspective> dd = new ComboBox<>();
				dd.setButtonCell(new ListCell<MPerspective>() {
					@Override
					protected void updateItem(MPerspective item, boolean empty) {
						super.updateItem(item, empty);
						if( item != null ) {
							setText(item.getLocalizedLabel());
						}
					}
				});
				dd.setCellFactory(new Callback<ListView<MPerspective>, ListCell<MPerspective>>() {
					
					@Override
					public ListCell<MPerspective> call(ListView<MPerspective> param) {
						return new ListCell<MPerspective>() {
							@Override
							protected void updateItem(MPerspective item, boolean empty) {
								super.updateItem(item, empty);
								if( item != null ) {
									setText(item.getLocalizedLabel());
								}
							}
						};
					}
				});
				dd.setItems(FXCollections.observableArrayList(modelService.findElements(application, null, MPerspective.class, null)));
				hbox.getChildren().add(dd);
				
				Button b = new Button("Unrender");
				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						MPerspective part = dd.getSelectionModel().getSelectedItem();
						engine.removeGui(part);
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			pane.setContent(vbox);
			box.getChildren().add(pane);
		}
		
		{
			TitledPane pane = new TitledPane();
			pane.setText("Window Properties");
			
			VBox vbox = new VBox(10);
			
			{
				HBox hbox = new HBox(10);
				hbox.getChildren().add(new Label("X"));
				focusField = new TextField(window.getX()+"");
				focusField.setId("text_windowX");
				hbox.getChildren().add(focusField);
				
				Button b = new Button("Set");
				b.setId("button_windowX");
				b.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						window.setX(Integer.parseInt(focusField.getText()));
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				hbox.getChildren().add(new Label("Y"));
				final TextField f = new TextField(window.getY()+"");
				hbox.getChildren().add(f);
				
				Button b = new Button("Set");
				b.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						window.setY(Integer.parseInt(f.getText()));
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				hbox.getChildren().add(new Label("W"));
				final TextField f = new TextField(window.getWidth()+"");
				hbox.getChildren().add(f);
				
				Button b = new Button("Set");
				b.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						window.setWidth(Integer.parseInt(f.getText()));
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				hbox.getChildren().add(new Label("H"));
				final TextField f = new TextField(window.getHeight()+"");
				hbox.getChildren().add(f);
				
				Button b = new Button("Set");
				b.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						window.setHeight(Integer.parseInt(f.getText()));
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			{
				HBox hbox = new HBox(10);
				hbox.getChildren().add(new Label("Title"));
				final TextField f = new TextField(window.getLabel()+"");
				hbox.getChildren().add(f);
				
				Button b = new Button("Set");
				b.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						window.setLabel(f.getText());
					}
				});
				hbox.getChildren().add(b);
				vbox.getChildren().add(hbox);
			}
			
			pane.setContent(vbox);
			box.getChildren().add(pane);			
		}
		
		{
			Label label = new Label("Context menu");
			menuService.registerContextMenu(label, "org.eclipse.fx.testcases.e4.popupmenu.0");
			box.getChildren().add(label);
		}
		
		{
			Button button = new Button("Publish selection");
			button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					selectionService.setSelection(UUID.randomUUID().toString());
				}
			});
			box.getChildren().add(button);
		}
		
		{
			Button button = new Button("Add ToolBar element");
			button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					MToolBar toolbar = (MToolBar) modelService.find("org.efxclipse.e4.maintoolbar", application);
					MHandledToolItem element = modelService.createModelElement(MHandledToolItem.class);
					element.setElementId("my.new.item.id");
					element.setLabel("New item");
					
					element.setCommand(application.getCommands().get(0));

					toolbar.getChildren().add(element);
				}
			});
			box.getChildren().add(button);
		}
		
		{
			Button button = new Button("Hide/Show Menu Item");
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					for( MMenuElement e : ((MMenu)window.getMainMenu().getChildren().get(0)).getChildren() ) {
						if( "org.eclipse.fx.testcases.e4.directmenuitem.hideshow".equals(e.getElementId()) ) {
							e.setVisible(! e.isVisible());
							System.err.println("TOGGLED");
						}
					}
				}
			});
			box.getChildren().add(button);
		}
		
		{
			Button button = new Button("Send EventTopic");
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.gc();
					broker.send("MyTopic", "Hello World");
				}
			});
			box.getChildren().add(button);
		}
		
		{
			Button button = new Button("Modify container data");
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					self.setContainerData("5");
				}
			});
			box.getChildren().add(button);
		}
		
		{
			Button button = new Button("Bring 2nd window to top");
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					modelService.bringToTop(application.getChildren().get(1));
				}
			});
			box.getChildren().add(button);
		}
		
		{
			Button button = new Button("Flip trimbar");
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MTrimBar mTrimBar = ((MTrimmedWindow)window).getTrimBars().get(0);
					mTrimBar.setToBeRendered(! mTrimBar.isToBeRendered());
//					mTrimBar.setVisible( ! mTrimBar.isVisible() );
				}
			});
			box.getChildren().add(button);
		}


		p.setTop(box);
	}
	
	@Focus
	void setFocus() {
		focusField.requestFocus();
	}
	
	@Inject
	public void setAppFocusControl(@Named(Constants.APP_FOCUS_NODE) @Optional Node node) {
		System.err.println("AppFocus@" + node);
	}
	
	@Inject
	public void setWindowFocusControl(@Named(Constants.WINDOW_FOCUS_NODE) @Optional Node node) {
		System.err.println("WindowFocus@" + node);
	}
	
	@PostConstruct
	void initDone() {
		System.err.println("SYNC: " + sync + " => " + e4Sync + " => " + coreSync);
	}
}
