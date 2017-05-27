package java0711_method;

/*피자의 반지름을 10, 도넛의 반지름은 2로 한다.
 * 
 * [실행결과]
 * 자바피자의 면적은 314.0
 * 자바도넛의 면적은 12.56
 */

class Circle {
	int radius; // 원의 반지름을 저장하는 멤버 변수
	String name; // 원의 이름을 저장하는 멤버 변수

	public double getArea() { // 멤버 메소드
		return 3.14 * radius * radius;
	}
}// end class////////////////////////

public class Java066_class {

	public static void main(String[] args) {
		Circle p = new Circle();
		p.name = "자바피자";
		p.radius = 10;

		Circle d = new Circle();
		d.name = "자바도넛";
		d.radius = 2;

		System.out.println(p.name +"의 면적은 " + p.getArea());
		System.out.println(d.name +"의 면적은 " + d.getArea());

	}// end main()

}// end class
