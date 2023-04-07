package searchTreeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import searchTreePD.BinarySearchTree;

public class SearchTreeTest {
	 public static void main(String arg[]){
		
		 BinarySearchTree<String> b2 = new BinarySearchTree<String>();
		 try {
				File myFile= new File("/Users/jyaheza/Downloads/testdata(2).csv"); 
				Scanner myScanner = new Scanner(myFile);
				while(myScanner.hasNextLine()) {
					String line = myScanner.nextLine();
					String [] words=line.split(",");
					b2.insert(Integer.parseInt(words[0]),words[1]);
				}
				myScanner.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("File Not Found");
			}
		 System.out.println("Test Binary Search Tree Test");
		 System.out.println("Height: "+b2.findHeight());
		 System.out.println("Search for 782209");
		 System.out.println("Search result: "+b2.search(782209));
		 System.out.println(b2.remove(782209));
		 System.out.println("Search for 782209");
		 System.out.println("search result: "+b2.search(782209));
		 System.out.println("\n \n");
		 b2.display(b2.head);

		
		 }
		
}
