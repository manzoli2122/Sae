package sae.publico.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.publico.domain.Sugestao;
import sae.publico.persistence.SugestaoDAO;




/**
 * Stateless session bean implementing the "Manage Sugestao" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.publico.application.ManageSugestaoService
 */
@Stateless
@DeclareRoles({"Admin", "egresso", "guest"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageSugestaoServiceBean extends CrudServiceBean<Sugestao> implements ManageSugestaoService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	
	/** The DAO for Sugestao objects. */
	@EJB
	private SugestaoDAO sugestaoDAO;
	

	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Sugestao> getDAO() {
		return sugestaoDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Sugestao createNewEntity() {
		return new Sugestao();
	}

}
