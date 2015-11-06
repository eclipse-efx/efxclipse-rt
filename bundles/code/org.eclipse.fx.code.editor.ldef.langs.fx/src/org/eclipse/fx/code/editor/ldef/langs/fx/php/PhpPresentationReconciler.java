package org.eclipse.fx.code.editor.ldef.langs.fx.php;

public class PhpPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public PhpPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Php__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __php_multiline_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Php__php_multiline_comment());
		setDamager(__php_multiline_commentDamageRepairer, "__php_multiline_comment");
		setRepairer(__php_multiline_commentDamageRepairer, "__php_multiline_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __php_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Php__php_string());
		setDamager(__php_stringDamageRepairer, "__php_string");
		setRepairer(__php_stringDamageRepairer, "__php_string");
	}
}
