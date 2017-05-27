package java0707_statement;

public class Java033_for {

	public static void main(String[] args) {
		int cnt=0;
		int sum=0;
		for(int row=1; row<=5; row++){
			sum=0;
			for(int col=1; col<=5; col++){
				System.out.printf("%d\t",++cnt);
				sum+=cnt;
			}
			System.out.println(sum);
		}

	}

}
