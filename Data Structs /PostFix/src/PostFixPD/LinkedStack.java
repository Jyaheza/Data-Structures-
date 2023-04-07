package PostFixPD;

public class LinkedStack<E> implements Stack<E> {

	SinglyLinkedlist<E> list= new SinglyLinkedlist<E>();
	
	LinkedStack(){
		
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
	
		return list.isEmpty();
	}

	@Override
	public void push(E t) {
		// TODO Auto-generated method stub
		list.addFirst(t);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}
	public int size() {
		return list.size();
	}
}
	
	
	
	
	
	
