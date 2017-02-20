package org.eclipse.fx.core.tests.text;

import org.eclipse.fx.core.text.AnnotatedString;
import org.eclipse.fx.core.text.AnnotatedString.Builder;
import org.junit.Assert;
import org.junit.Test;

public class TestAnnotatedString {
	@Test
	public void testAdd_Char() {
		Builder<String> builder = AnnotatedString.create(String.class,10);
		AnnotatedString<String> string = builder
			.add(new char [] { 'H','e','l','l','o' }, "a", "b")
			.add(new char[] { ' ' })
			.add(new char [] { 'W','o','r','l','d', '!' }, "c", "d")
			.build();
		Assert.assertNotNull(string);
		Assert.assertEquals(12, string.length());
		Assert.assertEquals("Hello World!", string.toString());
	}
}
