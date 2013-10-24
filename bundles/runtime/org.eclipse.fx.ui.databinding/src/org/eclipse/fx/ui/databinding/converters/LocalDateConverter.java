package org.eclipse.fx.ui.databinding.converters;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.core.databinding.conversion.Converter;

public abstract class LocalDateConverter extends Converter {

	public LocalDateConverter(Object fromType, Object toType) {
		super(fromType, toType);
	}

	public static LocalDateConverter fromDateToLocalDate() {
		return new LocalDateConverter(Date.class,LocalDate.class) {
			
			@Override
			public Object convert(Object fromObject) {
				if( fromObject == null ) {
					return null;
				}
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime((Date) fromObject);
				ZonedDateTime zdt = cal.toZonedDateTime();
				return zdt.toLocalDateTime().toLocalDate();
			}
		};
	}
	
	public static LocalDateConverter fromLocalDateTotoDate() {
		return new LocalDateConverter(LocalDate.class,Date.class) {
			
			@Override
			public Object convert(Object fromObject) {
				if( fromObject == null ) {
					return null;
				}
				return GregorianCalendar.from(((LocalDate)fromObject).atStartOfDay(ZoneId.systemDefault())).getTime();
			}
		};
	}
}
