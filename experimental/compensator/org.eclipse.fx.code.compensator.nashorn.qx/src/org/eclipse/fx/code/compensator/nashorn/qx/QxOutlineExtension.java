package org.eclipse.fx.code.compensator.nashorn.qx;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.ir.AccessNode;
import jdk.nashorn.internal.ir.BinaryNode;
import jdk.nashorn.internal.ir.Block;
import jdk.nashorn.internal.ir.BlockStatement;
import jdk.nashorn.internal.ir.BreakNode;
import jdk.nashorn.internal.ir.CallNode;
import jdk.nashorn.internal.ir.CaseNode;
import jdk.nashorn.internal.ir.CatchNode;
import jdk.nashorn.internal.ir.ContinueNode;
import jdk.nashorn.internal.ir.EmptyNode;
import jdk.nashorn.internal.ir.ExpressionStatement;
import jdk.nashorn.internal.ir.ForNode;
import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.ir.GetSplitState;
import jdk.nashorn.internal.ir.IdentNode;
import jdk.nashorn.internal.ir.IfNode;
import jdk.nashorn.internal.ir.IndexNode;
import jdk.nashorn.internal.ir.JoinPredecessorExpression;
import jdk.nashorn.internal.ir.LabelNode;
import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.LiteralNode;
import jdk.nashorn.internal.ir.Node;
import jdk.nashorn.internal.ir.ObjectNode;
import jdk.nashorn.internal.ir.PropertyNode;
import jdk.nashorn.internal.ir.ReturnNode;
import jdk.nashorn.internal.ir.RuntimeNode;
import jdk.nashorn.internal.ir.SetSplitState;
import jdk.nashorn.internal.ir.SplitNode;
import jdk.nashorn.internal.ir.SplitReturn;
import jdk.nashorn.internal.ir.SwitchNode;
import jdk.nashorn.internal.ir.TernaryNode;
import jdk.nashorn.internal.ir.ThrowNode;
import jdk.nashorn.internal.ir.TryNode;
import jdk.nashorn.internal.ir.UnaryNode;
import jdk.nashorn.internal.ir.VarNode;
import jdk.nashorn.internal.ir.WhileNode;
import jdk.nashorn.internal.ir.WithNode;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.nashorn.JSOutline;
import org.eclipse.fx.code.compensator.nashorn.JSOutlineExtension;
import org.eclipse.fx.code.compensator.nashorn.JSOutlineItem;

public class QxOutlineExtension implements JSOutlineExtension {

	@Override
	public boolean applies(Input<?> input) {
		return input.getData().toString().contains("qx.Class.define");
	}

	@Override
	public JSOutline createOutline(FunctionNode node) {
		JSOutlineItem root = new JSOutlineItem("<root>",null);

		node.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			private JSOutlineItem classDef;

			@Override
			public boolean enterCallNode(CallNode callNode) {
				if( callNode.getFunction().toString().endsWith("qx.Class.define") ) {
					classDef = new JSOutlineItem(((LiteralNode<?>)callNode.getArgs().get(0)).getString(), "qx-class-def");
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
						classDef.getChildren().add(handleMembers(propertyNode));
						break;
					default:
						break;
					}
				}
				return super.enterPropertyNode(propertyNode);
			}
		});
		return new JSOutline(root);
	}

	private JSOutlineItem handleProperties(PropertyNode p) {
		JSOutlineItem outline = new JSOutlineItem("Properties", "qx-properties");
		p.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {
			@Override
			public boolean enterPropertyNode(PropertyNode propertyNode) {
				if( p != propertyNode ) {
					outline.getChildren().add(new JSOutlineItem(propertyNode.getKeyName(), "qx-property-"+visibility(propertyNode.getKeyName())));
					return false;
				}

				return true;
			}
		});
		return outline;
	}

	private JSOutlineItem handleMembers(PropertyNode p) {
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
