package sae.publico.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.publico.domain.Depoimento;
import sae.publico.persistence.DepoimentoDAO;

@Stateless
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
