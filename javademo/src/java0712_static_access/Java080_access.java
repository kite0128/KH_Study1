package java0712_static_access;
//외부클래스의 위치를 알려주기 위해서 사용한다
import java.util.Scanner;
import java.awt.Frame;

/*
 * package 패키지명;
 * import 패키지명.클래스명;
 * import 패키지명.인터페이스명;
 * 
 * class 클래스명{
 *   static{ } : 클래스가 메모리에 로딩되는 시점에 멤버변수의 값을 할당한다.
 *   멤버변수 : 객체의 특징
 *   생성자 : 멤버변수에 초기값 할당
 *   메소드 : 객체의 동작-객체가 가지고 있는 값을 이용해서 계산하는 기능이다
 * }
 * 
 * package : 
 * 1 비슷한 작업을 수행하는 클래스 및 인터페이스를 묶어줄때 사용한다.
 * 2 open API에서 제공하는 클래스 및 인터페이스명의 중복을 피하기 위해서 사용한다.
 *    domain : www.naver.com
 *    package : com.naver.클래스명(인터페이스명);
 * 
 * 접근제어자 (access modifier)
 *  : 멤버 또는 클래스에 사용되어, 외부로부터의 접근을 제한한다.
 *  1 private : 같은 클래스내에서만 접근이 가능하다.
 *  2 default : 같은 패키지내에서만 접근이 가능하다.
 *  3 protected : 같은 패키지내에서, 그리고 다른 패키지의 자손클래스에서 접근이가능하다.
 *  4 public  : 접근 제한이 없다.
 *  
 *  클래스 : default, public 사용가능하다.
 *  변수, 생성자, 메소드 : private, default, protected, public사용가능하다.
 *  
 <객체지향의 조건>
1) 캡슐화 : 연관된 데이터와 함수를 논리적으로 묶어놓은 것이며, 데이터를 보호하기 위해 다른 객체의 접근을 제한하는 접근 제한 수식자의 기능을 제공한다
	예시) articleListVO , 콘텐 600
	다양한 감기약들이 여러가지 기능을 위임한다.
	
2) 상속 : 클래스를 확장시키는 것
	실제로 Java에서는 확장만 있고 상속이라는 것은 없다.

3) 다형성 : 여러가지 다양한 인스턴스를 생성할 수 있다는 것?
	인터페이스에 대한 이야기다. 즉, 한 인터페이스로 여러개의 구현체를 만들 수 있다는 이야기
	예를 들어 TV라는 객체가 있다면 삼성 TV, LG TV  등 다양하게 만들 수 있다.

4) 추상화 : 구현체는 없는 일반적인 method만 선언되어 있는 것
	인터페이스가 추상화다. 추상화를 적용받는 것은 인터페이스와 추상클래스이다.
	정확히 어떤일을 하는지는 모르지만 대충 어떤일을 할 것을 말하는 것

5) 정보 은닉 : Class 안에서 어떤일이/ 기능이 이루어 지는지 몰라야 한다는 것이다
	private이 있어야 하고 그것을 제어하는 것이 getter/setter 이때, 적절한 필터가 들어가야 한다.
	어떤 실행을 할 수 있는 것만 주고 내부적인 것은 모두 private으로 바꾸는 것
	
 *  
 *  
 */

public class Java080_access {

	private int var_private=1;
				int var_default=2;
	protected int var_protected=3;
	public int var_public=4;
		
}
