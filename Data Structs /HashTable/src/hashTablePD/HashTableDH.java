package hashTablePD;

public class HashTableDH<T>{

	public int size;
	int collisions=0;
	//int insertions=0;
	//public ArrayList<Element> elements= new ArrayList<Element>(size);
    public Elementt<T>[] elements;

	public HashTableDH(int size){
		
		elements= new Elementt[size];
		this.size=size;
		
	}
	int h(int k) {
		return ((3*k)+5)%this.size;
	}
	int hPrime(int k){
		return 7-(k%7);
	}
	int dbHash(int i,int k) {
		return (h(k)+i*hPrime(k))% this.size;
	}
	
	public boolean insert(int key, T value) {
		Elementt<T>elt= new Elementt<T>(key,value);
		boolean isInserted=false;
		//h(k)=(3k+5) mod (table size)
		int hash=h(key);
		int i = 0;
		//int j = 0;
		
		while(!isInserted) {
			//System.out.println("here");
			if(elements[hash]==null) {
				//insertions++;
				//System.out.println("Inserted at "+ hash+" tot insertions: "+ insertions);
				elements[hash]=elt;
				isInserted= true;
				//break;
			}
			else 
			{
				//collisions=collisions+1;
				//System.out.println("D hashing: "+ key+" "+ i+" th time");
				i++;
				hash=(dbHash(i,key));
				collisions++;
				//System.out.println("result: "+ hash);
				//i=i+1;
				//j=j+1;		
			}
		}
		return isInserted;
		
	}
	public Elementt<T> get(int key) {
		Elementt<T> elt=null;
		int hash=((3*key)+5)%this.size;
		for(int j=0;j<elements.length;j++) {
			if(elements[hash]==null){
				System.out.println(key+" Not Found");
				return null;
			}
			if(elements[hash].getKey()==key)
				elt=elements[hash];
		     
		else {
			int i=1;
			while(elements[hash].getKey()!=key) {
				hash=dbHash(key,i);
				if(elements[hash].getKey()==key)
					elt=elements[hash];
				i++;
			}
			return elt;
		}
		}	
		if(elt!=null) {
			return elt;
		}
		else {
			System.out.println(key+" Not Found");
			return null;
		}
	}

public Elementt<T> remove(int key){
	Elementt<T> elt=null;
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
	String txt= "Test HastTableDH with table size "+ this.size+"\n"+ 
"Number of Collisions = "+this.collisions+ "\n";
	
	return txt;
}
}

class Elementt<T>{
	int key;
	T content;
	Elementt(){
		
	}
	Elementt(int key,T content){
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
