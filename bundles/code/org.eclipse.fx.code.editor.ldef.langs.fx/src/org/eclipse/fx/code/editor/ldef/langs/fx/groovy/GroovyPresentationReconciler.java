package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class GroovyPresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
	public GroovyPresentationReconciler() {
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Groovy__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __groovy_apidocDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Groovy__groovy_apidoc());
		setDamager(__groovy_apidocDamageRepairer, "__groovy_apidoc");
		setRepairer(__groovy_apidocDamageRepairer, "__groovy_apidoc");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __groovy_characterDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Groovy__groovy_character());
		setDamager(__groovy_characterDamageRepairer, "__groovy_character");
		setRepairer(__groovy_characterDamageRepairer, "__groovy_character");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __groovy_stringDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Groovy__groovy_string());
		setDamager(__groovy_stringDamageRepairer, "__groovy_string");
		setRepairer(__groovy_stringDamageRepairer, "__groovy_string");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __groovy_multiline_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Groovy__groovy_multiline_comment());
		setDamager(__groovy_multiline_commentDamageRepairer, "__groovy_multiline_comment");
		setRepairer(__groovy_multiline_commentDamageRepairer, "__groovy_multiline_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __groovy_singleline_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Groovy__groovy_singleline_comment());
		setDamager(__groovy_singleline_commentDamageRepairer, "__groovy_singleline_comment");
		setRepairer(__groovy_singleline_commentDamageRepairer, "__groovy_singleline_comment");
	}
}
