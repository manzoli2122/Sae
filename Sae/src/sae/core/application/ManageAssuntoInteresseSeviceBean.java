package sae.core.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.AssuntoInteresse;
import sae.core.persistence.Assunto_InteresseDAO;



/**
 * Stateless session bean implementing the "Manage Assunto_Interesse" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.core.application.ManageAdministradorService
 */
@Stateless
@DeclareRoles({"Admin", "egresso", "guest"})
@RolesAllowed({ "Admin" })
public class ManageAssuntoInteresseSeviceBean  extends CrudServiceBean<AssuntoInteresse> implements ManageAssuntoInteresseSevice{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The DAO for Assunto_Interesse objects. */
	@EJB
	private Assunto_InteresseDAO assunto_InteresserDAO;
	
	
	
	
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<AssuntoInteresse> getDAO() {
		return assunto_InteresserDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected AssuntoInteresse createNewEntity() {
		return new AssuntoInteresse();
	}

}
