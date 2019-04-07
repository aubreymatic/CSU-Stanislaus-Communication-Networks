package threadtest;

public class ThreadServer implements Runnable {
	
	private int threadNo;
	private int num;
	
	public ThreadServer(int threadNo, int num) {
		this.threadNo = threadNo;
		this.num = num;
	}
	
	public void showNums() {
		for (int i=1; i <= num; i++) {
			System.out.println("Thread: " + threadNo + ", " + i);
		}
	}

	@Override
	public void run() {
		showNums();
	}
}