package java0720_api.prob;
/*
 * javac Prob001_String.java
 * java Prob001_String JAva Test
 */

/*1 프로그램 실행할때  "JAva Test" 문자열을 args배열에서 값을 받아 출력결과에 같이
 *  나오도록 프로그램을 구현하시오.
 *  java Prob001_String JAva Test
 *   * 
 * 2 출력결과
 *   source : JAva Test 
 *   convert: jaVA tEST
 *   length: 9
 *   reverse : tseT avAJ
 *   
 '0' => 48
 'a' => 97
 'A' => 65
 */

public class Prob001_String {

	public static void main(String[] args) {

		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.printf("source : %s %s", args[0], args[1]);
		System.out.println();

		char[] arr = new char[args[0].length() + args[1].length() + 1];
		
		String data="";
		for (int i = 0; i < args[0].length() + 1; i++) {
			if (i == args[0].length()) {
				arr[i] = ' ';
				break;
			}
			arr[i] = args[0].charAt(i);

		}

		for (int i = 0; i < args[1].length(); i++) {
			arr[args[0].length() + 1 + i] = args[1].charAt(i);
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 'z' && arr[i] >= 'a') {
				arr[i] = (char) (arr[i] - 32);
			} else if(arr[i] <= 'Z' && arr[i] >= 'A')
			{
				arr[i] = (char) (arr[i] + 32);
			}
			
			data += arr[i];
		}
		
		String data2 = args[0] + " " + args[1]; 
		StringBuffer sb = new StringBuffer(data2);
		
		System.out.printf("convert : %s", data);
		System.out.println();
		System.out.printf("length : %d", arr.length);
		System.out.println();
		System.out.printf("reverse : %s", sb.reverse());
	}

}// end class
