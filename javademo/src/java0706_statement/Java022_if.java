package java0706_statement;

/*
 * 각 월의 마지막 일
 * 1 3 5 7 8 10 12 => 31
 * 4 6 9 11 => 30
 * 2 => 28
 * 
 * [출력결과]
 * 4월의 마지막 일은 30일.
 */
public class Java022_if {

	public static void main(String[] args) {
		/*
		 * int month = 2; int lastday=-1; if(month==1 || month==3 || month==5 ||
		 * month==7 || month==8 || month==10 || month==12){ lastday = 31; }else
		 * if(month==4 || month==6 || month==9 || month==11){ lastday = 30;
		 * }else{ lastday = 2; }
		 * 
		 * //if(lastday==-1){ if(!(month>=1 && month<=12)){
		 * System.out.println("잘못 입력되었습니다. 다시 시작하세요."); }else{
		 * System.out.printf("%s월의 마지막 일은 %d일.", month, lastday); }
		 */
		int month = 14;
		int lastday = -1;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			lastday = 31;
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			lastday = 30;
			break;

		case 2:
			lastday = 2;
			break;

		default:
			lastday = -1;
		}

		if (lastday == -1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
		} else {
			System.out.printf("%d월의 마지막 일은 %d일 입니다.\n", month, lastday);
		}
	}
}
