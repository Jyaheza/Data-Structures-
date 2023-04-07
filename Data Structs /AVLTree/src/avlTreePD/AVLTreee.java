package avlTreePD;



public class AVLTreee<T> {
	 
	public int numberInTree=1;
	public Node head= null;
	public int insertions=0;
	void updateHeight(Node n) {
        n.height = 1+Math.max(height(n.left), height(n.right));
    }
	int height(Node n) {
		if(n==null) 
			return -1;
			else 
				return n.height;
		
    }
	int getBalance(Node n) {
		if(n==null)
			return 0;
		else 
			return height(n.right)-height(n.left);
        
    }
	class Node{
		int key;
		int height;
		T value;
		Node left;
	    Node right;
	    
	    private Node getLeftNode() {
	    	return this.left;
	    }
	    private Node getRightNode() {
	    	return this.right;
	    }
	    private int getKey() {
	    	return this.key;
	    }
	    
	    Node(int key,T value){
	    	this.key=key;
	    	this.value=value;
	    }
	    public boolean isLeaf() {
	    	if(this.getRightNode()==null&&this.getLeftNode()==null) 
	    		return true;
	    	else 
	    		return false;
	    }
	    public String toString() {
	    	return""+this.value;
	    }
	}
	
	public AVLTreee(){
		
	}
	public Integer findHeight(){
		 
        return getNodeHeight(this.head);
    }
 
    private Integer getNodeHeight(Node node) {
     if(node == null) {return -3;
        }
 
        return Math.max(getNodeHeight(node.getLeftNode()), getNodeHeight(node.getRightNode()))+1;
    }
    
    Node rotateRight(Node y) {
        Node x = y.left;
       Node z = x.right;
        
        x.right = y;
      
        y.left = z;
        
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    
    Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    
    }
    
    
    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

	
	public void insert(int id,T element){
		 Node newNode = new Node(id,element);
		 if(this.head==null){
		 this.head = newNode;
		 return;
		    }
		 Node current = head;
		 Node parent = null;
		 while(true){
		     parent = current;
		 
		 if(newNode.getKey()<current.key){
		 
			 current = current.left;
		
		 if(current==null){
		     parent.left = newNode;
		     numberInTree++;
		 return;
		 }
		    }
		 else 
		 {
			 current = current.right;
		 if(current==null){
		    parent.right = newNode;
		    numberInTree++;
		     return;
		 }
		  }
		 rebalance(newNode);
		    }
		 
		        }
	
	

	
	 public Node search(int id){
		 
	Node current = this.head;
	boolean isFound=false;
	while(current!=null){
		 if(current.getKey()==id){
			 
		 return current;
		 }
		 else if(current.getKey()>id){
			 
	current = current.getLeftNode();
		 
		 }
		 else
		 {
	current = current.getRightNode();
		 }
		   }
		if(isFound==false) {
		     return null;
		 }
		 else
			return current; 
		 }
	


	
	 public boolean remove(int id){
		 Node parent = head;
		 Node current = head;
		 boolean isLeftChild = false;
		   while(current.getKey()!=id){
		     parent = current;
		      if(current.getKey()>id){
		        isLeftChild = true;
		        current = current.getLeftNode();
		       }
		       else{
		       isLeftChild = false;
		       current = current.getRightNode();
		       }
		       if(current ==null){
		         return false;
		       }
		 }
		 
		 if(current.getLeftNode()==null && current.getRightNode()==null){
		    if(current==head){
		       head = null;
		     }
		     if(isLeftChild ==true){
		       parent.left = null;
		      }else{
		       parent.right = null;
		      }
		 }
		 //Case 2 : if node to be deleted has only one child
		 else if(current.right==null){
			 if(current==head){
			     head = current.left;
			 }
			 else if(isLeftChild)
			 {
			    parent.left = current.left;
			    
			 }
			 else
			 {
			    parent.right = current.left;
			 }
			 numberInTree--;
		 }
		 else if(current.left==null)
		 {
			 if(current==head)
			 {
			     head = current.right;
			 }
			 else if(isLeftChild)
			 {
			     parent.left = current.right;
			 }else
			 {
			     parent.right = current.right;
			 }
			 numberInTree--;
		 }
		 else if(current.left!=null && current.right!=null)
		 {
		 
		      Node successor = getSuccessor(current);
		   if(current==head){
		      head = successor;
		 }
		   else if(isLeftChild)
		   {
		 parent.left = successor;
		 }
		   else
		   {
		 parent.right = successor;
		   } 
		 successor.left = current.left;
		 numberInTree--;
		 } 
		 return true; 
		 }
	 public Node getSuccessor(Node deleleNode){
		 Node successsor =null;
		 Node successsorParent =null;
		 Node current = deleleNode.right;
		 while(current!=null)
			 {
				 successsorParent = successsor;
				 successsor = current;
				 current = current.left;
			 }
			 if(successsor!=deleleNode.right)
			 {
				 successsorParent.left = successsor.right;
				 successsor.right = deleleNode.right;
			 }
			 return successsor;
		 }
	 public void display(Node head){
		 if(head!=null)
		 {
		 display(head.left);
		 System.out.println(head.key+": " + head.value);
		 display(head.right);
		 }
		 }
}
