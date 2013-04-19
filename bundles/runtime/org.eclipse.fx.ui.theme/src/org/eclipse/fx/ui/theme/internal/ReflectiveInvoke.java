package org.eclipse.fx.ui.theme.internal;

import java.lang.reflect.Method;

import javafx.scene.Scene;

public class ReflectiveInvoke {
	
	public static void onStyleManagerClass(Scene s) throws Exception {
		/*
		 * com.sun.javafx.css.StyleManager.getInstance().reloadStylesheets(scene);
		 */
		Class<?> cl = Class.forName("com.sun.javafx.css.StyleManager");
		Method m1 = cl.getMethod("getInstance");
		Object o1 = m1.invoke(null);
		
		Method m2 = cl.getMethod("reloadStylesheets", Scene.class);
		m2.invoke(o1, s);
	}
}
