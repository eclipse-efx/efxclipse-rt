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
package org.eclipse.fx.ui.keybindings.e4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.core.commands.contexts.ContextManager;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MBindingContext;
import org.eclipse.e4.ui.model.application.commands.MBindingTable;
import org.eclipse.e4.ui.model.application.commands.MBindings;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MKeyBinding;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.services.EContextService;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.fx.ui.keybindings.e4.internal.BindingTable;
import org.eclipse.fx.ui.keybindings.e4.internal.BindingTableManager;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Process contexts in the model, feeding them into the command service.
 */
@SuppressWarnings("restriction")
public class BindingProcessingAddon {

	@Inject
	private MApplication application;

	@Inject
	private IEventBroker broker;

	@Inject
	private ContextManager contextManager;

	@Inject
	private BindingTableManager bindingTables;

	@Inject
	private ECommandService commandService;

	@Inject
	private EBindingService bindingService;

	@Inject
	@Log
	private Logger logger;

	private EventHandler additionHandler;

	private EventHandler contextHandler;

	@PostConstruct
	void init() {
		defineBindingTables();
		activateContexts(this.application);
		registerModelListeners();
	}

	private void activateContexts(Object me) {
		if (me instanceof MBindings) {
			MContext contextModel = (MContext) me;
			MBindings container = (MBindings) me;
			List<MBindingContext> bindingContexts = container.getBindingContexts();
			IEclipseContext context = contextModel.getContext();
			if (context != null && !bindingContexts.isEmpty()) {
				EContextService cs = context.get(EContextService.class);
				for (MBindingContext element : bindingContexts) {
					cs.activateContext(element.getElementId());
				}
			}
		}
		if (me instanceof MElementContainer) {
			@SuppressWarnings("unchecked")
			List<MUIElement> children = ((MElementContainer<MUIElement>) me).getChildren();
			Iterator<MUIElement> i = children.iterator();
			while (i.hasNext()) {
				MUIElement e = i.next();
				activateContexts(e);
			}
		}
	}

	private void defineBindingTables() {
		for (MBindingTable bindingTable : this.application.getBindingTables()) {
			defineBindingTable(bindingTable);
		}
	}

	/**
	 * @param bindingTable
	 */
	private void defineBindingTable(MBindingTable bindingTable) {
		final Context bindingContext = this.contextManager.getContext(bindingTable.getBindingContext().getElementId());
		BindingTable table = this.bindingTables.getTable(bindingTable.getBindingContext().getElementId());
		if (table == null && bindingContext != null) {
			table = new BindingTable(bindingContext);
			this.bindingTables.addTable(table);
		}
		for (MKeyBinding binding : bindingTable.getBindings()) {
			defineBinding(table, bindingContext, binding);
		}
	}

	private void defineBinding(BindingTable bindingTable, Context bindingContext, MKeyBinding binding) {
		String keySequence = binding.getKeySequence();
		if( keySequence != null ) {
			Binding keyBinding = createBinding(bindingContext, binding.getCommand(), binding.getParameters(), keySequence, binding);
			if (keyBinding != null && !binding.getTags().contains(EBindingService.DELETED_BINDING_TAG)) {
				bindingTable.addBinding(keyBinding);
			}			
		}
	}

