package java0715_abstract_interface;

//ctrl + shift + o => 임포트하지 않은 것이 여러개일 때 유용!
import java.io.Serializable;

/*
 * 인터페이스(interface)
 * 1 추상메소드와 상수만 가지고 있는 형태이다.
 * 2 클래스 작성에 도움을 줄 목적으로  제공이 되는 표준 명세서이다.
 * 3 implements : 클래스에 인터페이스를 상속할때 사용되는 키워드이다.
 * 4 인터페이스는 다중상속이 된다.
 * 5 인터페이스는 접근제어자로 public, protected만 제공된다.
 *   default로 선언된 멤버변수,메소드는 컴파일러에서 public으로 처리한다.
 * 6 인터페이스에서는 추상메소드에 abstract키워드는 명시 하지 않으면
 *   컴파일러가 abstract키워드를 붙여 처리한다.
 */
interface CarRun{
	int car_count=0; //public static final;
	void work(); //public abstract
}

class TrunkRun implements CarRun, Serializable{

	@Override
	public void work() {
		System.out.println("트럭이 짐을 싣고 있다.");
		
	}
	
}

public class Java099_interface {

	public static void main(String[] args) {
		
		//CarRun cr = new CarRun();
		TrunkRun tr = new TrunkRun();
		tr.work();

	}

}
