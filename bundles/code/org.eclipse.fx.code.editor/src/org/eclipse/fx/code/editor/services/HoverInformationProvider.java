package org.eclipse.fx.code.editor.services;

import java.util.Set;

import org.eclipse.fx.text.hover.AnnotationHoverProvider;
import org.eclipse.fx.text.hover.DocumentHoverProvider;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

public interface HoverInformationProvider {
	public CharSequence getHoverInformation(String partitionType, IRegion region);
	public IRegion getHoverRegion(String partitionType, int offset);

	DocumentHoverProvider getDocumentHoverProvider();
	Set<AnnotationHoverProvider> getAnnotationHoverProviders();

}
