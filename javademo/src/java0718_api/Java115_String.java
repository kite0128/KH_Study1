package java0718_api;

public class Java115_String {
		public static void main(String[] args) {
			String str = new String("koREa,jsp,java");
			System.out.println("문자열 길이 : " + str.length());
			System.out.println("대문자 : " + str.toUpperCase());
			System.out.println("소문자 : " + str.toLowerCase());
			System.out.println("문자 : " + str.charAt(1)); //charAt(index);
			System.out.println("인덱스 : " + str.indexOf('R')); // indexOf('특정문자');
			System.out.println("범위 : " + str.substring(5)); //5(index) 부터 나머지 끝까지
			System.out.println("범위 : " + str.substring(2, 8)); //REa, js
			
			String[] arr = str.split(",");
			for(int i=0; i<arr.length; i++)
				System.out.printf("arr[%d]=%s\n", i, arr[i]);
			
			int x=10;
			int y=20;
			System.out.printf("%d+%d=%d\n", x, y, x+y);
			
			//valueOf()는 static이 선언되어 있기 때문에 class.메소드() 생성이 가능(객체 생성 없이)
			String s1 = String.valueOf(x);
			String s2 = String.valueOf(y);
			System.out.printf("%s+%s=%s\n", s1, s2, s1+s2);
			
			char[] data = {'1','2','3'};
			String s3 = String.valueOf(data);
			System.out.println(data);
		}
}
