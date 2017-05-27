package java0706_statement;
/*
 * if(조건식){
 * 		if(조건식){
 *			수행할 문장; 
 * 		}else{
 * 			수행할 문장;
 * 		}
 * }else{
 * 		수행할 문장;
 * }
 */
public class Java019_if {

	public static void main(String[] args) {
		boolean member=true; //회원 or 비회원
		String grade = "일반"; //회원일 때 등급
		
		if(member){
			if(grade=="VVIP"){
				System.out.println("30%적립");
			}else{
				System.out.println("10%적립");
			}
		}else{
			System.out.println("비회원");
		}
		
		System.out.println("고객님 감사합니다.");

	}

}
