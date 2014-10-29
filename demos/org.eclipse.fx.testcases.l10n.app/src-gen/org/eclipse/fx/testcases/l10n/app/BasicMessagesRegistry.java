package org.eclipse.fx.testcases.l10n.app;

import org.eclipse.fx.core.di.text.AbstractMessageRegistry;
import org.eclipse.fx.core.text.Formatter;

import org.eclipse.e4.core.di.annotations.Creatable;

import java.util.function.Supplier;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;

@Creatable
public class BasicMessagesRegistry extends AbstractMessageRegistry<BasicMessages> {




	@Inject
	public void updateMessages(@Translation BasicMessages messages) {
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

	public Supplier<String> BasicDyn_supplier(Object val) {
		return () -> BasicDyn(val);
	}

}
