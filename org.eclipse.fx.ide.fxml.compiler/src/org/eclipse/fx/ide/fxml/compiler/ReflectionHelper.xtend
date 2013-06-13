package org.eclipse.fx.ide.fxml.compiler

import org.eclipse.xtext.common.types.JvmTypeReference
import javafx.beans.DefaultProperty

class ReflectionHelper {
	def static getEnumType(JvmTypeReference type, String attributeName, boolean layoutConstraint) {
		val c = Class::forName(type.qualifiedName, false, typeof(ReflectionHelper).getClassLoader())
		val methodName = "set"+attributeName.toFirstUpper
		val m = c.methods.findFirst[name == methodName && (parameterCount == 1 || (layoutConstraint && parameterCount == 2) )]
		
		return m?.parameterTypes.get(if (layoutConstraint) 1 else 0)?.name
	}
	
	def static needsBuilder(JvmTypeReference type) {
		val c = Class::forName(type.qualifiedName, false, typeof(ReflectionHelper).getClassLoader())
		return c.constructors.findFirst[parameterCount==0] == null
	}
	
	def static defaultAttribute(JvmTypeReference type) {
		var c = Class::forName(type.qualifiedName, false, typeof(ReflectionHelper).getClassLoader())
		var DefaultProperty p
		do {
			p = c.getAnnotation(typeof(DefaultProperty))
			c = c.superclass;
		} while( p == null && c != typeof(Object) )
		
		return p.value;
	}
}