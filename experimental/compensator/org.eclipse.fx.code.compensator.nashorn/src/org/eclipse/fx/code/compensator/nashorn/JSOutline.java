package org.eclipse.fx.code.compensator.nashorn;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import javafx.collections.ObservableList;

import javax.inject.Inject;

import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.ir.IdentNode;
import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.Node;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.Parser;
import jdk.nashorn.internal.runtime.Context;
import jdk.nashorn.internal.runtime.ErrorManager;
import jdk.nashorn.internal.runtime.Source;
import jdk.nashorn.internal.runtime.options.Options;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.core.di.Service;

public class JSOutline implements Outline {
	private OutlineItem i;

	@Inject
	public JSOutline(@Service List<JSOutlineExtension> extensionList, Input<?> input) {
		this.i = builtIt(extensionList, input);
	}

	@Override
	public ObservableList<OutlineItem> getRootItems() {
		return i.getChildren();
	}

	private static OutlineItem builtIt(List<JSOutlineExtension> extensions, Input<?> input) {
		final Options options = new Options("nashorn");
        options.set("anon.functions", true);
        options.set("parse.only", true);
        options.set("scripting", true);

        ErrorManager errors = new ErrorManager();
        Context context = new Context(options, errors, Thread.currentThread().getContextClassLoader());

        Context.setGlobal(new Global( context ));

        final Source   source   = Source.sourceFor("dummy.js", input.getData().toString().toCharArray());
        FunctionNode node = new Parser(context.getEnv(), source, errors).parse();

        Optional<JSOutlineExtension> extension = extensions.stream().filter((e) -> e.applies(input)).findFirst();
        return extension.map((e)->e.createOutline(node,input)).orElse(defaultOutline(node));
	}

	private static OutlineItem defaultOutline(FunctionNode node) {
		Stack<OutlineItem> i = new Stack<>();
        i.push(new JSOutlineItem("<root>",null));
        node.accept(new NodeVisitor<LexicalContext>(new LexicalContext()) {

        	@Override
        	public boolean enterFunctionNode(FunctionNode functionNode) {
        		if( ! functionNode.isProgram() ) {
        			JSOutlineItem outlineItem;
        			if( functionNode.isAnonymous() ) {
        				String name = ((IdentNode)functionNode.getIdent().accept(this)).getName();
        				if( name.contains(":") ) {
        					outlineItem = new JSOutlineItem("<anonymous>","js-function-icon");
        				} else {
        					outlineItem = new JSOutlineItem(name,"js-method-icon");
        				}
        			} else {
        				outlineItem = new JSOutlineItem(((IdentNode)functionNode.getIdent().accept(this)).getName(),"js-function-icon");
        			}

        			i.peek().getChildren().add(outlineItem);
        			i.push(outlineItem);
        		}
        		return super.enterFunctionNode(functionNode);
        	}

        	@Override
        	public Node leaveFunctionNode(FunctionNode functionNode) {
        		if( ! functionNode.isProgram() ) {
        			i.pop();
        		}

        		return super.leaveFunctionNode(functionNode);
        	}
		});

		return i.peek();
	}
}