package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;

public class Java154_stream {

	public static void main(String[] args) {
		
		System.out.print("데이터입력 ");
		
		//콘솔창 목적지에 InputStream으로 연결
		InputStream is = System.in;
		
		try {
			int line = is.read();
			System.out.println(line);
			System.out.println((char)line);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
