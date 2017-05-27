package java0715_abstract_interface;

abstract class Shape{
	int width;
	int height;
	
	public Shape(int width, int height){
		this.width=width;
		this.height=height;
	}
	
	void prn(){
		System.out.printf("width=%d height=%d\n", width, height);
	}
	
	//추상메소드로 만든다. 그러면 밑의 각 클래스에서 부모 클래스를 상속 받은 상태에서는 같은 이름 다른 내용의 메소드 생성 가능.
	abstract double getArea();
}

class Rect extends Shape{
	int width;
	int height;
	
	public Rect(int width, int height){
		super(width,height);
	}
	
	double getArea(){
		return width*height;
	}
	
}

class Trai extends Shape{
	
	public Trai(int width, int height){
		super(width,height);
	}
	
	double getArea(){
		return width*height*0.5;
	}
	
}


public class Java097_abstract {

	public static void main(String[] args) {
		//Shape은 추상클래스이므로 객체 생성을 할 수 없다.
		//Shape se = new Shape(10,20);

		Rect rr = new Rect(10,20);
		System.out.println("사각형 넓이 : " + rr.getArea());
		
		Trai tt = new Trai(10,20);
		System.out.println("삼각형 넓이 : " + tt.getArea());
	}

}
