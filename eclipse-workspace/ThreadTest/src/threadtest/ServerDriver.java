package threadtest;

public class ServerDriver {

	public static void main(String[] args) {
		Server server = new Server();
		int[] nums = {3, 2, 4};
		
		for (int num: nums) {
			server.showNums(num);
		}
	}

}
