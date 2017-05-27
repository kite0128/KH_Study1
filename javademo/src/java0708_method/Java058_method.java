package java0708_method;

public class Java058_method {
	
	static char[] arr={'j','a','v','a',' ','t','e','s','t'};
	
	public static void main(String[] args) {
		System.out.println(reverse(arr));
		
	}
	
	public static char[] reverse(char[] data){
		
		char[] num = new char[data.length];
		for(int i=0; i<num.length;i++){
			num[i]=data[data.length-1-i];
		}
		return num;
	}
}
