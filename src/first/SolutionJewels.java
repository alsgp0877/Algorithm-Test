package first;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class SolutionJewels {

	public static void main(String[] args) {
		
		String jew = "z";//얘는 따로보고
		String stones = "aAAbbbbb";//얘는 하나로 보고 
		
		solve(jew,stones);
		
	}
	
	
	  private static void solve(String jew,String stones) { 
		  
			boolean chkjew = Pattern.matches("^[a-zA-Z]*$", jew);//true : 영어만 쓰고 있음 
			boolean chkstones = Pattern.matches("^[a-zA-Z]*$", stones);

			if(chkjew && chkstones) {
				if (1 <= jew.length() && jew.length() <= 50 || 1 <= stones.length() && stones.length() <= 50 ) {
					int count = 0;
					for(String str : charToString(jew)) {
						if(stones.contains(str)) {
							count++;
						}
						
					}
					
					System.out.println("중복이 없어진 보석" + charToString(jew));
					System.out.println("보석이 포함되는 갯수 " + count);
					
				}
			}
	  
	  }
	  
	  private static Set<String> charToString(String jew) {
			//1차적으로 보석의 문자들을 set에  하나하나 넣어서 중복되면 알아서 없애주게끔 
			Set<String> set = new HashSet<>();

			for(int i=0;i<jew.length();i++) {
				
				String charToString = String.valueOf(jew.charAt(i));//String 문자열을 char 문자로 하나하나 쪼개서 set에 넣을수 있도록 문자 하나하나를 string 형태로 만든다
				set.add(charToString);//set에 넣어서 중복을 없앤다. 
			}
			
			return set;
	  }
	 

	
}
