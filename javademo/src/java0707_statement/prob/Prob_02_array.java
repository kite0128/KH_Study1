package java0707_statement.prob;
/*
 * num배열의 합계와 평균을 구하는 프로그램을 구현하시오.
 *  출력결과
 *  합계: ?
 *  평균: ?
 */

public class Prob_02_array {

	public static void main(String[] args) {
       int num[]=new int[]{60,95,88};
       int sum=0;
       double avg=0;
       
       for(int i=0; i<num.length; i++){
    	   sum+=num[i];
    	  
       }
       avg = (double)sum/num.length;
      System.out.println("합계:" +sum);
      System.out.println("평균:" + avg);
	}//end main()

}//end class
