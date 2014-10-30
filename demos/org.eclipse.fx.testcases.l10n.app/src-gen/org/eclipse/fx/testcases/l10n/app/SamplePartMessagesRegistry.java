package org.eclipse.fx.testcases.l10n.app;

/*
 * Do not modify - Auto generated from Message.l10n
 */
@org.eclipse.e4.core.di.annotations.Creatable
public class SamplePartMessagesRegistry extends org.eclipse.fx.core.di.text.AbstractMessageRegistry<SamplePartMessages> {
	@javax.inject.Inject
	private org.eclipse.fx.core.di.text.NumberFormatter _number;

	@javax.inject.Inject
	private org.eclipse.fx.core.di.text.DateFormatter _date;


	@javax.inject.Inject
	private org.eclipse.fx.testcases.l10n.app.MyFormatter cust_myformatter;

	@javax.inject.Inject
	private org.eclipse.fx.testcases.l10n.app.BasicMessagesRegistry bundle_BasicMessages;

	@javax.inject.Inject
	public void updateMessages(@org.eclipse.e4.core.services.nls.Translation SamplePartMessages messages) {
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
