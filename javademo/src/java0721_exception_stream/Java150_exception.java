package java0721_exception_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Java150_exception {

	public static void main(String[] args) {
		File file = new File("sampel.txt");

		try {
			FileReader fr = new FileReader(file);
			// FileNotFoundException은 checked exception 이므로
			// 반드시 try~catch~finally(예외처리)를 해줘야 한다.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
