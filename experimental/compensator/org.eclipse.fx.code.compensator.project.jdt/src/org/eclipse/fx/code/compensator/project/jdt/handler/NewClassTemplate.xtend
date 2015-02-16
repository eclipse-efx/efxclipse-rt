package org.eclipse.fx.code.compensator.project.jdt.handler

class NewClassTemplate {
	def static generate(String packagename, String className) '''
	package «packagename»;
	
	public class «className» {
		
	}
	'''
}