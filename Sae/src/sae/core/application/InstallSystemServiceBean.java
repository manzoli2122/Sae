package sae.core.application;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sae.core.domain.SaeConfiguracao;
import sae.core.persistence.SaeConfiguracaoDAO;

@Stateless
public class InstallSystemServiceBean implements InstallSystemService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(InstallSystemServiceBean.class.getCanonicalName());

	
	/** The DAO for SaeConfiguracao objects. */
	@EJB
	private SaeConfiguracaoDAO saeConfiguracaoDAO;
	
	
	
	
	
	
	@Override
	public void installSystem( SaeConfiguracao config) throws Exception {
		logger.log(Level.INFO, "INSTALANDO O SISTEMA ... ");
		try {
			Date now = new Date(System.currentTimeMillis());
			config.setCreationDate(now);
			saeConfiguracaoDAO.save(config);
			logger.log(Level.INFO, " CONFIGUARAÇÃO SALVA ");
		}
		catch (Exception e) {
			logger.log(Level.INFO, "EXCEÇÃO DURANTE A INSTALAÇÃO DO SISTEMA ");
			throw new Exception(e);
		}
	}

}
