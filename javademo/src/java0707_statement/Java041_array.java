package java0707_statement;

public class Java041_array {

	public static void main(String[] args) {
		int cnt=0; //대문자의 갯수 누적
		char[] data=new char[]{'a','b','F','R','a'};
		
		for(int i=0;i<data.length;i++){
			if(data[i]>='A' && data[i]<='Z'){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
