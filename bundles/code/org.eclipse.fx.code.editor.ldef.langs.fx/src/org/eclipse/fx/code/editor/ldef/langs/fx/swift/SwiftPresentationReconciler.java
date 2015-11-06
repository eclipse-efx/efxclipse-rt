package org.eclipse.fx.code.editor.ldef.langs.fx.swift;

public class SwiftPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public SwiftPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Swift__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __swift_single_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Swift__swift_single_line_comment());
		setDamager(__swift_single_line_commentDamageRepairer, "__swift_single_line_comment");
		setRepairer(__swift_single_line_commentDamageRepairer, "__swift_single_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __swift_multi_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Swift__swift_multi_line_comment());
		setDamager(__swift_multi_line_commentDamageRepairer, "__swift_multi_line_comment");
		setRepairer(__swift_multi_line_commentDamageRepairer, "__swift_multi_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __swift_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Swift__swift_string());
		setDamager(__swift_stringDamageRepairer, "__swift_string");
		setRepairer(__swift_stringDamageRepairer, "__swift_string");
	}
}
