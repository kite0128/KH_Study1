package java0706_statement;
/*
 * 1. data변수에 저장된 값이 영문자 대문자이면 "대문자입니다", 소문자이면 "소문자입니다"
 *    그외는 "기타입니다"로 출력하는 프로그램을 구현하시오.
 * 2. [출력결과] 
 * data='D'  => 대문자입니다.
 * data='d'  => 소문자입니다.
 * data='1'  => 기타입니다.  
 *    
 */
public class Java021_if {

	public static void main(String[] args) {
		char data='A';
		
		if(data >= 97){
			System.out.printf("%s는 소문자입니다.", data);
		}else if(data<97 && data>=65){
			System.out.printf("%s는 대문자입니다.", data);
		}else{
			System.out.println("기타입니다.");
		}
		

	}

}
