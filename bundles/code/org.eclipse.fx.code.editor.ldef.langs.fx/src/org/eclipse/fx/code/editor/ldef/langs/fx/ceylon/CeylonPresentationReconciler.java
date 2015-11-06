package org.eclipse.fx.code.editor.ldef.langs.fx.ceylon;

public class CeylonPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public CeylonPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ceylon__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ceylon_multi_line_api_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ceylon__ceylon_multi_line_api_comment());
		setDamager(__ceylon_multi_line_api_commentDamageRepairer, "__ceylon_multi_line_api_comment");
		setRepairer(__ceylon_multi_line_api_commentDamageRepairer, "__ceylon_multi_line_api_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ceylon_single_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ceylon__ceylon_single_line_comment());
		setDamager(__ceylon_single_line_commentDamageRepairer, "__ceylon_single_line_comment");
		setRepairer(__ceylon_single_line_commentDamageRepairer, "__ceylon_single_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ceylon_multi_line_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ceylon__ceylon_multi_line_comment());
		setDamager(__ceylon_multi_line_commentDamageRepairer, "__ceylon_multi_line_comment");
		setRepairer(__ceylon_multi_line_commentDamageRepairer, "__ceylon_multi_line_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __ceylon_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Ceylon__ceylon_string());
		setDamager(__ceylon_stringDamageRepairer, "__ceylon_string");
		setRepairer(__ceylon_stringDamageRepairer, "__ceylon_string");
	}
}
