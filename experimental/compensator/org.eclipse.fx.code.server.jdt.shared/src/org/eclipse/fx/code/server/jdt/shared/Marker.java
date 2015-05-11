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