	private Binding createBinding(Context bindingContext, MCommand cmdModel, List<MParameter> modelParms, @NonNull String keySequence, MKeyBinding binding) {
		Binding keyBinding = null;

		if (binding.getTransientData().get(EBindingService.MODEL_TO_BINDING_KEY) != null) {
			try {
				keyBinding = (Binding) binding.getTransientData().get(EBindingService.MODEL_TO_BINDING_KEY);
				return keyBinding;
			} catch (ClassCastException cce) {
				System.err.println("Invalid type stored in transient data with the key " //$NON-NLS-1$
						+ EBindingService.MODEL_TO_BINDING_KEY);
				return null;
			}
		}

		if (cmdModel == null) {
			return null;
		}
		Map<String, Object> parameters = null;
		if (modelParms != null && !modelParms.isEmpty()) {
			parameters = new HashMap<String, Object>();
			for (MParameter mParm : modelParms) {
				parameters.put(mParm.getName(), mParm.getValue());
			}
		}
		ParameterizedCommand cmd = this.commandService.createCommand(cmdModel.getElementId(), parameters);
		TriggerSequence sequence = null;
		sequence = this.bindingService.createSequence(keySequence);

		if (cmd == null) {
			this.logger.error("Failed to find command for binding: " + binding); //$NON-NLS-1$
		} else if (sequence == null) {
			this.logger.error("Failed to map binding: " + binding); //$NON-NLS-1$
		} else {
			try {
				String schemeId = null;
				String locale = null;
				String platform = null;

				Map<String, String> attrs = new HashMap<String, String>();
				List<String> tags = binding.getTags();
				for (String tag : tags) {
					// remember to skip the ':' in each tag!
					if (tag.startsWith(EBindingService.SCHEME_ID_ATTR_TAG)) {
						schemeId = tag.substring(9);
						attrs.put(EBindingService.SCHEME_ID_ATTR_TAG, schemeId);
					} else if (tag.startsWith(EBindingService.LOCALE_ATTR_TAG)) {
						locale = tag.substring(7);
						attrs.put(EBindingService.LOCALE_ATTR_TAG, locale);
					} else if (tag.startsWith(EBindingService.PLATFORM_ATTR_TAG)) {
						platform = tag.substring(9);
						attrs.put(EBindingService.PLATFORM_ATTR_TAG, platform);
					} else if (tag.startsWith(EBindingService.TYPE_ATTR_TAG)) {
						// system bindings won't pass this attr
						attrs.put(EBindingService.TYPE_ATTR_TAG, "user"); //$NON-NLS-1$
					}
				}
				keyBinding = this.bindingService.createBinding(sequence, cmd, bindingContext.getId(), attrs);
			} catch (IllegalArgumentException e) {
				this.logger.error("failed to create: " + binding, e); //$NON-NLS-1$
				return null;
			}

		}
		return keyBinding;
	}

	private void updateBinding(MKeyBinding binding, boolean add, Object eObj) {
		Object parentObj = ((EObject) binding).eContainer();
		if (!(parentObj instanceof MBindingTable)) {
			// the link will already be broken for removes, so we'll try this
			if (eObj instanceof MBindingTable) {
				parentObj = eObj;
			}
		}

		if (parentObj == null) {
			return;
		}

		MBindingTable bt = (MBindingTable) parentObj;
		final Context bindingContext = this.contextManager.getContext(bt.getBindingContext().getElementId());
		BindingTable table = this.bindingTables.getTable(bindingContext.getId());
		if (table == null) {
			this.logger.error("Trying to create \'" + binding //$NON-NLS-1$
					+ "\' without binding table " + bindingContext.getId());//$NON-NLS-1$
			return;
		}
		String keySequence = binding.getKeySequence();
		if(  keySequence != null ) {
			Binding keyBinding = createBinding(bindingContext, binding.getCommand(), binding.getParameters(), keySequence, binding);
			if (keyBinding != null) {
				if (add) {
					table.addBinding(keyBinding);
				} else {
					table.removeBinding(keyBinding);
				}
			}			
		}
	}

	@PreDestroy
	void dispose() {
		unregsiterModelListeners();
	}

