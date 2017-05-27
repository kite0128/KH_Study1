package java0705_basic_operator;

public class Java009_operator {

	public static void main(String[] args) {
		int x=3;
		x++;
		System.out.println(x);
		++x;
		System.out.println(x);
		
		int y=4;
		int z=2;
		// 변수앞에 ++가 있으면 변수의 값을 먼저 증가시키고 +연산이 수행된다
		int res = ++y + z;
		System.out.println(res);

	}

}
