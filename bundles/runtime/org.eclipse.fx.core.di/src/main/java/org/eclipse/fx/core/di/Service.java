/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import org.eclipse.fx.core.observable.ValueObservable.OString;

/**
 * Annotation to use with DI to support dynamics and multiple services
 *
 * @since 1.2
 */
@Qualifier
@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
	/**
	 * @return <code>true</code> to track dynamics e.g. in OSGi where services
	 *         can come and go
	 */
	boolean dynamic() default true;

	/**
	 * @return ldap filter expression
	 * @since 3.0.0
	 */
	String filterExpression() default "";

	/**
	 * @return class providing a dynamic filter expression
	 * @since 3.0.0
	 */
	Class<? extends OString> dynamicFilterExpression() default OString.class;
}
