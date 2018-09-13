import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CallSheetsAPI {
	public static void main(String[] args) {
		try {
			String sAPIKey = "APIKey";
			
			StringBuilder sUrlString = new StringBuilder();
			sUrlString.append("https://sheets.googleapis.com/v4/spreadsheets/") // API URL
			.append("11BCnspCt2Mut3nhc4WMY6CYTd0zF9C3eCzsk1AEpKLM") // シートID
			.append("/values/")
			.append("sales!A1:E6") // 範囲
			.append("?key=") // API Key パラメータ名
			// APIキーに置き換えてください。
			.append(sAPIKey); // API Key
			
			URL oUrl = new URL(sUrlString.toString());
			HttpURLConnection con = (HttpURLConnection) oUrl.openConnection();
			con.setRequestMethod("GET");

			BufferedReader bufferedReader = null;
			ArrayList<String> lResultSet = new ArrayList<String>();

			bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			// JSONデータのパーズ
			lResultSet = JsonUtil.parseJSONData(bufferedReader);

			for (String sStr: lResultSet) {
				System.out.println(sStr);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}