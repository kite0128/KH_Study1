package java0719_api;

import static java.lang.Math.*;

public class Java131_Math {

	public static void main(String[] args) {
		
		//0.0부터 1.0미만 사이의 난수 발생
		double ran = random();
		ran=ran*10; //0.0~10.0 미만 사이의 수
		int num=(int)floor(ran); //소수 이하는 버리고 0~10 미만을 리턴한다. => 반올림이 안된다.
		System.out.println(num);

	}

}
