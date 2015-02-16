package org.eclipse.fx.code.server.jdt.inmemory;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.code.server.jdt.server.JDTServerImpl;
import org.eclipse.fx.code.server.jdt.shared.Marker;
import org.eclipse.fx.code.server.jdt.shared.Proposal;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

public class MemJDTServer implements JDTServer {
	private JDTServerImpl serverImpl = new JDTServerImpl();
	private final String id = UUID.randomUUID().toString();

	private static Logger LOGGER;

	private static Logger getLogger() {
		if( LOGGER == null ) {
			LOGGER = LoggerCreator.createLogger(MemJDTServer.class);
		}
		return LOGGER;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Future<String> registerModule(URI uri) {
		return CompletableFuture.supplyAsync(() -> serverImpl.registerModule(uri));
	}

	@Override
	public Future<List<String>> getSourceFolders(String moduleName) {
		return CompletableFuture.supplyAsync(() -> serverImpl.getSourceFolders(moduleName));
	}

	@Override
	public Future<Boolean> isManaged(String moduleName, String path) {
		return CompletableFuture.supplyAsync(() -> serverImpl.isManaged(moduleName, path));
	}

	@Override
	public Future<String> openFile(String moduleName, String path) {
		return CompletableFuture.supplyAsync(() -> serverImpl.openFile(moduleName, path));
	}
	
	@Override
	public Future<Boolean> createFile(String moduleName, String path, ByteBuffer content) {
		return CompletableFuture.supplyAsync(() -> serverImpl.createFile(moduleName,path,content));
	}

	@Override
	public Future<ByteBuffer> getFileContent(String id) {
		return CompletableFuture.supplyAsync(() -> ByteBuffer.wrap(serverImpl.getFileContent(id)));
	}

	@Override
	public Future<List<Marker>> getMarkers(String id) {
		return CompletableFuture.supplyAsync(() -> serverImpl.getMarkers(id));
	}

	@Override
	public Future<Boolean> reset(String id) {
		return CompletableFuture.supplyAsync(() -> {
			serverImpl.reset(id);
			return true;
		});
	}

	@Override
	public Future<Boolean> dispose(String resourceId) {
		return CompletableFuture.supplyAsync(() -> {
			serverImpl.dispose(resourceId);
			return true;
		});
	}

	@Override
	public Future<Boolean> insertContent(String id, int offset,
			ByteBuffer content) {
		return CompletableFuture.supplyAsync(() -> {
			serverImpl.insertContent(id, offset, content.array());
			return true;
		});
	}

	@Override
	public Future<Boolean> replaceContent(String id, int offset,
			int length, ByteBuffer content) {
		return CompletableFuture.supplyAsync(() -> {
			serverImpl.replaceContent(id, offset, length, content.array());
			return true;
		});
	}

	@Override
	public Future<Boolean> persistContent(String id) {
		return CompletableFuture.supplyAsync(() -> {
			serverImpl.persistFileContent(id);
			return true;
		});
	}

	@Override
	public Future<Boolean> setFileContent(String id, ByteBuffer content) {
		return CompletableFuture.supplyAsync(() -> {
			serverImpl.setFileContent(id, content.array());
			return true;
		});
	}

	@Override
	public Future<List<Proposal>> getProposals(String id, int offset) {
		return CompletableFuture.supplyAsync(() -> serverImpl.getProposals(id,offset));
	}
}
