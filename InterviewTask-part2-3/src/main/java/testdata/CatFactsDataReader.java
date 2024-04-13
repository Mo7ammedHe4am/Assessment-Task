package testdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CatFactsDataReader {

    public String url, endpoint;

    public void readJsonData() throws IOException, org.json.simple.parser.ParseException {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\CatFactsApi.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            url = (String) person.get("url");
            endpoint = (String) person.get("endpoint");
        }
    }
}
