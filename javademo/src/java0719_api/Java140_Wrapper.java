package java0719_api;

/*
 * sn변수에 저장된 문자열중에서 숫자갯수를 출력하는 프로그램을 구현하시오.
 * [출력결과]
 * 숫자갯수:3
 */

public class Java140_Wrapper {

	public static void main(String[] args) {
     String sn="korea12 paran3";
     int sum = 0;
     for(int i=0; i<sn.length(); i++){
    	 char data = sn.charAt(i);
    	 //data가 숫자면 true, 아니면 false을 리턴
    	 if(Character.isDigit(data))
    		sum++;
     }
     
     System.out.println("숫자갯수 : " + sum);
     
	}// end main()

}// end class
