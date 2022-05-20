package com.csap3;

import java.net.http.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.*;

/**
 * The type Api handler.
 *
 * @author Tejas Prabhune, Vaibhav Srivastava
 */
public final class APIHandler {

	/**
	 * Make player array list.
	 *
	 * @param name the name
	 * @param year the year
	 * @return the array list
	 */
	public static ArrayList<EntityInfo> makePlayer(String name, int year) {
		name = replaceSpaces(name);

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.balldontlie.io/api/v1/players?per_page=100&search=" + name))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String resBody = response.body();
			ArrayList<EntityInfo> playerList = getEntityResponse(resBody, "Player");
			ArrayList<EntityInfo> result = new ArrayList<EntityInfo>();
			result.add(playerList.get(0));
			result.add(getStats(playerList.get(0), year));
			return result;

		} catch (Exception e) {
			System.out.println("Player not found!");
		}
		return null;

	}

	/**
	 * Make team array list.
	 *
	 * @param name the name
	 * @param year the year
	 * @return the array list
	 */
	public static ArrayList<EntityInfo> makeTeam(String name, int year) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.balldontlie.io/api/v1/teams"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String resBody = response.body();
			ArrayList<EntityInfo> teamList = getEntityResponse(resBody, "Team");
			ArrayList<EntityInfo> result = new ArrayList<EntityInfo>();
			for (EntityInfo entity : teamList) {
				Team team = (Team) entity;
				if (name.toLowerCase().indexOf(team.getName().toLowerCase()) >= 0) {
					result.add(team);
					result.add(getTeamStats(team, year));
				}
			}
			return result;

		} catch (Exception e) {
		}
		return null;

	}

	/**
	 * Gets stats.
	 *
	 * @param entityInfo the entity info
	 * @param year       the year
	 * @return the stats
	 */
	public static PlayerStats getStats(EntityInfo entityInfo, int year) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.balldontlie.io/api/v1/season_averages?player_ids[]="
						+ ((Player) entityInfo).getId() + "&season=" + year))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String resBody = response.body();
			ArrayList<String> parsed = new ArrayList<String>();
			parsed.add("{".concat(getInnerBracketInfo(resBody)).concat("}"));
			HashMap<String, Object> map = formatResponse(parsed);
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			PlayerStats playerStats = mapper.convertValue(map, PlayerStats.class);
			return playerStats;

		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Gets team stats.
	 *
	 * @param team the team
	 * @param year the year
	 * @return the team stats
	 */
	public static TeamStats getTeamStats(Team team, int year) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.balldontlie.io/api/v1/games?per_page=100&seasons[]=" + year
						+ "&postseason=false&team_ids[]=" + team.getId()))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String resBody = response.body();
			scores = getTeamScores(resBody, team);
		} catch (Exception e) {

		}
		TeamStats teamStats = new TeamStats();
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}

		teamStats.setPts(sum / scores.size());
		teamStats.setHighPts(mostPtsScored(scores));
		return teamStats;
	}

	/**
	 * Uses Bubble Sort to find the highest points scored in a season.
	 * @param scoreList List of scores
	 * @return Highest points by a team in a season
	 */
	public static int mostPtsScored(ArrayList<Integer> scoreList) {
		for (int i = 0; i < scoreList.size() - 1; i++) {
			for (int j = 1; j < scoreList.size() - i; j++) {
				if (scoreList.get(j - 1) > scoreList.get(j)) {
					int temp = scoreList.get(j - 1);
					scoreList.set(j - 1, scoreList.get(j));
					scoreList.set(j, temp);
				}
			}
		}

		return scoreList.get(scoreList.size() - 1);
	}

	/**
	 * Creates an ArrayList of all the game scores in a season by a team.
	 * @param resBody API response
	 * @param team Team to find information of
	 * @return All game scores in ArrayList
	 */
	public static ArrayList<Integer> getTeamScores(String resBody, Team team) {
		ArrayList<Integer> scores = new ArrayList<Integer>();

		do {
			resBody = resBody.substring(resBody.indexOf(team.getName() + "\"}") + team.getName().length() + 2);
			String score = (resBody.substring(resBody.indexOf(":") + 1, resBody.indexOf("}")));
			if (score.indexOf(",") >= 0) {
				score = score.substring(0, score.indexOf(","));
			}
			scores.add(Integer.valueOf(score));
		} while (resBody.indexOf(",{\"id") >= 0);

		return scores;
	}
	
	/**
	 * Parse player response array list.
	 *
	 * @param resBody the res body
	 * @return the array list
	 */
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
	 * Gets entity response.
	 *
	 * @param resBody    the res body
	 * @param entityName the entity name
	 * @return the entity response
	 */
	public static ArrayList<EntityInfo> getEntityResponse(String resBody, String entityName) {
		ArrayList<ArrayList<String>> entityList = new ArrayList<ArrayList<String>>();
		ArrayList<EntityInfo> entities = new ArrayList<EntityInfo>();
		do {
			if (entityName.equals("Player"))
				entityList.add(parsePlayerResponse(resBody));
			else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add("{".concat(getInnerBracketInfo(resBody)).concat("}"));
				entityList.add(temp);
			}
			resBody = "{".concat(resBody.substring(resBody.indexOf(",{") + 1)).concat("}");
		} while (resBody.indexOf(",{") >= 0);

		for (ArrayList<String> entityJSON : entityList) {
			HashMap<String, Object> map = formatResponse(entityJSON);
			ObjectMapper mapper = new ObjectMapper();
			if (entityName.equals("Player")) {
				Player player = mapper.convertValue(map, Player.class);
				entities.add(player);
			} else if (entityName.equals("Team")) {
				Team team = mapper.convertValue(map, Team.class);
				entities.add(team);
			}
		}

		return entities;
	}

	/**
	 * Gets team info for player response, all JSON data for stats response
	 *
	 * @param resBody the res body
	 * @return inner bracket info
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

	/**
	 * Format response hash map.
	 *
	 * @param response the response
	 * @return the hash map
	 */
	public static HashMap<String, Object> formatResponse(ArrayList<String> response) {

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < response.size(); i++) {
			String resData = response.get(i);
			try {
				map.putAll(mapper.readValue(resData, new TypeReference<HashMap<String, Object>>() {
				}));
			} catch (Exception e) {
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

		if (response.size() > 1) {
			Object teamNameValue = map.get("name");
			map.remove("name");
			map.put("teamName", teamNameValue);
		}

		return map;
	}

	/**
	 * Replace spaces string.
	 *
	 * @param title the title
	 * @return the string
	 */
	public static String replaceSpaces(String title) {
		if (title.indexOf(" ") < 0) {
			return title;
		} else {
			return title.substring(0, title.indexOf(" ")) + "+"
					+ replaceSpaces(title.substring(title.indexOf(" ") + 1));
		}
	}

	/**
	 * Gets image.
	 *
	 * @param name   the name
	 * @param isTeam the is team
	 * @return the image
	 */
	public static String getImage(String name, boolean isTeam) {
		if (isTeam) {
			try {
				HttpRequest imageReq = HttpRequest.newBuilder().uri(URI.create(
						"https://en.wikipedia.org/w/api.php?action=query&prop=pageimages&piprop=original&titles=" + name
								+ "&format=json"))
						.method("GET", HttpRequest.BodyPublishers.noBody()).build();
				HttpResponse<String> imageResp = HttpClient.newHttpClient().send(imageReq,
						HttpResponse.BodyHandlers.ofString());
				return getJPGString(imageResp.body());
			} catch (Exception e) {
			}
			return null;
		} else {
			name = APIHandler.replaceSpaces(name);
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://en.wikipedia.org/w/api.php?action=opensearch&search=" + name
							+ "&limit=1&namespace=0&format=json"))
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			try {
				HttpResponse<String> response = HttpClient.newHttpClient().send(request,
						HttpResponse.BodyHandlers.ofString());
				String resp = response.body();
				String wikiTitle = resp.substring(resp.indexOf(",[\"") + 3, resp.indexOf("\"]"));
				wikiTitle = APIHandler.replaceSpaces(wikiTitle);

				HttpRequest imageReq = HttpRequest.newBuilder().uri(URI.create(
						"https://en.wikipedia.org/w/api.php?action=query&prop=pageimages&piprop=original&titles="
								+ wikiTitle + "&format=json"))
						.method("GET", HttpRequest.BodyPublishers.noBody()).build();
				HttpResponse<String> imageResp = HttpClient.newHttpClient().send(imageReq,
						HttpResponse.BodyHandlers.ofString());
				return getJPGString(imageResp.body());
			} catch (Exception e) {
			}
			return null;
		}
	}

	/**
	 * Gets jpg string.
	 *
	 * @param resp the resp
	 * @return the jpg string
	 */
	public static String getJPGString(String resp) {
		if (resp != null)
			if (resp.indexOf(".jpg") >= 0)
				return resp.substring(resp.lastIndexOf("http"), resp.lastIndexOf(".jpg") + 4);
			else if (resp.indexOf(".svg") >= 0)
				return resp.substring(resp.lastIndexOf("http"), resp.lastIndexOf(".svg") + 4);
			else
				return "";
		else
			return "";
	}
}
