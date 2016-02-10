package sae.core.control;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.convert.Converter;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.controller.PersistentObjectConverterFromId;
import sae.core.domain.Administrador;
import sae.core.persistence.AdministradorDAO;


/**
 * Application-scoped bean that centralizes controller information for the core package. This bean differs from the
 * singleton EJB CoreInformacao by containing data relative to the presentation layer (controller and view, i.e., the
 * web).
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@ApplicationScoped
public class CoreControl  implements Serializable {

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(CoreControl.class.getCanonicalName());
	
	
	/** The DAO for Administrador objects. */
	@EJB    	
	private AdministradorDAO administradorDAO;
	
	
	/** JSF Converter for Administrador objects. */
	private PersistentObjectConverterFromId<Administrador> administradorConverter;
	

	
	
	
	
	/** Getter for AdministradorConverter */
	public Converter getAdministradorConverter() {
		// Lazily create the converter.
		if (administradorConverter == null) 
			logger.log(Level.FINEST, "Creating a administrador converter ....... ");
			administradorConverter = new PersistentObjectConverterFromId<Administrador>(administradorDAO);
		return administradorConverter;
	}
	
	
	
	
}