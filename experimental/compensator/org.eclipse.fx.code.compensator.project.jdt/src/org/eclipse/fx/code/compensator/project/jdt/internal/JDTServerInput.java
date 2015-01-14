package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.server.jdt.JDTServer;

public class JDTServerInput implements Input<String>, ContentTypeProvider {
	private JDTServer server;
	private Future<String> openFile;

	public JDTServerInput(JDTServer server, String module, String path) {
		this.server = server;
		this.openFile = this.server.openFile(module, path);
	}

	@Override
	public String getData() {
		try {
			String resourceId = this.openFile.get();
			Future<ByteBuffer> data = this.server.getFileContent(resourceId);

			// Freaking hack because JavaFX can not deal with TABs
			String s = new String(data.get().array());
			BufferedReader reader = new BufferedReader(new StringReader(s));
			StringBuilder b = new StringBuilder();
			String line;
			while( (line = reader.readLine()) != null ) {
				//FIXME We need to replace TABs for now
				b.append(line.replaceAll("\t", "    ")+"\n");
			}
			reader.close();

			if( ! s.equals(b.toString()) ) {
				this.server.setFileContent(resourceId, ByteBuffer.wrap(b.toString().getBytes())).get();
				this.server.persistContent(resourceId);
			}
			return b.toString();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
