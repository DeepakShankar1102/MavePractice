package ApplicationTest;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJSON {
public  JSONObject JSONparse() throws IOException, ParseException {
		
		
		JSONParser JsonParser=new JSONParser();
		
		FileReader Reader=new FileReader("properties.json");
		
		Object ParsedObject= JsonParser.parse(Reader);
		
		JSONObject JsonObj=(JSONObject)ParsedObject;
		
		return JsonObj;
	}

}
