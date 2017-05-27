package java0708_method;

public class Java055_method {

	public static void main(String[] args) {
		int data = 10;
		boolean res = process(data);
		if (res)
			System.out.printf("%d는(은) 짝수입니다.\n", data);
		else
			System.out.printf("%d는(은) 홀수입니다.\n", data);
	}

	public static boolean process(int data) {
		// data 매개변수의 값이 짝수이면 true, 홀수이면 false를 리턴하는 프로그램
		if (data % 2 == 0) 
			return true;
		else
			return false;
	}

}
