package linkedList;

public class DoublyLinkedList<T> {
		//---------------- nested Node class ----------------
		private static class Node<T>{
		private T country;
		private Node<T> prev;
		private Node<T> next;
		public Node(T e, Node<T> p, Node<T> n) {
		country = e; prev = p; next = n;
		}
		public T getElement() { return country; } 
		public Node<T> getPrev() { return prev; } 
		public Node<T> getNext() { return next; } 
		public void setPrev(Node<T> p) { prev = p; } 
		public void setNext(Node<T> n) { next = n; }
		} //----------- end of nested Node class -----------
		// instance variables of the DoublyLinkedList
		private Node<T> header;
		private Node<T> trailer;
		private int size = 0;
		
		public DoublyLinkedList( ) {
		header = new Node<>(null, null, null); 
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
		}
		// reference to the element stored at this node // reference to the previous node in the list
		// reference to the subsequent node in the list
		public int size() { return size; }
		public boolean isEmpty() { return size == 0; }
		 public T first( ) {
		if (isEmpty()) return null;
		return header.getNext().getElement(); 
		 }// first element is beyond header }
		 public T last( ) {
		if (isEmpty()) return null;
		return trailer.getPrev().getElement(); // last element is before trailer }
		 }
		// header sentinel
		// trailer sentinel
		// number of elements in the list
		// create header
		// trailer is preceded by header // header is followed by trailer
	
		public void addFirst(T e) {
	    addBetween(e, header, header.getNext());
		}
		
		public void addLast(T e) {
	    addBetween(e, trailer.getPrev(), trailer);
	}
		
		public T removeFirst( ) {
	 if (isEmpty()) return null; // nothing to remove
	 return remove(header.getNext()); // first element is beyond header
		}
		
		public T removeLast( ) {
		if (isEmpty()) return null;
		 return remove(trailer.getPrev());
		}
		private T remove(Node<T> node) {
			 Node<T> predecessor = node.getPrev( );
			 Node<T> successor = node.getNext( );
		     predecessor.setNext(successor);
			successor.setPrev(predecessor);
			size--;
		   return node.getElement( );
			 }
	
		 private void addBetween(T e, Node<T> predecessor, Node<T> successor) {
		
		Node<T> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		 successor.setPrev(newest);
		size++;
		}
		 public void printList() {
			 Node<T> currentNode=header;
			 for(int i=0;i<size;i++) {
		    System.out.print(currentNode.getElement()+" ");
			currentNode= currentNode.getNext();
			 }
		 }
		 public void printReverse() {
			 Node<T> currentNode= trailer;
			 for(int i=0;i<size;i++) {
				 currentNode= currentNode.getPrev();
				 System.out.print(currentNode.getElement()+" ");
}
		 }
		 }

