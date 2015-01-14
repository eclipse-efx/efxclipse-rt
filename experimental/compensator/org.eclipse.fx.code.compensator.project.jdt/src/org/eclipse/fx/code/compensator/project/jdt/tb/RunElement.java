package org.eclipse.fx.code.compensator.project.jdt.tb;

import org.eclipse.fx.code.compensator.project.ProjectService.ToolbarElement;
import org.eclipse.fx.core.di.Invoke;

public class RunElement extends ToolbarElement {

	public RunElement() {
		super("run-button", "Run Executable");
	}

	@Invoke
	public void runExecutable() {

	}
}
