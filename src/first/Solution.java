package first;

import java.util.Arrays;

class Solution {

	public int solve(String[] mailCollection) {

		// 배열 => stream => 중복제거 => 배열
		// 최종결과물에서 중복을 제거하고 최종적으로 몇개의 이메일이 나올수있는지 확인, 갯수도

		String[] arrmailResult = new String[mailCollection.length];// 여러개의 mailResult(최종출력물)들을 배열로 만들고 총 갯수와 최종 출력물을 출력

		for (int k = 0; k < mailCollection.length; k++) {
			if (mailCollection[k] != null) {
				if (1 <= mailCollection[k].length() && mailCollection[k].length() <= 100) {
					if (mailCollection[k].contains("@")) {

						String[] mailSplit = mailCollection[k].split("@");
						String mailLocal = mailSplit[0].toLowerCase();
						String mailDomain = mailSplit[1].toLowerCase();
						char[] stringtocharDmail = mailDomain.toCharArray();// 도메인메일부분을 string -> char로바꿔서 배열에 넣어줌
						arrmailResult[k] = chkLmail(mailLocal) + '@' + chkDmail(stringtocharDmail);

					}
				}
			}
		}

		String[] dismailResult = Arrays.stream(arrmailResult).distinct().toArray(String[]::new);
		for (String str : dismailResult) {
			System.out.println("유효성 통과 모음" + str);
		}
		
		return dismailResult.length;

	}

	public String chkLmail(String mailLocal) {

		boolean firstplusLmail = mailLocal.startsWith("+");
		String mailLocalReplace = null;// 이 변수는 전역으로 있어야 순차적으로 바뀌는 문자열을 표현할수있

		// 로컬메일이 +를 가지는 경우
		if (mailLocal.contains("+")) {
			if (!firstplusLmail) {// 로컬메일 첫번째 문자가 +가 아닌경우 -> 정상이메일인 경우
				mailLocalReplace = mailLocal.replace(mailLocal.substring(mailLocal.indexOf("+"), mailLocal.length()),
						"");// 빈문자열로 만들기

				if (mailLocalReplace.contains(".")) {

					mailLocalReplace = mailLocalReplace.replace(mailLocalReplace
							.substring(mailLocalReplace.indexOf("."), mailLocalReplace.indexOf(".") + 1), "");
				}

			}
		} else if (mailLocal.contains(".")) {

			mailLocalReplace = mailLocal
					.replace(mailLocal.substring(mailLocal.indexOf("."), mailLocal.indexOf(".") + 1), "");

		} else {

			mailLocalReplace = mailLocal;
		}

		return mailLocalReplace;

	}

	// 2차 리팩토링 : depth 들여쓰기를 줄여본다.
	// ? public 안에 왜 static만 쓸수있나염
	// 이 함수가 기능을 많이하나? 생각해보니 문자열도 체크하고 .도 체크하고 두가지를 하긴함?
	public String chkDmail(char[] stringtocharDmail) {

		char[] resultDmail = new char[30];// 도메인조작본

		for (int i = 0; i < stringtocharDmail.length; i++) {

			if (chkazDmail(stringtocharDmail[i])) {// a~z일때는 그냥 배열에 넣어주고
				resultDmail[i] = stringtocharDmail[i];
			} else if (chkDotDmail(stringtocharDmail[i])) {// 소문자 제외 .일때도 넣어주는데 .이 아닐때는 빈칸을 넣음
				resultDmail[i] = stringtocharDmail[i];
			} else {
				resultDmail[i] = ' ';
			}
		}

		// 도메인조작을 한 문자열 중에 빈칸이 생기면 그 빈칸을 없앤 문자열을 만들어주는 구간
		String blankDmail = new String(resultDmail);
		if (blankDmail.contains(" ")) {// 도메인 조작을 했으면 조작한 도메인이 출력될꺼임
			blankDmail = blankDmail.replace(blankDmail.substring(blankDmail.indexOf(" "), blankDmail.indexOf(" ") + 1),
					"");

		}

		return blankDmail;
	}

	// 3차 리팩토링 메소드(함수)의 의도가 잘 드러나도록 동등한 수준의 작업을 여러단계로 나눈다.

	public boolean chkazDmail(char stringtocharDmail) {

		return stringtocharDmail >= 'a' && stringtocharDmail <= 'z';

	}

	public boolean chkDotDmail(char stringtocharDmail) {

		return stringtocharDmail == '.';

	}
}

