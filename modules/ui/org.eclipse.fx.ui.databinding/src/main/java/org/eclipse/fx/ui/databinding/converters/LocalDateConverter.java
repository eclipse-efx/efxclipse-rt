/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.converters;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Convert a JDK8 between {@link LocalDate} and a {@link Date}
 */
public abstract class LocalDateConverter extends Converter {

	LocalDateConverter(@NonNull Object fromType, @NonNull Object toType) {
		super(fromType, toType);
	}

	/**
	 * @return create a {@link Date} to {@link LocalDate} converter
	 */
	public static LocalDateConverter fromDateToLocalDate() {
		return new LocalDateConverter(Date.class, LocalDate.class) {

			@Override
			public Object convert(Object fromObject) {
				if (fromObject == null) {
					return null;
				}
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime((Date) fromObject);
				ZonedDateTime zdt = cal.toZonedDateTime();
				return zdt.toLocalDateTime().toLocalDate();
			}
		};
	}

	/**
	 * @return create a {@link LocalDate} to {@link Date} converter
	 */
	public static LocalDateConverter fromLocalDateTotoDate() {
		return new LocalDateConverter(LocalDate.class, Date.class) {

			@Override
			public Object convert(Object fromObject) {
				if (fromObject == null) {
					return null;
				}
				return GregorianCalendar.from(
						((LocalDate) fromObject).atStartOfDay(ZoneId
								.systemDefault())).getTime();
			}
		};
	}
}
