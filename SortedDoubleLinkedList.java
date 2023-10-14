import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		this.comparator = compareableObject;
	}
	
	public void add(T data) {
		Node<T> newData = new Node<T>(data);
		Node<T> currentNode = head;
		
		// check if no elements in list, breaks
		if (head == null) {
			head = newData;
			tail = newData;
			size++;
			return;
		}
		
		// loop through entire array once
		for (int i = 0; i < size; i++) {
			// if newData is less than or equal to currentNode
			if (comparator.compare(newData.data, currentNode.data) <= 0) {
				if (currentNode == head) {
					super.addToFront(data);
				}
				else if (currentNode == tail) {
					newData.next = currentNode;
	            	newData.prev = currentNode.prev;
	            	currentNode.prev.next = newData;
	            	currentNode.prev = newData;
	            	size++;
				}
				
				return;
			}
			
			currentNode = currentNode.next;
		}
		
		tail.next = newData;
		newData.prev = tail;
		tail = newData;
		tail.next = head;
		head.prev = tail;
		size++;
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	public Node<T> remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
	
}
