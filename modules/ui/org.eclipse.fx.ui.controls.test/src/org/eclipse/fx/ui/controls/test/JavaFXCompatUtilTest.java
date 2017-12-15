package org.eclipse.fx.ui.controls.test;


import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.junit.Assert;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class JavaFXCompatUtilTest {
	@Test
	public void getAllWindows() {
		Assert.assertNotNull(JavaFXCompatUtil.getAllWindows());
	}

	@Test
	public void getCode() {
		Assert.assertEquals(0x41,JavaFXCompatUtil.getCode(KeyCode.A));
	}

	@Test
	public void getChar() {
		Assert.assertEquals("A",JavaFXCompatUtil.getChar(KeyCode.A));
	}

	@Test
	public void reapplyCSS() {
		JavaFXCompatUtil.reapplyCSS(new Rectangle());
	}
}
