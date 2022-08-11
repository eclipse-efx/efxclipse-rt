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
package org.eclipse.fx.testcases.l10n.app;

/*
 * Do not modify - Auto generated from Message.l10n
 */
@org.eclipse.e4.core.di.annotations.Creatable
public class SamplePartMessagesRegistry extends org.eclipse.fx.core.text.AbstractTextRegistry<SamplePartMessages> {
	@javax.inject.Inject
	private org.eclipse.fx.core.text.NumberFormatter _number;

	@javax.inject.Inject
	private org.eclipse.fx.core.text.DateFormatter _date;


	@javax.inject.Inject
	private org.eclipse.fx.testcases.l10n.app.MyFormatter cust_myformatter;

	@javax.inject.Inject
	private org.eclipse.fx.testcases.l10n.app.BasicMessagesRegistry bundle_BasicMessages;

	@javax.inject.Inject
	public void updateMessages(@org.eclipse.e4.core.services.nls.Translation SamplePartMessages messages) {
		super.updateMessages(messages);
	}

	public java.util.function.Supplier<String> getSupplierByKey(String key, Object... values) {
		switch(key) {
		case "SimpleText":
		return this::SimpleText;
		case "SimpleDateText":
		return SimpleDateText_supplier((java.util.Date) values[0]);
		case "SimpleNumberText":
		return SimpleNumberText_supplier((Number) values[0]);
		case "CustFormatText":
		return CustFormatText_supplier((Number) values[0]);
		case "ReferenceText":
		return this::ReferenceText;
		case "ReferenceDyn":
		return ReferenceDyn_supplier((Object) values[0]);
		}
		throw new IllegalArgumentException("Key '"+key+"' is unknown");
	}

	public String SimpleText() {
		return getMessages().SimpleText;
	}


	public String SimpleDateText() {
		return getMessages().SimpleDateText;
	}

	public String SimpleDateText(java.util.Date now) {
		java.util.Map<String,Object> dataMap = new java.util.HashMap<>();
		dataMap.put("now",now);
		java.util.Map<String,org.eclipse.fx.core.text.Formatter<?>> formatterMap = new java.util.HashMap<>();
		formatterMap.put("-date",_date);
		return org.eclipse.fx.core.text.MessageFormatter.create(dataMap::get,formatterMap::get).apply( SimpleDateText() );
	}

	public java.util.function.Supplier<String> SimpleDateText_supplier(java.util.Date now) {
		return () -> SimpleDateText(now);
	}

	public String SimpleNumberText() {
		return getMessages().SimpleNumberText;
	}

	public String SimpleNumberText(Number val) {
		java.util.Map<String,Object> dataMap = new java.util.HashMap<>();
		dataMap.put("val",val);
		java.util.Map<String,org.eclipse.fx.core.text.Formatter<?>> formatterMap = new java.util.HashMap<>();
		formatterMap.put("-number",_number);
		return org.eclipse.fx.core.text.MessageFormatter.create(dataMap::get,formatterMap::get).apply( SimpleNumberText() );
	}

	public java.util.function.Supplier<String> SimpleNumberText_supplier(Number val) {
		return () -> SimpleNumberText(val);
	}

	public String CustFormatText() {
		return getMessages().CustFormatText;
	}

	public String CustFormatText(Number val) {
		java.util.Map<String,Object> dataMap = new java.util.HashMap<>();
		dataMap.put("val",val);
		java.util.Map<String,org.eclipse.fx.core.text.Formatter<?>> formatterMap = new java.util.HashMap<>();
		formatterMap.put("myformatter",cust_myformatter);
		return org.eclipse.fx.core.text.MessageFormatter.create(dataMap::get,formatterMap::get).apply( CustFormatText() );
	}

	public java.util.function.Supplier<String> CustFormatText_supplier(Number val) {
		return () -> CustFormatText(val);
	}

	public String ReferenceText() {
		return bundle_BasicMessages.BasicYes();
	}


	public String ReferenceDyn() {
		return bundle_BasicMessages.BasicDyn();
	}

	public String ReferenceDyn(Object val) {
		return bundle_BasicMessages.BasicDyn(val);
	}

	public java.util.function.Supplier<String> ReferenceDyn_supplier(Object val) {
		return () -> ReferenceDyn(val);
	}


}
