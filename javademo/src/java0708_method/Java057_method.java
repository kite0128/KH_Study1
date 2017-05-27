package java0708_method;

public class Java057_method {

	public static void main(String[] args) {
		int year = 2012;

		if (isLeapYear(year)) {
			System.out.printf("%d년은 윤년입니다.", year);
		} else {
			System.out.printf("%d년은 평년입니다.", year);
		}

	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}
}
