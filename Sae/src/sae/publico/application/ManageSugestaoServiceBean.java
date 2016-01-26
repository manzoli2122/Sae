package sae.publico.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.publico.domain.Sugestao;
import sae.publico.persistence.SugestaoDAO;

@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageSugestaoServiceBean extends CrudServiceBean<Sugestao> implements ManageSugestaoService{

	private static final long serialVersionUID = 1L;

	@EJB
	private SugestaoDAO sugestaoDAO;
	
	@Override
	public BaseDAO<Sugestao> getDAO() {
		return sugestaoDAO;
	}

	@Override
	protected Sugestao createNewEntity() {
		return new Sugestao();
	}

}
