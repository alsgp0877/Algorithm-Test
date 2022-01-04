package first;

import java.util.HashSet;
import java.util.Set;

public class SolutionAnswer {
	
	public static void main(String[] args) {
		String[] emails = {"test.email+james@coding.com",
				"test.email+james@coding.com",
				"test.e.mail+toto.jane@cod.ing.com",
				"testemail+tom@cod.ing.com"};
		
		System.out.println(solve_1(emails));
		//System.out.println(a.solve_substring(emails));
		//System.out.println(a.solve_split(emails));
				
	}
	
	//1.Basic
	private static int solve_1(String[] emails) {
		
		//1 ds
		//"test.email+james@coding.com",
		Set<String> set = new HashSet<>();
		//2 for while charAt()
		for(String email : emails) {
			String localName = makeLocalName(email);
			String dName = makeDName(email);
			
			set.add(localName+"@"+dName);
			
		}
		
		return set.size();
		
	}
	private static String makeDName(String email) {
		
		
		return email.substring(email.indexOf("@")+1);
	}

	private static String makeLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<email.length();i++) {
			
			if(email.charAt(i) == '.') {
				
				continue;
				
			}
			if(email.charAt(i) == '+' || email.charAt(i) == '@') {
				
				break;
			}
			
			sb.append(email.charAt(i));
			
		}
		return sb.toString();
	}

}


