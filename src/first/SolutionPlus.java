package first;

import java.util.Arrays;

//input:string output:string 
public class SolutionPlus {

	public static void main(String[] args) {
		
		int[] digits = {1,2,9};
		solve(digits);

	}
	
	public static int solve(int[] k) {

		int a = k[k.length-1];

		if(a == 9) {
			k[k.length-1] = 0;
			int c = k[k.length-2]+1;
			k[k.length-2] = c;
			System.out.println("9배열"+ Arrays.toString(k));
			
		}else {
			int b = a+1;
			k[k.length-1] = b;
			System.out.println("그냥숫자배열"+ Arrays.toString(k));
		}
		
		return 1;
		
	}

}
