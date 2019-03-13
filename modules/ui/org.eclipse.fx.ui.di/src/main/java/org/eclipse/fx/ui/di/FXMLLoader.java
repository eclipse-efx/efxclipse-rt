/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import org.eclipse.fx.core.fxml.ExtendedFXMLLoader;

/**
 * Annotation to mark an injection of an {@link FXMLLoaderFactory}
 *
 * Deprecated Use @LocalInstance {@link javafx.fxml.FXMLLoader} instead
 */
@Qualifier
@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface FXMLLoader {
	/**
	 * If set to true the {@link ExtendedFXMLLoader} will be used and
	 * {@link FXMLBuilder#builderFactory(javafx.util.BuilderFactory)} is ignored
	 * @return <code>true</code> to use an extended loader
	 */
	boolean useExtendedLoader() default false;
}
