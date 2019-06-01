package weathercloudclient;

import java.awt.EventQueue;
import org.json.*;
import java.net.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WeatherCloudClient {

	private JFrame frame;
	private JTextField tfRestServer;
	private JTextField tfZip;
	private JTextField tfDegree;
	private JTextArea taMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherCloudClient window = new WeatherCloudClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WeatherCloudClient() {
		initialize();
	}
	
	private String getRestURL(String restServer) {
		String url = "http://" + restServer + ":8080/weather";
		return url;
	}
	
	private String getData(String restURL) {
		String ret = "";
		try {
			// get weather JSON data
			URL url = new URL(restURL);
			URLConnection urlConn = url.openConnection();
			InputStream inputStream = urlConn.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String line = in.readLine();
			in.close();
			
			// parse JSON data and show parsed data
			JSONObject obj = new JSONObject(line);
			JSONArray weather = obj.getJSONArray("weather");
			for (int i=0; i < weather.length(); i++) {
				JSONObject entry = weather.getJSONObject(i);
				ret += "Zip: " + entry.getInt("zip") + ", ";
				ret += "degree: " + entry.getInt("degree") + ", ";
				ret += "city: " + entry.getString("city") + ", ";
				ret += "state: " + entry.getString("state") + "\n";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ret;
	}
	
	private String getRestURL(String restServer, String zip) {
		String url = "http://" + restServer + ":8080/weather/" + zip;
		System.out.println(url);
		return url;
	}
	
	private String getRestURL(String restServer, int degree) {
		String url = "http://" + restServer + ":8080/weather/";
		url += "warmerthan?degree=" + degree;
		System.out.println(url);
		return url;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWeatherApplication = new JLabel("Weather Application");
		lblWeatherApplication.setBounds(153, 24, 139, 15);
		frame.getContentPane().add(lblWeatherApplication);
		
		JLabel lblRestServer = new JLabel("Rest Server");
		lblRestServer.setBounds(177, 51, 107, 15);
		frame.getContentPane().add(lblRestServer);
		
		JLabel lblZipcode = new JLabel("Zip code");
		lblZipcode.setBounds(207, 78, 66, 15);
		frame.getContentPane().add(lblZipcode);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(207, 118, 66, 15);
		frame.getContentPane().add(lblDegree);
		
		JButton btnAll = new JButton("All");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String restServer = tfRestServer.getText();
				String restURL = getRestURL(restServer);
				taMsg.setText(getData(restURL));
			}
		});
		btnAll.setBounds(12, 51, 147, 25);
		frame.getContentPane().add(btnAll);
		
		JButton btnCity = new JButton("City");
		btnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String restServer = tfRestServer.getText();
				String zip = tfZip.getText();
				String restURL = getRestURL(restServer, zip);
				taMsg.setText(getData(restURL));
			}
		});
		btnCity.setBounds(12, 88, 147, 25);
		frame.getContentPane().add(btnCity);
		
		JButton btnWarmerThan = new JButton("Warmer Than");
		btnWarmerThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String restServer = tfRestServer.getText();
				int degree = Integer.parseInt(tfDegree.getText());
				String restURL = getRestURL(restServer, degree);
				taMsg.setText(getData(restURL));
			}
		});
		btnWarmerThan.setBounds(12, 125, 147, 25);
		frame.getContentPane().add(btnWarmerThan);
		
		taMsg = new JTextArea();
		taMsg.setBounds(12, 175, 416, 86);
		frame.getContentPane().add(taMsg);
		
		tfRestServer = new JTextField();
		tfRestServer.setBounds(277, 49, 124, 19);
		frame.getContentPane().add(tfRestServer);
		tfRestServer.setColumns(10);
		
		tfZip = new JTextField();
		tfZip.setBounds(277, 78, 124, 19);
		frame.getContentPane().add(tfZip);
		tfZip.setColumns(10);
		
		tfDegree = new JTextField();
		tfDegree.setBounds(277, 116, 124, 19);
		frame.getContentPane().add(tfDegree);
		tfDegree.setColumns(10);
	}
}
