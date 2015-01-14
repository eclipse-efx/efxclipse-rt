package org.eclipse.fx.code.server.jdt;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Future;

public interface JDTServer {
	public String getId();
	public Future<String> registerModule(URI uri);
	public Future<List<String>> getSourceFolders(String moduleName);

	public Future<Boolean> isManaged(String moduleName, String path);

	public Future<String> openFile(String moduleName, String path);

	public Future<ByteBuffer> getFileContent(String id);
	public Future<Boolean> setFileContent(String id, ByteBuffer content);
	public Future<Boolean> insertContent(String id, int offset, ByteBuffer content);
	public Future<Boolean> replaceContent(String resourceId, int offset,
			int length, ByteBuffer wrap);
	public Future<Boolean> persistContent(String id);



}