	private void additionHandler(Event event) {
		Object elementObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		if (elementObj instanceof MApplication) {
			Object newObj = event.getProperty(UIEvents.EventTags.NEW_VALUE);
			if (UIEvents.EventTypes.ADD.equals(event.getProperty(UIEvents.EventTags.TYPE)) && newObj instanceof MBindingTable) {
				MBindingTable bt = (MBindingTable) newObj;
				final Context bindingContext = this.contextManager.getContext(bt.getBindingContext().getElementId());
				if (bindingContext != null) {
					final BindingTable table = new BindingTable(bindingContext);
					this.bindingTables.addTable(table);
					List<MKeyBinding> bindings = bt.getBindings();
					for (MKeyBinding binding : bindings) {
						String keySequence = binding.getKeySequence();
						if( keySequence != null ) {
							Binding keyBinding = createBinding(bindingContext, binding.getCommand(), binding.getParameters(), keySequence, binding);
							if (keyBinding != null) {
								table.addBinding(keyBinding);
							}							
						}
					}
				}
			}
		} else if (elementObj instanceof MBindingTable) {
			Object newObj = event.getProperty(UIEvents.EventTags.NEW_VALUE);
			Object oldObj = event.getProperty(UIEvents.EventTags.OLD_VALUE);

			// adding a binding
			if (UIEvents.EventTypes.ADD.equals(event.getProperty(UIEvents.EventTags.TYPE)) && newObj instanceof MKeyBinding) {

				MKeyBinding binding = (MKeyBinding) newObj;
				updateBinding(binding, true, elementObj);
			}
			// removing a binding
			else if (UIEvents.EventTypes.REMOVE.equals(event.getProperty(UIEvents.EventTags.TYPE)) && oldObj instanceof MKeyBinding) {

				MKeyBinding binding = (MKeyBinding) oldObj;
				updateBinding(binding, false, elementObj);
			}
		} else if (elementObj instanceof MKeyBinding) {
			MKeyBinding binding = (MKeyBinding) elementObj;

			String attrName = (String) event.getProperty(UIEvents.EventTags.ATTNAME);

			if (UIEvents.EventTypes.SET.equals(event.getProperty(UIEvents.EventTags.TYPE))) {
				Object oldObj = event.getProperty(UIEvents.EventTags.OLD_VALUE);
				if (UIEvents.KeyBinding.COMMAND.equals(attrName)) {
					MKeyBinding oldBinding = (MKeyBinding) EcoreUtil.copy((EObject) binding);
					oldBinding.setCommand((MCommand) oldObj);
					updateBinding(oldBinding, false, ((EObject) binding).eContainer());
					updateBinding(binding, true, null);
				} else if (UIEvents.KeySequence.KEYSEQUENCE.equals(attrName)) {
					MKeyBinding oldBinding = (MKeyBinding) EcoreUtil.copy((EObject) binding);
					oldBinding.setKeySequence((String) oldObj);
					updateBinding(oldBinding, false, ((EObject) binding).eContainer());
					updateBinding(binding, true, null);
				}
			} else if (UIEvents.KeyBinding.PARAMETERS.equals(attrName)) {
				if (UIEvents.EventTypes.ADD.equals(event.getProperty(UIEvents.EventTags.TYPE))) {
					Object newObj = event.getProperty(UIEvents.EventTags.NEW_VALUE);
					MKeyBinding oldBinding = (MKeyBinding) EcoreUtil.copy((EObject) binding);
					oldBinding.getParameters().remove(newObj);
					updateBinding(oldBinding, false, ((EObject) binding).eContainer());
					updateBinding(binding, true, null);
				} else if (UIEvents.EventTypes.REMOVE.equals(event.getProperty(UIEvents.EventTags.TYPE))) {
					Object oldObj = event.getProperty(UIEvents.EventTags.OLD_VALUE);
					MKeyBinding oldBinding = (MKeyBinding) EcoreUtil.copy((EObject) binding);
					oldBinding.getParameters().add((MParameter) oldObj);
					updateBinding(oldBinding, false, ((EObject) binding).eContainer());
					updateBinding(binding, true, null);
				}
			}
			// if we've updated the tags for an MKeyBinding
			else if (UIEvents.ApplicationElement.TAGS.equals(attrName)) {
				List<String> tags = binding.getTags();
				// if we added a deleted tag to the MKeyBinding, then
				// remove it from the runtime binding tables
				if (tags.contains(EBindingService.DELETED_BINDING_TAG)) {
					updateBinding(binding, false, elementObj);
				}
				// else we're adding the binding to the runtime tables
				else {
					updateBinding(binding, true, elementObj);
				}
			}
		}
	}

	private void contextHandler(Event event) {
		Object elementObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		Object newObj = event.getProperty(UIEvents.EventTags.NEW_VALUE);
		if (UIEvents.EventTypes.SET.equals(event.getProperty(UIEvents.EventTags.TYPE)) && newObj instanceof IEclipseContext) {
			activateContexts(elementObj);
		}
	}

	private void registerModelListeners() {
		this.additionHandler = this::additionHandler;

		this.broker.subscribe(UIEvents.BindingTableContainer.TOPIC_BINDINGTABLES, this.additionHandler);
		this.broker.subscribe(UIEvents.BindingTable.TOPIC_BINDINGS, this.additionHandler);
		this.broker.subscribe(UIEvents.KeyBinding.TOPIC_COMMAND, this.additionHandler);
		this.broker.subscribe(UIEvents.KeyBinding.TOPIC_PARAMETERS, this.additionHandler);
		this.broker.subscribe(UIEvents.KeySequence.TOPIC_KEYSEQUENCE, this.additionHandler);
		this.broker.subscribe(UIEvents.ApplicationElement.TOPIC_TAGS, this.additionHandler);

		this.contextHandler = this::contextHandler;
		this.broker.subscribe(UIEvents.Context.TOPIC_CONTEXT, this.contextHandler);
	}

	private void unregsiterModelListeners() {
		this.broker.unsubscribe(this.additionHandler);
		this.broker.unsubscribe(this.additionHandler);
		this.broker.unsubscribe(this.additionHandler);
		this.broker.unsubscribe(this.additionHandler);
		this.broker.unsubscribe(this.additionHandler);
		this.broker.unsubscribe(this.contextHandler);
	}
}
