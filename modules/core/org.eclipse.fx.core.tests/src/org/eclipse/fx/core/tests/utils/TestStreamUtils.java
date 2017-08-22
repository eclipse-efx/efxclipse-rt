package org.eclipse.fx.core.tests.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.fx.core.StreamUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestStreamUtils {
	@Test
	public void test_replaceTabBySpace() {
		List<String> list = Arrays.asList("1", "2", "3"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		List<String> reversed = StreamUtils.reverse(list).collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList("3", "2", "1"), reversed);
	}
}
