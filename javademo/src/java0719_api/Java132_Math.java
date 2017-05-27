package java0719_api;

/*
 * 난수를 이용해서 소수점 첫째자리까지 반올림해서 구하시오.
 * ex)0.5689.... => 5.7
 */
public class Java132_Math {

	public static void main(String[] args) {
			double nan = Math.random();
			System.out.println(nan);
			nan = nan*100;
			long data = Math.round(nan);
			double num = (double)data/10;
			System.out.println(num);

	}


}
