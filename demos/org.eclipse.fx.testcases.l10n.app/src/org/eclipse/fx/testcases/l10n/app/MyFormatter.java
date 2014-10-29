package org.eclipse.fx.testcases.l10n.app;

import java.text.DecimalFormat;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.fx.core.text.Formatter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

@Creatable
public class MyFormatter implements Formatter<Object> {

	@Override
	public @NonNull String format(@Nullable Object object,
			@NonNull String format) {
		return object == null ? "-" : new DecimalFormat(format).format(object);
	}

}
