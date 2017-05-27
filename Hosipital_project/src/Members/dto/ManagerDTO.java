package Members.dto;

public class ManagerDTO {

	private String M_code;//의사/간호사 코드
	private String M_job;//의사 or 간호사
	private String M_name;
	private String M_phone;
	private String M_subject;//담당과목
	private int M_password;
	
	public ManagerDTO(){
		
	}
	

	public String getM_job() {
		return M_job;
	}
	public void setM_job(String m_job) {
		M_job = m_job;
	}
	public String getM_name() {
		return M_name;
	}
	public void setM_name(String m_name) {
		M_name = m_name;
	}
	public String getM_subject() {
		return M_subject;
	}
	public void setM_subject(String m_subject) {
		M_subject = m_subject;
	}
	public int getM_password() {
		return M_password;
	}
	public void setM_password(int m_password) {
		M_password = m_password;
	}


	public String getM_code() {
		return M_code;
	}


	public void setM_code(String m_code) {
		M_code = m_code;
	}


	public String getM_phone() {
		return M_phone;
	}


	public void setM_phone(String m_phone) {
		M_phone = m_phone;
	}

}//end ManagerDTO
