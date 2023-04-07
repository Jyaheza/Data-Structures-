import java.util.ArrayList; 
public class SortedList<T> {

	
private ArrayList<Node> list=new ArrayList<Node>();
public ArrayList<Node> getList() {
	return list;
}
public void insert(int key,T value,int index) {
	Node node= new Node(key,value);
	
	list.add(index, node);
}

	class Node{
		T element;
		int key;
		Node(int key, T element){
			this.element=element;
			this.key=key;
		}
		Node(){
			
		}
		public String toString() {
			return key+" "+element;
		}
	}
public ArrayList<Node> bubbleSort(){
    //copy
	ArrayList<Node> list= new ArrayList<Node>(this.list);
	    boolean sorted = false;
	    Node temp;
	    while(!sorted) {
	        sorted = true;
	        for (int i = 0; i < list.size() - 1; i++) {
	            if (list.get(i).key > list.get(i+1).key) {
	                temp = list.get(i);
	                list.set(i, list.get(i+1));
	                list.set(i+1, temp);
	                sorted = false;
	            }
	        }
	    }

	
	return list;
	
}
	
public ArrayList<Node> insertionSort(){
	ArrayList<Node> list= new ArrayList<Node>(this.list);
	    for (int i = 1; i < list.size(); i++) {
	        Node current = list.get(i);
	        int j = i - 1;
	        while(j >= 0 && current.key < list.get(j).key) {
	        
	            list.set(j+1, list.get(j));
	            j--;
	        }
	        // at this point we've exited, so j is either -1
	        // or it's at the first element where current >= a[j]
	        
	        list.set(j+1, current);
	    }
	    return list;
	}

public ArrayList<Node> selectionSort() {
	ArrayList<Node> list= new ArrayList<Node>(this.list);
    for (int i = 0; i < list.size(); i++) {
        Node min = list.get(i);
        int minId = i;
        for (int j = i+1; j < list.size(); j++) {
            if (list.get(j).key < min.key) {
                min = list.get(j);
                minId = j;
            }
        }
        // swapping
        Node temp = list.get(i);
        list.set(i, min);
        list.set(minId, temp);
       
    }
    return list;
}
	
 
public ArrayList<Node> quickSort(ArrayList<Node> list,int first, int last){

	if (first < last) {
	      int pivot = partition(list, first, last);
	     
	      quickSort(list, first, pivot - 1);

	      quickSort(list, pivot + 1, last);
	    }
	return list;
	
}


 int partition(ArrayList<Node> list, int first, int last) {
    Node pivot = list.get(last);
    int i = (first - 1);
    for (int j = first; j < last; j++) {
      if (list.get(j).key<= pivot.key) {
        i++;

        Node temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
      }

    }

    Node temp = list.get(i+1);
    list.set(i+1, list.get(last));
    list.set(last,temp);

    return (i + 1);
  }
 
 public ArrayList<Node> mergeSort( ArrayList<Node> list, int first, int last) {
	      
	    if (first < last) {

	      int midpoint = (first + last) / 2;

	      mergeSort(list, first, midpoint);
	      mergeSort(list, midpoint + 1, last);
	      merge(list, first, midpoint, last);
	    }
	    return list;
	  }
 
 void merge(ArrayList<Node> list, int p, int q, int r) {
	    int n1 = q - p + 1;
	    int n2 = r - q;
	    
	    ArrayList<Node> L= new ArrayList<Node>(n1);
	    for(int i=0;i<n1;i++) {
	    	L.add(i,new Node());
	    }
	    ArrayList<Node> M= new ArrayList<Node>(n2);
	    for(int i=0;i<n2;i++) {
	    	M.add(i,new Node());
	    }
	    for (int i = 0; i < n1; i++)
	    L.set(i, list.get(p+i));
	    for (int j = 0; j < n2; j++)
         M.set(j, list.get(q+1+j));
	    int i, j, k;
	    i = 0;
	    j = 0;
	    k = p;

	    while (i < n1 && j < n2) {
	    	
	      if (L.get(i).key <= M.get(j).key) {
	    	  list.set(k,L.get(i));
	          i++;
	      }
	      
	      else {
	    	  list.set(k,M.get(j));
	          j++;
	      }
	      k++;
	    }
	    while (i < n1) {
	      list.set(k, L.get(i));
	      i++;
	      k++;
	    }

	    while (j < n2) {
	      list.set(k, M.get(j));
	      j++;
	      k++;
	    }
	  }
 
public void printList(ArrayList<Node> list) {
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
}
}
