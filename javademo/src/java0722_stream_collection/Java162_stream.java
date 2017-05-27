package java0722_stream_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Java162_stream {

	public static void main(String[] args) {
			File file = new File("./src/java0722_stream_collection/score.txt");
			
			RandomAccessFile raf = null;
			try {
				/*
				 * "r" : 읽기(read)만 가능하다.
				 * "rw" : 읽기(read) 쓰기(write)가 가능하다.
				 */
				raf = new RandomAccessFile(file, "r");
				System.out.println(raf.getFilePointer());//0
				System.out.println((char)raf.read());//k
				System.out.println(raf.getFilePointer());//1
				System.out.println(raf.readLine());//im:56/78/12
				String line = raf.readLine();
				System.out.printf("%s %d\n", line, line.length());
				System.out.println(raf.getFilePointer());
				//포인터의 위치를 변경한다.(파일 처음부터 포인터를 찾는다.)
				raf.seek(4);
				System.out.println(raf.readLine());
				
				//지정된 수 만큼 byte을 건너뛴다.(현재 포인터가 있는 위치를 기준으로 건너뛴다.)
				raf.skipBytes(2);
				System.out.println(raf.readLine());
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}finally{
				
			}

	}

}
