package org.eclipse.fx.emf.edit.ui;

import static org.junit.Assert.*;

import org.eclipse.fx.emf.edit.ui.dnd.LocalTransfer;
import org.junit.Test;

public class LocalTransferTest {

	@Test
	public void setAndGetObjbect() {
		final Object object = new Object();
		LocalTransfer.INSTANCE.setObject(object);
		assertEquals(object, LocalTransfer.INSTANCE.getObject());
	}

}
