package org.eclipse.fx.testcases.dnd.app.jemmy;

import org.jemmy.fx.SceneDock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTestCase {
	protected static SceneDock scene;
	
	@BeforeClass
	public static void startApp() throws InterruptedException {
		try {
			scene = new SceneDock();
		} catch(Throwable t ) {
			t.printStackTrace();
		}
	}
	
	@Test
	public void sampleTestMethod() {
		Assert.fail("Not implemented");
	}
}
