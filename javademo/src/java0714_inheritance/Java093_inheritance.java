package java0714_inheritance;

/*
 * [출력결과]
 * 1000량의 물을 뿌린다
 * 8인승 차량입니다.
 */
class Car{
	int speed;
	String color;
	void setSpeed(int speed) {
		this.speed = speed;
	}

	void stop() {
		speed = 0;
	}
}

class FireEngine extends Car {	
	private long water;
	
	public void setWater(long water) {
		this.water = water;
	}

	void waterSpread() {
		System.out.println(water + "량의 물을 뿌린다");
	}	
}

class OwnerEngine  extends Car{	
	private int seat;
	
	  public void setSeat(int seat) {
		this.seat = seat;
	}
	
	void prn(){
		System.out.println(seat+"인승 차량입니다.");
	}
}
public class Java093_inheritance {

	public static void main(String[] args) {
		FireEngine f1 = new FireEngine();
		OwnerEngine f2 = new OwnerEngine();
		f1.setWater(1000);
		f1.waterSpread();
		f2.setSeat(8);
		f2.prn();
		
	}//end main()

}
