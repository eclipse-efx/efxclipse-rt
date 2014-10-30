package org.eclipse.fx.testcases.l10n.app;

/*
 * Do not modify - Auto generated from Message.l10n
 */
@org.eclipse.e4.core.di.annotations.Creatable
public class BasicMessagesRegistry extends org.eclipse.fx.core.di.text.AbstractMessageRegistry<BasicMessages> {





	@javax.inject.Inject
	public void updateMessages(@org.eclipse.e4.core.services.nls.Translation BasicMessages messages) {
		super.updateMessages(messages);
	}

	public String BasicYes() {
		return getMessages().BasicYes;
	}


	public String BasicDyn() {
		return getMessages().BasicDyn;
	}

	public String BasicDyn(Object val) {
		java.util.Map<String,Object> dataMap = new java.util.HashMap<>();
		dataMap.put("val",val);
		return org.apache.commons.lang.text.StrSubstitutor.replace( BasicDyn(), dataMap);
	}

	public java.util.function.Supplier<String> BasicDyn_supplier(Object val) {
		return () -> BasicDyn(val);
	}

}
