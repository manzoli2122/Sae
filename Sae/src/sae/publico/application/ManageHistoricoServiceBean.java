package sae.publico.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
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

}
