package java0725_collection.prob;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

/*
 * [문제] : booklist.txt 파일의 데이터를 이용하여 
 *      책 정보 하나당 하나의 Book 객체를 생성하고 생성된 Book 객체들을 
 *      Vector에 담아서 리턴하는 makeBookList() 메서드를 구현하시오.
 *      
 * [실행결과]
 * Java Programming 의 가격 : 25000
 * SQL Fundamentals 의 가격 : 47000
 * JDBC Programming 의 가격 : 30000
 * Servlet Programming 의 가격 : 20000
 * JSP Programming 의 가격 : 21000
 */
public class Prob001_Vector {

	public static void main(String[] args) throws Exception {
		Vector<Book> bookList = makeBookList();
		for (Book book : bookList) {
			System.out.println(book.getTitle() + " 의 가격 : " + book.getPrice());
		}

	}// end main()

	private static Vector<Book> makeBookList() throws Exception {
		// booklist.txt 파일의 데이터를 Vector에 저장한 후 리턴하는 프로그램을 구현하시오.
		Vector<Book> bk = new Vector<Book>();
		File file = new File("./src/java0725_collection/prob/booklist.txt");
		Scanner sc = null;
		
		sc = new Scanner(file);
		String[] st = null;
		while(sc.hasNextLine()){
			st = sc.nextLine().split("/");
			Book bk2 = new Book(st[0], st[1], st[2], st[3]);
			bk.add(bk2);
		}
		return bk;

	}// end makeBookList()

}// end class














