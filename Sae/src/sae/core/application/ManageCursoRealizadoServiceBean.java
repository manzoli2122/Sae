package sae.core.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.CursoRealizado;
import sae.core.persistence.CursoRealizadoDAO;




@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "Admin" })
public class ManageCursoRealizadoServiceBean extends CrudServiceBean<CursoRealizado> implements ManageCursoRealizadoService{

	
	
	private static final long serialVersionUID = 1L;
	
	@EJB    	
	private CursoRealizadoDAO cursoRealizadoDAO;
	
	
	
	@Override
	public BaseDAO<CursoRealizado> getDAO() {
		return cursoRealizadoDAO;
	}

	@Override
	protected CursoRealizado createNewEntity() {
		return new CursoRealizado();
	}

}
