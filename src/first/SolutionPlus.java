package first;

import java.util.Arrays;

//input:string output:string 
public class SolutionPlus {

	public static void main(String[] args) {
		
		//int[] digits = {1,2,9};//9가 1의 자리인경우 
		int[] digits = {9,9};//9가 1의 자리10의자리 인경우 
		solve(digits);

	}
	
	public static int solve(int[] k) {
		
		for(int i=k.length-1;i>0;i--) {//끝에서부터 
			
			int a = k[i];
			
			if(a >= 9) {
				k[i] = 0;
				int c = k[i-1]+1;
				if(k[0] >= 9) {
					//1,0
					k[i-1] = 0;
					k[i-2] = 1;
				}else {
					k[i-1] = c;
				}
			}else {
				int b = a+1;
				k[i] = b;
				break;
			}
		}
		
		System.out.println("배열"+ Arrays.toString(k));

		
		return 1;
		
	}

}
