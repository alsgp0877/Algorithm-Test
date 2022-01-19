package first;

//input:string output:string 
public class SolutionKeyAnswer {

	public static void main(String[] args) {
		String key = "8F3Z-2e-9-w"; 
		//String key = "8-5g-3-J";
		System.out.println("재 포맷된 라이센스키:" + solve(key,2));

	}
	
	public static String solve(String str, int k) {
		
		//1. -del
		String newStr = str.replace("-","");
		System.out.println("1:" + newStr);
		
		//2.upper
		newStr.toUpperCase();
		System.out.println("2:" + newStr);
		
		//3.k개로 파싱하기, 그리고 - 넣기
		StringBuilder sb = new StringBuilder(newStr);
		System.out.println("3:" + newStr);
		
		int len = sb.length();
		for(int i=k;i<len;i=i+k) {
			sb.insert(len-i, '-');
			System.out.println("4:" + sb);
		}
		
		
		return sb.toString();
		
	}

}
