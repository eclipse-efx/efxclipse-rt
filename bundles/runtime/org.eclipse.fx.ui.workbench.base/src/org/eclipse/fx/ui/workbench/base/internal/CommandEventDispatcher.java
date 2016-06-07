package org.eclipse.fx.ui.workbench.base.internal;

import javax.inject.Inject;

import org.eclipse.core.commands.CommandManager;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.event.EventBus;

public class CommandEventDispatcher implements IExecutionListener {
	private EventBus eventBus;

	@Inject
	public CommandEventDispatcher(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	@Inject
	void setManager(@Optional CommandManager manager) {
		// Command manager is not there at the beginning hence with make it optional
		if( manager != null ) {
			manager.addExecutionListener(this);
		}
	}

	@Override
	public void notHandled(String commandId, NotHandledException exception) {

	}

	@Override
	public void postExecuteFailure(String commandId, ExecutionException exception) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postExecuteSuccess(String commandId, Object returnValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preExecute(String commandId, ExecutionEvent event) {
		// TODO Auto-generated method stub

	}
}
