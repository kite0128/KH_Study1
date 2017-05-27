package java0726_collection.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * LinkedList
 * 1 List : 순서적으로 데이터를 저장
 * 2 Stack : LIFO
 * 3 Queue : FIFO
 */

public class Prob001_LinkedList {

	public static void main(String[] args) {
		/*
		 * booklist.txt파일의 데이터를 Stack으로 처리하여 출력되도록 
		 * 프로그램을 구현하시오.
		 *  title             	publisher   writer     price
		 	JSP Programming  	JSPPub     JSPExpert   21000
			Servlet Programming WeBBest 	GoodName	 20000
			JDBC Programming 	JDBCBest 	NaDo SQL 	30000
			SQL Fundmental 		SQLBest		 Na SQL 	47000
			Java Programming 	JavaBest	 Kim kava	 25000
		 */
		File file = new File("./src/java0726_collection/prob/booklist.txt");
		Scanner sc = null;
		String st = null;
		//Book bk = null;
		LinkedList<String> nList = new LinkedList<String>();
		try{
			sc = new Scanner(file);
			while(sc.hasNextLine()){
				//st = sc.nextLine().split("/");
				st = sc.nextLine().replaceAll("/", "   ");
				nList.push(st);
				}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
			sc.close();
		}
		
		while(!nList.isEmpty()){
			System.out.println(nList.pop());
		}
		
	
	}//end main()

}//end class











