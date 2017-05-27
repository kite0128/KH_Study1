package java0714_inheritance;

/*
 * [출력결과]
 * 애완동물이 움직입니다.
 * 애완동물이 움직입니다.
 * 강아지의 이름은 누렁이고, 몸무게는 10Kg입니다.
 * 새의 종류는 앵무새고, 날 수 있습니다
 */
class Pet {
	int age; // 애완동물 개월수

	public void move() {
		System.out.println("애완동물이 움직입니다.");
	}
}

class Dog extends Pet {
	String name; // 강아지 이름
	int weight; // 강아지 무게

	int getWeight() {
		return weight;
	}
}

class Bird extends Pet {
	String type; // 새 종류
	boolean flightYN; // 날수 있는지 여부

	boolean getFlight() {
		return flightYN;
	}
}

public class Java095_inheritance{

public static void main(String[] args) {
		Dog dog1 = new Dog();
		Bird bird1 = new Bird();
		dog1.move();
		bird1.move();
		dog1.name="누렁이";
		dog1.weight=10;
		bird1.type="앵무새";
		bird1.flightYN=true;
	
	System.out.println("강아지의 이름은 " + dog1.name + "고, 몸무게는 " + dog1.getWeight() + "Kg입니다.");
	System.out.println("새의 종류는 " + bird1.type + "고, 날 수 " + (bird1.getFlight() ? "있" : "없") + "습니다");
	}
}

