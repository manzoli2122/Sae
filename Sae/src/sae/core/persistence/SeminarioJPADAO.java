package sae.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.core.domain.Seminario;

@Stateless
public class SeminarioJPADAO extends BaseJPADAO<Seminario> implements SeminarioDAO{

	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;
	
	@Override
	public Class<Seminario> getDomainClass() {
		return Seminario.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
