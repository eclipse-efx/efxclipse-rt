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
package org.eclipse.fx.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;

import org.eclipse.jdt.annotation.NonNull;

/**
 * (extensible) service who allows to serialize simple values like
 * {@link Instant} to a string and deserialize it from there the following types
 * are always supported:
 * <ul>
 * <li>Basic-Datatype
 * <ul>
 * <li>{@link Boolean}</li>
 * <li>{@link Short}</li>
 * <li>{@link Integer}</li>
 * <li>{@link Long}</li>
 * <li>{@link Double}</li>
 * <li>{@link Float}</li>
 * <li>{@link BigDecimal}</li>
 * <li>{@link BigInteger}</li>
 * </ul>
 * </li>
 * <li>Date/Time
 * <ul>
 * <li>{@link Instant}</li>
 * <li>{@link LocalDate}</li>
 * <li>{@link LocalDateTime}</li>
 * <li>{@link LocalTime}</li>
 * <li>{@link OffsetDateTime}</li>
 * <li>{@link OffsetTime}</li>
 * <li>{@link Year}</li>
 * <li>{@link YearMonth}</li>
 * <li>{@link ZonedDateTime}</li>
 * <li>{@link Date}</li>
 * <li>{@link Calendar}</li>
 * </ul>
 * </li>
 * </ul>
 * Additional serializers can be registered through the
 * {@link ValueSerializeProvider} API
 *
 * If you need to serialize deeper object graphs the {@link ObjectSerializer}
 * should be used
 * 
 * @since 2.2.0
 */
public interface ValueSerializer extends Predicate<Class<?>> {
	/**
	 * Create a value instance from a string
	 * 
	 * @param <O>
	 *            the value type
	 * @param clazz
	 *            the type the new instance
	 * @param value
	 *            the string representation
	 * @return the new instance
	 */
	public <O> @NonNull O fromString(@NonNull Class<O> clazz, @NonNull String value);

	/**
	 * Serialize the instance to a string
	 *
	 * @param o
	 *            the object to serialize
	 * @return the new value
	 */
	public @NonNull String toString(@NonNull Object o);

	/**
	 * Service to provide new serializers
	 *
	 * @param <T>
	 *            the type
	 */
	public interface ValueSerializeProvider<T> {
		/**
		 * @return the type
		 */
		public Class<T> getType();

		/**
		 * Create an instance from the string
		 *
		 * @param value
		 *            the string representation
		 * @return the new instance
		 */
		public @NonNull T fromString(String value);

		/**
		 * Serialize the instance to its string representation
		 *
		 * @param value
		 *            the value
		 * @return the string represention
		 */
		public @NonNull String toString(@NonNull T value);
	}
}
