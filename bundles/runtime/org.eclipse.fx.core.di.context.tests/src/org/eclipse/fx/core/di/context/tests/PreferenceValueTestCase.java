package org.eclipse.fx.core.di.context.tests;

import java.time.Instant;
import java.util.UUID;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.preferences.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.prefs.BackingStoreException;

import javafx.beans.property.Property;

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

	static class ValueInject {
		@Inject
		@Preference(key="simpleBoolean")
		Value<Boolean> simpleBoolean;

		@Inject
		@Preference(key="simpleInt")
		Value<Integer> simpleInt;

		@Inject
		@Preference(key="simpleFloat")
		Value<Float> simpleFloat;

		@Inject
		@Preference(key="simpleDouble")
		Value<Double> simpleDouble;

		@Inject
		@Preference(key="simpleLong")
		Value<Long> simpleLong;

		@Inject
		@Preference(key="simpleString")
		Value<String> simpleString;
	}

	static class ValueInjectDefaults {
		@Inject
		@Preference(key="simpleBoolean",defaultValue="true")
		Value<Boolean> simpleBoolean;

		@Inject
		@Preference(key="simpleInt",defaultValue="-1")
		Value<Integer> simpleInt;

		@Inject
		@Preference(key="simpleFloat",defaultValue="-1")
		Value<Float> simpleFloat;

		@Inject
		@Preference(key="simpleDouble",defaultValue="-1")
		Value<Double> simpleDouble;

		@Inject
		@Preference(key="simpleLong",defaultValue="-1")
		Value<Long> simpleLong;

		@Inject
		@Preference(key="simpleString",defaultValue="")
		Value<String> simpleString;
	}

	static class PropertyInject {
		@Inject
		@Preference(key="simpleBoolean")
		Property<Boolean> simpleBoolean;

		@Inject
		@Preference(key="simpleInt")
		Property<Integer> simpleInt;

		@Inject
		@Preference(key="simpleFloat")
		Property<Float> simpleFloat;

		@Inject
		@Preference(key="simpleDouble")
		Property<Double> simpleDouble;

		@Inject
		@Preference(key="simpleLong")
		Property<Long> simpleLong;

		@Inject
		@Preference(key="simpleString")
		Property<String> simpleString;
	}

	static class PropertyInjectDefaults {
		@Inject
		@Preference(key="simpleBoolean",defaultValue="true")
		Property<Boolean> simpleBoolean;

		@Inject
		@Preference(key="simpleInt",defaultValue="-1")
		Property<Integer> simpleInt;

		@Inject
		@Preference(key="simpleFloat",defaultValue="-1")
		Property<Float> simpleFloat;

		@Inject
		@Preference(key="simpleDouble",defaultValue="-1")
		Property<Double> simpleDouble;

		@Inject
		@Preference(key="simpleLong",defaultValue="-1")
		Property<Long> simpleLong;

		@Inject
		@Preference(key="simpleString",defaultValue="")
		Property<String> simpleString;
	}

	@XmlRootElement
	public static class Complex {
		private String v1;
		private int v2;

		public Complex() {

		}

		public Complex(String v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}

		public String getV1() {
			return v1;
		}
		public void setV1(String v1) {
			this.v1 = v1;
		}
		public int getV2() {
			return v2;
		}
		public void setV2(int v2) {
			this.v2 = v2;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.v1 == null) ? 0 : this.v1.hashCode());
			result = prime * result + this.v2;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Complex other = (Complex) obj;
			if (this.v1 == null) {
				if (other.v1 != null)
					return false;
			} else if (!this.v1.equals(other.v1))
				return false;
			if (this.v2 != other.v2)
				return false;
			return true;
		}

	}

	static class NonStandardTypeInject {
		@Inject
		@Preference(key="instant")
		Instant instant = Instant.now();

		@Inject
		@Preference(key="instantDefault",defaultValue="1970-01-01T00:00:00Z")
		Instant instantDefault = Instant.now();

		@Inject
		@Preference(key="instantValue")
		Value<Instant> instantValue;

		@Inject
		@Preference(key="instantValueDefault",defaultValue="1970-01-01T00:00:00Z")
		Value<Instant> instantValueDefault;

		@Inject
		@Preference(key="instantProperty")
		Property<Instant> instantProperty;

		@Inject
		@Preference(key="instantPropertyDefault",defaultValue="1970-01-01T00:00:00Z")
		Property<Instant> instantPropertyDefault;
	}

	static class ComplexTypeInject {
		private static final String DEFAULT = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<complex><v1>Sample</v1><v2>1</v2></complex>"; //$NON-NLS-1$
		private static final String MODIFIED = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<complex><v1>Modified</v1><v2>0</v2></complex>"; //$NON-NLS-1$

		@Inject
		@Preference(key="complex")
		Complex complex;

		@Inject
		@Preference(key="complexDefault",defaultValue=DEFAULT)
		Complex complexDefault;

		@Inject
		@Preference(key="complexValue")
		Value<Complex> complexValue;

		@Inject
		@Preference(key="complexValueDefault",defaultValue=DEFAULT)
		Value<Complex> complexValueDefault;

		@Inject
		@Preference(key="complexProperty")
		Property<Complex> complexProperty;

		@Inject
		@Preference(key="complexPropertyDefault",defaultValue=DEFAULT)
		Property<Complex> complexPropertyDefault;
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
	public void testValuePreferences() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		ValueInject simpleInject = ContextInjectionFactory.make(ValueInject.class, serviceContext);
		Assert.assertFalse(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(0,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(0.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(0.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(0l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertNull(simpleInject.simpleString.getValue());

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

		Assert.assertTrue(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(1,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(1.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(1.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(1l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertEquals(sValue, simpleInject.simpleString.getValue());
	}

	/**
	 *
	 */
	@Test
	public void testPropertyPreferences() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		PropertyInject simpleInject = ContextInjectionFactory.make(PropertyInject.class, serviceContext);
		Assert.assertFalse(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(0,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(0.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(0.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(0l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertNull(simpleInject.simpleString.getValue());

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

		Assert.assertTrue(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(1,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(1.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(1.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(1l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertEquals(sValue, simpleInject.simpleString.getValue());
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

	/**
	 *
	 */
	@Test
	public void testValuePreferencesDefaultValues() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		ValueInjectDefaults simpleInject = ContextInjectionFactory.make(ValueInjectDefaults.class, serviceContext);
		Assert.assertTrue(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(-1,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(-1.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(-1.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(-1l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertEquals("", simpleInject.simpleString.getValue()); //$NON-NLS-1$

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

		Assert.assertFalse(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(1,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(1.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(1.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(1l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertEquals(sValue, simpleInject.simpleString.getValue());

		simpleInject.simpleBoolean.publish(Boolean.TRUE);
		simpleInject.simpleInt.publish(Integer.valueOf(-1));
		simpleInject.simpleFloat.publish(Float.valueOf(-1f));
		simpleInject.simpleDouble.publish(Double.valueOf(-1d));
		simpleInject.simpleLong.publish(Long.valueOf(-1l));
		sValue = UUID.randomUUID().toString();
		simpleInject.simpleString.publish(sValue);

		Assert.assertTrue(node.getBoolean("simpleBoolean", false)); //$NON-NLS-1$
		Assert.assertEquals(node.getInt("simpleInt", 0),-1); //$NON-NLS-1$
		Assert.assertEquals(node.getFloat("simpleFloat", 0f),-1f,0.0); //$NON-NLS-1$
		Assert.assertEquals(node.getDouble("simpleDouble", 0d),-1d,0.0); //$NON-NLS-1$
		Assert.assertEquals(node.getLong("simpleLong", 0l),-1l); //$NON-NLS-1$
		Assert.assertEquals(node.get("simpleString", null),sValue); //$NON-NLS-1$
	}

	/**
	 *
	 */
	@Test
	public void testPropertyPreferencesDefaultValues() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		PropertyInjectDefaults simpleInject = ContextInjectionFactory.make(PropertyInjectDefaults.class, serviceContext);
		Assert.assertTrue(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(-1,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(-1.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(-1.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(-1l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertEquals("", simpleInject.simpleString.getValue()); //$NON-NLS-1$

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

		Assert.assertFalse(simpleInject.simpleBoolean.getValue().booleanValue());
		Assert.assertEquals(1,simpleInject.simpleInt.getValue().intValue());
		Assert.assertEquals(1.0f,simpleInject.simpleFloat.getValue().floatValue(),0.0);
		Assert.assertEquals(1.0d,simpleInject.simpleDouble.getValue().doubleValue(),0.0);
		Assert.assertEquals(1l,simpleInject.simpleLong.getValue().longValue());
		Assert.assertEquals(sValue, simpleInject.simpleString.getValue());

		simpleInject.simpleBoolean.setValue(Boolean.TRUE);
		simpleInject.simpleInt.setValue(Integer.valueOf(-1));
		simpleInject.simpleFloat.setValue(Float.valueOf(-1f));
		simpleInject.simpleDouble.setValue(Double.valueOf(-1d));
		simpleInject.simpleLong.setValue(Long.valueOf(-1l));
		sValue = UUID.randomUUID().toString();
		simpleInject.simpleString.setValue(sValue);

		Assert.assertTrue(node.getBoolean("simpleBoolean", false)); //$NON-NLS-1$
		Assert.assertEquals(node.getInt("simpleInt", 0),-1); //$NON-NLS-1$
		Assert.assertEquals(node.getFloat("simpleFloat", 0f),-1f,0.0); //$NON-NLS-1$
		Assert.assertEquals(node.getDouble("simpleDouble", 0d),-1d,0.0); //$NON-NLS-1$
		Assert.assertEquals(node.getLong("simpleLong", 0l),-1l); //$NON-NLS-1$
		Assert.assertEquals(node.get("simpleString", null),sValue); //$NON-NLS-1$
	}

	/**
	 *
	 */
	@Test
	public void testNonStandardType() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		NonStandardTypeInject simpleInject = ContextInjectionFactory.make(NonStandardTypeInject.class, serviceContext);

		Assert.assertNull(simpleInject.instant);
		Assert.assertNotNull(simpleInject.instantDefault);
		Assert.assertEquals(Instant.ofEpochMilli(0), simpleInject.instantDefault);

		Assert.assertNull(simpleInject.instantValue.getValue());
		Assert.assertNotNull(simpleInject.instantValueDefault.getValue());
		Assert.assertEquals(Instant.ofEpochMilli(0), simpleInject.instantValueDefault.getValue());

		Assert.assertNull(simpleInject.instantProperty.getValue());
		Assert.assertNotNull(simpleInject.instantPropertyDefault.getValue());
		Assert.assertEquals(Instant.ofEpochMilli(0), simpleInject.instantPropertyDefault.getValue());

		IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.fx.core.di.context.tests"); //$NON-NLS-1$
		Instant now = Instant.now();
		node.put("instant", now.toString()); //$NON-NLS-1$
		node.put("instantDefault", now.toString()); //$NON-NLS-1$
		node.put("instantValue", now.toString()); //$NON-NLS-1$
		node.put("instantValueDefault", now.toString()); //$NON-NLS-1$
		node.put("instantProperty", now.toString()); //$NON-NLS-1$
		node.put("instantPropertyDefault", now.toString()); //$NON-NLS-1$
		try {
			node.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(now,simpleInject.instant);
		Assert.assertEquals(now,simpleInject.instantDefault);

		Assert.assertEquals(now,simpleInject.instantValue.getValue());
		Assert.assertEquals(now,simpleInject.instantValueDefault.getValue());

		Assert.assertEquals(now,simpleInject.instantProperty.getValue());
		Assert.assertEquals(now,simpleInject.instantPropertyDefault.getValue());

		Instant instant = Instant.ofEpochMilli(100);
		simpleInject.instantValue.publish(instant);
		simpleInject.instantValueDefault.publish(instant);

		simpleInject.instantProperty.setValue(instant);
		simpleInject.instantPropertyDefault.setValue(instant);

		Assert.assertEquals(instant,Instant.parse(node.get("instantValue", null))); //$NON-NLS-1$
		Assert.assertEquals(instant,Instant.parse(node.get("instantValueDefault", null))); //$NON-NLS-1$
		Assert.assertEquals(instant,Instant.parse(node.get("instantProperty", null))); //$NON-NLS-1$
		Assert.assertEquals(instant,Instant.parse(node.get("instantPropertyDefault", null))); //$NON-NLS-1$

	}

	/**
	 *
	 */
	@Test
	public void testComplexType() {
		IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		ComplexTypeInject simpleInject = ContextInjectionFactory.make(ComplexTypeInject.class, serviceContext);

		Assert.assertNull(simpleInject.complex);
		Assert.assertNotNull(simpleInject.complexDefault);
		Assert.assertEquals(simpleInject.complexDefault, new Complex("Sample", 1)); //$NON-NLS-1$

		Assert.assertNull(simpleInject.complexValue.getValue());
		Assert.assertNotNull(simpleInject.complexValueDefault.getValue());
		Assert.assertEquals(simpleInject.complexValueDefault.getValue(), new Complex("Sample", 1)); //$NON-NLS-1$

		Assert.assertNull(simpleInject.complexProperty.getValue());
		Assert.assertNotNull(simpleInject.complexPropertyDefault.getValue());
		Assert.assertEquals(simpleInject.complexPropertyDefault.getValue(), new Complex("Sample", 1)); //$NON-NLS-1$

		IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.fx.core.di.context.tests"); //$NON-NLS-1$
		node.put("complex", ComplexTypeInject.MODIFIED); //$NON-NLS-1$
		node.put("complexDefault", ComplexTypeInject.MODIFIED); //$NON-NLS-1$
		node.put("complexValue", ComplexTypeInject.MODIFIED); //$NON-NLS-1$
		node.put("complexValueDefault", ComplexTypeInject.MODIFIED); //$NON-NLS-1$
		node.put("complexProperty", ComplexTypeInject.MODIFIED); //$NON-NLS-1$
		node.put("complexPropertyDefault", ComplexTypeInject.MODIFIED); //$NON-NLS-1$

		Complex modified = new Complex("Modified", 0); //$NON-NLS-1$

		Assert.assertNotNull(simpleInject.complex);
		Assert.assertEquals(simpleInject.complex, modified);
		Assert.assertNotNull(simpleInject.complexDefault);
		Assert.assertEquals(simpleInject.complexDefault, modified);

		Assert.assertNotNull(simpleInject.complexValue.getValue());
		Assert.assertEquals(simpleInject.complexValue.getValue(), modified);
		Assert.assertNotNull(simpleInject.complexValueDefault.getValue());
		Assert.assertEquals(simpleInject.complexValueDefault.getValue(), modified);

		Assert.assertNotNull(simpleInject.complexProperty.getValue());
		Assert.assertEquals(simpleInject.complexProperty.getValue(), modified);
		Assert.assertNotNull(simpleInject.complexPropertyDefault.getValue());
		Assert.assertEquals(simpleInject.complexPropertyDefault.getValue(), modified);

		String id = UUID.randomUUID().toString();
		modified = new Complex(id,-1);

		simpleInject.complexValue.publish(modified);
		simpleInject.complexValueDefault.publish(modified);
		simpleInject.complexProperty.setValue(modified);
		simpleInject.complexPropertyDefault.setValue(modified);

		String serialized = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<complex><v1>"+id+"</v1><v2>-1</v2></complex>"; //$NON-NLS-1$ //$NON-NLS-2$

		Assert.assertEquals(serialized.replaceAll("\\s", ""), node.get("complexValue", null).replaceAll("\\s", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		Assert.assertEquals(serialized.replaceAll("\\s", ""), node.get("complexValueDefault", null).replaceAll("\\s", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		Assert.assertEquals(serialized.replaceAll("\\s", ""), node.get("complexProperty", null).replaceAll("\\s", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		Assert.assertEquals(serialized.replaceAll("\\s", ""), node.get("complexPropertyDefault", null).replaceAll("\\s", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
}