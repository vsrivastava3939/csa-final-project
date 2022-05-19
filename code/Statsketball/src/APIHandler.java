import java.net.http.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.*;

public final class APIHandler {

	public static Player makePlayer(int type, String name) {

		if (name.indexOf(" ") >= 0) {
			name = name.substring(0, name.indexOf(" "));
		}

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://free-nba.p.rapidapi.com/players?search=" + name + "&per_page=1&page=0"))
				.header("X-RapidAPI-Host", "free-nba.p.rapidapi.com")
				.header("X-RapidAPI-Key", "47c032da53mshd3c8594716c1b01p1fb01fjsnc1cb83b75c2e")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String resBody = response.body();
			ArrayList<String> parsed = parsePlayerResponse(resBody);
			HashMap<String, Object> map = formatResponse(parsed);
			ObjectMapper mapper = new ObjectMapper();
			Player player = mapper.convertValue(map, Player.class);
			return player;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static String getImageURL(String name) {
		// TODO: Implement Google Search API
		return "";
	}
	
	public static PlayerStats getStats(Player player, int year) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.balldontlie.io/api/v1/season_averages?player_ids[]=" + player.getId() + "&season=" + year))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String resBody = response.body();
			ArrayList<String> parsed = new ArrayList<String>();
			parsed.add("{".concat(getInnerBracketInfo(resBody)).concat("}"));
			System.out.println(parsed);
			HashMap<String, Object> map = formatResponse(parsed);
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(map);
			PlayerStats playerStats = mapper.convertValue(map, PlayerStats.class);
			return playerStats;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		getStats(makePlayer(0, "lebron"), 2018);
	}

	public static ArrayList<String> parsePlayerResponse(String resBody) {
		String teamInfo = getInnerBracketInfo(resBody);
		String playerInfo = resBody.substring(resBody.indexOf("{", 1) + 1, resBody.indexOf(teamInfo) - 9);

		ArrayList<String> response = new ArrayList<String>();
		response.add("{".concat(playerInfo).concat("}"));
		response.add(teamInfo);
		response.set(1, "{\"team_".concat(response.get(1).substring(1)).concat("}"));

		return response;
	}

	/**
	 * Gets team info for player response, all JSON data for stats response
	 * @param resBody
	 * @return
	 */
	public static String getInnerBracketInfo(String resBody) {
		if (resBody.indexOf("}") < 0) {
			if (resBody.indexOf("{") < 0) {
				return resBody;
			} else {
				return getInnerBracketInfo(resBody.substring(resBody.indexOf("{") + 1));
			}
		} else {
			return getInnerBracketInfo(resBody.substring(0, resBody.indexOf("}")));
		}

	}

	public static HashMap<String, Object> formatResponse(ArrayList<String> response) {

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < response.size(); i++) {
			String resData = response.get(i);
			System.out.println(resData);
			try {
				map.putAll(mapper.readValue(resData, new TypeReference<HashMap<String, Object>>() {
				}));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<String> it = map.keySet().iterator();
		HashMap<String, Object> formatMap = new HashMap<String, Object>();
		while (it.hasNext()) {
			String key = it.next();
			int underscoreIndex = key.indexOf("_");
			if (underscoreIndex >= 0) {
				Object value = map.get(key);
				String formatKey = key.substring(0, underscoreIndex)
						+ key.substring(underscoreIndex + 1, underscoreIndex + 2).toUpperCase()
						+ key.substring(underscoreIndex + 2);
				formatMap.put(formatKey, value);
				it.remove();
			}
		}

		map.putAll(formatMap);

		if(response.size() > 1) {
			Object teamNameValue = map.get("name");
			map.remove("name");
			map.put("teamName", teamNameValue);
		}

		return map;
	}
}
