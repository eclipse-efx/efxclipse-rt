/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.function;

/**
 * Relation operations for doubles
 * <ul>
 * <li>&lt; - lower than</li>
 * <li>&gt; - greater than</li>
 * <li>&lt;= - lower than or equal</li>
 * <li>&gt;= - greater than or equal</li>
 * <li>== - equal</li>
 * <li>!= - not equal</li>
 * </ul>
 * To create relation operations one uses the static helpers
 * 
 * <pre>
 * <code>
 * IntRelationOperation r = IntRelationOperation::lt
 * if( r.apply(10, 11) ) {
 * 	// 10 is lower than 11
 * }
 * </code>
 * </pre>
 * 
 * @since 2.2
 */
public interface IntRelationOperation {
	/**
	 * Execute the relation
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public boolean apply(int i, int j);

	/**
	 * Check if i lower than j
	 *
	 * <pre>
	 * <code>
	 *  i &lt; j
	 * </code>
	 * </pre>
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public static boolean lt(int i, int j) {
		return i < j;
	}

	/**
	 * Check if i lower than or equal j
	 *
	 * <pre>
	 * <code>
	 *  i &lt;= j
	 * </code>
	 * </pre>
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public static boolean lte(int i, int j) {
		return i <= j;
	}

	/**
	 * Check if i greater than j
	 *
	 * <pre>
	 * <code>
	 *  i &gt; j
	 * </code>
	 * </pre>
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public static boolean gt(int i, int j) {
		return i > j;
	}

	/**
	 * Check if i greater than or equal j
	 *
	 * <pre>
	 * <code>
	 *  i &gt;= j
	 * </code>
	 * </pre>
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public static boolean gte(int i, int j) {
		return i >= j;
	}

	/**
	 * Check if i equal to j
	 *
	 * <pre>
	 * <code>
	 *  i == j
	 * </code>
	 * </pre>
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public static boolean eq(int i, int j) {
		return i == j;
	}

	/**
	 * Check if i not equal to j
	 *
	 * <pre>
	 * <code>
	 *  i != j
	 * </code>
	 * </pre>
	 *
	 * @param i
	 *            the first operand
	 * @param j
	 *            the 2nd operand
	 * @return the result
	 */
	public static boolean neq(int i, int j) {
		return i != j;
	}
}