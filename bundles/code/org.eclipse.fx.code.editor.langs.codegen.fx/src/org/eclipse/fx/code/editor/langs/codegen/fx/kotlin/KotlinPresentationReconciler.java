package org.eclipse.fx.code.editor.langs.codegen.fx.kotlin;

public class KotlinPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public KotlinPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Kotlin__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __kotlin_multi_line_api_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Kotlin__kotlin_multi_line_api_comment());
		setDamager(__kotlin_multi_line_api_commentDamageRepairer, "__kotlin_multi_line_api_comment");
		setRepairer(__kotlin_multi_line_api_commentDamageRepairer, "__kotlin_multi_line_api_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __kotlin_single_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Kotlin__kotlin_single_line_comment());
		setDamager(__kotlin_single_line_commentDamageRepairer, "__kotlin_single_line_comment");
		setRepairer(__kotlin_single_line_commentDamageRepairer, "__kotlin_single_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __kotlin_multi_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Kotlin__kotlin_multi_line_comment());
		setDamager(__kotlin_multi_line_commentDamageRepairer, "__kotlin_multi_line_comment");
		setRepairer(__kotlin_multi_line_commentDamageRepairer, "__kotlin_multi_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __kotlin_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Kotlin__kotlin_string());
		setDamager(__kotlin_stringDamageRepairer, "__kotlin_string");
		setRepairer(__kotlin_stringDamageRepairer, "__kotlin_string");
	}
}
