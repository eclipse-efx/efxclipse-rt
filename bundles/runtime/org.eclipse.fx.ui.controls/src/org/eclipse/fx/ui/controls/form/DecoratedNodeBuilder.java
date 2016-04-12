package org.eclipse.fx.ui.controls.form;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.property.ValidationStatusPropertyOwner;

import javafx.scene.Node;

public final class DecoratedNodeBuilder {
	private final StatusDecorator decorator;
	private final ValidationStatusPropertyOwner statusPropertyOwner;
	private List<MutatorDef> nodeMutatorList;
	private final Node decoratedNode;

	static class MutatorDef {
		final Object data;
		final BiConsumer<Node,Object> mutator;

		public MutatorDef(Object data, BiConsumer<Node,?> mutator) {
			this.data = data;
			this.mutator = (BiConsumer<Node, Object>) mutator;
		}

	}
	DecoratedNodeBuilder(Node decoratedNode, StatusDecorator decorator, ValidationStatusPropertyOwner statusPropertyOwner) {
		this.decorator = decorator;
		this.decoratedNode = decoratedNode;
		this.statusPropertyOwner = statusPropertyOwner;
	}

	public static DecoratedNodeBuilder create(Node decoratedNode, ValidationStatusPropertyOwner statusPropertyOwner) {
		return create(decoratedNode,Util.getService(DecoratedNodeBuilder.class, StatusDecorator.class).orElse(new SimpleStatusDecorator()),statusPropertyOwner);
	}

	public static DecoratedNodeBuilder create(Node decoratedNode, StatusDecorator decorator, ValidationStatusPropertyOwner statusPropertyOwner) {
		return new DecoratedNodeBuilder(decoratedNode,decorator, statusPropertyOwner);
	}

	public DecoratedNodeBuilder decoratedNodeMutator(Consumer<Node> mutator) {
		decoratedNodeMutator(null, (n,o) -> mutator.accept(n));
		return this;
	}

	public <O> DecoratedNodeBuilder decoratedNodeMutator(O data, BiConsumer<Node, O> mutator) {
		if( this.nodeMutatorList == null ) {
			this.nodeMutatorList = new ArrayList<>();
		}
		this.nodeMutatorList.add( new MutatorDef(data, mutator) );
		return this;
	}

	public Node build() {
		Node node = this.decorator.decorate(this.statusPropertyOwner.statusProperty(), this.decoratedNode);
		if( this.nodeMutatorList != null ) {
			this.nodeMutatorList.forEach( m -> m.mutator.accept(node, m.data));
		}
		return node;
	}
}
