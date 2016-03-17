package sae.core.application;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.core.domain.Administrador;
import sae.core.domain.SaeConfiguracao;
import sae.core.persistence.AdministradorDAO;
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
	
	
	/** The DAO for Administrador objects. */
	@EJB    	
	private AdministradorDAO administradorDAO;
	
	
	/** The information singleton for the core module. */
	@EJB    	
	private CoreInformacao coreInformacao;
	
	
	
	@Override
	public void saveAdmin(Administrador entity){
		entity.setSenha(coreInformacao.getDefaultSenhaAdmin());
		administradorDAO.save(entity);
	}
	
	
	
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
