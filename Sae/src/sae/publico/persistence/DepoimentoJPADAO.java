package sae.publico.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.publico.domain.Depoimento;

@Stateless
public class DepoimentoJPADAO extends BaseJPADAO<Depoimento> implements DepoimentoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	
	
	@Override
	public Class<Depoimento> getDomainClass() {
		return Depoimento.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
