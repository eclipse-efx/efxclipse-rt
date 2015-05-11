package org.eclipse.fx.code.server.jdt.shared;

import java.util.List;

public class JavaCodeCompleteProposal implements Proposal {
	public enum Type {
		FIELD,
		METHOD,
		CONSTRUCTOR,

		INTERFACE,
		CLASS,
		ENUM
	}

	public enum Visibility {
		PUBLIC,
		PRIVATE,
		PROTECTED,
		PACKAGE_PRIVATE
	}

	public enum Modifier {
		FINAL,
		STATIC,
		ABSTRACT
	}

	private final Type type;
	private final Visibility visibility;
	private final List<Modifier> modifiers;
	private final String value;
	private final String label;
	private final String additionalLabel;
	private final int replacementOffset;
	private final int replacementLength;

	public JavaCodeCompleteProposal(Type type, Visibility visibility, List<Modifier> modifiers, int replacementOffset, int replacementLength, String value, String label, String additionalLabel) {
		this.type = type;
		this.visibility = visibility;
		this.modifiers = modifiers;
		this.replacementOffset = replacementOffset;
		this.replacementLength = replacementLength;
		this.value = value;
		this.label = label;
		this.additionalLabel = additionalLabel;
	}

	public Type getType() {
		return type;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public List<Modifier> getModifiers() {
		return modifiers;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	public String getAdditionalLabel() {
		return additionalLabel;
	}

	public int getReplacementLength() {
		return replacementLength;
	}

	public int getReplacementOffset() {
		return replacementOffset;
	}
}
