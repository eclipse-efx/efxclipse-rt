 
package org.eclipse.fx.demo.e4.actions;

import org.eclipse.e4.core.di.annotations.Execute;

@SuppressWarnings("restriction")
public class NewPersonAction {
	
	@Execute
	public void execute() {
		System.err.println("Create new person");
	}
		
}