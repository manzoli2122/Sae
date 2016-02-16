package sae.publico.application;

import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.core.application.SessionService;
import sae.core.domain.Egresso;
import sae.publico.domain.Historico_Egresso;
import sae.publico.persistence.Historico_EgressoDAO;



/**
 * Stateless session bean implementing the "Manage Historico" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.publico.application.ManageHistoricoService
 */
@Stateless
@DeclareRoles({"Admin", "egresso", "guest"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageHistoricoServiceBean extends CrudServiceBean<Historico_Egresso> implements ManageHistoricoService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	
	/** The DAO for Historico_Egresso objects. */
	@EJB
	private Historico_EgressoDAO historico_EgressoDAO;
	
	
	@EJB
	private SessionService sessionService;
	
	
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Historico_Egresso> getDAO() {
		return historico_EgressoDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Historico_Egresso createNewEntity() {
		return new Historico_Egresso();
	}

	
	
	/** @see sae.core.application.CrudServiceBean#validateCreate(br.ufes.inf.nemo.util.ejb3.persistence.PersistentObject) */
	@Override
	public void validateCreate(Historico_Egresso entity) throws CrudException {
		Egresso egresso = sessionService.getEgresso();
		if(egresso != null)
		entity.setEgresso(egresso);
		
	}
	
	
	
	
	@Override
	public List<Historico_Egresso>	retrieveAllMine() {
		return historico_EgressoDAO.retrieveAllMine(sessionService.getEgresso());
	}
}
