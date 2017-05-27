package java0719_api;
/*
 * 클래스에서 static 키워드가 선언된 멤버변수, 메소드를 호출할 때 
 * import static을 선언하면 클래스명없이 바로 멤버변수, 메소드를 호출 할 수 있다.
 */
import static java.lang.Math.E;
import static java.lang.Math.sqrt;
import static java.lang.Math.*;
/*
 * 수학관련 클래스
 * java.lang.Math
 */
public class Java130_Math {

	public static void main(String[] args) {
		
		System.out.println(Math.PI); //원주율
		System.out.println(Math.max(10, 20)); //최대값
		System.out.println(Math.min(10, 20)); //최소값
		System.out.println(E); //지수
		System.out.println(sqrt(25)); //제곱근	
		System.out.println(pow(2,3)); //거듭제곱
	}

}
