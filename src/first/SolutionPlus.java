package first;

import java.util.Arrays;

//input:string output:string 
public class SolutionPlus {

	public static void main(String[] args) {
		
		int[] digits = {1,2,9};
		solve(digits);

	}
	
	public static int solve(int[] k) {

		//1 배열의 맨끝에 있는 숫자
		int a = k[k.length-1];
		System.out.println("맨뒤에숫자"+a);
		//배열이 맨끝에 있는 숫자 +1
		int b = a+1;
		System.out.println("맨뒤에숫자"+b);
		//배열의 맨끝에 있는 숫자를 +1 된 숫자로 바꿈
		k[k.length-1] = b;
		System.out.println("배열"+ Arrays.toString(k));
		
		return 1;
		
	}

}
