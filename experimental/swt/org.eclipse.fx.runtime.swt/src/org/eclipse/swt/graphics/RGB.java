package org.eclipse.swt.graphics;


public class RGB {
	public int red;
	public int green;
	public int blue;
	
	public RGB(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public RGB(float hue, float saturation, float brightness) {
		if (hue < 0 || hue > 360 || saturation < 0 || saturation > 1 || 
				brightness < 0 || brightness > 1) {
			throw new IllegalArgumentException();
//				SWT.error(SWT.ERROR_INVALID_ARGUMENT);
			}
			float r, g, b;
			if (saturation == 0) {
				r = g = b = brightness; 
			} else {
				if (hue == 360) hue = 0;
				hue /= 60;	
				int i = (int)hue;
				float f = hue - i;
				float p = brightness * (1 - saturation);
				float q = brightness * (1 - saturation * f);
				float t = brightness * (1 - saturation * (1 - f));
				switch(i) {
					case 0:
						r = brightness;
						g = t;
						b = p;
						break;
					case 1:
						r = q;
						g = brightness;
						b = p;
						break;
					case 2:
						r = p;
						g = brightness;
						b = t;
						break;
					case 3:
						r = p;
						g = q;
						b = brightness;
						break;
					case 4:
						r = t;
						g = p;
						b = brightness;
						break;
					case 5:
					default:
						r = brightness;
						g = p;
						b = q;
						break;
				}
			}
			red = (int)(r * 255 + 0.5);
			green = (int)(g * 255 + 0.5);
			blue = (int)(b * 255 + 0.5);
	}
	
	public float[] getHSB() {	
		float r = red / 255f;
		float g = green / 255f;
		float b = blue / 255f;
		float max = Math.max(Math.max(r, g), b);
		float min = Math.min(Math.min(r, g), b);
		float delta = max - min;
		float hue = 0;
		float brightness = max;
		float saturation = max == 0 ? 0 : (max - min) / max;
		if (delta != 0) {
			if (r == max) {
				hue = (g  - b) / delta;
			} else {
				if (g == max) {
					hue = 2 + (b - r) / delta;	
				} else {
					hue = 4 + (r - g) / delta;
				}
			}
			hue *= 60;
			if (hue < 0) hue += 360;
		}
		return new float[] {hue, saturation, brightness};
	}	

	@Override
	public String toString() {
		return "RGB("+red+","+green+","+blue+")";
	}
}
