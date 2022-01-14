package first;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class SolutionJewels {

	public static void main(String[] args) {
		
		String jew = "z";//��� ���κ���
		String stones = "aAAbbbbb";//��� �ϳ��� ���� 
		
		solve(jew,stones);
		
	}
	
	
	  private static void solve(String jew,String stones) { 
		  
			boolean chkjew = Pattern.matches("^[a-zA-Z]*$", jew);//true : ��� ���� ���� 
			boolean chkstones = Pattern.matches("^[a-zA-Z]*$", stones);

			if(chkjew && chkstones) {
				if (1 <= jew.length() && jew.length() <= 50 || 1 <= stones.length() && stones.length() <= 50 ) {
					int count = 0;
					for(String str : charToString(jew)) {
						if(stones.contains(str)) {
							count++;
						}
						
					}
					
					System.out.println("�ߺ��� ������ ����" + charToString(jew));
					System.out.println("������ ���ԵǴ� ���� " + count);
					
				}
			}
	  
	  }
	  
	  private static Set<String> charToString(String jew) {
			//1�������� ������ ���ڵ��� set��  �ϳ��ϳ� �־ �ߺ��Ǹ� �˾Ƽ� �����ְԲ� 
			Set<String> set = new HashSet<>();

			for(int i=0;i<jew.length();i++) {
				
				String charToString = String.valueOf(jew.charAt(i));//String ���ڿ��� char ���ڷ� �ϳ��ϳ� �ɰ��� set�� ������ �ֵ��� ���� �ϳ��ϳ��� string ���·� �����
				set.add(charToString);//set�� �־ �ߺ��� ���ش�. 
			}
			
			return set;
	  }
	 

	
}
