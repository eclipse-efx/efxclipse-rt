/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.command;

import java.util.Map;
import java.util.Optional;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service to interact with commands
 *
 * @since 1.2
 * @noimplement
 */
public interface CommandService {
	/**
	 * Check if a command exits
	 *
	 * @param commandId
	 *            the command id
	 * @return <code>true</code> if the command exits
	 */
	public boolean exists(@NonNull String commandId);

	/**
	 * Check if the command is executeable
	 *
	 * @param commandId
	 *            the command id
	 * @param parameters
	 *            the parameters
	 * @return <code>true</code> if command can be executed
	 */
	public boolean canExecute(@NonNull String commandId, @NonNull Map<@NonNull String, @Nullable Object> parameters);

	/**
	 * Execute the command
	 *
	 * @param commandId
	 *            the command id
	 * @param parameters
	 *            the parameters
	 * @return the return value of the command
	 */
	public <O> Optional<O> execute(@NonNull String commandId, @NonNull Map<@NonNull String, @Nullable Object> parameters);
}
