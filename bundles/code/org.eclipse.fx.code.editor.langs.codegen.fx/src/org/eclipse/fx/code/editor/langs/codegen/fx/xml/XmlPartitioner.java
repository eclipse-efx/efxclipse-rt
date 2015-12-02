package org.eclipse.fx.code.editor.langs.codegen.fx.xml;

public class XmlPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public XmlPartitioner() {
		super(new XmlPartitionScanner(), new String[] {
			"__xml_decl","__xml_cdata","__xml_pi","__xml_comment","__xml_tag"
		});
	}
}
