package first;

import java.util.Arrays;

//input:string output:string 
public class SolutionPlus {

	public static void main(String[] args) {
		
		int[] digits = {1,2,9};
		solve(digits);

	}
	
	public static int solve(int[] k) {

		//1 �迭�� �ǳ��� �ִ� ����
		int a = k[k.length-1];
		System.out.println("�ǵڿ�����"+a);
		//�迭�� �ǳ��� �ִ� ���� +1
		int b = a+1;
		System.out.println("�ǵڿ�����"+b);
		//�迭�� �ǳ��� �ִ� ���ڸ� +1 �� ���ڷ� �ٲ�
		k[k.length-1] = b;
		System.out.println("�迭"+ Arrays.toString(k));
		
		return 1;
		
	}

}
