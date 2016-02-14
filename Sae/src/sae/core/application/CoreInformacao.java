package sae.core.application;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.SaeConfiguracao;
import sae.core.persistence.SaeConfiguracaoDAO;



/**
 * Singleton bean that stores in memory information that is useful for the entire application, i.e., read-only
 * information shared by all users. This bean stores information for the core package.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Singleton
@Named("coreInfo")
public class CoreInformacao implements Serializable {

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(CoreInformacao.class.getCanonicalName());

	
	/** The DAO for SaeConfiguracao objects. */
	@EJB
	private SaeConfiguracaoDAO saeConfiguracaoDAO;
	
	
	/** The system configuration objects */
	private SaeConfiguracao currentConfig;
	
	/** The default password of administrator */
	private static final String DEFAULT_SENHA_ADMIN = "adm123";
	
	
	/** Indicates if the system is properly installed. */
	private Boolean systemInstalled;

	
	
	
	
	/** Getter for SaeConfiguracao. */
	public SaeConfiguracao getCurrentConfig() { return currentConfig; }

	
	
	/** Getter for systemInstalled. */
	public Boolean getSystemInstalled() {
		if (systemInstalled == null|| systemInstalled == false) {
			logger.log(Level.FINER, "Checking if the system has been installed...");
			try {
				currentConfig = saeConfiguracaoDAO.retrieveCurrentConfiguration();
				systemInstalled = true;
			}
			catch (PersistentObjectNotFoundException e) {
				systemInstalled = false;
			}
		}
		return systemInstalled;
	}
	
	

	/** Getter for DefaultSenhaAdmin. */
	public String getDefaultSenhaAdmin() {
		return DEFAULT_SENHA_ADMIN;
	}
	
	
}
