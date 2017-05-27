package java0718_api;

public class Java117_String {

	public static void main(String[] args) {
		String p1="홍길동,561203-1597650";
		String p2="응삼이,030628-4056892";
		display(p1);
		display(p2);

	}
	
	public static void display(String str){
		
		/*String gen = "";
		String[] arr = str.split(",");
		
		if()
		
		System.out.println(arr[0] + "님은 " +  + "입니다.");
		System.out.println(arr[1] + "님은 " +  + "입니다.");
		*/
		
		String[] arr = str.split(",");
		char data = arr[1].charAt(7);
		if(data=='1' || data=='3')
			System.out.printf("%s님은 남성입니다.\n", arr[0]);
		else if(data=='2' || data=='4')
			System.out.printf("%s님은 여성입니다.\n",arr[0]);
		else
			System.out.println("잘못입력하셨습니다.");
	}

}
