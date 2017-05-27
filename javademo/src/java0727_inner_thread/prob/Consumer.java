package java0727_inner_thread.prob;

public class Consumer extends Thread{
	 private VendingMachine vm;
	 
	 public Consumer(VendingMachine vm){
		 this.vm = vm;
	 }
}
