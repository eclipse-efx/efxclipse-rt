package org.eclipse.fx.code.editor.asciidoc.fx;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.asciidoc.HTMLConverter;
import org.eclipse.fx.core.ThreadSynchronize;

import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

public class AsciiDoctorPreviewer {
	private final Input<String> input;
	private final HTMLConverter converter;
	private final ThreadSynchronize threadSynchronize;

	@Inject
	public AsciiDoctorPreviewer(Input<String> input, @Optional HTMLConverter converter, ThreadSynchronize threadSynchronize) {
		this.input = input;
		this.converter = converter;
		this.threadSynchronize = threadSynchronize;
	}

	@PostConstruct
	void init(BorderPane parent) {
		WebView view = new WebView();
		if( converter != null ) {
			CompletableFuture<String> convert = converter.convert("",  input.getData());
			Consumer<String> consumer = threadSynchronize.wrap(view.getEngine()::loadContent);
			convert.thenAccept(consumer);
		}
		parent.setCenter(view);
	}
}
