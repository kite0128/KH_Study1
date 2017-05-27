package java0718_api;

import java.util.regex.Pattern;

public class String123_regexp {

	public static void main(String[] args) {
		String sn = "12345";
		String sb = "2asba5";
		String st = "aabbcc";

		// a-z A-Z _ * $가 sn변수에 포함이 되어 있으면 true, 아니면 false을 리턴한다.
		System.out.println(sn.matches(".*[a-zA-Z_*$].*"));

		// sn변수에 0-9가 포함이 되여 있으면 true 아니면 false을 리턴한다.
		System.out.println(sn.matches(".*[0-9].*"));
		System.out.println(sn.matches(".*[\\d].*"));

		// sb변수에 저장된 값이 2로 시작이되면 true을 리턴하고 아니면 false을 리턴한다.
		System.out.println(sb.matches("2.*"));

		// sb변수에 저장된 값이 2로 시작되고 5로 끝나면 true리턴 아니면 false을 리턴한다.
		System.out.println(sb.matches("2.*5"));

		// sb변수에 저장된 문자열이 a 이거나 b로 시작하고 5자리 문자열이면 true 아니면 false을 리턴한다.
		System.out.println("////");
		System.out.println(sb.matches("[ab].{5}"));

		// st변수에 저장된 문자열이 a 또는 b로 시작하고 cc로 끝나면서
		// 사이에는 임의문자가 최소 1개에서 최대4개를 포함한다.
		System.out.println("////");
		System.out.println(st.matches("[ab].{1,4}cc"));

		String input1 = "11mar123dd";
		String input2 = "maaaaa";
		String input3 = "252352";
		/*
		 * Pattern.matches() : 빠르게 어떠한 text(String)이 주어진 Pattern 에 있는지를 확인한다.
		 * Pattern.compile() : 여러개의 텍스트를 재사용 가능한 Pattern 인스턴스로 컴파일 한다.
		 */
		System.out.println("////");
		
		System.out.println(input1.matches("[\\w]{5,10}") && Pattern.compile("[\\d]").matcher(input1).find()
				&& Pattern.compile("[a-zA-Z]").matcher(input1).find());
		
		System.out.println(input2.matches("[\\w]{5,10}") && Pattern.compile("[\\d]").matcher(input2).find()
				&& Pattern.compile("[a-zA-Z]").matcher(input2).find()); //2번째 것이 false이기 때문에 3번째 것을 실행하지 않는다
		
		System.out.println(input3.matches("[\\w]{5,10}") && Pattern.compile("[\\d]").matcher(input3).find()
				&& Pattern.compile("[a-zA-Z]").matcher(input3).find());
	}

}
