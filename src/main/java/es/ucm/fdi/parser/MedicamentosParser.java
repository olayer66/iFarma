package es.ucm.fdi.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.iw.model.Medicamento;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Repository
public class MedicamentosParser {
	private static final Logger log = Logger.getLogger(MedicamentosParser.class);
	private EntityManager em;
	public MedicamentosParser(String fichero)
	{
		
		if(!fichero.equals(""))
		{
			try {
				cargar(fichero);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void cargar(String fichero) throws IOException
	{
		JSONParser parser = new JSONParser();
		Medicamento medicamento=new Medicamento();
		try {
			log.info("Paso aqui");
			JSONArray a = (JSONArray) parser.parse(new String(Files.readAllBytes(Paths.get(fichero))));
            for(Object o : a) { // Loop over each each row
            	JSONObject row = (JSONObject) o;
                medicamento.setNombre((String) row.get("nombre"));
                medicamento.setDescripcion((String) row.get("descripcion"));
                medicamento.setLaboratorio((String) row.get("laboratorio"));
                medicamento.setPrecio(Double.parseDouble((String) row.get("precio")));
                log.info("Persisto");
                em.persist(medicamento);     
            }
        } catch (ParseException e) {
        	throw new IOException(e.getMessage());
        }
	}
	

}
