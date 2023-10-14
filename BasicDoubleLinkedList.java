import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class BasicDoubleLinkedList<T> implements Iterable<T>{
	Node<T> head;
	Node<T> tail;
	int size;
	
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addToEnd(T data) {
		Node<T> newEntry = new Node<T>(data);
		
		if (head == null) {
			head = newEntry;
			tail = newEntry;
			size++;
		}
		else {
			newEntry.prev = tail;
			newEntry.next = head;
			tail.next = newEntry;
			tail = newEntry;
			head.prev = newEntry;
			size++;
		}
	}
	
	public void addToFront(T data) {
		Node<T> newEntry = new Node<T>(data);
		
		if (head == null) {
			head = newEntry;
			tail = newEntry;
			size++;
		}
		else {
			newEntry.next = head;
			newEntry.prev = tail;
			head.prev = newEntry;
			head = newEntry;
			tail.next = newEntry;
			size++;
		}
	}
	
	public T getFirst() {
		return head.data;
	}
	
	public T getLast() {
		return tail.data;
	}
	
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>(head);
	}
	
	public Node<T> remove(T targetData, Comparator<T> comparator) {
		Node<T> data = head;
		Node<T> returnValue = null;
		int sizeIteration = size;
		
		if (data == null) {
			return null;
		}
		
		for (int i = 0; i < sizeIteration; i++) {
			if (comparator.compare(targetData, data.data) != 0) {
				data = data.next; // move to next element
			}
			else {
				// if element is at beginning
				if (data.prev == tail) {
					returnValue = new Node<T>(targetData);
					head = head.next;
					head.prev = tail;
					tail.next = head;
					size--;
					return returnValue;
				}
				// if element is at end
				else if (data.next == head) {
					returnValue = new Node<T>(targetData);
					tail = tail.prev;
					tail.next = head;
					head.prev = tail;
					size--;
					return returnValue;
				}
				// if anything else
				else {
					returnValue = new Node<T>(targetData);
					data.prev.next = data.next;
					data.next.prev = data.prev;
					size--;
					return returnValue;
				}
			}
		}
		return returnValue;
	}

	public T retrieveFirstElement() {
		T headData;
		
		if (head == null) {
			return null;
		}
		else {
			headData = head.data;
			head = head.next;
			size--;
		}
		
		return headData;
	}
	
	public T retrieveLastElement() {
		T tailData;
		
		if (head == null) {
			return null;
		}
		else {
			tailData = tail.data;
			tail = tail.prev;
			size--;
		}
		
		return tailData;
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> result = new ArrayList<>();
		// keep track of current Node
		Node<T> node = head;
		
		for (int i = 0; i < size; i++) {
			result.add(node.data);
			node = node.next;
		}
		
		return result;
	}
	
	protected class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		
		public Node(T dataNode) {
			this.prev = null;
			this.next = null;
			this.data = dataNode;
		}
	}
	
	protected class DoubleLinkedListIterator<T> implements ListIterator<T> {
		Node<T> data;
		T returnValue; // return value
		int index;
		
		public DoubleLinkedListIterator(Node<T> data) {
			this.data = data;
			index = 0;
		}
		
		@Override
		public boolean hasNext() {
			if (index < size) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				index++;
				returnValue = data.data;
				data = data.next;
				return returnValue;
			}
		}

		@Override
		public boolean hasPrevious() {
			if (index != 0) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public T previous() throws NoSuchElementException {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			else {
				index--;
				data = data.prev;
				returnValue = data.data;
				return returnValue;
			}
		}

		// unused methods
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
	}

}
