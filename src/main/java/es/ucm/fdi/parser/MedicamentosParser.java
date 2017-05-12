package es.ucm.fdi.parser;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import es.ucm.fdi.iw.model.Medicamento;


public class MedicamentosParser {
	
	public MedicamentosParser(String fichero,EntityManager manager)
	{
/*		if(!fichero.equals(""))
		{
			try {
				cargar(fichero, manager);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void cargar(String fichero, EntityManager em) throws FileNotFoundException
	{
		em.getTransaction().begin();
		String jsonStr;
		try {
			Medicamento medicamento=new Medicamento();
			jsonStr = new String(Files.readAllBytes(Paths.get(fichero)), "UTF-8");
		
            JSONObject rootObject = new JSONObject(jsonStr); // Parse the JSON to a JSONObject
            JSONArray rows = rootObject.getJSONArray("rows"); // Get all JSONArray rows
            
            for(int i=0; i < rows.length(); i++) { // Loop over each each row
                //medicamento.s
                JSONObject row = rows.getJSONObject(i); // Get row object
                medicamento.setIDMedicamento(row.getLong("id"));
                medicamento.setNombre(row.getString("nombre"));
                medicamento.setDescripcion(row.getString("descripcion"));
                medicamento.setLaboratorio(row.getString("laboratorio"));
                medicamento.setPrecio(Double.parseDouble(row.getString("precio")));
               em.persist(medicamento);
                
            }
			em.getTransaction().commit();
        } catch (Exception e) {
            // JSON Parsing error
            e.printStackTrace();
        }
*/	}
	

}
