/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
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
package org.eclipse.fx.osgi.fxloader.jpms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.fx.osgi.fxloader.FXClassloaderConfigurator;
import org.eclipse.fx.osgi.fxloader.jpms.ModuleLayerWrapper.ControllerWrapper;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;
import org.osgi.framework.wiring.BundleWiring;

@SuppressWarnings("javadoc")
public class JavaModuleLayerModification {
	private final Set<AddReads> reads;
	private final Set<AddOpenExports> exports;
	private final Set<AddOpenExports> opens;

	private final Bundle[] bundles;
	
	public JavaModuleLayerModification(Bundle[] bundles, Set<AddReads> reads, Set<AddOpenExports> exports, Set<AddOpenExports> opens) {
		this.bundles = bundles;
		this.reads = reads;
		this.exports = exports;
		this.opens = opens;
	}

	public boolean isEmpty() {
		return this.reads.isEmpty() && this.exports.isEmpty() && this.opens.isEmpty();
	}

	public static JavaModuleLayerModification empty() {
		return new JavaModuleLayerModification(new Bundle[0],Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
	}

	private static ModuleWrapper getUnnamedModule() {
		return new ClassloaderWrapper(JavaModuleLayerModification.class.getClassLoader()).getUnnamedModule();
	}
	
	private ModuleWrapper getBundleUnnamed(String value) {
		if( value.startsWith("BUNDLE(@") ) { //$NON-NLS-1$
			String id = value.substring(8,value.length()-1);
			long l = Long.parseLong(id);
			for( Bundle b : this.bundles ) {
				if( b.getBundleId() == l ) {
					return new ClassloaderWrapper(b.adapt(BundleWiring.class).getClassLoader()).getUnnamedModule();
				}
			}
		} else if( value.startsWith("BUNDLE(") ) { //$NON-NLS-1$
			String nameVersion = value.substring(7, value.length()-1);
			int idx = nameVersion.indexOf('@');
			if( idx > -1 ) {
				String symbolicName = nameVersion.substring(0, idx);
				Version version = Version.parseVersion(nameVersion.substring(idx+1));
				
				for( Bundle b : this.bundles ) {
					if( b.getSymbolicName().equals(symbolicName) && version.equals(b.getVersion()) ) {
						return new ClassloaderWrapper(b.adapt(BundleWiring.class).getClassLoader()).getUnnamedModule();
					}
				}
			}
		}
		return null;
	}

	public void applyConfigurations(ControllerWrapper controller) {
		Map<String, ModuleWrapper> map = new HashMap<>();
		for (AddOpenExports e : this.exports) {
			ModuleWrapper sourceModule = map.computeIfAbsent(e.source,
					n -> controller.layer().findModule(n).orElse(null));
			ModuleWrapper targetModule = null;
			if (e.target.equals("ALL-UNNAMED")) { //$NON-NLS-1$
				targetModule = getUnnamedModule();
			} else if (e.target.startsWith("BUNDLE")) { //$NON-NLS-1$
				targetModule = getBundleUnnamed(e.target);
			} else {
				targetModule = map.computeIfAbsent(e.target, n -> {
					return Stream.of(controller.layer(), ModuleLayerWrapper.boot()) //
							.map(l -> l.findModule(n).orElse(null)) //
							.findFirst().orElse(null);
				});
			}

			if (sourceModule == null) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Source module '" + e.source //$NON-NLS-1$
							+ "' is not dynamically loaded. Could not export '" + e.pn + "'."); //$NON-NLS-1$ //$NON-NLS-2$
				}
			} else if (targetModule == null) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Target module '" + e.target //$NON-NLS-1$
							+ "' is not found. Could not export '" + e.pn + "'."); //$NON-NLS-1$ //$NON-NLS-2$
				}
			} else {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Exporting '"+e+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				controller.addExports(sourceModule, e.pn, targetModule);
			}
		}

		for (AddOpenExports e : this.opens) {
			ModuleWrapper sourceModule = map.computeIfAbsent(e.source,
					n -> controller.layer().findModule(n).orElse(null));
			ModuleWrapper targetModule = null;
			if (e.target.equals("ALL-UNNAMED")) { //$NON-NLS-1$
				targetModule = getUnnamedModule();
			} else if (e.target.startsWith("BUNDLE")) { //$NON-NLS-1$
				targetModule = getBundleUnnamed(e.target);
			} else {
				targetModule = map.computeIfAbsent(e.target, n -> {
					return Stream.of(controller.layer(), ModuleLayerWrapper.boot()) //
							.map(l -> l.findModule(n).orElse(null)) //
							.findFirst().orElse(null);
				});
			}

			if (sourceModule == null) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Source module '" + e.source //$NON-NLS-1$
							+ "' is not dynamically loaded. Could not open '" + e.pn + "'."); //$NON-NLS-1$ //$NON-NLS-2$
				}

			} else if (targetModule == null) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Target module '" + e.target //$NON-NLS-1$
							+ "' is not found. Could not open '" + e.pn + "'."); //$NON-NLS-1$ //$NON-NLS-2$
				}

			} else {
				controller.addOpens(sourceModule, e.pn, targetModule);
			}
		}

		for (AddReads r : this.reads) {
			ModuleWrapper sourceModule = map.computeIfAbsent(r.source,
					n -> controller.layer().findModule(n).orElse(null));
			ModuleWrapper targetModule = null;
			if (r.target.equals("ALL-UNNAMED")) { //$NON-NLS-1$
				targetModule = getUnnamedModule();
			} else if (r.target.startsWith("BUNDLE")) { //$NON-NLS-1$
				targetModule = getBundleUnnamed(r.target);
			} else {
				targetModule = map.computeIfAbsent(r.target, n -> {
					return Stream.of(controller.layer(), ModuleLayerWrapper.boot()) //
							.map(l -> l.findModule(n).orElse(null)) //
							.findFirst().orElse(null);
				});
			}

			if (sourceModule == null) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Source module '" + r.source //$NON-NLS-1$
							+ "' is not dynamically loaded. Could not add read edge."); //$NON-NLS-1$
				}
			} else if (targetModule == null) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("JavaModuleLayerModification#applyConfigurations - Target module '" + r.target //$NON-NLS-1$
							+ "' is not found. Could not add read edge."); //$NON-NLS-1$
				}
			} else {
				controller.addReads(sourceModule, targetModule);
			}
		}
	}
}
