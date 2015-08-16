package org.eclipse.fx.code.editor.ldef.langs.fx.js;

public class JsPresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
	public JsPresentationReconciler() {
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Js__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __js_single_line_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Js__js_single_line_comment());
		setDamager(__js_single_line_commentDamageRepairer, "__js_single_line_comment");
		setRepairer(__js_single_line_commentDamageRepairer, "__js_single_line_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __js_multi_line_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Js__js_multi_line_comment());
		setDamager(__js_multi_line_commentDamageRepairer, "__js_multi_line_comment");
		setRepairer(__js_multi_line_commentDamageRepairer, "__js_multi_line_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __js_stringDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Js__js_string());
		setDamager(__js_stringDamageRepairer, "__js_string");
		setRepairer(__js_stringDamageRepairer, "__js_string");
	}
}
