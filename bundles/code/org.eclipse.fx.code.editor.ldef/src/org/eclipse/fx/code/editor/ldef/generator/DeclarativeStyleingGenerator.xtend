package org.eclipse.fx.code.editor.ldef.generator

import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.fx.code.editor.ldef.lDef.Root

class DeclarativeStyleingGenerator {
	def generate(LanguageDef model, IFileSystemAccess access) {
		if( model?.lexicalHighlighting?.vistual != null ) {
			access.generateFile((model.eContainer as Root).name.replace(".","/") + "/" + model.name + ".css", model.generateJavaFXCSS)
			access.generateFile((model.eContainer as Root).name.replace(".","/") + "/" + model.name + "-swt-style.json", model.generateSWTStyleing)
		}
	}

	def generateJavaFXCSS(LanguageDef model) '''
		«FOR tv : model.lexicalHighlighting.vistual.tokenVisuals»
		.styled-text-area .«model.name».«tv.token.name» {
			-styled-text-color: «tv.colorSpec»;
			«IF tv.bold»
			-fx-font-weight: bold;
			«ENDIF»
			«IF tv.italic»
			-fx-font-style: italic;
			«ENDIF»
		}

		«ENDFOR»
	'''

	def generateSWTStyleing(LanguageDef model) '''
	{
	  "$gtype": "StylesheetDefinition",
	  "colorList": [],
	  "elementList": [
		«FOR tv : model.lexicalHighlighting.vistual.tokenVisuals»
		    {
		      "$gtype": "StyleDefinition",
		      "bold": «tv.bold»,
		      "italic": «tv.italic»,
		      "name": "«model.name».«tv.token.name»",
		      "textRefColor": "«tv.colorSpec»"
		    }«IF model.lexicalHighlighting.vistual.tokenVisuals.last != tv»,«ENDIF»
		«ENDFOR»
		]
	}
	'''
}