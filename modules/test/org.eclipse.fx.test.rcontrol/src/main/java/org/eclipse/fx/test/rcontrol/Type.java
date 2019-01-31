/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.rcontrol;

import java.time.Duration;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;

/**
 * Type operations
 */
public interface Type {
	/**
	 * Create an operation to type in the provided key codes
	 * 
	 * @param codes
	 *            the key codes
	 * @return operation
	 */
	public static Operation key(KeyCode... codes) {
		return (r) -> {
			r.type(codes);
			return r;
		};
	}

	/**
	 * Create an operation to type in the provided key codes in the provided time
	 * 
	 * @param d
	 *            the duration
	 * @param codes
	 *            the codes
	 * @return operation
	 */
	public static Operation key(Duration d, KeyCode... codes) {
		return (r) -> {
			double v = d.toMillis() * 1.0 / codes.length;
			for (KeyCode c : codes) {
				r.type(c);
				r.sleep((long) v);
			}
			return r;
		};
	}

	/**
	 * Create an operation to type the provided key combinations
	 * 
	 * @param combinations
	 *            the combinations
	 * @return operation
	 */
	public static Operation key(KeyCodeCombination... combinations) {
		return (r) -> {
			r.type(combinations);
			return r;
		};
	};

	/**
	 * Create an operation to type the provided key combinations in the provided
	 * time
	 * 
	 * @param d
	 *            the duration
	 * 
	 * @param combinations
	 *            the combinations
	 * @return operation
	 */
	public static Operation key(Duration d, KeyCodeCombination... combinations) {
		return (r) -> {
			double v = d.toMillis() * 1.0 / combinations.length;
			for (KeyCodeCombination c : combinations) {
				r.type(c);
				r.sleep((long) v);
			}
			return r;
		};
	}

	/**
	 * Create an operation to type the provided text
	 * 
	 * @param text
	 *            the text
	 * @return operation
	 */
	public static Operation text(String text) {
		return (r) -> {
			r.text(text);
			return r;
		};
	}

	/**
	 * Create an operation to type the provided text in the provided time
	 * 
	 * @param d
	 *            the duration
	 * @param text
	 *            the text
	 * @return operation
	 */
	public static Operation text(Duration d, String text) {
		return (r) -> {
			double v = d.toMillis() * 1.0 / text.length();
			for (char c : text.toCharArray()) {
				r.text(String.valueOf(c));
				r.sleep((long) v);
			}
			return r;
		};
	}

	/**
	 * All type actions
	 * 
	 * @param <C>
	 *            the owner
	 */
	public interface Typable<C> {
		/**
		 * Type the provided text
		 * 
		 * @param text
		 *            the text
		 * @return the owner
		 */
		public C typeText(String text);

	}
}
