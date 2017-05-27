package java0704_basic;

//주석 : 코드에 대한 설명의 의미한다.

//하나의 라인에 대한 주석

/*
 * 여러 라인에 대한 주석 
 * 
 */

/*
 * 자바에서 제공하는 데이터타입
 *  1. 기본 데이터 타입
 * 		숫자:정수=> byte(1byte), short(2), int(4), long(8)
 * 			   실수=>float(4), double(8)
 * 		문자:char(2byte)
 * 		논리:boolean(1byte)
 *  2. 참조 데이터 타입
 *  	배열, 클래스, 인터페이스
 *  
 *  시스템에서 인식하는 데이터 타입의 크기
 *  byte < short,char < int < long < float < double
 */

public class Java003_dataType {

	public static void main(String[] args) {
		//변수 : 하나의 값을 저장하기 위한 메모리 공간
		int num = 10;    
		double data=1.5;
		// -128~127
		byte check = 127;
		// -32768 ~ 32767
		short kt = 127;
		
		long ko = 43L;
		
		float avg=4.5F;
		
		char alpa = 'a';
		
		double sum = 9.3;
		
		boolean is = true;
		
		is = false;
	}

}
