/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.panes;

import java.io.InputStream;

import javafx.scene.image.Image;

public abstract class ImageDescriptor {
	public interface InputStreamProvider {
		public InputStream getStream();
	}
	
	private Image image;
	
	public Image getImage() {
		if( image == null ) {
			image = doCreateImage();
		}
		
		return image;
	}
	
	protected abstract Image doCreateImage();
	
	public static ImageDescriptor fromUrl(final String url) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(url);
			}
		};
	}
	
	public static ImageDescriptor fromUrl(final String url, final boolean backgroundLoading) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(url, backgroundLoading);
			}
		};
	}
	
	public static ImageDescriptor fromUrl(final String url, final double requestedWidth, final double requestedHeight, final boolean preserviceRatio, final boolean smooth) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(url,requestedWidth,requestedHeight,preserviceRatio,smooth);
			}
		};
	}
	
	public static ImageDescriptor fromUrl(final String url, final double requestedWidth, final double requestedHeight, final boolean preserviceRatio, final boolean smooth, final boolean backgroundLoading) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(url,requestedWidth,requestedHeight,preserviceRatio,smooth,backgroundLoading);
			}
		};
	}
	
	public static ImageDescriptor fromInputStream(final InputStream stream) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(stream);
			}
		};
	}
	
	public static ImageDescriptor fromInputStream(final InputStream stream, final double requestedWidth, final double requestedHeight, final boolean preserviceRatio, final boolean smooth) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(stream,requestedWidth,requestedHeight,preserviceRatio,smooth);
			}
		};
	}
	
	public static ImageDescriptor fromInputStreamProvider(final InputStreamProvider provider) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(provider.getStream());
			}
		};
	}
	
	public static ImageDescriptor fromInputStreamProvider(final InputStreamProvider provider, final double requestedWidth, final double requestedHeight, final boolean preserviceRatio, final boolean smooth) {
		return new ImageDescriptor() {
			
			@Override
			protected Image doCreateImage() {
				return new Image(provider.getStream(),requestedWidth,requestedHeight,preserviceRatio,smooth);
			}
		};
	}
}