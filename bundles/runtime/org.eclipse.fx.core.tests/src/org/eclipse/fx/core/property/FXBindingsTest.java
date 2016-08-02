package org.eclipse.fx.core.property;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.bindings.FXBindings;
import org.junit.Assert;
import org.junit.Test;

import javafx.beans.binding.ListBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class FXBindingsTest {

	public static class Inner {
		public final StringProperty Value;

		public Inner(String blub) {
			this.Value = new SimpleStringProperty(blub);
		}
	}

	public static class Outer {
		public ObjectProperty<Inner> Value = new SimpleObjectProperty<>();
	}

	public static class Person {
		private static int i;
		private final StringProperty name;
		private ObjectProperty<Address> address = new SimpleObjectProperty<>();

		public Person() {
			this.name = new SimpleStringProperty(this, "name", i++ + "");
		}

		public Person(String name) {
			this.name = new SimpleStringProperty(this, "name", name);
		}
	}

	public static class Address {
		private StringProperty street = new SimpleStringProperty();
	}

	@Test
	public void testBindStream() {
		Outer outer = new Outer();
		Inner inner = new Inner("Hello");
		outer.Value.set(inner);

		ObjectProperty<Outer> master = new SimpleObjectProperty<Outer>(outer);

		ObjectBinding<String> m2 = FXBindings.bindStream(master).map(o -> o.Value).map(i -> i.Value).toBinding();

		Assert.assertEquals("Hello", m2.get());

		inner.Value.set("test1");

		Assert.assertEquals("test1", m2.get());

		Inner inner2 = new Inner("test2");
		outer.Value.set(inner2);

		Assert.assertEquals("test2", m2.get());

		Outer outer2 = new Outer();
		Inner inner3 = new Inner("test3");
		outer2.Value.set(inner3);
		master.set(outer2);

		Assert.assertEquals("test3", m2.get());

		ObjectProperty<Person> p = new SimpleObjectProperty<>( new Person() );

		ObjectBinding<String> street = FXBindings.bindStream( p ).map( o -> o.address).map( o -> o.street).toBinding();
		Property<String> streetProperty = FXBindings.bindStream( p ).map( o -> o.address).toProperty( o -> o.street);

		Assert.assertNull(street.get());
		Address a = new Address();
		p.get().address.set(a);
		Assert.assertNull(street.get());
		p.get().address.get().street.set("Test");
		Assert.assertEquals("Test",street.get());
		Assert.assertEquals("Test",streetProperty.getValue());
		streetProperty.setValue("Super geil 1");
		Assert.assertEquals("Super geil 1",street.get());

		Address a2 = new Address();
		a2.street.set("Bla");
		p.get().address.set(a2);
		Assert.assertEquals("Bla",street.get());

		streetProperty.setValue("Super geil 2");
		Assert.assertEquals("Super geil 2",street.get());

		Assert.assertEquals(a.street.get(), "Super geil 1");
		Assert.assertEquals(a2.street.get(), "Super geil 2");


		StringProperty uiProp = new SimpleStringProperty();
		uiProp.bindBidirectional(streetProperty);
		Assert.assertEquals("Super geil 2", uiProp.get());
		streetProperty.setValue("ui value");
		Assert.assertEquals("ui value", uiProp.get());
		uiProp.set("back to model");
		Assert.assertEquals("back to model", a2.street.get());
	}

	@Test
	public void testGC() {
		ObjectProperty<Person> p = new SimpleObjectProperty<>( new Person() );

		ObjectBinding<String> street = FXBindings.bindStream( p ).map( o -> o.address).map( o -> o.street).toBinding();
		Property<String> streetProperty = FXBindings.bindStream( p ).map( o -> o.address).toProperty( o -> o.street);

		System.gc();

		Assert.assertNull(street.get());
		Address a = new Address();
		p.get().address.set(a);
		Assert.assertNull(street.get());
		p.get().address.get().street.set("Test");
		Assert.assertEquals("Test",street.get());
		Assert.assertEquals("Test",streetProperty.getValue());
		streetProperty.setValue("Super geil 1");
		Assert.assertEquals("Super geil 1",street.get());
	}

	@Test
	public void testHop0() {
		ObjectProperty<Person> currentPerson = new SimpleObjectProperty<>();

		ObjectBinding<Person> binding = FXBindings.bindStream(currentPerson).toBinding();
		Assert.assertNull(binding.get());
		Person p1 = new Person();
		currentPerson.set(p1);
		Assert.assertSame(p1,binding.get());

		Person p2 = new Person();
		currentPerson.set(p2);
		Assert.assertSame(p2,binding.get());
	}

	@Test
	public void testListenerInit() {
		ObjectProperty<Person> currentPerson = new SimpleObjectProperty<>();

		ObjectBinding<Person> binding = FXBindings.bindStream(currentPerson).toBinding();
		AtomicInteger i = new AtomicInteger();
		binding.addListener( o -> {
			i.incrementAndGet();
		});

		Assert.assertEquals(0, i.get());
		Person p1 = new Person();
		currentPerson.set(p1);
		Assert.assertEquals(1, i.get());
	}

	@Test
	public void testListenerInitComplex() {
		ObjectProperty<Person> currentPerson = new SimpleObjectProperty<>();

		ObjectBinding<Address> binding = FXBindings.bindStream(currentPerson).map( p -> p.address).toBinding();
		AtomicInteger i = new AtomicInteger();
		binding.addListener( o -> {
			i.incrementAndGet();
		});

		Assert.assertEquals(0, i.get());
		Person p1 = new Person();
		currentPerson.set(p1);
		Assert.assertEquals(1, i.get());
	}

	@Test
	public void testMapObject() {
		Outer outer = new Outer();
		Inner inner = new Inner("Hello");
		outer.Value.set(inner);

		ObjectProperty<Outer> master = new SimpleObjectProperty<Outer>(outer);

		ObjectBinding<Inner> m1 = FXBindings.map(master, o -> o.Value);
		ObjectBinding<String> m2 = FXBindings.map(m1, i -> i.Value);


		Assert.assertEquals("Hello", m2.get());

		inner.Value.set("test1");

		Assert.assertEquals("test1", m2.get());

		Inner inner2 = new Inner("test2");
		outer.Value.set(inner2);

		Assert.assertEquals("test2", m2.get());

		Outer outer2 = new Outer();
		Inner inner3 = new Inner("test3");
		outer2.Value.set(inner3);
		master.set(outer2);

		Assert.assertEquals("test3", m2.get());

	}

	@Test
	public void testConcat() {

		ObservableList<String> l0 = FXCollections.observableArrayList();
		ObservableList<String> l1 = FXCollections.observableArrayList();
		ObservableList<String> l2 = FXCollections.observableArrayList();

		ListBinding<String> concat = FXBindings.concat(l0, l1, l2);

		Assert.assertEquals(0, concat.size());

		l1.add("Hello");

		Assert.assertArrayEquals(new String[] {
				"Hello"
		}, concat.toArray());

		l2.add("World");

		Assert.assertArrayEquals(new String[] {
				"Hello",
				"World"
		}, concat.toArray());

		l0.add("yay");

		Assert.assertArrayEquals(new String[] {
				"yay",
				"Hello",
				"World"
		}, concat.toArray());

		l0.add("!!!");

		Assert.assertArrayEquals(new String[] {
				"yay",
				"!!!",
				"Hello",
				"World"
		}, concat.toArray());

		l0.remove("!!!");

		Assert.assertArrayEquals(new String[] {
				"yay",
				"Hello",
				"World"
		}, concat.toArray());

		l0.remove("yay");

		Assert.assertArrayEquals(new String[] {
				"Hello",
				"World"
		}, concat.toArray());

		l2.remove("World");

		Assert.assertArrayEquals(new String[] {
				"Hello"
		}, concat.toArray());

		l1.remove("Hello");

		Assert.assertEquals(0, concat.size());
	}

	@Test
	public void testMap() {
		ObservableList<String> source = FXCollections.observableArrayList("one", "two", "three");

		ListBinding<String> result = FXBindings.map(source, s -> s + " apples");

		Assert.assertArrayEquals(new String[] {
				"one apples",
				"two apples",
				"three apples"
		}, result.toArray());

		source.set(1, "99");

		Assert.assertArrayEquals(new String[] {
				"one apples",
				"99 apples",
				"three apples"
		}, result.toArray());

		source.add("another");

		Assert.assertArrayEquals(new String[] {
				"one apples",
				"99 apples",
				"three apples",
				"another apples"
		}, result.toArray());

		source.remove("one");

		Assert.assertArrayEquals(new String[] {
				"99 apples",
				"three apples",
				"another apples"
		}, result.toArray());
	}

	@Test
	public void testFlatMapList() {

		ObservableList<String> one = FXCollections.observableArrayList("1", "2", "3");
		ObservableList<String> two = FXCollections.observableArrayList();
		ObservableList<String> three = FXCollections.observableArrayList("a", "b", "c");

		ObservableList<ObservableList<String>> source = FXCollections.observableArrayList(one, two, three);

		ListBinding<String> flatMap = FXBindings.flatMapList(source, x->x);

		Assert.assertArrayEquals(new String[] {
				"1", "2", "3", "a", "b", "c"
			}, flatMap.toArray());

		two.add("two");

		Assert.assertArrayEquals(new String[] {
			"1", "2", "3", "two", "a", "b", "c"
		}, flatMap.toArray());

		one.set(1, "xx");

		Assert.assertArrayEquals(new String[] {
			"1", "xx", "3", "two", "a", "b", "c"
		}, flatMap.toArray());

		three.remove(1);

		Assert.assertArrayEquals(new String[] {
			"1", "xx", "3", "two", "a", "c"
		}, flatMap.toArray());

		source.remove(one);

		Assert.assertArrayEquals(new String[] {
			"two", "a", "c"
		}, flatMap.toArray());


		one.add("offline");

		Assert.assertArrayEquals(new String[] {
			"two", "a", "c"
		}, flatMap.toArray());

		source.add(one);

		Assert.assertArrayEquals(new String[] {
			"two", "a", "c", "1", "xx", "3", "offline"
		}, flatMap.toArray());

	}

	@Test
	public void testFlatMapValue() {

		StringProperty a = new SimpleStringProperty("a");
		StringProperty b = new SimpleStringProperty("b");
		StringProperty c = new SimpleStringProperty("c");

		ObservableList<ObservableValue<String>> source = FXCollections.observableArrayList(a, b, c);

		ListBinding<String> flatMap = FXBindings.flatMapValue(source, x->x);


		Assert.assertArrayEquals(new String[] {
			"a", "b", "c"
		}, flatMap.toArray());

		source.remove(b);

		Assert.assertArrayEquals(new String[] {
			"a", "c"
		}, flatMap.toArray());

		b.set("B");

		Assert.assertArrayEquals(new String[] {
			"a", "c"
		}, flatMap.toArray());

		source.add(b);

		Assert.assertArrayEquals(new String[] {
			"a", "c", "B"
		}, flatMap.toArray());

		a.set("A");

		Assert.assertArrayEquals(new String[] {
			"A", "c", "B"
		}, flatMap.toArray());
	}


	@Test
	public void testBindingPaddedContent() {
		List<String> target = new ArrayList<>();
		ObservableList<Integer> sourceList = FXCollections.observableArrayList(1,2,3);
		Subscription binding = FXBindings.bindContent(1, target, sourceList, o -> "Converted " + o, i -> "Pad " + i);
		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 1, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 3, target.get(3));

//		binding.setPadding(0);
//		Assert.assertEquals(3, target.size());
//		Assert.assertEquals("Converted " + 1, target.get(0));
//		Assert.assertEquals("Converted " + 2, target.get(1));
//		Assert.assertEquals("Converted " + 3, target.get(2));
//
//		binding.setPadding(1);
//
//		Assert.assertEquals(4, target.size());
//		Assert.assertEquals("Pad " + 0, target.get(0));
//		Assert.assertEquals("Converted " + 1, target.get(1));
//		Assert.assertEquals("Converted " + 2, target.get(2));
//		Assert.assertEquals("Converted " + 3, target.get(3));
//
//		binding.setPadding(2);
//
//		Assert.assertEquals(5, target.size());
//		Assert.assertEquals("Pad " + 0, target.get(0));
//		Assert.assertEquals("Pad " + 1, target.get(1));
//		Assert.assertEquals("Converted " + 1, target.get(2));
//		Assert.assertEquals("Converted " + 2, target.get(3));
//		Assert.assertEquals("Converted " + 3, target.get(4));
	}

	@Test
	public void testBindingPaddedContent_AddRemove() {
		List<String> target = new ArrayList<>();
		ObservableList<Integer> sourceList = FXCollections.observableArrayList(1,2,3);
		Subscription binding = FXBindings.bindContent(1, target, sourceList, o -> "Converted " + o, i -> "Pad " + i);
		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 1, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 3, target.get(3));

		sourceList.add(0,0);

		Assert.assertEquals(5, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 0, target.get(1));
		Assert.assertEquals("Converted " + 1, target.get(2));
		Assert.assertEquals("Converted " + 2, target.get(3));
		Assert.assertEquals("Converted " + 3, target.get(4));

		sourceList.remove(0);

		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 1, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 3, target.get(3));
	}

	@Test
	public void testBindingPaddedContent_Permutate() {
		List<String> target = new ArrayList<>();
		SortedList<Integer> sourceList = FXCollections.observableArrayList(1,2,3).sorted((i1, i2) -> {
			return Integer.compare(i1, i2) * -1;
		});
		Subscription binding = FXBindings.bindContent(1, target, sourceList, o -> "Converted " + o, i -> "Pad " + i);

		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 3, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 1, target.get(3));

		sourceList.setComparator( ( i1, i2 ) -> Integer.compare(i1, i2) );

		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 1, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 3, target.get(3));
	}
}