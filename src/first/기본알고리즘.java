package first;

import java.util.Scanner;

public class 기본알고리즘 {

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
							//f문자열 1~3까지의 문자열
							//+기호가 시작되는 부분부터 끝까지 문자열
							//그 문자열을 f문자열에서 찾아서 빈칸으로 만들기
							String rsubstring = f.substring(f.indexOf("+",0), f.length());
							f.replace(rsubstring, "");
						}
						
						if(f.contains(".")) {
							
							//f문자열에서 .있는 위치를 반환해서 그 위치 문자열을 알아낸후 그만큼한 빈칸으로 변경
							String rsubstring = f.substring(f.indexOf(".",0));
							f.replace(rsubstring, "");
						}
						
						//TODO 도메인은 .문자만허용 + 문자는 허용안함
						
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
