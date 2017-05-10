package es.ucm.fdi.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;



public class parserMedicamentos {
	
	public parserMedicamentos(String fichero)
	{
		if(!fichero.equals(""))
		{
			try {
				cargar(fichero);
			} catch (FileNotFoundException | ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void cargar(String fichero) throws FileNotFoundException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader(fichero));
		for (Object o : a)
		{
		    JSONObject person = (JSONObject) o;
		    String name = (String) person.get("name");
		    System.out.println(name);
		}
	}
	

}
