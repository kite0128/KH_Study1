package java0705_basic_operator;
/*
 * 연산자 우선숙위
 * 단항연산자>산술연산자>비교연산자>논리연산자>삼항연산자>대입연산자
 */
public class Java014_operator {

	public static void main(String[] args) {
		int a=3;
		int b=4;
		int res;
		
		res = a+b;
		// '=' 연산자를 기준으로 좌변과 우변이 같을 때는 대입복합연산자를 사용할 수 있다.
		//res = res + a;
		res += a;

	}

}
