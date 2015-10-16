package org.eclipse.fx.code.editor.ldef.langs.fx.lua;

public class LuaPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public LuaPartitioner() {
		super(new LuaPartitionScanner(), new String[] {
			"__lua_single_line_comment","__lua_multi_line_comment","__lua_string"
		});
	}
}
