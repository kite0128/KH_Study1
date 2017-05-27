package Manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Manager.dto.ReservationDTO2;

public class ReservationDAO2 {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ReservationDAO2 dao = new ReservationDAO2();
	
	public ReservationDAO2() {

	}

	public static ReservationDAO2 getInstance() {
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
	
	//예약 정보 삽입
	public void insertMethod(ReservationDTO2 dto) {
		try {
			
			conn = start();
			stmt = conn.createStatement();			
			//insert into RESERVATION(Dates, Today, Disease, JUMIN, NAME, NUM, M_code, Time)
			//values('2016-8-15',sysdate, '외과','900101-1234567','박두리',SEQ_RESERVATION_NUM.nextval,'a','오전10시');
			String sql="insert into reservation values(?, sysdate, ?,?,?,SEQ_RESERVATION_NUM.nextval,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDates());
			pstmt.setString(2, dto.getDisease());
			pstmt.setString(3, dto.getJUMIN());
			pstmt.setString(4, dto.getNAME());
			pstmt.setString(5, dto.getM_code());
			pstmt.setString(6, dto.getTime());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}//insertMethod()
	
	//선택한 의사의 예약날짜와, 예약시간 불러오기
	public ArrayList<ReservationDTO2> searchDate(String search){
		ArrayList <ReservationDTO2> aList = new ArrayList<ReservationDTO2>();
		try {
			conn = start();
			stmt = conn.createStatement();
			String sql = "select Dates, Time from reservation where m_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				ReservationDTO2 dto = new ReservationDTO2();
				dto.setDates(rs.getString("dates"));
				dto.setTime(rs.getString("time"));
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
