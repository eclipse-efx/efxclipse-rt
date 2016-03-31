package org.eclipse.fx.ui.controls.form;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.Util;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class DefaultForm implements Form {
	final StatusDecorator decorator;
	private List<BindingImpl<?>> bindingList = new ArrayList<>();
	private ReadOnlyObjectWrapper<Status> validationStatus = new ReadOnlyObjectWrapper<>(this, "validationStatus", Status.ok());

	static Comparator<Status> STATUS_SORTER = (s1, s2) -> s1.getState().compareTo(s2.getState());
	static Predicate<Status> WARNING_ERROR = s -> s.getState() == State.ERROR || s.getState() == State.WARNING;

	public DefaultForm() {
		this(Util.lookupService(DefaultForm.class, StatusDecorator.class));
	}

	public DefaultForm(StatusDecorator decorator) {
		this.decorator = decorator;
	}

	public void registerBinding(BindingImpl<?> binding) {
		binding.validationStatusProperty().addListener(this::handleBindingStatusChange);
		this.bindingList.add(binding);
	}

	public void unregisterBinding(BindingImpl<?> binding) {
		binding.validationStatusProperty().removeListener(this::handleBindingStatusChange);
		this.bindingList.remove(binding);
	}

	private void handleBindingStatusChange(Observable o, Status ol, Status ne) {
		this.validationStatus.set(this.bindingList.stream()
			.map( b -> b.validationStatusProperty().get() )
			.sorted(STATUS_SORTER).filter(WARNING_ERROR)
			.findFirst()
			.orElse(Status.ok()));
	}

	@Override
	public ReadOnlyObjectProperty<Status> validationStatusProperty() {
		return this.validationStatus.getReadOnlyProperty();
	}

	@Override
	public <T> BindingBuilder<T> builder(String id, Property<T> validatedProperty, Property<T> oppositeProperty, BindingConfiguration type ) {
		return new BindingBuilderImpl<>(this, id, validatedProperty, oppositeProperty, type);
	}

	static class MutatorDef {
		final Object data;
		final BiConsumer<Node,Object> mutator;

		public MutatorDef(Object data, BiConsumer<Node,?> mutator) {
			this.data = data;
			this.mutator = (BiConsumer<Node, Object>) mutator;
		}

	}

	static class BindingBuilderImpl<T> implements BindingBuilder<T> {
		private final Property<T> validatedProperty;
		private final Property<T> oppositeProperty;
		private final BindingConfiguration type;
		private final DefaultForm form;
		private final String id;
		private Map<String, Property<?>> dependencyMap;
		private List<BiFunction<T,Map<String,Object>,Status>> validationList;
		private List<MutatorDef> nodeMutatorList;
		private Node decoratedNode;

		public BindingBuilderImpl(DefaultForm form, String id, Property<T> validatedProperty, Property<T> oppositeProperty, BindingConfiguration type) {
			this.form = form;
			this.validatedProperty = validatedProperty;
			this.oppositeProperty = oppositeProperty;
			this.type = type;
			this.id = id;
		}

		@Override
		public BindingBuilder<T> validator(Function<T,Status> validator) {
			return validator(( t, dep ) -> validator.apply(t));
		}

		@Override
		public BindingBuilder<T> decoratedNodeMutator(Consumer<Node> mutator) {
			decoratedNodeMutator(null, (n,o) -> mutator.accept(n));
			return this;
		}

		@Override
		public <O> BindingBuilder<T> decoratedNodeMutator(O data, BiConsumer<Node, O> mutator) {
			if( this.nodeMutatorList == null ) {
				this.nodeMutatorList = new ArrayList<>();
			}
			this.nodeMutatorList.add( new MutatorDef(data, mutator) );
			return this;
		}

		@Override
		public BindingBuilder<T> validator(BiFunction<T,Map<String,Object>,Status> validator) {
			if( this.validationList == null ) {
				this.validationList = new ArrayList<>();
			}
			this.validationList.add(validator);
			return this;
		}

		@Override
		public BindingBuilder<T> dependency(Property<?> property) {
			if( property.getName() == null ) {
				throw new IllegalArgumentException("The provided property is not named. Use dependency(String,Property) instead"); //$NON-NLS-1$
			}
			return dependency(property.getName(), property);
		}

		@Override
		public BindingBuilder<T> dependency(String name, Property<?> property) {
			if( this.dependencyMap != null ) {
				this.dependencyMap = new HashMap<>();
			}
			if( this.dependencyMap.containsKey(name) ) {
				throw new IllegalStateException("You already register a dependency '"+this.dependencyMap.get(name)+"' named '"+name+"'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			this.dependencyMap.put(name, property);
			return this;
		}

		@Override
		public BindingBuilder<T> decoratedNode(Node decoratedNode) {
			this.decoratedNode = decoratedNode;
			return this;
		}

		@Override
		public Binding build() {
			return new BindingImpl<>(this.form, this.id, this.decoratedNode, this.validatedProperty, this.oppositeProperty, this.dependencyMap, this.validationList, this.nodeMutatorList, this.type);
		}
	}

	static class BindingImpl<T> implements Binding {
		private final Property<T> validatedProperty;
		private final Property<T> oppositeProperty;
		private final Map<String, Property<?>> dependencyMap;
		private final List<BiFunction<T,Map<String,Object>,Status>> validationList;
		private final List<MutatorDef> nodeMutatorList;
		private final String id;
		private ObservableList<Status> validationStatusList = FXCollections.observableArrayList();
		private ReadOnlyObjectWrapper<Status> validationStatus = new ReadOnlyObjectWrapper<>(this, "status", Status.ok()); //$NON-NLS-1$
		private BindingConfiguration type;
		private final DefaultForm form;
		private Node decoratedNode;
		private Node cachedNode;

		public BindingImpl(DefaultForm form, String id, Node decoratedNode, Property<T> validatedProperty,
				Property<T> oppositeProperty,
				Map<String, Property<?>> dependencyMap,
				List<BiFunction<T,Map<String,Object>,Status>> validationList,
				List<MutatorDef> nodeMutatorList,
				BindingConfiguration type) {
			this.form = form;
			this.id = id;
			this.form.registerBinding(this);
			this.decoratedNode = decoratedNode;
			this.validatedProperty = validatedProperty;
			this.oppositeProperty = oppositeProperty;
			this.nodeMutatorList = nodeMutatorList == null ? null: new ArrayList<>(nodeMutatorList);
			this.dependencyMap = dependencyMap == null ? null : new HashMap<>(dependencyMap);
			this.validationList = validationList == null ? null : new ArrayList<>(validationList);
			this.type = type;

			if( type == BindingConfiguration.VALIDATE_TO_OPPOSITE ) {
				this.validatedProperty.bindBidirectional(oppositeProperty);
			} else {
				this.oppositeProperty.bindBidirectional(validatedProperty);
			}

			if( dependencyMap != null ) {
				this.dependencyMap.entrySet().forEach( e -> e.getValue().addListener( (o, ol, ne) -> {
					runvalidation();
				} ));
			}
			this.validatedProperty.addListener((o, ol, ne) -> {
				runvalidation();
			} );
		}

		@Override
		public String id() {
			return this.id;
		}

		@Override
		public ReadOnlyObjectProperty<Status> validationStatusProperty() {
			return this.validationStatus.getReadOnlyProperty();
		}

		private void runvalidation() {
			if( this.validationList != null ) {
				Map<String, Object> map = Optional.ofNullable(this.dependencyMap)
					.map(m -> m.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> (Object)e.getValue().getValue())))
					.orElse(new HashMap<>());
				this.validationStatusList.setAll(this.validationList
					.stream()
					.map( f -> f.apply(this.validatedProperty.getValue(), map))
					.collect(Collectors.toList()));
				this.validationStatus.setValue(this.validationStatusList
					.stream()
					.sorted( STATUS_SORTER )
					.filter( WARNING_ERROR )
					.findFirst()
					.orElse(Status.ok()));
			}
		}

		@Override
		public Node nodeWithStatus() {
			if( this.cachedNode == null ) {
				this.cachedNode = this.form.decorator.decorate(this.validationStatus, this.decoratedNode);
				if( this.nodeMutatorList != null ) {
					this.nodeMutatorList.forEach( m -> m.mutator.accept(this.cachedNode, m.data));
				}
			} else {
				this.cachedNode = new StatusNode(this.validationStatus);
			}
			return this.cachedNode;
		}

		@Override
		public void dispose() {
			if( this.type == BindingConfiguration.VALIDATE_TO_OPPOSITE ) {
				this.validatedProperty.unbindBidirectional(this.oppositeProperty);
			} else {
				this.oppositeProperty.unbindBidirectional(this.validatedProperty);
			}
			this.form.unregisterBinding(this);
		}

	}
}
