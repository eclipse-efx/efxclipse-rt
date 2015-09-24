/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.preferences;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * <p>
 * Annotation to inject a preference value.
 * </p>
 * The injected type can be:
 * <ul>
 * <li>"primitive": String, Boolean, boolean, Integer, int, Double, double, Float, float, Long, long</li>
 * <li>{@link Value}: where the type argument can be String, Boolean, Integer, Double, Float, Long</li>
 * </ul>
 * <p>
 * If you value {@link Value} the injected value must be exactly of this type
 * </p>
 * Examples
 * <pre>
 * class Test {
 *   &#64;Inject
 *   &#64;Preference("value")
 *   int value;
 *
 *   &#64;Inject
 *   &#64;Preference("value")
 *   Value&lt;Integer&gt; value;
 * }
 * </pre>
 */
@Qualifier
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Preference {
	/**
	 * @return path to the node
	 */
	String nodePath() default "";
	/**
	 * @return the key in the node
	 */
	String key();
	/**
	 * @return the desired type if no generics are used
	 */
	Class<?> type() default Object.class;
	/**
	 * @return a default value
	 */
	String defaultValue() default "";
}
