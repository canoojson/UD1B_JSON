import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ej_Productos {
	public static void main(String[] args) {
		JSONArray jsonArrayPd, jsonArrayCat  = null;
		JSONParser parser = new JSONParser();
		JSONObject jsobj, jobj = null;
		try {
			jsonArrayPd = (JSONArray) parser.parse(new FileReader("ficheros/Productos.json"));
			for (int i = 0; i < jsonArrayPd.size(); i++) {
				jsobj = (JSONObject) jsonArrayPd.get(i);
				System.out.println("Nombre del producto: " + jsobj.get("nombre_producto"));
				if(jsobj.get("tipo_producto").equals("Ropa")) {
					System.out.println("Precio: " + jsobj.get("precio") + "€");
				}
				if(jsobj.get("nombre_producto").equals("Pantalones Levi's 501")) {
					 jsonArrayCat = (JSONArray) jsobj.get("categorias");
					 System.out.println("Categorias: ");
					 for (int j = 0; j < jsonArrayCat.size(); j++) {
						System.out.println(jsonArrayCat.get(j));
					}
					 System.out.println("Stock: " + jsobj.get("stock").toString());
					 jobj = (JSONObject) jsobj.get("ubicacion");
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
