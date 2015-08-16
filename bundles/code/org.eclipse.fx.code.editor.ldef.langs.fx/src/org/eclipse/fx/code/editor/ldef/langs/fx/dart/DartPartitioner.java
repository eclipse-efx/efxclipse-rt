package org.eclipse.fx.code.editor.ldef.langs.fx.dart;

public class DartPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public DartPartitioner() {
		super(new DartPartitionScanner(), new String[] {
			"__dart_singlelinedoc_comment","__dart_multilinedoc_comment","__dart_singleline_comment","__dart_multiline_comment","__dart_string"
		});
	}
}
