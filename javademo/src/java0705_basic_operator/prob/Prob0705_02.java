package java0705_basic_operator.prob;

/*
 * data변수의 값이 대문자 이면 'A', 소문자이면 'a'을 
 * 출력하는 프로그램을 구현하시오.
 * [실행결과]
 * a
 */
/*
'0' => 48
'a' => 97
'A' => 65
*/

public class Prob0705_02 {

	public static void main(String[] args) {
		char data='z'; //A ~ Z  a~z
		//여기에 작성하시오
		
		char res = (char)(data<97 ? 'A' : 'a');
		System.out.println(res);
	}

}







