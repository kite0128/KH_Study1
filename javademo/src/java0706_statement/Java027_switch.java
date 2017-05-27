package java0706_statement;

public class Java027_switch {

	public static void main(String[] args) {
		
		char ope = '+';
		int numX = 10;
		int numY = 5;
		int res = 0;
		/*
		if(ope == '+'){
			res = numX + numY;
		}else if(ope == '-'){
			res = numX - numY;
		}else if(ope == '*'){
			res = numX * numY;
		}else if(ope == '/'){
			res = numX / numY;
		}else{
			System.out.println("사칙연산이 아닙니다.");
			return;
		}
		*/
		switch(ope)
		{
		case '+' :
			res = numX + numY;
			break;
		case '-' :
			res = numX - numY;
			break;
		case '*' :
			res = numX * numY;
			break;
		case '/' :
			res = numX / numY;
			break;
		default :
			System.out.println("사칙연산이 아닙니다.");
			return;
		}
		
		System.out.printf("%d %c %d = %d\n", numX, ope, numY, res);
	}

}
