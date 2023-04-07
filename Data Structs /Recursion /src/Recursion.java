
public class Recursion {
	int result;
	int c=0,v=0;
    String vowels = "aeiou";
public int multiplication(int num1,int num2) {
	if(num1==0||num2==0) {
		return 0;
	}
	if(num1==1) {
		return num2;
	}
	if(num2==1) {
		return num1;
	}
		else
			num1=num1+multiplication(num1,num2-1);
		return num1;
	}
public boolean palindrome(String s,int front, int rear) {
	//StringBuilder str= new StringBuilder(s);
	if(front>s.length()-1) {
		return true;
	}
	if(s.charAt(front)==s.charAt(rear)) {
			front++;
			rear--;
			return palindrome(s,front,rear);
	}
	else {
		return false;
		}
			
				
		}
	
	public boolean areMoreVowels(String str,int counter){
		
	    if(counter>str.length()-1) {
     
            System.out.print(v>c);
            System.exit(0);
	    	return (v>c);
	    }
	    else {
	    	while(counter<=str.length()-1) {
				if((vowels.indexOf(str.charAt(counter)))!=-1) {
					
	    			v++;
	    			counter=counter+1;
	    			areMoreVowels(str,counter);
	    		}
	    		else {
	    			
	    			c++;
	    			counter=counter+1;
	    			areMoreVowels(str,counter);
	    					
	    		}
	    	}
	    	return areMoreVowels(str,counter);
	    }
	    }
	public void towerOfHanoi(int n, char firstRod,char lastRod, char tempRod)
            {
               if (n == 0)
                  {
                return;
                  }
				towerOfHanoi(n - 1, firstRod, tempRod, lastRod);
				System.out.println("Move disk "+ n + " from rod " +firstRod +" to rod " + lastRod );
				towerOfHanoi(n - 1, tempRod, lastRod, firstRod);
}
}



