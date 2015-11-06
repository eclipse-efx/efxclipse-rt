package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class AdocPresentationReconciler extends org.eclipse.fx.text.ui.presentation.PresentationReconciler {
	public AdocPresentationReconciler() {
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Adoc__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __adoc_multiline_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Adoc__adoc_multiline_comment());
		setDamager(__adoc_multiline_commentDamageRepairer, "__adoc_multiline_comment");
		setRepairer(__adoc_multiline_commentDamageRepairer, "__adoc_multiline_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __adoc_singleline_commentDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Adoc__adoc_singleline_comment());
		setDamager(__adoc_singleline_commentDamageRepairer, "__adoc_singleline_comment");
		setRepairer(__adoc_singleline_commentDamageRepairer, "__adoc_singleline_comment");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __adoc_literal_blockDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Adoc__adoc_literal_block());
		setDamager(__adoc_literal_blockDamageRepairer, "__adoc_literal_block");
		setRepairer(__adoc_literal_blockDamageRepairer, "__adoc_literal_block");
		org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer __adoc_multiline_codeDamageRepairer = new org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer(new Adoc__adoc_multiline_code());
		setDamager(__adoc_multiline_codeDamageRepairer, "__adoc_multiline_code");
		setRepairer(__adoc_multiline_codeDamageRepairer, "__adoc_multiline_code");
	}
}
