import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CallSheetsAPI {
	public static void main(String[] args) {
		try {
			StringBuilder sUrlString = new StringBuilder();
			sUrlString.append("https://sheets.googleapis.com/v4/spreadsheets/") // API URL
			.append("11BCnspCt2Mut3nhc4WMY6CYTd0zF9C3eCzsk1AEpKLM") // シートID
			.append("/values/")
			.append("sales!A1:E6") // 範囲
			.append("?key=") // API Key パラメータ名
			// APIキーに置き換えてください。
			.append("ここにAPIキーを書いてください"); // API Key
			
			URL oUrl = new URL(sUrlString.toString());
			HttpURLConnection con = (HttpURLConnection) oUrl.openConnection();
			con.setRequestMethod("GET");

			BufferedReader bufferedReader = null;
			ArrayList<String> resultSet = new ArrayList<String>();

			bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			// JSONデータのパーズ
			resultSet = JsonUtil.parseJSONData(bufferedReader);

			for (String str: resultSet) {
				System.out.println(str);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}