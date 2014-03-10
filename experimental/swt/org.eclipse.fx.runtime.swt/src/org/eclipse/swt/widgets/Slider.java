package org.eclipse.swt.widgets;

import java.lang.reflect.Field;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Orientation;
import javafx.scene.control.Skin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.SliderBehavior;
import com.sun.javafx.scene.control.skin.BehaviorSkinBase;

@SuppressWarnings("restriction")
public class Slider extends Control {
	private javafx.scene.control.Slider slider;
	
	boolean noEvent;
	
	int eventType = SWT.DRAG;

	public Slider(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected void initListeners() {
		slider.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0) {
				if( noEvent ) {
					return;
				}
				
				Event event = new Event();
				event.detail = eventType;
				internal_sendEvent(SWT.Selection, event, true);
			}
		});
	}

	@Override
	public javafx.scene.control.Slider internal_getNativeObject() {
		return slider;
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean flushCache) {
		forceSizeProcessing();
		int width = (int) internal_getNativeObject().prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
		int height = (int) internal_getNativeObject().prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);

		if (wHint != SWT.DEFAULT)
			width = wHint;
		if (hHint != SWT.DEFAULT)
			height = hHint;

		Point p = new Point(width, height);
		return p;
	}

	@Override
	protected javafx.scene.control.Slider createWidget() {
		slider = new javafx.scene.control.Slider(0, 100, 0) {
			@Override
			protected Skin<?> createDefaultSkin() {
				Skin<?> s = super.createDefaultSkin();
				replaceBehavior(Slider.this,this,s);
				return s;
			}
		};
		slider.setMajorTickUnit(1);
		
		if( (style & SWT.VERTICAL) == SWT.VERTICAL ) {
			slider.setOrientation(Orientation.VERTICAL);
		}
		
		if( (style & SWT.BORDER) == SWT.BORDER ) {
			Util.logNotImplemented();
		}
		return slider;
	}
	
	private static boolean replaceBehavior(Slider swtSlider, javafx.scene.control.Slider slider, Skin skin) {
		try {
			Field f = BehaviorSkinBase.class.getDeclaredField("behavior");
			f.setAccessible(true);
			BehaviorBase<?> b = (BehaviorBase<?>) f.get(skin);
			b.dispose();
			f.set(skin, new SWTBehavior(swtSlider,slider));
			return true;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void addSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener (listener);
		registerListener (SWT.Selection,typedListener);
		registerListener (SWT.DefaultSelection,typedListener);
	}

	public int getIncrement() {
		checkWidget();
		return (int) slider.getMajorTickUnit();
	}

	public int getMaximum() {
		checkWidget();
		return (int) slider.getMax();
	}

	public int getMinimum() {
		checkWidget();
		return (int) slider.getMin();
	}

	public int getPageIncrement() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public int getSelection() {
		checkWidget();
		return (int) slider.getValue();
	}

	public int getThumb() {
		checkWidget();
		return (int) slider.getBlockIncrement();
	}

	public void removeSelectionListener(SelectionListener listener) {
		checkWidget ();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		unregisterListener(SWT.Selection, listener);
		unregisterListener(SWT.DefaultSelection,listener);
	}

	public void setIncrement(int value) {
		checkWidget();
		slider.setMajorTickUnit(value);
	}

	public void setMaximum(int value) {
		checkWidget();
		slider.setMax(value);
	}

	public void setMinimum(int value) {
		checkWidget();
		slider.setMin(value);
	}

	public void setPageIncrement(int value) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setSelection(int value) {
		checkWidget();
		try {
			noEvent = true;
			slider.setValue(value);	
		} finally {
			noEvent = false;
		}
		
	}

	public void setThumb(int value) {
		checkWidget();
		slider.setBlockIncrement(value);
	}

	public void setValues(int selection, int minimum, int maximum, int thumb, int increment, int pageIncrement) {
		setMinimum(minimum);
		setMinimum(maximum);

		setSelection(selection);

		setThumb(thumb);
		setIncrement(increment);
		setPageIncrement(pageIncrement);
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		Util.logNotImplemented();
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this,getFont());
	}
	
	static class SWTBehavior extends SliderBehavior {
		private Slider swtSlider;
		public SWTBehavior(Slider swtSlider, javafx.scene.control.Slider slider) {
			super(slider);
			this.swtSlider = swtSlider;
		}
		
		protected void callAction(String name) {
			if( "Home".equals(name) ) {
				swtSlider.eventType = SWT.HOME;
			} else if( "End".equals(name) ) {
				swtSlider.eventType = SWT.END;
			} else if( "IncrementValue".equals(name) ) {
				swtSlider.eventType = SWT.ARROW_DOWN;
			} else if( "DecrementValue".equals(name) ) {
				swtSlider.eventType = SWT.ARROW_UP;
			}
			super.callAction(name);
			swtSlider.eventType = SWT.DRAG;
			
		}
	}
}
