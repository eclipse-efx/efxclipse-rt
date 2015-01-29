package org.eclipse.fx.code.compensator.project.jdt.internal;

import org.eclipse.fx.code.server.jdt.shared.Marker;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;

public class JDTAnnotation extends Annotation {
	private final Marker marker;

	public JDTAnnotation(Marker marker) {
		super("jdt.annotation", false, marker.getMessage());
		this.marker = marker;
	}

	public Marker getMarker() {
		return marker;
	}
}
