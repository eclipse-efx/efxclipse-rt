package org.eclipse.fx.code.compensator.project.internal.commands;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.compensator.editor.VCSInput;

public class CommitActiveInput {
	public static final String COMMAND_ID = "org.eclipse.fx.code.compensator.project.commit.activeInput";
	@Execute
	public void commit(@Named("activeInput") VCSInput<?> input) {
		input.commit();
	}
}
