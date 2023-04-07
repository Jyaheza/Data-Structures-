import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime=0;
		long endTime=0;
		SortedList<String>list= new SortedList<String>();
		try {
			File myFile= new File("/Users/jyaheza/Downloads/testdata(2).csv"); 
			Scanner myScanner = new Scanner(myFile);
			int i=0;
			while(myScanner.hasNextLine()) {
				String line = myScanner.nextLine();
				String [] words=line.split(",");
			    list.insert(Integer.parseInt(words[0]),words[1],i);
			    i++;
			}
			myScanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		System.out.println("Before sorting");
		//list.printList(list.getList());
		
		
		//insertion sort
		System.out.println("Insertion sort Test");
		startTime = System.nanoTime();
		list.insertionSort();
		endTime = System.nanoTime();
		System.out.println("Time:"+(endTime-startTime));
		list.printList(list.insertionSort());
		System.out.print("\n \n \n");
		
		
		//selection sort
		System.out.println("Selection sort Test");
		startTime = System.nanoTime();
		endTime = System.nanoTime();
		System.out.println("Time: "+(endTime-startTime));
		list.printList(list.selectionSort());
		System.out.print("\n \n \n");
		
		//Quick Sort
		System.out.println("Quick sort Test");
		startTime = System.nanoTime();
		list.quickSort(list.getList(), 0, list.getList().size()-1);
		endTime = System.nanoTime();
		System.out.println("Time:"+(endTime-startTime));
		list.printList(list.quickSort(list.getList(), 0, list.getList().size()-1));
		System.out.print("\n \n \n");
		
		
		//Merge Sort
		System.out.println("Merge sort Test");
		startTime = System.nanoTime();
		list.mergeSort(list.getList(), 0, list.getList().size()-1);
		endTime = System.nanoTime();
		System.out.println("Time:"+(endTime-startTime));
		list.printList(list.mergeSort(list.getList(), 1, list.getList().size()-1));
		System.out.print("\n \n \n");
	}

}
