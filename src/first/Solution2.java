package first;

import java.util.Arrays;

//1�� �����丵 : �̸��� �� �˾ƺ��� ���� ���´�.

public class Solution2 {

	public static void main(String[] args) {

		String[] mailCollection = { "test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com"};
		String mailResult = null; //���ڿ� ������ ���ļ� �ᱹ ���������� ������ ���Ϲ��ڿ�
		String[] arrmailResult = new String[3];//�������� mailResult(������¹�)���� �迭�� ����� �� ������ ���� ��¹��� ���
		String mailReplace = null;//���ø������ۺ�


		for (int k = 0; k < mailCollection.length; k++) {
			if (mailCollection[k] != null) {
				if (1 <= mailCollection[k].length() && mailCollection[k].length() <= 100) {
					if (mailCollection[k].contains("@")) {

						String[] mailSplit = mailCollection[k].split("@");
						String mailLocal = mailSplit[0].toLowerCase();
						String mailDomain = mailSplit[1].toLowerCase();
						// �������̸��� ����� . �̿��� ���ڰ� ������ �����ֱ�
						char[] stringtocharDmail = mailDomain.toCharArray();//�����θ��Ϻκ��� string -> char�ιٲ㼭 �迭�� �־���
						
						
						//������������ �� ���ڿ� �߿� ��ĭ�� ����� �� ��ĭ�� ���� ���ڿ��� ������ִ� ����
						String blankDmail = new String(chkDotInDmail(stringtocharDmail)); //������ ������ �������� blankDmail�� �׳� ��µǰ�
						String chkBlankDmail = null;
						if (blankDmail.contains(" ")) {//������ ������ ������ ������ �������� ��µɲ���
							chkBlankDmail = blankDmail.replace(blankDmail.substring(blankDmail.indexOf(" "), blankDmail.indexOf(" ") + 1), "");
	
						}
						
						
						boolean firstplusLmail = mailLocal.startsWith("+");
						//���ø����� +�� ������ ���
						if (mailLocal.contains("+")) {
							if (!firstplusLmail) {//���ø��� ù��° ���ڰ� +�� �ƴѰ�� 
								// f���ڿ� 1~3������ ���ڿ�
								// +��ȣ�� ���۵Ǵ� �κк��� ������ ���ڿ�
								// �� ���ڿ��� f���ڿ����� ã�Ƽ� ��ĭ���� �����
								String rsubstring = mailLocal.substring(mailLocal.indexOf("+", 0), mailLocal.length());
								//System.out.println("rsubstring ���: " + rsubstring);
								mailReplace = mailLocal.replace(rsubstring, "");
								//System.out.println("ff ���: " + ff);

							}
						}
						//�տ��� ���ø����� + ������ ��������� 
						if (mailReplace != null) {
							//���ø����� .�� ������ ���
							if (mailReplace.contains(".")) {

								// f���ڿ����� .�ִ� ��ġ�� ��ȯ�ؼ� �� ��ġ ���ڿ��� �˾Ƴ��� �׸�ŭ�� ��ĭ���� ����
								int num = mailReplace.indexOf(".") + 1;
								String rsubstring = mailReplace.substring(mailReplace.indexOf("."), num);
								mailReplace = mailReplace.replace(rsubstring, "");

							}
							//������������ ������ ��� 
							if (chkBlankDmail != null) {
								mailResult = mailReplace + '@' + chkBlankDmail;
								arrmailResult[k] = mailResult;
							} else {//������������ �Ȱ�������� 

								mailResult = mailReplace + '@' + blankDmail;
								arrmailResult[k] = mailResult;

							}

						} else {//�տ��� ���ø����� + ������ �Ȱ�������� 
							if (!firstplusLmail) {//+ ������ �Ȱ��Ʊ� ������ +�� ÷�� �ִ��� �˻��������
								if (chkBlankDmail != null) {//������������ ������ ��� 
									mailReplace = mailLocal;//���ø��� ������ ���� �׳� ���Ϸ� �ٲ��ֱ�
									mailResult = mailReplace + '@' + chkBlankDmail;
									arrmailResult[k] = mailResult;

								} else {//������������ �Ȱ����� ��� 
									mailReplace = mailLocal;//���ø��� ������ ���� �׳� ���Ϸ� �ٲ��ֱ�
									mailResult = mailReplace + '@' + blankDmail;
									arrmailResult[k] = mailResult;

								}
							}

						}

					}
				}
			}
		}
		//https://hianna.tistory.com/554
		//�迭 => stream => �ߺ����� => �迭
		//������������� �ߺ��� �����ϰ� ���������� ��� �̸����� ���ü��ִ��� Ȯ��, ������ 
		String[] distinctResult = Arrays.stream(arrmailResult).distinct().toArray(String[]::new);
		for(String str:distinctResult) {
			
			System.out.println("��ȿ�� ��� ����" + str);
			
		}
		
		System.out.println("��ȿ�� ��� ���� ����" + distinctResult.length);

	}
	
	//2�� �����丵 : depth �鿩���⸦ �ٿ�����.
	//? public �ȿ� �� static�� �����ֳ���
	//�� �Լ��� ����� �����ϳ�? �����غ��� ���ڿ��� üũ�ϰ� .�� üũ�ϰ� �ΰ����� �ϱ���?
	private static char[] chkDotInDmail(char[] stringtocharDmail) {
		
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

		return resultDmail;
	}
	
	//3�� �����丵 �޼ҵ�(�Լ�)�� �ǵ��� �� �巯������ ������ ������ �۾��� �����ܰ�� ������. 

	private static boolean chkazDmail(char stringtocharDmail) {
		
		return stringtocharDmail >= 'a' && stringtocharDmail <= 'z';
		
	}
	
	private static boolean chkDotDmail(char stringtocharDmail) {
		
		return stringtocharDmail == '.';
		
	}
	

}
