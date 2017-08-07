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
package org.eclipse.fx.core;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Report progress for long running tasks
 *
 * @since 1.2
 */
public interface ProgressReporter {
	/**
	 * Reports about the start of a task
	 * <p>
	 * <b>Warning</b>: This code might be called by multiple threads
	 * concurrently
	 * </p>
	 *
	 * @param taskId
	 *            unique id for the task
	 * @param parentTaskId
	 *            id of the parent task
	 *
	 * @param taskName
	 *            the name of the task
	 * @param totalUnits
	 *            the total units of work for this task
	 * @param cancelable
	 *            <code>true</code> if the task can be canceled
	 *
	 */
	public void taskStart(@NonNull String taskId, @Nullable String parentTaskId, @NonNull String taskName, int totalUnits, boolean cancelable);

	/**
	 * Inform that the total task units has changed
	 *
	 * @param taskId
	 *            the task id
	 * @param totalUnits
	 *            the new total units
	 */
	public void taskUnitsChanged(@NonNull String taskId, int totalUnits);

	/**
	 * Report about the end of a task
	 * <p>
	 * <b>Warning</b>: This code might be called by multiple threads
	 * concurrently
	 * </p>
	 *
	 * @param taskId
	 *            the task id
	 * @param canceled
	 *            if the task has been canceled
	 */
	public void taskEnd(@NonNull String taskId, boolean canceled);

	/**
	 * Inform about progress update and provide a chance for the user to cancel
	 * the task.
	 * <p>
	 * <b>Warning</b>: This code might be called by multiple threads
	 * concurrently
	 * </p>
	 *
	 * @param taskId
	 *            the id
	 * @param message
	 *            the message
	 * @param unitsDone
	 *            the units done
	 */
	public void progress(@NonNull String taskId, @Nullable String message, int unitsDone);
	
	/**
	 * A simple default progress reporter
	 * 
	 * @since 2.0
	 */
	public static ProgressReporter NULLPROGRESS_REPORTER = new ProgressReporter() {
		
		@Override
		public void taskUnitsChanged(@NonNull String taskId, int totalUnits) {
			// nothing
		}
		
		@Override
		public void taskStart(@NonNull String taskId, @Nullable String parentTaskId, @NonNull String taskName, int totalUnits, boolean cancelable) {
			// nothing
		}
		
		@Override
		public void taskEnd(@NonNull String taskId, boolean canceled) {
			// nothing
		}
		
		@Override
		public void progress(@NonNull String taskId, @Nullable String message, int unitsDone) {
			// nothing
		}
	};
}
