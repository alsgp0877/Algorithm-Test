package first;

public class Solution {

	public static void main(String[] args) {

		// String mail = "alsgp0877@naver.com"; 1) 정상이메일인 경우
		// String mail = "test.email+james@coding.com"; 2) 로컬이름이 .과 +가 동시에 들어간 경우
		// String mail = "test@cod+ing.com"; 3) 도메인 이름이 .과 +가 동시에 들어간 경우
		String mail = "te.st+james@coding.com"; // 4) 로컬이름과 도메인이름이 동시에 . + 가 들어간 경우
		// String mail = "+test@coding.com"; 5) 로컬이름젤 첨에 +가 들어간 경우
		String result = null;
		String ff = null;
		char[] badd = new char[30];

		if (mail != null) {
			if (1 <= mail.length() && mail.length() <= 100) {
				if (mail.contains("@")) {

					String[] mailSplit = mail.split("@");
					String f = mailSplit[0].toLowerCase();
					String b = mailSplit[1].toLowerCase();
					// 도메인이름에 영어와 . 이외의 문자가 들어오면 없애주기
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
						System.out.println("badd 통과: " + s3);
					}
					
					


					boolean firstTextMail = f.startsWith("+");
					if (f.contains("+")) {
						if (!firstTextMail) {
							// f문자열 1~3까지의 문자열
							// +기호가 시작되는 부분부터 끝까지 문자열
							// 그 문자열을 f문자열에서 찾아서 빈칸으로 만들기
							String rsubstring = f.substring(f.indexOf("+", 0), f.length());
							System.out.println("rsubstring 통과: " + rsubstring);
							ff = f.replace(rsubstring, "");
							System.out.println("ff 통과: " + ff);

						}
					}
					if (ff != null) {
						if (ff.contains(".")) {

							// f문자열에서 .있는 위치를 반환해서 그 위치 문자열을 알아낸후 그만큼한 빈칸으로 변경
							int num = ff.indexOf(".") + 1;
							String rsubstring = ff.substring(ff.indexOf("."), num);
							System.out.println("rsubstring 통과: " + rsubstring);
							ff = ff.replace(rsubstring, "");
							System.out.println("ff 통과: " + ff);

						}
						
						if(s3 != null) {
							result = ff + '@' + s3;
							System.out.println("유효성 통과 성공" + result);
						}else {
							
							result = ff + '@' + s2;
							System.out.println("유효성 통과 성공" + result);
							
						}

					} else {
						if (!firstTextMail) {
							if(s3 != null) {
								result = ff + '@' + s3;
								System.out.println("유효성 통과 성공" + result);
							}else {
								
								result = ff + '@' + s2;
								System.out.println("유효성 통과 성공" + result);
								
							}
						}

					}

				}
			}
		}
	}
}
