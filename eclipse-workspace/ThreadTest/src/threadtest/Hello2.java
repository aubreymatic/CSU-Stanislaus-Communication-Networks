package threadtest;

public class Hello2 extends Thread {

	private int num;

	public Hello2(int num) {
		this.num = num;
	}

	public void fact() {
		int ret = 1;
		for (int i = 1; i <= num; i++) {
			ret *= i;
		}
		System.out.println("factorial(" + num + "): " + ret);
	}

	public void run() {
		fact();
	}
}
