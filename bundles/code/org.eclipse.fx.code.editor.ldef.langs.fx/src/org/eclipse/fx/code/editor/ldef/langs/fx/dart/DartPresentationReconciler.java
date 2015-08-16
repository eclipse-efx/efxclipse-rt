package org.eclipse.fx.code.editor.ldef.langs.fx.dart;

public class DartPresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
	public DartPresentationReconciler() {
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Dart__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dart_singlelinedoc_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Dart__dart_singlelinedoc_comment());
		setDamager(__dart_singlelinedoc_commentDamageRepairer, "__dart_singlelinedoc_comment");
		setRepairer(__dart_singlelinedoc_commentDamageRepairer, "__dart_singlelinedoc_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dart_multilinedoc_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Dart__dart_multilinedoc_comment());
		setDamager(__dart_multilinedoc_commentDamageRepairer, "__dart_multilinedoc_comment");
		setRepairer(__dart_multilinedoc_commentDamageRepairer, "__dart_multilinedoc_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dart_singleline_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Dart__dart_singleline_comment());
		setDamager(__dart_singleline_commentDamageRepairer, "__dart_singleline_comment");
		setRepairer(__dart_singleline_commentDamageRepairer, "__dart_singleline_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dart_multiline_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Dart__dart_multiline_comment());
		setDamager(__dart_multiline_commentDamageRepairer, "__dart_multiline_comment");
		setRepairer(__dart_multiline_commentDamageRepairer, "__dart_multiline_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dart_stringDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Dart__dart_string());
		setDamager(__dart_stringDamageRepairer, "__dart_string");
		setRepairer(__dart_stringDamageRepairer, "__dart_string");
	}
}
