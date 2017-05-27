package Members.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Members.dto.ManagerDTO;
import Members.dto.MembersDTO;
import Members.dto.MembersDTO2;
import Members.dto.ReservationDTO;

public class MembersDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MembersDAO dao = new MembersDAO();
	
	private MembersDAO(){
		
	}//end MembersDAO()
	
	public static MembersDAO getInstance(){
		return dao;
	}//end getInstance()
	
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
	
	public void insertMethod(MembersDTO2 dto) {
		try {
			
			conn = start();
			stmt = conn.createStatement();			
			String sql="insert into members values(SEQ_MEMBERS_NUMS.nextval,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJumin());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getGender());
			pstmt.executeUpdate();
			
		   

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}//insertMethod()
	
	public ArrayList<MembersDTO> listMethod(String date , String disease , String time ,String jumin,String m_code, String dates){
		
		
		ArrayList<MembersDTO> ber = new ArrayList<MembersDTO>();
		try {
			conn = start();
			stmt = conn.createStatement();
			
			String sql = "update RESERVATION set dates=? ,disease = ?,Time=?"+
					     " where jumin=?"+
					     " and m_code=?"+
					     " and dates =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setString(2, disease);
			pstmt.setString(3, time);
			pstmt.setString(4, jumin);
			pstmt.setString(5, m_code);
			pstmt.setString(6, dates);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			stop();
		}
		
		
		return ber;
	}//end update()
	
	public ArrayList<MembersDTO> listMethod(String jumin, String dates, String time, String disease){
		ArrayList<MembersDTO> del = new ArrayList<MembersDTO>();
		try {
			conn = start();
			stmt = conn.createStatement();
			
			String sql = "delete from RESERVATION"+
				         " where jumin = ?"+
				         " and dates =?"+
				         " and time =?"+
				         " and disease =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jumin);
			pstmt.setString(2, dates);
			pstmt.setString(3, time);
			pstmt.setString(4, disease);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			stop();
		}
		
		
		return del;
	}//end delete()
	
	public ArrayList<MembersDTO2> listMethod(String name, String jumin, String search){
		ArrayList<MembersDTO2> mem = new ArrayList<MembersDTO2>();
		try {
			conn = start();
			stmt = conn.createStatement();
			
			String sql = "select r.dates, r.time, r.disease, m.m_name, r.Today, m.m_code "
					+ " from reservation r, manager m, members b"
					+ " where r.m_code = m.m_code"
					+ " and r.jumin = b.jumin"
					+ " and b.name = ?"
					+ " and b.jumin = ?"
					+ " and r.dates || r.time || r.disease || m.m_name || r.Today || b.phone like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			pstmt.setString(3, "%"+search+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				MembersDTO2 mdto = new MembersDTO2();
				
				ReservationDTO rdto=new ReservationDTO();
				rdto.setDates(rs.getString("Dates"));
				rdto.setTime(rs.getString("Time"));
				rdto.setDisease(rs.getString("Disease"));
				rdto.setToday(rs.getString("Today"));
                rdto.setM_code(rs.getString("m_code"));
				mdto.setRdto(rdto);
				
				ManagerDTO ndto = new ManagerDTO();
				ndto.setM_code(rs.getString("m_code"));
				ndto.setM_name(rs.getString("m_name"));
				mdto.setNdto(ndto);
				
				
			
				mem.add(mdto);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			stop();
		}
		
		
		return mem;
	}//end select()
	
	public ArrayList<MembersDTO2> listMethod(String jumin) {
		ArrayList<MembersDTO2> member = new ArrayList<MembersDTO2>();
		try {
			conn = start();
			stmt = conn.createStatement();

			String sql = "select r.dates, r.time, r.disease, m.m_name, r.Today ,m.m_code, m_job"
					+ " from reservation r, manager m, members b"
					+ " where r.m_code = m.m_code"
					+ " and r.jumin = b.jumin"
					+ " and b.jumin = ?"
					+ " order by r.time ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jumin);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				MembersDTO2 mdto = new MembersDTO2();

				ReservationDTO rdto = new ReservationDTO();
				rdto.setDates(rs.getString("Dates"));
				rdto.setTime(rs.getString("Time"));
				rdto.setDisease(rs.getString("Disease"));
				rdto.setToday(rs.getString("Today"));
				rdto.setM_code(rs.getString("m_code"));
				mdto.setRdto(rdto);

				ManagerDTO ndto = new ManagerDTO();
				ndto.setM_name(rs.getString("m_name"));
				ndto.setM_job(rs.getString("m_job"));
				mdto.setNdto(ndto);

				member.add(mdto);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return member;
	}// end sort()
	

}//end MembersDAO
