package sae.publico.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import sae.publico.domain.Sugestao;

@Stateless
public class SugestaoJPADAO extends BaseJPADAO<Sugestao> implements SugestaoDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="Sae")
	private EntityManager entityManager;

	@Override
	public Class<Sugestao> getDomainClass() {
		return Sugestao.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
