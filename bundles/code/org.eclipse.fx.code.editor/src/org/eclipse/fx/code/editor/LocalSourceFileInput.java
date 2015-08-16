package org.eclipse.fx.code.editor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.fx.code.editor.services.URIProvider;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.adapter.Adapt;
import org.eclipse.fx.core.event.EventBus;

public class LocalSourceFileInput implements StringInput, URIProvider {
	private final Path path;
	private final Charset charSet;
	private String data;
	private String savedData;
	private EventBus eventBus;

	@Inject
	public LocalSourceFileInput(@Adapt @Named(Constants.DOCUMENT_URL) Path path, EventBus eventBus) {
		this(path,StandardCharsets.UTF_8, eventBus);
	}

	public LocalSourceFileInput(Path path, Charset charSet, EventBus eventBus) {
		this.path = path;
		this.charSet = charSet;
		this.eventBus = eventBus;
		eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_CREATED, this, true);
	}

	public Path getPath() {
		return path;
	}

	@PreDestroy
	@Override
	public final void dispose() {
		doDispose();
	}

	protected void doDispose() {
		eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_DISPOSED, this, true);
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

	@Override
	public URI getURI() {
		return URI.create(path.toUri().toString());
	}

	@Override
	public void updateData(int offset, int length, String replacement) {
		StringBuilder b = new StringBuilder(data.length() - length + replacement.length());
		b.append(data.substring(0, offset));
		b.append(replacement);
		b.append(data.substring(offset+length,data.length()));
		data = b.toString();

		SourceFileChange sourceChange = new SourceFileChange(this, offset, length, replacement);
		eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_MODIFIED, sourceChange, true);
	}
}
