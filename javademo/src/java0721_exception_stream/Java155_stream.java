package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;
/*
 * carriage return : 줄의 처음으로 이동(13)=>\r
 * line feed : 다음 줄로 이동(10)\>\n
 * 번호는 유니코드
 */
public class Java155_stream {

	public static void main(String[] args) {
		InputStream is = System.in;
		System.out.print("이름 : ");
		int data;
		
		try {
			while((data=is.read())!=10){//10 or 13으로 해야지 계속 준비상태가 아닌 종료가 된다.(char)제거하면 확인가능!
				System.out.println((char)data);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
