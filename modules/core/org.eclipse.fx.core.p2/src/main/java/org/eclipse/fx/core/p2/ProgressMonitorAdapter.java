/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.p2;

import java.util.UUID;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.fx.core.ProgressReporter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class ProgressMonitorAdapter implements IProgressMonitor {
	private final ProgressReporter reporter;
	
	@SuppressWarnings("null")
	@NonNull
	private final String taskId = UUID.randomUUID().toString();
	private boolean canceled;
	@Nullable
	private String subTask;
	
	public ProgressMonitorAdapter(ProgressReporter reporter) {
		this.reporter = reporter;
	}
	
	@Override
	public void beginTask(String name, int totalWork) {
		this.reporter.taskStart(this.taskId, null, name, totalWork, true);
	}

	@Override
	public void done() {
		this.reporter.taskEnd(this.taskId, isCanceled());
	}

	@Override
	public void internalWorked(double work) {
//		this.reporter.progress(this.taskId, null, work);
	}

	@Override
	public boolean isCanceled() {
		return this.canceled;
	}

	@Override
	public void setCanceled(boolean value) {
		this.canceled = value;
	}

	@Override
	public void setTaskName(String name) {
		if( this.subTask != null ) {
			String task = this.subTask;
			this.reporter.taskEnd(task, isCanceled());	
		}
	}

	@Override
	public void subTask(String name) {
		if( this.subTask != null ) {
			String task = this.subTask;
			this.reporter.taskEnd(task, isCanceled());
		}
		this.subTask = UUID.randomUUID().toString();
		if( this.subTask != null ) {
			String task = this.subTask;
			this.reporter.taskStart(task, this.taskId, name == null ? "<unknown>" : name, 1, true);	 //$NON-NLS-1$
		}
	}

	@Override
	public void worked(int work) {
		this.reporter.progress(this.taskId, null, work);
	}
}
