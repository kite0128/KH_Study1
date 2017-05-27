package java0706_statement;
/*
 * [출력결과]
 * station = "KBS" channel=7 => 닥터포스터
 * station = "KBS" channel=9 => 국수의 신
 * station = "MBC" channel = 11   => 몬스터
 * station = "EBS" channel = 13   => 한국기행
 */
public class Java023_if {

	public static void main(String[] args) {
		int channel=13;
		String station="EBS";
		String program;
		
		if(station=="KBS"){
			if(channel==7){
				program="닥터포스터";
			}else{
				program="국수의 신";
			}	
		}else if(station=="MBC"){
			program="몬스터";
		}else{
			program="한국기행";
		}
		
		System.out.printf("=> %s", program);
	}
}
