import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ejemplo_LeerTest {
	public static void main(String[] args) throws IOException, ParseException {
		try {
			JSONArray msgs = null;
			String v_msg = null;
			String v_name = null;
			JSONParser parser = new JSONParser();
			//Object obj = parser.parse(new FileReader("ficheros/test.json"));
			//JSONObject jsonObject=(JSONObject) obj;
			JSONObject obj =(JSONObject)parser.parse(new FileReader("ficheros/test.json"));
			v_name = (String) obj.get("name");
			System.out.println("nombre: " + obj.get("name"));
			System.out.println("edad: "+obj.get("age"));
			
			msgs = (JSONArray) obj.get("messages");
			Iterator<String> iterator=msgs.iterator();
			
			while(iterator.hasNext()) {
				v_msg=iterator.next();
				if(!v_msg.equals("msg 2")) {
					System.out.println(v_msg);
				}
			}
			
			if(v_name.equals("mkyong2.com")) {
				msgs = (JSONArray) obj.get("messages");
				ArrayList<String>iterator2=(ArrayList<String>) msgs.iterator();
				System.out.println(msgs.size());
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
