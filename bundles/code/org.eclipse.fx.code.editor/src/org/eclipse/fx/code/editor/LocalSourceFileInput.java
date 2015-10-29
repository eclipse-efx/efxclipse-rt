package org.eclipse.fx.code.editor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.adapter.Adapt;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.core.function.ExExecutor;

public class LocalSourceFileInput implements SourceFileInput {
	private final Path path;
	private final Charset charSet;
	private String data;
	private EventBus eventBus;

	@Inject
	public LocalSourceFileInput(@Adapt @Named(Constants.DOCUMENT_URL) Path path, @Optional EventBus eventBus) {
		this(path,StandardCharsets.UTF_8, eventBus);
	}

	public LocalSourceFileInput(Path path, Charset charSet, @Optional EventBus eventBus) {
		this.path = path;
		this.charSet = charSet;
		this.eventBus = eventBus;
	}

	@PostConstruct
	protected void init() {
		if( eventBus != null ) {
			eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_CREATED, this, true);
		}
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
		if( eventBus != null ) {
			eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_DISPOSED, this, true);
		}
	}

	@Override
	public String getData() {
		if( data == null ) {
			try {
				byte[] bytes = Files.readAllBytes(path);
				data = new String(bytes, charSet);
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
			if( eventBus != null ) {
				eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_SAVED, this, true);
			}
		} catch (IOException e) {
			throw new RuntimeException("Unable to write content to file '"+path+"'", e);
		}
	}

	@Override
	public String getURI() {
		return ExExecutor.executeSupplier(() -> path.toUri().toURL().toExternalForm(), "Could not retrieve URI from '"+path+"'").orElse(null);
	}

	@Override
	public void updateData(int offset, int length, String replacement) {
		StringBuilder b = new StringBuilder(data.length() - length + replacement.length());
		b.append(data.substring(0, offset));
		b.append(replacement);
		b.append(data.substring(offset+length,data.length()));
		data = b.toString();

		if( eventBus != null ) {
			SourceFileChange sourceChange = new SourceFileChange(this, offset, length, replacement);
			eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_MODIFIED, sourceChange, true);
		}
	}
}
