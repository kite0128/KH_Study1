package java0719_api.prob;

import java.util.Random;

/*
 * [문제]
 * 1~20 사이의 난수 10개를 발생시켜 배열에 저장한 후에 리턴하는 
 * makeArray() 메서드와 생성된 배열에서 중복된 숫자를 제거하고 
 * 유일한 숫자만 출력하는 printUniqueNumber() 메서드를 각각 구현하시오.
 * 
 * [프로그램 실행결과]
 * << 발생된 난수 >>
 *  15 7  4  4  8  7  1  11  17  5 
 *  << 중복되지 않은 유일한 숫자 >>
 *  15 8  1  11  17  5

 */
public class Prob002_random {

	public static void main(String[] args) {
		int[] array = makeArray();
		System.out.println("<< 발생된 난수 >>");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("\n<< 중복되지 않은 유일한 숫자 >>");
		printUniqueNumber(array);
	}// end main()

	private static int[] makeArray() {
		// 난수값를 발생시킨후 반환하는 프로그램을 구현하시오.
		Random ran = new Random();
		int[] num = new int[20];
		for (int i = 0; i < num.length; i++) {
			num[i] = ran.nextInt(20) + 1;
		}

		return num;
	}// end makeArray()

	private static void printUniqueNumber(int[] array) {
		// array배열에서 중복되지 않은 유일한 숫자만을 출력하는 프로그램을 구현하시오.
		boolean num2 = false;
		for (int i = 0; i < array.length; i++) {
			num2 = false;
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					num2 = true;
					break;
				}
			} // end for j

			if (num2 == false)
				System.out.printf("%3d", array[i]);
		} // end for i

	}// end printUniqueNumber()
}// end Prob04