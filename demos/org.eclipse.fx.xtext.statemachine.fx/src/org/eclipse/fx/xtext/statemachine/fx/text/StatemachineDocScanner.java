package org.eclipse.fx.xtext.statemachine.fx.text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

public class StatemachineDocScanner extends RuleBasedScanner {
	public StatemachineDocScanner() {
		setDefaultReturnToken(new Token(new TextAttribute("state_doc_default")));
	}
}
