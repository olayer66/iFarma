package es.ucm.fdi.parser;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.ucm.fdi.iw.model.Medicamento;


public class parserMedicamentos {
	
	public parserMedicamentos(String fichero,EntityManager manager)
	{
		if(!fichero.equals(""))
		{
			try {
				manager.getTransaction().begin();
				cargar(fichero);
				manager.getTransaction().commit();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void cargar(String fichero, EntityManager em) throws FileNotFoundException
	{
		Long idMedicmaneto;
		String nombre; 
		String descripcion;
		String laboratorio;
		double precio;
		String jsonStr = new String(Files.readAllBytes(Paths.get(fichero)), "UTF-8");
		try {
            JSONObject rootObject = new JSONObject(jsonStr); // Parse the JSON to a JSONObject
            JSONArray rows = rootObject.getJSONArray("rows"); // Get all JSONArray rows
            
            for(int i=0; i < rows.length(); i++) { // Loop over each each row
                Medicamento medicamento=new Medicamento();
                //medicamento.s
                JSONObject row = rows.getJSONObject(i); // Get row object
                idMedicmaneto=row.getLong("id");
                nombre= row.getString("nombre");
                descripcion=row.getString("descripcion");
                laboratorio=row.getString("laboratorio");
                precio=Double.parseDouble(row.getString("precio"));
                em.persist(arg0);
                
            }
        } catch (JSONException e) {
            // JSON Parsing error
            e.printStackTrace();
        }
	}
	

}
