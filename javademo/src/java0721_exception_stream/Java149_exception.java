package java0721_exception_stream;

public class Java149_exception {

	public static void main(String[] args) {
		String data1="12";
		String data2="6";
	
		try{
			int x = Integer.parseInt(data1);
			int y = Integer.parseInt(data2);
			int res = x/y;
		}catch(NumberFormatException ex){
			System.out.println("숫자를 입력하세요.");
		}catch(ArithmeticException ex){
			System.out.println("분모는 0보다 큰 수를 입력하세요.");
		}catch(RuntimeException ex){
			System.out.println(ex.toString());
		}

	}

}
