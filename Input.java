import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    public Object readFile(String jsonPath) {
        JSONParser parser = new JSONParser();
        Object terrain = null;
        try {
            FileReader reader = new FileReader(jsonPath);
            terrain = parser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException parse) {
            parse.getErrorType();
        }
        return terrain;
    }
}
