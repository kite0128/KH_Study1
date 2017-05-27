package Members.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Members.dto.ManagerDTO;

public class ManagerDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ManagerDAO dao = new ManagerDAO();
	
	public ManagerDAO() {

	}

	public static ManagerDAO getInstance() {
		return dao;
	}
	
	private Connection start() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@192.168.10.229:1521:xe";
		String username = "hr";
		String password = "a1234";

		return DriverManager.getConnection(url, username, password);

	}// end init()

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}// end stop()
	
	public ArrayList<ManagerDTO> searchMethod(String search){
		ArrayList <ManagerDTO> aList = new ArrayList<ManagerDTO>();
		try {
			conn = start();
			stmt = conn.createStatement();
			
			//select M_code, M_name, M_subject from manager where m_subject = '외과';
			String sql = "select m_code, m_name, m_subject from manager where m_subject = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ManagerDTO dto = new ManagerDTO();
				dto.setM_code(rs.getString("m_code"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_subject(rs.getString("m_subject"));
				aList.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return aList;
	}//end searchMethod()
}
