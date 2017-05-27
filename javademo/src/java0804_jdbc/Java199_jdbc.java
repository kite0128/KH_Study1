package java0804_jdbc;

import java.util.ArrayList;
import java.util.Scanner;

import java0804_jdbc.dao.EmpDAO;
import java0804_jdbc.dto.EmpDTO;

/*
 * 이름을 입력하세요? alex
 * 103 Alexander 9000 1990-01-03
 * 115 Alexander 3100 1995-05-18
 * 185 Alexis 4100 1997-02-20
 */
public class Java199_jdbc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요?");
		String word = sc.nextLine();
		
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpDTO> aList=dao.searchMethod(word);
		for(EmpDTO dto : aList){
			System.out.printf("%d %s %d %s\n", 
					dto.getEmployee_id(), 
					dto.getFirst_name(), 
					dto.getSalary(), 
					dto.getHire_date());
		}

	}//end main()

}//end class
