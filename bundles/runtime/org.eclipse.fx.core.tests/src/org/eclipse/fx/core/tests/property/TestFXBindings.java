package org.eclipse.fx.core.tests.property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.bindings.FXBindings;
import org.eclipse.fx.core.bindings.FXBindings.StatusBinding;
import org.eclipse.fx.core.bindings.FXCollectors;
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
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class TestFXBindings {

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

//	@Test
//	public void testSegmentedList() {
//		ObservableList<String> source = FXCollections.observableArrayList();
//		source.addAll("A","B","C","D","E");
//		ObservableList<ObservableList<String>> segmentedList = FXBindings.segmentedList(3, source);
//
//		Assert.assertEquals(2,segmentedList.size());
//		Assert.assertEquals("A",segmentedList.get(0).get(0));
//		Assert.assertEquals("B",segmentedList.get(0).get(1));
//		Assert.assertEquals("C",segmentedList.get(0).get(2));
//		Assert.assertEquals("D",segmentedList.get(1).get(0));
//		Assert.assertEquals("E",segmentedList.get(1).get(1));
//
//		// Check replacement
//		source.set(0,"A0");
//		Assert.assertEquals("A0",segmentedList.get(0).get(0));
//		Assert.assertEquals("B",segmentedList.get(0).get(1));
//		Assert.assertEquals("C",segmentedList.get(0).get(2));
//		Assert.assertEquals("D",segmentedList.get(1).get(0));
//		Assert.assertEquals("E",segmentedList.get(1).get(1));
//
//		source.setAll("A1","B1");
//		Assert.assertEquals(1,segmentedList.size());
//		Assert.assertEquals("A1",segmentedList.get(0).get(0));
//		Assert.assertEquals("B1",segmentedList.get(0).get(1));
//
//		source.setAll("A2","B2","C2","D2","E2");
//		Assert.assertEquals(2,segmentedList.size());
//		Assert.assertEquals("A2",segmentedList.get(0).get(0));
//		Assert.assertEquals("B2",segmentedList.get(0).get(1));
//		Assert.assertEquals("C2",segmentedList.get(0).get(2));
//		Assert.assertEquals("D2",segmentedList.get(1).get(0));
//		Assert.assertEquals("E2",segmentedList.get(1).get(1));
//
//		source.clear();
//		Assert.assertEquals(0,segmentedList.size());
//
//		// Add
//		source.add("A");
//		Assert.assertEquals(1,segmentedList.size());
//		Assert.assertEquals("A",segmentedList.get(0).get(0));
//		source.addAll("B","C","D");
//		Assert.assertEquals(2,segmentedList.size());
//		Assert.assertEquals("B",segmentedList.get(0).get(1));
//		Assert.assertEquals("C",segmentedList.get(0).get(2));
//		Assert.assertEquals("D",segmentedList.get(1).get(0));
//
////		Assert.assertEquals(2,segmentedList.size());
////		source.add(0,"A00");
////		Assert.assertEquals(2,segmentedList.size());
//	}

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
		Property<String> streetProperty = FXBindings.bindStream( p ).map( o -> o.address).collect(FXCollectors.toProperty(o -> o.street));

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
	public void testCollectors() {
		Outer outer = new Outer();
		Inner inner = new Inner("Hello");
		outer.Value.set(inner);

		ObjectProperty<Outer> master = new SimpleObjectProperty<Outer>(outer);

		ObjectBinding<String> m2 = FXBindings.bindStream(master).map(o -> o.Value).map(i -> i.Value).collect(FXCollectors.toBinding());

		Assert.assertEquals(m2.get(), "Hello");
		master.set(null);
		Assert.assertNull(m2.get());

		master.set(outer);
		m2 = FXBindings.bindStream(master).map(o -> o.Value).map(i -> i.Value).collect(FXCollectors.toBinding("No Null"));
		Assert.assertEquals(m2.get(), "Hello");
		master.set(null);
		Assert.assertEquals(m2.get(),"No Null");
	}

	@Test
	public void testGC() {
		ObjectProperty<Person> p = new SimpleObjectProperty<>( new Person() );

		ObjectBinding<String> street = FXBindings.bindStream( p ).map( o -> o.address).map( o -> o.street).toBinding();
		Property<String> streetProperty = FXBindings.bindStream( p ).map( o -> o.address).collect(FXCollectors.toProperty(o -> o.street));

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
	public void testNullRoot() {
		ObjectProperty<Person> p = new SimpleObjectProperty<>( new Person() );
		p.get().address.set(new Address());
		p.get().address.get().street.set("Street");
		Property<String> streetProperty = FXBindings.bindStream( p ).map( o -> o.address).collect(FXCollectors.toProperty(o -> o.street));
		p.set(null);
		Assert.assertNull(streetProperty.getValue());

		Person p2 = new Person();
		Address a2 = new Address();
		a2.street.set("New Street");
		p2.address.set(a2);
		p.set(p2);
		Assert.assertNotNull(streetProperty.getValue());

		p2.address.set(null);
		Assert.assertNull(streetProperty.getValue());

		Address a3 = new Address();
		a3.street.set("New New Street");
		p2.address.set(a3);
		Assert.assertNotNull(streetProperty.getValue());
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
	public void testMap() {
		ObjectProperty<String> master = new SimpleObjectProperty<String>("Test");

		ObjectBinding<String> map = FXBindings.map(master, x -> "Hallo " + x);

		Assert.assertEquals("Hallo Test", map.get());

		master.set("Foo");

		Assert.assertEquals("Hallo Foo", map.get());
	}

	@Test
	public void testFlatMap() {
		Outer outer = new Outer();
		Inner inner = new Inner("Hello");
		outer.Value.set(inner);

		ObjectProperty<Outer> master = new SimpleObjectProperty<Outer>(outer);

		ObjectBinding<Inner> m1 = FXBindings.flatMap(master, o -> o.Value);
		ObjectBinding<String> m2 = FXBindings.flatMap(m1, i -> i.Value);


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

	private static interface ChangeTest<T> {
		void test(Change<? extends T> change);
	}
	private static class RemoveAdd<T> implements ChangeTest<T> {
		private T[] added;
		private T[] removed;
		private int from;

		public RemoveAdd(T[] removed, T[] added, int from) {
			this.added = added;
			this.removed = removed;
			this.from = from;
		}

		@Override
		public void test(Change<? extends T> change) {
			Assert.assertEquals(added.length > 0, change.wasAdded());
			Assert.assertEquals(removed.length > 0, change.wasRemoved());
			Assert.assertEquals(from, change.getFrom());
			Assert.assertArrayEquals(added, change.getAddedSubList().toArray());
			Assert.assertArrayEquals(removed, change.getRemoved().toArray());
		}

	}

	private <T> void assertChange(List<Change<? extends T>> actual, ChangeTest<T>... expected) {
		Assert.assertEquals(expected.length, actual.size());
		int idx = 0;
		for (Change<? extends T> c : actual) {
			c.reset();
			c.next();
			expected[idx].test(c);
			idx++;
		}
		actual.clear();
	}

	@Test
	public void testConcat() {

		ObservableList<String> l0 = FXCollections.observableArrayList();
		ObservableList<String> l1 = FXCollections.observableArrayList();
		ObservableList<String> l2 = FXCollections.observableArrayList();

		ListBinding<String> concat = FXBindings.concat(l0, l1, l2);

		List<Change<? extends String>> curChange = new ArrayList<>();
		ListChangeListener<String> l = c -> {
			curChange.add(c);
			c.next();
			System.err.println("Removed: " + c.getRemoved());
			System.err.println("Added: " + c.getAddedSubList());
		};
		concat.addListener(l);


		Assert.assertEquals(0, concat.size());

		l1.add("Hello");

		Assert.assertArrayEquals(new String[] {
				"Hello"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] {}, new String[] { "Hello" }, 0));


		l2.add("World");

		Assert.assertArrayEquals(new String[] {
				"Hello",
				"World"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] {}, new String[] { "World" }, 1));

		l0.add("yay");

		Assert.assertArrayEquals(new String[] {
				"yay",
				"Hello",
				"World"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] {}, new String[] { "yay" }, 0));

		l0.add("!!!");

		System.gc();

		Assert.assertArrayEquals(new String[] {
				"yay",
				"!!!",
				"Hello",
				"World"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] {}, new String[] { "!!!" }, 1));

		l0.remove("!!!");

		Assert.assertArrayEquals(new String[] {
				"yay",
				"Hello",
				"World"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { "!!!" }, new String[] { }, 1));

		l0.remove("yay");

		Assert.assertArrayEquals(new String[] {
				"Hello",
				"World"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { "yay" }, new String[] { }, 0));

		l2.remove("World");

		Assert.assertArrayEquals(new String[] {
				"Hello"
		}, concat.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { "World" }, new String[] { }, 1));

		l1.remove("Hello");

		Assert.assertEquals(0, concat.size());
		assertChange(curChange, new RemoveAdd<String>(new String[] { "Hello" }, new String[] { }, 0));
	}

	@Test
	public void testConcatChangeEvents() {
		ObservableList<String> l0 = FXCollections.observableArrayList("A","B","C");
		ObservableList<String> l1 = FXCollections.observableArrayList("E","F","G");
		ObservableList<String> l2 = FXCollections.observableArrayList("I","J","K");

		ObservableList<String> concat = FXBindings.concatenatedList(l0, l1, l2);

		AtomicInteger totalEventCount = new AtomicInteger();
		AtomicInteger changeCount = new AtomicInteger();
		AtomicBoolean addCount = new AtomicBoolean();
		AtomicBoolean removeCount = new AtomicBoolean();

		concat.addListener( (Change<? extends String> c) -> {
			totalEventCount.incrementAndGet();
			changeCount.set(0);
			while( c.next() ) {
				changeCount.incrementAndGet();
				addCount.set(c.wasAdded());
				removeCount.set(c.wasRemoved());
			}
		});

		l0.add(3, "D");
		Assert.assertEquals(1, changeCount.get());
		Assert.assertTrue(addCount.get());
		Assert.assertFalse(removeCount.get());

		l0.remove("D");
		Assert.assertEquals(1, changeCount.get());
		Assert.assertFalse(addCount.get());
		Assert.assertTrue(removeCount.get());

		l0.addAll(3, Arrays.asList("D", "D2"));
		Assert.assertEquals(1, changeCount.get());
		Assert.assertTrue(addCount.get());
		Assert.assertFalse(removeCount.get());

		l0.removeAll("D","D2");
		Assert.assertEquals(1, changeCount.get());
		Assert.assertFalse(addCount.get());
		Assert.assertTrue(removeCount.get());

		l1.add(3,"H");
		Assert.assertEquals(1, changeCount.get());
		Assert.assertTrue(addCount.get());
		Assert.assertFalse(removeCount.get());

		l1.remove("H");
		Assert.assertEquals(1, changeCount.get());
		Assert.assertFalse(addCount.get());
		Assert.assertTrue(removeCount.get());

		totalEventCount.set(0);
		l0.setAll("C","B","A");
		Assert.assertEquals(2, totalEventCount.get()); // TODO Not ideal but currently no better solution

//		ObservableList<String> list = FXCollections.observableArrayList("A","B","C");
//		list.addListener( (Change<? extends String> c) -> {
//			while( c.next() ) {
//				System.err.println(c.getAddedSubList());
//				System.err.println(c.getRemoved());
//			}
//		} );
//		list.setAll("B","A","C");
	}

	@Test
	public void testMapList() {
		ObservableList<String> source = FXCollections.observableArrayList("one", "two", "three");

		ListBinding<String> result = FXBindings.mapList(source, s -> s + " apples");

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

		List<Change<? extends String>> curChange = new ArrayList<>();
		ListChangeListener<String> l = c -> {
			curChange.add(c);
			c.next();
			System.err.println("Removed: " + c.getRemoved());
			System.err.println("Added: " + c.getAddedSubList());
		};
		flatMap.addListener(l);

		Assert.assertArrayEquals(new String[] {
				"1", "2", "3", "a", "b", "c"
			}, flatMap.toArray());

		two.add("two");

		Assert.assertArrayEquals(new String[] {
			"1", "2", "3", "two", "a", "b", "c"
		}, flatMap.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { }, new String[] { "two" }, 3));


		one.set(1, "xx");

		Assert.assertArrayEquals(new String[] {
			"1", "xx", "3", "two", "a", "b", "c"
		}, flatMap.toArray());
		System.err.println(curChange);
		assertChange(curChange,
				new RemoveAdd<String>(new String[] {"2"}, new String[]{ }, 1),
				new RemoveAdd<String>(new String[] { }, new String[] { "xx" }, 1));


		three.remove(1);

		Assert.assertArrayEquals(new String[] {
			"1", "xx", "3", "two", "a", "c"
		}, flatMap.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { "b" }, new String[] { }, 5));

		source.remove(one);

		Assert.assertArrayEquals(new String[] {
			"two", "a", "c"
		}, flatMap.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { "1", "xx", "3" }, new String[] { }, 0));

		one.add("offline");

		Assert.assertArrayEquals(new String[] {
			"two", "a", "c"
		}, flatMap.toArray());
		Assert.assertEquals(0, curChange.size());

		source.add(one);

		Assert.assertArrayEquals(new String[] {
			"two", "a", "c", "1", "xx", "3", "offline"
		}, flatMap.toArray());
		assertChange(curChange, new RemoveAdd<String>(new String[] { }, new String[] { "1", "xx", "3", "offline"}, 3));
	}

	@Test
	public void testFlatMapListValue() {

		StringProperty a = new SimpleStringProperty("a");
		StringProperty b = new SimpleStringProperty("b");
		StringProperty c = new SimpleStringProperty("c");

		ObservableList<ObservableValue<String>> source = FXCollections.observableArrayList(a, b, c);

		ListBinding<String> flatMap = FXBindings.flatMapListValue(source, x->x);


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
	public void testBindContent() {
		List<String> target = new ArrayList<>();
		ObservableList<Integer> sourceList = FXCollections.observableArrayList(1);
		FXBindings.bindContent(target, sourceList,  i -> ""+i);
		sourceList.remove(0);
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

	@Test
	public void testBindBidirectional() {

		Property<String> s = new SimpleStringProperty("99");
		Property<Integer> i = new SimpleObjectProperty<Integer>();

		StatusBinding binding = FXBindings.bindBidirectional(i, s, Integer.class, String.class);

		Assert.assertEquals(99, i.getValue().intValue());
		Assert.assertEquals(State.OK, binding.getValue().getState());

		s.setValue("100");
		Assert.assertEquals(100, i.getValue().intValue());
		Assert.assertEquals(State.OK, binding.getValue().getState());

		s.setValue("abcd");
		Assert.assertEquals(100, i.getValue().intValue());
		Assert.assertEquals(State.ERROR, binding.getValue().getState());

		s.setValue("101");
		Assert.assertEquals(101, i.getValue().intValue());
		Assert.assertEquals(State.OK, binding.getValue().getState());

	}
}