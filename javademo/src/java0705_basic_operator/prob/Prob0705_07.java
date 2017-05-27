package java0705_basic_operator.prob;
/*
    1.jumsu변수에 저장된 값에 따라 상, 중, 하를 출력하는 프로그램을 작성하시오.
	 jumsu변수의 값이 80이상이면 상	 80미만 65이상이면 중     65미만이면 하 로 출력하시오.
    2. [출력결과]
       상
 */

public class Prob0705_07 {

	public static void main(String[] args) {
		 int jumsu = 85;
		 String res;
		 
		 res = (jumsu>=80) ? "'상' 입니다." : ((65<=jumsu && jumsu<80) ? "'중' 입니다." : "'하' 입니다.");
		 System.out.println(res);
		
      
	}//end main()

}//end class




