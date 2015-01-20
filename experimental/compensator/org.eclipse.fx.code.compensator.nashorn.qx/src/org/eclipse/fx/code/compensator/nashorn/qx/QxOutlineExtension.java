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
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;

public class QxOutlineExtension implements JSOutlineExtension {

	@Override
	public boolean applies(Input<?> input) {
		return input.getData().toString().contains("qx.Class.define");
	}

	@Override
	public OutlineItem createOutline(FunctionNode node, Input<?> input) {
		JSOutlineItem root = new JSOutlineItem("<root>",null);

		node.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			private JSOutlineItem classDef;

			@Override
			public boolean enterCallNode(CallNode callNode) {
				if( callNode.getFunction().toString().endsWith("qx.Class.define") ) {
					StyledString s = new StyledString();
					s.appendSegment(((LiteralNode<?>)callNode.getArgs().get(0)).getString(),"java-element-name");
					classDef = new JSOutlineItem(s, "qx-class-def");
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
						classDef.getChildren().add(handleProperties(propertyNode));
						break;
					case "members":
						classDef.getChildren().add(handleMembers(propertyNode,(String) input.getData()));
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

	private JSOutlineItem handleProperties(PropertyNode p) {
		JSOutlineItem outline = new JSOutlineItem("Properties", "qx-properties");
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

					outline.getChildren().add(new JSOutlineItem(s, "qx-property-"+visibility(propertyNode.getKeyName())));
					return false;
				}

				return true;
			}
		});
		return outline;
	}

	private JSOutlineItem handleMembers(PropertyNode p, String content) {
		JSOutlineItem outline = new JSOutlineItem("Members", "qx-members");

		p.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			@Override
			public boolean enterPropertyNode(PropertyNode propertyNode) {
				if( p != propertyNode ) {
					if( propertyNode.getValue() instanceof FunctionNode ) {
						outline.getChildren().add(new JSOutlineItem(propertyNode.getKeyName()+"()","qx-method-"+visibility(propertyNode.getKeyName())));
					} else if( propertyNode.getValue() instanceof ObjectNode ) {
						outline.getChildren().add(new JSOutlineItem(propertyNode.getKeyName(),"qx-field-"+visibility(propertyNode.getKeyName())));
					} else if( propertyNode.getValue() instanceof LiteralNode<?> ) {
						outline.getChildren().add(new JSOutlineItem(propertyNode.getKeyName(),"qx-field-"+visibility(propertyNode.getKeyName())));
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
