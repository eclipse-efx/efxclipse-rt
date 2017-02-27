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
package org.eclipse.fx.core.internal;

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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.fx.core.RankedService;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.ValueSerializer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Default implementation
 */
@Component
public class DefaultValueSerializer implements ValueSerializer, RankedService {
	private final Map<Class<?>, TwoVal<?>> mappings = new HashMap<>();

	static class TwoVal<T> {
		@Nullable
		final Object owner;
		@NonNull
		final Function<@NonNull String, @NonNull T> fromString;
		@NonNull
		final Function<@NonNull T, @NonNull String> toString;

		public TwoVal(@NonNull Function<@NonNull String, @NonNull T> fromString,
				@NonNull Function<@NonNull T, @NonNull String> toString) {
			this(null, fromString, toString);
		}

		public TwoVal(Object owner, @NonNull Function<@NonNull String, @NonNull T> fromString,
				@NonNull Function<@NonNull T, @NonNull String> toString) {
			this.owner = owner;
			this.fromString = fromString;
			this.toString = toString;
		}
	}

	/**
	 * Create a new instance
	 */
	@SuppressWarnings({ "null", "unchecked" })
	public DefaultValueSerializer() {
		this.mappings.put(Instant.class, new TwoVal<>(Instant::parse, (v) -> v.toString()));

		this.mappings.put(LocalDate.class, new TwoVal<>(LocalDate::parse, (v) -> v.toString()));
		this.mappings.put(LocalDateTime.class, new TwoVal<>(LocalDateTime::parse, (v) -> v.toString()));
		this.mappings.put(LocalTime.class, new TwoVal<>(LocalTime::parse, (v) -> v.toString()));

		this.mappings.put(OffsetDateTime.class, new TwoVal<>(OffsetDateTime::parse, (v) -> v.toString()));
		this.mappings.put(OffsetTime.class, new TwoVal<>(OffsetTime::parse, (v) -> v.toString()));

		this.mappings.put(Year.class, new TwoVal<>(Year::parse, (v) -> v.toString()));
		this.mappings.put(YearMonth.class, new TwoVal<>(YearMonth::parse, (v) -> v.toString()));

		this.mappings.put(ZonedDateTime.class, new TwoVal<>(ZonedDateTime::parse, (v) -> v.toString()));

		this.mappings.put(Boolean.class, new TwoVal<>(Boolean::valueOf, (v) -> v.toString()));
		this.mappings.put(boolean.class, new TwoVal<>(Boolean::valueOf, (v) -> v.toString()));

		this.mappings.put(Short.class, new TwoVal<>(Short::valueOf, (v) -> v.toString()));
		this.mappings.put(short.class, new TwoVal<>(Short::valueOf, (v) -> v.toString()));

		this.mappings.put(Integer.class, new TwoVal<>(Integer::valueOf, (v) -> v.toString()));
		this.mappings.put(int.class, new TwoVal<>(Integer::valueOf, (v) -> v.toString()));

		this.mappings.put(Long.class, new TwoVal<>(Long::valueOf, (v) -> v.toString()));
		this.mappings.put(long.class, new TwoVal<>(Long::valueOf, (v) -> v.toString()));

		this.mappings.put(Double.class, new TwoVal<>(Double::valueOf, (v) -> v.toString()));
		this.mappings.put(double.class, new TwoVal<>(Double::valueOf, (v) -> v.toString()));

		this.mappings.put(Float.class, new TwoVal<>(Float::valueOf, (v) -> v.toString()));
		this.mappings.put(float.class, new TwoVal<>(Float::valueOf, (v) -> v.toString()));

		this.mappings.put(BigDecimal.class, new TwoVal<>(BigDecimal::new, (v) -> v.toString()));
		this.mappings.put(BigInteger.class, new TwoVal<>(BigInteger::new, (v) -> v.toString()));

		this.mappings.put(Date.class, new TwoVal<>(s -> Date.from(Instant.parse(s)), (v) -> v.toInstant().toString()));
		this.mappings.put(Calendar.class, new TwoVal<>(s -> {
			Calendar.Builder b = new Calendar.Builder();
			b.setInstant(Date.from(Instant.parse(s)));
			return b.build();
		} , (v) -> v.toInstant().toString()));
		if (!Util.isOsgiEnv()) {
			Map<Class<?>, TwoVal<?>> collect = Util.lookupServiceList(ValueSerializeProvider.class).stream()
					.collect(Collectors.toMap(p -> p.getType(), p -> new TwoVal<>(p::fromString, p::toString)));
			this.mappings.putAll(collect);
		}
	}

	@Override
	public int getRanking() {
		return 0;
	}

	/**
	 * Register a provider
	 *
	 * @param p
	 *            the provider
	 */
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policyOption = ReferencePolicyOption.GREEDY)
	public <T> void registerProvider(ValueSerializeProvider<T> p) {
		this.mappings.put(p.getType(), new TwoVal<>(p, p::fromString, p::toString));
	}

	/**
	 * Unregister a provider
	 *
	 * @param p
	 *            the provider
	 */
	public void unregisterProvider(ValueSerializeProvider<?> p) {
		TwoVal<?> val = this.mappings.remove(p.getType());
		if (val != null && val.owner != p) {
			this.mappings.remove(p.getType(), val);
		}
	}

	@Override
	public boolean test(Class<?> t) {
		return this.mappings.containsKey(t);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <O> O fromString(Class<O> clazz, String value) {
		if (!test(clazz)) {
			throw new IllegalArgumentException("The type '" + clazz + "' is not supported"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return (O) this.mappings.get(clazz).fromString.apply(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString(Object o) {
		Function<?, String> toString = this.mappings.get(o.getClass()).toString;
		return ((Function<@NonNull Object, @NonNull String>) toString).apply(o);
	}

}
