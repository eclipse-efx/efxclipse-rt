package org.eclipse.fx.ide.fxml.compiler

import org.eclipse.xtext.common.types.JvmTypeReference

class ReflectionHelper {
	def static getEnumType(JvmTypeReference type, String attributeName, boolean layoutConstraint) {
		val c = Class::forName(type.qualifiedName);
		val methodName = "set"+attributeName.toFirstUpper;
		val m = c.methods.findFirst[name == methodName && (parameterCount == 1 || (layoutConstraint && parameterCount == 2) )]
		
		return m?.parameterTypes.get(if (layoutConstraint) 1 else 0)?.name;
	}
}