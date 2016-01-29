package sae.publico.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.publico.domain.Historico_Egresso;

@Stateless
public class Historico_EgressoJPADAO  extends BaseJPADAO<Historico_Egresso> implements Historico_EgressoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	@Override
	public Class<Historico_Egresso> getDomainClass() {
		return Historico_Egresso.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
