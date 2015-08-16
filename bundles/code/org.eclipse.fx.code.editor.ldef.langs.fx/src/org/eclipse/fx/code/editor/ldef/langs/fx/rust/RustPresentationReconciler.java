package org.eclipse.fx.code.editor.ldef.langs.fx.rust;

public class RustPresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
	public RustPresentationReconciler() {
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Rust__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __rust_single_line_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Rust__rust_single_line_comment());
		setDamager(__rust_single_line_commentDamageRepairer, "__rust_single_line_comment");
		setRepairer(__rust_single_line_commentDamageRepairer, "__rust_single_line_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __rust_multi_line_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Rust__rust_multi_line_comment());
		setDamager(__rust_multi_line_commentDamageRepairer, "__rust_multi_line_comment");
		setRepairer(__rust_multi_line_commentDamageRepairer, "__rust_multi_line_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __rust_stringDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Rust__rust_string());
		setDamager(__rust_stringDamageRepairer, "__rust_string");
		setRepairer(__rust_stringDamageRepairer, "__rust_string");
	}
}
