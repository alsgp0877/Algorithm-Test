package first;

import java.util.Arrays;

//input:string output:string 
public class SolutionPlus {

	public static void main(String[] args) {
		
		int[] digits = {2,2,9};//9�� 1�� �ڸ��ΰ�� 
		//int[] digits = {9,9};//9�� 1�� �ڸ�10���ڸ� �ΰ�� 
		System.out.println(Arrays.toString(solve(digits)));

	}
	
	public static int[] solve(int[] k) {
		
		int n = k.length;//
		
		for(int i=n-1;i>=0;i--) {
			k[i]++;
			if(k[i]<10) {
				return k;//999�� �ƴҶ��� �߰��� return
			}
			k[i]=0;
			
		}
		int[] result = new int[n+1];//0,0,0,0 => �̰� ���� 0���� �⺻���� ���ͼ� �װɷ� ����ϴ°���..
		result[0]=1;
		return result;
	}

}
