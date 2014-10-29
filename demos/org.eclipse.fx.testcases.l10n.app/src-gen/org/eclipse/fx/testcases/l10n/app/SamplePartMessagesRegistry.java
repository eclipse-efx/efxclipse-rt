package org.eclipse.fx.testcases.l10n.app;

import org.eclipse.fx.core.di.text.AbstractMessageRegistry;
import org.eclipse.fx.core.text.Formatter;

import org.eclipse.e4.core.di.annotations.Creatable;

import java.util.function.Supplier;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;

@Creatable
public class SamplePartMessagesRegistry extends AbstractMessageRegistry<SamplePartMessages> {
	@Inject
	private org.eclipse.fx.core.di.text.NumberFormatter _number;

	@Inject
	private org.eclipse.fx.core.di.text.DateFormatter _date;

	@Inject
	private org.eclipse.fx.testcases.l10n.app.MyFormatter cust_myformatter;

	@Inject
	private org.eclipse.fx.testcases.l10n.app.BasicMessagesRegistry bundle_BasicMessages;

	@Inject
	public void updateMessages(@Translation SamplePartMessages messages) {
		super.updateMessages(messages);
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
		java.util.Map<String,Formatter<?>> formatterMap = new java.util.HashMap<>();
		formatterMap.put("-date",_date);
		return org.eclipse.fx.core.text.MessageFormatter.create(dataMap::get,formatterMap::get).apply( SimpleDateText() );
	}

	public Supplier<String> SimpleDateText_supplier(java.util.Date now) {
		return () -> SimpleDateText(now);
	}

	public String SimpleNumberText() {
		return getMessages().SimpleNumberText;
	}

	public String SimpleNumberText(Number val) {
		java.util.Map<String,Object> dataMap = new java.util.HashMap<>();
		dataMap.put("val",val);
		java.util.Map<String,Formatter<?>> formatterMap = new java.util.HashMap<>();
		formatterMap.put("-number",_number);
		return org.eclipse.fx.core.text.MessageFormatter.create(dataMap::get,formatterMap::get).apply( SimpleNumberText() );
	}

	public Supplier<String> SimpleNumberText_supplier(Number val) {
		return () -> SimpleNumberText(val);
	}

	public String CustFormatText() {
		return getMessages().CustFormatText;
	}

	public String CustFormatText(Number val) {
		java.util.Map<String,Object> dataMap = new java.util.HashMap<>();
		dataMap.put("val",val);
		java.util.Map<String,Formatter<?>> formatterMap = new java.util.HashMap<>();
		formatterMap.put("myformatter",cust_myformatter);
		return org.eclipse.fx.core.text.MessageFormatter.create(dataMap::get,formatterMap::get).apply( CustFormatText() );
	}

	public Supplier<String> CustFormatText_supplier(Number val) {
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

	public Supplier<String> ReferenceDyn_supplier(Object val) {
		return () -> ReferenceDyn(val);
	}

}
