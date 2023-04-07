package PostFixPD;

import java.util.ArrayList;

public class SinglyLinkedlist<T> {
private int size=0;
private class Node<T>{
	T element;
	Node<T> next;
	public Node<T>getNext() {
		return next;
	}
	public T getElement() {
		return element;
	}
	public void setNext(Node<T> n) {
		next=n;
	}
	public String toString() {
		return ""+element;
	}
	Node(T t){
		this.element=t;
	}
	Node(){
		this.element=null;
	}
}
private Node<T> header= new Node<>(null);
private Node<T> trailer=new Node<>(null);

public boolean isEmpty() {
	if(size==0) {
		return true;
	}
	else
		return false;
}

public void addFirst(T element) {
	Node<T> newNode= new Node<T>(element);
	if(size==0) {
		newNode.setNext(trailer);
		header.setNext(newNode);
		size++;
	}
		else {
			newNode.setNext(header.getNext());
			header.setNext(newNode);
			size++;
			}

}
public T removeFirst() {
	if(isEmpty()) {
		return null;
	}
	else {
		Node<T> newNode= new Node<T>();
		newNode=header.getNext();
		header.setNext(header.getNext().getNext());
		size--;
		return newNode.getElement();
	}
}
public T getFirst() {
	if(isEmpty())
		return header.getElement();
	else
		return header.getNext().getElement();
}
public int size() {
	return this.size;
}
public ArrayList<T> getList(){
	ArrayList<T> list= new ArrayList<T>();
	Node<T> newNode= header;
	for(int i=0;i<size;i++) {
		newNode= newNode.getNext();
		list.add(newNode.getElement());
		
	}
	return list;
}
}
