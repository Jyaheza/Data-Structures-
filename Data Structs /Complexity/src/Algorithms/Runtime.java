package Algorithms;

public class Runtime {
	
	 public static int sumOfIntegers(int[] arr) {

		int n = arr.length, total = 0;

		for (int j=0; j <n; j++) 
			total +=arr[j];

		// loop from 0 to n-1

		return total;

		}

		
	public static int sumOfEvenIndexes(int[] arr) {

		int n = arr.length, total= 0;

		// note the increment of 2

		for (int j=0; j < n; j+= 2) 
			total += arr[j];

		return total;

		}

		
		public static int prefixSums(int[] arr) {

		int n = arr.length, total = 0;

		for (int j=0; j <n; j++) for (int k=0; k <=j; k++)

		
		total += arr[j]; 
		return total;

		}

		
		public static int sumOfprefixSums(int[] arr) {

		int n = arr.length, prefix= 0, total = 0;

		for (int j=0; j<n; j++) { 
			prefix += arr[j];
			total += prefix;
		}

		return total;
		}
		 

		
		
		public static int numberPrefixes(int[] first, int[] second) { 

		int n = first.length, count=0; 
		for (int i=0; i<n; i++) {

		int total = 0; 
		for (int j=0; j< n; j++)

		for (int k=0; k <= j; k++)

		total += first[k];

		if (second[i]==total) count++; 
		}

		return count;

		
		}
public static int [] desiredArray(int n, int array[]) {
	int [] arr= new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i]=array[i];
				
			}
			return arr;
		}
}
