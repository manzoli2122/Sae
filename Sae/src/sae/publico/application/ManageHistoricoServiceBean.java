package sae.publico.application;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.application.CrudServiceBean;
import sae.publico.domain.Historico_Egresso;
import sae.publico.persistence.Historico_EgressoDAO;

@Stateless
@DeclareRoles({"Admin", "egresso"})
@RolesAllowed({ "egresso", "Admin" })
public class ManageHistoricoServiceBean extends CrudServiceBean<Historico_Egresso> implements ManageHistoricoService{

	private static final long serialVersionUID = 1L;

	@EJB
	private Historico_EgressoDAO historico_EgressoDAO;
	
	
	@Override
	public BaseDAO<Historico_Egresso> getDAO() {
		return historico_EgressoDAO;
	}

	@Override
	protected Historico_Egresso createNewEntity() {
		return new Historico_Egresso();
	}

}
