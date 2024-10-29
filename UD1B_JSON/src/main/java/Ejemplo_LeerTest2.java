import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ejemplo_LeerTest2 {
	public static void main(String[] args) {
		JSONArray jsonArrayPg, jsonArrayRs = null;
		JSONParser parser = new JSONParser();
		JSONObject jsobj = null;
		try {
			JSONObject jobj = (JSONObject) parser.parse(new FileReader("ficheros/test2.json"));
			System.out.println(jobj.get("id"));
			System.out.println("clase: " + jobj.get("pages").getClass().getName());
			jsonArrayPg = (JSONArray) (jobj.get("pages"));
			for (int i = 0; i < jsonArrayPg.size(); i++) {
				jsobj = (JSONObject) jsonArrayPg.get(i);
				System.out.println("url: " + jsobj.get("pageUrl"));
				if(jsobj.get("pageUrl").equals("http://www.example0.com")) {
					jsonArrayRs = (JSONArray) jsobj.get("results");
					for (int j = 0; j < jsonArrayRs.size(); j++) {
						jsobj = (JSONObject) jsonArrayRs.get(j);
						System.out.println("Numero: " + jsobj.get("number"));
					}
				}
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
