package first;

import java.util.Arrays;

//1차 리팩토링 : 이름을 좀 알아보기 쉽게 짓는다.

public class Solution2 {

	public static void main(String[] args) {

		String[] mailCollection = { "test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com"};
		String mailResult = null; //문자열 조작을 거쳐서 결국 최종적으로 나오는 메일문자열
		String[] arrmailResult = new String[3];//여러개의 mailResult(최종출력물)들을 배열로 만들고 총 갯수와 최종 출력물을 출력
		String mailReplace = null;//로컬메일조작본


		for (int k = 0; k < mailCollection.length; k++) {
			if (mailCollection[k] != null) {
				if (1 <= mailCollection[k].length() && mailCollection[k].length() <= 100) {
					if (mailCollection[k].contains("@")) {

						String[] mailSplit = mailCollection[k].split("@");
						String mailLocal = mailSplit[0].toLowerCase();
						String mailDomain = mailSplit[1].toLowerCase();
						// 도메인이름에 영어와 . 이외의 문자가 들어오면 없애주기
						char[] stringtocharDmail = mailDomain.toCharArray();//도메인메일부분을 string -> char로바꿔서 배열에 넣어줌
						
						
						//도메인조작을 한 문자열 중에 빈칸이 생기면 그 빈칸을 없앤 문자열을 만들어주는 구간
						String blankDmail = new String(chkDotInDmail(stringtocharDmail)); //도메인 조작을 안했으면 blankDmail이 그냥 출력되고
						String chkBlankDmail = null;
						if (blankDmail.contains(" ")) {//도메인 조작을 했으면 조작한 도메인이 출력될꺼임
							chkBlankDmail = blankDmail.replace(blankDmail.substring(blankDmail.indexOf(" "), blankDmail.indexOf(" ") + 1), "");
	
						}
						
						
						boolean firstplusLmail = mailLocal.startsWith("+");
						//로컬메일이 +를 가지는 경우
						if (mailLocal.contains("+")) {
							if (!firstplusLmail) {//로컬메일 첫번째 문자가 +가 아닌경우 
								// f문자열 1~3까지의 문자열
								// +기호가 시작되는 부분부터 끝까지 문자열
								// 그 문자열을 f문자열에서 찾아서 빈칸으로 만들기
								String rsubstring = mailLocal.substring(mailLocal.indexOf("+", 0), mailLocal.length());
								//System.out.println("rsubstring 통과: " + rsubstring);
								mailReplace = mailLocal.replace(rsubstring, "");
								//System.out.println("ff 통과: " + ff);

							}
						}
						//앞에서 로컬메일이 + 조작을 거쳤을경우 
						if (mailReplace != null) {
							//로컬메일이 .를 가지는 경우
							if (mailReplace.contains(".")) {

								// f문자열에서 .있는 위치를 반환해서 그 위치 문자열을 알아낸후 그만큼한 빈칸으로 변경
								int num = mailReplace.indexOf(".") + 1;
								String rsubstring = mailReplace.substring(mailReplace.indexOf("."), num);
								mailReplace = mailReplace.replace(rsubstring, "");

							}
							//도메인조작을 거쳤을 경우 
							if (chkBlankDmail != null) {
								mailResult = mailReplace + '@' + chkBlankDmail;
								arrmailResult[k] = mailResult;
							} else {//도메인조작을 안거쳤을경우 

								mailResult = mailReplace + '@' + blankDmail;
								arrmailResult[k] = mailResult;

							}

						} else {//앞에서 로컬메일이 + 조작을 안거쳤을경우 
							if (!firstplusLmail) {//+ 조작을 안거쳤기 때문에 +가 첨에 있는지 검사해줘야함
								if (chkBlankDmail != null) {//도메인조작을 거쳤을 경우 
									mailReplace = mailLocal;//로컬메일 조작을 안한 그냥 메일로 바꿔주기
									mailResult = mailReplace + '@' + chkBlankDmail;
									arrmailResult[k] = mailResult;

								} else {//도메인조작을 안거쳤을 경우 
									mailReplace = mailLocal;//로컬메일 조작을 안한 그냥 메일로 바꿔주기
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
		//배열 => stream => 중복제거 => 배열
		//최종결과물에서 중복을 제거하고 최종적으로 몇개의 이메일이 나올수있는지 확인, 갯수도 
		String[] distinctResult = Arrays.stream(arrmailResult).distinct().toArray(String[]::new);
		for(String str:distinctResult) {
			
			System.out.println("유효성 통과 모음" + str);
			
		}
		
		System.out.println("유효성 통과 모음 갯수" + distinctResult.length);

	}
	
	//2차 리팩토링 : depth 들여쓰기를 줄여본다.
	//? public 안에 왜 static만 쓸수있나염
	//이 함수가 기능을 많이하나? 생각해보니 문자열도 체크하고 .도 체크하고 두가지를 하긴함?
	private static char[] chkDotInDmail(char[] stringtocharDmail) {
		
		char[] resultDmail = new char[30];//도메인조작본
		
		for (int i = 0; i < stringtocharDmail.length; i++) {
	
			if (chkazDmail(stringtocharDmail[i])) {//a~z일때는 그냥 배열에 넣어주고
				resultDmail[i] = stringtocharDmail[i];
			} else if (chkDotDmail(stringtocharDmail[i])) {//소문자 제외 .일때도 넣어주는데 .이 아닐때는 빈칸을 넣음
				resultDmail[i] = stringtocharDmail[i];
			} else {
				resultDmail[i] = ' ';
			}
		}

		return resultDmail;
	}
	
	//3차 리팩토링 메소드(함수)의 의도가 잘 드러나도록 동등한 수준의 작업을 여러단계로 나눈다. 

	private static boolean chkazDmail(char stringtocharDmail) {
		
		return stringtocharDmail >= 'a' && stringtocharDmail <= 'z';
		
	}
	
	private static boolean chkDotDmail(char stringtocharDmail) {
		
		return stringtocharDmail == '.';
		
	}
	

}
