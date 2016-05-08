package org.fundacionjala.automation.framework.utils.api.managers;

import java.util.ArrayList;
import java.util.List;

import org.fundacionjala.automation.framework.utils.api.objects.admin.Room;
import org.fundacionjala.automation.framework.utils.common.LogManager;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RoomAPIManager {
	public static List<Room> getRequest(String endPoint) throws UnirestException{
		HttpResponse<JsonNode> jsonResponse = APIManager.request(endPoint, "get");
		LogManager.info("GET Response:" + jsonResponse.getStatusText());
		JSONArray a = jsonResponse.getBody().getArray();
		List<Room> roomsList = new ArrayList<Room>();
		if (jsonResponse.getStatusText().equals("OK"))
		{
			for (int i = 0; i < a.length() ; i++) {
				JSONObject obj = (JSONObject) a.get(i);
				roomsList.add(new Room(obj));
			}
		}
		return roomsList;
	}
}