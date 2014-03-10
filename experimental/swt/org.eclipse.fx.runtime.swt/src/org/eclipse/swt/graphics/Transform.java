package org.eclipse.swt.graphics;

import org.eclipse.swt.SWT;

import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;

public class Transform extends Resource {
	private Affine transform;
	
	public Transform(Device device) {
		this(device, 1, 0, 0, 1, 0, 0);
	}
	
	public Transform(Device device, float[] elements) {
		this(device,elements[0], elements[1], elements[2], elements[3], elements[4], elements[5]);
	}
	
	public Transform (Device device, float m11, float m12, float m21, float m22, float dx, float dy) {
		super(device);
		this.transform = new Affine(m11, m12, dx, m21, m22, dy);
	}
	
	public void getElements(float[] elements) {
		elements[0] = (float) transform.getMxx();
		elements[1] = (float) transform.getMxy();
		elements[2] = (float) transform.getTx();
		elements[3] = (float) transform.getMyx();
		elements[4] = (float) transform.getMyy();
		elements[5] = (float) transform.getTy();
	}
	
	public void setElements(float m11, float m12, float m21, float m22, float dx, float dy) {
		transform.setToTransform(m11, m12, dx, m21, m22, dy);
	}
	
	public void identity() {
		transform.setMxx(1);
		transform.setMyy(1);
	}
	
	public void invert() {
		try {
			transform.invert();
		} catch (NonInvertibleTransformException e) {
			SWT.error(SWT.ERROR_CANNOT_INVERT_MATRIX, e);
		}
	}
	
	public boolean isIdentity() {
		return transform.isIdentity();
	}
	
	public void multiply(Transform matrix) {
		transform.prepend(matrix.transform);
	}
	
	public void rotate(float angle) {
		transform.appendRotation(angle);
	}
	
	public void scale(float scaleX, float scaleY) {
		transform.appendScale(scaleX, scaleY);
	}
	
	public void shear(float shearX, float shearY) {
		transform.appendShear(shearX, shearY);
	}
	
	public void transform(float[] pointArray) {
		int length = pointArray.length / 2;
		int j = 0;
		for( int i = 0; i < length; i++ ) {
			transform.transform(pointArray[j], pointArray[j+1]);
			j += 2;
		}
	}
	
	public void translate(float offsetX, float offsetY) {
		transform.appendTranslation(offsetX, offsetY);
	}

	@Override
	public void dispose() {
		transform = null;
	}

	@Override
	public boolean isDisposed() {
		return transform == null;
	}
	
	public Affine internal_getNativeObject() {
		return transform;
	}

}
