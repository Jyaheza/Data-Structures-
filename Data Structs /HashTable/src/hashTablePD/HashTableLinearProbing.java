package hashTablePD;
import java.io.IOException;

public class HashTableLinearProbing {
	
	  private DataItem[] hashArray; 

	  private int arraySize;

	  private DataItem bufItem; // for deleted items

	  public HashTableLinearProbing(int size) {
	    arraySize = size;
	    hashArray = new DataItem[arraySize];
	    bufItem = new DataItem(-1); // deleted item key is -1
	  }

	  public void displayTable() {
	    System.out.print("Table: ");
	    for (int j = 0; j < arraySize; j++) {
	      if (hashArray[j] != null)
	        System.out.println(hashArray[j].getKey() + " ");
	      else
	        System.out.println("#");
	    }
	    System.out.println("");
	  }

	  public int hashFunction(int key) {
	    return key % arraySize; 
	  }

	  public void insert(DataItem item){
	    int key = item.getKey(); 
	    int hashVal = hashFunction(key); // hash the key
	    // until empty cell or -1,
	    while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
	      ++hashVal; // go to next cell
	      hashVal %= arraySize; // wraparound if necessary
	    }
	    hashArray[hashVal] = item; // insert item
	  }

	  public DataItem delete(int key) {
	    int hashVal = hashFunction(key); 

	    while (hashArray[hashVal] != null) // until empty cell,
	    { 
	      if (hashArray[hashVal].getKey() == key) {
	        DataItem temp = hashArray[hashVal]; // save item
	        hashArray[hashVal] = bufItem; // delete item
	        return temp;
	      }
	      ++hashVal; // go to next cell
	      hashVal %= arraySize; // wraparound if necessary
	    }
	    return null; // can't find item
	  }

	  public DataItem find(int key) // find item with key
	  {
	    int hashVal = hashFunction(key); // hash the key

	    while (hashArray[hashVal] != null) // until empty cell,
	    { 
	      if (hashArray[hashVal].getKey() == key)
	        return hashArray[hashVal]; // found, return item
	      ++hashVal; // go to next cell
	      hashVal %= arraySize; // wraparound if necessary
	    }
	    return null; // can't find item
	  }

	  public static void main(String[] args) throws IOException {
	    DataItem aDataItem;
	    int aKey, size, initSize, keysPerCell;

	    size = 150;
	    initSize = 100;
	    keysPerCell = 10;
	    HashTableLinearProbing theHashTable = new HashTableLinearProbing(size);

	    for (int j = 0; j < initSize; j++){
	      aKey = (int) (java.lang.Math.random() * keysPerCell * size);
	      aDataItem = new DataItem(aKey);
	      theHashTable.insert(aDataItem);
	    }

	    theHashTable.displayTable();
	    aDataItem = new DataItem(100);
	    theHashTable.insert(aDataItem);

	    theHashTable.delete(100);
	    aDataItem = theHashTable.find(100);
	    if (aDataItem != null) {
	      System.out.println("Found " + 100);
	    } else
	      System.out.println("Could not find " + 100);
	  }
	}
	class DataItem { 
	  private int data; 

	  public DataItem(int d) {
	    data = d;
	  }

	  public int getKey() {
	    return data;
	  }
	}

