import java.io.*;
import java.util.*;
/**
* author: Moises Holguin
* date: Monday, November 26, 2012
* UTCS Problem #2
*/
public class CountThem {
	public static void main(String[] args) throws IOException {
		Scanner infile = new Scanner(new File("countthem.dat"));
		
		while(infile.hasNext()) {
			String line = infile.nextLine();
			int num1 = 0;
			int num2 = 0;
			
			//Handles the permutations
			if (line.contains("P")) {
				num1 = Integer.parseInt(line.substring(0,line.indexOf("P")));
				num2 = Integer.parseInt(line.substring(line.indexOf("P")+1));
				long answer = factorial(num1, num1-num2);
				
				//This is how a person would normally tackle the problem
				//long answer = factorial(num1)/factorial(num1-num2);
				
				System.out.println(answer);
			}
			//Handles the combinations
			else {
				num1 = Integer.parseInt(line.substring(0,line.indexOf("C")));
				num2 = Integer.parseInt(line.substring(line.indexOf("C")+1));
				long answer = factorial(num1, Math.max(num1-num2, num2))/factorial(Math.min(num1-num2, num2));
				
				//This is how a person would normally tackle the problem
				//long answer = factorial(num1)/(factorial(num1-num2)*factorial(num2));
				
				System.out.println(answer);
			}
		}
	}
	
	public static long factorial(int x) {
		if(x==0 || x==1)
			return 1;
		else
			return x * factorial(x-1);
	}
	
	//This is the key method that uses the HINT described in the problem
	public static long factorial(int x, int y) {
		if(x==0 || x==1 || x==y)
			return 1;
		else
			return x * factorial(x-1, y);
	}
}
