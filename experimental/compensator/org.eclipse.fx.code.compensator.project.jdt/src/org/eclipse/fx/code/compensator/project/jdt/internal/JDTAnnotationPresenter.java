package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import org.eclipse.fx.code.server.jdt.shared.Marker.Type;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationPresenter;

import com.sun.javafx.iio.ImageStorage.ImageType;

public class JDTAnnotationPresenter implements AnnotationPresenter {

	@Override
	public List<String> getTypes() {
		return Arrays.asList("jdt.annotation.WARNING","jdt.annotation.ERROR","jdt.annotation.INFO");
	}

	@Override
	public Node getPresentation(Annotation annotation, GraphicsLoader loader) {
		Node n = null;
		if( annotation instanceof JDTAnnotation ) {
			JDTAnnotation ja = (JDTAnnotation) annotation;

			if( ja.getMarker().getType() == Type.PROBLEM ) {
				switch (ja.getMarker().getSeverity()) {
				case ERROR:
					n = loader.getGraphicsNode(URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project", "css/icons/16/window-close.png"));
					break;
				case INFO:
					n = loader.getGraphicsNode(URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project", "css/icons/16/message_info.png"));
					break;
				case WARNING:
					n = loader.getGraphicsNode(URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project", "css/icons/16/message_warning.png"));
					break;
				default:
					break;
				}
			} else if( ja.getMarker().getType() == Type.TASK ) {
				n = loader.getGraphicsNode(URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project", "css/icons/16/showtsk_tsk.png"));
			}

			//TODO me

			if( n != null ) {
				Label l = new Label(null, n);
				l.setTooltip(new Tooltip(ja.getMarker().getMessage()));
				n = l;
			}

		}
		return n;
	}

}
