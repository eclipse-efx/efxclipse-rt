package org.eclipse.fx.ide.fxml.compiler

import org.eclipse.fx.ide.fxgraph.fXGraph.Model
import org.eclipse.fx.ide.fxgraph.fXGraph.Element
import org.eclipse.fx.ide.fxgraph.fXGraph.SimpleValuePropertyimport org.eclipse.fx.ide.fxgraph.fXGraph.ListValueProperty
import org.eclipse.fx.ide.fxgraph.fXGraph.StaticValueProperty

class FXGraphJavaGenerator {
	def generate(Model model) '''
	package «model.package.name»;
	
	//import org.eclipse.fx.core.fxml.FXMLLoading;
	import java.util.ResourceBundle;
	
	«FOR i : model.imports»
	import «i.importedNamespace»;
	«ENDFOR»
	
	public class «model.componentDef.name» /*implements FXMLLoading<«model.componentDef.rootNode.type.simpleName»>*/ {
		public «model.componentDef.rootNode.type.simpleName» load(ResourceBundle bundle) {
			«generateElementDef("root", 0, model.componentDef.rootNode)»
			return root;
		}
	}
	'''
	
	def CharSequence generateElementDef(String name, int varCount, Element element) '''
	«var c = varCount»
	«element.type.simpleName» «name» = new «element.type.simpleName»();
	«FOR p : element.properties»
		«IF p.value instanceof SimpleValueProperty»
			«name».set«p.name.toFirstUpper»(«(p.value as SimpleValueProperty).simpleAttributeValue»);
		«ELSEIF p.value instanceof Element»
			{
				«val i = c = c +1»
				«val varName = 'e_'+i»
				«generateElementDef(varName,i,p.value as Element)»
				«name».set«p.name.toFirstUpper»(«varName»);
				«staticProperties(varName,p.value as Element)»
			}
		«ELSEIF p.value instanceof ListValueProperty»
			«FOR l : (p.value as ListValueProperty).value»
				{
				«val i = c = c +1»
				«val varName = 'e_'+i»
					«IF l instanceof Element»
					«generateElementDef(varName,i,l as Element)»
					«name».get«p.name.toFirstUpper»().add(«varName»);
					«staticProperties(varName,l as Element)»
					«ENDIF»
				}
			«ENDFOR»
		«ENDIF»
	«ENDFOR»
	'''
	
	def staticProperties(String varname, Element element) '''
	«FOR prop : element.staticProperties»
		«IF prop.value instanceof SimpleValueProperty»
			«val type = prop.type»
			«IF (prop.value as SimpleValueProperty).stringValue != null»
				«val enumType = ReflectionHelper.getEnumType(type, prop.name, true)»
				«IF enumType != null»
					«type.simpleName».set«prop.name.toFirstUpper»(«varname»,«enumType».«(prop.value as SimpleValueProperty).stringValue»);
				«ELSE»
					«type.simpleName».set«prop.name.toFirstUpper»(«varname»,«(prop.value as SimpleValueProperty).simpleAttributeValue»);
				«ENDIF»
			«ELSE»
				«type.simpleName».set«prop.name.toFirstUpper»(«varname»,«(prop.value as SimpleValueProperty).simpleAttributeValue»);
			«ENDIF»
		«ENDIF»
	«ENDFOR»
	'''
	
	def simpleAttributeValue(SimpleValueProperty value) {
		if( value.stringValue != null ) {
			return '"' + value.stringValue + '"';
		} else if( value.booleanValue != null ) {
			return value.booleanValue;
		} else if( value.number != null ) {
			if( value.negative ) {
				return "-" + value.number;
			} else {
				return value.number;
			}
		}
	}
	
	def type(StaticValueProperty prop) {
		var el = prop.eContainer
		while( el.eContainer != null ) {
			if( el.eContainer instanceof Element ) {
				val e = el.eContainer as Element
				return e.type;
			}
			el = el.eContainer;
		}
	}
}