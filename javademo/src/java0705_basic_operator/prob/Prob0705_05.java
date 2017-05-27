package java0705_basic_operator.prob;

/*
 * 동전교환프로그램
 * 1 가장적은 동전으로 교환할 수 있는 프로그램작성하시오
 * 2 [출력결과]
 *   500원: 15개
     100원: 2개
     50원: 1개
     10원: 2개
     1원: 7개
 */

public class Prob0705_05 {

	public static void main(String[] args) {
		int money = 7777;
		int mok_500=money/500; //500원 개수
		int res_500=money%500; //500원 개수를 뺀 나머지
		
		int mok_100=res_500/100; // 100원 개수
		int res_100=res_500%100; // 100원 개수를 뺀 나머지
		
		int mok_50=res_100/50; // 50원 개수
		int res_50=res_100%50; // 50원 개수를 뺀 나머지
		
		int mok_10=res_50/10; // 10원 개수
		int res_10=res_50%10; // 10원 개수를 뺀 나머지
		
		int mok_1=res_10/1; // 1원 개수
		
		System.out.println("500원 : " + mok_500 + "개");
		System.out.println("100원 : " + mok_100 + "개");
		System.out.println("50원 : " + mok_50 + "개");
		System.out.println("10원 : " + mok_10 + "개");
		System.out.println("1원 : " + mok_1 + "개");
		//여기에 작성하시오
		
	}//end main()

}//end class



