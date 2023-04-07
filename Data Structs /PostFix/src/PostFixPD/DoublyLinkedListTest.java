package PostFixPD;

import java.util.ArrayList;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SinglyLinkedlist<String> list= new SinglyLinkedlist<>();
		list.addFirst("Amazi");
		list.addFirst("amabyi");
		list.addFirst("umuntu");
		list.addFirst("abantu");
		System.out.println(list.removeFirst());
		ArrayList<String> arr= list.getList();
		for(String s: arr) {
			System.out.println(s);
		}
	}

}
