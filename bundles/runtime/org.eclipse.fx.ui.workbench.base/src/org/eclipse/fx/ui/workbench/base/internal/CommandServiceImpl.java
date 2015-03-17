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

import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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

	/**
	 * Create a new instance
	 *
	 * @param commandService
	 *            command service
	 * @param handlerService
	 *            handler service
	 */
	@Inject
	public CommandServiceImpl(@NonNull ECommandService commandService, @NonNull EHandlerService handlerService) {
		this.commandService = commandService;
		this.handlerService = handlerService;
	}

	@Override
	public boolean exists(@NonNull String commandId) {
		return this.commandService.getCommand(commandId) != null;
	}

	@Override
	public boolean canExecute(@NonNull String commandId, @NonNull Map<@NonNull String, @Nullable Object> parameters) {
		ParameterizedCommand cmd = this.commandService.createCommand(commandId, parameters);
		return this.handlerService.canExecute(cmd);
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public <O> Optional<@NonNull O> execute(@NonNull String commandId, @NonNull Map<@NonNull String, @Nullable Object> parameters) {
		ParameterizedCommand cmd = this.commandService.createCommand(commandId, parameters);
		return Optional.ofNullable((O)this.handlerService.executeHandler(cmd));
	}

}
