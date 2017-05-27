package Manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Manager.dto.ReservationDTO;
import Members.dto.MembersDTO;
import Members.dto.MembersDTO2;
import Manager.dto.ManagerDTO;

public class ReservationDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	ResultSet rs;

	private static ReservationDAO dao = new ReservationDAO();

	private ReservationDAO() {

	}

	public static ReservationDAO getInstance() {

		return dao;

	}

	public Connection start() throws ClassNotFoundException, SQLException {

		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.OracleDriver");

		// 2.서버연결
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
			} catch (SQLException e) {

				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

	}

	// 검색 메서드(입력값 있을 때)
	public ArrayList<ReservationDTO> listMethod(String name) {
		ArrayList<ReservationDTO> aList = new ArrayList<ReservationDTO>();

		try {
			conn = start();
			String sql = "select * from reservation where name like ? order by num";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReservationDTO rdto = new ReservationDTO();

				rdto.setNum(rs.getInt("Num"));
				rdto.setName(rs.getString("Name"));
				rdto.setJumin(rs.getString("Jumin"));
				rdto.setM_code(rs.getString("M_code"));
				rdto.setDisease(rs.getString("Disease"));
				rdto.setDates(rs.getString("Dates"));
				rdto.setTime(rs.getString("Time"));

				aList.add(rdto);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;
	}

	// 검색 메서드(입력값 없을 때)
	public ArrayList<ReservationDTO> listMethod() {
		ArrayList<ReservationDTO> aList = new ArrayList<ReservationDTO>();

		try {
			conn = start();
			String sql = "select * from reservation";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ReservationDTO rdto = new ReservationDTO();

				rdto.setNum(rs.getInt("Num"));
				rdto.setName(rs.getString("Name"));
				rdto.setJumin(rs.getString("Jumin"));
				rdto.setM_code(rs.getString("M_code"));
				rdto.setDisease(rs.getString("Disease"));
				rdto.setDates(rs.getString("Dates"));
				rdto.setTime(rs.getString("Time"));

				aList.add(rdto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;
	}

	// 수정 메서드
	public ArrayList<ReservationDTO> modifyMethod(String dates, String time, String disease, String jumin,
			String m_code) {
		ArrayList<ReservationDTO> aList = new ArrayList<ReservationDTO>();

		try {
			conn = start();
			String sql = "update reservation set dates=?, time=?, disease=? where jumin=? and m_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dates);
			pstmt.setString(2, time);
			pstmt.setString(3, disease);
			pstmt.setString(4, jumin);
			pstmt.setString(5, m_code);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}

	// 삭제 메서드
	public ArrayList<ReservationDTO> deleteMethod(int row) {
		ArrayList<ReservationDTO> aList = new ArrayList<ReservationDTO>();

		try {
			conn = start();
			String sql = "delete from Reservation where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, row);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}

	// 초기화 메서드
	public ArrayList<ReservationDTO> formatMethod() {
		ArrayList<ReservationDTO> aList = new ArrayList<ReservationDTO>();

		try {
			conn = start();
			String sql = "delete from Reservation";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}

}// end class
