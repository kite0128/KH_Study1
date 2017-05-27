package java0719_api;

import java.util.Random;

public class Java134_Random {
	public static void main(String[] args) {
		Random ran = new Random();
		int[] num = new int[3];
		
		//1부터 10까지의 정수값을 num 배열에 저장
		for(int i=0; i<num.length; i++){
			num[i]=ran.nextInt(10)+1;
			
			// 중복체크를 위한 반복문
			for(int j=0; j<i;j++){
				if(num[j]==num[i]){
					i--;
					break;
				}
			}
		}
		for(int data : num)
			System.out.println(data);
	}
}
