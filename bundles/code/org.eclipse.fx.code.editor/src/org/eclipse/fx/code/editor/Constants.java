package org.eclipse.fx.code.editor;

import org.eclipse.fx.core.event.Topic;

public class Constants {
	public static final String EDITOR_DIRTY_FLAG_KEY = "code-editor-dirty";

	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_INPUT_CREATED = new Topic<>("at/bestsolution/dart/editor/file-input/created");
	public static final Topic<SourceFileChange> TOPIC_SOURCE_FILE_INPUT_MODIFIED = new Topic<>("at/bestsolution/dart/editor/file-input/modified");
	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_INPUT_DISPOSED = new Topic<>("at/bestsolution/dart/editor/file-input/disposed");
	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_INPUT_SAVED = new Topic<>("at/bestsolution/dart/editor/file-input/saved");

	public static final String DOCUMENT_URL = "documentUrl";
	public static final String VCS_URL = "vcsUrl";

	public static final String EDITOR_CONTAINER_TAG = "editorContainer";

}
