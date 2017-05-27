package java0708_method.prob;

/* 
 *  [출력결과]
 * 	 35276은 숫자입니다.
 * 	 2_8a은 문자입니다.
 */


public class Prob002_method {
	public static void main(String[] args) {
		System.out.print("12345는 ");
		prnDisplay(numCheck("12345"));

		System.out.print("315a_a은 ");
		prnDisplay(numCheck("315a_a은"));
	}// end main()

	public static boolean numCheck(String data) { // 35a2243
		// data값이 숫자면 true 아니면 false을 반환하는 로직 구현
		char check;
		
		for(int i=0; i<data.length(); i++){
			check = data.charAt(i);
			if(check<48 || check>57){
				return true;
			}
		}
		return false;
	}// end numCheck()

	public static void prnDisplay(boolean chk) {
		// chk값이 true이면 "숫자입니다."
		// chk값이 false이면 "문자입니다." 로 출력하는 로직구현
		if(chk)
			System.out.println("문자입니다.");
		else
			System.out.println("숫자입니다.");
		

	}// end prnDisplay()

}// end class
