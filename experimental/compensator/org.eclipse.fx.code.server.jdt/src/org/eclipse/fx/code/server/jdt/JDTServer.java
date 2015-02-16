package org.eclipse.fx.code.server.jdt;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.fx.code.server.jdt.shared.Marker;
import org.eclipse.fx.code.server.jdt.shared.Proposal;

public interface JDTServer {
	public String getId();
	public Future<String> registerModule(URI uri);
	public Future<List<String>> getSourceFolders(String moduleName);

	public Future<Boolean> isManaged(String moduleName, String path);

	public Future<String> openFile(String moduleName, String path);
	public Future<Boolean> createFile(String moduleName, String path, ByteBuffer content);

	public Future<ByteBuffer> getFileContent(String id);
	public Future<Boolean> setFileContent(String id, ByteBuffer content);
	public Future<Boolean> insertContent(String id, int offset, ByteBuffer content);
	public Future<Boolean> replaceContent(String resourceId, int offset,
			int length, ByteBuffer wrap);
	public Future<Boolean> persistContent(String id);
	public Future<List<Marker>> getMarkers(String id);

	public Future<List<Proposal>> getProposals(String id, int offset);
	public Future<Boolean> reset(String id);
	public Future<Boolean> dispose(String resourceId);
}