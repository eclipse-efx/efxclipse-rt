package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class PyPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public PyPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Py__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __python_multiline_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Py__python_multiline_comment());
		setDamager(__python_multiline_commentDamageRepairer, "__python_multiline_comment");
		setRepairer(__python_multiline_commentDamageRepairer, "__python_multiline_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __python_singleline_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Py__python_singleline_comment());
		setDamager(__python_singleline_commentDamageRepairer, "__python_singleline_comment");
		setRepairer(__python_singleline_commentDamageRepairer, "__python_singleline_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __python_stringDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Py__python_string());
		setDamager(__python_stringDamageRepairer, "__python_string");
		setRepairer(__python_stringDamageRepairer, "__python_string");
	}
}
