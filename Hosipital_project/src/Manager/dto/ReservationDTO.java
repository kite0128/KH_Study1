package Manager.dto;

public class ReservationDTO {
	private int Num;
	private String Name;
	private String Jumin;
	private String M_code;
	private String Disease;
	private String dates;
	private String Time;
	private String Today;
	
	
	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public String getJumin() {
		return Jumin;
	}

	public void setJumin(String jumin) {
		Jumin = jumin;
	}

	public String getM_code() {
		return M_code;
	}

	public void setM_code(String m_code) {
		M_code = m_code;
	}

	public String getDisease() {
		return Disease;
	}

	public void setDisease(String disease) {
		Disease = disease;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getToday() {
		return Today;
	}

	public void setToday(String today) {
		Today = today;
	}

	
}
