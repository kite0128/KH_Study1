package java0721_exception_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Java159_stream {

	public static void main(String[] args) {
		File file = new File("sample.txt");
		//System.out.println(file.exists());
		//System.out.println(file.isFile());
		
		FileWriter fw=null;
		try {
			/*
			 * FileWriter("대상파일", mode)
			 * mode의 값이 true이면 append이고, false이면 update이다.
			 * 두번째 인자값이 'false'이면 업데이트 'true'이면 추가가 된다.
			 */
			fw = new FileWriter(file, false);
			fw.write("aaaa\r\n"); //buffer			
			fw.flush(); // buffer->file & buffer를 clear한다.
			fw.write("tttt");
			
			System.out.println("저장종료");
			/*fw.close();
			fw.write(97);
			fw.flush();*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				fw.close();
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}

}
