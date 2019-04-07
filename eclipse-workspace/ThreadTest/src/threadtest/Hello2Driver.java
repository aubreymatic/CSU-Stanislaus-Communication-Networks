package threadtest;

public class Hello2Driver {

	public static void main(String[] args) {

		// create object with necessary initial values.
		int num = 4;
		Hello2 obj = new Hello2(num);

		// create a thread with the object
		Thread thread = new Thread(obj);

		// run method in a thread
		thread.start();
	}

}
