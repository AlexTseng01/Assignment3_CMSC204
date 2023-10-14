import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList integerList;
	IntegerComparator comparator;
	
	@BeforeEach
	void setUp() throws Exception {
		integerList = new BasicDoubleLinkedList<Integer>();
		integerList.addToFront(1);
		integerList.addToFront(2);
		integerList.addToEnd(3);
		
		comparator = new IntegerComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		integerList = null;
		comparator = null;
	}

	@Test
	void testGetSize() {
		assertEquals(3, integerList.getSize());
	}

	@Test
	void testAddToEnd() {
		integerList.addToEnd(9);
		assertEquals(9, integerList.getLast());
	}

	@Test
	void testAddToFront() {
		integerList.addToFront(7);
		assertEquals(7, integerList.getFirst());
	}

	@Test
	void testGetFirst() {
		assertEquals(2, integerList.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals(3, integerList.getLast());
	}

	@Test
	void testIterator() {
		assertTrue(integerList.iterator().hasNext());
		assertEquals(2, integerList.iterator().next());
	}

	@Test
	void testRemove() {
		assertEquals(1, integerList.remove(1, comparator).data);
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals(2, integerList.retrieveFirstElement());
		assertEquals(1, integerList.retrieveFirstElement());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals(3, integerList.retrieveLastElement());
		assertEquals(1, integerList.retrieveLastElement());
	}

	@Test
	void testToArrayList() {
		ArrayList<Integer> x = integerList.toArrayList();
		assertEquals(integerList.getFirst(), x.get(0));
	}
	
	private class IntegerComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer x, Integer y) {
			return x.compareTo(y);
		}
		
	}

}
