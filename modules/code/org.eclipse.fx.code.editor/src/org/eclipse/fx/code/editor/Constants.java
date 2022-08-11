/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor;

import org.eclipse.fx.code.editor.services.StringInputAboutToChange;
import org.eclipse.fx.core.event.Topic;

public class Constants {
	public static final String EDITOR_DIRTY_FLAG_KEY = "code-editor-dirty";

	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_INPUT_CREATED = new Topic<>("at/bestsolution/dart/editor/file-input/created");
	public static final Topic<StringInputAboutToChange> TOPIC_SOURCE_FILE_INPUT_TOBE_MODIFIED = new Topic<>("at/bestsolution/dart/editor/file-input/tobemodified");
	public static final Topic<SourceFileChange> TOPIC_SOURCE_FILE_INPUT_MODIFIED = new Topic<>("at/bestsolution/dart/editor/file-input/modified");
	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_INPUT_DISPOSED = new Topic<>("at/bestsolution/dart/editor/file-input/disposed");
	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_INPUT_SAVED = new Topic<>("at/bestsolution/dart/editor/file-input/saved");

//	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_STALE = new Topic<>("at/bestsolution/dart/editor/file-input/stale");
	public static final Topic<SourceFileInput> TOPIC_SOURCE_FILE_RELOADED = new Topic<>("at/bestsolution/dart/editor/file-input/reloaded");

	public static final Topic<SourceSelection> TOPIC_SELECT_SOURCE = new Topic<>("at/bestsolution/dart/editor/select-source");


	public static final String DOCUMENT_URL = "documentUrl";
	public static final String VCS_URL = "vcsUrl";
	public static final String CONTEXT = "context";

	public static final String EDITOR_CONTAINER_TAG = "editorContainer";

	public static final String PREFERENCE_NODE_PATH = "org.eclipse.fx.code.editor";
	public static final String PREFERENCE_KEY_EDITOR_FEATURE = "editorFeatures";
	public static final String PREFERENCE_TAB_ADVANCE = "tabAdvance";
	public static final String PREFERENCE_SPACES_FOR_TAB = "spacesForTab";
	public static final String PREFERENCE_ZOOMFACTOR = "zoomFactor";
}
