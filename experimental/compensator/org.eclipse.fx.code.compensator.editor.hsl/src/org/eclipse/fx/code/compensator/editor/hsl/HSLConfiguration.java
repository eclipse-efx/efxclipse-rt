/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor.hsl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;

import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.hsl.internal.HSLComponent;
import org.eclipse.fx.code.compensator.editor.hsl.internal.JavaScriptHelper;
import org.eclipse.fx.code.compensator.hsl.hSL.Damager;
import org.eclipse.fx.code.compensator.hsl.hSL.JSDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class HSLConfiguration extends SourceViewerConfiguration {
	private Model model;
	private ClassLoader cl;

	private final HSLComponent component;

	@Inject
	public HSLConfiguration(HSLComponent component, Input<?> input) {
		this.component = component;
		this.cl = getClass().getClassLoader();
		this.model = component.getModelForInput(input);
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		for( Damager sc : model.getDamagers() ) {
			if( sc instanceof RuleDamager ) {
				RuleDamager rs = (RuleDamager) sc;
				HSLRuleScanner s = new HSLRuleScanner(rs);
				DefaultDamagerRepairer dr = new DefaultDamagerRepairer(s);
				reconciler.setDamager(dr, rs.getPartition().getName());
				reconciler.setRepairer(dr, rs.getPartition().getName());
			} else {
				JSDamager js = (JSDamager) sc;
				Object o = JavaScriptHelper.loadScript(cl, js, js.getFileURI());
				reconciler.setDamager((IPresentationDamager) o, js.getPartition().getName());
				reconciler.setRepairer((IPresentationRepairer) o, js.getPartition().getName());
			}
		}

		return reconciler;
	}

	@Override
	public void setThemeId(String themeId) {
		super.setThemeId(themeId);
		URL url = _getDefaultStylesheet(themeId);
		// ensure initialized!!!
		getDefaultStylesheet();
		if( url != null ) {
			defaultStylesheet.set(url);
		} else {
			defaultStylesheet.set(_getDefaultStylesheet(null));
		}
	}

	private ReadOnlyObjectWrapper<URL> defaultStylesheet;

	@Override
	public ReadOnlyProperty<URL> getDefaultStylesheet() {
		if( defaultStylesheet == null ) {
			defaultStylesheet = new ReadOnlyObjectWrapper<>(this, "defaultStylesheet", _getDefaultStylesheet(null));
		}
		return defaultStylesheet.getReadOnlyProperty();
	}

	private URL _getDefaultStylesheet(String themeId) {
		URI uri = model.eResource().getURI();
		uri = uri.trimSegments(1);
		uri = uri.appendSegment(model.getName()+(themeId != null ? "-"+themeId : "")+"-highlight.css");

		if( uri.isPlatform() ) {
			System.err.println(cl.getResource(getPluginPath(uri)));
			return cl.getResource(getPluginPath(uri));
		} else {
			try {
				return new File(uri.toFileString()).toURI().toURL();
			} catch (MalformedURLException e) {
				return null;
			}
		}
	}

	private static String getPluginPath(URI uri) {
		String[] parts = uri.segments();
		StringBuffer b = new StringBuffer(parts[2]);

		for( int i = 3; i < parts.length; i++ ) {
			b.append("/" + parts[i]);
		}
		return b.toString();
	}
}
