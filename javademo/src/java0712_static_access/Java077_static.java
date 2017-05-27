package java0712_static_access;

class OrderStatic{
	//static이라서 먼저 생성(=>main 생성되기 전에 static이 먼저 생성)
	static{
		System.out.println("static");
	}
	
	public OrderStatic(){
		System.out.println("constructor");
	}
	
	public void prn(){
		System.out.println("prn");
	}
}


public class Java077_static {

	public static void main(String[] args) {
		OrderStatic ss = new OrderStatic();
		ss.prn();

	}

}
