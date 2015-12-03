package org.eclipse.fx.code.editor.langs.codegen.fx.ts;

public class TsPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public TsPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ts__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ts_single_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ts__ts_single_line_comment());
		setDamager(__ts_single_line_commentDamageRepairer, "__ts_single_line_comment");
		setRepairer(__ts_single_line_commentDamageRepairer, "__ts_single_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ts_multi_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ts__ts_multi_line_comment());
		setDamager(__ts_multi_line_commentDamageRepairer, "__ts_multi_line_comment");
		setRepairer(__ts_multi_line_commentDamageRepairer, "__ts_multi_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ts_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ts__ts_string());
		setDamager(__ts_stringDamageRepairer, "__ts_string");
		setRepairer(__ts_stringDamageRepairer, "__ts_string");
	}
}
