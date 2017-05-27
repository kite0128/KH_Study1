package java0714_inheritance;

class SuperConst{
	int x;
	int y;
	//생성자가 만들어져 있어서 무인자 생성자가 제공되지 않는다
	public SuperConst(int x, int y){
		this.x=x;
		this.y=y;
		System.out.printf("x=%d y=%d\n", x, y);
	}
}

class SubConst extends SuperConst{
	SubConst(){
		super(10, 20);
	}
}

public class Java088_inheritance {

	public static void main(String[] args) {
		SubConst sc = new SubConst();

	}

}
