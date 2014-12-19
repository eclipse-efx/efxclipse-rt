package org.eclipse.fx.code.compensator.jdt;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.code.compensator.editor.services.OutlineFactory;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
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
	    		String style;
				if( Modifier.isPrivate(node.getModifiers()) ) {
					style = "java-class-private";
				} else if( Modifier.isProtected(node.getModifiers()) ) {
					style = "java-class-protected";
				} else if( Modifier.isPublic(node.getModifiers()) ) {
					style = "java-class-public";
				} else {
					style = "java-class-default";
				}
				StyledString s = new StyledString();
				s.getSegmentList().add(new StyledStringSegment(node.getName().getFullyQualifiedName(),"java-element-name"));
	    		OutlineItem o = new JavaOutlineItem(s, style);
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
	    		String style;
				if( Modifier.isPrivate(node.getModifiers()) ) {
					style = "java-field-private";
				} else if( Modifier.isProtected(node.getModifiers()) ) {
					style = "java-field-protected";
				} else if( Modifier.isPublic(node.getModifiers()) ) {
					style = "java-field-public";
				} else {
					style = "java-field-default";
				}

				String type = node.getType().toString();

	    		for( Object v : node.fragments() ) {
	    			if( v instanceof VariableDeclarationFragment ) {
	    				VariableDeclarationFragment vdf = (VariableDeclarationFragment) v;
	    				StyledString s = new StyledString();
	    				s.getSegmentList().add(new StyledStringSegment(vdf.getName().getFullyQualifiedName(),"java-element-name"));
	    				s.getSegmentList().add(new StyledStringSegment(" : " + type, "java-type-info"));
	    				i.peek().getChildren().add(new JavaOutlineItem(s, style));
	    			}
	    		}
	    		return super.visit(node);
	    	}

	    	@Override
	    	public boolean visit(MethodDeclaration node) {
	    		String style;
				if( Modifier.isPrivate(node.getModifiers()) ) {
					style = "java-method-private";
				} else if( Modifier.isProtected(node.getModifiers()) ) {
					style = "java-method-protected";
				} else if( Modifier.isPublic(node.getModifiers()) ) {
					style = "java-method-public";
				} else {
					style = "java-method-default";
				}

				String type = node.getReturnType2() == null ? "void" : node.getReturnType2().toString();
				StyledString s = new StyledString();
				s.getSegmentList().add(new StyledStringSegment(node.getName().getFullyQualifiedName(),"java-element-name"));

				StringBuffer b = new StringBuffer();

				b.append("(");
				Iterator<?> iterator = node.parameters().iterator();
				while( iterator.hasNext()  ) {
					SingleVariableDeclaration d = (SingleVariableDeclaration) iterator.next();
					b.append(d.getType().toString());
					if( iterator.hasNext() ) {
						b.append(",");
					}
				}
				b.append(")");
				s.getSegmentList().add(new StyledStringSegment(b.toString(),"java-element-name"));
				s.getSegmentList().add(new StyledStringSegment(" : " + type, "java-type-info"));

	    		i.peek().getChildren().add(new JavaOutlineItem(s, style));
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
		private final CharSequence label;
		private final ObservableList<OutlineItem> list = FXCollections.observableArrayList();
		private final String type;

		public JavaOutlineItem(CharSequence label, String type) {
			this.label = label;
			this.type = type;
		}

		@Override
		public CharSequence getLabel() {
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
