package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.Rectangle;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Monitor {
	private Screen screen;
	
	Monitor(Screen screen) {
		this.screen = screen;
	}

	public Rectangle getBounds() {
		Rectangle2D bounds = screen.getBounds();
		return new Rectangle((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}
	
	public Rectangle getClientArea () {
		Rectangle2D bounds = screen.getVisualBounds();
		return new Rectangle((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Monitor)) return false;
		Monitor monitor = (Monitor) obj;
		return screen.equals(monitor.screen);
	}
	
	@Override
	public int hashCode() {
		return screen.hashCode();
	}
}
