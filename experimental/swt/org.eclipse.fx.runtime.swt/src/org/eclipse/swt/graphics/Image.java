/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.graphics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.internal.CanvasGC;
import org.eclipse.swt.internal.Util;

public class Image extends Resource implements Drawable {
	private WritableImage image;

	public Image(Device device, int width, int height) {
		super(device);
		image = new WritableImage(width, height);
	}

	public Image(Device device, Rectangle bounds) {
		super(device);
		image = new WritableImage(bounds.width, bounds.height);
	}

	public Image(Device device, InputStream stream) {
		super(device);
		javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
		this.image = new WritableImage(image.getPixelReader(),
				(int) image.getWidth(), (int) image.getHeight());
	}

	public Image(Device device, String filename) {
		super(device);
		try (InputStream stream = new FileInputStream(filename)) {
			javafx.scene.image.Image image = new javafx.scene.image.Image(
					stream);
			this.image = new WritableImage(image.getPixelReader(),
					(int) image.getWidth(), (int) image.getHeight());
			stream.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Image(Device device, Image srcImage, int flag) {
		super(device);
		switch (flag) {
		case SWT.IMAGE_COPY:
			image = new WritableImage(srcImage.image.getPixelReader(),
					(int) srcImage.image.getWidth(),
					(int) srcImage.image.getHeight());
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public Image(Device device, ImageData data) {
		super(device);
		image = fromData(data);
	}

	public Image(Device device, ImageData source, ImageData mask) {
		super(device);
		image = fromData(source, ImageData.convertMask(mask));
	}

	private WritableImage fromData(ImageData source, ImageData mask) {
		ImageData imageData;
		int blackIndex = 0;
		if (source.palette.isDirect) {
			imageData = new ImageData(source.width, source.height,
					source.depth, source.palette);
		} else {
			RGB black = new RGB(0, 0, 0);
			RGB[] rgbs = source.getRGBs();
			if (source.transparentPixel != -1) {
				/*
				 * The source had transparency, so we can use the transparent
				 * pixel for black.
				 */
				RGB[] newRGBs = new RGB[rgbs.length];
				System.arraycopy(rgbs, 0, newRGBs, 0, rgbs.length);
				if (source.transparentPixel >= newRGBs.length) {
					/* Grow the palette with black */
					rgbs = new RGB[source.transparentPixel + 1];
					System.arraycopy(newRGBs, 0, rgbs, 0, newRGBs.length);
					for (int i = newRGBs.length; i <= source.transparentPixel; i++) {
						rgbs[i] = new RGB(0, 0, 0);
					}
				} else {
					newRGBs[source.transparentPixel] = black;
					rgbs = newRGBs;
				}
				blackIndex = source.transparentPixel;
				imageData = new ImageData(source.width, source.height,
						source.depth, new PaletteData(rgbs));
			} else {
				while (blackIndex < rgbs.length) {
					if (rgbs[blackIndex].equals(black))
						break;
					blackIndex++;
				}
				if (blackIndex == rgbs.length) {
					/*
					 * We didn't find black in the palette, and there is no
					 * transparent pixel we can use.
					 */
					if ((1 << source.depth) > rgbs.length) {
						/* We can grow the palette and add black */
						RGB[] newRGBs = new RGB[rgbs.length + 1];
						System.arraycopy(rgbs, 0, newRGBs, 0, rgbs.length);
						newRGBs[rgbs.length] = black;
						rgbs = newRGBs;
					} else {
						/* No room to grow the palette */
						blackIndex = -1;
					}
				}
				imageData = new ImageData(source.width, source.height,
						source.depth, new PaletteData(rgbs));
			}
		}
		if (blackIndex == -1) {
			/* There was no black in the palette, so just copy the data over */
			System.arraycopy(source.data, 0, imageData.data, 0,
					imageData.data.length);
		} else {
			/* Modify the source image to contain black wherever the mask is 0 */
			int[] imagePixels = new int[imageData.width];
			int[] maskPixels = new int[mask.width];
			for (int y = 0; y < imageData.height; y++) {
				source.getPixels(0, y, imageData.width, imagePixels, 0);
				mask.getPixels(0, y, mask.width, maskPixels, 0);
				for (int i = 0; i < imagePixels.length; i++) {
					if (maskPixels[i] == 0)
						imagePixels[i] = blackIndex;
				}
				imageData.setPixels(0, y, source.width, imagePixels, 0);
			}
		}
		imageData.maskPad = mask.scanlinePad;
		imageData.maskData = mask.data;
		return fromData(imageData);
	}

	private WritableImage fromData(ImageData data) {
		WritableImage img = new WritableImage(data.width, data.height);
		ImageData transparencyMask = data.getTransparencyMask();
		for (int x = data.width - 1; x >= 0; x--) {
			for (int y = data.height - 1; y >= 0; y--) {
				RGB rgb = data.palette.getRGB(data.getPixel(x, y));
				int pixel = rgb.red << 16 | rgb.green << 8 | rgb.blue;
				rgb = transparencyMask.palette.getRGB(transparencyMask
						.getPixel(x, y));
				int mask = rgb.red << 16 | rgb.green << 8 | rgb.blue;
				if (mask != 0) {
					int alpha = data.getAlpha(x, y);
					if (alpha > 0) {
						pixel = pixel & 0x00FFFFFF | alpha << 24;
						img.getPixelWriter().setArgb(x, y, pixel);
					}
				}
			}
		}
		return img;
	}

	public javafx.scene.image.Image internal_getImage() {
		return image;
	}

	public Color getBackground() {
		Util.logNotImplemented();
		return null;
	}

	public Rectangle getBounds() {
		return new Rectangle(0, 0, (int) image.getWidth(),
				(int) image.getHeight());
	}

	public ImageData getImageData() {
		PaletteData paletteData = new PaletteData(0xFF0000, 0xFF00, 0xFF);
		int width = (int) image.getWidth();
		int height = (int) image.getHeight();
		
		ImageData imageData = new ImageData(width, height,32, paletteData);
		byte[] maskData = new byte[(width + 7) / 8 * height];
		PixelReader reader = image.getPixelReader();
		for (int x = width - 1; x >= 0; x--) {
			for (int y = height - 1; y >= 0; y--) {
				int argb = reader.getArgb(x, y);
				RGB rgb = new RGB((argb >> 16) & 0xFF,(argb >> 8) & 0xFF, argb & 0xFF);
				int pixel = paletteData.getPixel(rgb);
				imageData.setPixel(x, y, pixel);
				int alpha = (argb >> 24) & 0xFF;
				imageData.setAlpha(x, y, alpha);
				if (alpha != 0) {
					int index = x + y * ((width + 7) / 8) * 8;
					maskData[index / 8] |= (byte) (1 << (7 - (index % 8)));
				}
			}
		}
		imageData.maskPad = 1;
		imageData.maskData = maskData;
		return imageData;
	}

	public void setBackground(Color color) {
		Util.logNotImplemented();
	}

	@Override
	public boolean isDisposed() {
		return image == null;
	}

	@Override
	public void dispose() {
		image = null;
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new CanvasGC(image);
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		// TODO Auto-generated method stub
		
	}
}