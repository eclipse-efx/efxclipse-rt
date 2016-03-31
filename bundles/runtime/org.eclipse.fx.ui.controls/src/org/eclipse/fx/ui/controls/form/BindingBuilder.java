package org.eclipse.fx.ui.controls.form;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.fx.core.Status;

import javafx.beans.property.Property;
import javafx.scene.Node;

public interface BindingBuilder<T> {
	public BindingBuilder<T> decoratedNode(Node decoratedNode);
	public BindingBuilder<T> decoratedNodeMutator( Consumer<Node> mutator );
	public <O> BindingBuilder<T> decoratedNodeMutator( O data, BiConsumer<Node,O> mutator );
	public BindingBuilder validator(Function<T, Status> validator);
	public BindingBuilder validator(BiFunction<T, Map<String,Object>, Status> validator);
	public BindingBuilder dependency(Property<?> property);
	public BindingBuilder dependency(String name, Property<?> property);
	public Binding build();
}
