package testdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public String username, password , searchdata;

    public void jsonReader() throws IOException, org.json.simple.parser.ParseException {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\UserData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            username = (String) person.get("username");
            password = (String) person.get("password");
            searchdata = (String) person.get("searchdata");        }
    }
}
