package org.eclipse.fx.code.editor.ldef.langs.fx.xml;

public class XmlPresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
	public XmlPresentationReconciler() {
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Xml__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __xml_tagDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Xml__xml_tag());
		setDamager(__xml_tagDamageRepairer, "__xml_tag");
		setRepairer(__xml_tagDamageRepairer, "__xml_tag");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __xml_declDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Xml__xml_decl());
		setDamager(__xml_declDamageRepairer, "__xml_decl");
		setRepairer(__xml_declDamageRepairer, "__xml_decl");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __xml_cdataDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Xml__xml_cdata());
		setDamager(__xml_cdataDamageRepairer, "__xml_cdata");
		setRepairer(__xml_cdataDamageRepairer, "__xml_cdata");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __xml_piDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Xml__xml_pi());
		setDamager(__xml_piDamageRepairer, "__xml_pi");
		setRepairer(__xml_piDamageRepairer, "__xml_pi");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __xml_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Xml__xml_comment());
		setDamager(__xml_commentDamageRepairer, "__xml_comment");
		setRepairer(__xml_commentDamageRepairer, "__xml_comment");
	}
}
