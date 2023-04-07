package linkedList;

import java.util.ArrayList;

public class DoublyLinkedList2<T> {
private int size=0;
private static class Node<T>{
	private T element;
	private Node<T> next;
	private Node<T> prev;
	public Node(T e) {
		element=e;
	}
	public T getElement() {
		return element;
	}
	public Node<T> getNext(){
		return next;
	}
	public Node<T> getPrev(){
		return prev;
	
	}
	public void setPrev(Node<T> p) { prev = p; } 
	public void setNext(Node<T> n) { next = n; }
	}
private Node<T>header= null;
private Node<T>trailer= null;
private Node<T> newest;

public Node<T> getFirst(){
	if(size==0) {
		return header;
	}
	else 
		return header.getNext();
}
public Node<T> getLast(){
	if(size==0) {
		return trailer;
	}
	else
		return trailer.getPrev();
}
public void addFirst(T e) {
	 newest= new Node<T>(e);
	 if(isEmpty()) {
		 trailer=newest;
	 }
	 else {
		 header.setPrev(newest);
	 }
			newest.setNext(header);
			newest.setPrev(null);
			header = newest;
			
			size++;

}
public void addLast(T e) {
	newest =new Node<T>(e);
	if(isEmpty()) {
		header=newest;
	}
	else {
		trailer.setNext(newest);
	}
			newest.setPrev(trailer);
			newest.setNext(null);
			trailer = newest;
			size++;

}
public void removeLast() {
	if(header==null) {
		System.out.print("List empty");
	}
	else {
		trailer= trailer.prev;
	trailer.setPrev(null);
	size--;
	}
}
public void removeFirst() {
	if(header==null) {
		System.out.print("List empty");
	}
	else {
		header= header.getNext();
		header.setPrev(null);;
		size--;
	}
}
public boolean isEmpty() {
	if(size==0) {
		return true;
	}
	else 
		return false;
}

public DoublyLinkedList2<T> clone() {
	final DoublyLinkedList2<T> listCopy= new DoublyLinkedList2<T>();
	Node<T> listNode= header;
	while(listNode!=null) {
		listCopy.addLast(listNode.getElement());
		listNode=listNode.getNext();
	}
	return listCopy;
	
}


public ArrayList<T> toArrayFromFirst(){
	ArrayList<T> array= new ArrayList<T>();
	 Node<T> currentNode=header;
	 int i=size;
	 while(i>0) {
	array.add(currentNode.getElement());
	 currentNode= currentNode.getNext();
	 i--;
	 }
	 return array;
}
public ArrayList<T> toArrayFromLast(){
	ArrayList<T> reverseArray= new ArrayList<T>();
	Node<T> currentNode=trailer;
	int i=size;
	 while(i>0) {
	reverseArray.add(currentNode.getElement());
	 currentNode= currentNode.getPrev();
	 i--;
	 }
	 return reverseArray;
}

}
