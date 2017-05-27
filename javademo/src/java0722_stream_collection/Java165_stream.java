package java0722_stream_collection;

import java.io.File;
import java.io.IOException;

public class Java165_stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./src/java0722_stream_collection/temp/test.txt");
		if (!file.exists()) {
			try {
				boolean data = file.createNewFile();
				System.out.println(data ? "파일생성성공" : "파일생성실패");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			file.delete();
			System.out.println("파일삭제");
		}
	}

}
