/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.server.jdt.shared;

public class Marker {
	public enum Type {
		PROBLEM,
		TASK
	}

	public enum Severity {
		ERROR,
		WARNING,
		INFO
	}

	private final Type type;
	private final Severity severity;
	private final String message;
	private final String resourceId;
	private final int lineNumber;
	private final int startPos;
	private final int endPos;

	public Marker(Type type, Severity severity, String message, String resourceId, int lineNumber,
			int startPos, int endPos) {
		this.type = type;
		this.severity = severity;
		this.message = message;
		this.resourceId = resourceId;
		this.lineNumber = lineNumber;
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public Severity getSeverity() {
		return severity;
	}

	public Type getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public String getResourceId() {
		return resourceId;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getStartPos() {
		return startPos;
	}

	public int getEndPos() {
		return endPos;
	}


}
