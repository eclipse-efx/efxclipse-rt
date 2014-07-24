package org.eclipse.fx.ui.viewer;

import java.util.Arrays;
import java.util.List;

public class ContentProviderFactory {
	public static <O> ContentProvider<O, List<O>> createListContentProvider() {
		return new ContentProvider<O, List<O>>() {
			@Override
			public List<O> getRootElements(List<O> input) {
				return input;
			}
		};
	}
	
	public static <O> ContentProvider<O, O[]> createArrayContentProvider() {
		return new ContentProvider<O, O[]>() {

			@Override
			public List<O> getRootElements(O[] input) {
				return Arrays.asList(input);
			}
		};
	}
}
