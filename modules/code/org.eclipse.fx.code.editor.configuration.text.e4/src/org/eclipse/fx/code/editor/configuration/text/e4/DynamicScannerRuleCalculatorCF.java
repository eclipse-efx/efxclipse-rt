/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.configuration.text.e4;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.configuration.text.DynamicScannerRuleCalculator;
import org.eclipse.fx.code.editor.configuration.text.DynamicScannerRuleCalculatorTypeProvider;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;


@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property="service.context.key=org.eclipse.fx.code.editor.configuration.text.DynamicScannerRuleCalculator")
public class DynamicScannerRuleCalculatorCF extends InputBasedContextFunction<DynamicScannerRuleCalculator,DynamicScannerRuleCalculatorTypeProvider> {
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	protected void registerService(DynamicScannerRuleCalculatorTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	@Override
	protected void unregisterService(DynamicScannerRuleCalculatorTypeProvider service) {
		super.unregisterService(service);
	}
}
