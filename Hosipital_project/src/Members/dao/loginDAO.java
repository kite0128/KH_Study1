package Members.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Members.dto.MembersDTO;
import Members.dto.loginDTO;

public class loginDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static loginDAO dao = new loginDAO();
	
	private loginDAO(){
		
		
	}
	
	public static loginDAO getInstance(){
		return dao;
	}
	
	private Connection start() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@192.168.10.229:1521:xe";
		String username = "hr";
		String password = "a1234";
				
		return DriverManager.getConnection(url, username, password);
	}//end start()
	
	private void stop() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}// end stop()
	
	
	public int  listMethod(String name ,String search){
		int cnt = 0;
		
		try {
			conn = start();
			stmt = conn.createStatement();
			String sql ="select NAME, JUMIN,count(*), phone, gender, addr "+
		             " from MEMBERS"+
				     " where NAME = ? and JUMIN = ?"+
		             " group by name, jumin, phone, gender, addr";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,search);
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()){
				//dto에 있는 값을 비교해야하기 때문에 getInstance를 사용한다.
				MembersDTO mdto =MembersDTO.getInstance();
				mdto.setName(rs.getString("name"));
				mdto.setJumin(rs.getString("jumin"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setGenger(rs.getString("gender"));
				mdto.setAddr(rs.getString("addr"));
				cnt = rs.getInt("count(*)");
				
		     	
				}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
		
	}//end dbCheck()
	
	

}//end class
