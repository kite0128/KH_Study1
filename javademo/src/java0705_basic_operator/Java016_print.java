package java0705_basic_operator;

public class Java016_print {

	public static void main(String[] args) {
		System.out.println("java");
		System.out.print("jsp\t");
		System.out.print("spring\n");
		
		/*
		 * 출력기호
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %b : 논리
		 * %s : 문자열 
		 */
		// System.out.printf("출력형식",값1,값2,값3...);
		System.out.printf("%s 님의 평균은 %f 이므로 %c 입니다.\n","홍길동",95.0,'A');
		System.out.printf("당신의 색깔은 \"%s\" 입니다.\n","빨강");
		System.out.printf("%d %% %d = %d\n", 3, 2, 3 % 2);
		System.out.printf("%s\n", "abcdefghi");
		System.out.printf("%5s\n", "ab");
		System.out.printf("%6s\n","자바");
		System.out.printf("%f\n",12345.45);
		System.out.printf("%5.1f\n",12.4);
		
	}

}
