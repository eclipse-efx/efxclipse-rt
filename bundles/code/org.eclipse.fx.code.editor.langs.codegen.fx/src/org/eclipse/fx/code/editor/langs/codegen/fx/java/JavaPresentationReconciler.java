package org.eclipse.fx.code.editor.langs.codegen.fx.java;

public class JavaPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public JavaPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Java__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __java_multi_line_api_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Java__java_multi_line_api_comment());
		setDamager(__java_multi_line_api_commentDamageRepairer, "__java_multi_line_api_comment");
		setRepairer(__java_multi_line_api_commentDamageRepairer, "__java_multi_line_api_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __java_multi_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Java__java_multi_line_comment());
		setDamager(__java_multi_line_commentDamageRepairer, "__java_multi_line_comment");
		setRepairer(__java_multi_line_commentDamageRepairer, "__java_multi_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __java_single_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Java__java_single_line_comment());
		setDamager(__java_single_line_commentDamageRepairer, "__java_single_line_comment");
		setRepairer(__java_single_line_commentDamageRepairer, "__java_single_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __java_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Java__java_string());
		setDamager(__java_stringDamageRepairer, "__java_string");
		setRepairer(__java_stringDamageRepairer, "__java_string");
	}
}
