package first;

public class Solution {

	public static void main(String[] args) {

		// String mail = "alsgp0877@naver.com"; 1) �����̸����� ���
		// String mail = "test.email+james@coding.com"; 2) �����̸��� .�� +�� ���ÿ� �� ���
		// String mail = "test@cod+ing.com"; 3) ������ �̸��� .�� +�� ���ÿ� �� ���
		String mail = "te.st+james@coding.com"; // 4) �����̸��� �������̸��� ���ÿ� . + �� �� ���
		// String mail = "+test@coding.com"; 5) �����̸��� ÷�� +�� �� ���
		String result = null;
		String ff = null;
		char[] badd = new char[30];

		if (mail != null) {
			if (1 <= mail.length() && mail.length() <= 100) {
				if (mail.contains("@")) {

					String[] mailSplit = mail.split("@");
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
					if(s2.contains(" ")) {
						s3 = s2.replace(s2.substring(s2.indexOf(" "),s2.indexOf(" ")+1), "");
						System.out.println("badd ���: " + s3);
					}
					
					


					boolean firstTextMail = f.startsWith("+");
					if (f.contains("+")) {
						if (!firstTextMail) {
							// f���ڿ� 1~3������ ���ڿ�
							// +��ȣ�� ���۵Ǵ� �κк��� ������ ���ڿ�
							// �� ���ڿ��� f���ڿ����� ã�Ƽ� ��ĭ���� �����
							String rsubstring = f.substring(f.indexOf("+", 0), f.length());
							System.out.println("rsubstring ���: " + rsubstring);
							ff = f.replace(rsubstring, "");
							System.out.println("ff ���: " + ff);

						}
					}
					if (ff != null) {
						if (ff.contains(".")) {

							// f���ڿ����� .�ִ� ��ġ�� ��ȯ�ؼ� �� ��ġ ���ڿ��� �˾Ƴ��� �׸�ŭ�� ��ĭ���� ����
							int num = ff.indexOf(".") + 1;
							String rsubstring = ff.substring(ff.indexOf("."), num);
							System.out.println("rsubstring ���: " + rsubstring);
							ff = ff.replace(rsubstring, "");
							System.out.println("ff ���: " + ff);

						}
						
						if(s3 != null) {
							result = ff + '@' + s3;
							System.out.println("��ȿ�� ��� ����" + result);
						}else {
							
							result = ff + '@' + s2;
							System.out.println("��ȿ�� ��� ����" + result);
							
						}

					} else {
						if (!firstTextMail) {
							if(s3 != null) {
								result = ff + '@' + s3;
								System.out.println("��ȿ�� ��� ����" + result);
							}else {
								
								result = ff + '@' + s2;
								System.out.println("��ȿ�� ��� ����" + result);
								
							}
						}

					}

				}
			}
		}
	}
}
