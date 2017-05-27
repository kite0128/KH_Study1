package java0720_api.prob;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * [출력결과]
 *  영어 소문자 갯수:3
 *  영어 대문자 갯수:3
 *  숫자 갯수:2
 */

public class Prob006_String {

	public static void main(String[] args) {
		String data = "ke4RdTA5";

		display(process(data));
	}// end main()

	public static char[] process(String data) {
		/*
		 * Pattern lowerCase = Pattern.compile("[a-z]");
		Pattern upperCase = Pattern.compile("[A-Z]");
		Pattern intNum = Pattern.compile("[0-9]");

		int lowerCount = 0;
		int upperCount = 0;
		int numCount = 0;

		Matcher matLowerCase = lowerCase.matcher(data);
		Matcher matUpperCase = upperCase.matcher(data);
		Matcher matNum = intNum.matcher(data);
		while (matLowerCase.find()) {
			lowerCount++;
		}
		while (matUpperCase.find()) {
			upperCount++;
		}
		while (matNum.find()) {
			numCount++;
		}

		int[] arr = new int[]{lowerCount, upperCount, numCount};

		return arr;
		 */
		
		return null;
	}// end process()

	public static void display(char[] arr) {
		System.out.println("영어 소문자 갯수:" + arr[0]);
		System.out.println("영어 대문자 갯수:" + arr[1]);
		System.out.println("숫자 갯수:" + arr[2]);
		
		
		
	}// end display()

}// end class
