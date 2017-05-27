package java0714_inheritance;

class Parent {
	String name;
	int age;

	public Parent() {

	}

	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Sun extends Parent {
	String dept;

	public Sun() {

	}

	public Sun(String name, int age, String dept) {
		super(name, age);//항상 위에, 제일 먼저 나와야 한다
		this.dept = dept;
	}
	
	public void prn(){
		System.out.printf("%s %d %s\n", name, age, dept);
	}
}

public class Java089_inheritance {

	public static void main(String[] args) {
			Sun ss = new Sun("홍길동", 50, "기획부");
			ss.prn();
	}

}
