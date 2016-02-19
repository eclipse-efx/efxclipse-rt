package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.fx.code.editor.CodeReference;

public interface SearchProvider {

	
	
	Future<CodeReference> findDeclaration(int offset);

	Future<List<CodeReference>> findImplementations(int offset);

	Future<List<CodeReference>> findReferences(int offset);


}
