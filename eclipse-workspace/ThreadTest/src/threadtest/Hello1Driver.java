package threadtest;

public class Hello1Driver {

	public static void main(String[] args) {
		
		// create object with necessary initial values.
		int num = 5;
		Hello1 obj = new Hello1(num);
		
		// create a thread with the object
		Thread thread = new Thread(obj);

		// run method in a thread
		thread.start();
	}

}
