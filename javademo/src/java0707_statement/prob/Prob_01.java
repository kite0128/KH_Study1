package java0707_statement.prob;

/*
for문을 이용해서 12의 약수를 구하시오
약수 : 어떤 수를 나누어서 0으로 떨어진 수
1
2 
3 
4 
6 
12
*/

public class Prob_01 {

	public static void main(String[] args) {
		int num=12;
			
		for(int i=1;i<=num;i++){
			if(num%i==0){
				System.out.printf("%d " ,i);
			}
		}
		
		
		

	}//end main()

}//end class













