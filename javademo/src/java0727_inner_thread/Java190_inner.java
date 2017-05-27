package java0727_inner_thread;
/*
 * 지역클래스에서 외부클래스 메서드의 매개변수, 지역변수를
 * 호출하기 위해서는 final이 선언되여 있어야 한다.
 * 하지만, jdk8버전부터는 final이 선언되어 있지 않아도 호출이 가능하다.
 */
class OuterLocal {
	private int x;
	static int y;
	final private int z = 10;

	public void call(final int a) {
		final int b = 20;
		int c = 30;
		//c = 50;
		
		class InnerLocal {
			void prn() {
				x = 5;
				y = 150;
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				System.out.println("z=" + z);
				System.out.println("a=" + a);
				System.out.println("b=" + b);
				//외부클래스에서 선언한 변수를 내부클래스에서 다시 선언하여 할당할 때는 'final'로 인식한다.(미리 선언되어 있어야 한다)
				//c = 40;
			}
		}

		InnerLocal inner = new InnerLocal();
		inner.prn();
	}

}

public class Java190_inner {

	public static void main(String[] args) {
		OuterLocal outer = new OuterLocal();
		outer.call(100);
	}

}
