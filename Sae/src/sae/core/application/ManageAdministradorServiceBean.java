package sae.core.application;


import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.controller.PersistentObjectConverterFromId;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Administrador;
import sae.core.persistence.AdministradorDAO;


@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "Admin" })
public class ManageAdministradorServiceBean extends CrudServiceBean<Administrador> implements ManageAdministradorService{

	
	private static final long serialVersionUID = 1L;
	
	@EJB    	
	private AdministradorDAO administradorDAO;
	
	private PersistentObjectConverterFromId<Administrador> administradorConverter;
	
	
	
	@Override
	public BaseDAO<Administrador> getDAO() {
		return administradorDAO;
	}

	@Override
	protected Administrador createNewEntity() {
		return new Administrador();
	}
	
	@Override
	public Converter getAdministradorConverter() {
		if (administradorConverter == null) 
			administradorConverter = new PersistentObjectConverterFromId<Administrador>(administradorDAO);
		return administradorConverter;
	}
	
	@Override
	public void validateCreate(Administrador entity) throws CrudException {
		entity.setSenha("123");
		
	}
	
	@PermitAll
	@Override
	public void create(Administrador entity) {
		// TODO Auto-generated method stub
		super.create(entity);
	}
	
	
	
}
