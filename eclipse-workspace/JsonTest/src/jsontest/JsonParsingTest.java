package jsontest;

import org.json.*;

public class JsonParsingTest {
	
	// create JSON data
	// {"weather":[
	//   {"zip":95382,"degree":82,"city":"Turlock","state":"CA"},
	//	 {"zip":94089,"degree":75,"city":"San Jose","state":"CA"},
	// 			  ]
	// }
	
	private static String generateJson() {
		JSONWriter jstr = new JSONStringer();
		
		jstr.object();
			// key
			jstr.key("weather");
		
			// value (array of weather data)
			jstr.array();
				// Turlock
				jstr.object();
					jstr.key("zip").value(95382);
					jstr.key("degree").value(82);
					jstr.key("city").value("Turlock");
					jstr.key("state").value("CA");
				jstr.endObject();
			
				// San Jose
				jstr.object();
					jstr.key("zip").value(94089);
					jstr.key("degree").value(75);
					jstr.key("city").value("San Jose");
					jstr.key("state").value("CA");
				jstr.endObject();
			jstr.endArray();
		jstr.endObject();
		
		return jstr.toString();
	}

	public static void main(String[] args) {
		
		// Generate JSON data
		String str = generateJson();
		System.out.println("*** JSON data ****");
		System.out.println(str);
		System.out.println();
		
		// Parse JSON data
		System.out.println("*** Parsed JSON data ****");
		JSONObject obj = new JSONObject(str);
		JSONArray weather = obj.getJSONArray("weather");
		for (int i=0; i < weather.length(); i++) {
			JSONObject entry = weather.getJSONObject(i);
			System.out.print("zip: " + entry.getInt("zip") + ", ");
			System.out.print("degree: " + entry.getInt("degree") + ", ");
			System.out.print("city: " + entry.getString("city") + ", ");
			System.out.print("state: " + entry.getString("state") + "\n");
		}

	}

}
