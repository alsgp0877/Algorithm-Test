package first;

import java.util.Arrays;

//input:string output:string 
public class SolutionPlus {

	public static void main(String[] args) {
		
		int[] digits = {2,2,9};//9가 1의 자리인경우 
		//int[] digits = {9,9};//9가 1의 자리10의자리 인경우 
		System.out.println(Arrays.toString(solve(digits)));

	}
	
	public static int[] solve(int[] k) {
		
		int n = k.length;//
		
		for(int i=n-1;i>=0;i--) {
			k[i]++;
			if(k[i]<10) {
				return k;//999가 아닐때는 중간에 return
			}
			k[i]=0;
			
		}
		int[] result = new int[n+1];//0,0,0,0 => 이거 원래 0으로 기본값이 나와서 그걸로 사용하는거임..
		result[0]=1;
		return result;
	}

}
