package hashTablePD;

import java.util.ArrayList;

public class HashTableLP<T>{
	public int size;
	int collisions=0;
	//public ArrayList<Element> elements= new ArrayList<Element>(size);
    public Element<T>[] elements;

	public HashTableLP(int size){
		elements= new Element[size];
		this.size=size;
	}
	public boolean insert(int key, T value) {
		Element<T>elt= new Element<T>(key,value);
		boolean isInserted=false;
		//h(k)=(3k+5) mod (table size)
		int hash=((3*key)+5)%this.size;
		while(hash<size) {
			if(elements[hash]==null) {
			elements[hash]=elt;
			isInserted= true;
			break;
			}
		else {
			collisions=collisions+1;
			hash=(hash+1)%this.size;
			}
		}
		return isInserted;
		
	}
	public Element<T> get(int key) {
		Element<T> elt=null;
		int hash=((3*key)+5)%this.size;
		for(int i=0;i<elements.length;i++) {
			if(i==hash)
				elt=elements[i];
		     }
		if(elt!=null) {
			return elt;
		}
		else {
			System.out.println(key+" Not Found");
			return null;
		}
			
		
	}

public Element<T> remove(int key){
	Element<T> elt=null;
	int hash=((3*key)+5)%this.size;
	for(int i=0;i<elements.length;i++) {
		if(i==hash) {
			elt=elements[i];
			elements[i]=null;
		}
	}
	if(elt!=null)
	return elt;
	else {
		System.out.println(key+" Not Found");
		return elt;
	}
}
public String toString() {
	String txt= "Test HastTableLP with table size "+ this.size+"\n"+ 
"Number of Collisions = "+this.collisions+ "\n";
	
	return txt;
}
}

class Element<T>{
	int key;
	T content;
	Element(){
		
	}
	Element(int key,T content){
		this.key=key;
		this.content=content;
	}
	public int getKey() {
		return this.key;
	}
	public T getContent() {
		return this.content;
	}
	public String toString() {
		return ""+content;
	}
}
