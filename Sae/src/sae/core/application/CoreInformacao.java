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


@Singleton
@Named("coreInfo")
public class CoreInformacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(CoreInformacao.class.getCanonicalName());

	@EJB
	private SaeConfiguracaoDAO saeConfiguracaoDAO;
	
	private SaeConfiguracao currentConfig;
	
	private Boolean systemInstalled;

	
	public SaeConfiguracao getCurrentConfig() { return currentConfig; }

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
	
	
}
