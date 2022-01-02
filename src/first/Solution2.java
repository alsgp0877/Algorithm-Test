package first;

import java.util.Arrays;

//1�� �����丵 : �̸��� �� �˾ƺ��� ���� ���´�.

public class Solution2 {

	public static void main(String[] args) {

		String[] mailCollection = { "test.email+james@coding-com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com","alsgp0877@cod.ing.com","alsgp.0877@cod.ing.com"};
		String[] arrmailResult = new String[mailCollection.length];//�������� mailResult(������¹�)���� �迭�� ����� �� ������ ���� ��¹��� ���
		


		for (int k = 0; k < mailCollection.length; k++) {
			if (mailCollection[k] != null) {
				if (1 <= mailCollection[k].length() && mailCollection[k].length() <= 100) {
					if (mailCollection[k].contains("@")) {

						String[] mailSplit = mailCollection[k].split("@");
						String mailLocal = mailSplit[0].toLowerCase();
						String mailDomain = mailSplit[1].toLowerCase();
						char[] stringtocharDmail = mailDomain.toCharArray();//�����θ��Ϻκ��� string -> char�ιٲ㼭 �迭�� �־���
						arrmailResult[k] = chkLmail(mailLocal) + '@' + chkDotInDmail(stringtocharDmail);
						 
					}
				}
			}
		}
		
		String[] dismailResult = Arrays.stream(arrmailResult).distinct().toArray(String[]::new);
		for(String str:dismailResult) {
			System.out.println("��ȿ�� ��� ����" + str);
		}
		System.out.println("��ȿ�� ��� ���� ����" + dismailResult.length);
		
		//https://hianna.tistory.com/554
		//�迭 => stream => �ߺ����� => �迭
		//������������� �ߺ��� �����ϰ� ���������� ��� �̸����� ���ü��ִ��� Ȯ��, ������ 

	}
	
	//2�� �����丵 : depth �鿩���⸦ �ٿ�����.
	//? public �ȿ� �� static�� �����ֳ���
	//�� �Լ��� ����� �����ϳ�? �����غ��� ���ڿ��� üũ�ϰ� .�� üũ�ϰ� �ΰ����� �ϱ���?
	private static String chkDotInDmail(char[] stringtocharDmail) {
		
		char[] resultDmail = new char[30];//���������ۺ�
		
		for (int i = 0; i < stringtocharDmail.length; i++) {
	
			if (chkazDmail(stringtocharDmail[i])) {//a~z�϶��� �׳� �迭�� �־��ְ�
				resultDmail[i] = stringtocharDmail[i];
			} else if (chkDotDmail(stringtocharDmail[i])) {//�ҹ��� ���� .�϶��� �־��ִµ� .�� �ƴҶ��� ��ĭ�� ����
				resultDmail[i] = stringtocharDmail[i];
			} else {
				resultDmail[i] = ' ';
			}
		}
		
		//������������ �� ���ڿ� �߿� ��ĭ�� ����� �� ��ĭ�� ���� ���ڿ��� ������ִ� ����
		String blankDmail = new String(resultDmail); 
		if (blankDmail.contains(" ")) {//������ ������ ������ ������ �������� ��µɲ���
			blankDmail = blankDmail.replace(blankDmail.substring(blankDmail.indexOf(" "), blankDmail.indexOf(" ") + 1), "");

		}

		return blankDmail;
	}
	
	//3�� �����丵 �޼ҵ�(�Լ�)�� �ǵ��� �� �巯������ ������ ������ �۾��� �����ܰ�� ������. 

	private static boolean chkazDmail(char stringtocharDmail) {
		
		return stringtocharDmail >= 'a' && stringtocharDmail <= 'z';
		
	}
	
	private static boolean chkDotDmail(char stringtocharDmail) {
		
		return stringtocharDmail == '.';
		
	}
	
	private static String chkLmail(String mailLocal) {
		
		boolean firstplusLmail = mailLocal.startsWith("+");
		String mailLocalReplace = null;//�� ������ �������� �־�� ���������� �ٲ�� ���ڿ��� ǥ���Ҽ���
		
		//���ø����� +�� ������ ���
		if (mailLocal.contains("+")) {
			if (!firstplusLmail) {//���ø��� ù��° ���ڰ� +�� �ƴѰ�� -> �����̸����� ��� 
				mailLocalReplace = mailLocal.replace(mailLocal.substring(mailLocal.indexOf("+"), mailLocal.length()), "");//���ڿ��� ����� 
				
				if (mailLocalReplace.contains(".")) {

					mailLocalReplace = mailLocalReplace.replace(mailLocalReplace.substring(mailLocalReplace.indexOf("."), mailLocalReplace.indexOf(".") + 1), "");
				}

			}
		}else if (mailLocal.contains(".")) {

			mailLocalReplace = mailLocal.replace(mailLocal.substring(mailLocal.indexOf("."), mailLocal.indexOf(".") + 1), "");

		}else {
			
			mailLocalReplace = mailLocal;
		}
		
		return mailLocalReplace;
		
	}
	
}
