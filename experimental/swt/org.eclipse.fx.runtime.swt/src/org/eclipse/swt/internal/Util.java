package org.eclipse.swt.internal;

import java.util.Arrays;

import javafx.collections.ObservableList;

public class Util {
	public static final void logNotImplemented() {
		StackTraceElement e = Thread.currentThread().getStackTrace()[2];
		System.err.println(e + " not implemented yet");
	}
	
	public static final void removeListIndices(ObservableList<?> list, int[] indices) {
		int[] sorted = new int[indices.length];
		System.arraycopy(indices, 0, sorted, 0, indices.length);
		Arrays.sort(sorted);
		
		int correction = 0;
		for( int i : sorted ) {
			list.remove(i - correction);
			correction++;
		}
	}
	
	public static final <T> T[] setIndexValue(int index, T[] array, T value) {
		if( index >= array.length ) {
			array = Arrays.copyOf(array, index+1);
		}
		array[index] = value;
		return array;
	}
	
	public static final String fixMnemonic(String string) {
		if( string == null ) {
			return string;
		}
		string = string.replace("_", "__");
		if( string.contains("&&") ) {
			string = string.replace("&&", "###!###");
			string = string.replace('&', '_');
			string = string.replace("###!###", "&");
		} else {
			string = string.replace('&', '_');	
		}
		
		return string;
	}
	
	public static final String fixAccelerator(String string) {
		if( string == null ) {
			return null;
		}
		int idx = string.indexOf('\t');
		if( idx > 0 ) {
			return string.substring(0, idx);
		}
		return string;
	}
	
	public static double alphaToOpacity(int alpha) {
		return (255 - alpha) / 255.0;
	}
	
	public static int opacityToAlpha(double o) {
		return (int)((o * 255.0 - 255 ) * -1);
	}
	
	public static String notNull(String text) {
		return text == null ? "" : text;
	}
}
