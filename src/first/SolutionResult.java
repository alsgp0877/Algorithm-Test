package first;

//1�� �����丵 : �̸��� �� �˾ƺ��� ���� ���´�.
//1�� �����丵 : �̸��� �� �˾ƺ��� ���� ���´�.

public class SolutionResult {

	public static void main(String[] args) {

		String[] mailCollection = { "test.email+james@coding-com", "test.e.mail+toto.jane@coding.com",
				"testemail+tom@cod.ing.com", "alsgp0877@cod.ing.com", "alsgp.0877@cod.ing.com" };
		Solution slove = new Solution();
		System.out.println("��ȿ�� ��� ���� ����" + slove.solve(mailCollection));

	}

}
