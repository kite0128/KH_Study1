package Members.dto;

public class loginDTO {
	private String name;
	private String jumin;
	private String phone;
	private String gender;
	private String addr;
	
	
	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public loginDTO(){
		
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



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}


}//end class
