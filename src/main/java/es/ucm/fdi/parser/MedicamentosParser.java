package es.ucm.fdi.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import es.ucm.fdi.iw.model.Medicamento;

public class MedicamentosParser {
	private static final Logger log = Logger.getLogger(MedicamentosParser.class);	
	
	public static void carga(File fichero, EntityManager em) throws IOException {
		try {
			String json = new String(Files.readAllBytes(fichero.toPath()));			
			log.info("Cadena cargada");
			
			ObjectMapper mapper = new ObjectMapper();
			Medicamento[] ms = mapper.readValue(json, Medicamento[].class);
			log.info("JSON valido: tengo " + ms.length + " medicamentos!");
			
            for (Medicamento m : ms) {                 
                log.info("Persisto");
                m.setId(0);
                em.persist(m);
            }
        } catch (Exception e) {
        	throw new IOException(e.getMessage(), e);
        }
	}
	

}
