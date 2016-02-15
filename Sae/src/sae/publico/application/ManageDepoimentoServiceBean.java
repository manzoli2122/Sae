package sae.publico.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.publico.domain.Depoimento;
import sae.publico.persistence.DepoimentoDAO;




/**
 * Stateless session bean implementing the "Manage Depoimento" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.publico.application.ManageDepoimentoService
 */
@Stateless
@DeclareRoles({"Admin", "egresso", "guest"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageDepoimentoServiceBean extends CrudServiceBean<Depoimento> implements ManageDepoimentoService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	
	/** The DAO for Depoimento objects. */
	@EJB
	private DepoimentoDAO depoimentoDAO;
	
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Depoimento> getDAO() {
		return depoimentoDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Depoimento createNewEntity() {
		return new Depoimento();
	}

}
