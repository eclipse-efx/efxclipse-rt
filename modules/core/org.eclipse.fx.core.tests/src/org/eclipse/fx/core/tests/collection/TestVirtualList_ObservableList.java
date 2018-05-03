package org.eclipse.fx.core.tests.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.fx.core.collection.IndexRangeView;
import org.eclipse.fx.core.collection.IndexView;
import org.eclipse.fx.core.collection.VirtualList;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;

public class TestVirtualList_ObservableList {
	@Test
	public void create() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		assertNotNull(VirtualList.of(list));
	}

	@Test
	public void get() {
		VirtualList<String> vl = VirtualList.of(FXCollections.observableArrayList("A", "B", "C"));
		assertEquals("A", vl.get(0));
		assertEquals("B", vl.get(1));
		assertEquals("C", vl.get(2));
	}

	@Test
	public void length() {
		ObservableList<String> l = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> vl = VirtualList.of(l);
		assertEquals(3, vl.length().get());

		// increase
		l.add("D");
		assertEquals(4, vl.length().get());

		AtomicBoolean i = new AtomicBoolean();
		FXObservableUtil.onChange(vl.length(), c -> {
			assertEquals(5L, c.longValue());
			i.set(true);
		});
		l.add("E");
		assertEquals(5, vl.length().get());
		assertTrue(i.get());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void tooLargeIndex() {
		VirtualList.of(FXCollections.observableArrayList("A", "B", "C")).get(3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void tooLowIndex() {
		VirtualList.of(FXCollections.observableArrayList("A", "B", "C")).get(-1);
	}

	@Test
	public void indexView() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexView<String> view = virtualList.getView(0);
		assertNotNull(view);
		assertEquals(0l, view.index().get());
		assertEquals("A", view.get());
	}

	@Test
	public void indexViewOutOfRange() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexView<String> view = virtualList.getView(3);
		assertNotNull(view);
		assertEquals(3l, view.index().get());
		assertNull(view.get());
	}

	@Test
	public void indexViewAddAtIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(0);
		view.addListener((ob, ol, ne) -> {
			assertEquals(ol, "A");
			assertEquals(ne, "A0");
			i.set(true);
		});

		list.add(0, "A0");
		assertTrue(i.get());
		assertEquals("A0", view.get());
	}

	@Test
	public void indexViewAddBeforeIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(1);
		view.addListener((ob, ol, ne) -> {
			assertEquals(ol, "B");
			assertEquals(ne, "A");
			i.set(true);
		});

		list.add(0, "A0");
		assertTrue(i.get());
		assertEquals("A", view.get());
	}

	@Test
	public void indexViewAddAfterIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(0);
		view.addListener((ob, ol, ne) -> {
			i.set(true);
		});

		list.add(1, "A0");
		assertFalse(i.get());
	}

	@Test
	public void indexViewMoveByPositive() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean changeTracker = new AtomicBoolean();
		AtomicBoolean indexTracker = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(0);
		view.addListener((ob, ol, ne) -> {
			assertEquals(ol, "A");
			assertEquals(ne, "B");
			changeTracker.set(true);
		});
		view.index().addListener((ob, ol, ne) -> {
			assertEquals(0l, ol.longValue());
			assertEquals(1l, ne.longValue());
			indexTracker.set(true);
		});
		view.moveBy(1);
		assertTrue(changeTracker.get());
		assertTrue(indexTracker.get());
		assertEquals("B", view.get());
	}

	@Test
	public void indexViewMoveOutOfRange() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean changeTracker = new AtomicBoolean();
		AtomicBoolean indexTracker = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(0);
		view.addListener((ob, ol, ne) -> {
			assertEquals(ol, "A");
			assertNull(ne);
			changeTracker.set(true);
		});
		view.index().addListener((ob, ol, ne) -> {
			assertEquals(0l, ol.longValue());
			assertEquals(3l, ne.longValue());
			indexTracker.set(true);
		});
		view.moveBy(3);
		assertTrue(changeTracker.get());
		assertNull(view.get());
	}

	@Test
	public void indexViewMoveByNegative() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean changeTracker = new AtomicBoolean();
		AtomicBoolean indexTracker = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(1);
		view.addListener((ob, ol, ne) -> {
			assertEquals(ol, "B");
			assertEquals(ne, "A");
			changeTracker.set(true);
		});
		view.index().addListener((ob, ol, ne) -> {
			assertEquals(1l, ol.longValue());
			assertEquals(0l, ne.longValue());
			indexTracker.set(true);
		});
		view.moveBy(-1);
		assertTrue(changeTracker.get());
		assertEquals("A", view.get());
	}

	@Test
	public void indexViewGetIntoRangeExact() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(3);
		view.addListener((ob, ol, ne) -> {
			assertNull(ol);
			assertEquals(ne, "D");
			i.set(true);
		});
		list.add("D");
		assertEquals("D", view.get());
	}

	@Test
	public void indexViewGetIntoRange() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexView<String> view = virtualList.getView(3);
		view.addListener((ob, ol, ne) -> {
			assertNull(ol);
			assertEquals(ne, "C");
			i.set(true);
		});
		list.add(0, "A0");
		assertEquals("C", view.get());
	}

	@Test
	public void indexRangeView() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexRangeView<String> view = virtualList.getView(1, 2);
		assertNotNull(view);
		assertEquals(2l, view.length().get());
		assertEquals(1l, view.startIndex().get());
		assertEquals(2l, view.endIndex().get());
		assertEquals("B", view.get(0));
		assertEquals("C", view.get(1));
	}

	@Test
	public void indexRangeViewOutOfRange() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexRangeView<String> view = virtualList.getView(2, 3);
		assertNotNull(view);
		assertEquals(3l, view.length().get());
		assertEquals(2l, view.startIndex().get());
		assertEquals(4l, view.endIndex().get());
		assertEquals("C", view.get(0));
		assertEquals("D", view.get(1));
		assertNull(view.get(2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexRangeViewOutOfRangeToLargeIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexRangeView<String> view = virtualList.getView(2, 3);
		assertNotNull(view);
		assertEquals(3l, view.length().get());
		assertEquals(2l, view.startIndex().get());
		assertEquals(4l, view.endIndex().get());
		assertEquals("C", view.get(0));
		assertEquals("D", view.get(1));
		assertNull(view.get(2));
		view.get(3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexRangeViewTooLowIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexRangeView<String> view = virtualList.getView(1, 2);
		view.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexRangeViewTooLargeIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
		VirtualList<String> virtualList = VirtualList.of(list);

		IndexRangeView<String> view = virtualList.getView(1, 2);
		view.get(2);
	}
	
	@Test
	public void indexRangeViewAddAtIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(0,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});

		list.add(0, "A0");
		assertTrue(i.get());
		assertEquals(0, view.startIndex().get());
		assertEquals(1, view.endIndex().get());
		assertEquals("A0", view.get(0));
		assertEquals("A", view.get(1));
	}
	
	@Test
	public void indexRangeViewAddBeforeIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(1,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});

		assertEquals("B", view.get(0));
		assertEquals("C", view.get(1));
		list.add(0, "A0");
		assertTrue(i.get());
		assertEquals(1, view.startIndex().get());
		assertEquals(2, view.endIndex().get());
		assertEquals("A", view.get(0));
		assertEquals("B", view.get(1));
	}
	
	@Test
	public void indexRangeViewAddAfterIndex() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);

		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(1,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});

		assertEquals("B", view.get(0));
		assertEquals("C", view.get(1));
		list.add(3, "A0");
		assertFalse(i.get());
		assertEquals(1, view.startIndex().get());
		assertEquals(2, view.endIndex().get());
		assertEquals("B", view.get(0));
		assertEquals("C", view.get(1));
	}
	
	@Test
	public void indexRangeViewMoveByPositive() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);
		
		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(0,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});
		
		view.moveBy(1);
		assertTrue(i.get());
		assertEquals(1, view.startIndex().get());
		assertEquals(2, view.endIndex().get());
		assertEquals("B", view.get(0));
		assertEquals("C", view.get(1));
	}
	
	@Test
	public void indexRangeViewMoveByNegative() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);
		
		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(1,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});
		
		view.moveBy(-1);
		assertTrue(i.get());
		assertEquals(0, view.startIndex().get());
		assertEquals(1, view.endIndex().get());
		assertEquals("A", view.get(0));
		assertEquals("B", view.get(1));
	}
	
	@Test
	public void indexRangeViewMoveOutOfRange() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);
		
		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(0,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});
		
		view.moveBy(3);
		assertTrue(i.get());
		assertEquals(3, view.startIndex().get());
		assertEquals(4, view.endIndex().get());
		assertNull(view.get(0));
		assertNull(view.get(1));
	}
	
	@Test
	public void indexRangeViewShrink() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);
		
		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(0,3);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});
		
		view.shrinkBy(1);
		assertTrue(i.get());
		assertEquals(0, view.startIndex().get());
		assertEquals(1, view.endIndex().get());
		assertEquals("A",view.get(0));
		assertEquals("B", view.get(1));
	}
	
	@Test
	public void indexRangeViewGrow() {
		ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");
		VirtualList<String> virtualList = VirtualList.of(list);
		
		AtomicBoolean i = new AtomicBoolean();
		IndexRangeView<String> view = virtualList.getView(0,2);
		view.addListener((Change<? extends String> c) -> {
			i.set(true); 
		});
		
		view.growBy(1);
		assertTrue(i.get());
		assertEquals(0, view.startIndex().get());
		assertEquals(2, view.endIndex().get());
		assertEquals("A",view.get(0));
		assertEquals("B", view.get(1));
		assertEquals("C", view.get(2));
	}
}
