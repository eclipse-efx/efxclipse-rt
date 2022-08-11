/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.base.debug;

import java.io.IOException;
import java.io.Writer;
import java.util.function.Predicate;

import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MGenericStack;
import org.eclipse.e4.ui.model.application.ui.MGenericTile;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.text.TextUtil;

/**
 * Helper API to dump an application model
 */
public class ModelStructureDump {
	/**
	 * Visitor called for each model element
	 */
	public interface Visitor {
		/**
		 * Method called for each model element
		 * 
		 * @param element the element
		 * @param writer  the buffer to write to
		 * @return <code>true</code> if children should be visited
		 * @throws IOException
		 */
		public boolean visit(MApplicationElement element, Writer writer) throws IOException;
	}

	/**
	 * Default dump configurations
	 */
	public enum DefaultConfiguration implements Visitor, Predicate<MApplicationElement> {
		/**
		 * Dump just the basic UI
		 */
		BasicUI(DefaultConfiguration::basicUI_visit, DefaultConfiguration::basicUI_filter);

		private final Visitor visitorDelegate;
		private final Predicate<MApplicationElement> filterDelegate;

		private DefaultConfiguration(Visitor delegate, Predicate<MApplicationElement> filterDelegate) {
			this.visitorDelegate = delegate;
			this.filterDelegate = filterDelegate;
		}

		@Override
		public boolean visit(MApplicationElement element, Writer writer) throws IOException {
			return this.visitorDelegate.visit(element, writer);
		}

		@Override
		public boolean test(MApplicationElement t) {
			return this.filterDelegate.test(t);
		}

		private static boolean basicUI_visit(MApplicationElement element, Writer writer) throws IOException {
			writer.append(((EObject) element).eClass().getName());
			if (element instanceof MUILabel) {
				writer.append(" - " + ((MUILabel) element).getLocalizedLabel()); //$NON-NLS-1$
			}
			if (element instanceof MUIElement && ((MUIElement) element).getContainerData() != null
					&& !((MUIElement) element).getContainerData().isEmpty()) {
				writer.append(": " + ((MUIElement) element).getContainerData()); //$NON-NLS-1$
			}
			return element instanceof MElementContainer<?>;
		}

		private static boolean basicUI_filter(MApplicationElement element) {
			return element instanceof MPartSashContainerElement || element instanceof MStackElement
					|| element instanceof MWindow || element instanceof MGenericStack<?>
					|| element instanceof MGenericTile<?> || element instanceof MPerspective;
		}
	}

	/**
	 * Dump the element
	 * 
	 * @param element              the element
	 * @param writer               the writer
	 * @param defaultConfiguration the configuration
	 * @throws IOException
	 */
	public static void dump(MApplicationElement element, Writer writer, DefaultConfiguration defaultConfiguration)
			throws IOException {
		dump(element, writer, defaultConfiguration, defaultConfiguration);
	}

	/**
	 * Dump the element
	 * 
	 * @param element       the element
	 * @param writer        the writer
	 * @param visitor       the visitor to use
	 * @param contentFilter the content filter
	 * @throws IOException
	 */
	public static void dump(MApplicationElement element, Writer writer, Visitor visitor,
			Predicate<MApplicationElement> contentFilter) throws IOException {
		dump(0, element, writer, visitor, contentFilter);
	}

	private static void dump(int nestLevel, MApplicationElement element, Writer writer, Visitor visitor,
			Predicate<MApplicationElement> contentFilter) throws IOException {
		writer.append(TextUtil.createRepeatedString(' ', nestLevel * 4) + " + "); //$NON-NLS-1$
		boolean proceed = visitor.visit(element, writer);
		writer.append('\n');
		if (proceed) {
			EList<EObject> eContents = ((EObject) element).eContents();
			for (EObject eo : eContents) {
				if (eo instanceof MApplicationElement && contentFilter.test((MApplicationElement) eo)) {
					dump(nestLevel + 1, (MApplicationElement) eo, writer, visitor, contentFilter);
				}
			}
		}
	}
}
