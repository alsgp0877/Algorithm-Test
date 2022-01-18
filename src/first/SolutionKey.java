package first;

//input:string output:string 
public class SolutionKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "8F3Z-2e-9-w";
		solve(key,4);

	}
	
	public static String solve(String s, int k) {
		
		//-를 없애는게 맞는걸까? -를 기준으로 문자열을 나누는건 어떨까?
		//-를 없애려고 한다면 없애고 들어온 문자열과 비교해서 그부분이 포함된 부분빼고 나머지를 k에 따라 나누는?
		//왜냐면 첫번째꺼는 어차피 동일하게 가져갈꺼니까 '첫번째문자-'이거 뒤에꺼만 잘라내면 될것 같은데?
		
		//문자열이 들어왔을때 첫대쉬를 기준으로 앞뒤를 나눈다. 
		String[] str = s.split("-");
		System.out.println(str[0]);//첫문자
		System.out.println(str[1]);//나
		System.out.println(str[2]);//머
		System.out.println(str[3]);//지 
		StringBuilder second = new StringBuilder();
		String first="";
		
		for(int i=0;i<str.length;i++) {
			
			if(i==0) {
				first = str[0];
			}else {
				second.append(str[i]);
		
			}
		}
		
		//뒷부분에서 이제 k로 들어온 값을 가지고 나눠야하는데 
		//만약에 k가 2가 들어왔으면 2-2 이란식으로 해줘야함. 
		
		System.out.println(first.toUpperCase() + '-' + second.toString().toUpperCase());//지 

		for(int i=0;i<second.length();i++) {
			//https://okky.kr/article/230197
			
			
		}
		
		
		return null;
		
	}

}
