package org.eclipse.fx.core.di.context.tests;

import java.util.UUID;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.preferences.Preference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.prefs.BackingStoreException;

public class PreferenceValueTestCase {

	static class SimpleInject {
		@Inject
		@Preference(key="simpleBoolean")
		boolean simpleBoolean = true;

		@Inject
		@Preference(key="simpleInt")
		int simpleInt = -1;

		@Inject
		@Preference(key="simpleFloat")
		float simpleFloat = -1;

		@Inject
		@Preference(key="simpleDouble")
		double simpleDouble = -1;

		@Inject
		@Preference(key="simpleLong")
		long simpleLong = -1;

		@Inject
		@Preference(key="simpleString")
		String simpleString = ""; //$NON-NLS-1$
	}

	static class SimpleInjectDefaults {
		@Inject
		@Preference(key="simpleBoolean",defaultValue="true")
		boolean simpleBoolean;

		@Inject
		@Preference(key="simpleInt",defaultValue="-1")
		int simpleInt;

		@Inject
		@Preference(key="simpleFloat",defaultValue="-1")
		float simpleFloat;

		@Inject
		@Preference(key="simpleDouble",defaultValue="-1")
		double simpleDouble;

		@Inject
		@Preference(key="simpleLong",defaultValue="-1")
		long simpleLong;

		@Inject
		@Preference(key="simpleString",defaultValue="")
		String simpleString;
	}

	/**
	 *
	 */
	@SuppressWarnings("static-method")
	@Before
	public void setup() {
		try {
			IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.fx.core.di.context.tests"); //$NON-NLS-1$
			node.removeNode();
		} catch (BackingStoreException e) {

			Assert.fail();
		}
	}

	/**
	 *
	 */
	@Test
	public void testSimplePreferences() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		SimpleInject simpleInject = ContextInjectionFactory.make(SimpleInject.class, serviceContext);
		Assert.assertFalse(simpleInject.simpleBoolean);
		Assert.assertEquals(0,simpleInject.simpleInt);
		Assert.assertEquals(0.0f,simpleInject.simpleFloat,0.0);
		Assert.assertEquals(0.0d,simpleInject.simpleDouble,0.0);
		Assert.assertEquals(0l,simpleInject.simpleLong);
		Assert.assertNull(simpleInject.simpleString);

		IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.fx.core.di.context.tests"); //$NON-NLS-1$
		node.putBoolean("simpleBoolean", true); //$NON-NLS-1$
		node.putDouble("simpleDouble", 1.0d); //$NON-NLS-1$
		node.putFloat("simpleFloat", 1.f); //$NON-NLS-1$
		node.putInt("simpleInt", 1); //$NON-NLS-1$
		node.putLong("simpleLong", 1l); //$NON-NLS-1$
		String sValue = UUID.randomUUID().toString();
		node.put("simpleString", sValue); //$NON-NLS-1$
		try {
			node.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
			Assert.fail();
		}

		Assert.assertTrue(simpleInject.simpleBoolean);
		Assert.assertEquals(1,simpleInject.simpleInt);
		Assert.assertEquals(1.0f,simpleInject.simpleFloat,0.0);
		Assert.assertEquals(1.0d,simpleInject.simpleDouble,0.0);
		Assert.assertEquals(1l,simpleInject.simpleLong);
		Assert.assertEquals(sValue, simpleInject.simpleString);
	}

	/**
	 *
	 */
	@Test
	public void testSimplePreferencesDefaultValues() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		SimpleInjectDefaults simpleInject = ContextInjectionFactory.make(SimpleInjectDefaults.class, serviceContext);
		Assert.assertTrue(simpleInject.simpleBoolean);
		Assert.assertEquals(-1,simpleInject.simpleInt);
		Assert.assertEquals(-1.0f,simpleInject.simpleFloat,0.0);
		Assert.assertEquals(-1.0d,simpleInject.simpleDouble,0.0);
		Assert.assertEquals(-1l,simpleInject.simpleLong);
		Assert.assertEquals("", simpleInject.simpleString); //$NON-NLS-1$

		IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.fx.core.di.context.tests"); //$NON-NLS-1$
		node.putBoolean("simpleBoolean", false); //$NON-NLS-1$
		node.putDouble("simpleDouble", 1.0d); //$NON-NLS-1$
		node.putFloat("simpleFloat", 1.f); //$NON-NLS-1$
		node.putInt("simpleInt", 1); //$NON-NLS-1$
		node.putLong("simpleLong", 1l); //$NON-NLS-1$
		String sValue = UUID.randomUUID().toString();
		node.put("simpleString", sValue); //$NON-NLS-1$
		try {
			node.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
			Assert.fail();
		}

		Assert.assertFalse(simpleInject.simpleBoolean);
		Assert.assertEquals(1,simpleInject.simpleInt);
		Assert.assertEquals(1.0f,simpleInject.simpleFloat,0.0);
		Assert.assertEquals(1.0d,simpleInject.simpleDouble,0.0);
		Assert.assertEquals(1l,simpleInject.simpleLong);
		Assert.assertEquals(sValue, simpleInject.simpleString);
	}
}
