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
						if (s2.contains(" ")) {
							s3 = s2.replace(s2.substring(s2.indexOf(" "), s2.indexOf(" ") + 1), "");
							//System.out.println("badd 통과: " + s3);
						}

						boolean firstTextMail = f.startsWith("+");
						if (f.contains("+")) {
							if (!firstTextMail) {
								// f문자열 1~3까지의 문자열
								// +기호가 시작되는 부분부터 끝까지 문자열
								// 그 문자열을 f문자열에서 찾아서 빈칸으로 만들기
								String rsubstring = f.substring(f.indexOf("+", 0), f.length());
								//System.out.println("rsubstring 통과: " + rsubstring);
								ff = f.replace(rsubstring, "");
								//System.out.println("ff 통과: " + ff);

							}
						}
						if (ff != null) {
							if (ff.contains(".")) {

								// f문자열에서 .있는 위치를 반환해서 그 위치 문자열을 알아낸후 그만큼한 빈칸으로 변경
								int num = ff.indexOf(".") + 1;
								String rsubstring = ff.substring(ff.indexOf("."), num);
								//System.out.println("rsubstring 통과: " + rsubstring);
								ff = ff.replace(rsubstring, "");
								//System.out.println("ff 통과: " + ff);

							}

							if (s3 != null) {
								result = ff + '@' + s3;
								System.out.println("유효성 통과 성공1" + result);
								result1[k] = result;
							} else {

								result = ff + '@' + s2;

								System.out.println("유효성 통과 성공2" + result);
								result1[k] = result;

							}

						} else {
							if (!firstTextMail) {
								if (s3 != null) {
									ff = f;
									result = ff + '@' + s3;
									result1[k] = result;
									System.out.println("유효성 통과 성공3" + result);
								} else {
									ff = f;
									result = ff + '@' + s2;
									result1[k] = result;
									System.out.println("유효성 통과 성공4" + result);

								}
							}

						}

					}
				}
			}
		}
		//https://hianna.tistory.com/554
		//배열 => stream => 중복제거 => 배열
		String[] result3 = Arrays.stream(result1).distinct().toArray(String[]::new);
		for(String str:result3) {
			System.out.println("유효성 통과 모음" + str);
			
		}
		
		System.out.println("유효성 통과 모음 갯수" + result3.length);

	}
}
