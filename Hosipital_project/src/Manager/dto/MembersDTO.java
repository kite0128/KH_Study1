package Manager.dto;

public class MembersDTO {
	private String name;//이름
	private String jumin;//주민번호
	private String phone;//핸드폰
	private String addr;//주소
	private String genger;//성별
	
	private ManagerDTO ndto;
	private ReservationDTO rdto;
	
	//저장된 값을 다른 창에 넘겨줘야 하는 방법
    private static MembersDTO dto = new MembersDTO();
	
	private MembersDTO(){
		
	}
	
	public static MembersDTO getInstance(){
		return dto;
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
	public String getGenger() {
		return genger;
	}
	public void setGenger(String genger) {
		this.genger = genger;
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
	
	
	
}//end MembersDTO
