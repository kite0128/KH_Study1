package java0715_abstract_interface;

class BindTest{
	String stn;
	
	public BindTest(String stn){
		this.stn = stn;
	}
	
	public String toString(){
		return stn;
	}
}

class A{
	
}

class B{
	
}

public class Java105_binding {

	public static void main(String[] args) {
		/*A aa = new A();
		B bb = new B();
		aa=bb;*/
		
		//바인딩(binding) : 두 개의 관계를 연결한 것이다.
		
		//정적 바인딩 : 메모리에 생성된 영역과 같은 타입으로 메모리를 관리한다.
		BindTest bt = new BindTest("java");
		System.out.println(bt.toString());
		
		//동적 바인딩 : 메모리에 생성된 영역을 부모객체로 메모리를 관리한다. 
		//상속(is a) -> 업캐스팅 -> 동적바인딩
		Object obj = new Object();
		String st = new String("jsp");
		
		//obj=(Object)st;
		obj=st;
		
		String sn = (String)obj; //다운캐스팅 -> 동적바운딩 => 반드시 업캐스팅 다음에 다운캐스팅이 가능
		System.out.println(sn.toString());
	}

}
