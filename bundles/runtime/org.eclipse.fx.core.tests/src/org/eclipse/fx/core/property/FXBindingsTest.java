package org.eclipse.fx.core.property;

import org.eclipse.fx.core.bindings.FXBindings;
import org.junit.Assert;
import org.junit.Test;

import javafx.beans.binding.ListBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FXBindingsTest {

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

}