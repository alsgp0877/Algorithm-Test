package first;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class SolutionJewelsAnswer {

	public static void main(String[] args) {
		
		String jew = "aA";//얘는 따로보고
		String stones = "aAAbbbbb";//얘는 하나로 보고 
		
		System.out.println(solve(jew,stones));
		
	}
	
	
	public static int solve(String jew,String stones) { 
		
		//1.ds
		Set<Character> set = new HashSet<>();
		
		//2.for while
		char[] charArr = jew.toCharArray();
		for(int i=0; i<charArr.length;i++) {
			set.add(charArr[i]);
		}
		  
		int count=0;
		char[] stoneArr = stones.toCharArray();
		for(int i=0;i<stoneArr.length;i++) {
			if(set.contains(stoneArr[i])) {
				count++;
			}
		}
		
		return count;
		
	  
	}
	  

	
}
