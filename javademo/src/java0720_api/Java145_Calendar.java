package java0720_api;

import java.util.Calendar;

/*
 * 2016년 2월 마지막과 요일을 구하는 프로그램을 구현하세요.
 * [출력결과]
 * 2016-2-29 월요일
 */
public class Java145_Calendar {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 1, 1); //2016년 2월 1일(아직은 마지막 '일'을 모르기 때문에 그냥 1일로 해준다)
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, date);
		String day="";
		switch(cal.get(Calendar.DAY_OF_WEEK)){
		case 1: day="일"; break;
		case 2: day="월"; break;
		case 3: day="화"; break;
		case 4: day="수"; break;
		case 5: day="목"; break;
		case 6: day="금"; break;
		case 7: day="토"; break;
		
		}
		System.out.printf("%d-%d-%d %s요일\n", 2016, 2, date, day);
		

	}

}
