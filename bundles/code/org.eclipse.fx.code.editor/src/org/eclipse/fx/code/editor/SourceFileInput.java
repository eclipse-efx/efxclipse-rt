package org.eclipse.fx.code.editor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SourceFileInput implements StringInput {
	private final Path path;
	private final Charset charSet;
	private String data;
	private String savedData;

	public SourceFileInput(Path path, Charset charSet) {
		this.path = path;
		this.charSet = charSet;
	}

	public SourceFileInput(Path path) {
		this(path,StandardCharsets.UTF_8);
	}

	@Override
	public void dispose() {
	}

	@Override
	public String getData() {
		if( data == null ) {
			try {
				byte[] bytes = Files.readAllBytes(path);
				data = savedData = new String(bytes, charSet);
			} catch (IOException e) {
				throw new RuntimeException("Unable to read file content of '"+path+"'", e);
			}
		}
		return data;
	}

	@Override
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void persist() {
		try {
			Files.write(path, data.getBytes(charSet));
			savedData = data;
		} catch (IOException e) {
			throw new RuntimeException("Unable to write content to file '"+path+"'", e);
		}
	}

	@Override
	public void reset() {
		data = savedData;
	}

}
