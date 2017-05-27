package Manager.dto;

import Members.dto.ManagerDTO;

public class ReservationDTO2 {
	
	private String Dates;//시간
	private String Today;
	private String Disease;
	private String JUMIN;
	private String NAME;
	private int NUM;
	private String M_code;
	private String Time;
	
	ManagerDTO mdto;
	
	
	
	public ReservationDTO2() {
		
	}
	
	public ReservationDTO2(String dates, String disease, String jumin, String name, String m_code, String time) {
		super();
		this.Dates = dates;
		this.Disease = disease;
		this.JUMIN = jumin;
		this.NAME = name;
		this.M_code = m_code;
		this.Time = time;
	}
	public ManagerDTO getMdto() {
		return mdto;
	}

	public void setMdto(ManagerDTO mdto) {
		this.mdto = mdto;
	}
	
	
	public String getDates() {
		return Dates;
	}
	public void setDates(String dates) {
		Dates = dates;
	}
	public String getToday() {
		return Today;
	}
	public void setToday(String today) {
		Today = today;
	}
	public String getDisease() {
		return Disease;
	}
	public void setDisease(String disease) {
		Disease = disease;
	}
	public String getJUMIN() {
		return JUMIN;
	}
	public void setJUMIN(String jUMIN) {
		JUMIN = jUMIN;
	}
	public int getNUM() {
		return NUM;
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}

	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}

	public String getM_code() {
		return M_code;
	}

	public void setM_code(String m_code) {
		M_code = m_code;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	

}//end ReservationDTO
