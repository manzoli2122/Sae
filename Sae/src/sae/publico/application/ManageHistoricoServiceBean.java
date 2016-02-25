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
import sae.publico.domain.HistoricoEgresso;
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
public class ManageHistoricoServiceBean extends CrudServiceBean<HistoricoEgresso> implements ManageHistoricoService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	
	/** The DAO for Historico_Egresso objects. */
	@EJB
	private Historico_EgressoDAO historico_EgressoDAO;
	
	
	@EJB
	private SessionService sessionService;
	
	
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<HistoricoEgresso> getDAO() {
		return historico_EgressoDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected HistoricoEgresso createNewEntity() {
		return new HistoricoEgresso();
	}

	
	
	/** @see sae.core.application.CrudServiceBean#validateCreate(br.ufes.inf.nemo.util.ejb3.persistence.PersistentObject) */
	@Override
	public void validateCreate(HistoricoEgresso entity) throws CrudException {
		Egresso egresso = sessionService.getEgresso();
		if(egresso != null)
		entity.setEgresso(egresso);
		
	}
	
	
	
	
	@Override
	public List<HistoricoEgresso>	retrieveAllMine() {
		return historico_EgressoDAO.retrieveAllMine(sessionService.getEgresso());
	}
}
