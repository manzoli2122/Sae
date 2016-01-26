package sae.publico.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.publico.domain.Depoimento;
import sae.publico.persistence.DepoimentoDAO;

@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageDepoimentoServiceBean extends CrudServiceBean<Depoimento> implements ManageDepoimentoService{

	private static final long serialVersionUID = 1L;

	@EJB
	private DepoimentoDAO depoimentoDAO;
	
	
	@Override
	public BaseDAO<Depoimento> getDAO() {
		return depoimentoDAO;
	}

	@Override
	protected Depoimento createNewEntity() {
		return new Depoimento();
	}

}
