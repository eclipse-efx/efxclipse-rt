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
package org.eclipse.fx.ui.controls.styledtext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.TextEditAction;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 * Mapping for user input triggers to actions to allow customization.
 *
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * @noreference
 */
public class TriggerActionMapping {

	public static class Context {
		public final StyledTextArea control;
		public Context(StyledTextArea control) {
			this.control = control;
		}
	}

	private static class Trigger {

		public final String conditionId;
		public final Supplier<Boolean> condition;

		public Trigger() {
			this.conditionId = null;
			this.condition = ()->true;
		}
		public Trigger(String conditionId, Supplier<Boolean> condition) {
			this.conditionId = conditionId;
			this.condition = condition;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((condition == null) ? 0 : condition.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Trigger other = (Trigger) obj;
			if (condition == null) {
				if (other.condition != null)
					return false;
			} else if (!condition.equals(other.condition))
				return false;
			return true;
		}
	}

	private static class KeyCombinationTrigger extends Trigger {
		public final KeyCombination keyCombo;

		/**
		 *
		 * @param keyCombo see {@link KeyCombination} for valid values
		 */
		public KeyCombinationTrigger(String keyCombo) {
			this.keyCombo = KeyCombination.keyCombination(keyCombo);
		}

		public KeyCombinationTrigger(String conditionId, Supplier<Boolean> condition, String keyCombo) {
			super(conditionId, condition);
			this.keyCombo = KeyCombination.keyCombination(keyCombo);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((keyCombo == null) ? 0 : keyCombo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			KeyCombinationTrigger other = (KeyCombinationTrigger) obj;
			if (keyCombo == null) {
				if (other.keyCombo != null)
					return false;
			} else if (!keyCombo.equals(other.keyCombo))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Combo("+this.keyCombo+")" + (conditionId != null ? "@" + conditionId : ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

	private static class TypedCharTrigger extends Trigger {
		public final char character;

		public TypedCharTrigger(char character) {
			this.character = character;
		}

		public TypedCharTrigger(String conditionId, Supplier<Boolean> condition, char character) {
			super(conditionId, condition);
			this.character = character;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + character;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			TypedCharTrigger other = (TypedCharTrigger) obj;
			if (character != other.character)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "TypedChar("+this.character+")" + (conditionId != null ? "@" + conditionId : ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

	private Map<Trigger, TextEditAction> mapping = new HashMap<>();

	private ObjectProperty<TriggerActionMapping> overrideProperty = new SimpleObjectProperty<>(this, "override"); //$NON-NLS-1$
	public ObjectProperty<TriggerActionMapping> overrideProperty() {
		return this.overrideProperty;
	}

	public void setOverride(TriggerActionMapping override) {
		this.overrideProperty.set(override);
	}

	public void map(String keyCombo, TextEditAction action) {
		this.mapping.put(new KeyCombinationTrigger(keyCombo), action);
	}

	public void map(char typedChar, TextEditAction action) {
		this.mapping.put(new TypedCharTrigger(typedChar), action);
	}

	public void mapConditional(String conditionId, Supplier<Boolean> condition, String keyCombo, TextEditAction action) {
		this.mapping.put(new KeyCombinationTrigger(conditionId, condition, keyCombo), action);
	}

	public void mapConditional(String conditionId, Supplier<Boolean> condition, char typedChar, TextEditAction action) {
		this.mapping.put(new TypedCharTrigger(conditionId, condition, typedChar), action);
	}

	private Stream<Trigger> applicableTriggers() {
		return this.mapping.keySet().stream().filter(x->x.condition.get());
	}

	private Optional<KeyCombinationTrigger> findTrigger(KeyCombination combo) {
		return applicableTriggers()
			.filter(t->t instanceof KeyCombinationTrigger)
			.map(t->(KeyCombinationTrigger)t)
			.filter(t->t.keyCombo.equals(combo))
			.findFirst();
	}

	private Optional<KeyCombinationTrigger> findTrigger(KeyEvent event) {
		 return applicableTriggers()
			.filter(t->t instanceof KeyCombinationTrigger)
			.map(t->(KeyCombinationTrigger)t)
			.filter(t->t.keyCombo.match(event))
			.findFirst();
	}

	private Optional<TypedCharTrigger> findTrigger(char typedChar) {
		return applicableTriggers()
			.filter(t->t instanceof TypedCharTrigger)
			.map(t->(TypedCharTrigger)t)
			.filter(t->t.character == typedChar)
			.findFirst();
	}

	public Optional<TextEditAction> get(KeyCombination combo) {
		if (this.overrideProperty.get() != null) {
			Optional<TextEditAction> overridden = this.overrideProperty.get().get(combo);
			if (overridden.isPresent()) {
				return overridden;
			}
		}
		return findTrigger(combo).map(t->this.mapping.get(t));
	}

	public Optional<TextEditAction> get(KeyEvent event) {
		if (this.overrideProperty.get() != null) {
			Optional<TextEditAction> overridden = this.overrideProperty.get().get(event);
			if (overridden.isPresent()) {
				return overridden;
			}
		}
		return findTrigger(event).map(t->this.mapping.get(t));
	}

	public Optional<TextEditAction> get(char typedChar) {
		if (this.overrideProperty.get() != null) {
			Optional<TextEditAction> overridden = this.overrideProperty.get().get(typedChar);
			if (overridden.isPresent()) {
				return overridden;
			}
		}
		return findTrigger(typedChar).map(t->this.mapping.get(t));
	}

	public boolean triggerAction(KeyCombination combo, Context context) {
		Optional<TextEditAction> optional = get(combo);
		return optional.map(a->handle(a, context)).orElse(false);
	}

	public boolean triggerAction(KeyEvent event, Context context) {
		Optional<TextEditAction> optional = get(event);
		return optional.map(a->handle(a, context)).orElse(false);
	}

	public boolean exists(KeyEvent event) {
		return get(event).isPresent();
	}

	public boolean exists(char c) {
		return get(c).isPresent();
	}

	public boolean triggerAction(char typedChar, Context context) {
		Optional<TextEditAction> optional = get(typedChar);
		return optional.map(a->handle(a, context)).orElse(false);
	}

	public boolean triggerAction(TextEditAction action, Context context) {
		return handle(action, context);
	}

	protected List<BiFunction<TextEditAction, Context, Boolean>> eventHandler = new ArrayList<>();





	public Subscription subscribe(BiFunction<TextEditAction, Context, Boolean> handler) {
		this.eventHandler.add(handler);
		return new Subscription() {
			@Override
			public void dispose() {
				TriggerActionMapping.this.eventHandler.remove(handler);
			}
		};
	}

	private boolean handleInternal(TextEditAction action, Context context) {
		for (BiFunction<TextEditAction, Context, Boolean> handler : this.eventHandler) {
			boolean consumed = handler.apply(action, context);
			if (consumed) {
				return true;
			}
		}
		return false;
	}

	private boolean handle(TextEditAction action, Context context) {
		if (this.overrideProperty.get() != null) {
			boolean result = this.overrideProperty.get().handle(action, context);
			if (result) {
				return true;
			}
		}

		return handleInternal(action, context);
	}
}
