package jsontest;

import org.json.*;

public class JsonTest {

	public static void main(String[] args) {
		// JSON data
		String str = "{ \"name\": \"Alice\", \"age\":20} ";
		
		// Parse JSON data
		JSONObject obj = new JSONObject(str);
		String name = obj.getString("name");
		int age = obj.getInt("age");
		
		// Use parsed data
		System.out.println("name: " + name + ", age: " + age);
	}

}
