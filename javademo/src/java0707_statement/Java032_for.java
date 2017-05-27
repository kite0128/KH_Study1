package java0707_statement;

public class Java032_for {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			if(i%3==0){
				continue; // 반복문에서 그냥 지나간다
			}
			System.out.println(i);
		}

	}

}
