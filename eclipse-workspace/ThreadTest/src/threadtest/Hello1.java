package threadtest;

public class Hello1 implements Runnable {

	private int num;

	public Hello1(int num) {
		this.num = num;
	}

	public void fact() {
		int ret = 1;
		for (int i = 1; i <= num; i++) {
			ret *= i;
		}
		System.out.println("factorial(" + num + "): " + ret);
	}

	@Override
	public void run() {
		fact();
	}
}
