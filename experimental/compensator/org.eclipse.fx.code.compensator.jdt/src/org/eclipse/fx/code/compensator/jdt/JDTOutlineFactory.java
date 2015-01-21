package org.eclipse.fx.code.compensator.jdt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import javax.inject.Inject;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.code.compensator.editor.services.OutlineFactory;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;
import org.eclipse.fx.ui.services.resources.AdornedImageDescriptor;
import org.eclipse.fx.ui.services.resources.AdornedImageDescriptor.Adornment;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class JDTOutlineFactory implements OutlineFactory {
	public enum Type {
		UNKNOWN,

		FIELD,
		METHOD,
		CONSTRUCTOR,

		INTERFACE,
		CLASS,
		ENUM
	}

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			return ((ContentTypeProvider) input).getContentType() == ContentTypeProvider.JAVA;
		}
		return false;
	}

	@Override
	public Class<? extends Outline> createOutline(Input<?> input) {
		return JavaOutline.class;
	}

	public static class JavaOutline implements Outline {
		private  OutlineItem i;

		@Inject
		public JavaOutline(Input<?> input, GraphicsLoader graphicsLoader) {
			this.i = builtOutline(input,graphicsLoader);
		}

		@Override
		public ObservableList<OutlineItem> getRootItems() {
			return i.getChildren();
		}

		private static OutlineItem builtOutline(Input<?> input, GraphicsLoader graphicsLoader) {
			ASTParser parser = ASTParser.newParser(AST.JLS8);
			parser.setKind(ASTParser.K_COMPILATION_UNIT);
		    parser.setSource(input.getData().toString().toCharArray());
		    parser.setResolveBindings(true);
		    ASTNode cu = parser.createAST(null);

		    Stack<OutlineItem> i = new Stack<>();
	        i.push(new JavaOutlineItem(null,graphicsLoader,"<root>",Type.UNKNOWN,0));

		    cu.accept(new ASTVisitor() {

		    	@Override
		    	public boolean visit(TypeDeclaration node) {
					StyledString s = new StyledString();
					s.getSegmentList().add(new StyledStringSegment(node.getName().getFullyQualifiedName(),"java-element-name"));
		    		OutlineItem o = new JavaOutlineItem(i.peek(),graphicsLoader,s, Type.CLASS, node.getModifiers());
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

					String type = node.getType().toString();

		    		for( Object v : node.fragments() ) {
		    			if( v instanceof VariableDeclarationFragment ) {
		    				VariableDeclarationFragment vdf = (VariableDeclarationFragment) v;
		    				StyledString s = new StyledString();
		    				s.getSegmentList().add(new StyledStringSegment(vdf.getName().getFullyQualifiedName(),"java-element-name"));
		    				s.getSegmentList().add(new StyledStringSegment(" : " + type, "java-type-info"));
		    				i.peek().getChildren().add(new JavaOutlineItem(i.peek(),graphicsLoader,s, Type.FIELD,node.getModifiers()));
		    			}
		    		}
		    		return super.visit(node);
		    	}

		    	@Override
		    	public boolean visit(MethodDeclaration node) {
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

		    		i.peek().getChildren().add(new JavaOutlineItem(i.peek(),graphicsLoader,s, Type.METHOD, node.getModifiers()));
		    		return super.visit(node);
		    	}

			});
		    return i.peek();
		}
	}

	static class JavaOutlineItem implements OutlineItem {
		private final CharSequence label;
		private final ObservableList<OutlineItem> list = FXCollections.observableArrayList();

		private final int flags;
		private final Type type;
		private final GraphicsLoader loader;
		private final OutlineItem parent;

		public JavaOutlineItem(OutlineItem parent, GraphicsLoader loader, CharSequence label, Type type, int flags) {
			this.parent = parent;
			this.loader = loader;
			this.label = label;
			this.type = type;
			this.flags = flags;
		}

		@Override
		public CharSequence getLabel() {
			return label;
		}

		@Override
		public OutlineItem getParent() {
			return parent;
		}

		@Override
		public Node getGraphic() {
			URI baseImage = null;

			List<Adornment> adornments = new ArrayList<>();

			if( type == Type.CLASS ) {
				baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/classpub_obj.png");
			} else if( type == Type.FIELD ) {
				if(Flags.isPrivate(flags)) {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_private_obj.png");
				} else if( Flags.isProtected(flags) ) {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_protected_obj.png");
				} else if( Flags.isPublic(flags) ) {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_public_obj.png");
				} else {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/field_default_obj.png");
				}
			} else if( type == Type.METHOD ) {
				if(Flags.isPrivate(flags)) {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methpri_obj.png");
				} else if( Flags.isProtected(flags) ) {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methpro_obj.png");
				} else if( Flags.isPublic(flags) ) {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methpub_obj.png");
				} else {
					baseImage = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.jdt", "css/icons/16/methdef_obj.png");
				}
			}

			if( baseImage != null ) {
				if( adornments.isEmpty() ) {
					return loader.getGraphicsNode(baseImage);
				}
				return loader.getGraphicsNode(new AdornedImageDescriptor(baseImage, adornments));
			}

			return null;
		}

		@Override
		public ObservableList<OutlineItem> getChildren() {
			return list;
		}

	}
}
