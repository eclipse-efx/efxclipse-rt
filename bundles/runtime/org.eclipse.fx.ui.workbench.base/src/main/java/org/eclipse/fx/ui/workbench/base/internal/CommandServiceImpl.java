/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.fx.core.adapter.AdapterService;
import org.eclipse.fx.core.command.Command;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * A command service implementation
 *
 * @since 1.2
 */
@SuppressWarnings("restriction")
public class CommandServiceImpl implements CommandService {
	@NonNull
	private final ECommandService commandService;
	@NonNull
	private final EHandlerService handlerService;
	@NonNull
	private final IEclipseContext context;
	@NonNull
	private final ObjectSerializer serializer;
	@NonNull
	private final AdapterService adapterService;
	private boolean disposed;

	/**
	 * Create a new instance
	 *
	 * @param commandService
	 *            command service
	 * @param handlerService
	 *            handler service
	 * @param context
	 *            the context
	 */
	@Inject
	public CommandServiceImpl(@NonNull ECommandService commandService, @NonNull EHandlerService handlerService, @NonNull IEclipseContext context,@NonNull ObjectSerializer serializer, @NonNull AdapterService adapterService) {
		this.commandService = commandService;
		this.handlerService = handlerService;
		this.context = context;
		this.serializer = serializer;
		this.adapterService = adapterService;
	}
	
	@PreDestroy
	void dispose() {
		this.disposed = true;
	}

	@Override
	public boolean exists(@NonNull String commandId) {
		if( this.disposed ) {
			throw new IllegalStateException("Service is disposed");
		}
		return this.commandService.getCommand(commandId) != null;
	}

	@Override
	public boolean canExecute(@NonNull String commandId, @NonNull Map<@NonNull String, @Nullable Object> parameters) {
		if( this.disposed ) {
			throw new IllegalStateException("Service is disposed");
		}
		ParameterizedCommand cmd = this.commandService.createCommand(commandId, mapToString(this.adapterService,this.serializer,parameters));
		return this.handlerService.canExecute(cmd);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <O> Optional<O> execute(@NonNull String commandId, @NonNull Map<@NonNull String, @Nullable Object> parameters) {
		if( this.disposed ) {
			throw new IllegalStateException("Service is disposed");
		}
		ParameterizedCommand cmd = this.commandService.createCommand(commandId, mapToString(this.adapterService,this.serializer,parameters));
		return Optional.ofNullable((O) this.handlerService.executeHandler(cmd));
	}

	@SuppressWarnings("null")
	private static Map<@NonNull String, @Nullable Object> mapToString(@NonNull AdapterService adapterService, @NonNull ObjectSerializer serializer, Map<@NonNull String, @Nullable Object> map) {
		Map<@NonNull String, @Nullable Object> rv = new HashMap<>(map);
		Map<@NonNull String, Object> collect = rv.entrySet()
				.stream()
				.filter( e -> e.getValue() != null)
				.filter( e -> !(e.getValue() instanceof String))
				.filter( e -> adapterService.canAdapt(e.getValue(), String.class))
				.collect(Collectors.toMap( e -> e.getKey(), e -> (Object)adapterService.adapt(e.getValue(), String.class)));
		rv.putAll(collect);

		rv.putAll(rv.entrySet().stream()
			.filter( e -> e.getValue() != null)
			.filter( e -> !(e.getValue() instanceof String))
			.collect(Collectors.toMap( e -> e.getKey(), e -> {
				if( e.getValue() instanceof List<?> || e.getValue() instanceof Set<?> ) {
					Collection<Object> c = (Collection<Object>) e.getValue();
					if( c == null ) {
						return null;
					}
					if( c.isEmpty() ) {
						return serializer.serializeCollection(c, Object.class);
					} else {
						Class<Object> t = (Class<Object>) c.iterator().next().getClass();
						return serializer.serializeCollection(c, t);
					}
				} else {
					return serializer.serialize(e.getValue());
				}
			})));

		return rv;
	}

	@Override
	public <O> Optional<Command<O>> createCommand(@NonNull String commandId) {
		if( this.disposed ) {
			throw new IllegalStateException("Service is disposed");
		}
		org.eclipse.core.commands.Command command = this.commandService.getCommand(commandId);
		if (command == null || !command.isDefined()) {
			return Optional.empty();
		}
		CommandImpl<O> c = new CommandImpl<O>(commandId, this.context);
		ContextInjectionFactory.inject(c, this.context);
		return Optional.of(c);
	}

	static class CommandImpl<O> implements Command<O> {
		private final String commandId;
		private CommandService commandService;
		private final IEclipseContext context;

		private ReadOnlyBooleanWrapper enabledProperty = new ReadOnlyBooleanWrapper(this, "enabled"); //$NON-NLS-1$
		private final ObservableMap<String, String> parameters = FXCollections.observableMap(new HashMap<>());

		public CommandImpl(String commandId, IEclipseContext context) {
			this.commandId = commandId;
			this.context = context;
			this.parameters.addListener((Observable o) -> {
				recalculateState();
			});
		}

		@PostConstruct
		void init(IEventBroker eventBroker) {
			eventBroker.subscribe(ScopedObjectFactory.KEYMODIFED_TOPIC, e -> recalculateState());
			eventBroker.subscribe(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, e -> {
				recalculateState();
			});
			eventBroker.subscribe(UIEvents.Dirtyable.TOPIC_DIRTY, e -> recalculateState());
			this.context.runAndTrack(new RunAndTrack() {

				@Override
				public boolean changed(IEclipseContext context) {
					context.get(IServiceConstants.ACTIVE_CONTEXTS);
					context.get(IServiceConstants.ACTIVE_SELECTION);
					context.get(IServiceConstants.ACTIVE_PART);
					recalculateState();
					return true;
				}
			});
		}

		@Override
		public void evaluate() {
			recalculateState();
		}

		@Inject
		public void setCommandService(CommandService commandService) {
			this.commandService = commandService;
			recalculateState();
		}

		@SuppressWarnings({ "unchecked", "null" })
		void recalculateState() {
			this.enabledProperty.set(this.commandService.canExecute(this.commandId, (Map<String, Object>) (Map<?, ?>) this.parameters));
		}

		@Override
		public ReadOnlyBooleanProperty enabledProperty() {
			return this.enabledProperty.getReadOnlyProperty();
		}

		@Override
		public boolean isEnabled() {
			return this.enabledProperty.get();
		}

		@SuppressWarnings({ "null", "unchecked" })
		@Override
		public Optional<O> execute() {
			return this.commandService.execute(this.commandId, (Map<String, Object>) (Map<?, ?>) this.parameters);
		}

		@Override
		public ObservableMap<String, String> parameters() {
			return this.parameters;
		}

	}
}
