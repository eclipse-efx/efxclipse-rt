package org.eclipse.fx.code.editor.ldef.langs.fx.ceylon;

public class CeylonPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public CeylonPartitioner() {
		super(new CeylonPartitionScanner(), new String[] {
			"__ceylon_multi_line_api_comment","__ceylon_single_line_comment","__ceylon_multi_line_comment","__ceylon_string"
		});
	}
}
