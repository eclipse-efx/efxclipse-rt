package org.eclipse.fx.core.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.core.property.FXObservableUtils;
import org.eclipse.fx.core.property.FXObservableUtils.PaddedListBinding;
import org.junit.Assert;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;


public class FXObservableUtilsTest {
	@Test
	public void testBindingPaddedContent() {
		List<String> target = new ArrayList<>();
		ObservableList<Integer> sourceList = FXCollections.observableArrayList(1,2,3);
		PaddedListBinding<String,Integer> binding = FXObservableUtils.bindContent(1, target, sourceList, o -> "Converted " + o, i -> "Pad " + i);
		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 1, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 3, target.get(3));

		binding.setPadding(0);
		Assert.assertEquals(3, target.size());
		Assert.assertEquals("Converted " + 1, target.get(0));
		Assert.assertEquals("Converted " + 2, target.get(1));
		Assert.assertEquals("Converted " + 3, target.get(2));

		binding.setPadding(1);

		Assert.assertEquals(4, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Converted " + 1, target.get(1));
		Assert.assertEquals("Converted " + 2, target.get(2));
		Assert.assertEquals("Converted " + 3, target.get(3));

		binding.setPadding(2);

		Assert.assertEquals(5, target.size());
		Assert.assertEquals("Pad " + 0, target.get(0));
		Assert.assertEquals("Pad " + 1, target.get(1));
		Assert.assertEquals("Converted " + 1, target.get(2));
		Assert.assertEquals("Converted " + 2, target.get(3));
		Assert.assertEquals("Converted " + 3, target.get(4));
	}

	@Test
	public void testBindingPaddedContent_AddRemove() {
		List<String> target = new ArrayList<>();
		ObservableList<Integer> sourceList = FXCollections.observableArrayList(1,2,3);
		PaddedListBinding<String,Integer> binding = FXObservableUtils.bindContent(1, target, sourceList, o -> "Converted " + o, i -> "Pad " + i);
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
		PaddedListBinding<String,Integer> binding = FXObservableUtils.bindContent(1, target, sourceList, o -> "Converted " + o, i -> "Pad " + i);

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
