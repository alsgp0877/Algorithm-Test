package first;

import java.util.Scanner;

public class �⺻�˰��� {

	public static void main(String[] args) {

		String mail = "alsgp0877@naver.com";
		boolean firstTextMail = mail.startsWith("+");
		boolean chkLowerCase = false;

		if (mail != null) {
			if (1 <= mail.length() && mail.length() <= 100) {
				if (!firstTextMail) {
					if (mail.contains("@")) {
						
						String[] mailSplit = mail.split("@");
						String f = mailSplit[0];
						String b = mailSplit[1];
						
						if(f.contains("+")) {
							//f���ڿ� 1~3������ ���ڿ�
							//+��ȣ�� ���۵Ǵ� �κк��� ������ ���ڿ�
							//�� ���ڿ��� f���ڿ����� ã�Ƽ� ��ĭ���� �����
							String rsubstring = f.substring(f.indexOf("+",0), f.length());
							f.replace(rsubstring, "");
						}
						
						if(f.contains(".")) {
							
							//f���ڿ����� .�ִ� ��ġ�� ��ȯ�ؼ� �� ��ġ ���ڿ��� �˾Ƴ��� �׸�ŭ�� ��ĭ���� ����
							String rsubstring = f.substring(f.indexOf(".",0));
							f.replace(rsubstring, "");
						}
						
						//TODO �������� .���ڸ���� + ���ڴ� ������
						
					}
				}
			}
		}
	}
}

/*
 * char[] charmail = mail.toCharArray(); for (char c : charmail) { if
 * (Character.isLowerCase(c)) { chkLowerCase = true;
 * 
 * } }
 */
