package java0707_statement;

public class Java030_for {

	public static void main(String[] args) {
		int sum = 0;
		int i;
		// for문에서 조건식을 생략할 때는 종료되는 값을 정확히 모를때 생략한다.
		for (i = 1;; i++) {
			sum += i;
			if (sum >= 30) {
				System.out.printf("i=%d sum=%d\n", i, sum);
				break; // 현재 수행중인 반복문을 빠져나온다.
			}
		}
	}
}
