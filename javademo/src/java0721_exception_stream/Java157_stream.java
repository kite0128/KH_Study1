package java0721_exception_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Java157_stream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = 0;
		int y = 0;
		
		System.out.print("x:");
		//x = Integer.parseInt(sc.nextLine());
		x=sc.nextInt();
		System.out.print("y:");
		//y = Integer.parseInt(sc.nextLine());
		y=sc.nextInt();
		System.out.printf("x+y=%d\n", x + y);
		
		sc.close();

	}
}
