 
package org.eclipse.fx.demo.e4.actions;

import org.eclipse.e4.core.di.annotations.Execute;

@SuppressWarnings("restriction")
public class SaveAction {
	@Execute
	public void execute() {
		System.err.println("Save everything");
	}
		
}