package java0805_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java0803_jdbc.dto.MemDTO;
import java0804_jdbc.dao.EmpDAO;
import java0804_jdbc.dto.EmpDTO;
import java0805_jdbc.dto.EmployeesDTO;

public class EmployeesDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;	

	private static EmployeesDAO dao = new EmployeesDAO();
	
	private EmployeesDAO() {

	}
	
	public static EmployeesDAO getInstance(){
		
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException{
		 
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.OracleDriver");

		// 2.서버연결
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);

	}

	private void stop(){
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public ArrayList<EmployeesDTO> listMethod(String a){
		ArrayList<EmployeesDTO> aList = new ArrayList<EmployeesDTO>();

		try {
			conn = init();

			// 3.쿼리문을 실행하기 위해 Statement 타입의 객체를 리턴
			stmt = conn.createStatement();
			
			// 4.쿼리문 실행
			String sql = "select * from Employees where lower(first_name) like '%"+ a.toLowerCase() + "%'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				EmployeesDTO dto = new EmployeesDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setDepartment_id(rs.getInt("department_id"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;
	}
}
