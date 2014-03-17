package org.eclipse.swt.graphics;


public class Pattern extends Resource {
	javafx.scene.paint.Color color1;
	javafx.scene.paint.Color color2;
	javafx.scene.image.Image image;
	boolean disposed;
	float x1;
	float x2;
	float y1;
	float y2;
	
	public Pattern(Device device, Image image) {
		super(device);
		this.image = image.internal_getImage();
	}
	
	public Pattern(Device device, float x1, float y1, float x2, float y2, Color color1, Color color2) {
		this(device, x1, y1, x2, y2, color1, 0xFF, color2, 0xFF);
	}
	
	public Pattern(Device device, float x1, float y1, float x2, float y2, Color color1, int alpha1, Color color2, int alpha2) {
		super(device);
		this.color1 = color1.internal_getNativeObject();
		this.color1 = javafx.scene.paint.Color.rgb(color1.getRed(), color1.getGreen(), color1.getBlue(), alpha1 / 255.0);
		this.color2 = javafx.scene.paint.Color.rgb(color2.getRed(), color2.getGreen(), color2.getBlue(), alpha2 / 255.0);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public void dispose() {
		this.color1 = null;
		this.color2 = null;
		this.image = null;
		disposed = true;
	}

	@Override
	public boolean isDisposed() {
		return disposed;
	}
	
	public javafx.scene.paint.Color internal_getColor1() {
		return color1;
	}
	
	public javafx.scene.paint.Color internal_getColor2() {
		return color2;
	}
	
	public javafx.scene.image.Image internal_getImage() {
		return image;
	}
	
	public float internal_getX1() {
		return x1;
	}
	
	public float internal_getX2() {
		return x2;
	}
	
	public float internal_getY1() {
		return y1;
	}
	
	public float internal_getY2() {
		return y2;
	}
}
