package java0718_api;

public class Java116_String {

	public static void main(String[] args) {
		
		String sn = "127.0.0.1:8000";
		/*
		int index = sn.indexOf(':');
		System.out.println("ip:" + sn.substring(0, index));
		System.out.println("port:" + sn.substring(index+1));
		*/
		
		
		String[] arr = sn.split(":");
		System.out.println("ip:"+arr[0]);
		System.out.println("port:"+arr[1]);
	}

}
