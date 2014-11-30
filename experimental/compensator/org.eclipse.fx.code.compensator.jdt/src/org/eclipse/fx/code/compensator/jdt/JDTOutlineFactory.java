package org.eclipse.fx.code.compensator.jdt;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.code.compensator.editor.services.OutlineFactory;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class JDTOutlineFactory implements OutlineFactory {

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			return ((ContentTypeProvider) input).getContentType() == ContentTypeProvider.JAVA;
		}
		return false;
	}

	@Override
	public Outline createOutline(Input<?> input) {
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
	    parser.setSource(input.getData().toString().toCharArray());
	    parser.setResolveBindings(true);
	    ASTNode cu = parser.createAST(null);

	    Stack<OutlineItem> i = new Stack<>();
        i.push(new JavaOutlineItem("<root>",null));

	    cu.accept(new ASTVisitor() {

	    	@Override
	    	public boolean visit(TypeDeclaration node) {
	    		OutlineItem o = new JavaOutlineItem(node.getName().getFullyQualifiedName(), "java-class");
	    		i.peek().getChildren().add(o);
	    		i.push(o);

	    		return super.visit(node);
	    	}

	    	@Override
	    	public void endVisit(TypeDeclaration node) {
	    		i.pop();
	    		super.endVisit(node);
	    	}

	    	@Override
	    	public boolean visit(FieldDeclaration node) {
	    		for( Object v : node.fragments() ) {
	    			if( v instanceof VariableDeclarationFragment ) {
	    				VariableDeclarationFragment vdf = (VariableDeclarationFragment) v;
	    				i.peek().getChildren().add(new JavaOutlineItem(vdf.getName().getFullyQualifiedName(), "java-field"));
	    			}
	    		}
	    		return super.visit(node);
	    	}

	    	@Override
	    	public boolean visit(MethodDeclaration node) {
	    		i.peek().getChildren().add(new JavaOutlineItem(node.getName().getFullyQualifiedName(), "java-method"));
	    		return super.visit(node);
	    	}

		});
		return new JavaOutline(i.peek());
	}

	static class JavaOutline implements Outline {
		private  OutlineItem i;

		public JavaOutline( OutlineItem i) {
			this.i = i;
		}

		@Override
		public ObservableList<OutlineItem> getRootItems() {
			return i.getChildren();
		}

	}

	static class JavaOutlineItem implements OutlineItem {
		private final String label;
		private final ObservableList<OutlineItem> list = FXCollections.observableArrayList();
		private final String type;

		public JavaOutlineItem(String label, String type) {
			this.label = label;
			this.type = type;
		}

		@Override
		public String getLabel() {
			return label;
		}

		@Override
		public List<String> getStyle() {
			return type == null ? Collections.emptyList() : Collections.singletonList(type);
		}

		@Override
		public ObservableList<OutlineItem> getChildren() {
			return list;
		}

	}
}
