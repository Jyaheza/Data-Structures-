
public class RecursionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palindrome="radar";
		
		
		Recursion rec= new Recursion();
		System.out.println("Multiplication: "+rec.multiplication(9, 4));
		System.out.println("Palindrome:"+rec.palindrome(palindrome, 0, palindrome.length()-1));
		System.out.println("\n");
		System.out.println("Towers of Hanoi");
		rec.towerOfHanoi(4,'A','B','C');
		System.out.println("\n");
		System.out.println("More vowels: "+rec.areMoreVowels("one",0));
		
		
	}

}
