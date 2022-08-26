/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.nashorn.qx;

import jdk.nashorn.internal.ir.CallNode;
import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.LiteralNode;
import jdk.nashorn.internal.ir.ObjectNode;
import jdk.nashorn.internal.ir.PropertyNode;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.code.compensator.nashorn.JSOutlineExtension;
import org.eclipse.fx.code.compensator.nashorn.JSOutlineItem;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public class QxOutlineExtension implements JSOutlineExtension {

	@Override
	public boolean applies(Input<?> input) {
		return input.getData().toString().contains("qx.Class.define");
	}

//	private static final URI Q_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/function.png");

	private static final URI FIELD_PRIVATE_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/field-private.png");
	private static final URI FIELD_PROTECTED_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/field-protected.png");
	private static final URI FIELD_PUBLIC_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/field-public.png");

	private static final URI METHOD_PRIVATE_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/method-private.png");
	private static final URI METHOD_PROTECTED_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/method-protected.png");
	private static final URI METHOD_PUBLIC_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/method-public.png");

	private static final URI PROPERTY_PRIVATE_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/property-public.png");
	private static final URI PROPERTY_PROTECTED_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/property-public.png");
	private static final URI PROPERTY_PUBLIC_CLASS = URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.nashorn.qx", "css/icons/property-public.png");


	@Override
	public OutlineItem createOutline(FunctionNode node, Input<?> input, GraphicsLoader loader) {
		JSOutlineItem root = new JSOutlineItem(null,"<root>",null);

		node.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			private JSOutlineItem classDef;

			@Override
			public boolean enterCallNode(CallNode callNode) {
				if( callNode.getFunction().toString().endsWith("qx.Class.define") ) {
					StyledString s = new StyledString();
					s.appendSegment(((LiteralNode<?>)callNode.getArgs().get(0)).getString(),"java-element-name");
					classDef = new JSOutlineItem(root,s, null);
					root.getChildren().add(classDef);
				}
				return super.enterCallNode(callNode);
			}

			@Override
			public boolean enterPropertyNode(PropertyNode propertyNode) {
				if( classDef != null ) {
					switch (propertyNode.getKeyName()) {
					case "include":
						break;
					case "extend":
						break;
					case "construct":
						break;
					case "statics":
						break;
					case "events":
						break;
					case "properties":
						classDef.getChildren().add(handleProperties(classDef,propertyNode,loader));
						break;
					case "members":
						classDef.getChildren().add(handleMembers(classDef,propertyNode,(String) input.getData(),loader));
						break;
					default:
						break;
					}
				}
				return super.enterPropertyNode(propertyNode);
			}
		});
		return root;
	}

	private JSOutlineItem handleProperties(OutlineItem parent, PropertyNode p, GraphicsLoader loader) {
		JSOutlineItem outline = new JSOutlineItem(parent, "Properties", null);
		p.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			@Override
			public boolean enterPropertyNode(PropertyNode propertyNode) {
				if( p != propertyNode ) {
					StyledString s = new StyledString();
					s.getSegmentList().add(new StyledStringSegment(propertyNode.getKeyName(),"java-element-name"));

					propertyNode.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
						public boolean enterPropertyNode(PropertyNode sub) {
							if( "check".equals(sub.getKeyName()) ) {
								s.getSegmentList().add(new StyledStringSegment(" : " + sub.getValue(),"java-type-info"));
								return false;
							}
							return true;
						}
					});
					URI uri;
					if( propertyNode.getKeyName().startsWith("__") ) {
						uri = PROPERTY_PRIVATE_CLASS;
					} else if( propertyNode.getKeyName().startsWith("_") ) {
						uri = PROPERTY_PROTECTED_CLASS;
					} else {
						uri = PROPERTY_PUBLIC_CLASS;
					}
					outline.getChildren().add(new JSOutlineItem(outline, s, () -> loader.getGraphicsNode(uri)));
					return false;
				}

				return true;
			}
		});
		return outline;
	}

	private JSOutlineItem handleMembers(OutlineItem parent, PropertyNode p, String content, GraphicsLoader loader) {
		JSOutlineItem outline = new JSOutlineItem(parent, "Members", null);

		p.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			@Override
			public boolean enterPropertyNode(PropertyNode propertyNode) {
				if( p != propertyNode ) {
					if( propertyNode.getValue() instanceof FunctionNode ) {
						URI uri;
						if( propertyNode.getKeyName().startsWith("__") ) {
							uri = METHOD_PRIVATE_CLASS;
						} else if( propertyNode.getKeyName().startsWith("_") ) {
							uri = METHOD_PROTECTED_CLASS;
						} else {
							uri = METHOD_PUBLIC_CLASS;
						}
						outline.getChildren().add(new JSOutlineItem(outline, propertyNode.getKeyName()+"()",() -> loader.getGraphicsNode(uri)));
					} else if( propertyNode.getValue() instanceof ObjectNode || propertyNode.getValue() instanceof LiteralNode<?> ) {
						URI uri;
						if( propertyNode.getKeyName().startsWith("__") ) {
							uri = FIELD_PRIVATE_CLASS;
						} else if( propertyNode.getKeyName().startsWith("_") ) {
							uri = FIELD_PROTECTED_CLASS;
						} else {
							uri = FIELD_PUBLIC_CLASS;
						}

						outline.getChildren().add(new JSOutlineItem(outline, propertyNode.getKeyName(),() -> loader.getGraphicsNode(uri)));
					} else {
						System.err.println("Unknown value type: " + propertyNode.getValue().getClass());
					}
					return false;
				}
				return true;
			}
		});
		return outline;
	}

	private static String visibility(String name) {
		if( name.startsWith("__") ) {
			return "private";
		} else if( name.startsWith("_") ) {
			return "protected";
		}
		return "public";
	}
}
