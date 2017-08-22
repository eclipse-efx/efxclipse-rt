package org.eclipse.fx.code.editor.asciidoc;

import java.util.concurrent.CompletableFuture;

public interface HTMLConverter {
	public CompletableFuture<String> convert(String filePath, String asciiDocSource);
}
