
package Algorithms;
import java.io.*;


public class RuntimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Algorithm 1 from 100 to 100000
			
			 String result=" Algorithm 1"+"\n"+"n,Millisec"+"\n";
					int [] arr= new int[100000];
					
					for(int i=100;i<100000;i+=100) {
						long startTime = System.nanoTime(); 
						Runtime.sumOfIntegers(Runtime.desiredArray(i, arr));
						long stopTime = System.nanoTime(); 
						result=result+String.valueOf(i)+","+String.valueOf(stopTime - startTime+"\n");
					}
					
					
		// Algorithm 2 from 100 to 100000
					
					
					 String result2="Algorithm 2"+"\n"+"n,Millisec"+"\n";
							arr= new int[100000];
							
							for(int i=100;i<100000;i+=100) {
								long startTime = System.nanoTime(); 
								Runtime.sumOfEvenIndexes(Runtime.desiredArray(i, arr));
								long stopTime = System.nanoTime(); 
								result2=result2+String.valueOf(i)+","+String.valueOf(stopTime - startTime+"\n");
								
								
							}
							result=result+result2;
							
							// Algorithm 3 from 100 to 100000
							
							
							 String result3=" Algorithm 3"+"\n"+"n,Millisec"+"\n";
									arr= new int[100000];
									
									for(int i=100;i<100000;i+=100) {
										long startTime = System.nanoTime(); 
										Runtime.prefixSums(Runtime.desiredArray(i, arr));
										long stopTime = System.nanoTime(); 
										result3=result3+String.valueOf(i)+","+String.valueOf(stopTime - startTime+"\n");
										
										
									}
									result=result+result3;
									
									// Algorithm 4 from 100 to 100000
									
									
									 String result4=" Algorithm 4"+"\n"+"n,Millisec"+"\n";
											arr= new int[100000];
											
											for(int i=100;i<100000;i+=100) {
												long startTime = System.nanoTime(); 
												Runtime.sumOfprefixSums(Runtime.desiredArray(i, arr));
												long stopTime = System.nanoTime(); 
												result4=result4+String.valueOf(i)+","+String.valueOf(stopTime - startTime+"\n");
												//System.out.print(result4);
												
											}
											
											result= result+result4;
											
											
											// Algorithm 5 from 10 to 1000
											
											
											String result5= " Algorithm 5"+"\n"+"n,Millisec"+"\n";
													arr= new int[1000];
													
													for(int i=10;i<1000;i+=10) {
														long startTime = System.nanoTime(); 
														Runtime.sumOfEvenIndexes(Runtime.desiredArray(i, arr));
														long stopTime = System.nanoTime(); 
														result5=result5+String.valueOf(i)+","+String.valueOf(stopTime - startTime+"\n");
														
														
													}
													
													result=result+result5;
													System.out.print(result);
													
													
													
													// creating and writing to a file
													
													
													File myFile = new File("/Users/jyaheza/Documents/DATATEXTFILE.txt");
													try {
														if(myFile.createNewFile()) {
															System.out.print("file created");
															try {
																FileWriter writer= new FileWriter("/Users/jyaheza/Documents/DATATEXTFILE.txt");
																writer.write(result);
																writer.close();
															}
															catch(IOException e){
																System.out.print("Can not write to file");
															}
																
														}
														else
															System.out.print("file exists");
													} catch (IOException e) {
													
														e.printStackTrace();
													}
													
		}
 
		
		
	


}




