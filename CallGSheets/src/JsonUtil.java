import java.io.BufferedReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtil {
	public static ArrayList<String> parseJSONData(BufferedReader bufferedReader) {
		ArrayList<String> resultSet = new ArrayList<String>();
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(bufferedReader);
			JSONArray jsonArray = (JSONArray)jsonObject.get("values");
			
			for (int i = 0; i<jsonArray.size(); i++) {
				String sRecord = jsonArray.get(i).toString();
				sRecord = sRecord.replace("[", "").replace("]", "");
				sRecord = sRecord.replace("\"", "'");					
				resultSet.add(sRecord);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
