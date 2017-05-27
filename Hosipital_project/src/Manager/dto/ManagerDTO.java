package Manager.dto;

public class ManagerDTO {
	private String M_code;
	private int M_password;
	private String M_name;
	private int M_phone;
	private String M_subject;
	private String M_job;
	

	public String getM_name() {
		return M_name;
	}
	public void setM_name(String m_name) {
		M_name = m_name;
	}
	public String getM_code() {
		return M_code;
	}
	public void setM_code(String m_code) {
		M_code = m_code;
	}
	public int getM_password() {
		return M_password;
	}
	public void setM_password(int m_password) {
		M_password = m_password;
	}
	public int getM_phone() {
		return M_phone;
	}
	public void setM_phone(int m_phone) {
		M_phone = m_phone;
	}
	public String getM_subject() {
		return M_subject;
	}
	public void setM_subject(String m_subject) {
		M_subject = m_subject;
	}
	public String getM_job() {
		return M_job;
	}
	public void setM_job(String m_job) {
		M_job = m_job;
	}
	
}
