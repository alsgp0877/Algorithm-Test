package first;

//1차 리팩토링 : 이름을 좀 알아보기 쉽게 짓는다.
//1차 리팩토링 : 이름을 좀 알아보기 쉽게 짓는다.

public class SolutionResult {

	public static void main(String[] args) {

		String[] mailCollection = { "test.email+james@coding-com", "test.e.mail+toto.jane@coding.com",
				"testemail+tom@cod.ing.com", "alsgp0877@cod.ing.com", "alsgp.0877@cod.ing.com" };
		Solution slove = new Solution();
		System.out.println("유효성 통과 모음 갯수" + slove.solve(mailCollection));

	}

}
