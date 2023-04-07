package linkedList;

import java.util.ArrayList;

public class linkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
DoublyLinkedList2<String> list2= new DoublyLinkedList2<String>();
list2.addFirst("USA");
list2.addLast("Germany");
list2.addFirst("France");
list2.addLast("England");
list2.addFirst("Belgium");

DoublyLinkedList2<String> listCopy= list2.clone();

ArrayList<String> arrayFromFirst= list2.toArrayFromFirst();
ArrayList<String> arrayFromLast= list2.toArrayFromLast();
ArrayList<String> copyFromFirst= listCopy.toArrayFromFirst();

for(int i=0;i<arrayFromFirst.size();i++) {
	System.out.print(arrayFromFirst.get(i)+" ");
	
}
System.out.print("\n"+"\n");
for(int i=0;i<arrayFromLast.size();i++) {
	System.out.print(arrayFromLast.get(i)+" ");
}
System.out.print("\n"+"\n");
for(int i=0;i<copyFromFirst.size();i++) {
	System.out.print(copyFromFirst.get(i)+" ");
}
}
	}

