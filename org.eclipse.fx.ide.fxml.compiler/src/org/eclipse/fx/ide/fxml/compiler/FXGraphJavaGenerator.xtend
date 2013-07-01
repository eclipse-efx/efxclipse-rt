package org.eclipse.fx.ide.fxml.compiler

import org.eclipse.fx.ide.fxgraph.fXGraph.Model
import org.eclipse.fx.ide.fxgraph.fXGraph.Element
import org.eclipse.fx.ide.fxgraph.fXGraph.SimpleValuePropertyimport org.eclipse.fx.ide.fxgraph.fXGraph.ListValueProperty
import org.eclipse.fx.ide.fxgraph.fXGraph.StaticValueProperty

import static extension org.eclipse.fx.ide.fxml.compiler.ReflectionHelper.*
import java.util.Set
import java.util.HashSet

class FXGraphJavaGenerator {
	int varIndex = 0;
	Set<String> extraImports = new HashSet;
	
	def getVarIndex() {
		varIndex = varIndex + 1;
		return varIndex;
	}
	
	def generate(Model model) '''
	package «model.package.name»;
	
	import org.eclipse.fx.core.fxml.FXMLDocument;
	import java.util.ResourceBundle;
	
	«var content = generateElementDef("root", model.componentDef.rootNode)»
	
	«FOR i : model.imports»
	import «i.importedNamespace»;
	«ENDFOR»
	
	«FOR i : extraImports»
	import «i»;
	«ENDFOR»
	
	public class «model.componentDef.name» extends FXMLDocument<«model.componentDef.rootNode.type.simpleName»> {
		public «model.componentDef.rootNode.type.simpleName» load(ResourceBundle bundle) {
			«content»
			return root;
		}
	}
	'''
	
	def CharSequence generateElementDef(String name, Element element) '''
	«IF element.type.needsBuilder»
		«element.type.simpleName» «name»;
		«element.type.simpleName»Builder «name»Builder = «element.type.simpleName»Builder.create();
		«val dummy = extraImports.add(element.type.qualifiedName+"Builder")»
		«FOR p : element.properties»
			«IF p.value instanceof SimpleValueProperty»
				«name»Builder.«p.name»(«(p.value as SimpleValueProperty).simpleAttributeValue»);
			«ENDIF»
		«ENDFOR»
		«name» = «name»Builder.build();
	«ELSE»
		«element.type.simpleName» «name» = new «element.type.simpleName»();
		«FOR p : element.properties»
			«IF p.value instanceof SimpleValueProperty»
				«name».set«p.name.toFirstUpper»(«(p.value as SimpleValueProperty).simpleAttributeValue»);
			«ELSEIF p.value instanceof Element»
				{
					«val varName = 'e_'+getVarIndex»
					«generateElementDef(varName,p.value as Element)»
					«name».set«p.name.toFirstUpper»(«varName»);
					«staticProperties(varName,p.value as Element)»
				}
			«ELSEIF p.value instanceof ListValueProperty»
				«FOR l : (p.value as ListValueProperty).value»
					{
					«val i = getVarIndex»
					«val varName = 'e_'+i»
						«IF l instanceof Element»
						«generateElementDef(varName,l as Element)»
						«name».get«p.name.toFirstUpper»().add(«varName»);
						«staticProperties(varName,l as Element)»
						«ENDIF»
					}
				«ENDFOR»
			«ENDIF»
		«ENDFOR»
		«FOR p : element.defaultChildren»
			{
				«val i = getVarIndex»
				«val varName = 'e_'+i»
				«generateElementDef(varName,p)»
				«name».get«element.type.defaultAttribute.toFirstUpper»().add(«varName»);
			}
		«ENDFOR»
	«ENDIF»
	'''
	
	def staticProperties(String name, Element element) '''
	«FOR prop : element.staticProperties»
		«val type = prop.type»
		«IF prop.value instanceof SimpleValueProperty»
			«IF (prop.value as SimpleValueProperty).stringValue != null»
				«val enumType = ReflectionHelper.getEnumType(type, prop.name, true)»
				«IF enumType != null»
					«type.simpleName».set«prop.name.toFirstUpper»(«name»,«enumType».«(prop.value as SimpleValueProperty).stringValue»);
				«ELSE»
					«type.simpleName».set«prop.name.toFirstUpper»(«name»,«(prop.value as SimpleValueProperty).simpleAttributeValue»);
				«ENDIF»
			«ELSE»
				«type.simpleName».set«prop.name.toFirstUpper»(«name»,«(prop.value as SimpleValueProperty).simpleAttributeValue»);
			«ENDIF»
		«ELSEIF prop.value instanceof Element»
			«val varname = 'e_'+getVarIndex»
			«generateElementDef(varname,prop.value as Element)»
			«type.simpleName».set«prop.name.toFirstUpper»(«name»,«varname»);
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