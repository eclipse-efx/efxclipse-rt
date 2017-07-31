package org.eclipse.fx.osgi.util.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.MementoStore;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.fx.core.ServiceUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestMementoStore {
	@Test
	public void testAvailable() {
		Assert.assertNotNull(ServiceUtils.getService(MementoStore.class));
	}
	
	@Test
	public void testPrimitives() {
		MementoStore store = ServiceUtils.getService(MementoStore.class).get();
		
		String path = UUID.randomUUID().toString();
		
		String stringValue = UUID.randomUUID().toString();
		double doubleValue = new Random().nextDouble();
		int intValue = new Random().nextInt();
		boolean booleanValue = new Random().nextBoolean();
		
		Memento memento = store.getMemento(path);
		memento.put("string-test", stringValue);
		memento.put("double-test", doubleValue);
		memento.put("int-test", intValue);
		memento.put("boolean-test", booleanValue);
		
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(path);
		Assert.assertEquals(stringValue, node.get("string-test", null));
		Assert.assertEquals(doubleValue, node.getDouble("double-test", 0.0),0.0);
		Assert.assertEquals(intValue, node.getInt("int-test", 0));
		Assert.assertEquals(booleanValue, node.getBoolean("boolean-test", ! booleanValue));
		
		Assert.assertEquals(stringValue, memento.get("string-test", (String)null));
		Assert.assertEquals(doubleValue, memento.get("double-test", 0.0),0.0);
		Assert.assertEquals(intValue, memento.get("int-test", 0));
		Assert.assertEquals(booleanValue, memento.get("boolean-test", ! booleanValue));
	}
	
	@Test
	public void testStoreComplex() {
		MementoStore store = ServiceUtils.getService(MementoStore.class).get();
		
		String path = UUID.randomUUID().toString();
		
		Memento memento = store.getMemento(path);
		
		ArrayList<String> l = new ArrayList<>();
		l.add("Value 1");
		l.add("Value 2");
		memento.put("test-value", l, ObjectSerializer.JAXB_SERIALIZER);
		
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(path);
		String serialized = node.get("test-value", null);
		Assert.assertNotNull(serialized);
		
		List<?> list = memento.get("test-value", List.class, null);
		Assert.assertNotNull(list);
		Assert.assertEquals(l, list);
	}
}