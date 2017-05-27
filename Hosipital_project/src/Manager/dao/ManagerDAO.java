package Manager.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Manager.LoginSub;
import Manager.dto.ManagerDTO;

public class ManagerDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static ManagerDAO dao = new ManagerDAO();

	private ManagerDAO() {

	}

	public static ManagerDAO getInstance() {

		return dao;

	}

	public Connection start() throws ClassNotFoundException, SQLException {

		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.OracleDriver");

		// 2.서버연결
		//192.168.10.229
		String url = "jdbc:oracle:thin://@192.168.10.229:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);

	}

	private void stop() {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

	}

	// 로그인 체크
	public ArrayList<ManagerDTO> loginMethod(String id, int pw) {
		ArrayList<ManagerDTO> aList = new ArrayList<ManagerDTO>();

		try {
			conn = start();
			String sql = "select M_password, M_name from Manager where M_code= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// 레코드가 있는지 검사
			if (rs.next()) {
				ManagerDTO dto = new ManagerDTO();

				if (pw == rs.getInt("M_password")) {
					System.out.println("로그인 되었습니다.");
					LoginSub sub = new LoginSub();

				} else {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				}

			} else {
				System.out.println("등록되지 않은 정보입니다. 관리자에게 문의하세요.");
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

		}

		return aList;

	}

}
