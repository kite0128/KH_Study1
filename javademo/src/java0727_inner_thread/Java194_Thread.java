package java0727_inner_thread;

/*
 * 스레드 생명주기(Life Cycle)
 * start() - 실행준비상태(Runnable) - run() - dead
 */
class User3 extends Thread {

	public User3() {

	}

	public User3(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getState()); // Runnable

		for (int i = 1; i <= 10; i++) {

			try {
				// 1000은 1초를 의미한다.
				Thread.sleep(1000);//Waiting (Not Runnable) 일시정지상태
				System.out.printf("%s i=%d\n", getName(), i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}

public class Java194_Thread {

	public static void main(String[] args) {
		User3 user = new User3("user");
		System.out.println(user.getState()); // NEW

		user.start();

		try {
			/*
			 * 지정된 시간동안 스레드가 실행되도록 한다. 
			 * 지정된 시간이 지나거나 종료가 되면 join()을 호출한 스레드로 다시 돌아와 실행을 계속 수행한다.
			 */
			user.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(user.getState()); //TERMINATED
		System.out.println("main end");
	}

}
