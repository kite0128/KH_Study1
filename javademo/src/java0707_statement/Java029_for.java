package java0707_statement;

public class Java029_for {

	public static void main(String[] args) {
		int sum=0;
		int i;
		for(i=1;  ;i++){
			sum+=i;
			if(sum>=30){
				break;
			}
		}
		System.out.printf("i=%d sum=%d\n", i, sum);

	}

}
