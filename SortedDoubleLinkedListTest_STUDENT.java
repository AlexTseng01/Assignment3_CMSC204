import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedListTest_STUDENT {
	SortedDoubleLinkedList integerList;
	IntegerComparator comparator;
	
	@BeforeEach
	void setUp() throws Exception {
		comparator = new IntegerComparator();
		integerList = new SortedDoubleLinkedList<Integer>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		integerList = null;
		comparator = null;
	}

	@Test
	void testIterator() {
		integerList.add(1);
		integerList.add(5);
		integerList.add(2);
		assertTrue(integerList.iterator().hasNext());
		assertEquals(1, integerList.iterator().next());
	}

	@Test
	void testRemove() {
		integerList.add(1);
		integerList.add(5);
		integerList.add(2);
		integerList.remove(1, comparator);
		assertEquals(2, integerList.getFirst());
	}

	@Test
	void testAdd() {
		integerList.add(1);
		integerList.add(5);
		integerList.add(2);
		assertEquals(5, integerList.getLast());
		assertEquals(1, integerList.getFirst());
	}
	
	private class IntegerComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer x, Integer y) {
			return x.compareTo(y);
		}
		
	}
}
