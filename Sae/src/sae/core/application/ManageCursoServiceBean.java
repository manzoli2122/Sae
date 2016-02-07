package sae.core.application;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.controller.PersistentObjectConverterFromId;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Curso;
import sae.core.persistence.CursoDAO;


@Stateless
@DeclareRoles({"Admin", "egresso" , "guest"})
@RolesAllowed({ "Admin" })

//DefaultUnauthenticatedPrincipal
public class ManageCursoServiceBean extends CrudServiceBean<Curso> implements ManageCursoService{

	
	private static final long serialVersionUID = 1L;
	
	private PersistentObjectConverterFromId<Curso> cursoConverter;
	
	@EJB
	private CursoDAO cursoDAO;

	
	
	
	@Override
	@PermitAll
	public Converter getCursoConverter() {
		if (cursoConverter == null) 
			cursoConverter = new PersistentObjectConverterFromId<Curso>(cursoDAO);
		return cursoConverter;
	}
	
	@Override
	@PermitAll
	public long count() {
		return super.count();
	}
	
	
	@Override
	@PermitAll
	public List<Curso> list(int... interval) {
		return super.list(interval);
	}
	
	
	@Override
	public BaseDAO<Curso> getDAO() {
		return cursoDAO;
	}

	@Override
	protected Curso createNewEntity() {
		return new Curso();
	}
	
	@Override
	public void update(Curso entity) {
		Curso oldEntity = getDAO().retrieveById(entity.getId());
		if ( oldEntity.getNome().equals(entity.getNome()) &&  oldEntity.getCodigo().equals(entity.getCodigo())){
			super.update(entity);
		}
	}

	

	


}
