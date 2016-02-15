package sae.publico.application;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.core.application.SessionService;
import sae.core.domain.Egresso;
import sae.publico.domain.Escolaridade;
import sae.publico.persistence.EscolaridadeDAO;



/**
 * Stateless session bean implementing the "Manage Escolaridade" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.core.application.ManageAdministradorService
 */
@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageEscolaridadeServiceBean extends CrudServiceBean<Escolaridade> implements ManageEscolaridadeService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageEscolaridadeServiceBean.class.getCanonicalName());
	

	/** The DAO for Escolaridade objects. */
	@EJB
	private EscolaridadeDAO escolaridadeDAO;
	
	
	@EJB
	private SessionService sessionService;

	
	
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Escolaridade> getDAO() {
		return escolaridadeDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Escolaridade createNewEntity() {
		return new Escolaridade();
	}
	
	
	
	/** @see sae.core.application.CrudServiceBean#validateCreate(br.ufes.inf.nemo.util.ejb3.persistence.PersistentObject) */
	@Override
	public void validateCreate(Escolaridade entity) throws CrudException {
		Egresso egresso = sessionService.getEgresso();
		if(egresso != null)
			logger.log(Level.INFO, "egresso = {0} " , egresso.getNome());
		else logger.log(Level.INFO, "EGRESSO NULO");
		entity.setEgresso(egresso);
		
	}
	
	
	
	
	@Override
	public List<Escolaridade>	retrieveAllMine() {
		return escolaridadeDAO.retrieveAllMine(sessionService.getEgresso());
	}
	
	
}
