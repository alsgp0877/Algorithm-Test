package first;

//input:string output:string 
public class SolutionKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* String key = "8F3Z-2e-9-w"; */
		String key = "8-5g-3-J";
		System.out.println("재 포맷된 라이센스키:" + solve(key,2));

	}
	
	public static String solve(String s, int k) {
		
		//-를 없애는게 맞는걸까? -를 기준으로 문자열을 나누는건 어떨까?
		//-를 없애려고 한다면 없애고 들어온 문자열과 비교해서 그부분이 포함된 부분빼고 나머지를 k에 따라 나누는?
		//왜냐면 첫번째꺼는 어차피 동일하게 가져갈꺼니까 '첫번째문자-'이거 뒤에꺼만 잘라내면 될것 같은데?
		//문자열이 들어왔을때 첫대쉬를 기준으로 앞뒤를 나눈다. 
		String[] str = s.split("-");
		//System.out.println(str[0]);//첫문자
		//System.out.println(str[1]);//나
		//System.out.println(str[2]);//머
		//System.out.println(str[3]);//지 
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
		//뒤에서부터 와야 정확한 문자의 길이를 알고잘라낼수있어서 그런듯?
		//-1한거는 맨뒤에는 붙으면 안되서 
		for(int i=second.length()-1;i>0;i--) {
			//https://okky.kr/article/230197
			if(i%k==0) {//4번째 자리에 - 넣기, 4로나눴을때 나머지가 0인곳이 4의 배수나 그런곳의 자리이겟지..
				second.insert(i, "-");
			}
			
		}
		
		String result = first +"-" + second;
		return result.toUpperCase();
		
	}

}
