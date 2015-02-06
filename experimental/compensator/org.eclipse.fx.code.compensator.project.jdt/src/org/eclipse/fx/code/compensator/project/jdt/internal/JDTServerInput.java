package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.TextEditor;
import org.eclipse.fx.code.compensator.editor.URIProvider;
import org.eclipse.fx.code.compensator.editor.VCSInput;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.code.server.jdt.JDTServerFactory;
import org.eclipse.fx.core.URI;

public class JDTServerInput implements Input<String>, ContentTypeProvider, URIProvider, VCSInput<String> {
	public final JDTServer server;
	public final Future<String> openFile;
	private final String uri;
	private VCSRepositoryInstance repositoryInstance;
	private Path filePath;
	
	
	@Inject
	public JDTServerInput(@Named(TextEditor.DOCUMENT_URL) String url, @Named(TextEditor.VCS_URL) String vcsUrl, InstanceProject project, JDTServerFactory factory) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(url);
		JDTServer server = factory.getOrCreateServer(uri.segment(0));
		String module = uri.segment(1);
		StringBuilder b = new StringBuilder();

		for( int i = 2; i < uri.segmentCount(); i++ ) {
			if( b.length() > 0 ) {
				b.append('/');
			}
			b.append(uri.segment(i));
		}
		this.server = server;
		this.uri = url;
		this.openFile = this.server.openFile(module, b.toString());
		
		filePath = Paths.get(java.net.URI.create(vcsUrl));
		for( VCSRepositoryInstance i : project.getRepositoryInstanceList() ) {
			if( filePath.startsWith(i.getRootPath()) ) {
				repositoryInstance = i;
				break;
			}
		}
	}

	@Override
	public Future<Boolean> commit() {
		repositoryInstance.commit(Collections.singleton(filePath));
		return null;
	}
	
	@Override
	public URI getURI() {
		return URI.create(uri);
	}

	@Override
	public void reset() {
		try {
			String resourceId = this.openFile.get();
			Future<Boolean> rv = this.server.reset(resourceId);
			rv.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dispose() {
		try {
			String resourceId = this.openFile.get();
			Future<Boolean> rv = this.server.dispose(resourceId);
			rv.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getData() {
		try {
			String resourceId = this.openFile.get();
			Future<ByteBuffer> data = this.server.getFileContent(resourceId);

			// Freaking hack because JavaFX can not deal with TABs
			String s = new String(data.get().array());
//			BufferedReader reader = new BufferedReader(new StringReader(s));
//			StringBuilder b = new StringBuilder();
//			String line;
//			while( (line = reader.readLine()) != null ) {
//				//FIXME We need to replace TABs for now
//				b.append(line.replaceAll("\t", "    ")+"\n");
//			}
//			reader.close();
//
//			if( ! s.equals(b.toString()) ) {
//				this.server.setFileContent(resourceId, ByteBuffer.wrap(b.toString().getBytes())).get();
//				this.server.persistContent(resourceId);
//			}
			return s;
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setData(String data) {
		try {
			String resourceId = this.openFile.get();
			Future<Boolean> content = this.server.setFileContent(resourceId, ByteBuffer.wrap(data.getBytes()));
			content.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void persist() {
		try {
			String resourceId = this.openFile.get();
			Future<Boolean> content = this.server.persistContent(resourceId);
			content.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertData(int offset, String data) {
		try {
			String resourceId = this.openFile.get();
			Future<Boolean> rv = this.server.insertContent(resourceId, offset, ByteBuffer.wrap(data.getBytes()));
			rv.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void replaceData(int offset, int length, String data) {
		try {
			String resourceId = this.openFile.get();
			Future<Boolean> rv = this.server.replaceContent(resourceId, offset, length, ByteBuffer.wrap(data.getBytes()));
			rv.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getContentType() {
		return ContentTypeProvider.JAVA;
	}


}
