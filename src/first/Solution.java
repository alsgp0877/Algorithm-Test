package first;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		//String[] mail = { "alsgp0877@naver.com"};
		String[] mail = { "test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com"};
		String result = null;
		String[] result1=new String[3];
		String ff = null;
		char[] badd = new char[30];

		for (int k = 0; k < mail.length; k++) {
			if (mail[k] != null) {
				if (1 <= mail[k].length() && mail[k].length() <= 100) {
					if (mail[k].contains("@")) {

						String[] mailSplit = mail[k].split("@");
						String f = mailSplit[0].toLowerCase();
						String b = mailSplit[1].toLowerCase();
						// �������̸��� ����� . �̿��� ���ڰ� ������ �����ֱ�
						char[] bsplit = b.toCharArray();
						for (int i = 0; i < bsplit.length; i++) {
							if (bsplit[i] >= 'a' && bsplit[i] <= 'z') {
								badd[i] = bsplit[i];
							} else {
								if (bsplit[i] == '.') {
									badd[i] = bsplit[i];
								} else {
									badd[i] = ' ';
								}
							}

						}

						String s2 = new String(badd);
						String s3 = null;
						if (s2.contains(" ")) {
							s3 = s2.replace(s2.substring(s2.indexOf(" "), s2.indexOf(" ") + 1), "");
							//System.out.println("badd ���: " + s3);
						}

						boolean firstTextMail = f.startsWith("+");
						if (f.contains("+")) {
							if (!firstTextMail) {
								// f���ڿ� 1~3������ ���ڿ�
								// +��ȣ�� ���۵Ǵ� �κк��� ������ ���ڿ�
								// �� ���ڿ��� f���ڿ����� ã�Ƽ� ��ĭ���� �����
								String rsubstring = f.substring(f.indexOf("+", 0), f.length());
								//System.out.println("rsubstring ���: " + rsubstring);
								ff = f.replace(rsubstring, "");
								//System.out.println("ff ���: " + ff);

							}
						}
						if (ff != null) {
							if (ff.contains(".")) {

								// f���ڿ����� .�ִ� ��ġ�� ��ȯ�ؼ� �� ��ġ ���ڿ��� �˾Ƴ��� �׸�ŭ�� ��ĭ���� ����
								int num = ff.indexOf(".") + 1;
								String rsubstring = ff.substring(ff.indexOf("."), num);
								//System.out.println("rsubstring ���: " + rsubstring);
								ff = ff.replace(rsubstring, "");
								//System.out.println("ff ���: " + ff);

							}

							if (s3 != null) {
								result = ff + '@' + s3;
								System.out.println("��ȿ�� ��� ����1" + result);
								result1[k] = result;
							} else {

								result = ff + '@' + s2;

								System.out.println("��ȿ�� ��� ����2" + result);
								result1[k] = result;

							}

						} else {
							if (!firstTextMail) {
								if (s3 != null) {
									ff = f;
									result = ff + '@' + s3;
									result1[k] = result;
									System.out.println("��ȿ�� ��� ����3" + result);
								} else {
									ff = f;
									result = ff + '@' + s2;
									result1[k] = result;
									System.out.println("��ȿ�� ��� ����4" + result);

								}
							}

						}

					}
				}
			}
		}
		//https://hianna.tistory.com/554
		//�迭 => stream => �ߺ����� => �迭
		String[] result3 = Arrays.stream(result1).distinct().toArray(String[]::new);
		for(String str:result3) {
			System.out.println("��ȿ�� ��� ����" + str);
			
		}
		
		System.out.println("��ȿ�� ��� ���� ����" + result3.length);

	}
}
