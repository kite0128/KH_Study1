package java0707_statement;

public class Java039_array {

	public static void main(String[] args) {
		/*	
			int ko=90;
			int en=80;
			int jp=40;
		*/
		
		int[] jumsu=new int[3]; //'new'는 객체를 생성하기 위해 사용되는 키워드!
		/*
		 * new : 힙 메모리에 배열을 생성해주는 키워드이다.
		 * 배열에 저장된 값을 요소(element)라 한다.
		 * 배열은 생성될 때 요소에 접근할 수 있도록 인덱스가 제공된다.
		 * 인덱스는 0부터 시작한다.
		 * 배열의 크기를 리턴해주는 키워드는 length 이다.
		 */
		for(int i=0; i<jumsu.length; i++){
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
		
		jumsu[0]=90;
		jumsu[1]=80;
		jumsu[2]=40;
		
		for(int i=0; i<3; i++){
			System.out.printf("jumsu[%d]=%d\n",i,jumsu[i]);
		}
		
		String data="java";
		System.out.println("문자열길이 : "+data.length());
	}

}
