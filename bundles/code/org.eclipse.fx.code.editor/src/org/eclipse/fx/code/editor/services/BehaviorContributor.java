package org.eclipse.fx.code.editor.services;

import java.util.function.Supplier;

import org.eclipse.fx.core.text.TextEditAction;

public interface BehaviorContributor {

	public static interface MappingRegistry {
		void map(String combo, TextEditAction action);
		void map(char typedChar, TextEditAction action);

		void mapConditional(String conditionId, Supplier<Boolean> condition, String combo, TextEditAction action);
		void mapConditional(String conditionId, Supplier<Boolean> condition, char typedChar, TextEditAction action);
	}


	public void initializeMapping(MappingRegistry mapping);

	/**
	 *
	 * @param action
	 * @param context
	 * @return true if this action was consumed
	 */
	public default boolean handle(TextEditAction action) {
		return false;
	}

}
