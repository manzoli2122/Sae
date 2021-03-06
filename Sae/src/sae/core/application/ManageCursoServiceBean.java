package sae.core.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Curso;
import sae.core.persistence.CursoDAO;



/**
 * Stateless session bean implementing the "Manage Curso" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.core.application.ManageAdministradorService
 */
@Stateless
@DeclareRoles({"Admin", "egresso" , "guest"})
@RolesAllowed({ "Admin" })
public class ManageCursoServiceBean extends CrudServiceBean<Curso> implements ManageCursoService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The DAO for Curso objects. */
	@EJB
	private CursoDAO cursoDAO;

	
	
	
	@Override
	public void authorize() {
		super.authorize();
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Curso> getDAO() {
		return cursoDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Curso createNewEntity() {
		return new Curso();
	}
	
	
	
	/** @see sae.core.application.CrudServiceBean#update(Curso entity) */
	@Override
	public void update(Curso entity) {
		Curso oldEntity = getDAO().retrieveById(entity.getId());
		if ( oldEntity.getNome().equals(entity.getNome()) &&  oldEntity.getCodigo().equals(entity.getCodigo())){
			super.update(entity);
		}
	}

}
