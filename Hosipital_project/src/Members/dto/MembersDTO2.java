package Members.dto;

public class MembersDTO2 {
	private String name;//이름
	private String jumin;//주민번호
	private String phone;//핸드폰
	private String addr;//주소
	private String gender;//성별
	
	private ManagerDTO ndto;
	private ReservationDTO rdto;
	
	
	public MembersDTO2(){
			
		}
		
	public MembersDTO2(String name, String jumin, String phone, String addr, String gender) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.phone = phone;
		this.gender = gender;
		this.addr = addr;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public ManagerDTO getNdto() {
		return ndto;
	}
	public void setNdto(ManagerDTO ndto) {
		this.ndto = ndto;
	}
	public ReservationDTO getRdto() {
		return rdto;
	}
	public void setRdto(ReservationDTO rdto) {
		this.rdto = rdto;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}//end MembersDTO
