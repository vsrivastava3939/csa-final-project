import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://customsearch.googleapis.com/customsearch/v1?key=AIzaSyAsffaeboZzdHuuEXZC0ppifH2s1gzAfFE");
			URLConnection connection = url.openConnection();

			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			JSONObject json = new JSONObject(builder.toString());
			String imageUrl = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(0)
					.getString("url");
			System.out.println(imageUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
