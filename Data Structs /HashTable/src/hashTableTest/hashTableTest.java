package hashTableTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import hashTablePD.HashTableDH;
import hashTablePD.HashTableLP;

public class hashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
HashTableLP<String> table = new HashTableLP<String>(100);
HashTableLP<String> table1 = new HashTableLP<String>(200);
HashTableDH<String> table2 = new HashTableDH<String>(100);
HashTableDH<String> table3 = new HashTableDH<String>(200);
try {
	File myFile= new File("/Users/jyaheza/Downloads/hashdata.csv"); 
	Scanner myScanner = new Scanner(myFile);
	while(myScanner.hasNextLine()) {
		String line = myScanner.nextLine();
		String [] words=line.split(",");
		table.insert(Integer.parseInt(words[0]),words[1]);
		table1.insert(Integer.parseInt(words[0]),words[1]);
		table2.insert(Integer.parseInt(words[0]),words[1]);
		table3.insert(Integer.parseInt(words[0]),words[1]);
	}
	myScanner.close();
}
catch(FileNotFoundException e) {
	System.out.println("File Not Found");
}
System.out.print(table.toString());
System.out.println("Name: "+table.get(782209));
table.remove(782209);
table.get(782209);


System.out.println("\n");


System.out.print(table1.toString());
System.out.println("Name: "+table1.get(782209));
table1.remove(782209);
table1.get(782209);

System.out.println("\n");

System.out.print(table2.toString());
System.out.println("Name: "+table2.get(782209));
table2.remove(782209);
table2.get(782209);

System.out.println("\n");

System.out.print(table3.toString());
System.out.println("Name: "+table3.get(782209));
table3.remove(782209);
table3.get(782209);
	}

}
