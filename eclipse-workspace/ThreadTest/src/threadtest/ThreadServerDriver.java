package threadtest;

public class ThreadServerDriver {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 4 };

		for (int i = 0; i < nums.length; i++) {

			// create object with necessary initial values.
			ThreadServer server = new ThreadServer(i, nums[i]);

			// create a thread with the object
			Thread thread = new Thread(server);

			// run method in a thread
			thread.start();
		}
	}
}
